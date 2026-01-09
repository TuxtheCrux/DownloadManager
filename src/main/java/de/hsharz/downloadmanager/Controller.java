package de.hsharz.downloadmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ListView<Download> listURL;
    @FXML
    private TextField tF;


    /* ToDO
        Implement propertyChange functionality
     */
    @FXML
    private void onDownloadClick(ActionEvent event){

        if (!tF.getText().isEmpty()) {
            listURL.getItems().add(new Download(tF.getText()));
        } else {
            System.out.println("URL field is empty. Please enter a valid URL.");
        }

    }

    @FXML
    private void onTextFieldClick(ActionEvent event){
    }


}
