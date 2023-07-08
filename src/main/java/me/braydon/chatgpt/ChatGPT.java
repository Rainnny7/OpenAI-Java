package me.braydon.chatgpt;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.braydon.chatgpt.web.ApiCredentials;
import me.braydon.chatgpt.web.ApiWebRequest;
import me.braydon.chatgpt.web.exception.ApiException;
import me.braydon.chatgpt.web.response.ChatMessage;
import me.braydon.chatgpt.web.response.impl.chat.ChatCompletion;
import me.braydon.chatgpt.web.response.impl.model.Model;
import me.braydon.chatgpt.web.response.impl.model.ModelList;

import java.util.Map;

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
     * @throws ApiException for raised api errors
     */
    @NonNull
    public ModelList models() {
        return ApiWebRequest.get()
                   .path("/models")
                   .credentials(apiCredentials)
                   .build().execute(ModelList.class);
    }
    
    /**
     * Get the model that has the
     * same id as the given model enum.
     *
     * @param model the model enum
     * @return the model
     * @see Model for model
     * @see ModelEnum for model enum
     * @throws ApiException for raised api errors
     */
    @NonNull
    public Model getModel(@NonNull ModelEnum model) {
        return getModel(model.getId());
    }
    
    /**
     * Get the model with the given id.
     *
     * @param modelId the id of the model
     * @return the model
     * @see Model for model
     * @throws ApiException for raised api errors
     */
    @NonNull
    public Model getModel(@NonNull String modelId) {
        return ApiWebRequest.get()
                   .path("/models/" + modelId)
                   .credentials(apiCredentials)
                   .build().execute(Model.class);
    }
    
    /**
     * Send a chat message using the model that has the
     * same id as the given model enum, and with the
     * provided chat history.
     *
     * @param model the model enum
     * @param history the chat history
     * @return the model
     * @see ChatMessage for chat message
     * @see Model for model
     * @see ModelEnum for model enum
     * @throws ApiException for raised api errors
     */
    @NonNull
    public ChatCompletion chatCompletion(@NonNull ModelEnum model, @NonNull ChatMessage... history) {
        return chatCompletion(model.getId(), history);
    }
    
    /**
     * Send a chat message using the model with
     * the given id, and with the provided chat
     * history.
     *
     * @param modelId the id of the model
     * @param history the chat history
     * @return the chat completion
     * @see ChatMessage for chat message
     * @see Model for model
     * @throws ApiException for raised api errors
     */
    @NonNull
    public ChatCompletion chatCompletion(@NonNull String modelId, @NonNull ChatMessage... history) {
        if (history.length < 1) { // No need at least one chat message
            throw new IllegalArgumentException("At least one message must be present in history");
        }
        return ApiWebRequest.post(Map.of(
            "model", modelId,
            "messages", history
            )).path("/chat/completions")
                   .credentials(apiCredentials)
                   .build().execute(ChatCompletion.class);
    }
}