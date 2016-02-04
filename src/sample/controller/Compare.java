package sample.controller;

import sample.models.BaseItem;
import sample.models.Unit;
import sample.models.units.Armour.Tank;
import sample.models.units.Armour.VehicleHitResult;
import sample.models.units.BaseProfile;
import sample.models.units.Model;
import sample.models.wargear.Weapon;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Compare {

    public static ArrayList<Integer> compareBaseStats(BaseProfile unit1, BaseProfile unit2) {
        ArrayList<Integer> comparedList = new ArrayList<>();
        for (int i = 0; i < unit1.getBaseProfile().size(); i++)
        {
            comparedList.add(unit1.getBaseProfile().get(i) - unit2.getBaseProfile().get(i));
        }
        return comparedList;
    }

    public static void compareAssaultResults(Unit chargingUnit, Unit defendingUnit) {
        int initiativeStep = 10;
        while ((chargingUnit.getChildren().size() > 0 || defendingUnit.getChildren().size() > 0) && initiativeStep > 0) {
            int woundsByChargingUnit = 0;
            int woundsByDefendingUnit = 0;
            for (BaseItem model : chargingUnit.getChildren()) {
                BaseProfile attackingModel = (BaseProfile) model;
                if (attackingModel.getInitiative() == initiativeStep) {
                    
                }
            }
        }
    }

    public static Map<VehicleHitResult, Double> compareAgainstLightVehicle(CombatType combatType, Unit unit, int range) {
        Tank lightVehicle = new Tank(0, 10, 10, 10, 3);
        switch (combatType) {
            case Close_Combat:
                break;
            case Ranged:
                double chanceForGlance = 0.0;
                double chanceForPen = 0.0;
                for (BaseItem model : unit.getChildren()) {
                    Model attackingModel = (Model) model;
                    Weapon bestWeapon =  attackingModel.getRangedAntiTankWeapon();
                    Map<VehicleHitResult, Double> results = lightVehicle.hitAgainstFrontArmour(bestWeapon.getStrength(), 0, bestWeapon.getNumberOfShots(range));
                    if (results.get(VehicleHitResult.Penetrated) > 0) {
                        chanceForPen += results.get(VehicleHitResult.Penetrated);
                    }
                    if (results.get(VehicleHitResult.Glanced) > 0) {
                        chanceForGlance += results.get(VehicleHitResult.Glanced);
                    }
                }
                Map<VehicleHitResult, Double> returnedMap = new HashMap<>();
                returnedMap.put(VehicleHitResult.Penetrated, chanceForPen);
                returnedMap.put(VehicleHitResult.Glanced, chanceForGlance);
                return returnedMap;
            case Psychic:
                break;
            default:
                break;

        }
        return new HashMap<>();
    }

    public static Map<VehicleHitResult, Double> compareAgainstMediumVehicle(CombatType combatType, Unit unit, int range) {
        Tank mediumVehicle = new Tank(0, 12, 12, 12, 3);
        switch (combatType) {
            case Close_Combat:
                break;
            case Ranged:
                double chanceForGlance = 0.0;
                double chanceForPen = 0.0;
                for (BaseItem model : unit.getChildren()) {
                    Model attackingModel = (Model) model;
                    Weapon bestWeapon =  attackingModel.getRangedAntiTankWeapon();
                    Map<VehicleHitResult, Double> results = mediumVehicle.hitAgainstFrontArmour(bestWeapon.getStrength(), 0, bestWeapon.getNumberOfShots(range));
                    if (results.get(VehicleHitResult.Penetrated) > 0) {
                        chanceForPen += results.get(VehicleHitResult.Penetrated);
                    }
                    if (results.get(VehicleHitResult.Glanced) > 0) {
                        chanceForGlance += results.get(VehicleHitResult.Glanced);
                    }
                }
                Map<VehicleHitResult, Double> returnedMap = new HashMap<>();
                returnedMap.put(VehicleHitResult.Penetrated, chanceForPen);
                returnedMap.put(VehicleHitResult.Glanced, chanceForGlance);
                return returnedMap;
            case Psychic:
                break;
            default:
                break;

        }
        return new HashMap<>();
    }

    public static Map<VehicleHitResult, Double> compareAgainstHeavyVehicle(CombatType combatType, Unit unit, int range) {
        Tank heavyVehicle = new Tank(0, 14, 14, 14, 4);
        switch (combatType) {
            case Close_Combat:
                break;
            case Ranged:
                double chanceForGlance = 0.0;
                double chanceForPen = 0.0;
                for (BaseItem model : unit.getChildren()) {
                    Model attackingModel = (Model) model;
                    Weapon bestWeapon =  attackingModel.getRangedAntiTankWeapon();
                    Map<VehicleHitResult, Double> results = heavyVehicle.hitAgainstFrontArmour(bestWeapon.getStrength(), 0, bestWeapon.getNumberOfShots(range));
                    if (results.get(VehicleHitResult.Penetrated) > 0) {
                        chanceForPen += results.get(VehicleHitResult.Penetrated);
                    }
                    if (results.get(VehicleHitResult.Glanced) > 0) {
                        chanceForGlance += results.get(VehicleHitResult.Glanced);
                    }
                }
                Map<VehicleHitResult, Double> returnedMap = new HashMap<>();
                returnedMap.put(VehicleHitResult.Penetrated, chanceForPen);
                returnedMap.put(VehicleHitResult.Glanced, chanceForGlance);
                return returnedMap;
            case Psychic:
                break;
            default:
                break;

        }
        return new HashMap<>();
    }
}
