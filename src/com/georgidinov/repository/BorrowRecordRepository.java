package com.georgidinov.repository;

import com.georgidinov.domain.record.BorrowRecord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class BorrowRecordRepository {

    private static Map<Integer, BorrowRecord> recordMap = new HashMap<>();

    public void add(BorrowRecord borrowRecord) {
        recordMap.put(borrowRecord.getId(), borrowRecord);
    }

    public Set<BorrowRecord> findAll() {
        return new HashSet<>(recordMap.values());
    }

    public Optional<BorrowRecord> findById(int id) {
        return Optional.ofNullable(recordMap.get(id));
    }

    public Set<BorrowRecord> findAllByReaderId(int readerId) {
        Set<BorrowRecord> borrowRecords = new HashSet<>();
        recordMap.values()
                .stream()
                .filter(borrowRecord -> borrowRecord.getReaderId() == readerId)
                .forEach(borrowRecords::add);
        return borrowRecords;
    }

    public int size() {
        return recordMap.size();
    }

}
