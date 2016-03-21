package sample.models;

import sample.models.units.BaseProfile;
import sample.models.units.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darzolak on 21-Mar-16.
 */
public class InfantryUnit extends Unit {
    int averageToughness;

    public InfantryUnit(String unitName) {
        super(unitName);
    }

    public int getAverageToughness() {
        return averageToughness;
    }

    @Override
    public void addModels(Model model) {
        super.addModels(model);
        List<Integer> toughnessValues = new ArrayList<>();
        for (BaseItem model1 : this.getChildren())
        {
            toughnessValues.add(((BaseProfile) model1).getToughness());
        }
        averageToughness = majorityNumber(toughnessValues);
    }
}
