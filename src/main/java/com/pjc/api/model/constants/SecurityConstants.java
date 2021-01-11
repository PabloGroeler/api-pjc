package com.pjc.api.model.constants;

public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 300_000_000; /// FIX 5 mins 300_000
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/usuarios";
}
