package com.example.demogcp.service;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class TestServiceTest {

    @Autowired
    TestService testService;

    @Test
    void findAll() {
//        結果應該要長
//        TestEntity(entryId=1, guestName=first guest, content=I got here!)
//        TestEntity(entryId=2, guestName=second guest, content=Me too!)
        testService.findAll().forEach(e-> System.out.println(e.toString()));
    }
}