module de.hsharz.downloadmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.hsharz.downloadmanager to javafx.fxml;
    exports de.hsharz.downloadmanager;
}