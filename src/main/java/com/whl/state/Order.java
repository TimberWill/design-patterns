package com.whl.state;

import com.whl.state.impl.PendingPaymentState;

public class Order {
  private OrderState currentState;  // 当前状态
  private int orderId;
  private double amount;

  public Order(int orderId, double amount) {
    this.orderId = orderId;
    this.amount = amount;
    // 初始状态为待付款
    this.currentState = new PendingPaymentState();
    System.out.println("创建订单 #" + orderId + "，金额：" + amount + "元，当前状态：待付款");
  }

  public void setState(OrderState state) {
    this.currentState = state;
  }

  public int getOrderId() {
    return orderId;
  }

  public double getAmount() {
    return amount;
  }

  // 状态相关的方法委托给当前状态对象处理
  public void pay() {
    currentState.pay(this);
  }

  public void ship() {
    currentState.ship(this);
  }

  public void confirmReceipt() {
    currentState.confirmReceipt(this);
  }

  public void cancel() {
    currentState.cancel(this);
  }
}
