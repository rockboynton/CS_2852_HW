package binarysearchtree;

import java.math.BigInteger;
import java.util.TreeMap;

public class Driver {
    public static void main(String[] args) {
        BinarySearchTree<BigInteger> treeOfBigNumbers = new BinarySearchTree<>();
        treeOfBigNumbers.add(new BigInteger("3"));
        treeOfBigNumbers.add(new BigInteger("30000000"));
        treeOfBigNumbers.add(new BigInteger("999999999999999"));
        System.out.println(treeOfBigNumbers.size());
        System.out.println(treeOfBigNumbers.isEmpty());
        System.out.println("Should be true: " + treeOfBigNumbers.contains(new BigInteger("3")));
        System.out.println("Should be true: " + treeOfBigNumbers.contains(new BigInteger("30000000")));
        System.out.println("Should be true: " + treeOfBigNumbers.contains(new BigInteger("999999999999999")));
        System.out.println("Should be false: " + treeOfBigNumbers.contains(new BigInteger("5")));
        System.out.println("Should be 1, 3, 30000000, 999999999999999, 9999999999999998 : " +
                treeOfBigNumbers.toString());
        System.out.println("Should be 999999999999999: " + treeOfBigNumbers.max());
        System.out.println("Should be 3: " + treeOfBigNumbers.min());

    }
}

