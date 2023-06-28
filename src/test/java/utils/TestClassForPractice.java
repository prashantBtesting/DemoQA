package utils;

import java.util.*;

public class TestClassForPractice {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>(List.of(50, 60, 90, 65, 96));

        al1.add(10);
        al1.add(0, 8);
        al1.addAll(al2);
        al1.addAll(2, al2);
        // System.out.println(al1);
        //  System.out.println(al1.get(10));
        //  al1.removeAll(al2);
        //  System.out.println(al1);
        //   for (Integer x:al1)
        //   System.out.println(x);


        LinkedList<Integer> al3 = new LinkedList<>(List.of(60, 55, 9, 63));
        //  al3.addAll(al2);

        ArrayDeque<Integer> dq = new ArrayDeque<>(List.of(505, 999));

        dq.offerLast(2);
        dq.offerLast(1);
        dq.offerFirst(40);
        dq.offerFirst(20);

        dq.offerFirst(50);
        //  System.out.println(dq);
        //  dq.forEach(System.out::println);

        ArrayList<Integer> arr = new ArrayList<>(List.of(20, 30, 60, 90, 34, 62, 81));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(63, 423, 659, 865, 330, 203));
        arr.addAll(arr2);
        arr.add(10);
        int sum = 0;
        for (Integer num : arr) {
            sum = sum + num;
        }
        // arr.clear();
        // System.out.println(arr);
        // System.out.println(sum);
        //System.out.println(arr.retainAll(arr2));


        ListIterator<Integer> it = arr.listIterator();
        while (it.hasNext()) {
            //  System.out.println(it.);
        }


    }

}
