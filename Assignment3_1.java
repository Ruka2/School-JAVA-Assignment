//  Suppose you have a stack S containing n elements
// and a queue Q that is initially empty.
// Describe how you can use Q to scan S to see
// if it contains a certain element x,
// with the additional constraint that
// your algorithm must return the elements back to S in their original order.
// You may only use S, Q, and a constant number of other primitive variables.


public class Assignment3_1 {
    /** Declare the initial object */
    private static ArrayStack mystack = new ArrayStack<Integer>();
    private static ArrayQueue myqueue = new ArrayQueue<Integer>(); // a queue is initially empty
    /** the Main function */
    public static void main(String[] args) {
        int x = 4;                                     // the element x
        mystack.push(1);                           // a stack containing n elements
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        mystack.push(5);
        mystack.push(6);
        mystack.push(7);
        mystack.push(8);
        mystack.push(9);
        checkElement(mystack, myqueue, x);
        }
    private static void checkElement(ArrayStack stack, ArrayQueue queue, int x){
        ArrayStack temp = new ArrayStack<Integer>();
        System.out.println("The element x: " + x);
        System.out.println("The original stack: " + mystack);
        System.out.println("The original queue: " + myqueue);
        System.out.println("------------------------------");
        /** Step 1*/
        int Size1 = stack.size();
        for(int i = 0; i < Size1; i++) {
            if (stack.top() == (Object) x) {
                System.out.println("The stack have the element x: " + stack.top());
                System.out.println("The position of x: " + (Size1 - i - 1));
                /** Step 2*/
                int Size2 = stack.size();
                for (int k = 0; k < Size2; k++) {
                    queue.enqueue(stack.pop());
                }
                Size2 = queue.size();
                for (int j = 0; j < Size2; j++) {
                    stack.push(queue.dequeue());
                }
                for (int m = 0; m < Size1; m++) {
                    queue.enqueue(stack.pop());
                }
                for (int s = 0; s < Size1; s++) {
                    stack.push(queue.dequeue());
                }
                System.out.println("The after stack: " + stack);
                break;
            } else if (i == Size1 - 1) {
                System.out.println("The element x cannot be found");
                break;
            } else {
                queue.enqueue(stack.pop());
            }
        }
    }
}
/** Stack */
class ArrayStack<E> {
    private static final int CAPACITY = 1000;           // default array capacity
    private E[] data;                                  // generic array used for storage
    private int t = -1;                                // index of the top element in stack
    public ArrayStack() { this(CAPACITY); }            // constructs stack with default capacity
    public ArrayStack(int capacity) { data = (E[]) new Object[capacity]; } // constructs stack with give capacity
    public int size() { return (t + 1); }              // safe cast; compiler may give warning
    public boolean isEmpty() { return (t == -1); }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;                                 // increment t before storing new item
    }
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;                                // dereference to help garbage collection
        t--;
        return answer;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null) {                      // the capacity is large, but output should can't see it all
                sb.append(data[i] + " ");
            }
        }
        return sb.toString();
    }
}
/** Queue */
class ArrayQueue<E> {
    /** instance variables */
    private static final int CAPACITY = 1000;
    private E[] data;                                  // generic array used for storage
    private int f = 0;                                 // index of the front element
    private int sz = 0;                                // current number of elements
    /** constructors */
    public ArrayQueue() { this(CAPACITY); }            // constructs queue with default capacity
    public ArrayQueue(int capacity) { data = (E[]) new Object[capacity]; } // constructs queue with given capacity
    /** methods */
    public int size() { return sz; }                   // returns the number of elements in the queue
    public boolean isEmpty() { return (sz == 0); }     // tests whether the queue is empty

    public void enqueue(E e) throws IllegalStateException { // inserts an element at the rear of the queue
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;            // use modular arithmetic
        data[avail] = e;
        sz++;
    }
    public E first() {                                 // returns, but don't remove, the first elment of the queue
        if (isEmpty()) return null;
        return data[f];
    }
    public E dequeue() {                               // remove and return
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;                                // dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
    public String toString() {                         // make the object to string and print it
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null) {                      // the capacity is large, but output should can't see it all
                sb.append(data[i] + " ");
            }
        }
        return sb.toString();
    }
}