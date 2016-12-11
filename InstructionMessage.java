package com.savant;

public class InstructionMessage {
  private int InstructionType;
  private int ProductCode;
  private int Quantity;
  private int UOM;
  private int TimeStamp;
  
  public InstructionMessage( final int InstructionType, final int ProductCode,final  int Quantity,final int UOM,final int TimeStamp) {
    this.InstructionType = InstructionType;
    this.ProductCode = ProductCode;
    this.Quantity = Quantity;
    this.UOM = UOM;
    this.TimeStamp = TimeStamp;
  }
  
  public void setInstructionType(int InstructionType) {
    this.InstructionType = InstructionType;
  }
  
  public int getInstructionType() {
    return InstructionType;
  }
  
  public void setProductCode(int ProductCode) {
    this.ProductCode = ProductCode;
  }
  
  public int getProductCode() {
    return ProductCode;
  }
  
  public void setQuantity(int Quantity) {
    this.Quantity = Quantity;
  }
  
  public int getQuantity() {
    return Quantity;
  }
  
  public void setUOM(int UOM) {
    this.UOM = UOM;
  }
  
  public int getUOM() {
    return UOM;
  }
  
  public void setTimeStamp(int TimeStamp) {
    this.TimeStamp = TimeStamp;
  }
  
  public int getTimeStamp() {
    return TimeStamp;
  }

  public String toString() {
    return "Message has instruction type :"+ getInstructionType() 
        + ",  productCode :"+ getProductCode()
        + ", quantity :"+ getQuantity()
        + ", uom :"+ getUOM()
        + ", timeStamp :"+ getTimeStamp();
  }
}
