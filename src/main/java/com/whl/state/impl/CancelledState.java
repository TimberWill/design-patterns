package com.whl.state.impl;

import com.whl.state.Order;
import com.whl.state.OrderState;

// 已取消状态
public class CancelledState implements OrderState {
  @Override
  public void pay(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已取消，不能支付");
  }

  @Override
  public void ship(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已取消，不能发货");
  }

  @Override
  public void confirmReceipt(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已取消，不能确认收货");
  }

  @Override
  public void cancel(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已取消，请勿重复取消");
  }

  @Override
  public String getStateName() {
    return "已取消";
  }
}
