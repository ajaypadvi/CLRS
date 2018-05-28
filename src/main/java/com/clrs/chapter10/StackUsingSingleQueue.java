package com.clrs.chapter10;

/**
 * Push O(n)
 * Pop O(1)
 */
public class StackUsingSingleQueue {

    private Queue queue;

    public StackUsingSingleQueue(int size) {
        queue = new Queue(size,"Q");
    }

    public void push(int x) {
        int sizeOfQueue = queue.getElements();
        queue.enqueue(x);

        for (int i = 0; i < sizeOfQueue; i++) {
            queue.enqueue(queue.dequeue());
        }
        System.out.println("PUSH :  " + queue.toString());
    }

    public int pop() {
        int x = queue.dequeue();
        System.out.println("POP : " + queue.toString());
        return x;
    }
}
