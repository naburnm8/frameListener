package ru.naburnm8.framelistener.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.naburnm8.framelistener.data.db.ProcessedData;


@Service
public class ProcessedDataSender {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${mainServiceUrl}")
    private String mainServiceUrl;

    public void sendProcessedFrame(ProcessedData processedData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessedData> request = new HttpEntity<>(processedData, headers);
        restTemplate.postForObject(mainServiceUrl, request, String.class);
    }
}
