package ru.netology.netologydiplom.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/cloud/login/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "auth-token";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000;
}
