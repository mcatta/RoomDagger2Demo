package eu.marcocattaneo.roomdagger2.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import eu.marcocattaneo.roomdagger2.R;
import eu.marcocattaneo.roomdagger2.data.Product;
import eu.marcocattaneo.roomdagger2.di.AppModule;
import eu.marcocattaneo.roomdagger2.di.DaggerAppComponent;
import eu.marcocattaneo.roomdagger2.di.RoomModule;
import eu.marcocattaneo.roomdagger2.repository.ProductRepository;

public class MainActivity extends AppCompatActivity {

    @Inject
    public ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);


        productRepository.findAll().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                Toast.makeText(MainActivity.this, String.format("Product size: %s", products.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
