package travel.letstrip.utils;




import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class WebUtils {
    private static final List<String> DEVICES = List.of("Android", "iPhone", "iPad", "Windows", "Macintosh", "Linux");
    private final HttpServletRequest request;

    public String getDeviceType() {
        String userAgent = getUserAgent();
        if (userAgent != null) {
            return DEVICES.stream()
                    .filter(userAgent::contains)
                    .findAny()
                    .orElse("Unknown");
        } else return "Unknown";
    }


    public String getClientIpAddress() {
        String xForwardedForHeader = Objects.requireNonNullElse(getHeader(), request.getRemoteAddr());
        return xForwardedForHeader.split(",")[0];
    }

    private String getHeader() {
        return request.getHeader("X-Forwarded-For");
    }

    public String getHost() {
        return request.getHeader("Host");
    }

    public String getUserAgent() {
        return request.getHeader("User-Agent");
    }

    public String getBody() throws IOException {
        return new String(request.getInputStream().readAllBytes());
    }
}
