package me.braydon.chatgpt.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Credentials to use when sending
 * {@link ApiWebRequest}'s to OpenAI.
 *
 * @author Braydon
 */
@AllArgsConstructor @Getter
public class ApiCredentials {
    /**
     * The API key to use when authenticating with the OpenAI API.
     */
    @NonNull private final String apiKey;
    
    /**
     * The organization to use when authenticating with the OpenAI API.
     */
    @NonNull private final String organization;
    
    @Override
    public String toString() {
        int length = 7; // The amount of chars to show
        String key = this.apiKey.substring(0, length);
        String apiKey = key + "*".repeat(this.apiKey.length() - length) + '\'';
        return "ApiCredentials{" +
                   "apiKey='" + apiKey + '\'' +
                   ", organization='" + organization + '\'' +
                   '}';
    }
}