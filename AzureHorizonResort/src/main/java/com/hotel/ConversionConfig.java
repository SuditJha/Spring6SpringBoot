package com.hotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.HashMap;
import java.util.Map;

// Don't Change the given code

@Configuration
public class ConversionConfig {

    @Bean
    public GenericConversionService conversionService() {
        GenericConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToMapConverter());
        return conversionService;
    }

    // Custom converter for converting String to Map
    private static class StringToMapConverter implements Converter<String, Map<String, Double>> {
        @Override
        public Map<String, Double> convert(String source) {
            // Convert the string to a map
            // Assuming the string is formatted like "{key1=value1, key2=value2, ...}"
            Map<String, Double> map = new HashMap<>();
            String[] pairs = source.substring(1, source.length() - 1).split(", ");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                map.put(keyValue[0], Double.valueOf(keyValue[1]));
            }
            return map;
        }
    }
}
