package com.ectools.challenge.ectoolsimporter.models;

import java.io.Serializable;

public class Product implements Serializable {

    private String uuid;
    private String name;
    private String description;
    private String provider;
    private boolean available;
    private String unitOfMeasurement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }


    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", available=" + available +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                '}';
    }
}
