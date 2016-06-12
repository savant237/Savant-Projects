package com.JPMorgan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author savant
 *
 */
public class TradeRecord {
  private String stockSymbol="";
  private Date time;
  private int quantity;
  private double price;
  private String indicator="";
  /**
   * 
   * @param stockSymbol Name of the Stock
   * @param quantity Number of share of stock
   * @param price Market Price of Stock
   * @param indicator  Buy/Sell indicator
   * @param time Timestamp of processing of trade
   */
  public TradeRecord(String stockSymbol, int quantity, double price,String indicator, Date time){
    this.stockSymbol = stockSymbol;
    this.quantity = quantity;
    this.price = price;
    this.time = time;
    this.indicator = indicator;
  }
  /**
   * 
   * @return time String format of time 
   */
  public String getFormatedTime(){
    Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
      String time = sdf.format(cal.getTime());
      return time;
  }
  /*
   * @return stockSymbol
   */
  public String getStockSymbol() {
    return stockSymbol;
  }
  /**
   * 
   * @return quantity
   */
  public int getQuantity() {
    return quantity;
  }
  /**
   * 
   * @return price
   */
  public double getPrice() {
    return price;
  }
  /**
   * 
   * @return time 
   */
  public Date getTimeStamp() {
    return time;
  }
  /*
   * @return indicator  buy/sell
   */
  public String getIndicator() {
    return indicator;
  }

}
