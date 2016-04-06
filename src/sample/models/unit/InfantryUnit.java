package sample.models.unit;

import sample.Controller;
import sample.Main;
import sample.models.BaseItem;
import sample.models.unit.units.Infantry.BaseProfile;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;

import java.util.*;

/**
 * Created by Darzolak on 21-Mar-16.
 */
public class InfantryUnit extends Unit {
    private int averageToughness;

    public InfantryUnit(String unitName) {
        super(unitName);
    }

    public int getAverageToughness() {
        return averageToughness;
    }

    @Override
    public Map<String, Integer> casualties(int numberOfHits, Weapon weaponFiring, boolean isTest) {
        //Roll to wound for the weapon
        Map<String, Integer> weaponStatistics = new HashMap<String, Integer>();

        int rollNeededToWound = Main.controller.tables.toWoundRollNeeded(weaponFiring.getStrength(), averageToughness);
        weaponStatistics.put("ToWound", rollNeededToWound);

        return super.casualtyCalc(numberOfHits, rollNeededToWound, weaponFiring, isTest, weaponStatistics);
    }

    @Override
    public void addModels(Model model) {
        models.add(model);
        List<Integer> toughnessValues = new ArrayList<>();
        for (BaseItem model1 : models)
        {
            toughnessValues.add(((BaseProfile) model1).getToughness());
        }
        averageToughness = majorityNumber(toughnessValues);
    }
}
