module com.example.statisticallibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.statisticallibrary to javafx.fxml;
    exports com.example.statisticallibrary;
}