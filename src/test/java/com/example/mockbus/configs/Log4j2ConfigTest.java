package com.example.mockbus.configs;

import org.junit.Test;

import static org.junit.Assert.*;

public class Log4j2ConfigTest {
    @Test
    public void testPerformSomeTask() throws Exception {
        Log4j2Config log4J2PropertiesConf=new Log4j2Config();
        log4J2PropertiesConf.performSomeTask();
    }

}