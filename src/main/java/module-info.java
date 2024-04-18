module mathou {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens mathou to javafx.fxml;
    exports mathou;
}