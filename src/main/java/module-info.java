module it.adamgolub.WeaThereAndHere {
    requires javafx.controls;
    requires javafx.fxml;
    requires owm.japis;
    requires java.sql;
    requires annotations;

    opens it.adamgolub.WeaThereAndHere to javafx.fxml;
    exports it.adamgolub.WeaThereAndHere;
}