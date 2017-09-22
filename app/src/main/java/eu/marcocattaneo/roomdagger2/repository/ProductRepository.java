package eu.marcocattaneo.roomdagger2.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import eu.marcocattaneo.roomdagger2.data.Product;

public interface ProductRepository {

    LiveData<Product> findById(int id);

    LiveData<List<Product>> findAll();

    long insert(Product product);

    int delete(Product product);

}
