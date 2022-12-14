package com.application.utility;

import com.application.controllers.DialogBoxController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogBox {

    public static final int ERROR_DIALOG_BOX = 1;
    public static final int INFORMATION_DIALOG_BOX = 2;
    public static final int WARNING_DIALOG_BOX = 3;
    public static final int SUCCESS_DIALOG_BOX = 4;

    public static void showDialogue(String heading, String subtitle, int type) {
        try {
            Stage dialogBox = new Stage();
            FXMLLoader loader = new FXMLLoader(DialogBoxController.class.getResource("dialog-box.fxml"));

            Parent root = loader.load();

            ((Label) root.lookup("#heading")).setText(heading);
            ((Label) root.lookup("#subtitle")).setText(subtitle);

            if (type == ERROR_DIALOG_BOX) {
                dialogBox.setTitle("Error");
                ((ImageView) root.lookup("#imageViewID")).setImage(new Image("file:Client/src/main/resources/icons/error.png"));
                dialogBox.getIcons().add(new Image("file:Client/src/main/resources/icons/error.png"));
            } else if (type == INFORMATION_DIALOG_BOX) {
                dialogBox.setTitle("Information");
                ((ImageView) root.lookup("#imageViewID")).setImage(new Image("file:Client/src/main/resources/icons/information.png"));
                dialogBox.getIcons().add(new Image("file:Client/src/main/resources/icons/information.png"));
            } else if (type == WARNING_DIALOG_BOX) {
                dialogBox.setTitle("Warning");

                ((ImageView) root.lookup("#imageViewID")).setImage(new Image("file:Client/src/main/resources/icons/warning.png"));
                dialogBox.getIcons().add(new Image("file:Client/src/main/resources/icons/warning.png"));
            } else if (type == SUCCESS_DIALOG_BOX) {
                dialogBox.setTitle("Success");

                ((ImageView) root.lookup("#imageViewID")).setImage(new Image("file:Client/src/main/resources/icons/success.png"));
                dialogBox.getIcons().add(new Image("file:Client/src/main/resources/icons/success.png"));
            }

            Scene scene = new Scene(root);
            dialogBox.centerOnScreen();
            dialogBox.setAlwaysOnTop(true);
            dialogBox.setScene(scene);

            dialogBox.setResizable(false);
            dialogBox.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// Project Finished on Mon Jan 2 2023 15:30:00 GMT+0600 (Bangladesh Standard Time)
