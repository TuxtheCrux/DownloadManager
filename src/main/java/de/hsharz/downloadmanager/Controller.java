package de.hsharz.downloadmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements PropertyChangeListener {
    @FXML
    private ListView<Download> listURL;
    @FXML
    private TextField tF;


    @FXML
    private void onDownloadClick(ActionEvent event){
        try {
            if (!tF.getText().isEmpty() && !tF.getText().equals("Please Enter URL")) {
                Download newDownload = new Download(tF.getText());
                newDownload.addPropertyChangeListener(this);
                listURL.getItems().add(newDownload);
                tF.clear();
            } else {
                System.out.println("URL field is empty. Please enter a valid URL.");
            }
        } catch(Exception ex){
            System.err.println("An error occurred while processing the download: " + ex.getMessage());
        }

    }

    @FXML
    private void onTextFieldClick(ActionEvent event){
        if(tF.getText().equals("Please Enter URL")){
            tF.clear();
        }
    }

    @FXML
    protected void onListViewKeyPressed(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.DELETE) || keyEvent.getCode().equals(KeyCode.BACK_SPACE)) {
            List<Download> selectedItems = new ArrayList<>(listURL.getSelectionModel().getSelectedItems());

            for (Download selectedDownload : selectedItems) {
                if (selectedDownload != null) {
                    selectedDownload.removePropertyChangeListener(this);

                    if (selectedDownload.downloadThread != null && selectedDownload.downloadThread.isAlive()) {
                        selectedDownload.downloadThread.interrupt();
                    }
                    listURL.getItems().remove(selectedDownload);
                }
            }
            listURL.getSelectionModel().clearSelection();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
       if("finishedDownload".equals(evt.getPropertyName()) && evt.getNewValue().equals(true)){
           Download finishedDownload = (Download) evt.getSource();
           finishedDownload.removePropertyChangeListener(this);
           listURL.getItems().remove(finishedDownload);
       }
    }


}