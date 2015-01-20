package io.robot.core;


import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;
import java.util.Set;

/**
 * Execute
 * Created by Hz on 2015/1/19.
 */
public class Executor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);

    public static String exec(String cmd) {
        LOGGER.info("The cmd is " + cmd);
        List<String> result = Lists.newLinkedList();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            InputStreamReader ir = new InputStreamReader(process
                    .getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            process.waitFor();
            String line;
            while ((line = input.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            LOGGER.info("A error occurred  in execute " + cmd);
            e.printStackTrace();
        } catch (InterruptedException e) {
            LOGGER.info("A error occurred  in wait for the process.");
            e.printStackTrace();
        }finally {
            if(process != null)
                process.destroy();
        }
        return StringUtils.join(result, "\n");
    }
}
