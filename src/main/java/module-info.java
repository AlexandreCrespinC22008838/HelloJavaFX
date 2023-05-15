module com.example.hello2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hello2 to javafx.fxml;
    exports com.example.hello2;
    exports com.example.partie1;
    exports com.example.partie2;
    exports com.example.partie2.exercice5;
}