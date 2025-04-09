package fr.iut.androidprojet.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionReponseDao {

    @Query("SELECT * FROM question_reponse ORDER BY id")
    List<QuestionReponse> getAll();

    @Insert
    long insert(QuestionReponse questionReponse);

    @Insert
    long[] insertAll(QuestionReponse... questionReponses);

    @Delete
    void delete(QuestionReponse questionReponse);

    @Update
    void update(QuestionReponse questionReponse);

    /////////////////////////////////////////////////////
    // Requêtes
    /////////////////////////////////////////////////////

    // Récupérer un nombre donné de questions (de type donné) au hasard dans la base de données
    @Query("SELECT * FROM question_reponse WHERE typeQuestion = :typeQuestions ORDER BY RANDOM() LIMIT :nbQuestions")
    List<QuestionReponse> getQuestions(String typeQuestions, int nbQuestions);

}
