package com.fj.forkJointest.forkJoin;

import com.fj.forkJointest.Colours;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@Slf4j
@WithStateMachine
public class S3 {


    @OnTransition(target = "S3")
    public void onTransition(StateContext<String, String> stateContext) {
        log.info(Colours.ANSI_BLUE + "target = \"S3\", getState().getId(): "
                + stateContext.getStateMachine().getState().getId()
                + Colours.ANSI_RESET);
    }

    @OnStateChanged(target = "S3")
    public void onStateChanged(StateContext<String, String> stateContext) {
        log.debug(Colours.B_HI_ANSI_GREEN + "S3 EXPECTS_ORDERS stateChanged :: Current state ID :: {}",
                stateContext.getStateMachine().getState().getId() + Colours.ANSI_RESET);
    }
}
