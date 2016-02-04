package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.models.Army;
import sample.models.BaseItem;
import sample.models.Unit;
import sample.models.units.Infantry;
import sample.models.units.Model;
import sample.models.wargear.Weapon;
import sample.models.wargear.WeaponType;
import sample.view.HierarchyTracker;
import sample.view.TreeViewWithItems;

public class Main extends Application {
    public static TreeViewWithItems<BaseItem> treeView;
    public static Controller controller;
    public static Scene mainScene;
    public static SplitPane content;
    public static ScrollPane contentPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(500);
        primaryStage.setTitle("Hello World");
        primaryStage.show();

        Pane pane = getMainPane();
        controller = new Controller();
        Controller.army = setUpArmy();
        refreshTree();

        mainScene = new Scene(pane);
        primaryStage.setScene(mainScene);
    }

    private Army setUpArmy() {
        Army chaosSpaceMarines = new Army();
        Unit chaosMarines = new Unit("Chaos Space Marines");
        Infantry chaosSpaceMarine1 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine2 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine3 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine4 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarineCaptain = new Infantry("Aspiring Champion", 4,4,4,4,1,4,2,9,3);

        Weapon bolter = new Weapon(24, 4, 5, WeaponType.Rapid_Fire, 1);
        Weapon missileLauncher = new Weapon(48, 8, 3, WeaponType.Heavy, 1);
        Weapon boltPistol = new Weapon(12, 4, 5, WeaponType.Pistol, 1);
        Weapon chainSword = new Weapon(12, 4, 0, WeaponType.Melee);

        chaosSpaceMarine1.addRangedWeapon(bolter);
        chaosSpaceMarine2.addRangedWeapon(bolter);
        chaosSpaceMarine3.addRangedWeapon(bolter);
        chaosSpaceMarine4.addRangedWeapon(bolter);
        chaosSpaceMarine4.addRangedWeapon(missileLauncher);
        chaosSpaceMarineCaptain.addRangedWeapon(boltPistol);
        chaosSpaceMarineCaptain.addAssaultWeapon(chainSword);

        chaosMarines.addModels(chaosSpaceMarine1);
        chaosMarines.addModels(chaosSpaceMarine2);
        chaosMarines.addModels(chaosSpaceMarine3);
        chaosMarines.addModels(chaosSpaceMarine4);
        chaosMarines.addModels(chaosSpaceMarineCaptain);
        chaosSpaceMarines.addUnits(chaosMarines);

        return chaosSpaceMarines;
    }


    private Pane getMainPane() {
        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = getMenuBar();

        mainPane.setTop(menuBar);

        refreshTree();

        Pane informationPane = new Pane();
        contentPane = new ScrollPane(informationPane);
        content = new SplitPane();

        contentPane.setFitToHeight(true);
        contentPane.setFitToWidth(true);
        contentPane.setStyle("-fx-background-color:transparent;");

        VBox.setVgrow(contentPane, Priority.ALWAYS);

        VBox stickyBarBox = new VBox();
        VBox.setVgrow(stickyBarBox, Priority.SOMETIMES);
        stickyBarBox.setAlignment(Pos.BOTTOM_LEFT);

        VBox contentVBox = new VBox();
        contentVBox.getChildren().addAll(contentPane, stickyBarBox);

        content.getItems().add(treeView);
        content.getItems().add(contentPane);
        mainPane.setCenter(content);

        return mainPane;
    }

    private MenuBar getMenuBar() {
        return new MenuBar();
    }


    /**
     * Refreshes the tree menu of the main pane
     */
    public static void refreshTree() {
        if (treeView == null) {
            // Create the tree view
            treeView = new TreeViewWithItems<BaseItem>(new TreeItem<>());
            treeView.setShowRoot(false);
        }

        HierarchyTracker.refreshMap(treeView);

        TreeItem<BaseItem> selectedItem = treeView.getSelectionModel().getSelectedItem();

        treeView.setItems(FXCollections.observableArrayList(Controller.army));

        HierarchyTracker.restoreMap(treeView);

        // Select the selected tree item in the tree
        if (selectedItem != null) {
            treeView.selectItem(selectedItem);
        }
        else if (Controller.selectedTreeItem != null) {
            treeView.selectItem(Controller.selectedTreeItem);
        }
        else {
            Platform.runLater(() -> {
                treeView.selectItem(Controller.army);
                treeView.getSelectionModel().getSelectedItem().setExpanded(true);
            });

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
