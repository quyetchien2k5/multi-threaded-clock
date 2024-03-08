package Controller;

import View.View_clock;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;



public class Clock extends Thread{

    public Button print_button;
    public TextField time_zone;
    public Label time;
    public View_clock view_clock;
    @FXML
    public Label time2;
    public String time3;
    public String formattedTime1;


    public void updateClock(){
        new Thread(() -> {
            // Load FXML mới và hiển thị nó

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (!time_zone.getText().isEmpty()) {
                try {

                    ZoneOffset zoneOffset = ZoneOffset.ofHours( Integer.parseInt(time_zone.getText()));

                    LocalDateTime localDateTime = LocalDateTime.now(zoneOffset);
                    OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss O");
                    String formattedTime = offsetDateTime.format(formatter);

                    // Cập nhật UI trên Luồng Ứng dụng JavaFX
                    Platform.runLater(() -> time.setText(formattedTime));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }else{
                time.setText("00:00:00");
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
            }).start();
    }

    public void print(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Clock_after.fxml"));
        Parent newRoot = null;
        try {
            newRoot = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage newStage = new Stage();
            Scene scene = new Scene(newRoot);
            newStage.setScene(scene);
            newStage.show();
            Clock controller = loader.getController();
        new Thread(() -> {
           ZoneOffset zoneOffset = ZoneOffset.ofHours(Integer.parseInt(time_zone.getText()));
          Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {


                LocalDateTime localDateTime = LocalDateTime.now(zoneOffset);
                OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss O");
                formattedTime1 = offsetDateTime.format(formatter);
              Platform.runLater(() -> controller.time2.setText(formattedTime1));
              System.out.println("luong "+ zoneOffset);
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();

        }).start();
    }

    public void getClock(View_clock viewClock) {
        this.view_clock = viewClock;
    }
}
