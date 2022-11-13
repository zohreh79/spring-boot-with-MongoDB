package com.mongoDB.controller;

import com.mongoDB.domain.Notes;
import com.mongoDB.model.AddOrUpdate;
import com.mongoDB.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/note")
public class NotesController {

    //postman collection link: https://www.getpostman.com/collections/c8d2ec5fa0cd43e02d5f

    @Autowired
    NotesRepository notesRepository;

    @PostMapping()
    private ResponseEntity<String> addNotes(@RequestBody AddOrUpdate addOrUpdateNote) {
        Notes notes = notesRepository.findByTitle(addOrUpdateNote.getTitle());
        if (notes == null) {
            Notes newNote = new Notes(addOrUpdateNote.getTitle(), addOrUpdateNote.getText(), System.currentTimeMillis() / 1000);
            notesRepository.insert(newNote);
            return ResponseEntity.ok("note saved.");
        } else return new ResponseEntity<>("a note has been defined with this title!", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping()
    private ResponseEntity<?> getNoteWithSubject(@RequestParam(value = "title") String title) {
        Notes notes = notesRepository.findByTitle(title);
        if (notes == null) {
            return new ResponseEntity<>("note not found", HttpStatus.NOT_FOUND);
        } else return ResponseEntity.ok(notes);
    }

    @GetMapping(path = "/all")
    private ResponseEntity<?> getAllNotes() {
        return ResponseEntity.ok(notesRepository.findAll());
    }

    @DeleteMapping()
    private ResponseEntity<String> deleteNote(@RequestParam(value = "title") String title) {
        Notes notes = notesRepository.findByTitle(title);
        if (notes == null) {
            return new ResponseEntity<>("note not found", HttpStatus.NOT_FOUND);
        } else {
            notesRepository.delete(notes);
            return ResponseEntity.ok("note deleted successfully.");
        }
    }

}
