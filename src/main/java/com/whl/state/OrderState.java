package com.whl.state;

public interface OrderState {
    // 支付
    void pay(Order order);
    // 发货
    void ship(Order order);
    // 确认收货
    void confirmReceipt(Order order);
    // 取消订单
    void cancel(Order order);

    // 获取状态名称
    String getStateName();
}
