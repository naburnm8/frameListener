package ru.naburnm8.framelistener.data.db;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProcessedDataRepository extends JpaRepository<ProcessedData, Long> {
    public Optional<List<ProcessedData>> findByName(String name);
}
