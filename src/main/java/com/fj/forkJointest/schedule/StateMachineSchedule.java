package com.fj.forkJointest.schedule;

import com.fj.forkJointest.Colours;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StateMachineSchedule {


    @Autowired
    private StateMachine<String, String> stateMachine;

//    @Scheduled(fixedRate = 3000)
    public void printCurrentState() {

        log.debug(
                Colours.ANSI_PURPLE
                        + "stateMachine.getState().getIds(): "
                        + stateMachine.getState().getIds()
                        + Colours.ANSI_RESET);

//        log.debug(
//                Colours.ANSI_PURPLE
//                        + "\nstateMachine.getState().getAStates(): " + stateMachine.getState().getStates() + Colours.ANSI_RESET);

    }

}
