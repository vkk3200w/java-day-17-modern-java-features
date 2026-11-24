//C. Practical exercise — 25 points
//Build a simple product inventory manager. Store products in a Map keyed by product ID. Each product must have an ID, name, and non-negative quantity. 
// Implement add product, update quantity, search by ID, and display all unique product names. Use a Set to display unique names.
//  Reject invalid IDs, blank names, and negative quantities. Create and use a custom checked exception named ProductNotFoundException 
// when an update or search refers to a missing product. Demonstrate appropriate exception handling.
import java.util.*;
class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    
    }
}
class product{
    int id;
    String name;
    int quantity;
    product(int id ,String name ,int quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public String toString(){
        return id+" "+name+" "+quantity;

    }
}
public class q3{
    static Map<Integer,product> products=new HashMap<>();
    static void addProduct(int id,String name,int quantity){
        if(id<=0|| name==null||name.isBlank()||quantity<0){
            throw new IllegalArgumentException("invalid details");

        }
        products.put(id,new product(id,name,quantity));

    }
    static void update(int id,int quantity)
    throws ProductNotFoundException{
        if(quantity<0){
            throw new IllegalArgumentException("invalid quantity");
        }
        if(!product.containsKey(id)){
            throw new ProductNotFoundException ("product not found");
        }
        products.get(id).quantity=quantity;
    }
    static product searchProduct(int id)
    throws ProductNotFoundException{
    if (!product.containsKey(id)){
        throw new ProductNotFoundException("NOT FORUND");
    }
    return product.get(id);
    }

    static void displayUniqueNames(){
        Set<String> names=new HashSet<>();
        for (product p: products.values()){
            names.add(p.names);

        }
        System.out.println(names);
    }
    public static void main(String[] args){
        try{
            addProduct(1,"laptop",10);
            addProduct(2,"tv",20);
            update(1,15);
            System.out.println(searchProduct(1));
            displayUniqueNames();
            searchProduct(10);

        }
        catch(ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

}