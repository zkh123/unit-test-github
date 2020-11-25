package com.example.unit.test.github.threadTest.classLoaderTest;

import java.util.Arrays;
import java.util.List;

/**
 * 1加载
 * 2链接  2.1验证 2.2准备 2.3解析
 * 3初始化
 */
public class TargetForClassLoader {

    /**
     * 根类加载器
     */
    public static void bootstrapClassLoader(){
        String property = System.getProperty("sun.boot.class.path");
        List<String> list = Arrays.asList(property.split(";"));
        list.forEach((t)->{
            System.out.println("启动根类加载器加载了以下资源: " + t);
        });
    }

    /**
     * 扩展类加载器
     */
    public static void extClassLoader(){
        String property = System.getProperty("java.ext.dirs");
        List<String> list = Arrays.asList(property.split(";"));
        list.forEach((t)->{
            System.out.println("启动扩展类加载器加载了以下资源: " + t);
        });
    }

    public static void applicationClassLoader(){
        String property = System.getProperty("java.class.path");
        List<String> list = Arrays.asList(property.split(";"));
        list.forEach((t)->{
            System.out.println("启动系统类加载器加载了以下资源: " + t);
        });
    }

    public static void main(String[] args) {
        bootstrapClassLoader();
        System.out.println("-------------------");
        extClassLoader();
        System.out.println("-------------------");
        applicationClassLoader();
        System.out.println("-------------------");
    }

