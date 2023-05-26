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
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class RectangleController extends ShapeHelper implements Initializable {
    public TextField height;
    public TextField width;
	public static Stage newWindow=null;
    protected Rectanglee rectangle;
	private String thisName;
    protected Double x,y,w,h;
    protected Color c;
    String type;
	Stage stage=new Stage();
	Stage changes=new Stage();

	public void onRectangleButton(ActionEvent event) {
        if (event.getSource().equals(drawBTN)){
            try{
                setRectangle("rectangle",name.getText(),Double.parseDouble(positionX.getText()),Double.parseDouble(positionY.getText()),Double.parseDouble(width.getText()),Double.parseDouble(height.getText()),color.getValue());
            }
            catch (NumberFormatException e){
            }
            finally {
                ShapesController.newWindow5.hide();
            }
        }
    }
    public void setRectangle(String type,String name,Double x,Double y,Double width,Double height,Color c) {
    	thisName=name;
    	this.x=x;
    	this.y=y;
    	w=width;
    	h=height;
    	this.c=c;
    	this.type=type;
        rectangle=new Rectanglee(type,name,x,y,width,height,c);
        rectangle.setFill(c);
     	 setStage();
        draw();
    }
	@Override
	public void draw() {
		App.root.getChildren().add(rectangle);
	}
	@Override
	public void remove(){
		stage.hide();
		App.root.getChildren().remove(rectangle);
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
				Label radiusXLbl = new Label(h.toString());
				radiusXLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
				Label RXLbl = new Label("Height :");
				RXLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
				Label radiusYLbl = new Label(w.toString());
				radiusYLbl.setStyle("-fx-font-family: 'Bodoni MT Black'");
				Label RYLbl = new Label("Width :");
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
							VBox vBox2;
							TextField RYF=new TextField(w.toString());
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
							TextField RXF=new TextField(h.toString());
							RXF.getStylesheets().add("file:src/Graphics/css/Circle.css");
							RXF.getStyleClass().add("txtfield");
							//if it's a square there is no need to have both height and width
							if(rectangle.getType().equalsIgnoreCase("rectangle")) {
								vBox2=new VBox(namelabel,RXF,RYF,PXF,PYF,colorPicker);

							}
							else vBox2=new VBox(namelabel,RYF,PXF,PYF,colorPicker);

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
										h=Double.parseDouble(RXF.getText());
										w=Double.parseDouble(RYF.getText());
										c=colorPicker.getValue();
										setRectangle("rectangle",thisName,x,y,h,w,c);//,Double.parseDouble(positionY.getText()),Double.parseDouble(radiusX.getText()),Double.parseDouble(radiusY.getText()),color.getValue());
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
							changes.setScene(new Scene(root1));
							changes.setResizable(false);
							changes.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
							changes.show();
							remove();
						}
					});
					VBox vBox2=new VBox(hBox,chng,rem);
					vBox2.setAlignment(Pos.CENTER);
					root.getChildren().add(vBox2);
					stage.setScene(new Scene(root));
					stage.show();
					stage.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
					stage.setResizable(false);
				}
				catch (Exception exe){
					exe.printStackTrace();
				}
				newWindow = new Stage();
				newWindow.setTitle(rectangle.getType());
				newWindow.setScene(root.getScene());
				newWindow.initModality(Modality.WINDOW_MODAL);
				newWindow.initOwner(App.scene.getWindow());
				// Set position of second window,   related to primary window.
				newWindow.setX(90);
				newWindow.setY(65);
				newWindow.setResizable(false);
				newWindow.getIcons().add(new Image("file:src/Graphics/icon/icon.png.png"));
				newWindow.show();
			}
		};
		System.out.println("try 9");
		rectangle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}


class Rectanglee extends Rectangle{
	final private String name;
	final private String type;
	public Rectanglee(String type,String name,Double x,Double y,Double l1,Double l2,Color c) {
		super(x,y,l1,l2);
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

