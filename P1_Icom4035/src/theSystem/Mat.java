package theSystem;

import java.util.ArrayList;

import structures.LLStack;
import structures.SLLQueue;

public class Mat {
	private SLLQueue<Order> inputQueue = new SLLQueue<>();
	private ArrayList<Order> terminatedJobs = new ArrayList<>();
	private double earnnings;

	public Mat(SLLQueue<Order> inputQueue) {
		// TODO Auto-generated constructor stub
		this.inputQueue=inputQueue;
	}
	public void execute() {
		Order order;
		int time = 1;
		int lineStackSize = 0;
		LLStack<Order> lineStack = new LLStack<>();

		order = inputQueue.dequeue();

		while(!inputQueue.isEmpty() || !lineStack.isEmpty()) {
			while(!inputQueue.isEmpty() && inputQueue.first().getArrive()==time)
				lineStack.push(inputQueue.dequeue());

			order.setServiceTime(order.getServiceTime()-1);
			if(!lineStack.isEmpty()) {
				lineStackSize = lineStack.size();
				LLStack<Order> tempStack = new LLStack<>();
				for(int i=0;i<lineStackSize;i++) {
					if(tempStack.isEmpty())
						while(!lineStack.isEmpty())
							tempStack.push(lineStack.pop());
					Order temp = tempStack.pop();
					temp.setLevelOfPatience(temp.getLevelOfPatience()-1);
					lineStack.push(temp);
				}
			}
			if(order.getServiceTime()==0) {
				terminatedJobs.add(order);
				for(int i=0; i<lineStackSize;i++) {
					if(lineStack.top().getLevelOfPatience() <= 0)
						lineStack.pop();
					else {
						order = lineStack.pop();
						break;
					}
				}
			}
			time++;
		}
		
		for (int i = 0; i < terminatedJobs.size(); i++) {
			earnnings += terminatedJobs.get(i).getCost();
		}
		
		System.out.println(earnnings);
	}

	
	
}

