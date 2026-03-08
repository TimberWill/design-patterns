package com.whl.state.impl;

import com.whl.state.Order;
import com.whl.state.OrderState;

// 待付款状态
public class PendingPaymentState implements OrderState {
  @Override
  public void pay(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 支付成功，金额：" + order.getAmount() + "元");
    // 状态流转：待付款 → 已付款
    order.setState(new PaidState());
    System.out.println("订单状态变更为：已付款");
  }

  @Override
  public void ship(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 尚未付款，不能发货");
  }

  @Override
  public void confirmReceipt(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 尚未付款，不能确认收货");
  }

  @Override
  public void cancel(Order order) {
    System.out.println("订单 #" + order.getOrderId() + " 取消成功");
    order.setState(new CancelledState());
    System.out.println("订单状态变更为：已取消");
  }

  @Override
  public String getStateName() {
    return "待付款";
  }
}
