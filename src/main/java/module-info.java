module de.hsharz.downloadmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens de.hsharz.downloadmanager to javafx.fxml;
    exports de.hsharz.downloadmanager;
}