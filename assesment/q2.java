//Write a method that receives a List<String> of email addresses and returns a Map<String, Integer> containing the frequency of each valid,
 //non-null email address. Treat addresses as case-insensitive by converting them to lowercase. Use an Iterator to remove null or blank entries 
 // from a working copy before counting. Preserve no particular Map iteration order requirement.
import java.util.*;
public class q2{
    public static Map<String,Integer> countEmails(List<String> emails){
        List<String> copy= new ArrayList<>(emails);
        Iterator<String> it=copy.iterator();
        while(it.hasNext()){
            String email= it.next();
            if(email==null|| email.isBlank()){
                it.remove();
            }
        }
        Map<String,Integer> result =new HashMap<>();
        for (String email:copy){
            email=email.toLowerCase();
            result.put(email,result.getOrDefault(email,0)+1);
        }
        return result;
    }
        public static void main(String[] args){
            List<String> emails= Arrays.asList("kk@gmail.com.","vkk@gmail.com",null,"");
            System.out.println(countEmails(emails));
        }
}
