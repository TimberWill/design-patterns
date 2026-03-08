package com.whl.responsibility;

import com.whl.responsibility.request.PurchaseRequest;

// 总监审批
public class Director extends Approver {
  public Director(String name) {
    super(name, "总监");
  }

  @Override
  public void processRequest(PurchaseRequest request) {
    if (request.getAmount() <= 20000) {
      System.out.println("【总监 " + name + "】审批通过：采购单 #" + request.getId() + "，金额：" + request.getAmount()
              + "元，用途：" + request.getPurpose());
    } else {
      forwardToNext(request);
    }
  }
}
