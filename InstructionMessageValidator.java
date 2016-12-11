package com.savant;

/**
 * 
 * @author savant
 *
 */
public class InstructionMessageValidator {
  enum Choices {EXIT,CONTINUE};
  enum Options{Y,N};
  
  
/**
 * Validation for exit/continue option
 * @param Symbol
 * @return boolean
 */
  public boolean isValidChoice(String symbol) {
    for (Choices c : Choices.values()) {
      if (c.name().equalsIgnoreCase(symbol)) {
        return true;
      }
    }
    return false;
  }
  /**
   * Validation for Quantity of share value
   * @param quantity
   * @return boolean
   */
  public boolean isValidInstructionType(final int instructionType){
    
    if (instructionType >0 && instructionType < 100) {
    return true;
    }else {
      throw new InvalidMessageException("Message has invalid InstructionType, please try again and enter integer(n) : 0<n<100");
      
    }
    
  }
  public boolean isValidInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    }catch (NumberFormatException e) {
      return false;
    }
  }
  /**
   * Validation for ProductCode value
   * @param productCode
   * @return boolean
   */
  public boolean isValidProductCode(final int productCode){
    
    if (productCode >0 ) {
      return true;
      }else {
        throw new InvalidMessageException("Message has invalid ProductCode, please try again and enter integer(n) : 0<n");
      }
    }
  /**
   * Validation for Quantity value
   * @param quantity
   * @return boolean
   */
  public boolean isValidQuantity(final int quantity){
    if (quantity >0 ) {
      return true;
      }else {
        throw new InvalidMessageException("Message has invalid Quantity, please try again and enter integer(n) : 0<n");
      }
    }
  /**
   * Validation for UOM value
   * @param uom
   * @return boolean
   */
  public boolean isValidUOM(final int uom){
    if (uom >=0 && uom < 256 ) {
      return true;
      }else {
        throw new InvalidMessageException("Message has invalid UOM, please try again and enter integer(n) : 0<=n<256");
      }
    }
  /**
   * Validation for TimeStamp value
   * @param timeStamp
   * @return boolean
   */
  public boolean isValidTimeStamp(final int timeStamp){
    if (timeStamp > 0) {
      return true;
      }else {
        throw new InvalidMessageException("Message has invalid TimeStamp, please try again and enter integer(n) : 0<n");
      }
    }
  /**
   * Validation for Y/N option
   * @param option
   * @return boolean
   */
  public boolean isValidOption(String option){
    for (Options c : Options.values()) {
      if (c.name().equalsIgnoreCase(option)) {
        return true;
      }
    }
    return false;
  }
}

