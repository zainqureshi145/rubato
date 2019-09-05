package no.rubato.security;

public class SecurityConstants {
    static final String SIGN_UP_URLS = "/api/register/**";
    static final String VIEW_USERS = "/api/users/**";
    static final String VIEW_BANDS = "/api/bands/**";
    static final String VIEW_ADMIN = "/api/admin/**";
    static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final long EXPIRATION_TIME = 30000_0000;//30 Seconds
}
