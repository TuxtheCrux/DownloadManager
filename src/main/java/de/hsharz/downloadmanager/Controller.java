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


    @FXML
    private void onDownloadClick(ActionEvent event){
        try {
            if (!tF.getText().isEmpty()) {
                listURL.getItems().add(new Download(tF.getText()));
            } else {
                System.out.println("URL field is empty. Please enter a valid URL.");
            }
            for (int i = 0; i < listURL.getItems().size(); i++) {
                Download tmpDownloadItem = listURL.getItems().get(i);
                tmpDownloadItem.addPropertyChangeListener(e -> {
                    if (e.getNewValue().equals(true)) {
                        listURL.getItems().remove(tmpDownloadItem);
                    }
                });
            }
        } catch(Exception ex){
            System.err.println("An error occurred while processing the download: " + ex.getMessage());
        }

    }

    @FXML
    private void onTextFieldClick(ActionEvent event){
    }


}
