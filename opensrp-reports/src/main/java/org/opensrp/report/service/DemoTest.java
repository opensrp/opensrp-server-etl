package org.opensrp.report.service;

import org.springframework.stereotype.Component;

@Component
public class DemoTest {

    private String name;

    public DemoTest() {
        System.err.println("dddd");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
