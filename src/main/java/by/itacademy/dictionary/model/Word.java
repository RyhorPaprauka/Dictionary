package by.itacademy.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Word implements Comparable<Word> {

    private String word;
    private Integer meaning;


    @Override
    public int compareTo(Word o) {
        return word.compareTo(o.word);
    }
}
