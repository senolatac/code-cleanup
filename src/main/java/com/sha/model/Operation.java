package com.sha.model;

import java.util.Date;

public class Operation extends BaseModel implements IModel {

    private Date operationDate;
    private boolean succeed;

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
}
