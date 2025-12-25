package com.example;

import javafx.fxml.*;
import javafx.scene.control.TextArea;

import javafx.application.*;


@SuppressWarnings("unused")


public class termsandconditionscontroller {


    @FXML  private TextArea termsTextArea ;


    @FXML public void initialize()
    {
        termsTextArea.setText( 


"""
        TERMS AND CONDITIONS

        1. Introduction
        By registering, you agree to these terms.

        2. User Eligibility
        You must be 18 years or older.

        3. Account Responsibility
        You are responsible for maintaining confidentiality.

        4. Data Usage
        Your data will be used only for application purposes.

        5. Prohibited Activities
        Misuse of the application is prohibited.

        6. Termination
        Accounts may be suspended for violations.

        7. Changes to Terms
        Terms may change without notice.

        8. Contact
        Email: support@example.com
        
        """


        );

    }



    
}
