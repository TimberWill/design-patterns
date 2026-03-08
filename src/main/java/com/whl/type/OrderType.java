package com.whl.type;

import com.whl.strategy.DiscountStrategy;

/**
 * 枚举.
 */
public enum OrderType {
  NORMAL(price -> price * 0.9),
  VIP(price -> price * 0.8),
  PRE_SALE(price -> price * 0.85);

  private final DiscountStrategy strategy;

  OrderType(DiscountStrategy strategy) {
    this.strategy = strategy;
  }

  public double applyDiscount(double price) {
    return strategy.calculate(price);
  }
}
