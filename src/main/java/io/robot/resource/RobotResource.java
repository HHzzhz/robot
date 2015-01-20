package io.robot.resource;

import com.codahale.metrics.annotation.Timed;
import io.robot.core.Executor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Resource
 * Created by Hz on 2015/1/19.
 */
@Path("/robot")
@Produces(MediaType.APPLICATION_JSON)
public class RobotResource {
    private final String path;
    private final Map<String, String> cmd;

    private Executor executor;
    public RobotResource(String path, Map<String, String> cmd) {
        this.path = path;
        this.cmd = cmd;
        this.executor = new Executor();
    }

    @GET
    @Timed
    @Path("/{cmd}")
    public String invokeCmd(@PathParam("cmd") String cmd) {
        String encodedCmd = String.format(this.cmd.get(cmd), this.path);
        return executor.exec(encodedCmd);
    }
}
