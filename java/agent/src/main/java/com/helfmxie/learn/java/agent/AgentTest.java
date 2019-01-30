package com.helfmxie.learn.java.agent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.instrument.Instrumentation;

/**
 * @BelongsProject: learn
 * @BelongsPackage: com.helfmxie.learn.java.agent
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-30 15:29
 * @Description:
 */
public class AgentTest {


    private static final String log_file_path =
            "/Users/zhihaoxie/IdeaProjects/self/learn/java/agent/src/main/java/com/helfmxie/learn/java/agent/agent.log";


    /**
     * 以vm参数的形式载入，在程序main方法执行之前执行
     * 其jar包的manifest需要配置属性Premain-Class
     */
    public static void premain(String agentArgs, Instrumentation inst) throws IOException {
        try {
            main(agentArgs, inst);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 以Attach的方式载入，在Java程序启动后执行
     * 其jar包的manifest需要配置属性Agent-Class
     */
    public static void agentmain(String agentArgs, Instrumentation inst) throws IOException {
        try {
            main(agentArgs, inst);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String agentArgs, Instrumentation inst) throws Exception {
        // Instrumentation提供的addTransformer方法，在类加载时会回调ClassFileTransformer接口
        final PrintWriter fw = new PrintWriter(new File(log_file_path));
        fw.write("attach成功!\n");
        fw.flush();
        Class[] classes = inst.getAllLoadedClasses();
        for (Class clazz : classes) {
            String log = "Class为" + clazz.getName() + "\n";
            fw.write(log);
            fw.flush();
        }
    }
}
