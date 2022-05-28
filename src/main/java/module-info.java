module stage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports stage;
    opens stage to javafx.fxml;
}