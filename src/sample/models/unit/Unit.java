package sample.models.unit;

import javafx.collections.ObservableList;
import sample.models.BaseItem;
import sample.models.unit.units.Infantry.BaseProfile;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public abstract class Unit extends BaseItem {

    protected ObservableList<BaseItem> models = observableArrayList();

    public Unit (String unitName) {
        this.itemType = "Unit";
        this.name = unitName;
    }

    public abstract void addModels(Model model);

    protected int majorityNumber(List<Integer> nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }

    public abstract Map<String, Integer> casualties(int numberOfHits, Weapon weaponFiring, boolean isTest);

    public Map<String, Integer> casualtyCalc(int numberOfHits, int rollNeededToWound, Weapon weaponFiring, boolean isTest, Map<String, Integer> weaponStatistics) {
        int numberOfWounds = 0;
        for (int i = 0; i < numberOfHits; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(6) + 1; // 0-9.
            if (randomNumber >= rollNeededToWound) {
                numberOfWounds += 1;
            }
        }
        weaponStatistics.put("NoWounds", numberOfWounds);

        int numberOfSavesMade = numberOfWounds;
        while (models.size() > 0 && numberOfWounds > 0) {

            if (models.size() <= 0) {
                break;
            }

            Random rand = new Random();
            int randomNumber = rand.nextInt(6) + 1; // 0-9.
            int bestSave = ((BaseProfile) models.get(0)).getBestSave(weaponFiring.getAp(), false);

            if (randomNumber < bestSave) {
                numberOfSavesMade -= 1;
                BaseProfile targetModel = ((BaseProfile)models.get(0));
                targetModel.setWounds(targetModel.getWounds() - 1);

                if (targetModel.getWounds() <= 0 && !isTest) {
                    models.remove(targetModel);
                }
            }
            numberOfWounds -= 1;
        }
        weaponStatistics.put("SavesMade", numberOfSavesMade);
        return weaponStatistics;
    }


    @Override
    public ObservableList<BaseItem> getChildren() {
        return models;
    }


}
