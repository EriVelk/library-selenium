package org.example.utils;

import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Constants {
    public static String pathImg = System.getProperty("user.dir").concat("\\src\\main\\resources\\img\\");
    public static String pathSaveDocument = System.getProperty("user.dir").concat("\\src\\main\\resources\\documents\\");
    public static String fontArial = "Arial";
    public static String folderSuccess = "success";
    public static String folderError = "error";
    public static String assertionError = "Assertion Error";
    public static String timestamp = String.valueOf(new Date().toInstant().toEpochMilli());
    public static String titleErrors = "Errors";
    public static String titleDate = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    public static String titleTime = LocalTime.now().toString();
}
