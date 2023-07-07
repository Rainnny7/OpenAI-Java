package me.braydon.chatgpt;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.braydon.chatgpt.web.ApiCredentials;

/**
 * @author Braydon
 */
@AllArgsConstructor
public final class ChatGPT {
    /**
     * Credentials to the OpenAI API.
     *
     * @see ApiCredentials for impl
     */
    @NonNull private final ApiCredentials apiCredentials;
    
    public void chatCompletions(@NonNull ModelEnum modelEnum) {
        chatCompletions(modelEnum.getId());
    }
    
    public void chatCompletions(@NonNull String model) {}
}