package me.braydon.openai.web;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Credentials to use when sending
 * {@link ApiWebRequest}'s to OpenAI.
 *
 * @author Braydon
 */
@Builder @Getter
public class ApiCredentials {
    /**
     * The API key to use when authenticating with the OpenAI API.
     */
    @NonNull private final String apiKey;
    
    /**
     * The optional organization to use when authenticating with the OpenAI API.
     */
    private final String organization;
    
    /**
     * Do these credentials
     * contain an organization?
     *
     * @return whether these creds contain an org
     */
    public boolean hasOrganization() {
        return organization != null && (!organization.trim().isEmpty());
    }
    
    @Override
    public String toString() {
        int length = 14; // The amount of chars to show
        String key = this.apiKey.substring(0, length);
        String apiKey = key + "*".repeat(this.apiKey.length() - length);
        return "ApiCredentials{" +
                   "apiKey='" + apiKey + '\'' +
                   ", organization='" + organization + '\'' +
                   '}';
    }
}