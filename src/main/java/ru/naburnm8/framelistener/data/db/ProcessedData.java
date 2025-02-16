package ru.naburnm8.framelistener.data.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ProcessedData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long timestamp;
    private String name;
    private double value1;
    private double value2;
    private double value3;
    private double value4;

    public ProcessedData(long timestamp, double[] values, String name) {
        this.timestamp = timestamp;
        this.name = name;
        if (values.length < 4) {
            throw new IllegalArgumentException("Not enough values");
        }
        this.value1 = values[0];
        this.value2 = values[1];
        this.value3 = values[2];
        this.value4 = values[3];
    }

    public ProcessedData(long timestamp, double value1, double value2, double value3, double value4, String name) {
        this.timestamp = timestamp;
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public ProcessedData() {
    }
}
