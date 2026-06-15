package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class arrayList {
    public static void main(String[] args) {
//        ArrayList<String> list = new  ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        System.out.println(list);
//
//        list.remove(list.size()-1);
//        System.out.println(list);

       /* HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");
        System.out.println(cars);
*/
        HashMap<String, String> capitalCity = new HashMap<>();
        capitalCity.put("Ikeja", "Lagos");
        capitalCity.put("Rioja", "Sao Paulo");
        System.out.println(capitalCity);

    }

}

