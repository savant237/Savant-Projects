package com.savant.PriorityQueueTest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;
import junit.framework.Assert;
import com.savant.InstructionMessage;
import com.savant.InstructionMessageQueue;

@SuppressWarnings("deprecation")
public class InstructionMessageQueueTest{
  Queue<InstructionMessage> messagePriorityQueue= new PriorityQueue<>(idComparator);
  public static Comparator<InstructionMessage> idComparator = new Comparator<InstructionMessage>(){
    @Override
      public int compare(InstructionMessage c1, InstructionMessage c2) {
        return (int) (c1.getInstructionType() - c2.getInstructionType());
      }
    };
    InstructionMessage message1 = new InstructionMessage(1,1,1,1,1);
    InstructionMessage message2 = new InstructionMessage(2,2,2,2,2);
    InstructionMessageQueue queue = new InstructionMessageQueue(messagePriorityQueue);
    @Test
  public void addMessagesToIntructionMessageQueueTest() {
    
    Assert.assertEquals("addMessagesToIntructionMessageQueueTest#1",true,queue.addMessageToQueue(message1));
  }
    @Test
  public void removeMessagesFromIntructionMessageQueueTest() {
        queue.addMessageToQueue(message1);
        Assert.assertEquals("removeMessagesFromIntructionMessageQueueTest#1",message1.toString(),queue.removeMessageFromQueue());
  }
    @Test
    public void retriveMessagesFromIntructionMessageQueueTest() {
       
        queue.addMessageToQueue(message1);
        queue.addMessageToQueue(message2);
        Assert.assertEquals("retriveMessagesFromIntructionMessageQueueTest#1",message1.toString(),queue.retrieveMessageFromQueue());
  }
    @Test
    public void sizeOfIntructionMessageQueueTest() {
        queue.addMessageToQueue(message1);
        queue.addMessageToQueue(message2);
        Assert.assertEquals("sizeOfIntructionMessageQueueTest#1",2,queue.sizeOfQueue());
  }
    @Test
    public void isEmptyIntructionMessageQueueTest() {
        queue.addMessageToQueue(message1);
        queue.removeMessageFromQueue();
        Assert.assertEquals("isEmptyIntructionMessageQueueTest#1",true,queue.isEmpty());
        queue.addMessageToQueue(message1);
        Assert.assertEquals("isEmptyIntructionMessageQueueTest#2",false,queue.isEmpty());
  }
}
