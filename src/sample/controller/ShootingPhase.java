package sample.controller;

import sample.Controller;
import sample.Main;
import sample.models.Army;
import sample.models.unit.InfantryUnit;
import sample.models.unit.Unit;
import sample.models.unit.units.Infantry.Infantry;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;
import org.junit.Test;
import sample.models.wargear.WeaponType;

import static org.junit.Assert.*;

import java.util.*;

/**
 * Created by Darzolak on 06-Feb-16.
 */
public class ShootingPhase {
    public static Unit unitShooting;
    public static Unit targetUnit;
    private static Map<Weapon, ArrayList<Model>> firingWeapons;

    public static Double chanceToHit(Model modelFiring){
        return 7.0 - Main.controller.tables.toHitRollNeeded(modelFiring.getBallisticSkill()) / 6;
    }

    public static Map<Weapon, Map<String, Integer>> shootingPhase(Unit unit1, Unit unit2, Map<Weapon, ArrayList<Model>> weapons) {
        unitShooting = unit1;
        targetUnit = unit2;
        firingWeapons = weapons;
        Map<Weapon, Map<String, Integer>> statistics = new HashMap<Weapon, Map<String, Integer>>();
        for (Weapon weaponFiring : weapons.keySet()) {
            Map<String, Integer> weaponStatistics = new HashMap<String, Integer>();
            if (targetUnit.getChildren().size() <= 0) {
                break;
            }

            int numberOfHits = 0;
            int numberOfHitsMade = 0;

            //Roll to hit for the weapons
            for (Model modelFiring : weapons.get(weaponFiring)) {
                int rollNeededtoHit = Main.controller.tables.toHitRollNeeded(modelFiring.getBallisticSkill());
                weaponStatistics.put("ToHitNeeded", rollNeededtoHit);
                numberOfHitsMade += weaponFiring.getNumberOfShots();
                for (int i = 0; i < weaponFiring.getNumberOfShots(); i++) {
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(6) + 1; // 0-6.
                    if (randomNumber >= rollNeededtoHit) {
                        numberOfHits += 1;
                    }
                }
            }
            weaponStatistics.put("NoHitsMade", numberOfHitsMade);
            weaponStatistics.put("NoHits", numberOfHits);

            Map<String, Integer> tempMap = targetUnit.casualties(numberOfHits, weaponFiring, true);
            weaponStatistics.putAll(tempMap);
            statistics.put(weaponFiring, weaponStatistics);
        }
        return statistics;
    }
}
