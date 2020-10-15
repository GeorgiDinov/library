package com.georgidinov.service;

import com.georgidinov.repository.BorrowRecordRepository;
import com.georgidinov.repository.BorrowRequestRepository;

//todo implement logic
public class RecordService {

    private BorrowRecordRepository borrowRecordRepository;
    private BorrowRequestRepository borrowRequestRepository;

    public RecordService(BorrowRecordRepository borrowRecordRepository,
                         BorrowRequestRepository borrowRequestRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.borrowRequestRepository = borrowRequestRepository;
    }

}
