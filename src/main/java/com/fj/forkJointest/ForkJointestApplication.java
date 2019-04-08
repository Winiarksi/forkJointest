package com.fj.forkJointest;

import com.fj.forkJointest.config.StateMachineConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.service.StateMachineService;

/**
 * https://docs.spring.io/spring-statemachine/docs/2.0.3.RELEASE/reference/htmlsingle/#statemachine-config-states-junction
 */


@SpringBootApplication
@EnableScheduling
public class ForkJointestApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ForkJointestApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(ForkJointestApplication.class, args);

	}
}



//
//	/**
//	 * Creates a new state machine for each user and starts it.
//	 * This will allow each user to progress to different stages at different times.
//	 *
//	 * @param context Spring context.
//	 */
//	@SuppressWarnings("unchecked")
//	private synchronized static void createAndStartStateMachineForAllUsers(ConfigurableApplicationContext context) {
//
//		if (Boolean.parseBoolean(context.getEnvironment().getProperty("skipVerifications", "false"))) {
//			LOG.warn("### SKIP VERIFICATIONS ENABLED - NOT AUTO STARTING MACHINES! ###");
//			return;
//		}
//
//		UserService userService = context.getBean(UserService.class);
//		for (User user : userService.getEnabledUsersFromDb()) {
//
//			StateMachineService stateMachineService = context.getBean(StateMachineService.class);
//
//			//Check to see if there is a machine in progress.
//			String stateMachineUUID = userService.getRunningStateMachineId(user.getUserId());
//
//			if (stateMachineUUID != null) {
//
//				StateMachine<States, Events> stateMachine = stateMachineService.acquireStateMachine(stateMachineUUID, true);
//				LOG.info("State machine resumed for userId: " + user.getUserId() + " State: " + stateMachine.getState().getId());
//
//			} else {
//
//				String newStateMachineUUID = userService.createTradeSession(user.getUserId());
//				stateMachineService.acquireStateMachine(newStateMachineUUID);
//			}
//		}
//	}
//}
