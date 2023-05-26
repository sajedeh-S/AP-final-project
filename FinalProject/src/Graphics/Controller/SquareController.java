package Graphics.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SquareController extends RectangleController {

    public TextField sidelength;
    Stage stage=new Stage();
    public void onSquareButton(ActionEvent event) {
        if (event.getSource().equals(drawBTN)){
            try{
                setSquare(name.getText(),Double.parseDouble(positionX.getText()),Double.parseDouble(positionY.getText()),Double.parseDouble(sidelength.getText()),color.getValue());

            }
            catch (NumberFormatException e){

            }
            finally {
                ShapesController.newWindow4.hide();
            }
        }
    }

    public void setSquare(String name,Double x,Double y,Double length,Color c) {
        setRectangle("square",name,x,y,length,length,c);
    }

}
