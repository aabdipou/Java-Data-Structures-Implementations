package ArrayList;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class myArrayList<T> extends AbstractList<T> implements List<T>, RandomAccess, Cloneable, java.io.Serializable{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] arr;
    private int currentSize = 0;

    public myArrayList(){
        arr = new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
    }
    public myArrayList(int capacity){
        arr = new Object[capacity];
        size = capacity;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < currentSize; i++){
            if(o == arr[i]) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator<Object> it = new Iterator<Object>(){
           
            private int currentIndex = 0;
            
            @Override
            public boolean hasNext() {
                return currentIndex < size && arr[currentIndex] != null;
            }

            @Override
            public Object next() {
                return arr[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if(size == 0){
            return null;
        }
        if(a.length < currentSize){
            Object [] returnArr = new Object[size];
            for(int i = 0; i < currentSize; i++){
                returnArr[i] = arr[i];
            }
            return returnArr;
        }else{
            for(int i = 0; i < currentSize; i++){
                a[i] = arr[i];
            }
            return a;
        }
    }

    @Override
    public boolean add(Object e) {
        if(currentSize < arr.length){
            arr[currentSize] = e;
            currentSize++;
            return true;
        }else{
            Object [] newArr = new Object[size*2];
            size = size*2;
            for(int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            newArr[currentSize] = e;
            currentSize++;
            arr = newArr;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = -1; 
        for(int i = 0; i < currentSize; i++){
            if(o == arr[i]){
                index = i;
                break;
            }
        }

        if(index != -1){
            for(int j = index; j < currentSize-1; j++){
                arr[j] = arr[j+1];
            }
            arr[currentSize-1] = null;
            currentSize--;
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator<Object> it = c.iterator();
        while(it.hasNext()){
            if(!contains(it.next())) return false;
            }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Iterator<Object> it = c.iterator();
        while(it.hasNext()){
            add(it.next());
        }
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < currentSize; i++){
            arr[i] = null;
        }
        
    }

    @Override
    public T get(int index) {
        if(arr[index] == null){
            return null;
        }else{
            return (T) arr[index];
        }
    }

    @Override
    public Object set(int index, Object element) {
        Object prev = arr[index];
        arr[index] = element;
        return prev;
    }

    @Override
    public void add(int index, Object element) {
       if(index > arr.length){
            Object [] newArr = new Object[index+1];
            size = index+1;
            for(int i = 0; i < index && i < currentSize; i++){
                newArr[i] = arr[i];
            }
            newArr[index] = element;
            for(int i = index+1; i < currentSize; i++){
                newArr[i] = arr[i-1];
            }
            currentSize++;
            arr = newArr;
            return;
      
        }else{
        
        if(arr[index] == null && index < arr.length){
            arr[index] = element;
            return;
        }
 
        if(currentSize < arr.length && index < arr.length){
             for(int i = currentSize; i > index; i--){
                 arr[i] = arr[i-1];
             }
             arr[index] = element;
             currentSize++;
             return;
         }else{
         Object [] newArr = new Object[size*2];
         size = size*2;
         for(int i = 0; i < index; i++){
             newArr[i] = arr[i];
         }
         newArr[index] = element;
         for(int i = index+1; i < currentSize; i++){
             newArr[i] = arr[i-1];
         }
         currentSize++;
         arr = newArr;
         return;
     }
       }      
    }

    @Override
    public T remove(int index) {
        Object removed = arr[index];
        for(int i = index; i < currentSize-1; i++){
            arr[i] = arr[i+1];
        }
        arr[currentSize-1] = null;
        currentSize--;
        return (T) removed;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < currentSize; i++){
            if(o == arr[i]) return i;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for(int i = 0; i < currentSize; i++){
            if(o == arr[i]) index = i;
        }
        return index;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        myArrayList<Object> returnList = new myArrayList<Object>(fromIndex-toIndex+1);
        for(int i = fromIndex; i <= toIndex; i++){
            returnList.add(arr[i]);
        }
        return returnList;
    }

}