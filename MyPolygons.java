
/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 1 (100 marks, 10%) - Due March 19, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */

public class MyPolygons {

  private Node current;
  private final Node sentinel;
  private int size;

  MyPolygons() {
    this.sentinel = new Node(null);
    this.sentinel.setPrev(sentinel);
    this.sentinel.setNext(sentinel);
    this.current = this.sentinel;
    this.size = 0;
  }

  MyPolygons(Polygon p) {
    sentinel = new Node(null);
    size = 0;
    clear();

  }

  public void clear() {
    // Make the list be empty by having the sentinel point to itself
    // in both directions.
    sentinel.setNext(sentinel);
    sentinel.setPrev(sentinel);

    // There's only one place to put the current reference...
    current = sentinel;
    size = 0;
  }

  // Function to insert node in the list
  public void add(Polygon new_data) {
    Node x = new Node(new_data); // allocate a new element

    // Splice in the new element.
    x.setNext(current.getNext());
    x.setPrev(current);

    current.getNext().setPrev(x);
    current.setNext(x);

    current = x; // new element is current position

    size++;
  }

  public String toString() {
    String result = "";

    for (Node x = sentinel.getNext(); x != sentinel; x = x.getNext())
      result += x.toString() + "\n";

    return result;
  }

  public boolean isEmpty() {
    return sentinel.getNext() == sentinel;
  }

  public boolean hasCurrent() {
    return current != sentinel;
  }

  public boolean hasNext() {
    return hasCurrent() && current.getNext() != sentinel;
  }

  public boolean hasPrev() {
    return hasCurrent() && current.getPrev() != sentinel;
  }

  public Polygon getFirst() {
    if (isEmpty()) {
      System.out.println("The list is empty ");
      return null;
    }
    current = sentinel.getNext();
    return get();
  }

  public Polygon getLast() {
    if (isEmpty()) {
      System.out.println("The list is empty");
      return null;
    }
    current = sentinel.getPrev();
    return get();
  }
  // ------------------------------------------------------------------

  public void prepend(Polygon obj) {
    current = sentinel;
    add(obj);

  }

  public void append(Polygon obj) {

    Node x = new Node(obj); // allocate a new element

    // Splice in the new element.
    x.setNext(sentinel);
    x.setPrev(current);

    current.setNext(x);

    current = x; // new element is current position
    size++;

  }

  public void insertBefore(Polygon obj) {

    Node n = new Node(obj); // create a new node for input data

    current.getPrev().setNext(n);
    n.setPrev(current.getPrev());

    n.setNext(current);
    current.setPrev(n);

    current = current.getPrev();

    // Update previous node's next

    size++;

  }

  public void moveNext() {
    if (isEmpty()) {
      System.out.println("The list is empty");
      return;
    } else
      current = current.getNext();
  }

  public void resetCurrent() {
    current = sentinel.getNext(); // reset the current
  }

  public void removeHeaditem() {

    resetCurrent(); // set current to the head of the list
    // Do not let the sentinel be deleted!
    if (hasCurrent()) {
      // Splice out the current element.
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());

      current = current.getNext(); // make successor the new current
      size--;
    } else
      System.err.println("No head item to be deleted.");
  }

  // ----------------------------------------------------------------
  public Polygon get() {
    if (hasCurrent())
      return current.getData();
    else {
      System.out.println("No current item");
      return null;
    }

  }

  // Error if there is no current item.
  public void set(Polygon obj) {
    if (hasCurrent())
      current.setData(obj);
    else
      System.err.println("No current item");
  }

  // Moves current to the next position. Error if there is no next item.
  public Polygon next() {
    if (hasNext()) {
      current = current.getNext();
      return current.getData();
    } else {
      System.err.println("No next item");
      return null;
    }
  }

  public void addInOrder(Polygon new_data) {
    Node x = new Node(new_data); // allocate a new element
    resetCurrent(); // move current to begining

    if (size == 0) {
      prepend(new_data);
      return;
    }

    else
      while (hasCurrent()) {
        if (current.getData().ComesBefore(new_data) == true) {
          insertBefore(new_data);
          break;
        } else if (current.getData().ComesBefore(new_data) == false && current.getNext() != sentinel) {
          current = current.getNext();

        } else if (current.getData().ComesBefore(new_data) == false && current.getNext() == sentinel) {
          append(new_data);
          break;
        }

      }

  }

  public int getsize() {
    return size;
  }

  public void printNodes() {
    resetCurrent();

    while (hasCurrent()) {
      System.out.println(current.getData());

      if (current.getNext() != null) {

        current = current.getNext();

      } else
        return;
    }

  }

}
