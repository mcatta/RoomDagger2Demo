package eu.marcocattaneo.roomdagger2.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import eu.marcocattaneo.roomdagger2.data.Product;
import eu.marcocattaneo.roomdagger2.data.ProductDao;

public class ProductDataSource implements ProductRepository {

    private ProductDao productDao;

    @Inject
    public ProductDataSource(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public LiveData<Product> findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public LiveData<List<Product>> findAll() {
        return productDao.findAll();
    }

    @Override
    public long insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public int delete(Product product) {
        return productDao.delete(product);
    }
}
