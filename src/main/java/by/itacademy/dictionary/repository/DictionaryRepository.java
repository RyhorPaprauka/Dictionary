package by.itacademy.dictionary.repository;

import by.itacademy.dictionary.model.Word;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryRepository {

    private static final String FULL_QUERY = "select dictionary_2.word, dictionary_2.reference_id " +
            "from dictionary_2 left join dictionary_1 " +
            "on dictionary_2.word = dictionary_1.word  where dictionary_1.word is null " +
            "union select * from dictionary_1";
    private static final String FIRST_TABLE_QUERY = "select * from dictionary_1";
    private static final String SECOND_TABLE_QUERY = "select * from dictionary_2";
    private final JdbcTemplate jdbcTemplate;

    public List<Word> getByFullQuery() {
        return jdbcTemplate.query(FULL_QUERY,
                (rs, rowNum) ->
                        new Word(rs.getString("word"),
                                rs.getInt("reference_id")));
    }

    public List<Word> getFirstTable() {
        return jdbcTemplate.query(FIRST_TABLE_QUERY,
                (rs, rowNum) ->
                        new Word(rs.getString("word"),
                                rs.getInt("reference_id")));
    }

    public List<Word> getSecondTable() {
        return jdbcTemplate.query(SECOND_TABLE_QUERY,
                (rs, rowNum) ->
                        new Word(rs.getString("word"),
                                rs.getInt("reference_id")));
    }
}
