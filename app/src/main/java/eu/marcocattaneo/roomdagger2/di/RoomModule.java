package eu.marcocattaneo.roomdagger2.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.marcocattaneo.roomdagger2.data.ProductDao;
import eu.marcocattaneo.roomdagger2.repository.DemoDatabase;
import eu.marcocattaneo.roomdagger2.repository.ProductDataSource;
import eu.marcocattaneo.roomdagger2.repository.ProductRepository;

@Module
public class RoomModule {

    private DemoDatabase demoDatabase;

    public RoomModule(Application mApplication) {
        demoDatabase = Room.databaseBuilder(mApplication, DemoDatabase.class, "demo-db").build();
    }

    @Singleton
    @Provides
    DemoDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Singleton
    @Provides
    ProductDao providesProductDao(DemoDatabase demoDatabase) {
        return demoDatabase.getProductDao();
    }

    @Singleton
    @Provides
    ProductRepository productRepository(ProductDao productDao) {
        return new ProductDataSource(productDao);
    }

}
