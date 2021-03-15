module ua.churkin.study.calc_app {
    requires javafx.controls;
    requires javafx.fxml;
	requires exp4j;
	requires javafx.base;

    opens ua.churkin.study.calc_app to javafx.fxml;
    exports ua.churkin.study.calc_app;
}