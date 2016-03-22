package sample.models.unit;

import javafx.collections.ObservableList;
import sample.models.BaseItem;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;

import java.util.List;

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

    public abstract Unit casualties(int numberOfHits, Weapon weaponFiring);

    @Override
    public ObservableList<BaseItem> getChildren() {
        return models;
    }


}
