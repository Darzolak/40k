package sample.models.unit;

import sample.Controller;
import sample.Main;
import sample.models.BaseItem;
import sample.models.unit.units.Infantry.BaseProfile;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public Unit casualties(int numberOfHits, Weapon weaponFiring) {
        //Roll to wound for the weapon
        //todo change this shit
        //todo pick model to destroy
        int rollNeededToWound = Main.controller.tables.toWoundRollNeeded(weaponFiring.getStrength(), averageToughness);

        int numberOfWounds = 0;
        for (int i = 0; i < numberOfHits; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(6) + 1; // 0-9.
            if (randomNumber >= rollNeededToWound) {
                numberOfWounds += 1;
            }
        }

        while (models.size() > 0 && numberOfWounds > 0) {
            for (int i = 0; i < numberOfHits; i++) {
                if (models.size() <= 0) {
                    break;
                }
                Random rand = new Random();
                int randomNumber = rand.nextInt(6) + 1; // 0-9.
                if (randomNumber < ((BaseProfile)models.get(0)).getBestSave(weaponFiring.getAp(), false)) {
                    BaseProfile targetModel = ((BaseProfile)models.get(0));

                    targetModel.setWounds(targetModel.getWounds() - 1);

                    if (targetModel.getWounds() <= 0) {
                        models.remove(targetModel);
                    }
                }
            }
            numberOfWounds -= 1;
        }
        return this;
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
