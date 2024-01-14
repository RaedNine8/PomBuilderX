package spring._init_shell.shell.models;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;

public class Dependencies {


    // Dependency constants
    private final static String AWS_LAMBDA_JAVA_CORE = "aws-lambda-java-core";
    private final static String AWS_LAMBDA_JAVA_EVENTS = "aws-lambda-java-events";
    private final static String COM_DOT_AMAZONAWS = "com.amazonaws";
    private final static String SPRING_EXPERIMENTAL = "org.springframework.experimental";
    private final static String SPRING_NATIVE = "spring-native";
    private final static String SPRING_CLOUD_GROUP_ID = "org.springframework.cloud";
    private final static String SPRING_CLOUD_FUNCTION_AWS = "spring-cloud-function-adapter-aws";
    private final static String SPRING_CLOUD_FUNCTION_WEBFLUX = "spring-cloud-starter-function-webflux";
    private final static String SPRING_CLOUD_FUNCTION_CONTEXT = "spring-cloud-function-context";
    private final static String SPRING_NATIVE_VERSION_HOLDER = "${spring-native.version}";

    // Method to remove certain dependencies from the model
    public static void removeFunctionStarters(Model model) {
        // Remove dependencies related to Spring Cloud Function starters
        model.getDependencies()
                .removeIf(d -> (d.getGroupId().equalsIgnoreCase(SPRING_CLOUD_GROUP_ID)
                        && d.getArtifactId().equalsIgnoreCase(SPRING_CLOUD_FUNCTION_CONTEXT)));
        model.getDependencies()
                .removeIf(d -> (d.getGroupId().equalsIgnoreCase(SPRING_CLOUD_GROUP_ID)
                        && d.getArtifactId().equalsIgnoreCase(SPRING_CLOUD_FUNCTION_WEBFLUX)));
        model.getDependencies()
                .removeIf(d -> (d.getGroupId().equalsIgnoreCase(SPRING_CLOUD_GROUP_ID)
                        && d.getArtifactId().equalsIgnoreCase(SPRING_CLOUD_FUNCTION_AWS)));
    }

    // Method to create a Dependency for Spring Native
    public static Dependency springNative() {
        Dependency u = new Dependency();
        u.setGroupId(SPRING_EXPERIMENTAL);
        u.setArtifactId(SPRING_NATIVE);
        u.setVersion(SPRING_NATIVE_VERSION_HOLDER);
        return u;
    }

    // Method to create a Dependency for Spring RestDocs Asciidoctor
    public static Dependency springRestdocsAsciidoctor() {
        Dependency u = new Dependency();
        u.setGroupId("org.springframework.restdocs");
        u.setArtifactId("spring-restdocs-asciidoctor");
        u.setVersion("${spring-restdocs.version}");
        return u;
    }

    // Method to create a Dependency for AWS Lambda Java Events
    public static Dependency awsJavaEvents() {
        Dependency u = new Dependency();
        u.setGroupId(COM_DOT_AMAZONAWS);
        u.setArtifactId(AWS_LAMBDA_JAVA_EVENTS);
        u.setVersion("3.11.0");
        u.setScope("provided");
        return u;
    }

    // Method to create a Dependency for AWS Lambda Java Core
    public static Dependency awsJavaCore() {
        Dependency u = new Dependency();
        u.setGroupId(COM_DOT_AMAZONAWS);
        u.setArtifactId(AWS_LAMBDA_JAVA_CORE);
        u.setVersion("1.1.0");
        u.setScope("provided");
        return u;
    }

    // Method to create a Dependency for Spring Cloud Function WebFlux
    public static Dependency webfluxStarter() {
        Dependency u = new Dependency();
        u.setGroupId(SPRING_CLOUD_GROUP_ID);
        u.setArtifactId(SPRING_CLOUD_FUNCTION_WEBFLUX);
        return u;
    }

    // Method to create a Dependency for Spring Cloud Function AWS
    public static Dependency awsStarter() {
        Dependency u = new Dependency();
        u.setGroupId(SPRING_CLOUD_GROUP_ID);
        u.setArtifactId(SPRING_CLOUD_FUNCTION_AWS);
        return u;
    }

    // Method to create a Dependency for JUnit Platform Launcher
    public static Dependency junitPlatformLauncher() {
        Dependency d = new Dependency();
        d.setGroupId("org.junit.platform");
        d.setArtifactId("junit-platform-launcher");
        d.setScope("test");
        return d;
    }

}
