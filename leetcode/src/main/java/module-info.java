module com.example.leetcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    opens com.example.leetcode to javafx.fxml;
    exports com.example.leetcode;
}