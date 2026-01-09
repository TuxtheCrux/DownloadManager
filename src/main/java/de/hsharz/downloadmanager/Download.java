package de.hsharz.downloadmanager;

import javafx.application.Platform;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Download {
    protected PropertyChangeSupport support;
    protected Thread downloadThread;
    protected String downloadURL;

    public Download(String url){
        this.downloadURL = url;
        this.support = new PropertyChangeSupport(this);
        startThread();
    }

    public void downloadingURL(){
        try {
            Thread.sleep(1000);
            Platform.runLater(() ->
                    support.firePropertyChange("finishedDownload", false, true )
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void startThread(){
        downloadThread = new Thread(this::downloadingURL);
        System.out.println("Download started for URL: " + downloadURL);
        downloadThread.start();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
    }




    @Override
    public String toString(){
        return downloadURL;
    }
}
