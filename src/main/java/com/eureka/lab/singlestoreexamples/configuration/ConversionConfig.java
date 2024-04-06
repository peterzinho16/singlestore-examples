package com.eureka.lab.singlestoreexamples.configuration;

import com.eureka.lab.singlestoreexamples.converter.LocalDateToLocalDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.MySqlDialect;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConversionConfig {

    @Bean
    public R2dbcCustomConversions r2dbcCustomConversionsForDateTime() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new LocalDateToLocalDateTimeConverter());
        return R2dbcCustomConversions.of(MySqlDialect.INSTANCE, converters);
    }
}