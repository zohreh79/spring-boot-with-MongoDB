package com.mongoDB.repository;

import com.mongoDB.domain.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<Notes, String> {
}
