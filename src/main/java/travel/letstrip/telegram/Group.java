package travel.letstrip.telegram;

import lombok.Data;

/**
 * Configuration properties for Telegram groups and topics.
 */
@Data
public class Group {

    /**
     * Main Telegram group or chat ID.
     */
    private String id;

    /**
     * Optional topic (forum thread) ID for the main group.
     */
    private String topicId;

    /**
     * Administrator group ID.
     */
    private String adminId;

    /**
     * Report group ID.
     */
    private String reportGroupId;

    /**
     * Topic ID used for report messages.
     */
    private Integer reportGroupTopicId;

    /**
     * Error notification group ID.
     */
    private String errorGroupId;
}
