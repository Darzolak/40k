package sample;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import sample.controller.Tables;
import sample.models.Army;
import sample.models.BaseItem;
import sample.view.scenes.ArmyScene;
import sample.view.scenes.BaseScene;
import sample.view.scenes.ISceneSwitcher;
import sample.view.scenes.unitScenes.UnitScene;
import sample.view.scenes.unitScenes.modelsScenes.InfantryScene;

import java.util.HashMap;

public class Controller {
    public static TreeItem selectedTreeItem = new TreeItem();
    public static Army army = new Army();
    public static HashMap<String, ISceneSwitcher> switchStrategy = new HashMap<String, ISceneSwitcher>();
    public static Tables tables = new Tables();

    public Controller() {
        switchStrategy.put("Army", new ArmyScene());
        switchStrategy.put("Unit", new UnitScene());
        switchStrategy.put("Infantry", new InfantryScene());

    }

    public static void switchScene(BaseItem item) {

        BaseScene switchedScene = (BaseScene) switchStrategy.get(item.getItemType());
        switchedScene.buildScene(item);
        Main.contentPane.setContent(switchedScene);
        SplitPane thing = Main.content;
    }

}
