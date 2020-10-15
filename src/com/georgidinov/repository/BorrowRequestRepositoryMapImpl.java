package com.georgidinov.repository;

import com.georgidinov.domain.record.BorrowRequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class BorrowRequestRepositoryMapImpl {

    private static Map<Integer, BorrowRequest> borrowRequestMap = new HashMap<>();

    public void add(BorrowRequest borrowRequest) {
        borrowRequestMap.put(borrowRequest.getId(), borrowRequest);
    }

    public Optional<BorrowRequest> findById(int id) {
        return Optional.of(borrowRequestMap.get(id));
    }

    public Set<BorrowRequest> findAll() {
        return new HashSet<>(borrowRequestMap.values());
    }

    public Set<BorrowRequest> findAllActive() {
        return borrowRequestMap.values()
                .stream()
                .filter(BorrowRequest::isActive)
                .collect(Collectors.toSet());
    }

    public List<BorrowRequest> findAllSortedOnDueDateASC() {
        List<BorrowRequest> borrowRequests = new ArrayList<>(this.findAllActive());
        borrowRequests.sort(Comparator.comparing(BorrowRequest::getReservationDueDate));
        return borrowRequests;
    }

    public Set<BorrowRequest> findAllByReaderId(int readerId) {
        Set<BorrowRequest> borrowRequests = new HashSet<>();
        borrowRequestMap.values()
                .stream()
                .filter(borrowRequest -> borrowRequest.getReaderId() == readerId)
                .forEach(borrowRequests::add);
        return borrowRequests;
    }

    public Set<BorrowRequest> findAllByBookId(int bookId) {
        Set<BorrowRequest> borrowRequests = new HashSet<>();
        borrowRequestMap.values()
                .stream()
                .filter(borrowRequest -> borrowRequest.getBookId() == bookId)
                .forEach(borrowRequests::add);
        return borrowRequests;
    }

    public int size() {
        return borrowRequestMap.size();
    }

}
