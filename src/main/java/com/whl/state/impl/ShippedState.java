package com.whl.state.impl;

import com.whl.state.Order;
import com.whl.state.OrderState;

// 已发货状态
public class ShippedState implements OrderState {
  @Override
  public void pay(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已发货，无需支付");
  }

  @Override
  public void ship(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已发货，请勿重复发货");
  }

  @Override
  public void confirmReceipt(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 确认收货成功");
    // 状态流转：已发货 → 已完成
    order.setState(new CompletedState());
    System.out.println("订单状态变更为：已完成");
  }

  @Override
  public void cancel(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已发货，不能取消，如需退货请申请售后");
  }

  @Override
  public String getStateName() {
    return "已发货";
  }
}
