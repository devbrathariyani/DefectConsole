package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DefectController {

    @FXML
    private ComboBox<String> projectInput;

    @FXML
    private TextField defectNameInput;

    @FXML
    private TextField defectDescriptionInput;

    @FXML
    private ComboBox<String> defectCategoryInput;

    @FXML
    private TableView<DefectConsole.Defect> defectTable;

    private ObservableList<DefectConsole.Defect> defects;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setDefects(ObservableList<DefectConsole.Defect> defects) {
        this.defects = defects;
    }

    @FXML
    private void addDefect() {
        String project = projectInput.getValue();
        String name = defectNameInput.getText();
        String description = defectDescriptionInput.getText();
        String category = defectCategoryInput.getValue();

        if (project != null && !name.isEmpty() && !description.isEmpty() && category != null) {
            defects.add(new DefectConsole.Defect(name, description, category, project));
            defectNameInput.clear();
            defectDescriptionInput.clear();
        }
    }

    @FXML
    private void removeDefect() {
        DefectConsole.Defect selectedDefect = defectTable.getSelectionModel().getSelectedItem();
        if (selectedDefect != null) {
            defects.remove(selectedDefect);
        }
    }
}
