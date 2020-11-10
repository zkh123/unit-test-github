package com.example.unit.test.github.threadTest.serverTest;

import java.util.concurrent.Executor;

public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
