package deque;
import org.junit.*;

public class ArrayDeque <T>{
    private int size;

    private T[] items;
    private int front;
    private int rear;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;

    }
    public ArrayDeque(ArrayDeque other){
        items= (T[]) new Object[other.size];
        int index= other.front;
        int i=0;
        while(index!=rear){
//            this.addLast((T)other.get(index));
           this.items[i]=(T)other.items[index];
           i=i+1;
            index=index+1;
            if(index== other.size){
                index=0;
            }
        }
        this.items[i]=(T)other.items[index];
        front=0;
        rear=index;
        this.size= other.size;
        /*
         for(int i=0;i< other.size;i++){
               this.addLast((T)other.get(i));
         }

         */
//         front=other.front;
//         rear= other.rear;


    }
    private void resize(){
        T []a=(T[]) new Object[size*2];
            /*
            if we have items={1,2,3} and front in index 1 and rear in index 0
           now a is double the size ={x,x,x,x,x,x}
           so front is in ={x,x,x,front,x,x} and this is the array a
           now to copy we will do it in 2 steps but first the source is (items array) and destination is (a array)

           our first step:
           we should copy from source array starting from front till end of items array
           the destination array we will start from half it's len (btw it's len is double items len)
           the length is (items length-front) so lets assume in our first example we said front is in index 1 and the length was 3 so(3-1=2 which is true)

           our second step:
           we will copy till rear (which ofcourse will be front -1)

             */
        // shanging resize logic
        /*
        System.arraycopy(items,front,a,(a.length/2),items.length-front);
        if(front!=0) {
            System.arraycopy(items, 0, a, (a.length / 2) + (items.length - front), rear + 1);
        }
        items=a;

         */
        System.arraycopy(items,front,a,0,items.length-front);
        if(front!=0|| front>rear){
            System.arraycopy(items,0,a,items.length-front,rear+1);
        }
        items=a;
        front=0;
        rear=size-1;
    }
    public void addLast(T item){
        if(size==0){
           front=0;
            rear=rear+1;
            items[rear]=item;
            size=size+1;
        }
        else if(size== items.length){
            resize();
            rear=rear+1;
            items[rear]=item;
            size=size+1;

        }
        else {
            if(rear== items.length-1){
                rear=0;
            }else {
                rear = rear + 1;
            }
            items[rear] = item;
            size = size + 1;

        }
    }
    public void addFirst(T item){
        if(size==0){
            front= 0;
            items[front]=item;
            rear=front;

        }
        else if(size== items.length){
            resize();
            front= items.length-1;
            items[front]=item;


        }
        else{
            if(front==0){
                front= items.length-1;
            }
            else{
                front=front-1;
            }
             items[front]=item;

        }
        size=size+1;
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }

        T i=items[front];
        if(front== items.length-1){
            front=0;
        }else {
            front = front + 1;
        }
        size=size-1;
        return i;
        /*
        size=size-1;
        T i=items[front];
        if(front== items.length-1){
            front=0;
        }
        else {
            front = front + 1;
        }
        return i;

         */
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        T i=items[rear];
        if(rear==0){
            rear=items.length-1;
        }
        else {
            rear = rear - 1;
        }
        size=size-1;
        return i;
        /*
        size=size-1;
        T i=items[rear];
        if(rear==0){
            rear=items.length-1;
        }
        else{
            rear=rear-1;
        }
        return i;

         */
    }
    public T get(int index){
        if(index>=size){
            return null;
        }
        if((front+index)>= items.length){
            int indx=(front+index)- items.length;
            return items[indx];
        }
        return items[front+index];


    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

}
