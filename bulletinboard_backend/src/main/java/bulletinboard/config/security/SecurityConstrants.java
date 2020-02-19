package bulletinboard.bulletinboard_be.config.security;

public class SecurityConstrants {
//    public static final Integer EXPIRATION_TIME = 1 * 60 * 1000; // 1 minutes
    public static final Integer EXPIRATION_TIME = 5 * 1000;

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/user";
    public static final String TOKEN_SECRET = "vdfo9323kn2vnlsewl";

//    public static String getTokenSecret(){
//        AppProperties appProperties = (AppProperties) SpringApplicationC
//
//    }

//    public static final String TOKEN_SECRET = "vdfo9323kn2vnlsewl";


}
