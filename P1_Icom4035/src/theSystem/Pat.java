package theSystem;

import java.util.ArrayList;

import structures.SLLQueue;

public class Pat {
	private SLLQueue<Order> inputQueue;
	private double money;
	private int peopleAttended;


	public Pat(SLLQueue<Order> inputQueue) {
		this.inputQueue = inputQueue;
	}



	public void Execute() {
		SLLQueue<Order> lineQueue = new SLLQueue<>();
		ArrayList<Order> orderQueue = new ArrayList<>();
		int time = 0;
		double profit = 0;


		while(!inputQueue.isEmpty() || !lineQueue.isEmpty()) {

			try {

				if (inputQueue.first().getArrive()==time) {
					lineQueue.enqueue(inputQueue.dequeue());
				}

			} catch (Exception e) {
				// TODO: handle exception
			}


			if (!lineQueue.isEmpty()) {
				lineQueue.first().setServiceTime(lineQueue.first().getServiceTime()-1);
			}


			if (!inputQueue.isEmpty()) {

				while (inputQueue.first().getArrive() == time) {
					lineQueue.enqueue(inputQueue.dequeue());

				}
			}

			if (!lineQueue.isEmpty()) {
				lineQueue.enqueue(lineQueue.dequeue());
				for (int i = 0; i < lineQueue.size()-1; i++) {
					lineQueue.first().setLevelOfPatience(lineQueue.first().getLevelOfPatience()-1);
					lineQueue.enqueue(lineQueue.dequeue());
				}


			}


			try {
				if (lineQueue.first().getServiceTime()==0) {
					orderQueue.add(lineQueue.dequeue());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}




			try {
				if (lineQueue.first().getLevelOfPatience()<=0) {
					lineQueue.dequeue();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}



			time++;



		}


		for (int i = 0; i < orderQueue.size(); i++) {
			money += orderQueue.get(i).getCost();
		}
		
		peopleAttended = orderQueue.size();
		
		System.out.println(peopleAttended);
		System.out.println(money);



	}
}


