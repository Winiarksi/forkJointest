package com.fj.forkJointest.forkJoin;

import com.fj.forkJointest.Colours;
import com.fj.forkJointest.service.Sleep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@Slf4j
@WithStateMachine
public class S30 {


    @OnTransition(target = "S30")
    public void onTransition(StateContext<String, String> stateContext) {
        log.info(Colours.ANSI_BLUE + "target = \"S30\", getState().getId(): "
                + stateContext.getStateMachine().getState().getId()
                + Colours.ANSI_RESET);
        Sleep.sleep(600);
    }

    @OnStateChanged(target = "S30")
    public void onStateChanged(StateContext<String, String> stateContext) {
        log.debug(Colours.B_HI_ANSI_GREEN + "S30 EXPECTS_ORDERS stateChanged :: Current state ID :: {}",
                stateContext.getStateMachine().getState().getId() + Colours.ANSI_RESET);
        Sleep.sleep(600);
    }
}
