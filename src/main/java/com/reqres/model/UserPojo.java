package com.reqres.model;

public class UserPojo
{
    private String name;                                                        //Goto Post and declare those variables inside payload body

    private String job;                                                        //Request body

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
