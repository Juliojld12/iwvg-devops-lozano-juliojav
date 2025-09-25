package es.upm.miw.devops.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/")
public class SystemResource {

    public static final String VERSION_BADGE = "/version-badge";

    private static final String BADGE_IMAGE_TEMPLATE = """
            <svg xmlns="http://www.w3.org/2000/svg" width="%d" height="20">
                <linearGradient id="a" x2="0" y2="100%%">
                    <stop offset="0" stop-color="#bbb" stop-opacity=".1"/>
                    <stop offset="1" stop-opacity=".1"/>
                </linearGradient>
                <rect rx="3" width="%d" height="20" fill="#555"/>
                <rect rx="3" x="%d" width="%d" height="20" fill="#4c1"/>
                <path fill="#4c1" d="M%d 0h4v20h-4z"/>
                <rect rx="3" width="%d" height="20" fill="url(#a)"/>
                <g fill="#fff" text-anchor="middle" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" font-size="11">
                    <text x="%d" y="15" fill="#010101" fill-opacity=".3">%s</text>
                    <text x="%d" y="14">%s</text>
                    <text x="%d" y="15" fill="#010101" fill-opacity=".3">%s</text>
                    <text x="%d" y="14">%s</text>
                </g>
            </svg>
            """;

    private static final int TEXT_MARGIN = 12;
    private static final int CHARACTER_WIDTH = 6;

    @Value("${info.app.artifact}")
    private String artifact;

    @Value("${info.app.version}")
    private String version;

    @Value("${info.app.build}")
    private String build;

    // --- sanitize helpers to avoid injection in SVG text nodes ---
    private static String xmlEscape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    public String generateBadge(String label, String value) {
        String safeLabel = xmlEscape(label);
        String safeValue = xmlEscape(value);

        int widthLabel = TEXT_MARGIN + CHARACTER_WIDTH * safeLabel.length();
        int widthValue = TEXT_MARGIN + CHARACTER_WIDTH * safeValue.length();
        int textWidth = widthLabel + widthValue;
        int middleLabel = widthLabel / 2;
        int middleValue = widthLabel + widthValue / 2;

        return String.format(
                BADGE_IMAGE_TEMPLATE,
                textWidth, textWidth, widthLabel, widthValue, widthLabel, textWidth,
                middleLabel, safeLabel, middleLabel, safeLabel,
                middleValue, safeValue, middleValue, safeValue
        );
    }

    @GetMapping
    public String applicationInfo() {
        String appInfo = "{\"version\":\"" + this.artifact + "::" + this.version + "::" + this.build + "\"} <br> <br>";
        appInfo += "/version-badge <br><br>";
        appInfo += "/actuator/info <br> /actuator/health <br><br>";
        appInfo += "/swagger-ui.html  <br> /v3/api-docs <br>";
        return appInfo;
    }

    @GetMapping(value = VERSION_BADGE, produces = {"image/svg+xml"})
    public byte[] generateBadge() {
        // charset explícito para evitar warning de Sonar
        return this.generateBadge("Render", "v" + version).getBytes(StandardCharsets.UTF_8);
    }
}
