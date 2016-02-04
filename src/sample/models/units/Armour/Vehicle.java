package sample.models.units.Armour;

import javafx.collections.ObservableList;
import sample.models.BaseItem;
import sample.models.units.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darzolak on 04-Feb-16.
 */
public abstract class Vehicle extends Model {

    //region variables
    protected int ballisticSkill;
    protected int frontArmour;
    protected int sideArmour;
    protected int rearArmour;
    protected int hullPoints;
    //endregion

    //region getters and setters
    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(int ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public int getFrontArmour() {
        return frontArmour;
    }

    public void setFrontArmour(int frontArmour) {
        this.frontArmour = frontArmour;
    }

    public int getSideArmour() {
        return sideArmour;
    }

    public void setSideArmour(int sideArmour) {
        this.sideArmour = sideArmour;
    }

    public int getRearArmour() {
        return rearArmour;
    }

    public void setRearArmour(int rearArmour) {
        this.rearArmour = rearArmour;
    }

    public int getHullPoints() {
        return hullPoints;
    }

    public void setHullPoints(int hullPoints) {
        this.hullPoints = hullPoints;
    }
    //endregion

    public Map<VehicleHitResult, Double> hitAgainstFrontArmour(int strength, int modifier, int numberOfShots) {
        Map<VehicleHitResult, Double> returnedMap = new HashMap<>();
        returnedMap.put(VehicleHitResult.Penetrated, (((double)6 -  (frontArmour - strength)) / (6 + modifier)) * numberOfShots);
        returnedMap.put(VehicleHitResult.Glanced, (((double)7 - (frontArmour - strength)) / (6 + modifier)) * numberOfShots);
        return returnedMap;
    }

    public Map<VehicleHitResult, Double> hitAgainstSideArmour(int strength, int modifier, int numberOfShots) {
        Map<VehicleHitResult, Double> returnedMap = new HashMap<>();
        returnedMap.put(VehicleHitResult.Penetrated, (((double)6 -  (sideArmour - strength)) / (6 + modifier)) * numberOfShots);
        returnedMap.put(VehicleHitResult.Glanced, (((double)7 - (sideArmour - strength)) / (6 + modifier)) * numberOfShots);
        return returnedMap;
    }

    public Map<VehicleHitResult, Double> hitAgainstRearArmour(int strength, int modifier, int numberOfShots) {
        Map<VehicleHitResult, Double> returnedMap = new HashMap<>();
        returnedMap.put(VehicleHitResult.Penetrated, (((double)6 -  (rearArmour - strength)) / (6 + modifier)) * numberOfShots);
        returnedMap.put(VehicleHitResult.Glanced, (((double)7 - (rearArmour - strength)) / (6 + modifier)) * numberOfShots);
        return returnedMap;
    }

    @Override
    public ObservableList<BaseItem> getChildren() {
        return null;
    }
}
