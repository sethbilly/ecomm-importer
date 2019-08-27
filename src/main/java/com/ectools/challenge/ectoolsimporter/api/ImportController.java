package com.ectools.challenge.ectoolsimporter.api;

import com.ectools.challenge.ectoolsimporter.models.Product;
import com.ectools.challenge.ectoolsimporter.utils.CsvJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImportController {

    /**
     * Using the JMS broker to send message to all listeners
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/import-csv")
    @ResponseBody
    public String serializeCsvToJson(
            @RequestParam(value = "file") MultipartFile csv) {
        try {
            byte[] bytes = csv.getBytes();
            List<Product> productList = CsvJsonConverter.convert(bytes);
            if (productList.isEmpty()) {
                return "Error occurred parsing csv file, upload not successful";
            }
            jmsTemplate.convertAndSend("ProductTransactionQueue", productList);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return "CSV file parsed and uploaded successfully...Product list sent to transaction queue";
    }


}
