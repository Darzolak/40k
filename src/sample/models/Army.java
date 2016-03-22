package sample.models;

import javafx.collections.ObservableList;
import sample.models.unit.Unit;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Army extends BaseItem {
    private ObservableList<BaseItem> units = observableArrayList();

    public Army () {
        itemType = "Army";
    }

    public void addUnits(Unit unit) {
        units.add(unit);

    }

    @Override
    public ObservableList<BaseItem> getChildren() {
        return units;
    }

    @Override
    public String toString() {
        return "akjsdnsbadfkjbsadkjfbsdf";
    }

}
