package sample.view.scenes.unitScenes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sample.models.BaseItem;
import sample.models.Unit;
import sample.view.scenes.BaseScene;
import sample.view.scenes.ISceneSwitcher;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class UnitScene extends BaseScene implements ISceneSwitcher {

    public UnitScene() {

    }

    @Override
    public void buildScene(BaseItem item) {
        HBox inner = new HBox();
        Unit army = (Unit) item;

        Label test = new Label(army.toString());
        this.setStyle("-fx-background-color:Red;");
        inner.getChildren().add(test);
        this.setContent(inner);
    }
}
