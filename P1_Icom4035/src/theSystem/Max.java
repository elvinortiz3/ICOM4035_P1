package theSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import structures.SLLQueue;

public class Max {

	private SLLQueue<Order> inputQueue = new SLLQueue<>();
	private ArrayList<Order> terminatedOrders = new ArrayList<>();
	private double maxProfit;
	private int maxProfitIndex;

	public Max(SLLQueue<Order> inputQueue) {
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

						maxProfit = processingList.get(i).getCost();
						maxProfitIndex = i;
						break;
					}

				}

				for(int i=0; i<processingList.size(); i++) {
					if(processingList.get(i).getCost() > maxProfit && processingList.get(i).getLevelOfPatience() >0) {
						maxProfit = processingList.get(i).getCost();
						maxProfitIndex = i;
					}
				}
				
				
				order = processingList.remove(maxProfitIndex);
				SLLQueue<Order> temp = new SLLQueue<>();
				for(int i =0; i<processingList.size(); i++) 
					if(!(processingList.get(i).getLevelOfPatience() <= 0))
						temp.enqueue(processingList.get(i));

				//Queue<Order> temp = new LinkedList<>(processingList);
				int tempSize = temp.size();
				processingList.clear();
				for(int i=0 ; i < tempSize; i++)
					processingList.add(temp.dequeue());


				//				for(int i = 0; i<temp.size();i++) {
				//					if(temp.peek().getLevelOfPatience() <= 0)
				//						temp.poll();
				//					else
				//						processingList.add(temp.peek());
				//				}


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
