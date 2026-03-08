package com.whl.strategy;

/**
 * 策略模式.
 */
//@FunctionalInterface
public interface DiscountStrategy {
  double calculate(double price);
}
