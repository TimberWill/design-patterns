package com.whl.responsibility;

import com.whl.responsibility.request.PurchaseRequest;

// 组长审批
public class TeamLeader extends Approver {
  public TeamLeader(String name) {
    super(name, "组长");
  }

  @Override
  public void processRequest(PurchaseRequest request) {
    if (request.getAmount() <= 1000) {
      System.out.println("【组长 " + name + "】审批通过：采购单 #" + request.getId() + "，金额：" + request.getAmount()
              + "元，用途：" + request.getPurpose());
    } else {
      forwardToNext(request);
    }
  }
}
