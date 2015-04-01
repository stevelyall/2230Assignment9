import exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * LinkedStack.java
 *
 * COMP 2230 Assignment 4
 * Steven Lyall (T00023594)
 *
 * Linked implementation of a stack.
 *
 * @author Java Foundations except where noted
 * @version 4.0
 */

public class LinkedStack<T> implements StackADT<T>, Iterable
{
    protected LinearNode<T> top;
    protected int modCount = 0;
    protected LinkedStackIterator iterator;


    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     * @author Java Foundations
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        modCount++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element from top of stack
     * @throws exceptions.EmptyCollectionException if the stack is empty
     * @author Java Foundations
     */
    public T pop() throws EmptyCollectionException
    {
        modCount++;
        iterator = new LinkedStackIterator();
        top = top.getNext();
        return iterator.next();
    }


    // Additional methods implemented below

    /**
     * Returns the top element in the stack without modifying the stack.
     *  Complexity: O(1)
     *  Precondition: The stack contains at least one element.
     *  Postcondition: The element on the top of the stack is returned but the structure remains unchanged.
     * @throws exceptions.EmptyCollectionException if the stack is empty
     * @return top element in stack
     * @author stevelyall
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Can't peek, stack is empty.");
        }
        return top.getElement();
    }

    /**
     * Checks to see if the stack is empty or not.
     *  Complexity: O(1)
     *  Precondition: The LinkedStack object has been instantiated.
     *  Postcondition: Returns a boolean true if top points to null, false otherwise. The stack is unchanged.
     * @author stevelyall
     * @return true if top is null, false otherwise
     */
    public boolean isEmpty() {
        return (top==null) ? true : false;
    }

    /**
     * Get the number of items in the stack.
     *  Complexity: O(n)
     *  Precondition: The LinkedStack object has been instantiated.
     *  Postcondition: Returns the number of elements in the stack. The stack is unchanged.
     * @author stevelyall
     * @return the value of count
     */
    public int size() {
        LinearNode<T> current = top;
        int numNodes = 0;
        while (current!=null) {
            numNodes++;
            current = current.getNext();

        }
        return numNodes;
    }

    /**
     * Returns a string representation of this stack.
     * Complexity: O(n)
     * Precondition: The LinkedStack object has been instantiated.
     * Postcondition: Returns a string representation of the stack. The stack itself is unchanged.
     * @author stevelyall
     * @return string representation of the stack
     */
    public String toString() {
        iterator = new LinkedStackIterator();
        String stackString = "<TOP OF STACK>";
        while (iterator.hasNext()) {
            stackString += "\n" + iterator.next();
        }
        return  stackString + "\n<BOTTOM OF STACK>";
    }

    public Iterator iterator() {
        return iterator();
    }

    class LinkedStackIterator implements Iterator<T> {

        private int iteratorModCount;
        private LinearNode<T> current;

        /**
         * Sets up the iterator.
         */
        public LinkedStackIterator() {
            current = top;
            iteratorModCount = modCount;
        }

        /**
         * Check whether another element exists.
         *
         * @author stevelyall
         * @throws java.util.ConcurrentModificationException if the collection is modified while the iterator is being used
         * @return true if there is another element in the collection, false otherwise
         */
        @Override
        public boolean hasNext() {

            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (current !=null);
        }

        /**
         * Moves iterator to next element in the structure.
         *
         * @author stevelyall
         * @throws exceptions.EmptyCollectionException if there is no next element
         * @return the next element in the structure
         */
        @Override
        public T next() {
            if (!hasNext()){
                throw new EmptyCollectionException("LinkedStack");
            }
            T toGet = current.getElement();
            current = current.getNext();
            return toGet;
        }

        /**
         * Remove is not supported.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
