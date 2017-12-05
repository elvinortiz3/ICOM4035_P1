package theSystem;

import java.util.*;

import structures.LLStack;
import structures.SLLQueue;

import java.nio.*;
import java.nio.file.*;

public class Main {



	public static void main(String[] args) {
		String[] result = null;
		



		SLLQueue<Order> inputQueue = new SLLQueue<>();
	


		/**This part receives the info of CSV files and save the info on a array of Strings call "Result"**/
		try {

			List<String> lines = Files.readAllLines(Paths.get("/home/fernando/Desktop/P1_Icom4035/src/data/input1.csv"));
			for (String line : lines) {

				line = line.replace("\"", "");
				line = line.replace("$", "");
				result = line.split(",");
				

				Order myJob = new Order(Integer.parseInt(result[0]), Integer.parseInt(result[1]), Integer.parseInt(result[2]), Double.parseDouble(result[3]), Integer.parseInt(result[4]));
				inputQueue.enqueue(myJob);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Pat FCFS = new Pat(inputQueue);
		Mat LCFS = new Mat(inputQueue);
		Max max = new Max(inputQueue);
		Pac pac = new Pac(inputQueue);
		
		pac.execute();
		
		//FCFS.Execute();
		//LCFS.execute();
		
		



	

	
	}

}
