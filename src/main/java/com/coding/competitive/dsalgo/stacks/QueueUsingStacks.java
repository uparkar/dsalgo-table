package com.coding.competitive.dsalgo.stacks;

public class QueueUsingStacks {

    private CustomStack stk1 = new CustomStack(4);
    private CustomStack stk2 = new CustomStack(4);

    public static void main(String[] args) {

        QueueUsingStacks qus = new QueueUsingStacks();
        qus.enQ(2);
        qus.enQ(3);
        qus.enQ(4);
        qus.enQ(5);
        qus.enQ(6);
        qus.enQ(7);

        int removed = qus.deQ();
        System.out.printf("Front in Q was %d\n",removed);
        qus.enQ(6);
        removed = qus.deQ();
        System.out.printf("Front in Q was %d\n",removed);
        removed = qus.deQ();
        System.out.printf("Front in Q was %d\n",removed);
        removed = qus.deQ();
        System.out.printf("Front in Q was %d\n",removed);
        removed = qus.deQ();
        System.out.printf("Front in Q was %d\n",removed);
        removed = qus.deQ();
        System.out.printf("Front in Q was %d\n",removed);


    }

    private void enQ(int elem) {
        if(stk1.isFull())
            System.out.println("Q is Full, remove elements to add new");
        else
            stk1.push(elem);
    }

    private int deQ() {
        while(!stk1.isEmpty() && !stk2.isFull()) {
            stk2.push(stk1.pop());
        }
        //At this stage all elements from Stk1 should be in Stk2 and reversed order

        if(stk2.isEmpty())
            return Integer.MIN_VALUE;
        int front = stk2.pop();

        //Restore Stk1 from the remaining elements in Stk2
        while(!stk2.isEmpty() && !stk1.isFull()) {
            stk1.push(stk2.pop());
        }

        return front;
    }
}
