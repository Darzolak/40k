package sample.controller;

import javafx.collections.transformation.SortedList;
import sample.Controller;
import sample.models.Unit;
import sample.models.units.Model;
import sample.models.wargear.Weapon;

import java.util.*;

/**
 * Created by Darzolak on 06-Feb-16.
 */
public class ShootingPhase {
    public static Unit unitShooting;
    public static Unit targetUnit;
    private static SortedMap<Weapon, ArrayList<Model>> firingWeapons;

    public static Double chanceToHit(Model modelFiring){
        return 7.0 - Controller.tables.toHitRollNeeded(modelFiring.getBallisticSkill()) / 6;
    }

    public static Unit shootingPhase(Unit unit1, Unit unit2, SortedMap<Weapon, ArrayList<Model>> weapons) {
        unitShooting = unit1;
        targetUnit = unit2;
        firingWeapons = weapons;
        for (Weapon weaponFiring : weapons.keySet()) {
            ArrayList<Model> value = weapons.get(weaponFiring);
            for (Model modelFiring : value) {
                int rollNeededtoHit = Controller.tables.toHitRollNeeded(modelFiring.getBallisticSkill());
                int rollNeededtoWound = Controller.tables.toWoundRollNeeded(weaponFiring.getStrength(), )

            }


        }




        return targetUnit;
    }
}
