package com.whl.state.impl;

import com.whl.state.Order;
import com.whl.state.OrderState;

// 已完成状态
public class CompletedState implements OrderState {
  @Override
  public void pay(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已完成，无需支付");
  }

  @Override
  public void ship(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已完成，不能发货");
  }

  @Override
  public void confirmReceipt(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已完成，请勿重复确认收货");
  }

  @Override
  public void cancel(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已完成，不能取消");
  }

  @Override
  public String getStateName() {
    return "已完成";
  }
}
