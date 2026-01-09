package de.hsharz.downloadmanager;

public class Download {
    Thread downloadThread;
    String downloadURL;

    public Download(String url){
        this.downloadURL = url;
        startThread();
    }

    public void downloadingURL(){
        try {
            Thread.sleep(10_000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void startThread(){
        downloadThread = new Thread(this::downloadingURL);
        downloadThread.start();
    }


    @Override
    public String toString(){
        return downloadURL;
    }
}
