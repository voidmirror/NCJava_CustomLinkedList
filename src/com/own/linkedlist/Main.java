package com.own.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        NodeCustom<Integer> name = new NodeCustom(45, null, null);
//        NodeCustom<String> name2 = new NodeCustom("sijief", null, null);
//        System.out.println(name);
//        System.out.println(name2);

        // Declaration
        long start;
        long stop;

        // Time Testing =========================================================

        List<String> list = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add("string" + i);
        }
        stop = System.nanoTime();
        System.out.println("Stock: Add to list: " + (stop - start));



        LinkedListCustom<String> customList = new LinkedListCustom<>();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            customList.add("string" + i);
        }
        stop = System.nanoTime();
        System.out.println("Custom: Add to list: " + (stop - start));


        ArrayList<String> arrayList = new ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add("string" + i);
        }
        stop = System.nanoTime();
        System.out.println("ArrayList: Add to list: " + (stop - start));


        System.out.println();

        // ITERATOR=================================================================

//        start = System.nanoTime();
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        stop = System.nanoTime();
//        System.out.println("Stock: Print iterator.next(): " + (stop - start));
////
////
//        start = System.nanoTime();
//        Iterator iterator2 = customList.iterator();
//        while (iterator2.hasNext()) {
//            System.out.println(iterator2.next());
//        }
//        stop = System.nanoTime();
//        System.out.println("Custom: Print iterator.next(): " + (stop - start));


//        start = System.nanoTime();
//        Iterator iterator2 = arrayList.iterator();
//        while (iterator2.hasNext()) {
//            System.out.println(iterator2.next());
//        }
//        stop = System.nanoTime();
//        System.out.println("ArrayList: Print iterator.next(): " + (stop - start));
//
//        System.out.println();


        // CLEAR=======================================================================

//        start = System.nanoTime();
//        list.clear();
//        stop = System.nanoTime();
//        System.out.println("Stock: Clear: " + (stop - start));
//
//        start = System.nanoTime();
//        customList.clear();
//        stop = System.nanoTime();
//        System.out.println("Custom: Clear: " + (stop - start));

//        start = System.nanoTime();
//        arrayList.clear();
//        stop = System.nanoTime();
//        System.out.println("ArrayList: Clear: " + (stop - start));
//
//        System.out.println();

        // REMOVE (Comment CLEAR)=========================================================

//        start = System.nanoTime();
//        Iterator iterator3 = customList.iterator();
//        for (int i = 0; i < 1000; i++) {
//            list.remove("string" + i);
//        }
//        stop = System.nanoTime();
//        System.out.println("Stock: remove(): " + (stop - start));
//
//        start = System.nanoTime();
//        Iterator iterator4 = customList.iterator();
//        for (int i = 0; i < 1000; i++) {
//            customList.remove("string" + i);
//        }
//        stop = System.nanoTime();
//        System.out.println("Custom: remove(): " + (stop - start));


//        start = System.nanoTime();
//        Iterator iterator4 = arrayList.iterator();
//        for (int i = 0; i < 1000; i++) {
//            arrayList.remove("string" + i);
//        }
//        stop = System.nanoTime();
//        System.out.println("ArrayList: remove(): " + (stop - start));











//        customList.add("Somebody");
//        customList.add("Ones");
//        customList.add("Told");
//        customList.add("Me");
//        customList.add("The");
//        customList.add("World");
//        customList.add("Is");
//        customList.add("Gonna");
//        customList.add("Roll");
//        customList.add("Me");
//        customList.addToBegin("LKSMLEFKLSEF");
//        System.out.println(customList.getFirst());
//        System.out.println(customList.getSize());


//        Iterator iterator = list.iterator();



//        start = System.nanoTime();
//        // ITERATOR
//        Iterator iterator = customList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        stop = System.nanoTime();
//        System.out.println(stop - start);
    }

}
