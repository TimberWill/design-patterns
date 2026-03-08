package com.whl.factory;

import com.whl.strategy.DiscountStrategy;
import com.whl.strategy.impl.NormalDiscount;
import com.whl.strategy.impl.PreSaleDiscount;
import com.whl.strategy.impl.VipDiscount;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式.
 */
public class DiscountStrategyFactory {
  private static Map<String, DiscountStrategy> strategies = new HashMap<>();

  static {
    strategies.put("NORMAL", new NormalDiscount());
    strategies.put("VIP", new VipDiscount());
    strategies.put("PRE_SALE", new PreSaleDiscount());
  }

  public static DiscountStrategy getStrategy(String type) {
    DiscountStrategy strategy = strategies.get(type);
    if (strategy == null) {
      throw new IllegalArgumentException("未知类型");
    }
    return strategy;
  }
}
