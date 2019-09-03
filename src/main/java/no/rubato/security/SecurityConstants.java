package no.rubato.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/api/register/**";
    public static final String VIEW_USERS = "/api/users/**";
    public static final String VIEW_BANDS = "/api/bands/**";
    public static final String VIEW_ADMIN = "/api/admin/**";
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 30000_0000;//30 Seconds
}
