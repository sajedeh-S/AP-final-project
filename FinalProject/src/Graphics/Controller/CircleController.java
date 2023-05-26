package Graphics.Controller;

import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CircleController extends EllipseController{
    public TextField radius;

    public void onCircleButton(ActionEvent event) {
        if (event.getSource().equals(drawBTN)) {
            if (positionX.getText() != null && positionY.getText() != null && radius.getText() != null) {
                try {
                    setCircle(name.getText(),Double.parseDouble(positionX.getText()), Double.parseDouble(positionY.getText()), Double.parseDouble(radius.getText()), color.getValue());
                } catch (NumberFormatException e) {

                } finally {
                    ShapesController.newWindow2.hide();
                }
            }
        }
    }

    public void setCircle(String name,Double x, Double y,Double r,Color c) {
        setEllipse("circle",name,x,y,r,r,c);
    }

}
