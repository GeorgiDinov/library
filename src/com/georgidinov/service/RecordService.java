package com.georgidinov.service;

import com.georgidinov.repository.BorrowRecordRepository;

//todo implement logic
public class RecordService {

    private BorrowRecordRepository borrowRecordRepository;

    public RecordService(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

}
