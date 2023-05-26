package Graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class App extends Application {
    public static Pane root=null;
    public static Scene scene=null;
    public static FXMLLoader xmlFile=null;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        xmlFile=new FXMLLoader();
        xmlFile.setLocation(App.class.getResource("Fxml/Paint.fxml"));
        try{
            root=xmlFile.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if(root!=null){
            scene=new Scene(root);
        }
        primaryStage.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
        primaryStage.setTitle("Paint");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
