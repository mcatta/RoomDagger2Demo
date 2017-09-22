package eu.marcocattaneo.roomdagger2.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product WHERE id=:id")
    LiveData<Product> findById(int id);

    @Query("SELECT * FROM Product")
    LiveData<List<Product>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Product product);

    @Delete
    int delete(Product product);

}
