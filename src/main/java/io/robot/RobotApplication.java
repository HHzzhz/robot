package io.robot;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.robot.resource.RobotResource;

/**
 * Application
 * Created by Hz on 2015/1/19.
 */
public class RobotApplication extends Application<RobotConfiguration>{

    public static void main(String[] args) throws Exception {
        new RobotApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<RobotConfiguration> bootstrap) {

    }

    @Override
    public void run(RobotConfiguration robotConfiguration, Environment environment) throws Exception {
        final RobotResource robot = new RobotResource(
                robotConfiguration.getPath(),
                robotConfiguration.getCmd());
        environment.jersey().register(robot);
    }
}
