package eu.marcocattaneo.roomdagger2.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import eu.marcocattaneo.roomdagger2.data.ProductDao;
import eu.marcocattaneo.roomdagger2.repository.DemoDatabase;
import eu.marcocattaneo.roomdagger2.repository.ProductRepository;
import eu.marcocattaneo.roomdagger2.view.MainActivity;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    ProductDao productDao();

    DemoDatabase demoDatabase();

    ProductRepository productRepository();

    Application application();

}
