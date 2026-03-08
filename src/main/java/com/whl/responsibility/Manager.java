package com.whl.responsibility;

import com.whl.responsibility.request.PurchaseRequest;

// 经理审批
public class Manager extends Approver {
  public Manager(String name) {
    super(name, "经理");
  }

  @Override
  public void processRequest(PurchaseRequest request) {
    if (request.getAmount() <= 5000) {
      System.out.println("【经理 " + name + "】审批通过：采购单 #" + request.getId()
              + "，金额：" + request.getAmount() + "元，用途：" + request.getPurpose());
    } else {
      forwardToNext(request);
    }
  }
}
