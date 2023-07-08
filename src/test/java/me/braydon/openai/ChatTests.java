package me.braydon.openai;

import me.braydon.openai.web.response.ChatMessage;
import me.braydon.openai.web.response.impl.chat.ChatCompletion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Braydon
 */
public final class ChatTests {
    /**
     * Testing of {@link ChatCompletion}'s.
     */
    @Test @DisplayName("Chat Completion")
    public void completion() {
        ChatCompletion completion = Constants.TEST_CLIENT.chatCompletion(ModelEnum.GPT_3_5_TURBO,
            new ChatMessage("user", "Hello! Generate me 10 random words please <3")
        ); // Send the chat message
        assumeTrue(completion.choiceCount() > 0, "No new history entry");
    }
}