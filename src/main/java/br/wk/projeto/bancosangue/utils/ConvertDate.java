package br.wk.projeto.bancosangue.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ConvertDate {

    static public String convertDate(String date) {
        return date.substring(6, 10) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2);
    }

    static public LocalDate convertToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        formatter = formatter.withLocale( Locale.US );
       return LocalDate.parse(date, formatter);
    }
}
