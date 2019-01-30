package com.helfmxie.learn.java.api.attach;

import com.sun.tools.attach.VirtualMachine;

/**
 * @BelongsProject: learn
 * @BelongsPackage: com.helfmxie.java.com.helfmxie.learn.java.api.attach
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-30 15:20
 * @Description: attach请求的发起者
 */
public class AttachClient {


    public static void main(String[] args) throws Exception {
        VirtualMachine virtualMachine = VirtualMachine.attach("91371");
        try {
            virtualMachine.loadAgent(
                    "/Users/zhihaoxie/IdeaProjects/self/learn/java/agent/target/learn.java.agent-1.0-SNAPSHOT-demo.jar");
        } finally {
            virtualMachine.detach();
        }
    }
}
