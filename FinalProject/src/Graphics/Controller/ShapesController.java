package Graphics.Controller;

import Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ShapesController implements Initializable {
    public Button circle;
    public Button ellipse;
    public Button rectangle;
    public Button square;
    public static Stage newWindow2= null;
    public static Stage newWindow3= null;
    public static Stage newWindow4= null;
    public static Stage newWindow5= null;
    public void onShapesButton(ActionEvent event){
        if(event.getSource().equals(circle)){
            Label labelshapes=new Label("Circle");
            StackPane CircleLayout = new StackPane();
            CircleLayout.getChildren().add(labelshapes);
            FXMLLoader fxmlloader =new FXMLLoader();
            Pane root=new Pane();
            fxmlloader.setLocation(App.class.getResource("Fxml/Circle.fxml"));
            try{
                root=fxmlloader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(root!=null){
                Scene CircleScene = new Scene(root, 228, 230);
            }
            //New window (Stage)
            newWindow2=new Stage();
            newWindow2.setTitle("Circle");
            newWindow2.setScene(root.getScene());
            newWindow2.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
            // Set position of second window, related to primary window.
            newWindow2.setX(90);
            newWindow2.setY(65);
            newWindow2.setResizable(false);
            newWindow2.initModality(Modality.WINDOW_MODAL);
            newWindow2.initOwner(App.scene.getWindow());
            PaintController.newWindow.hide();
            newWindow2.show();
        }
        else if(event.getSource().equals(ellipse)){
            FXMLLoader fxmlloader=new FXMLLoader();
            Pane root=new Pane();
            fxmlloader.setLocation(App.class.getResource("Fxml/Ellipse.fxml"));
            try{
                root=fxmlloader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(root!=null){
                Scene EllipseScene = new Scene(root, 228, 250);
            }
            //New window (Stage)
            newWindow3 = new Stage();
            newWindow3.setTitle("Ellipse");
            newWindow3.setScene(root.getScene());
            newWindow3.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
            // Set position of second window, related to primary window.
            newWindow3.setX(90);
            newWindow3.setY(65);
            newWindow3.setResizable(false);
            newWindow3.initModality(Modality.WINDOW_MODAL);
            newWindow3.initOwner(App.scene.getWindow());
            PaintController.newWindow.hide();
            newWindow3.show();
        }
        else if(event.getSource().equals(square)){
            Label labelshapes=new Label("Square");
            StackPane SquareLayout = new StackPane();
            SquareLayout.getChildren().add(labelshapes);
            FXMLLoader fxmlloader=new FXMLLoader();
            Pane root=new Pane();
            fxmlloader.setLocation(App.class.getResource("Fxml/Square.fxml"));
            try{
                root=fxmlloader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(root!=null){
                Scene SquareScene = new Scene(root, 228, 230);
            }
            //New window (Stage)
            newWindow4 = new Stage();
            newWindow4.setTitle("Square");
            newWindow4.setScene(root.getScene());
            newWindow4.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
            // Set position of second window, related to primary window.
            newWindow4.setX(90);
            newWindow4.setY(65);
            newWindow4.setResizable(false);
            newWindow4.initModality(Modality.WINDOW_MODAL);
            newWindow4.initOwner(App.scene.getWindow());
            PaintController.newWindow.hide();
            newWindow4.show();
        }
        else if(event.getSource().equals(rectangle)){
            Label labelshapes=new Label("Rectangle");
            StackPane RectangleLayout = new StackPane();
            RectangleLayout.getChildren().add(labelshapes);
            FXMLLoader fxmlloader=new FXMLLoader();
            Pane root=new Pane();
            fxmlloader.setLocation(App.class.getResource("Fxml/Rectangle.fxml"));
            try{
                root=fxmlloader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(root!=null){
                Scene RectangleScene = new Scene(root, 228, 250);
            }
            //New window (Stage)
            newWindow5 = new Stage();
            newWindow5.setTitle("Rectangle");
            newWindow5.setScene(root.getScene());
            newWindow5.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
            // Set position of second window, related to primary window.
            newWindow5.setX(90);
            newWindow5.setY(65);
            newWindow5.setResizable(false);
            newWindow5.initModality(Modality.WINDOW_MODAL);
            newWindow5.initOwner(App.scene.getWindow());
            PaintController.newWindow.hide();
            newWindow5.show();
        }
    }

    public void mouseEnter(MouseEvent event) {
        if (event.getSource().equals(circle)) {
            circle.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(ellipse)) {
            ellipse.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(rectangle)) {
            rectangle.setStyle("-fx-opacity: 1");
        }
        if(event.getSource().equals(square)){
            square.setStyle("-fx-opacity: 1");
        }
    }
    public void mouseExit(MouseEvent event) {
        if (event.getSource().equals(circle)) {
            circle.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(ellipse)) {
            ellipse.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(rectangle)) {
            rectangle.setStyle("-fx-opacity: 0.85");
        }
        if(event.getSource().equals(square)){
            square.setStyle("-fx-opacity: 0.85");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
