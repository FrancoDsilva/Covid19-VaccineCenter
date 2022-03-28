package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

    @FXML
    TextField nameTextField,nameTextField1,nameTextField2,nameTextField3,nameTextField4,nameTextField5,nameTextField6;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException {

        String username = nameTextField.getText();
        String username1 = nameTextField1.getText();
        String username2 = nameTextField2.getText();
        String username3 = nameTextField3.getText();
        String username4 = nameTextField4.getText();
        String username5 = nameTextField5.getText();
        String username6 = nameTextField6.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(username);
        Scene2Controller scene2Controller1 = loader.getController();
        scene2Controller.displayName1(username1);
        Scene2Controller scene2Controller2 = loader.getController();
        scene2Controller.displayName2(username2);
        Scene2Controller scene2Controller3 = loader.getController();
        scene2Controller.displayName3(username3);
        Scene2Controller scene2Controller4 = loader.getController();
        scene2Controller.displayName4(username4);
        Scene2Controller scene2Controller5 = loader.getController();
        scene2Controller.displayName5(username5);
        Scene2Controller scene2Controller6 = loader.getController();
        scene2Controller.displayName6(username6);


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();





    }

}