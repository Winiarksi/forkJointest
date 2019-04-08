package com.fj.forkJointest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.statemachine.StateMachineSystemConstants;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.model.StateMachineModelFactory;
import org.springframework.statemachine.uml.UmlStateMachineModelFactory;

@Slf4j
@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineModelConfigurer<String, String> model) throws Exception {
        model
                .withModel()
                .factory(modelFactory());
    }

    @Bean
    public StateMachineModelFactory<String, String> modelFactory() {
        Resource model = new ClassPathResource("/UMLsimple-forkjoin/simple-forkjoin.uml");
        return new UmlStateMachineModelFactory(model);
    }


    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
        config
                .withConfiguration()
                .listener(new StateMachineListener())
                .taskExecutor(myAsyncTaskExecutor())
                .autoStartup(false);
    }

    @Bean(name = StateMachineSystemConstants.TASK_EXECUTOR_BEAN_NAME)
    public TaskExecutor myAsyncTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        return taskExecutor;
    }
}
