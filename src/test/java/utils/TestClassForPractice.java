package utils;
import java.util.*;
public class TestClassForPractice {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>(List.of(50,60,90,65,96));

      al1.add(10);
      al1.add(0,8);
      al1.addAll(al2);
      al1.addAll(2,al2);
     // System.out.println(al1);
      //  System.out.println(al1.get(10));
      //  al1.removeAll(al2);
      //  System.out.println(al1);
     //   for (Integer x:al1)
         //   System.out.println(x);



        LinkedList<Integer> al3 = new LinkedList<>(List.of(60,55,9,63));
      //  al3.addAll(al2);

        System.out.println(al3.descendingIterator());
    }
}
