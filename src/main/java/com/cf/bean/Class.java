package com.cf.bean;

import java.util.Set;

/**
 * Created by cpazstido on 2016/4/27.
 */
public class Class {
    private int cid;
    private String cname;
    private Set<Person> personSet;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }
}
