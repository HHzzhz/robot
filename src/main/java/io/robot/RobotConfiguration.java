package io.robot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Configuration
 * Created by Hz on 2015/1/19.
 */
public class RobotConfiguration extends Configuration{
    @NotNull
    private Map<String, String> cmd;

    @NotEmpty
    private String path;

    @JsonProperty
    public Map<String, String> getCmd() {
        return cmd;
    }

    @JsonProperty
    public void setCmd(Map<String, String> cmd) {
        this.cmd = cmd;
    }

    @JsonProperty
    public String getPath() {
        return path;
    }

    @JsonProperty
    public void setPath(String path) {
        this.path = path;
    }
}
