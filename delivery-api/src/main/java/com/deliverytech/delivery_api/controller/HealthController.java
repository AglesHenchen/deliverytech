public class HealthController {
    
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().toString(),
            "service", "Delivery API",
            "javaVersion", System.getProperty("java.version")
        );
    }

    @GetMapping("/info")
    public AppInfo info() {
        return new AppInfo(
            "Delivery Tech API",
            "1.0.0",
            "[Agles Henchen]",
            "JDK 25",
            "Spring Boot 3.2.x"
        );
    }

    //Record para demonstrar recurso do Java 14+
    public record Appinfo(
        String application,
        String version,
        String developer,
        String javaVersion,
        String framework
    ) {}
}
