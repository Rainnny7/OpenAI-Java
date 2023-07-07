package me.braydon.chatgpt;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.braydon.chatgpt.web.ApiCredentials;
import me.braydon.chatgpt.web.ApiWebRequest;
import me.braydon.chatgpt.web.response.impl.ModelList;

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
    
    /**
     * Get a list of models.
     *
     * @return the models
     * @see ModelList
     */
    @NonNull
    public ModelList models() {
        return ApiWebRequest.get()
                   .path("/models")
                   .credentials(apiCredentials)
                   .build().execute(ModelList.class);
    }
}