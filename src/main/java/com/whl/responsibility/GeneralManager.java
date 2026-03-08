package com.whl.responsibility;

import com.whl.responsibility.request.PurchaseRequest;

public class GeneralManager extends Approver  {
  public GeneralManager(String name) {
    super(name, "总经理");
  }

  @Override
  public void processRequest(PurchaseRequest request) {
    if (request.getAmount() <= 100000) {
      System.out.println("【总经理 " + name + "】审批通过：采购单 #" + request.getId() + "，金额：" + request.getAmount()
              + "元，用途：" + request.getPurpose());
    } else {
      System.out.println("【审批拒绝】采购金额 " + request.getAmount() + "元超出总经理权限，需董事会审批");
    }
  }
}
