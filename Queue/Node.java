package Queue;
/*Node Class*/
public class Node<T> {
    T data;
    Node next;
    Node prev;

    public Node(T data){
        this.data = data;
    }

    public Node getNext(){
        return next;
    }

    public T getData(){
        return data;
    }

    public Node getPrev(){
        return prev;
    }

    public void setNext(Node next){
        this.next = next;
        return;
    }

    public void setData(T data){
        this.data = data;
        return;
    }

    public void setPrev(Node prev){
        this.prev = prev;
        return;
    }

}

