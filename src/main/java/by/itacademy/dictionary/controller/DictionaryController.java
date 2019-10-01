package by.itacademy.dictionary.controller;

import by.itacademy.dictionary.model.Word;
import by.itacademy.dictionary.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping(path = "/sql")
    public ResponseEntity<List<Word>> getBySQL() {
        return ResponseEntity.ok(dictionaryService.getBySQL());
    }

    @GetMapping(path = "/java")
    public ResponseEntity<Set<Word>> getByJava() {
        return ResponseEntity.ok(dictionaryService.getByJava());
    }
}
