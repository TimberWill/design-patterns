package com.whl;

import com.whl.factory.DiscountStrategyFactory;
import com.whl.responsibility.Director;
import com.whl.responsibility.GeneralManager;
import com.whl.responsibility.Manager;
import com.whl.responsibility.TeamLeader;
import com.whl.responsibility.request.PurchaseRequest;
import com.whl.service.OrderService;
import com.whl.state.Order;
import com.whl.strategy.DiscountStrategy;
import com.whl.strategy.impl.VipDiscount;
import com.whl.type.OrderType;
import junit.framework.TestCase;

public class AppTest extends TestCase {

  /**
   * 策略模式测试
    场景：根据用户类型（普通用户、会员用户、VIP用户）应用不同的折扣策略。
    1. 普通用户（Normal）：不打折，原价支付。
    2. 会员用户（Member）：享受10%的折扣。
    3. VIP用户（VIP）：享受20%的折扣。
   */
  public void test01() {
    OrderService service = new OrderService();
    service.setStrategy(new VipDiscount());
    double result = service.applyDiscount(100);
    System.out.println(result);
  }

  /**
   * 工厂模式测试
    场景：根据用户类型（普通用户、会员用户、VIP用户）应用不同的折扣策略。
    1. 普通用户（Normal）：不打折，原价支付。
    2. 会员用户（Member）：享受10%的折扣。
    3. VIP用户（VIP）：享受20%的折扣。
   */
  public void test02() {
    DiscountStrategy strategy = DiscountStrategyFactory.getStrategy("VIP");
    double calculate = strategy.calculate(100);
    System.out.println(calculate);
  }

  /**
   * 枚举策略测试
    场景：根据订单类型（普通订单、会员订单、VIP订单）应用不同的折扣策略。
    1. 普通订单（OrderType.NORMAL）：不打折，原价支付。
    2. 会员订单（OrderType.MEMBER）：享受10%的折扣。
    3. VIP订单（OrderType.VIP）：享受20%的折扣。
   */
  public void test03() {
    double price = 100;
    OrderType type = OrderType.VIP;
    double result = type.applyDiscount(price);
    System.out.println(result);
  }

  /**
   * 责任链模式测试
    场景：公司采购审批流程，根据采购金额不同由不同级别的审批人处理。
    1. TeamLeader（部门主管）审批金额 <= 1000元
    2. Manager（经理）审批金额 > 1000元且 <= 5000元
    3. Director（总监）审批金额 > 5000元且 <= 20000元
    4. GeneralManager（总经理）审批金额 > 20000元且 <= 100000元
    超过100000元的采购单需要董事会审批，暂不处理。
   */
  public void test04() {
    // 创建审批人
    TeamLeader teamLeader = new TeamLeader("张三");
    Manager manager = new Manager("李四");
    Director director = new Director("王五");
    GeneralManager generalManager = new GeneralManager("赵六");

    // 构建责任链
    teamLeader.setNextApprover(manager);
    manager.setNextApprover(director);
    director.setNextApprover(generalManager);

    // 创建采购请求
    PurchaseRequest request1 = new PurchaseRequest(800, "办公用品", 1001);
    PurchaseRequest request2 = new PurchaseRequest(3000, "电脑设备", 1002);
    PurchaseRequest request3 = new PurchaseRequest(15000, "服务器", 1003);
    PurchaseRequest request4 = new PurchaseRequest(50000, "装修工程", 1004);

    // 从链首开始处理
    System.out.println("=== 处理采购单 1001 ===");
    teamLeader.processRequest(request1);

    System.out.println("\n=== 处理采购单 1002 ===");
    teamLeader.processRequest(request2);

    System.out.println("\n=== 处理采购单 1003 ===");
    teamLeader.processRequest(request3);

    System.out.println("\n=== 处理采购单 1004 ===");
    teamLeader.processRequest(request4);
  }

  /**
   * 状态模式测试
    场景：订单状态管理，根据订单的不同状态（待付款、已付款、已发货、已完成、已取消）执行不同的操作。
    1. 待付款（Pending Payment）：用户可以支付订单或取消订单。
    2. 已付款（Paid）：用户可以申请退款或等待发货。
    3. 已发货（Shipped）：用户可以确认收货或申请售后。
    4. 已完成（Completed）：订单已完成，不能再进行操作。
    5. 已取消（Cancelled）：订单已取消，不能再进行操作。
   */
  public void test05() {
    // 创建新订单
    Order order = new Order(10001, 299.9);

    System.out.println("\n=== 测试支付 ===");
    order.pay();  // 待付款 → 支付

    System.out.println("\n=== 测试重复支付 ===");
    order.pay();  // 已付款状态，不能重复支付

    System.out.println("\n=== 测试发货 ===");
    order.ship(); // 已付款 → 发货

    System.out.println("\n=== 测试确认收货 ===");
    order.confirmReceipt(); // 已发货 → 已完成

    System.out.println("\n=== 测试取消已完成订单 ===");
    order.cancel(); // 已完成，不能取消

    System.out.println("\n=== 创建另一个订单测试取消流程 ===");
    Order order2 = new Order(10002, 599.9);
    order2.pay();  // 支付
    order2.cancel(); // 已付款状态可以取消
  }
}
