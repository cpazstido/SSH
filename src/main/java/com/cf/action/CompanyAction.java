package com.cf.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by cpazstido on 2016/4/27.
 */
public class CompanyAction extends ActionSupport {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String add()
    {
        msg="hello world!";
        return SUCCESS;
    }

    public String personJson()
    {
        msg="personJson";
        return SUCCESS;
    }
}
