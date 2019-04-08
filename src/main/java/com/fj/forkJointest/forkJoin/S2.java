package com.fj.forkJointest.forkJoin;

import com.fj.forkJointest.Colours;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@Slf4j
@WithStateMachine
public class S2 {


    @OnTransition(target = "S2")
    public void onTransition(StateContext<String, String> stateContext) {
        log.info(Colours.ANSI_BLUE + "target = \"S2\", getState().getId(): "
                + stateContext.getStateMachine().getState().getId()
                + Colours.ANSI_RESET);
    }

    @OnTransition(source = "S2", target = "S3")
    public void onTransition2(StateContext<String, String> stateContext) {
        log.info(Colours.ANSI_BLUE + "source = \"S2\", target = \"S3\", getState().getId(): "
                + stateContext.getStateMachine().getState().getId()
                + Colours.ANSI_RESET);
    }

    @OnStateChanged(target = "S2")
    public void onStateChanged(StateContext<String, String> stateContext) {
        log.debug(Colours.B_HI_ANSI_GREEN + "S2 EXPECTS_ORDERS stateChanged :: Current state ID :: {}",
                stateContext.getStateMachine().getState().getId() + Colours.ANSI_RESET);
//        stateContext.getStateMachine().sendEvent("A1");
//        log.info("Evet A1 send");

    }
}
