package com.ddehaty.simpletask.call;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends CrudRepository<Call, Long> {

    @Query("SELECT count(id) as count from Call")
    int countAllCalls();

    @Query("SELECT distinct origin from Call")
    List<String> getDistinctOrigins();

    @Query("SELECT distinct destination from Call")
    List<String> getDistinctDestination();
}