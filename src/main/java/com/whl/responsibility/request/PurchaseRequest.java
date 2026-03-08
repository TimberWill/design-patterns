package com.whl.responsibility.request;

/**
 * 采购请求.
 */
public class PurchaseRequest {
  private double amount;      // 采购金额
  private String purpose;     // 采购目的
  private int id;             // 请求编号

  public PurchaseRequest(double amount, String purpose, int id) {
    this.amount = amount;
    this.purpose = purpose;
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public String getPurpose() {
    return purpose;
  }

  public int getId() {
    return id;
  }
}
