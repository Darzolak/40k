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
import sample.view.HierarchyTracker;
import sample.view.TreeViewWithItems;

public class Main extends Application {
    private static TreeViewWithItems<BaseItem> treeView;
    public static Controller controller;
    public static Scene mainScene;
    public static SplitPane content;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(500);
        primaryStage.setTitle("Hello World");
        primaryStage.show();

        Pane pane = getMainPane();
        controller = new Controller();
        controller.army = setUpArmy();
        refreshTree();

        mainScene = new Scene(pane);
        primaryStage.setScene(mainScene);
    }

    private Army setUpArmy() {
        Army chaosSpaceMarines = new Army();
        Unit chaosMarines = new Unit();
        Infantry chaosSpaceMarine = new Infantry(4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarineCaptain = new Infantry(4,4,4,4,1,4,2,9,3);

        chaosMarines.addModels(chaosSpaceMarine);
        chaosMarines.addModels(chaosSpaceMarineCaptain);
        chaosSpaceMarines.addUnits(chaosMarines);

        return chaosSpaceMarines;
    }


    private Pane getMainPane() {
        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = getMenuBar();

        mainPane.setTop(menuBar);

        this.refreshTree();

        Pane informationPane = new Pane();
        ScrollPane contentPane = new ScrollPane(informationPane);
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
