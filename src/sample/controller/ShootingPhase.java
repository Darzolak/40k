package sample.controller;

import javafx.collections.transformation.SortedList;
import sample.Controller;
import sample.models.BaseItem;
import sample.models.InfantryUnit;
import sample.models.Unit;
import sample.models.VehicleUnit;
import sample.models.units.Armour.Vehicle;
import sample.models.units.BaseProfile;
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

            int numberOfHits = 0;

            //Roll to hit for the weapons
            for (Model modelFiring : value) {
                int rollNeededtoHit = Controller.tables.toHitRollNeeded(modelFiring.getBallisticSkill());
                for (int i = 0; i < weaponFiring.getNumberOfShots(); i++) {
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(6) + 1; // 0-9.
                    if (randomNumber >= rollNeededtoHit) {
                        numberOfHits += 1;
                    }
                }
            }

            if (targetUnit.getChildren().get(0) instanceof Vehicle) {
                targetUnit = casualtiesVehicle(numberOfHits, targetUnit, weaponFiring);
            }
            else {
                targetUnit = casualtiesInfantry(numberOfHits, targetUnit, weaponFiring);
            }

        }
        return targetUnit;
    }

    private static Unit casualtiesInfantry(int numberOfHits, Unit targetUnit, Weapon weaponFiring) {
        //Roll to wound for the weapon
        //todo change this shit
        //todo pick model to destroy
        int rollNeededToWound = Controller.tables.toWoundRollNeeded(weaponFiring.getStrength(), ((InfantryUnit) targetUnit).getAverageToughness());

        int numberOfWounds = 0;
        for (int i = 0; i < numberOfHits; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(6) + 1; // 0-9.
            if (randomNumber >= rollNeededToWound) {
                numberOfWounds += 1;
            }
        }

        while (targetUnit.getChildren().size() > 0 && numberOfWounds > 0) {
            for (int i = 0; i < numberOfHits; i++) {
                Random rand = new Random();
                int randomNumber = rand.nextInt(6) + 1; // 0-9.
                if (randomNumber < ((BaseProfile)targetUnit.getChildren().get(0)).getBestSave(weaponFiring.getAp(), false)) {
                    BaseProfile targetModel = ((BaseProfile)targetUnit.getChildren().get(0));

                    targetModel.setWounds(targetModel.getWounds() - 1);

                    if (targetModel.getWounds() <= 0) {
                        targetUnit.getChildren().remove(targetModel);
                    }
                }
            }
        }
        return targetUnit;
    }

    private static Unit casualtiesVehicle(int numberOfHits, Unit targetUnit, Weapon weaponFiring) {
        //Roll to wound for the weapon
        //todo change this shit
        //todo pick model to destroy
        int rollNeededToPen = Controller.tables.toPenNeeded(weaponFiring.getStrength(), ((InfantryUnit) targetUnit).getAverageToughness());

        int numberOfPens = 0;
        for (int i = 0; i < numberOfHits; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(6) + 1; // 1-6.
            if (randomNumber >= rollNeededToPen) {
                numberOfPens += 1;
            }
        }

        while (targetUnit.getChildren().size() > 0 && numberOfPens > 0) {
            for (int i = 0; i < numberOfHits; i++) {
                Random rand = new Random();
                int randomNumber = rand.nextInt(6) + 1; // 0-9.
                if (randomNumber >= ((Vehicle)targetUnit.getChildren().get(0)).getBestSave(weaponFiring.getAp(), false)) {
                    Vehicle targetVehicle = ((Vehicle)targetUnit.getChildren().get(0));

                    targetVehicle.setHullPoints(targetVehicle.getHullPoints() - 1);

                    if (targetVehicle.getHullPoints() <= 0) {
                        targetUnit.getChildren().remove(targetVehicle);
                    }
                }
            }
        }
        return targetUnit;
    }
}
