package com.example.demo.web;

import com.example.demo.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
public class LogDemoServiceImpl implements LogDemoService{

    private final MyLogger myLogger;
    @Override
    public void logic(String id) {
        myLogger.log("service id = "+id);
    }
}
