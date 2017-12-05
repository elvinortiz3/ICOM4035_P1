package structures;

public class LLStack<E> implements Stack<E>
{
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
	
	/**Stack class**/

	private SNode<E> top; 
	private int size; 

	public LLStack() {
		top = null; 
		size = 0; 
	}

	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("pop: Stack is empty."); 

		SNode<E> ntr = top;
		E etr = ntr.getElement(); 

		top = top.getNext();
		ntr.clean();
		size--;

		return etr;
	}

	public void push(E e) {

		SNode<E> nta = new SNode<E>(e, top);
		top = nta;
		size++; 
	}

	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("pop: Stack is empty."); 
		return top.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}


	// just for testing and grading....
	public void showReverse() { 
		if (size == 0)
			System.out.println("Stack is empty."); 
		else
			recSR(top);
	} 
	private void recSR(SNode<E> f) { 
		if (f != null) { 
			recSR(f.getNext()); 
			System.out.println(f.getElement()); 
		} 
	} 


}