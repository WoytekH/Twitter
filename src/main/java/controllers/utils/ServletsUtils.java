package controllers.utils;

import javax.servlet.http.HttpServletRequest;

public class ServletsUtils {
    public static final String ERRORS_ATTRIBUTE_NAME = "errors";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String REMEMBER = "remember";
    public static final String CHECKBOX_CHECKED = "on";

    public static final String LOGIN_ERROR_HEADER = "INVALID LOGIN";
    public static final String EMAIL_ERROR_HEADER = "INVALID EMAIL";
    public static final String PASSWORD_ERROR_HEADER = "INVALID PASSWORD";
    public static final String LOGIN_NOT_EXIST_MESSAGE = "This login do not exist";
    public static final String LOGIN_IN_USE_ERROR_MESSAGE = "Typed login is already in use"; // <------------
    public static final String WRONG_PASSWORD_ERROR_MESSAGE = "Wrong password";
    public static final String EMAIL_ERROR_MESSAGE = "Typed email is already in use";
    public static final String FOLLOWED_USERS = "followedUsers";
    public static final String NOT_FOLLOWED_USERS = "notFollowedUsers";
    public static final String USER_LOGIN_FOLLOW = "userLoginToFollow";
    public static final String USER_LOGIN_TO_STOP_FOLLOW = "userLoginToUnfollow";
    public static final String FOLLOWED_TWEETS = "tweets";
    public static final String TWEET_MESSAGE_PARAM = "tweetsMessage";


    public static String getUserLoginFromSession(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(USER_LOGIN);
    }
}
