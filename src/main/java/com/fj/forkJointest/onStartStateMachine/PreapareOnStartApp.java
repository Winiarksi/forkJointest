package com.fj.forkJointest.onStartStateMachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;


@Slf4j
@Component
//public class PreapareOnStartApp implements CommandLineRunner {
public class PreapareOnStartApp implements ApplicationRunner {


    @Autowired
    private StateMachine<String, String> stateMachine;

//    @Override
//    public void run(String...args) throws Exception {
//
//    log.info("Odpalam Spring State Machine");
//
//    stateMachine.start();
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("Odpalam Spring State Machine");
        stateMachine.start();
    }

}
