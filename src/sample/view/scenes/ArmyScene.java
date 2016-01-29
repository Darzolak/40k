package sample.view.scenes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
        this.setStyle("-fx-background-color:blue;");
    }

    @Override
    public void buildScene(BaseItem item) {
        HBox inner = new HBox();
        Army army = (Army) item;

        Label test = new Label(army.toString());
        this.setStyle("-fx-background-color:Red;");
        inner.getChildren().add(test);
        this.setContent(inner);
    }
}
