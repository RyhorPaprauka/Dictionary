package by.itacademy.dictionary.service;

import by.itacademy.dictionary.model.Word;
import by.itacademy.dictionary.repository.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    public List<Word> getBySQL() {
        return dictionaryRepository.getByFullQuery();
    }

    public Set<Word> getByJava() {
        Set<Word> words = new TreeSet<>();
        words.addAll(dictionaryRepository.getFirstTable());
        words.addAll(dictionaryRepository.getSecondTable());
        return words;
    }
}
