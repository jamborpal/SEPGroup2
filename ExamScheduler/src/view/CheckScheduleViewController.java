package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ExamList;
import model.ExamListModel;
import parser.ParserException;

public class CheckScheduleViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    private ExamListViewModel viewModel;
    @FXML
    private TextField teacherField;
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
    private TableColumn<ExamViewModel, String> examinerField;
    @FXML
    Label errorLabel;

    public CheckScheduleViewController()
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
        examinerField.setCellValueFactory(cellData -> cellData.getValue().getexaminerProperty());
        errorLabel.setText("");

    }

    public void reset()
    {
        teacherField.setText("");
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
    private void okButtonPressed() throws ParserException
    {
        ExamList teachersScheduleById = model.getTeachersScheduleById(teacherField.getText());


            classField.setCellValueFactory(cellData -> cellData.getValue().getclassProperty());
            courseField.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
            roomField.setCellValueFactory(cellData -> cellData.getValue().getroomProperty());
            datesField.setCellValueFactory(cellData -> cellData.getValue().getdateProperty());
            examinerField.setCellValueFactory(cellData -> cellData.getValue().getexaminerProperty());

    }

}
