package sample.models.unit;

import sample.Controller;
import sample.Main;
import sample.models.BaseItem;
import sample.models.unit.units.Armour.Vehicle;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;

import java.util.*;

/**
 * Created by Darzolak on 21-Mar-16.
 */
public class VehicleUnit extends Unit {
    int averageFrontArmour;
    int averageSideArmour;
    int averageRearArmour;

    public int getAverageFrontArmour() {
        return averageFrontArmour;
    }

    public int getAverageSideArmour() {
        return averageSideArmour;
    }

    public int getAverageRearArmour() {
        return averageRearArmour;
    }

    public VehicleUnit(String unitName) {
        super(unitName);
    }

    @Override
    public Map<String, Integer> casualties(int numberOfHits, Weapon weaponFiring, boolean isTest) {
        //Roll to Pen for the weapon
        Map<String, Integer> weaponStatistics = new HashMap<String, Integer>();

        int rollNeededToPen = Main.controller.tables.toPenNeeded(weaponFiring.getStrength(), this.getAverageFrontArmour());
        weaponStatistics.put("ToPen", rollNeededToPen);

        return super.casualtyCalc(numberOfHits, rollNeededToPen, weaponFiring, isTest, weaponStatistics);
    }

    @Override
    public void addModels(Model model) {
        models.add(model);
        List<Integer> frontArmourValues = new ArrayList<>();
        List<Integer> sideArmourValues = new ArrayList<>();
        List<Integer> rearArmourValues = new ArrayList<>();
        for (BaseItem model1 : models)
        {
            frontArmourValues.add(((Vehicle) model1).getFrontArmour());
            sideArmourValues.add(((Vehicle) model1).getSideArmour());
            rearArmourValues.add(((Vehicle) model1).getRearArmour());
        }
        averageFrontArmour = majorityNumber(frontArmourValues);
        averageSideArmour = majorityNumber(sideArmourValues);
        averageRearArmour = majorityNumber(rearArmourValues);
    }
}
