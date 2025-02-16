package ru.naburnm8.framelistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.framelistener.data.FrameData;
import ru.naburnm8.framelistener.data.FrameProcessor;
import ru.naburnm8.framelistener.data.ProcessedDataSender;
import ru.naburnm8.framelistener.data.db.ProcessedData;
import ru.naburnm8.framelistener.data.db.ProcessedDataService;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {
    @Autowired
    private ProcessedDataService processedDataService;

    @Autowired
    private ProcessedDataSender processedDataSender;

    @PostMapping()
    public void receiveFrame(@RequestBody FrameData frameData) {
        ProcessedData processedData = FrameProcessor.processFrame(frameData);
        processedDataService.saveProcessedData(processedData);
        new Thread(() -> processedDataSender.sendProcessedFrame(processedData)).start();
    }

    @GetMapping()
    public List<ProcessedData> getAllProcessedData() {
        return processedDataService.getAllProcessedData();
    }

    @GetMapping("/name")
    public ResponseEntity<List<ProcessedData>> getAllProcessedDataByName(@RequestParam String name) {
        Optional<List<ProcessedData>> processedData = processedDataService.getProcessedDataByName(name);
        return processedData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
