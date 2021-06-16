package ArrayList;

import java.util.*;

public class main {
    public static void main(String[] args){
        myArrayList<Integer> list = new myArrayList<Integer>();
        for(int i = 0; i <= 11; i++){
            list.add(i);
        } 
        System.out.println(Arrays.toString(list.toArray()));
        list.add(0, 10);
        System.out.println(Arrays.toString(list.toArray()));
        list.add(30, 10);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(30));
        list.remove(3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
