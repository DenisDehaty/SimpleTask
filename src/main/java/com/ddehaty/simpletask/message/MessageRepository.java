package com.ddehaty.simpletask.message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("SELECT count(id) as count from Message")
    int countAllMessages();

    @Query("SELECT distinct origin from Message")
    List<String> getDistinctOrigins();

    @Query("SELECT distinct destination from Message")
    List<String> getDistinctDestination();
}