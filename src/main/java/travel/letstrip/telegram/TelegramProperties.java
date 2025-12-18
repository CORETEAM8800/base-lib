package travel.letstrip.telegram;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Root configuration properties for Telegram integration.
 *
 * <p>Binds configuration values under the {@code telegram.*} prefix
 * from application properties or YAML files.</p>
 *
 * <p>This class aggregates configuration for:</p>
 * <ul>
 *   <li>Telegram bot settings</li>
 *   <li>Telegram group settings</li>
 *   <li>Telegram logging behavior</li>
 *   <li>Telegram message options</li>
 * </ul>
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "telegram")
public class TelegramProperties {

    /**
     * Telegram bot configuration.
     */
    private Bot bot = new Bot();

    /**
     * Telegram group configuration.
     */
    private Group group = new Group();

    /**
     * Telegram logging configuration.
     */
    private Logging logging = new Logging();

    /**
     * Telegram message configuration.
     */
    private Message message = new Message();

    /**
     * Determines whether the Telegram bot is enabled.
     *
     * <p>The bot is considered enabled only if:</p>
     * <ul>
     *   <li>The bot is explicitly enabled</li>
     *   <li>A valid bot token is provided</li>
     * </ul>
     *
     * @return {@code true} if the bot is enabled and properly configured
     */
    public boolean isBotEnabled() {
        return bot.isEnabled() && hasValidBotConfig();
    }

    /**
     * Determines whether Telegram logging is enabled.
     *
     * <p>Logging is enabled only if:</p>
     * <ul>
     *   <li>Logging is explicitly enabled</li>
     *   <li>A valid bot configuration is present</li>
     * </ul>
     *
     * @return {@code true} if Telegram logging is enabled
     */
    public boolean isLoggingEnabled() {
        return logging.isEnabled() && hasValidBotConfig();
    }

    /**
     * Checks whether the bot configuration is valid.
     *
     * @return {@code true} if a non-empty bot token is configured
     */
    public boolean hasValidBotConfig() {
        return bot.getToken() != null && !bot.getToken().isEmpty();
    }

    /**
     * Checks whether the main Telegram group configuration is valid.
     *
     * @return {@code true} if a group ID is configured
     */
    public boolean hasValidGroupConfig() {
        return group.getId() != null && !group.getId().isEmpty();
    }

    /**
     * Checks whether a Telegram topic (forum thread) ID is configured.
     *
     * @return {@code true} if a topic ID is present
     */
    public boolean hasTopicId() {
        return group.getTopicId() != null && !group.getTopicId().isEmpty();
    }

    /**
     * Returns the configured topic ID as an {@link Integer}.
     *
     * <p>If the topic ID is missing or cannot be parsed,
     * {@code null} is returned.</p>
     *
     * @return topic ID as integer or {@code null}
     */
    public Integer getTopicIdAsInteger() {
        if (!hasTopicId()) {
            return null;
        }
        try {
            return Integer.parseInt(group.getTopicId());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Returns the configured logging levels as an array.
     *
     * <p>The levels are parsed from a comma-separated string
     * (e.g. {@code "ERROR,WARN"}).</p>
     *
     * @return array of allowed log levels
     */
    public String[] getLoggingLevels() {
        return logging.getLevel().split(",");
    }
}
