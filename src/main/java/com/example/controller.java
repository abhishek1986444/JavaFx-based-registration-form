package com.example;

import java.sql.SQLException;

import java.sql.*;

import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TextField;


import javafx.scene.control.PasswordField ;

import javafx.scene.control.Alert;


import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;




@SuppressWarnings(  "unused" )




public class controller {

// ----------------- fxml fields  - ------



    @FXML  private TextField useridField;

    @FXML private TextField usernameField ;


    @FXML private TextField mailField ;

    @FXML private PasswordField passwordField ;

    @FXML private  CheckBox termsCheckBox ; 

    @FXML private Label statusLabel ; // needed review 



    private struct object ;


public  controller () throws Exception{

    DBconnection connection = new DBconnection() ;

    object = connection.getConnection();



}
 


public  void  register() throws SQLException  // add register function in the controller.java file 

 
{

 String user_id = useridField.getText().trim();


String mail_id = mailField.getText().trim() ; 




String password = passwordField.getText().trim();





String username = usernameField.getText().trim() ;






// code for the status label 

    termsCheckBox.getStyleClass().remove("error-checkbox"); // reset

    

    if (useridField.getText().isEmpty()
            || usernameField.getText().isEmpty()
            || mailField.getText().isEmpty()
            || passwordField.getText().isEmpty()) {

        showError("All fields are required ❌");
        return;
    }

if ( !termsCheckBox.isSelected())
{
System.out.println("User doesn't selected checkbox");

    termsCheckBox.getStyleClass().add("error-checkbox"); // highlight

    showError("You must agree to the Terms and Conditions to register.");

    passwordField.clear();

password = "" ;
return ;

}

System.out.println( " User name " + username);


System.out.println( "User Id  " + user_id);


System.out.println(  "mail id " + mail_id);



    // If everything is valid
    showSuccess("Registration successful ✔");


    // 



String userinput = " insert into userrecord (userid , mailid , password, username ) values ( ?, ? , ?  , ? )  ;   " ; 

PreparedStatement ps = object.connection.prepareStatement(userinput);




ps.setString( 1,user_id );
ps.setString( 2,mail_id);

ps.setString( 3, password);

ps.setString( 4, username );


System.out.println(ps.executeUpdate());

ps.close();

object.connection.close();



}


// need review 



private void showSuccess(String message) {
    statusLabel.setText(message);
    statusLabel.setVisible(true);
    statusLabel.getStyleClass().removeAll("status-error");
    statusLabel.getStyleClass().addAll("status-label", "status-success");
}

private void showError(String message) {
    statusLabel.setText(message);
    statusLabel.setVisible(true);
    statusLabel.getStyleClass().removeAll("status-success");
    statusLabel.getStyleClass().addAll("status-label", "status-error");
}

// 

    
}



