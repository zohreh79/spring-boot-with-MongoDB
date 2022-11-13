package com.mongoDB.repository;

import com.mongoDB.domain.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<Notes, String> {

    Notes findByTitle(String title);

}
