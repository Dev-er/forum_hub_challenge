package com.alura.forum_hub_challenge.configuration;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateAndTimeConfigurations {

    public static LocalDateTime generateDateForNow() {
        var zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

        return zonedDateTime.toLocalDateTime();
    }

    public static String formatToBr(LocalDateTime dateTime) {
        var formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var formattedTime = dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        return formattedDate + " às " + formattedTime;
    }
}
