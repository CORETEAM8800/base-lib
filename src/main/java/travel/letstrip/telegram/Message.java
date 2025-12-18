package travel.letstrip.telegram;

import lombok.Data;

/**
 * Configuration properties related to Telegram message behavior.
 */
@Data
public class Message {

    /**
     * Maximum allowed message length.
     */
    private int maxLength = 4000;

    /**
     * Message parse mode.
     *
     * <p>Supported values: HTML, Markdown, MarkdownV2.</p>
     */
    private String parseMode = "HTML";

    /**
     * Whether to disable web page previews in messages.
     */
    private boolean disableWebPagePreview = true;

    /**
     * Whether to disable message notifications.
     */
    private boolean disableNotification = false;

    /**
     * Rate limit for outgoing messages (messages per minute).
     */
    private int rateLimit = 30;
}
