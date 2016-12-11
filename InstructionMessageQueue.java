package com.savant;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class InstructionMessageQueue {
	private  Queue<InstructionMessage> messagePriorityQueue= new PriorityQueue<>(idComparator);
	public InstructionMessageQueue (Queue<InstructionMessage> messagePriorityQueue){
		this.messagePriorityQueue = messagePriorityQueue;
	}
	
	
	public static Comparator<InstructionMessage> idComparator = new Comparator<InstructionMessage>(){
		  @Override
		    public int compare(InstructionMessage c1, InstructionMessage c2) {
		      return (int) (c1.getInstructionType() - c2.getInstructionType());
		    }
		  };
		  
		  public  boolean addMessageToQueue(InstructionMessage message) {
			    
			    return messagePriorityQueue.add(message);
			   
			  }
			  /**
			   * Method to retrieveMessageFromQueue
			   * @return message
			   */
			  
			public  String retrieveMessageFromQueue() {
			    if(!isEmpty()){
			      InstructionMessage stu = messagePriorityQueue.peek();
			      return stu.toString();
			    }else {
			      return "Queue is empty";
			    }
			  }

			  /**
			   * Method to removeMessageFromQueue
			   * @return message
			   */
			  public String removeMessageFromQueue() {
			    if(!isEmpty()){
			      InstructionMessage stu = messagePriorityQueue.poll();
			      return stu.toString();
			    }else {
			      return "Queue is empty";
			    }
			  }
			  /**
			   * Method to check if Queue is empty
			   * @return boolean 
			   */
			  public  boolean isEmpty(){
			    return messagePriorityQueue.isEmpty();
			  }
			  /**
			   * Method to check size of Queue 
			   * @return message
			   * 
			   */
			  public int sizeOfQueue(){
			    return messagePriorityQueue.size();
			  }
			}



