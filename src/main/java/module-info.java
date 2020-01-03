module it.adamgolub.WeaThereAndHere {
    requires javafx.controls;
    requires javafx.fxml;
    requires owm.japis;
    requires java.sql;
    requires annotations;
    requires com.google.gson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens it.adamgolub.WeaThereAndHere to javafx.fxml;
    exports it.adamgolub.WeaThereAndHere;
}