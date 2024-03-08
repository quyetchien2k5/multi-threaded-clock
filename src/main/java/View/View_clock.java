package View;

import Controller.Clock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class View_clock extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader clock = new FXMLLoader(getClass().getResource("Clock.fxml"));
        Parent clockfxml = clock.load();
        Clock controller = clock.getController();
        controller.getClock(this);
        Scene scene = new Scene(clockfxml, 375, 244);

        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
        controller.updateClock();
    }


    public static void main(String[] args) {
        launch(args);
    }
}