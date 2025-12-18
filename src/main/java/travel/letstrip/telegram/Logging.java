package travel.letstrip.telegram;

import lombok.Data;

/**
 * Configuration properties for Telegram-based logging.
 */
@Data
public class Logging {

    /**
     * Enables or disables Telegram logging.
     */
    private boolean enabled = false;

    /**
     * Comma-separated list of log levels to forward
     * (e.g. ERROR, WARN, INFO).
     */
    private String level = "ERROR,WARN";

    /**
     * Whether to include stack traces in log messages.
     */
    private boolean includeStackTrace = true;

    /**
     * Maximum number of stack trace lines to include.
     */
    private int maxStackTraceLines = 5;

    /**
     * Enables asynchronous message sending.
     */
    private boolean async = true;

    /**
     * Queue size used for asynchronous logging.
     */
    private int queueSize = 1000;
}
