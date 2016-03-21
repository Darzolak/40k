package sample.models;

import sample.models.units.Armour.Vehicle;
import sample.models.units.BaseProfile;
import sample.models.units.Model;

import java.util.ArrayList;
import java.util.List;

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
    public void addModels(Model model) {
        super.addModels(model);
        List<Integer> frontArmourValues = new ArrayList<>();
        List<Integer> sideArmourValues = new ArrayList<>();
        List<Integer> rearArmourValues = new ArrayList<>();
        for (BaseItem model1 : this.getChildren())
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
