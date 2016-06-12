package com.JPMorgan;

/**
 * 
 * @author savant
 *
 */
public class StockValidator {
  enum StockChoices {TEA,POP,ALE,GIN,JOE};
  enum Choices {EXIT,CONTINUE};
  enum BuySellOptions{BUY,SELL};
  /**
   * Validation for stock symbol
   * @param stockSymbol
   * @return boolean
   */
  public boolean isValidStock(String stockSymbol) {
    for (StockChoices c : StockChoices.values()) {
      if (c.name().equals(stockSymbol)) {
        return true;
      }
    }
    return false;
  }
/**
 * Validation for exit/continue option
 * @param stockSymbol
 * @return boolean
 */
  public boolean isValidChoice(String stockSymbol) {
    for (Choices c : Choices.values()) {
      if (c.name().equals(stockSymbol)) {
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
  public boolean isValidQuantity(String quantity){
    try {
      Integer.parseInt(quantity);
      // no exception thrown, that means its a valid quantity
      return true;
    } catch(NumberFormatException e) {
        // invalid quantity
      return false;
    }
  }
  /**
   * Validation for Market Price value
   * @param stockPrice
   * @return boolean
   */
  public boolean isValidPrice(String stockPrice){
    try {
      Double.parseDouble(stockPrice);
      // no exception thrown, that means its a valid price
      return true;
    } catch(NumberFormatException e) {
      // invalid price
      return false;
    }
  }
  /**
   * Validation for buy/sell option
   * @param option
   * @return boolean
   */
  public boolean isValidOption(String option){
    for (BuySellOptions c : BuySellOptions.values()) {
      if (c.name().equals(option)) {
        return true;
      }
    }
    return false;
  }
}
