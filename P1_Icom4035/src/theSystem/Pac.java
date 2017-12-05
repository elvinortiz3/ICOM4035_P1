package theSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import structures.SLLQueue;

public class Pac {

	private SLLQueue<Order> inputQueue = new SLLQueue<>();
	private ArrayList<Order> terminatedOrders = new ArrayList<>();
	private double maxLevelPatience;
	private int maxIndex;

	public Pac(SLLQueue<Order> inputQueue) {
		this.inputQueue = inputQueue;
	}

	public void execute() {
		Order order;
		ArrayList<Order> processingList = new ArrayList<>();
		int time = 1;
		double earnings = 0;

		order = inputQueue.dequeue();

		while(!inputQueue.isEmpty() || !processingList.isEmpty()) {
			while(!inputQueue.isEmpty() && inputQueue.first().getArrive()==time)
				processingList.add(inputQueue.dequeue());

			order.setServiceTime(order.getServiceTime()-1);

			if(!processingList.isEmpty()) 
				for (Order orders : processingList) 
					orders.setLevelOfPatience(orders.getLevelOfPatience()-1);

			if(order.getServiceTime()==0) {
				terminatedOrders.add(order);


				for (int i = 0; i < processingList.size(); i++) {

					if (processingList.get(i).getLevelOfPatience()>0) {

						maxLevelPatience = processingList.get(i).getLevelOfPatience();
						maxIndex = i;
						break;
					}

				}

				for(int i=0; i<processingList.size(); i++) {
					if(processingList.get(i).getLevelOfPatience() < maxLevelPatience && processingList.get(i).getLevelOfPatience() >0) {
						maxLevelPatience = processingList.get(i).getLevelOfPatience();
						maxIndex = i;
					}
				}
				
				
				order = processingList.remove(maxIndex);
				SLLQueue<Order> temp = new SLLQueue<>();
				for(int i =0; i<processingList.size(); i++) 
					if(!(processingList.get(i).getLevelOfPatience() <= 0))
						temp.enqueue(processingList.get(i));

			
				int tempSize = temp.size();
				processingList.clear();
				for(int i=0 ; i < tempSize; i++)
					processingList.add(temp.dequeue());

			}
			time++;
		}
		terminatedOrders.add(order);

		for(int i=0; i<terminatedOrders.size(); i++)
			earnings+=terminatedOrders.get(i).getCost();

		System.out.println(earnings);
		System.out.println(terminatedOrders.size());
	}
}
