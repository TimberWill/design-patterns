package com.whl.strategy.impl;

import com.whl.strategy.DiscountStrategy;

public class PreSaleDiscount implements DiscountStrategy {
  @Override
  public double calculate(double price) {
    return price * 0.85;
  }
}
