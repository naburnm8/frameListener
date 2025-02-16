package ru.naburnm8.framelistener.data.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessedDataService {
    @Autowired
    private ProcessedDataRepository processedDataRepository;

    public ProcessedData saveProcessedData(ProcessedData dataToSave){
        return processedDataRepository.save(dataToSave);
    }

    public List<ProcessedData> getAllProcessedData(){
        return processedDataRepository.findAll();
    }

    public Optional<List<ProcessedData>> getProcessedDataByName(String name){
        return processedDataRepository.findByName(name);
    }

}
