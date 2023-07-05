package com.example.demogcp.service;

import com.example.demogcp.entity.TestEntity;
import com.example.demogcp.repository.TestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public List<TestEntity> findAll(){
        return testRepository.findAll();
    }

}
