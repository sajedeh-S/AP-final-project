package Graphics.Controller;


import Graphics.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaintController implements Initializable {
    @FXML
    public Hyperlink about;
    public Button choosefile;
    public Button shapes;
    public Button save;
    public Button drawnshapes;
    public static Stage newWindow = null;
    public static Stage newWindow1= null;
    int cnt;

    public void onPaintButton(ActionEvent event){
    	//open input file
        File f;
        FileChooser.ExtensionFilter suffix = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        FileChooser selectFile = new FileChooser();
        selectFile.getExtensionFilters().add(suffix);
        if(event.getSource().equals(choosefile)){
            selectFile.setTitle("Open File");
            f = selectFile.showOpenDialog(new Stage());
            if(f.exists() && f.canRead()) {
                BufferedReader input=null;
                try{
                	//reading from file line by line and making the shape that is introduced in each line
                    input = new BufferedReader(new FileReader(f));
                    String s = input.readLine();

                    while(s!=null){
                        s=s.toLowerCase();
                        makeShape(s);
                        s=input.readLine();
                    }
                }
                catch(Exception e) {
                    System.err.println(e);}
                finally{
                    try{
                        input.close();
                    }
                    catch(IOException e){
                        System.err.println(e);}
                }
            }
        }
        if(event.getSource().equals(about)){
            FXMLLoader fxmlloader =new FXMLLoader();
            Pane root=new Pane();
            fxmlloader.setLocation(App.class.getResource("Fxml/About.fxml"));
            try{
                root=fxmlloader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(root!=null){
                Scene secondScene = new Scene(root, 600, 117);
            }
            //New window (Stage)
            newWindow1 = new Stage();
            newWindow1.setTitle("About");
            newWindow1.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
            newWindow1.setScene(root.getScene());
            newWindow1.initModality(Modality.WINDOW_MODAL);
            newWindow1.initOwner(App.scene.getWindow());
            // Set position of second window, related to primary window.
            newWindow1.setX(1215);
            newWindow1.setY( 65);
            newWindow1.setResizable(false);
            newWindow1.show();
        }
        if(event.getSource().equals(shapes)){
            FXMLLoader fxmlloader =new FXMLLoader();
            Pane root=new Pane();
            fxmlloader.setLocation(App.class.getResource("Fxml/Shapes.fxml"));
            try{
                root=fxmlloader.load();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if(root!=null){
                Scene secondScene = new Scene(root, 390, 110);
            }
            //New window (Stage)
            newWindow = new Stage();
            newWindow.setTitle("Shapes");
            newWindow.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
            newWindow.setScene(root.getScene());
            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.initOwner(App.scene.getWindow());
            // Set position of second window, related to primary window.
            newWindow.setX(90);
            newWindow.setY(65);
            newWindow.setResizable(false);
            newWindow.show();
        }

    }
    //defult values for position
    Double x=0.0,y=80.0;
    public void makeShape(String s){
        //default values
        String name="sample"+cnt++;
        String type="shape";
        Color color=Color.RED;
        Double radius=10.0,radius1=10.0,radius2=20.0,length=10.0,height=20.0;
        //flags show if we need to use default values so the defaults should change for next shape
        boolean flagX=false,flagY=false;
        //split each line
        String[] str=s.split(" ");
        //finding value of each element from file
        for(String string:str){
            if(string.startsWith("type")){
                type=string.substring(5,string.length());
                //System.out.println(type);
            }
            if(string.startsWith("name")){
                name=string.substring(5,string.length());
                //System.out.println(name);
            }
            if(string.startsWith("color")){
                color=toColor(string.substring(6,string.length()));
                //System.out.println(color);
            }
            if(string.startsWith("position")){
                x=Double.parseDouble(string.substring(10,string.indexOf(",")));
                flagX=true;
                //System.out.println(x);
            }
            if(string.startsWith("position")){
                y=Double.parseDouble(string.substring(string.indexOf(",")+1,string.length()-1));
                flagY=true;
                //System.out.println(y);
            }
            if(string.startsWith("length")){
                length=Double.parseDouble(string.substring(7,string.length()));
                //System.out.println(length);
            }
            if(string.startsWith("height")){
                height=Double.parseDouble(string.substring(7,string.length()));
                //System.out.println(height);
            }
            if(string.startsWith("radius1")){
                radius1=Double.parseDouble(string.substring(8,string.length()));
                //System.out.println(radius1);
            }
            else if(string.startsWith("radius2")){
                radius2=Double.parseDouble(string.substring(8,string.length()));
                //System.out.println(radius2);
            }
            else if(string.startsWith("radius")){
                radius=Double.parseDouble(string.substring(7,string.length()));
                //System.out.println(radius);
            }

        }
        //
        
        //making the shape which was introduced in current line
        try {
            switch(type.toLowerCase()){
                case "circle":{
                    CircleController c=new CircleController();
                    c.setCircle(name,x,y,radius,color);
                    break;
                }
                case "ellipse":{
                    EllipseController e=new EllipseController();
                    e.setEllipse("ellipse",name,x,y,radius1,radius2,color);
                    break;
                }
                case "square":{
                    SquareController sq=new SquareController();
                    sq.setSquare(name,x,y,length,color);
                    break;
                }
                case "rectangle":{
                    RectangleController r=new RectangleController();
                    r.setRectangle("rectangle",name,x,y,length,height, color);
                    break;
                }
            }
        }catch(Exception e) {
            System.err.println(e);
        }
        //if the default position were used we need to change them for next shape
        //because otherwise next shape will be drawn on the top of this shape
        if(!flagX)x+=40;
        else if(!flagY)y+=40;
        //
    }
    //converting string to color
    public Color toColor(String s){
        Color c=Color.valueOf(s);
        return c;
    }
    //


    public void mouseEnter(MouseEvent event) {
        if (event.getSource().equals(choosefile)) {
            choosefile.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(shapes)) {
            shapes.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(save)) {
            save.setStyle("-fx-opacity: 1");
        }
        if(event.getSource().equals(drawnshapes)){
            drawnshapes.setStyle("-fx-opacity: 1");
        }
    }
    public void mouseExit(MouseEvent event) {
        if (event.getSource().equals(choosefile)) {
            choosefile.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(shapes)) {
            shapes.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(save)) {
            save.setStyle("-fx-opacity: 0.85");
        }
        if(event.getSource().equals(drawnshapes)){
            drawnshapes.setStyle("-fx-opacity: 0.85");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}