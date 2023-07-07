package me.braydon.chatgpt.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents an API web request to OpenAPI.
 *
 * @author Braydon
 */
@RequiredArgsConstructor
public final class ApiWebRequest {
    private static final String API_ENDPOINT = "https://api.openai.com/v1"; // The OpenAI API endpoint
    
    public static <T> T send(@NonNull String path, @NonNull ApiCredentials credentials, @NonNull T responseType) {}
}