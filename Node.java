/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 1 (100 marks, 10%) - Due March 19, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
public class Node {

    private Polygon data;
    private Node next;
    private Node prev;

    Node() {
        next = null;
        prev = null;
        data = null;

    }

    Node(Polygon d) {
        data = d;
        next = prev = null;

    }

    public void setNext(Node n) {
        next = n;

    }

    public void setPrev(Node p) {
        prev = p;
    }

    public Node getNext() {
        return next;

    }

    public Node getPrev() {
        return prev;

    }

    public void setData(Polygon d) {
        data = d;

    }

    public Polygon getData() {
        return data;
    }

}
