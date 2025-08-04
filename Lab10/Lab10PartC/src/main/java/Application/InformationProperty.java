package Application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Component
@ConfigurationProperties(prefix = "app")
public class InformationProperty {
    @NotBlank
    private String name;
    @NotBlank
    private String version;
    @NotBlank
    private Server server;
    private List<String> countries;

    public static class Server {
        private String url;
        private String name;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public Server getServer() { return server; }
    public void setServer(Server server) { this.server = server; }

    public List<String> getCountries() { return countries; }
    public void setCountries(List<String> countries) { this.countries = countries; }

    @Override
    public String toString() {
        return "InformationProperty{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", server=" + server +
                ", countries=" + countries +
                '}';
    }
}
