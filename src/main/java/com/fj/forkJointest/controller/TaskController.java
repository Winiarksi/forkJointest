package com.fj.forkJointest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TaskController {

    @Autowired
    StateMachine<String, String> stateMachine;


    @GetMapping("/letsDance")
    public String letsDance() {
        stateMachine.sendEvent("E1");

        return "Wystartowali!!";
    }
}
