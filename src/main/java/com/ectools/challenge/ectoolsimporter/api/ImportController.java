package com.ectools.challenge.ectoolsimporter.api;


import java.util.List;
import com.ectools.challenge.ectoolsimporter.models.Product;
import com.ectools.challenge.ectoolsimporter.utils.CsvProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/importer")
public class ImportController {


        @Autowired
        private JmsTemplate jmsTemplate;

    @RequestMapping("/read")
    public String read(@RequestParam(value="file") MultipartFile csv) {
        try {
                byte[] bytes = csv.getBytes();
                List<Product> products = CsvProcessor.convert(bytes);
                if(!products.isEmpty()) {
                        jmsTemplate.convertAndSend("ProductTransactionQueue", products);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "CSV file parsed and uploaded successfully...Product list sent to transaction queue";
    }


}
