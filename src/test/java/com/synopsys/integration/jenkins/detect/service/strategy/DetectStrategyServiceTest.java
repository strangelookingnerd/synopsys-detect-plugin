package com.synopsys.integration.jenkins.detect.service.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.synopsys.integration.jenkins.detect.DetectJenkinsEnvironmentVariable;
import com.synopsys.integration.util.IntEnvironmentVariables;

public class DetectStrategyServiceTest {
    @Test
    public void testGetJarStrategy() {
        IntEnvironmentVariables intEnvironmentVariables = new IntEnvironmentVariables(false);
        intEnvironmentVariables.put(DetectJenkinsEnvironmentVariable.USER_PROVIDED_JAR_PATH.stringValue(), "/tmp/path/to/detect.jar");

        DetectExecutionStrategy detectExecutionStrategy = testGetExecutionStrategy(intEnvironmentVariables);
        assertEquals(DetectJarStrategy.class, detectExecutionStrategy.getClass());
    }

    @Test
    public void testGetScriptStrategy() {
        IntEnvironmentVariables intEnvironmentVariables = new IntEnvironmentVariables(false);

        DetectExecutionStrategy detectExecutionStrategy = testGetExecutionStrategy(intEnvironmentVariables);
        assertEquals(DetectScriptStrategy.class, detectExecutionStrategy.getClass());
    }

    public DetectExecutionStrategy testGetExecutionStrategy(IntEnvironmentVariables intEnvironmentVariables) {
        DetectStrategyService detectStrategyService = new DetectStrategyService(null, null, null);

        return detectStrategyService.getExecutionStrategy(intEnvironmentVariables, null, null);
    }
}