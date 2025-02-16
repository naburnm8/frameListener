package ru.naburnm8.framelistener.data;

import ru.naburnm8.framelistener.data.db.ProcessedData;

import java.util.ArrayList;
import java.util.Arrays;


public class FrameProcessor {
    public static ProcessedData processFrame(FrameData frameData) {

        int binSize = frameData.getFrame().length / 4;
        ArrayList<Double> valuesList = new ArrayList<>();
        double currentValue = 0.0;
        for (int i = 0; i < frameData.getFrame().length; i++) {
            if ((i != 0 && i % binSize == 0) || i == frameData.getFrame().length - 1) {
                valuesList.add(currentValue);
                currentValue = 0.0;
            }
            else {
                double randomFactor = Math.random();
                currentValue += randomFactor*frameData.getFrame()[i];
            }
        }
        double[] values = valuesList.stream().mapToDouble(Double::doubleValue).toArray();
        System.out.println(Arrays.toString(values));
        return new ProcessedData(frameData.getTimestamp(), values, frameData.getName());
    }
}
