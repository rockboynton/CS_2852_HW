package binarysearchtree;

import circularqueue.CircularQueue;

import java.math.BigInteger;


public class Driver {
    public static void main(String[] args) {
//        BinarySearchTree<BigInteger> treeOfBigNumbers = new BinarySearchTree<>();
//        treeOfBigNumbers.add(new BigInteger("1"));
//        treeOfBigNumbers.add(new BigInteger("5"));
//        treeOfBigNumbers.add(new BigInteger("300"));
//        treeOfBigNumbers.add(new BigInteger("6"));
//        treeOfBigNumbers.add(new BigInteger("2"));
//        treeOfBigNumbers.add(new BigInteger("60000"));
//        System.out.println(treeOfBigNumbers.toString());
//        System.out.println(treeOfBigNumbers.toString2());
//        System.out.println(treeOfBigNumbers.toString3());
//        System.out.println(treeOfBigNumbers.countLeaves());
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
        circularQueue.offer(1);
        circularQueue.offer(2);
        circularQueue.offer(3);
        circularQueue.offer(4);
        circularQueue.offer(5);
        System.out.println(circularQueue.peek());
        System.out.println(circularQueue.poll());
        System.out.println(circularQueue.poll());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.poll());
        System.out.println(circularQueue.poll());
        System.out.println(circularQueue.poll());
        circularQueue.offer(123);
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.poll());
        System.out.println(circularQueue.isEmpty());
    }
}

