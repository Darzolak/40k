package sample.models;

import javafx.collections.ObservableList;
import sample.models.units.Model;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Unit extends BaseItem {

    private ObservableList<BaseItem> models = observableArrayList();

    public Unit () {

    }

    public void addModels(Model model) {
        models.add(model);
    }

    @Override
    public ObservableList<BaseItem> getChildren() {
        return models;
    }


}
