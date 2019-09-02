package com.ectools.challenge.ectoolsimporter.utils;

import com.ectools.challenge.ectoolsimporter.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class converts each csv line to a product model
 * Reads each new line as a new product model
 */
public class CsvProcessor {
    /**
     * @param file
     * @return List of products from parsing csv file
     */
    public static List<Product> convert(byte[] file) {
        List<Product> products = new ArrayList<>();
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(bais));
            String productLine = "";
            br.readLine();
            while ((productLine = br.readLine()) != null) {
                if (!productLine.isEmpty()) {
                    String[] data = productLine.split(",");
                    Product product = new Product();
                    product.setUuid(data[0]);
                    product.setName(data[1]);
                    product.setDescription(data[2]);
                    product.setProvider(data[3]);
                    product.setAvailable(data[4]);
                    product.setUnitOfMeasurement(data[5]);
                    products.add(product);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

}
