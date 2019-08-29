package com.ectools.challenge.ectoolsimporter;

import com.ectools.challenge.ectoolsimporter.models.ProductMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/**
 * Main entry to application
 */
@SpringBootApplication
public class EctoolsImporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EctoolsImporterApplication.class, args);
    }
}
