package myPackage.crudApp;

import myPackage.exception.NullProductException;
import myPackage.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudApp {

    private static SessionFactory factory;

    public static void init(){
        //Application.forcePrepareData();
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void createExample(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product radiaktivniyKartifel = new Product( "Радиоактивынй Картофель", 100500);
            //System.out.println(radiaktivniyKartifel.toString());
            session.save(radiaktivniyKartifel);
            session.getTransaction().commit();
        }
    }

    public static String readExample(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, 1);
            if (product == null){
                return null;
            }
            return product.toString();
        }
    }

    public static void updateExample(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, 1);
            if (product == null){
                throw new NullProductException();
            }
            product.setTitle("Электрический Огурец");
            product.setCost(777);
            session.getTransaction().commit();
        }
    }

    public static void main(String args[]){
        try{
            init();
            createExample();
            updateExample();
            System.out.println(readExample());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
