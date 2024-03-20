package com.eureka.lab.singlestoreexamples.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ReadingConverter
public class LocalDateToLocalDateTimeConverter implements Converter<LocalDate, LocalDateTime> {

    @Override
    public LocalDateTime convert(LocalDate source) {
        return LocalDateTime.of(source, LocalTime.MIDNIGHT);
    }
}