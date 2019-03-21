package com.fj.forkJointest.config;

import com.fj.forkJointest.Colours;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

@Slf4j
public class StateMachineListener extends StateMachineListenerAdapter<String, String> {

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        log.info("state changed from: {} to {}", from==null ? "null" : from.getId(), to.getId());
    }

    @Override
    public void transitionStarted(Transition<String, String> transition) {
        log.info("transition started! target state: {}", transition.getTarget().getId());
    }

    @Override
    public void eventNotAccepted(Message<String> event) {
        log.info(Colours.HI_ANSI_RED + "Event not accepted: {}", event.getPayload() + Colours.ANSI_RESET);
//        throw new EventNotAcceptedException("event not accepted");
    }

    @Override
    public void stateMachineStarted(StateMachine<String, String> stateMachine) {
        super.stateMachineStarted(stateMachine);
        log.info("State machine started :: {}", stateMachine.getState().getId());
    }
}
