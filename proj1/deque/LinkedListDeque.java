package deque;

public class LinkedListDeque<T> {
        private class node{
            public node previous;
            public node next;
            public T element;
            public node(node pre,T e,node nxt){
                previous= pre;
                element=e;
                next=nxt;
            }
        }
    private node sentinel;


    private int size;


    public LinkedListDeque(){
        sentinel=new node(null,null,null);
        size=0;
    }
    public LinkedListDeque(LinkedListDeque other) {

        sentinel = new node(null, null, null);
        size = 0;
        for(int i=0;i< other.size;i++){
            this.addLast((T)other.get(i));
        }
    }
    public void addFirst(T item){
        size=size+1;

        if(sentinel.next==null){
            sentinel.next=new node(sentinel,item,sentinel);
            sentinel.previous=sentinel.next;
        }
        else{
            sentinel.next=new node(sentinel,item,sentinel.next);
        }


    }
    public void addLast(T item){
        size=size+1;
        if(sentinel.next==null){
            sentinel.next=new node(sentinel,item,sentinel);
            sentinel.previous=sentinel.next;
        }
        else{
            node p=sentinel.previous;
            p.next=new node(p,item,sentinel);
            sentinel.previous=p.next;
        }

    }
    public boolean isEmpty(){
        if(sentinel.next==null){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        node p=sentinel.next;
        if(p==sentinel){
            System.out.println("A newly initialized LLDeque should be empty");
        }
        while(p!=sentinel){
            System.out.print(p.element);
            p=p.next;
        }
        System.out.println();
    }
    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        size=size-1;
        node p=sentinel.next;
        T front=p.element;
        if(p.next==sentinel) {
            sentinel.next=null;
            sentinel.previous=null;
        }
        else{
            sentinel.next=p.next;
            node x=p.next;
            x.previous=sentinel;
        }
        return front;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        size=size-1;
        node p=sentinel.previous;
        T last=p.element;
        if(p.previous==sentinel){
            sentinel.next=null;
            sentinel.previous=null;
        }
        else {
            p = p.previous;
            sentinel.previous = p;
            p.next = sentinel;
        }
        return last;
    }
    public T get(int index){
        if(size<index){
            return null;
        }
        int i=0;
        node p=sentinel.next;
        while(i<index){
            p=p.next;
            i++;
        }
        return p.element;
    }
    private T recursiveGet(node p,int i){
        if(i==0) {
            return p.element;
        }
        i-=1;
        return recursiveGet(p.next,i);
    }
    public T getRecursive(int index){
      return recursiveGet(sentinel.next,index);
    }
}
