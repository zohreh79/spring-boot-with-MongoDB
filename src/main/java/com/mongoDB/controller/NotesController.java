package com.mongoDB.controller;

import com.mongoDB.model.AddOrUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/note")
public class NotesController {


    @PostMapping()
    private ResponseEntity<String> addNotes(@RequestBody AddOrUpdate addOrUpdateNote) {
        System.out.println("addNotes");
        return ResponseEntity.ok("ok");
    }

    @PutMapping()
    private ResponseEntity<String> updateNote(@RequestBody AddOrUpdate addOrUpdateNote) {
        System.out.println("updateNote");
        return ResponseEntity.ok("ok");
    }

    @GetMapping()
    private ResponseEntity<String> getNoteWithSubject(@RequestParam(value = "title") String title) {
        System.out.println("getNoteWithSubject");
        return ResponseEntity.ok("ok");
    }

    @GetMapping(path = "/all")
    private ResponseEntity<String> getAllNotes() {
        System.out.println("getAllNotes");
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping()
    private ResponseEntity<String> deleteNote(@RequestParam(value = "title") String title) {
        System.out.println("deleteNote");
        return ResponseEntity.ok("ok");
    }

}
