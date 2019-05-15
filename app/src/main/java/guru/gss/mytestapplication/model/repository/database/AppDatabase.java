package guru.gss.mytestapplication.model.repository.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import guru.gss.mytestapplication.model.repository.database.dao.CharacterDao;
import guru.gss.mytestapplication.utils.models.Character;

@Database(entities = {Character.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();

}
