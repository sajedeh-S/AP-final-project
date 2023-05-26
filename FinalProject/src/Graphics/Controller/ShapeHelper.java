package Graphics.Controller;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public abstract class ShapeHelper {
    public TextField name;
    public TextField positionX;
    public TextField positionY;
    public ColorPicker color;
    public Button drawBTN;

    public abstract void draw();
    public abstract void remove();

    public void mouseEnter(MouseEvent event){
        if(event.getSource().equals(drawBTN)){
            drawBTN.setStyle("-fx-opacity: 1");
        }
    }
    public void mouseExit(MouseEvent event){
        if(event.getSource().equals(drawBTN)){
            drawBTN.setStyle("-fx-opacity: 0.85");
        }
    }

}
