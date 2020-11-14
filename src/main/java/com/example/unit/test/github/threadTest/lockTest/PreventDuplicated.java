package com.example.unit.test.github.threadTest.lockTest;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PreventDuplicated {

    private final static String LOCK_PATH = "D:/international_market_deparment/github/unit-test-github/src/main/java/com/example/unit/test/github/threadTest/lockTest";
    private final static String LOCK_FILE = ".lock";
    private final static String PERMISSIONS = "rw-------";

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()){
            throw new RuntimeException("the program already running...");
        }
        path.toFile().createNewFile();
//        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
//        Files.createFile(path,PosixFilePermissions.asFileAttribute(perms));
    }

    private static Path getLockFile(){
        return Paths.get(LOCK_PATH,LOCK_FILE);
    }


    public static void main(String[] args) throws IOException {
        checkRunning();

        Runtime.getRuntime().addShutdownHook(new Thread("hock-thread-01"){
            @Override
            public void run() {
                log.info("the program received is kill SIGNAL.");
                getLockFile().toFile().delete();
            }
        });

        new Thread("work-thread-001"){
            @Override
            public void run() {
                try {
                    log.info("word running...");
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int param  = 1/0;
                log.info("word error");
            }
        }.start();

        log.info("PreventDuplicated over");
    }

}
