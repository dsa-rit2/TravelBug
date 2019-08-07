package travelBug.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GroupList<T> implements GroupListInterface<T> {

	private Node firstNode;
	public int numberOfEntries;

	private GroupList() {
		clear();
	}

	@SuppressWarnings("unchecked")
	public GroupList(SinglyLinkedList<T> listNode) {
		clear();
		GroupList<T> tempLinkedList = new GroupList<T>();
		for (T list : listNode) {
			if (tempLinkedList.isEmpty() || tempLinkedList.firstNode.equals(list)) {
				tempLinkedList.add(list);
			} else {
				this.add((T) tempLinkedList);
				tempLinkedList.clear();
			}
		}
		this.add((T) tempLinkedList);
	}

	private boolean add(T newEntry) {
		Node newNode = new Node(newEntry); // create the new node

		if (isEmpty()) // if empty list
		{
			firstNode = newNode;
		} else { // add to end of nonempty list
			Node currentNode = firstNode; // traverse linked list with p pointing to the current node
			while (currentNode.next != null) { // while have not reached the last node
				currentNode = currentNode.next;
			}
			currentNode.next = newNode; // make last node reference new node
		}

		numberOfEntries++;
		return true;
	}

	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new GroupListIterator();
	}

	private class GroupListIterator implements Iterator<T> {

		private Node currentNode = firstNode;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T returnData = currentNode.data;
				currentNode = currentNode.next;
				return returnData;
			} else {
				throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	private class Node {

		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			this.next = null;
		}

		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
