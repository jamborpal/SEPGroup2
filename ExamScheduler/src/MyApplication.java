import javafx.application.Application;
import javafx.stage.Stage;
import model.ExamModelManager;
import parser.ParserException;
import view.ViewHandler;


public class MyApplication extends Application
{
    public void start(Stage primaryStage) throws ParserException
    {
        ExamModelManager model = new ExamModelManager();
        ViewHandler view  = new ViewHandler(model);
        view.start(primaryStage);
    }
}