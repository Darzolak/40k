package sample.view.controls;

import javafx.scene.control.Label;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class LabelTitle extends Label {

    public LabelTitle(String title) {
        super();
        this.setText(title);
        this.setStyle("-fx-font-size: 150%;");
    }
}
