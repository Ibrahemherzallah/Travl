module com.example.travl {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires mysql.connector.java;
    requires com.google.protobuf;
    requires java.desktop;
    opens com.example.travl.controllers;
    opens com.example.travl.models;
    opens com.example.travl to javafx.fxml;
    exports com.example.travl;
    exports com.example.travl.models;
}