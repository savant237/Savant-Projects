package com.JPMorgan;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class StockHelper {
  GBCEData gbceData;
  private String stock;
  private double price;
  Map<String, List<TradeRecord>> allTrades = null;
  Date currentTime = null;
  public StockHelper(GBCEData gbceData, String stock, Double price,Map<String, List<TradeRecord>> allTrades,Date currentTime) {
    this.gbceData = gbceData;
    this.stock = stock;
    this.price = price;
    this.allTrades = allTrades;
    this.currentTime = currentTime;
  }
  /**
   * This method is used to calculate the dividend yield.
   * 
   * @return Dividend Yield (dy) 
   */
  public double getDividentYield() {
    double dy = 0;
    double lastDiv = ((Double)gbceData.getStockLastDiv().get(stock)).doubleValue();
    double parVal = ((Double)gbceData.stockParVal.get(stock)).doubleValue();
    String type = ((String)gbceData.stockType.get(stock)).toString();
    if (type.equals("Common")){
      try {
        dy = lastDiv / price;
      }catch (ArithmeticException e) {
        System.out.println("Please enter valid price .Zero is not a valid price value");
        e.printStackTrace();
      }
    } else if(type.equals("Preferred")) {
      int fixDiv = ((Integer)gbceData.stockFixedDiv.get(stock)).intValue();
      try {
        dy = (fixDiv * parVal)/price;
      }catch (ArithmeticException e) {
        System.out.println("Please enter valid price .Zero is not a valid price value");
        e.printStackTrace();
      }
    }
    return dy;
  }
  /**
   * This method is used to calculate the P/E ratio
   * @return P/E ratio (per )
   */
  public double getPERatio(){
    double dividend = getDividentYield();
    double per = 0;
    try {
      per = dividend == 0 ? dividend : price/dividend;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }
    return per;
  }
  
  /**
   * Method used to print  recode of all trade 
   * and Volume Weighted Stock Price 
   * 
   */
  public void printStocks() {
    Iterator<String> listIter= allTrades.keySet().iterator();
    System.out.println("   \niii.*******Record of trade *****************************/");
    System.out.printf("   %-12s%-12s%-12s%-12s%-12s\n","Stock","Timestamp","Quantity ","Buy/Sell ","Trade Price");
    while(listIter.hasNext()) {
      String stockName = listIter.next();
      List<TradeRecord> stockLists = allTrades.get(stockName);
      for(TradeRecord trade : stockLists) {
        System.out.printf("   %-12s%-12s%-12d%-12s%-12.2f\n",trade.getStockSymbol(),trade.getFormatedTime(),trade.getQuantity(),trade.getIndicator(),trade.getPrice());
      }
    }
    System.out.println("   /********************************************************/");
    listIter= allTrades.keySet().iterator();
    System.out.println("iv.*******Volume Weighted Stock Price *******************/");
    while(listIter.hasNext()) {
      String stockName = listIter.next();
      List<TradeRecord> stockLists = allTrades.get(stockName);
      double waverage = weightedAverage(currentTime, stockLists);
      System.out.println("    Wieghted average of "+stockName + " : " + waverage);
    }
      System.out.println("   /********************************************************/");
  }
  /**
   * 
   * @return Methode used to calculate the geometric mean of all stocks 
   */
  public void geoMetricMeanOfAllStocks() {
    Iterator<String> listIter= allTrades.keySet().iterator();
    System.out.println("\n(B) Geometric Mean of Stock ");
    while(listIter.hasNext()) {
      String stockName = listIter.next();
      List<TradeRecord> stockLists = allTrades.get(stockName);
      double result = geoMetricMean( stockLists);
      System.out.printf(" \nGeometric Mean of Stock %s : %.2f ", stockName, result);
    }
  }
  /**
   * @param stockTradeHistory list of all trade record for one stock
   * @return geoMean geometric mean of prices for all stocks
   */
  public double geoMetricMean(List<TradeRecord> stockTradeHistory) {
    ListIterator<TradeRecord> li = stockTradeHistory.listIterator();
    double val = 1;
    double geoMean = 0;
    while(li.hasNext()) {
      TradeRecord trade = li.next();
      val = val*trade.getPrice();
    }
    geoMean = Math.pow(val, 1.0/stockTradeHistory.size());
    return geoMean;
  }
/**
 * 
 * @param timeStamp
 * @param stockTradeHistory
 * @return Volume Weighted Stock Price 
 */
  public double weightedAverage(Date timeStamp, List<TradeRecord> stockTradeHistory) {
    ListIterator<TradeRecord> li = stockTradeHistory.listIterator(stockTradeHistory.size());
    int totalQuantity = 0;
    double totalPrice= 0.0;
    while(li.hasPrevious()) {
      TradeRecord trade = li.previous();
      if(trade.getTimeStamp().after(timeOffset(timeStamp,15))) {
        totalPrice = totalPrice + trade.getPrice()*trade.getQuantity();
        totalQuantity = totalQuantity + trade.getQuantity();
      }
      else {
        break;
      }
    }
    return totalQuantity == 0 ? totalQuantity : totalPrice/totalQuantity;
  }

  /**
   * Method used to calculate the timeoffset 
   * which is 15 min less than the current time.
   * @param time
   * @param offset
   * @return date
   */
  public Date timeOffset (Date time, int offset) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(time);
    cal.add(Calendar.MINUTE, -offset);
    return cal.getTime();
  }
}
