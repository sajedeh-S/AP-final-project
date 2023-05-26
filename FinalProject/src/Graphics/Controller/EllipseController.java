package Graphics.Controller;

import Graphics.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class EllipseController extends ShapeHelper implements Initializable {
    public TextField radiusX;
    public TextField radiusY;
    public static Stage newWindow=null;
    protected Ellipsee ellipse;
    private String thisName;
    protected Double r1;
    protected Double r2;
    protected Double x,y;
    protected Color c;
    Stage stage=new Stage();
  Stage changes=new Stage();

    public void onEllipseButton(ActionEvent event) {
        if (event.getSource().equals(drawBTN)){
            try{
                setEllipse("ellipse",name.getText(),Double.parseDouble(positionX.getText()),Double.parseDouble(positionY.getText()),Double.parseDouble(radiusX.getText()),Double.parseDouble(radiusY.getText()),color.getValue());
            }
            catch (NumberFormatException e){
            }
            finally {
                ShapesController.newWindow3.hide();
            }
        }
        }
    public void setEllipse(String type,String name,Double x, Double y,Double r1,Double r2,Color c ) {
    	thisName=name;
        this.x=x;
        this.y=y;
        this.r1=r1;
        this.r2=r2;
        this.c=c;
        ellipse=new Ellipsee(type,name,x,y,r1,r2,c);
        setStage();
           draw();
    }
    @Override
    public void draw() {
        App.root.getChildren().add(ellipse);
    }
    @Override
    public void remove(){
        stage.hide();
    	App.root.getChildren().remove(ellipse);
        newWindow.hide();
        }

void setStage() {
      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Label namelabel=new Label(thisName);
                namelabel.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label NLbl = new Label("Name :");
                NLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label radiusXLbl = new Label(r1.toString());
                radiusXLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label RXLbl = new Label("RadiusX :");
                RXLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label radiusYLbl = new Label(r2.toString());
                radiusYLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label RYLbl = new Label("RadiusY :");
                RYLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label posXLbl = new Label(x.toString());
                posXLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label PXLbl = new Label("PositionX :");
                PXLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label posYLbl = new Label(y.toString());
                posYLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label PYLbl = new Label("PositionY :");
                PYLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label colorLbl = new Label(c.toString());
                colorLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                Label CLbl = new Label("Color :");
                CLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
                VBox vBox=new VBox(namelabel,radiusXLbl,radiusYLbl,posXLbl,posYLbl,colorLbl);
                VBox vBox1=new VBox(NLbl,RXLbl,RYLbl,PXLbl,PYLbl,CLbl);
                vBox1.setAlignment(Pos.CENTER);
                vBox1.setSpacing(7);
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(7);
                HBox hBox=new HBox(vBox1,vBox);
                hBox.setAlignment(Pos.TOP_CENTER);
                hBox.setSpacing(25);
                Pane root=new Pane();
                try{
                  Button rem=new Button("Remove");
                    rem.getStylesheets().add("file:src/Graphics/css/Paint.css");
                    rem.getStyleClass().add("remove");
                    rem.setPrefWidth(120);
                  rem.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                          remove();}});
                  Button chng = new Button("Change Details");
                    chng.getStylesheets().add("file:src/Graphics/css/Paint.css");
                    chng.getStyleClass().add("drawnshapes");
                    chng.setPrefWidth(120);
                    Pane root1 = new Pane();
                    chng.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            TextField RXF=new TextField(r1.toString());
                            RXF.getStylesheets().add("file:src/Graphics/css/Circle.css");
                            RXF.getStyleClass().add("txtfield");
                            TextField RYF=new TextField(r2.toString());
                            RYF.getStylesheets().add("file:src/Graphics/css/Circle.css");
                            RYF.getStyleClass().add("txtfield");
                            TextField PXF=new TextField(x.toString());
                            PXF.getStylesheets().add("file:src/Graphics/css/Circle.css");
                            PXF.getStyleClass().add("txtfield");
                            TextField PYF=new TextField(y.toString());
                            PYF.getStylesheets().add("file:src/Graphics/css/Circle.css");
                            PYF.getStyleClass().add("txtfield");
                            ColorPicker colorPicker=new ColorPicker(c);
                            colorPicker.getStylesheets().add("file:src/Graphics/css/Circle.css");
                            colorPicker.getStyleClass().add("txtfield");
                            VBox vBox2=new VBox(namelabel,RXF,RYF,PXF,PYF,colorPicker);
                            vBox2.setAlignment(Pos.CENTER);
                            vBox2.setSpacing(7);
                            HBox hBox1=new HBox(vBox1,vBox2);
                            hBox1.setAlignment(Pos.CENTER);
                            hBox1.setSpacing(20);
                            Button drw=new Button("Draw");
                            drw.getStylesheets().add("file:src/Graphics/css/Circle.css");
                            drw.getStyleClass().add("btn");
                            drw.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try{
                                        x=Double.parseDouble(PXF.getText());
                                        y=Double.parseDouble(PYF.getText());
                                        r1=Double.parseDouble(RXF.getText());
                                        r2=Double.parseDouble(RYF.getText());
                                        c=colorPicker.getValue();
                                        setEllipse("ellipse",thisName,x,y,r1,r2,c);//,Double.parseDouble(positionY.getText()),Double.parseDouble(radiusX.getText()),Double.parseDouble(radiusY.getText()),color.getValue());
                                    }
                                    catch (NumberFormatException e){
                                    }
                                    finally {
                                        changes.hide();
                                    }
                                }
                            });
                            VBox vBox3=new VBox(hBox1,drw);
                            vBox3.setAlignment(Pos.CENTER);
                            root1.getChildren().add(vBox3);
                            changes.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
                            changes.setScene(new Scene(root1));
                            changes.setResizable(false);
                            changes.show();
                            remove();
                        }
                    });
                  VBox vBox2=new VBox(hBox,chng,rem);
                  vBox2.setAlignment(Pos.CENTER);
                    root.getChildren().add(vBox2);
                    stage.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
                    stage.setScene(new Scene(root));
                    stage.show();
                    stage.setResizable(false);
                }
                catch (Exception exe){
                    exe.printStackTrace();
                }
                newWindow = new Stage();
                newWindow.setTitle(ellipse.getType());
                newWindow.setScene(root.getScene());
                newWindow.initModality(Modality.WINDOW_MODAL);
                newWindow.initOwner(App.scene.getWindow());
                // Set position of second window,   related to primary window.
                newWindow.setX(90);
                newWindow.setY(65);
                newWindow.setResizable(false);
                newWindow.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
                newWindow.show();
                System.out.println("try 8");
            }
        };
        System.out.println("try 9");
        ellipse.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
     
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}


class Ellipsee extends Ellipse{
  final private String name;
  final private String type;
  public Ellipsee(String type,String name,Double x,Double y,Double r1,Double r2,Color c) {
    super(x,y,r1,r2);
    super.setFill(c);
    this.name=name;
    this.type=type;
  }

  public String getName() {
    return name;
  }
  public String getType() {
    return type;
  }
  
}
