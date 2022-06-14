module com.example.umltool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.umltool to javafx.fxml;
    exports com.example.umltool;
}