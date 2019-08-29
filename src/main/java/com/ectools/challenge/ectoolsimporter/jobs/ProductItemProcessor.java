package com.ectools.challenge.ectoolsimporter.jobs;

import com.ectools.challenge.ectoolsimporter.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<Product, Product> {

    private static final Logger log = LoggerFactory.getLogger(ProductItemProcessor.class);

    @Override
    public Product process(Product product) throws Exception {
        return product;
    }

}
