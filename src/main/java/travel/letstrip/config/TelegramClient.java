package travel.letstrip.config;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import travel.letstrip.telegram.TelegramProperties;

import java.io.File;

public class TelegramClient {

    private final TelegramBot bot;
    private final TelegramProperties properties;

    public TelegramClient(TelegramProperties properties) {
        this.properties = properties;
        this.bot = new TelegramBot(properties.getBot().getToken());
    }

    /* ================= PUBLIC API ================= */
    public void sendDocumentToMainGroup(File file, String caption) {
        sendDocument(properties.getGroup().getId(), file, caption, properties.getTopicIdAsInteger());
    }

    public void sendPhotoToMainGroup(File file, String caption) {
        sendPhoto(properties.getGroup().getId(), file, caption, properties.getTopicIdAsInteger());
    }

    public void sendDocumentToErrorGroup(File file, String caption) {
        sendDocument(properties.getGroup().getErrorGroupId(), file, caption, properties.getTopicIdAsInteger());
    }

    public void sendToMainGroup(String message) {
        send(properties.getGroup().getId(), message, properties.getTopicIdAsInteger());
    }

    public void sendToErrorGroup(String message) {
        send(properties.getGroup().getErrorGroupId(), message, properties.getTopicIdAsInteger());
    }

    /* ================= CORE METHOD ================= */
    private void sendPhoto(String chatId, File file, String caption, Integer topicId) {
        if (!isValid(chatId, file)) return;

        SendPhoto request = new SendPhoto(chatId, file)
                .caption(caption)
                .parseMode(resolveParseMode());

        if (topicId != null) {
            request.replyToMessageId(topicId);
        }

        bot.execute(request);
    }
    private void sendDocument(String chatId, File file, String caption, Integer topicId) {
        if (!isValid(chatId, file)) return;

        SendDocument request = new SendDocument(chatId, file)
                .caption(caption)
                .parseMode(resolveParseMode());

        if (topicId != null) {
            request.replyToMessageId(topicId);
        }

        bot.execute(request);
    }

    private void send(String chatId, String message, Integer topicId) {
        if (chatId == null || chatId.isBlank()) {
            return;
        }

        SendMessage request = new SendMessage(chatId, message)
                .parseMode(resolveParseMode())
                .disableWebPagePreview(properties.getMessage().isDisableWebPagePreview())
                .disableNotification(properties.getMessage().isDisableNotification());

        if (topicId != null) {
            request.replyToMessageId(topicId);
        }

        bot.execute(request);
    }

    /* ================= HELPERS ================= */
    private boolean isValid(String chatId, File file) {
        return chatId != null && !chatId.isBlank()
                && file != null && file.exists();
    }

    private ParseMode resolveParseMode() {
        try {
            return ParseMode.valueOf(properties.getMessage().getParseMode().toUpperCase());
        } catch (Exception e) {
            return ParseMode.HTML;
        }
    }
}
