package com.whl.service;

import com.whl.strategy.DiscountStrategy;

public class OrderService {
  private DiscountStrategy strategy;

  public void setStrategy(DiscountStrategy strategy) {
    this.strategy = strategy;
  }

  public double applyDiscount(double price) {
    return strategy.calculate(price);
  }

}
