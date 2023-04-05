module com.example.uml_tool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.codec;
    requires java.desktop;


    opens com.example.uml_tool to javafx.fxml;
    exports com.example.uml_tool;



    /*javafx{
            modules=['javafx.controls','javafx.graphics','javafx.swing','javafx.base']
        }*/
}
