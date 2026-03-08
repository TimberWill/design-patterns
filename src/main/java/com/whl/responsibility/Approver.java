package com.whl.responsibility;

import com.whl.responsibility.request.PurchaseRequest;

// 审批人抽象类
public abstract class Approver {
  protected Approver nextApprover;  // 下一个审批人
  protected String name;             // 审批人姓名
  protected String position;         // 职位

  public Approver(String name, String position) {
    this.name = name;
    this.position = position;
  }

  // 设置下一个审批人
  public void setNextApprover(Approver nextApprover) {
    this.nextApprover = nextApprover;
  }

  // 审批请求的抽象方法
  public abstract void processRequest(PurchaseRequest request);

  // 转发给下一个审批人
  protected void forwardToNext(PurchaseRequest request) {
    if (nextApprover != null) {
      System.out.println("【" + position + " " + name + "】无权审批，已转交给下一级");
      nextApprover.processRequest(request);
    } else {
      System.out.println("【审批失败】没有合适的审批人处理该请求");
    }
  }
}
