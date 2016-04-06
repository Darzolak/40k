package sample.view.scenes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.controller.CombatType;
import sample.controller.Compare;
import sample.controller.ShootingPhase;
import sample.models.Army;
import sample.models.BaseItem;
import sample.models.unit.Unit;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;
import sample.models.wargear.WeaponType;
import sample.view.controls.LabelField;
import sample.view.controls.LabelTitle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class ArmyScene extends BaseScene implements ISceneSwitcher {
    private Army army;

    public ArmyScene () {
        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setStyle("-fx-background-color:blue;");
    }

    private Tab getDetailsTab() {
        Tab detailsTab = new Tab();
        detailsTab.setText("Basic Information");
        Pane basicInfoPane = new VBox(10);
        basicInfoPane.setBorder(null);
        basicInfoPane.setPadding(new Insets(25, 25, 25, 25));
        ScrollPane wrapper = new ScrollPane(basicInfoPane);
        detailsTab.setContent(wrapper);

        LabelTitle name = new LabelTitle(army.getName());

        ListView<BaseItem> unitContentsListView = new ListView<BaseItem>(army.getChildren());

        Button selectButton = new Button("Select");

        selectButton.setOnAction((event) -> {
            if (unitContentsListView.getSelectionModel().getSelectedItem() != null) {
                Main.treeView.selectItem(unitContentsListView.getSelectionModel().getSelectedItem());
            }
        });

        basicInfoPane.getChildren().addAll(name,unitContentsListView,selectButton);
        return detailsTab;
    }

    private Tab getUnitComparisonTab() {
        Tab detailsTab = new Tab();
        detailsTab.setText("Shooting Phase theory");
        Pane basicInfoPane = new HBox(10);
        Pane basicControls = new VBox(10);
        Pane detailedStatistics = new VBox(10);
        basicInfoPane.setBorder(null);
        basicInfoPane.setPadding(new Insets(25, 25, 25, 25));
        ScrollPane wrapper = new ScrollPane(basicInfoPane);
        detailsTab.setContent(wrapper);
        Compare.compareAgainstLightVehicle(CombatType.Ranged, ((Unit) army.getChildren().get(0)), 12);
        LabelTitle name = new LabelTitle(army.getName());

        ComboBox<BaseItem> shootingCombo = new ComboBox<BaseItem>();
        ComboBox<BaseItem> targetCombo = new ComboBox<BaseItem>();

        shootingCombo.getItems().addAll(army.getChildren());
        targetCombo.getItems().addAll(army.getChildren());

        Button shootBtn = new Button("Shoot");
        shootBtn.setOnAction((event) -> {
                detailedStatistics.getChildren().clear();
                Map<Weapon, ArrayList<Model>> map = new HashMap<Weapon, ArrayList<Model>>() {
                };

                Weapon tempWeapon = null;
                ArrayList<Model> models = new ArrayList<>();
                for (BaseItem item : shootingCombo.getValue().getChildren()) {
                    Model model = (Model) item;

                    tempWeapon = model.getRangedAntiInfantryWeapon();

                    ArrayList<Model> tempModels = map.get(tempWeapon);
                    if (tempModels == null) {
                        models = new ArrayList<>();
                        models.add(model);
                        map.put(tempWeapon, models);
                    }
                    else
                    {
                        tempModels.add(model);
                        map.put(tempWeapon, models);
                    }
                }

                Map<Weapon, Map<String, Integer>> statistics = ShootingPhase.shootingPhase((Unit) shootingCombo.getValue(), (Unit) targetCombo.getValue(), map);

                for (Weapon weaponFiring : statistics.keySet()) {
                    LabelTitle weaponTitle = new LabelTitle(weaponFiring.toString());

                    LabelField noHitsMadeLabel = new LabelField("Number of Hits Made:", statistics.get(weaponFiring).get("NoHitsMade").toString());
                    LabelField toHitNeededLabel = new LabelField("To Hit Roll Needed:", statistics.get(weaponFiring).get("ToHitNeeded").toString());
                    LabelField noHitsLabel = new LabelField("Number of Hits:", statistics.get(weaponFiring).get("NoHits").toString());
                    LabelField toWoundLabel = new LabelField("To Wound Roll Needed:", statistics.get(weaponFiring).get("ToWound").toString());
                    LabelField noWoundsLabel = new LabelField("Number of Wounds:", statistics.get(weaponFiring).get("NoWounds").toString());
                    LabelField savesMadeLabel = new LabelField("Number of Saves Made:", statistics.get(weaponFiring).get("SavesMade").toString());

                    detailedStatistics.getChildren().addAll(weaponTitle, toHitNeededLabel, toWoundLabel, noHitsMadeLabel, noHitsLabel, noWoundsLabel, savesMadeLabel);
                }
            });

        basicControls.getChildren().addAll(name, shootingCombo, targetCombo, shootBtn);



        basicInfoPane.getChildren().addAll(basicControls, detailedStatistics);
        return detailsTab;
    }

    @Override
    public void buildScene(BaseItem item) {
        army = (Army) item;

        TabPane inner = new TabPane();

        Tab detailsTab = getDetailsTab();
        Tab unitComparisonTab = getUnitComparisonTab();

        inner.getTabs().add(detailsTab);
        inner.getTabs().add(unitComparisonTab);
        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setStyle("-fx-background-color:Red;");
        this.setContent(inner);
    }
}
