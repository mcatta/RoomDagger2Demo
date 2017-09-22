package eu.marcocattaneo.roomdagger2.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import eu.marcocattaneo.roomdagger2.data.Product;
import eu.marcocattaneo.roomdagger2.data.ProductDao;

@Database(entities = {Product.class}, version = DemoDatabase.VERSION)
public abstract class DemoDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract ProductDao getProductDao();

}
