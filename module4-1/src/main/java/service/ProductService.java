package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"abc","https://tse1.mm.bing.net/th?id=OIP.h8s_-BU7Y1c1fK_jmDtGWQHaEK&pid=Api&rs=1&c=1&qlt=95&w=203&h=114",1000000));
        products.add(new Product(2,"xyz","https://tse1.mm.bing.net/th?id=OIP.j63HtwOLoE3SZ2cs0LuunAHaEK&pid=Api&rs=1&c=1&qlt=95&w=203&h=114", 1111111));
    }
    public static void save(Product p){
        products.add(p);
    }
    public static void delete(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()== id){
                products.remove(i);
            }
        }
    }
    public static void edit(int index , Product product){
        products.set(index, product);
    }
    public static Product getProduct(int id){
        return products.get(findIndexById(id));
    }

    public static int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
