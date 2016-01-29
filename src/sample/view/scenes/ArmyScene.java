package sample.view.scenes;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sample.models.Army;
import sample.models.BaseItem;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class ArmyScene extends BaseScene implements ISceneSwitcher {

    public ArmyScene () {
        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setStyle("-fx-background-color:transparent;");
    }


    @Override
    public void buildScene(BaseItem item) {
        this.getChildren().clear();
        Army army = (Army) item;


        this.getChildren().add(new Label(army.toString()));
    }
}
