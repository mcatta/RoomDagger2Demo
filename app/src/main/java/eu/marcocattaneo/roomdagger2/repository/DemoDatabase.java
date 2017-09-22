@Database(entities = {Product.class}, version = DemoDatabase.VERSION)
public abstract class DemoDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract ProductDao getProductDao();

}
