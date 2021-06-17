package Queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class myQueue<T> implements Queue<T>{
    
    int size;
    Node head;
    Node tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node currentNode = head;
        while(currentNode.getNext() != null){
            if(currentNode.getData() == o) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator<Object> it = new Iterator<Object>(){
            Node currentNode = head;
            
            @Override
            public boolean hasNext(){
                return currentNode.getNext() == null;
            }

            @Override
            public Object next(){
                currentNode = currentNode.getNext();
                return currentNode.getData();
            }
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        Node currentNode = head;
        Object[] returnArr = new Object[size];
        for(int i = 0; i < size; i++){
            returnArr[i] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return returnArr;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] returnArr;
        Node currentNode = head;
        if(a.length < size){
            returnArr = new Object[size]; 
            a = returnArr;
        }
        for(int i = 0; i < size; i++){
            a[i] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        Node currentNode = head;
        while(currentNode.getNext() != null){
            if(currentNode.getData() == o){
                currentNode.getPrev().setNext(currentNode.getNext());
                if(currentNode == tail) currentNode.next = tail;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public boolean add(Object e) {
        Node added = new Node(e);
        if(size == 0){
            this.head = this.tail = added;
            size++;
            return true;
        }else{
            this.tail.next = added;
            this.tail = added;
            size++;
            return true;
        }
    }

    @Override
    public boolean offer(Object e) {
        return add(e);
    }

    @Override
    public T remove() {
        Object removed = head.getData();
        head = head.getNext();
        size--;
        return (T)removed;
    }

    @Override
    public T poll() {
        return remove();
    }

    @Override
    public T peek() {
        return (T)head.getData();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T element() {
        // TODO Auto-generated method stu
        return null;
    }
    
}
