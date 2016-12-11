package com.savant;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class InstructionMessageQueueMain {
  private static boolean input = true;
  private static Scanner in =  new Scanner(System.in);
  private static InstructionMessageValidator validator = new InstructionMessageValidator();
  private static InstructionMessageQueue queue;

  public static void main(String[] args) {
    Queue<InstructionMessage> messagePriorityQueue= new PriorityQueue<>(idComparator);
    queue= new InstructionMessageQueue(messagePriorityQueue);
    while(input){
      System.out.println("Enter instruction message");
      addMessageToQueue(queue);
      System.out.println("Want to remove the message(Y/N)");
      String yN = in.next();
      while(!validator.isValidOption(yN)){
        System.out.println("Invalid entry, Please try again want to remove the message(Y/N)");
        yN = in.next(); 
      }
      if( yN.equalsIgnoreCase("Y")){
        removeMessageFromQueue(queue);
      }
      System.out.println("Want to retrieve the message(Y/N)");
      String retMsg = in.next();
      while (!validator.isValidOption(retMsg)) {
        System.out.println("Invalid entry, Please try again want to retrieve the message(Y/N)");
        retMsg = in.next();
      }
      if( retMsg.equalsIgnoreCase("Y")){
        retrieveMessageFromQueue(queue);
      }
      sizeOfQueue(queue);
      System.out.println("Exit/Continue");
      String exitContinue = in.next();
      while (!validator.isValidChoice(exitContinue)){
        System.out.println("Invalid entry, Please try again Exit/Continue");
        exitContinue = in.next();  
      }

      if(exitContinue.equalsIgnoreCase("Exit")) {
        input = false;
      }
    }
  }

  public static Comparator<InstructionMessage> idComparator = new Comparator<InstructionMessage>(){
  @Override
    public int compare(InstructionMessage c1, InstructionMessage c2) {
      return (int) (c1.getInstructionType() - c2.getInstructionType());
    }
  };
  /**
   * Method to addMessageToQueue
   * @param InstructionMessageQueue queue
   */
  public static void addMessageToQueue(InstructionMessageQueue queue) {
    int instructionType= 0;
    int productCode= 0;
    int quantity= 0;
    int uom = 0;
    int timeStamp = 0;
    
    System.out.println("Enter message InstructionType");
    String instructionTypeValue = in.next();
    while(!validator.isValidInteger(instructionTypeValue)) {
      System.out.println("Enter valid integer value of InstructionType");
      instructionTypeValue = in.next();
    }
    instructionType = Integer.parseInt(instructionTypeValue);

    System.out.println("Enter message ProductCode");
    String productCodeValue = in.next();
    while(!validator.isValidInteger(productCodeValue)) {
      System.out.println("Enter valid integer value of ProductCode");
      productCodeValue = in.next();
    }
    productCode = Integer.parseInt(productCodeValue);

    System.out.println("Enter message Quantity");
    String quantityValue = in.next();
    while(!validator.isValidInteger(quantityValue)) {
      System.out.println("Enter valid integer value of Quantity");
      quantityValue = in.next();
    }
    quantity= Integer.parseInt(quantityValue);

    System.out.println("Enter message UOM");
    String uomValue = in.next();
    while(!validator.isValidInteger(uomValue)) {
      System.out.println("Enter valid integer value of UOM");
      uomValue = in.next();	
    }
    uom = Integer.parseInt(uomValue);

    System.out.println("Enter message TimeStamp");
    String timeStampValue = in.next();
    while(!validator.isValidInteger(timeStampValue)) {
      System.out.println("Enter valid integer value of TimeStamp");
      timeStampValue = in.next();	
    }
    timeStamp = Integer.parseInt(timeStampValue);
    
    InstructionMessage message = new InstructionMessage(instructionType,productCode,quantity,uom,timeStamp);
    InstructionMessageValidator validator = new InstructionMessageValidator();
    try {
    if(validator.isValidInstructionType(message.getInstructionType()) && validator.isValidProductCode(message.getProductCode()) 
    && validator.isValidQuantity(message.getQuantity()) && validator.isValidTimeStamp(message.getTimeStamp()) 
    && validator.isValidUOM(message.getUOM())) {
    queue.addMessageToQueue(message);
    }
    }catch (InvalidMessageException e) {
      System.out.println(e.getMessage());
      addMessageToQueue(queue);
    }
  }
  /**
   * Method to retrieveMessageFromQueue
   * @param InstructionMessageQueue queue
   */
  private static void retrieveMessageFromQueue(InstructionMessageQueue queue) {
    if(!queue.isEmpty()){
      String stu = queue.retrieveMessageFromQueue();
      System.out.println("Message =" + stu);
    }else {
      System.out.println("Queue is empty");
    }
  }

  /**
   * Method to removeMessageFromQueue
   * @param InstructionMessageQueue queue
   */
  public static void removeMessageFromQueue(InstructionMessageQueue queue) {
    if(!queue.isEmpty()){
      String stu = queue.removeMessageFromQueue();
      System.out.println("Removed message is=" + stu);
    }else {
      System.out.println("Queue is empty");
    }
  }
  /**
   * Method to check if Queue is empty
   * @param InstructionMessageQueue queue
   * @return boolean 
   */
  public static boolean isEmpty(InstructionMessageQueue queue){
    return queue.isEmpty();
  }
  /**
   * Method to check size of Queue 
   * @param InstructionMessageQueue queue
   * 
   */
  public static void sizeOfQueue(InstructionMessageQueue queue){
    System.out.println("Number of InstructionMessages are: "+ queue.sizeOfQueue());
  }
}

