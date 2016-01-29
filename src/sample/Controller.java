package sample;

import javafx.scene.control.TreeItem;
import sample.models.Army;
import sample.models.BaseItem;
import sample.view.scenes.ArmyScene;
import sample.view.scenes.BaseScene;
import sample.view.scenes.ISceneSwitcher;
import sample.view.scenes.unitScenes.UnitScene;

import java.util.HashMap;

public class Controller {
    public static TreeItem selectedTreeItem = new TreeItem();
    public static Army army = new Army();
    public static HashMap<String, ISceneSwitcher> switchStrategy = new HashMap<String, ISceneSwitcher>();

    public Controller() {
        switchStrategy.put("Army", new ArmyScene());
        switchStrategy.put("Unit", new UnitScene());

    }

    public static void switchScene(BaseItem item) {
        Main.content.getItems().remove(1);
        BaseScene switchedScene = (BaseScene) switchStrategy.get(item.getItemType());
        switchedScene.buildScene(item);
        Main.content.getItems().add(switchedScene);
    }

}
