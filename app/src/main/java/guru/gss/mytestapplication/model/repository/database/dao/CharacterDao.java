package guru.gss.mytestapplication.model.repository.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import guru.gss.mytestapplication.utils.models.Character;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CharacterDao {

    @Query("SELECT * FROM character")
    Flowable<List<Character>> getAll();

    @Query("SELECT * FROM character WHERE id = :id")
    Single<Character> getById(long id);

    @Insert
    void insert(Character employee);

    @Update
    void update(Character employee);

    @Delete
    void delete(Character employee);

}
