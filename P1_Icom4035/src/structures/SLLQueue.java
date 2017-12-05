package structures;

import theSystem.Order;

public class SLLQueue<E> implements Queue<E> {

	/** 
   A partial implementation of the Queue using a singly linked list with references 
   to the first and to the last node.
	 **/


	private static class SNode<E> {   // Inner class for nodes. 
		private E element; 
		private SNode<E> next;

		public SNode(E data, SNode<E> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(E data)  { 
			this.element = data; 
			next = null; 
		}

		public E getElement() {
			return this.element;
		} 
		public void setElement(E data) {
			this.element = data;
		}

		public SNode<E> getNext() {
			return next;
		}

		public void setNext(SNode<E> next) {
			this.next = next;
		}

		public void clean() { 
			element = null; 
			next = null; 
		}
	}	


/**Queue class**/
	private SNode<E> first, last;   // references to first and last node
	private int size; 

	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	public int size() {
		return size;
	}
	

	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) return null;
		return first.getElement(); 
	}
	public E dequeue() {
		if (isEmpty()) return null;	

		SNode<E> ntr = first;
		E etr = ntr.getElement();

		first = first.getNext();
		ntr.clean();
		size--;
		return etr;

	}
	public void enqueue(E e) {
		SNode<E> nn = new SNode<E>(e); 

		if (size == 0) 
			first =  nn;
		else  
			last.setNext(nn);
		last = nn;
		size++; 
	}


	@Override
	public void showReverse() { 
		if (size == 0)
			System.out.println("Queue is empty."); 
		else
			recSR(first);
	} 
	private void recSR(SNode<E> f) { 
		if (f != null) { 
			recSR(f.getNext()); 
			System.out.println(f.getElement()); 
		} 
	}

}
