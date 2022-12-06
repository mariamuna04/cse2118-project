// Created by Maria Muna on Nov 16 2022 13:54

package com.application.client;

import com.application.security.Authentication;
import com.application.utils.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SignInController extends Controller {
    @FXML
    private TextField usernameTextField;

    private static final int SIGN_IN_REQUEST = 20;

    private static final int USER_FOUND_FROM_DATABASE = 30;
    @FXML
    private PasswordField passwordTextField;

    public void onSignInListener() throws Exception {
        String email = usernameTextField.getText();
        String password = passwordTextField.getText();

        Socket socket = new Socket("localhost", 8080);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeInt(SIGN_IN_REQUEST);
        dataOutputStream.writeUTF(email);
        dataOutputStream.writeUTF(password);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int response = dataInputStream.readInt();
        if(response == USER_FOUND_FROM_DATABASE) {
            Utility.changeScene(usernameTextField, "home-activity.fxml");
        } else {
//            Utility.showAlert("Error", "User Not Found");
            System.err.println("User Not Found");

        }

    }

    public void onSignIUpListener() throws Exception {
        Utility.changeScene(usernameTextField, "sign-up-activity.fxml");
    }

    public void onAboutUsListener() throws Exception {
        Utility.changeScene(usernameTextField, "about-us-activity.fxml");
    }
}