package sample.view.scenes.unitScenes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.models.BaseItem;
import sample.models.Unit;
import sample.view.controls.LabelTitle;
import sample.view.scenes.BaseScene;
import sample.view.scenes.ISceneSwitcher;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class UnitScene extends BaseScene implements ISceneSwitcher {
    private Unit unit;


    public UnitScene() {

    }

    private Tab getDetailsTab() {
        Tab detailsTab = new Tab();
        detailsTab.setText("Basic Information");
        Pane basicInfoPane = new VBox(10);
        basicInfoPane.setBorder(null);
        basicInfoPane.setPadding(new Insets(25, 25, 25, 25));
        ScrollPane wrapper = new ScrollPane(basicInfoPane);
        detailsTab.setContent(wrapper);

        LabelTitle name = new LabelTitle(unit.getName());

        ListView<BaseItem> unitContentsListView = new ListView<BaseItem>(unit.getChildren());

        Button selectButton = new Button("Select");

        selectButton.setOnAction((event) -> {
            if (unitContentsListView.getSelectionModel().getSelectedItem() != null) {
                Main.treeView.selectItem(unitContentsListView.getSelectionModel().getSelectedItem());
            }
        });

        basicInfoPane.getChildren().addAll(name,unitContentsListView,selectButton);
        return detailsTab;
    }



    @Override
    public void buildScene(BaseItem item) {
        unit = (Unit) item;
        TabPane inner = new TabPane();

        Tab detailsTab = getDetailsTab();

        inner.getTabs().add(detailsTab);
        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setStyle("-fx-background-color:Red;");
        this.setContent(inner);
    }
}
