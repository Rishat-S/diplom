package ru.netology.netologydiplom.security;

public class SecurityConstants {
    public static final String CLOUD_SIGNUP = "/cloud/signup/**";
    public static final String CLOUD_LOGIN = "/cloud/login/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "auth-token";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 1_600_000;
}
