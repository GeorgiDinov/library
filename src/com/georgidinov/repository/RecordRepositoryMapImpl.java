package com.georgidinov.repository;

import com.georgidinov.domain.record.Record;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class RecordRepositoryMapImpl {

    private static Map<Integer, Record> recordMap = new HashMap<>();

    public void add(Record record) {
        recordMap.put(record.getId(), record);
    }

    public Set<Record> findAll() {
        return new HashSet<>(recordMap.values());
    }

    public Optional<Record> findById(int id) {
        return Optional.of(recordMap.get(id));
    }

    public Set<Record> findAllByReaderId(int readerId) {
        Set<Record> records = new HashSet<>();
        recordMap.values()
                .stream()
                .filter(record -> record.getReaderId() == readerId)
                .forEach(records::add);
        return records;
    }

    public int size() {
        return recordMap.size();
    }

}
