package com.whl.singleton;

/**
 * 单例设计模式.
 */
public class Singleton {

  private static final Singleton instance = new Singleton();

  //  私有构造函数，防止外部实例化
  private Singleton() {
    if (instance != null) {
      throw new RuntimeException("单例对象已存在");
    }
  }

  // 全局访问点，获取单例实例
  public static Singleton getInstance() {
    return instance;
  }
}
