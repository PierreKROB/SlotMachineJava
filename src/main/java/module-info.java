module mathou {
    requires javafx.controls;
    requires javafx.fxml;

    opens mathou to javafx.fxml;
    exports mathou;
}