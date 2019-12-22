module it.adamgolub.WeaThereAndHere {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.adamgolub.WeaThereAndHere to javafx.fxml;
    exports it.adamgolub.WeaThereAndHere;
}