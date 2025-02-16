package ru.naburnm8.framelistener.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FrameData {
    private long timestamp;
    private byte[] frame;
    private String name;

    public FrameData(long timestamp, byte[] frame, String name) {
        this.timestamp = timestamp;
        this.frame = frame;
        this.name = name;
    }
}
