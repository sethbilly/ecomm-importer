package com.ectools.challenge.ectoolsimporter.utils;

import com.ectools.challenge.ectoolsimporter.models.Product;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {

    @Override
    public Product mapFieldSet(FieldSet fieldSet) throws BindException {

        Product mappedProduct = new Product();
        mappedProduct.setUuid(fieldSet.readString("Uuid"));
        mappedProduct.setName(fieldSet.readString("Name"));
        mappedProduct.setDescription(fieldSet.readString("Description"));
        mappedProduct.setProvider(fieldSet.readString("provider"));
        mappedProduct.setAvailable(fieldSet.readBoolean("available"));
        mappedProduct.setUnitOfMeasurement("MeasurementUnits");
        return mappedProduct;
    }
}
