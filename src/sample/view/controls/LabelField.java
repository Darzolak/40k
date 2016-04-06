package sample.view.controls;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class LabelField extends HBox {
    private Label label;
    private Label value;

    public LabelField() {
    }

    public LabelField(String labelText, String valueText) {
        label = new Label(labelText);
        if (label.getText().length() < 30) {
            label.setMinWidth(120);
            label.setPrefWidth(130);
        }
        value = new Label(valueText);
        label.setStyle("-fx-font-weight: bold");

        this.getChildren().addAll(label, value);
    }

    public String getLabel() {
        return label.getText();
    }

    public void setLabel(String labelText) {
        label.setText(labelText);
    }

    public String getValue() {
        return value.getText();
    }

    public void setValue(String valueText) {
        value.setText(valueText);
    }

}
