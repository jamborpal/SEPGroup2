package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Class;
import model.*;
import parser.ParserException;

import java.io.FileNotFoundException;
import java.util.Optional;

public class ManageDataViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    private ExamListViewModel viewModel;
    @FXML
    private TableView<ExamViewModel> examTable;
    @FXML
    private TableColumn<ExamViewModel, String> classField;
    @FXML
    private TableColumn<ExamViewModel, String> courseField;
    @FXML
    private TableColumn<ExamViewModel, String> datesField;
    @FXML
    private TableColumn<ExamViewModel, String> roomField;
    @FXML
    Label errorLabel;
    @FXML
    ChoiceBox courseDropdown;
    @FXML
    ChoiceBox classDropDown;
    @FXML
    ChoiceBox roomDropDown;
    @FXML
    TextField dayTextField;
    @FXML
    TextField monthTextField;
    @FXML
    TextField yearTextField;
    @FXML
    TableColumn<ExamViewModel, String> dateTableColumn;
    @FXML
    private TableView<ExamViewModel> datesTable;

    public ManageDataViewController()
    {
    }

    public void init(ViewHandler viewHandler, ExamListModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.viewModel = new ExamListViewModel(model);
        classField.setCellValueFactory(cellData -> cellData.getValue().getclassProperty());
        courseField.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
        roomField.setCellValueFactory(cellData -> cellData.getValue().getroomProperty());
        datesField.setCellValueFactory(cellData -> cellData.getValue().getdateProperty());
        courseDropdown.setItems(FXCollections.observableArrayList(model.getCourses().getUnscheduledCourses()));
        courseDropdown.setTooltip(new Tooltip("Select a course!"));
        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        classDropDown.setTooltip(new Tooltip("Select a class!"));
        roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getAllRooms()));
        roomDropDown.setTooltip(new Tooltip("Select a room!"));
        errorLabel.setText("");

    }

    public void reset()
    {

        examTable.setItems(viewModel.update());
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML
    private void cancelButtonPressed()
    {
        viewHandler.closeView();
        viewHandler.openView("DetailsView");
    }

    @FXML
    private void editButtonPressed() throws FileNotFoundException, ParserException
    {
        ExamViewModel selectedItem = examTable.getSelectionModel().getSelectedItem();
        Exam exam = new Exam(selectedItem.getCourse(), selectedItem.getTheClass(), selectedItem.getRoom(), selectedItem.isWritten());
        if (roomDropDown.getSelectionModel().getSelectedItem() != null)
        {
            model.setExamRoom((Room) roomDropDown.getSelectionModel().getSelectedItem(), exam);
        }
        if (examTable.getSelectionModel().getSelectedItem() == null)
        {
            errorLabel.setText("Select an exam to edit!");
        }

        errorLabel.setText("");
        model.getFileConsole().writeExamList(model.getExamList());
        viewModel.update();
    }

    @FXML
    private void deleteButtonPressed() throws FileNotFoundException, ParserException
    {
        if (examTable.getSelectionModel().getSelectedItem() == null)
        {
            errorLabel.setText("Select an exam to delete!");
        }
        Course course = null;
        Class theClass = null;
        Room room = null;
        boolean isWritten = true;
        errorLabel.setText("");
        try
        {
            ExamViewModel selectedItem = examTable.getSelectionModel().getSelectedItem();
            boolean remove = confirmation();

            if (remove)
            {

                Exam exam = new Exam(selectedItem.getCourse(), selectedItem.getTheClass(), selectedItem.getRoom(), selectedItem.isWritten());
                model.removeAnExam(exam);
                viewModel.remove(exam);
                examTable.getSelectionModel().clearSelection();
            }
        } catch (Exception e)
        {
            errorLabel.setText("Item not found: " + e.getMessage());
        }
        viewModel.update();
        model.getFileConsole().writeExamList(model.getExamList());
    }

    private boolean confirmation()
    {
        int index = examTable.getSelectionModel().getSelectedIndex();
        ExamViewModel selectedItem = examTable.getItems().get(index);
        if (index < 0 || index >= examTable.getItems().size())
        {
            return false;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Removing exam {Course: " + selectedItem.getCourseProperty().get() + ", Class: " + selectedItem.getclassProperty().get() + "}");
        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }

    @FXML
    private void addButton()
    {

        ExamViewModel selectedItem = examTable.getSelectionModel().getSelectedItem();
        Exam exam = new Exam(selectedItem.getCourse(), selectedItem.getTheClass(), selectedItem.getRoom(), selectedItem.isWritten());
        MyDate date = new MyDate(Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(yearTextField.getText()));
        model.getDate(exam).add(date);
        //how to add data in the columns from the dates arraylist
    }

}
