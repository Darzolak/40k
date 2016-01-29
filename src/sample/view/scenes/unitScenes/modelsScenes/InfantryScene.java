package sample.view.scenes.unitScenes.modelsScenes;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.models.BaseItem;
import sample.models.units.Infantry;
import sample.models.units.Model;
import sample.view.controls.LabelField;
import sample.view.controls.LabelTitle;
import sample.view.scenes.BaseScene;
import sample.view.scenes.ISceneSwitcher;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class InfantryScene extends BaseScene implements ISceneSwitcher {
    private Infantry infantry;

    public InfantryScene() {

    }

    private Tab getDetailsTab() {
        Tab detailsTab = new Tab();
        detailsTab.setText("Basic Information");
        Pane basicInfoPane = new VBox(10);
        basicInfoPane.setBorder(null);
        basicInfoPane.setPadding(new Insets(25, 25, 25, 25));
        ScrollPane wrapper = new ScrollPane(basicInfoPane);
        detailsTab.setContent(wrapper);

        LabelTitle name = new LabelTitle(infantry.getName());

        LabelField weaponSkillLabel = new LabelField("Weapon Skill:", infantry.getWeaponSkill().toString());
        LabelField ballisticSkillLabel = new LabelField("Ballistic Skill:", infantry.getBallisticSkill().toString());
        LabelField strengthLabel = new LabelField("Strength:", infantry.getStrength().toString());
        LabelField toughnessLabel = new LabelField("Toughness:", infantry.getToughness().toString());
        LabelField woundsLabel = new LabelField("Wounds:", infantry.getWounds().toString());
        LabelField initiativeLabel = new LabelField("Initiative:", infantry.getInitiative().toString());
        LabelField attacksLabel = new LabelField("Attacks:", infantry.getAttacks().toString());
        LabelField leadershipLabel = new LabelField("Leadership:", infantry.getLeadership().toString());
        LabelField armourSaveLabel = new LabelField("Armour Save:", infantry.getArmourSave().toString() + "+");

        basicInfoPane.getChildren().addAll(name, weaponSkillLabel, ballisticSkillLabel, strengthLabel, toughnessLabel, woundsLabel, initiativeLabel, attacksLabel, leadershipLabel, armourSaveLabel);
        return detailsTab;
    }



    @Override
    public void buildScene(BaseItem item) {
        infantry = (Infantry) item;
        TabPane inner = new TabPane();

        Tab detailsTab = getDetailsTab();

        inner.getTabs().add(detailsTab);
        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setStyle("-fx-background-color:Red;");
        this.setContent(inner);
    }
}
