package me.braydon.chatgpt;

import me.braydon.chatgpt.web.ApiCredentials;

/**
 * Tests require the following env vars to be set:
 * TEST_API_KEY - Your OpenAI API key
 *
 * @author Braydon
 */
public class Constants {
    /**
     * The test client to use.
     *
     * @see ChatGPT for the client
     */
    protected static final ChatGPT TEST_CLIENT = new ChatGPT(ApiCredentials.builder()
                                                                 .apiKey(System.getenv("TEST_API_KEY"))
                                                                 .build());
}
