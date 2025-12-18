package travel.letstrip.telegram;

import lombok.Data;

/**
 * Configuration properties for the Telegram bot.
 */
@Data
public class Bot {

    /**
     * Enables or disables the Telegram bot.
     */
    private boolean enabled = false;

    /**
     * Telegram bot token.
     */
    private String token;

    /**
     * Enables webhook mode.
     *
     * <p>If {@code false}, long polling is used.</p>
     */
    private boolean webhook = false;

    /**
     * Webhook URL used when webhook mode is enabled.
     */
    private String webhookUrl;
}
