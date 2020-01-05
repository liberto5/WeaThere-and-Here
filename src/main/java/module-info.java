module it.adamgolub.WeaThereAndHere {
    requires owm.japis;
    requires java.sql;
    requires annotations;
    requires com.google.gson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.controlsfx.controls;
    requires javafx.fxml;

    opens it.adamgolub.WeaThereAndHere to javafx.fxml;
    exports it.adamgolub.WeaThereAndHere;
}