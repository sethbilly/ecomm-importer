package com.ectools.challenge.ectoolsimporter.api;

import com.ectools.challenge.ectoolsimporter.models.Product;
import com.ectools.challenge.ectoolsimporter.utils.CsvJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImportController {

    @Autowired private JmsTemplate jmsTemplate;

    @PostMapping("/import-csv")
    public String serializeCsvToJson(
            @RequestParam(value = "file")MultipartFile csv) {
        try {
            byte[] bytes = csv.getBytes();
            CsvJsonConverter.convert(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
