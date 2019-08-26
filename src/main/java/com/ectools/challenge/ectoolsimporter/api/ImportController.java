package com.ectools.challenge.ectoolsimporter.api;

import com.ectools.challenge.ectoolsimporter.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ImportController {

    @PostMapping("/import")
    public List<Product> serializeCsvToJson(
            @Valid Product product,
            @RequestParam(value = "file")MultipartFile csv) {
        return null;
    }


}
