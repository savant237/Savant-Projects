package com.JPMorgan;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author savant
 *
 */
public class SuperSimpleStocks {
  public static void main(String[] args) {
    Map<String, List<TradeRecord>> allTrades = new HashMap<String, List<TradeRecord>>();
    Scanner stock=null;
    StockValidator validator = new StockValidator();
    // TODO Auto-generated method stub
    while(true) {
      stock = new Scanner(System.in);
      //Start of application 
      if(!allTrades.isEmpty()){
      System.out.println("\nWant to EXIT/CONTINUE?");
      String exitContinue = stock.next().toUpperCase();
      while(!validator.isValidChoice(exitContinue)){
        System.out.println("Enter the valid choice(EXIT/CONTINUE): ");
        exitContinue = stock.next().toUpperCase();
      }
      if(exitContinue.equalsIgnoreCase("EXIT")) {
        stock.close();
        System.out.println("Application Terminate");
        break;
      }
      }else {
          System.out.println("/***************************/");
          System.out.println("Super Simple Stocks");
          System.out.println("/***************************/");
      }
      
      System.out.println("\n\nEnter the Stock name from (TEA,POP,ALE,GIN,JOE): ");
      String stockSymbol = stock.next().toUpperCase();
      //check is stock name is valid
      while(!validator.isValidStock(stockSymbol)){
          System.out.println("Enter the valid Stock Name from (TEA,POP,ALE,GIN,JOE): ");
          stockSymbol = stock.next().toUpperCase();
      }
      
      System.out.println("Enter the Market Price of Stock: ");
      String priceVal = stock.next();
      double price;
      //check if market price entered is valid
      while(!validator.isValidPrice(priceVal)){
        System.out.println("Enter the valid numeric Market Price of Stock: ");
        priceVal = stock.next();
      }
      price = Double.parseDouble(priceVal);
      
      System.out.println("Enter the Quantity of stock: ");
      String quantityVal = stock.next();
      int quantity;
      //check if Quantity of share entered is valid
      while(!validator.isValidQuantity(quantityVal)){
          System.out.println("Enter the valid numeric quantity of Stock: ");
          quantityVal = stock.next();
        }
      quantity = Integer.parseInt(quantityVal);
      
      System.out.println("Want to BUY/SELL?: ");
      String indicator = stock.next().toUpperCase();
      //check if Buy/sell indicator value entered is valid
      while(!validator.isValidOption(indicator)){
          System.out.println("Enter the valid Option (BUY/SELL): ");
          indicator = stock.next().toUpperCase();
      }
      
      Date currentTime = new Date(); 
      TradeRecord trade = new TradeRecord(stockSymbol,quantity,  price, indicator,currentTime);
      List<TradeRecord> stockTradeHistory = null ;
      //check if the entered stock already exist in Map
      if(allTrades.get(stockSymbol) == null) {
        //Initialise the stockTradeHistory
        stockTradeHistory = new ArrayList<TradeRecord>();
        //populate map with stockSymbol as key and stockTradeHistory as value
        allTrades.put(stockSymbol, stockTradeHistory);
      }
      else {
        //initialise stockTradeHistory by selecting the record from Map
        stockTradeHistory = allTrades.get(stockSymbol);
      }
      //add new record to the stockTradeHistory list
      stockTradeHistory.add(trade);
      GBCEData gbceData = new GBCEData();
      StockHelper helper = new StockHelper(gbceData,stockSymbol,price,allTrades,currentTime);
      System.out.println("\n\n(A) For a given stock ");
      System.out.printf("   \ni. Dividend yield for stock (%s)is: %.2f", stockSymbol,helper.getDividentYield());
      System.out.printf("   \nii. P/E Ratio for stock (%s)is: %.2f", stockSymbol,helper.getPERatio());
      helper.printStocks();
      helper.geoMetricMeanOfAllStocks();
    }
  }
}
