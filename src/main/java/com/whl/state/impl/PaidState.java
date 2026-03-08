package com.whl.state.impl;

import com.whl.state.Order;
import com.whl.state.OrderState;

// 已付款状态
public class PaidState implements OrderState {
  @Override
  public void pay(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 已付款，请勿重复支付");
  }

  @Override
  public void ship(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 发货成功");
    // 状态流转：已付款 → 已发货
    order.setState(new ShippedState());
    System.out.println("订单状态变更为：已发货");
  }

  @Override
  public void confirmReceipt(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 尚未发货，不能确认收货");
  }

  @Override
  public void cancel(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 申请退款成功，订单取消");
    order.setState(new CancelledState());
    System.out.println("订单状态变更为：已取消");
  }

  @Override
  public String getStateName() {
    return "已付款";
  }
}
