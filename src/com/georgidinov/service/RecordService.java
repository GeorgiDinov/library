package com.georgidinov.service;

import com.georgidinov.repository.RecordRepositoryMapImpl;

//todo implement logic
public class RecordService {

    private RecordRepositoryMapImpl recordRepository;

    public RecordService(RecordRepositoryMapImpl recordRepository) {
        this.recordRepository = recordRepository;
    }

}
