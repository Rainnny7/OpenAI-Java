package me.braydon.openai;

import me.braydon.openai.web.ApiCredentials;

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
     * @see OpenAI for the client
     */
    protected static final OpenAI TEST_CLIENT = new OpenAI(ApiCredentials.builder()
                                                                 .apiKey(System.getenv("TEST_API_KEY"))
                                                                 .build());
}
