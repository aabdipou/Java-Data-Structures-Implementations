package Queue;

import java.util.*;

public class main {
    public static void main(String[] args){
        myQueue<Integer> list = new myQueue<Integer>();
        for(int i = 1; i <= 11; i++){
            list.add(i);
        } 
        System.out.println(Arrays.toString(list.toArray()));
        list.offer(5);
        System.out.println(Arrays.toString(list.toArray()));
        list.poll();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.peek());
    }
}
