package com.ectools.challenge.ectoolsimporter.utils;

import com.ectools.challenge.ectoolsimporter.models.Product;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;


/**
 *  This class converts each csv line to a product model
 *  Reads each new line as a new product model
 */
public class CsvJsonConverter {

    /**
     *
     * @param file
     * @return
     */
    public static boolean convert(byte[] file) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(bais));
            String productLine = "";
            while((productLine = br.readLine()) != null) {
                String[] data = productLine.split(",");
                Product product = new Product();
                product.setUuid(data[0]);
                product.setName(data[1]);
                product.setDescription(data[2]);
                product.setProvider(data[3]);
                product.setAvailable(Boolean.valueOf(data[4]));
                product.setUnitOfMeasurement(data[5]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
