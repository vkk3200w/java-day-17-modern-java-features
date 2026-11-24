
//Create a generic method named findFrequency() that accepts a List<T> and a target value of type T. 
// Return the number of times the target occurs in the list. Use equals() to compare values. Demonstrate the method with a List<String> and a List<Integer>. 
import java.util.*;


public class q1 {
    public static <T> int  findFrequency(List<T> list, T target){
        int count=0;
        for (T items : list){
            if(items.equals(target)){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        List<String> names =Arrays.asList("kk","vkk","kk");
    
    List<Integer> numbers=Arrays.asList(10,20,30,10);
   
    System.out.println(findFrequency(names,"kk"));
    System.out.println(findFrequency(numbers,10));
}
}