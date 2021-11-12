module com.lecteurpdfdoubleaffichage.lecteurpdfdoubleaffichage {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;


    opens com.lecteurpdfdoubleaffichage.lecteurpdfdoubleaffichage to javafx.fxml;
    exports com.lecteurpdfdoubleaffichage.lecteurpdfdoubleaffichage;
}