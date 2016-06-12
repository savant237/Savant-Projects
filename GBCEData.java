package com.JPMorgan;

import java.util.Hashtable;
/**
 * 
 * @author savant
 *
 */
public class GBCEData {
  Hashtable<String, String> stockType ;
  Hashtable<String, Double> stockLastDiv;
  Hashtable<String, Integer> stockFixedDiv;
  Hashtable<String, Double> stockParVal;

  /**
   * Constructor for class GBCEData
   */
  public GBCEData(){
    stockType = new Hashtable<String, String>();
    stockLastDiv = new Hashtable<String, Double>();
    stockFixedDiv = new Hashtable<String, Integer>();
    stockParVal = new Hashtable<String, Double>(); 
    createData();
  }
  /**
   * createData() method is used to populate each instance of 
   * Hashtable<E,E>
   */
  public void createData(){
    stockType.put("TEA","Common");
    stockType.put("POP","Common");
    stockType.put("ALE","Common");
    stockType.put("GIN","Prefered");
    stockType.put("JOE","Common");
  
    stockLastDiv.put("TEA",new Double(0.00));
    stockLastDiv.put("POP",new Double(0.80));
    stockLastDiv.put("ALE",new Double(0.23));
    stockLastDiv.put("GIN",new Double(0.08));
    stockLastDiv.put("JOE",new Double(0.13));
  
    stockFixedDiv.put("GIN", new Integer(2));
  
    stockParVal.put("TEA",new Double(1));
    stockParVal.put("POP",new Double(1));
    stockParVal.put("ALE",new Double(0.60));
    stockParVal.put("GIN",new Double(1));
    stockParVal.put("JOE",new Double(2.5));
  }
  /**
   * 
   * @return stockType 
   */
  public Hashtable<String, String> getStockType(){
    return stockType;
  }
  /**
   * 
   * @return stockLastDiv
   */
  
  public Hashtable<String, Double> getStockLastDiv(){
    return stockLastDiv;
  }
  
  /**
   * 
   * @return stockFixedDiv
   */
  public Hashtable<String, Integer> getStockFixedDiv(){
    return stockFixedDiv;
  }
  /**
   * 
   * @return stockParVal
   */
  public Hashtable<String, Double> getStockParVal(){
    return stockParVal;
  }
  public static void main(String[] arg) {
    new  GBCEData();
  }
}


