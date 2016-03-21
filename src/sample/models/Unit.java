package sample.models;

import javafx.collections.ObservableList;
import sample.models.units.Model;

import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Unit extends BaseItem {

    private ObservableList<BaseItem> models = observableArrayList();

    public Unit (String unitName) {
        this.itemType = "Unit";
        this.name = unitName;
    }

    public void addModels(Model model) {
        models.add(model);
    }

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

    @Override
    public ObservableList<BaseItem> getChildren() {
        return models;
    }


}