    /**
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\resources.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\sunrsasign.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jsse.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jce.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\charsets.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jfr.jar
     * 启动根类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\classes
     * -------------------
     * 启动扩展类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext
     * 启动扩展类加载器加载了以下资源: C:\WINDOWS\Sun\Java\lib\ext
     * -------------------
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\charsets.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\deploy.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\access-bridge-64.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\cldrdata.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\dnsns.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\jaccess.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\jfxrt.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\localedata.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\nashorn.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunec.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunjce_provider.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunmscapi.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunpkcs11.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\zipfs.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\javaws.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jce.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jfr.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jfxswt.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\jsse.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\management-agent.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\plugin.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\resources.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-web\2.3.4.RELEASE\spring-boot-starter-web-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter\2.3.4.RELEASE\spring-boot-starter-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot\2.3.4.RELEASE\spring-boot-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-autoconfigure\2.3.4.RELEASE\spring-boot-autoconfigure-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-logging\2.3.4.RELEASE\spring-boot-starter-logging-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\yaml\snakeyaml\1.26\snakeyaml-1.26.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-json\2.3.4.RELEASE\spring-boot-starter-json-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\core\jackson-databind\2.11.2\jackson-databind-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\core\jackson-annotations\2.11.2\jackson-annotations-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.11.2\jackson-datatype-jdk8-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.11.2\jackson-datatype-jsr310-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\module\jackson-module-parameter-names\2.11.2\jackson-module-parameter-names-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-tomcat\2.3.4.RELEASE\spring-boot-starter-tomcat-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\apache\tomcat\embed\tomcat-embed-core\9.0.38\tomcat-embed-core-9.0.38.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\glassfish\jakarta.el\3.0.3\jakarta.el-3.0.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.38\tomcat-embed-websocket-9.0.38.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-web\5.2.9.RELEASE\spring-web-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-beans\5.2.9.RELEASE\spring-beans-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-webmvc\5.2.9.RELEASE\spring-webmvc-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-aop\5.2.9.RELEASE\spring-aop-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-context\5.2.9.RELEASE\spring-context-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-expression\5.2.9.RELEASE\spring-expression-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\hamcrest\hamcrest\2.2\hamcrest-2.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\net\bytebuddy\byte-buddy\1.10.14\byte-buddy-1.10.14.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\objenesis\objenesis\2.6\objenesis-2.6.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-core\5.2.9.RELEASE\spring-core-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-jcl\5.2.9.RELEASE\spring-jcl-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\junit\junit\4.13\junit-4.13.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\hamcrest\hamcrest-core\2.2\hamcrest-core-2.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\google\guava\guava\29.0-jre\guava-29.0-jre.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\google\guava\failureaccess\1.0.1\failureaccess-1.0.1.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\checkerframework\checker-qual\2.11.1\checker-qual-2.11.1.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\google\errorprone\error_prone_annotations\2.3.4\error_prone_annotations-2.3.4.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\google\j2objc\j2objc-annotations\1.3\j2objc-annotations-1.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\alibaba\fastjson\1.2.73\fastjson-1.2.73.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\mysql\mysql-connector-java\5.1.46\mysql-connector-java-5.1.46.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\alibaba\druid\1.0.9\druid-1.0.9.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\lib\jconsole.jar
     * 启动系统类加载器加载了以下资源: C:\Program Files\Java\jdk1.8.0_144\lib\tools.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\mybatis\spring\boot\mybatis-spring-boot-starter\2.1.1\mybatis-spring-boot-starter-2.1.1.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-jdbc\2.3.4.RELEASE\spring-boot-starter-jdbc-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\zaxxer\HikariCP\3.4.5\HikariCP-3.4.5.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-jdbc\5.2.9.RELEASE\spring-jdbc-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-tx\5.2.9.RELEASE\spring-tx-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\mybatis\spring\boot\mybatis-spring-boot-autoconfigure\2.1.1\mybatis-spring-boot-autoconfigure-2.1.1.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\mybatis\mybatis\3.5.3\mybatis-3.5.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\mybatis\mybatis-spring\2.0.3\mybatis-spring-2.0.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\redisson\redisson-spring-boot-starter\3.11.2\redisson-spring-boot-starter-3.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-actuator\2.3.4.RELEASE\spring-boot-starter-actuator-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-actuator-autoconfigure\2.3.4.RELEASE\spring-boot-actuator-autoconfigure-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-actuator\2.3.4.RELEASE\spring-boot-actuator-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\micrometer\micrometer-core\1.5.5\micrometer-core-1.5.5.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\hdrhistogram\HdrHistogram\2.1.12\HdrHistogram-2.1.12.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\latencyutils\LatencyUtils\2.0.3\LatencyUtils-2.0.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\boot\spring-boot-starter-data-redis\2.3.4.RELEASE\spring-boot-starter-data-redis-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\data\spring-data-redis\2.3.4.RELEASE\spring-data-redis-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\data\spring-data-keyvalue\2.3.4.RELEASE\spring-data-keyvalue-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\data\spring-data-commons\2.3.4.RELEASE\spring-data-commons-2.3.4.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-oxm\5.2.9.RELEASE\spring-oxm-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\springframework\spring-context-support\5.2.9.RELEASE\spring-context-support-5.2.9.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\redisson\redisson\3.11.2\redisson-3.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-common\4.1.52.Final\netty-common-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-codec\4.1.52.Final\netty-codec-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-buffer\4.1.52.Final\netty-buffer-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-transport\4.1.52.Final\netty-transport-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-resolver\4.1.52.Final\netty-resolver-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-resolver-dns\4.1.52.Final\netty-resolver-dns-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-codec-dns\4.1.52.Final\netty-codec-dns-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\netty\netty-handler\4.1.52.Final\netty-handler-4.1.52.Final.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\javax\cache\cache-api\1.1.1\cache-api-1.1.1.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\projectreactor\reactor-core\3.3.10.RELEASE\reactor-core-3.3.10.RELEASE.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\reactivestreams\reactive-streams\1.0.3\reactive-streams-1.0.3.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\io\reactivex\rxjava2\rxjava\2.2.19\rxjava-2.2.19.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\de\ruedigermoeller\fst\2.57\fst-2.57.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\javassist\javassist\3.21.0-GA\javassist-3.21.0-GA.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\dataformat\jackson-dataformat-yaml\2.11.2\jackson-dataformat-yaml-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\com\fasterxml\jackson\core\jackson-core\2.11.2\jackson-core-2.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\jodd\jodd-bean\5.0.10\jodd-bean-5.0.10.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\jodd\jodd-core\5.0.10\jodd-core-5.0.10.jar
     * 启动系统类加载器加载了以下资源: D:\Maven\repo\org\redisson\redisson-spring-data-21\3.11.2\redisson-spring-data-21-3.11.2.jar
     * 启动系统类加载器加载了以下资源: D:\soft\installation_file\ideaIU-2019.2.4.win\lib\idea_rt.jar
     * 启动系统类加载器加载了以下资源: D:\soft\installation_file\ideaIU-2019.2.4.win\plugins\java\lib\rt\debugger-agent.jar
     * -------------------
     */
}
