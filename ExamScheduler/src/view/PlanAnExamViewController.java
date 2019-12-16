package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Class;
import model.*;
import parser.ParserException;

import java.io.FileNotFoundException;

public class PlanAnExamViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    boolean isWritten = true;
    @FXML
    ChoiceBox examTypeDropdown;
    @FXML
    ChoiceBox courseDropdown;
    @FXML
    ChoiceBox classDropDown;
    @FXML
    TextField dayTextField;
    @FXML
    TextField monthTextField;
    @FXML
    TextField yearTextField;
    @FXML
    ChoiceBox roomDropDown;
    @FXML
    private TableView<ExamViewModel> datesTableView;
    @FXML
    private TableColumn<ExamViewModel, String> datesColumn;
    @FXML
    private Label errorLabel;


    public PlanAnExamViewController()
    {
    }

    public void init(ViewHandler viewHandler, ExamListModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        examTypeDropdown.setItems(FXCollections.observableArrayList("Oral", "Written"));
        examTypeDropdown.setTooltip(new Tooltip("Select if the exam is oral or written!"));
        courseDropdown.setItems(FXCollections.observableArrayList(model.getCourses().getCourses()));
        courseDropdown.setTooltip(new Tooltip("Select a course!"));
        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        classDropDown.setTooltip(new Tooltip("Select a class!"));
        roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getAllRooms()));
        roomDropDown.setTooltip(new Tooltip("Select a room!"));
        datesColumn.setCellValueFactory(cellData -> cellData.getValue().getdateProperty());
        errorLabel.setText("");

    }

    public void reset()
    {
        errorLabel.setText("");
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
    private void confirmExamButtonPressed() throws ParserException, FileNotFoundException
    {

        model.PlanAnExam((Course) courseDropdown.getSelectionModel().getSelectedItem(), (Class) classDropDown.getSelectionModel().getSelectedItem(), (Room) roomDropDown.getSelectionModel().getSelectedItem(), model.getDates(), isWritten);
        for (int i = 0; i < model.getCourses().size(); i++)
        {
            if (model.getCourses().get(i).equals((Course) courseDropdown.getSelectionModel().getSelectedItem()))
            {
                model.getCourses().get(i).setIsScheduled();
            }
        }
        for (int i = 0; i < model.getDates().size(); i++)
        {
            model.getDates().remove(model.getDates().getDates().get(i));
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.showAndWait();
        model.getFileConsole().writeExamList(model.getExamList());
    }

    @FXML
    private void addAnotherPressed()
    {
        examTypeDropdown.setItems(FXCollections.observableArrayList("Oral", "Written"));

        courseDropdown.setItems(FXCollections.observableArrayList(model.getCourses().getCourses()));

        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getAllRooms()));
        datesColumn.setCellValueFactory(cellData -> cellData.getValue().getdateProperty());
        dayTextField.setText("");
        monthTextField.setText("");
        yearTextField.setText("");
        for (int i = 0; i < model.getDates().size(); i++)
        {
            model.getDates().remove(model.getDates().getDates().get(i));
        }
    }

    @FXML
    private void addButton()
    {
        int oralDays = 0;


        if (examTypeDropdown.getSelectionModel().getSelectedItem().toString().equals("Written"))
        {
            isWritten = true;
        } else if (examTypeDropdown.getSelectionModel().getSelectedItem().toString().equals("Oral"))
        {
            isWritten = false;
        }
        if (isWritten == true)
        {
            roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getRoomsForWritten()));
        } else if (isWritten == false)
        {
            roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getRoomsForOral()));
            if (((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() % 20 == 0)
            {
                oralDays = ((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() / 20;
            } else if (((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() % 20 != 0)
            {
                oralDays = (((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() / 20) + 1;
            }
            errorLabel.setText("Pick " + oralDays + " date(s), 20 students can take the oral exam/day.");
        }
        MyDate date = new MyDate(Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(yearTextField.getText()));
        model.getDates().add(date);
        //how to add data in the columns from the dates arraylist
    }


}
