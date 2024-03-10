package data.users;

public class Users {
    private String standardUserUsername = "standard_user";
    private String standardUserPassword = "secret_sauce";
    private boolean isLoginInAppStandardUser = true;
    private String lockedOutUsername = "locked_out_user";
    private String lockedOutUserPassword = "secret_sauce";
    private boolean isLoginInAppLockedOutUser = false;
    private String problemUsername = "problem_user";
    private String problemUserPassword = "secret_sauce";
    private boolean isLoginInAppProblemUser = true;

    public String getStandardUserUsername() {
        return standardUserUsername;
    }

    public String getStandardUserPassword() {
        return standardUserPassword;
    }

    public boolean isLoginInAppStandardUser() {
        return isLoginInAppStandardUser;
    }

    public String getLockedOutUsername() {
        return lockedOutUsername;
    }

    public String getLockedOutUserPassword() {
        return lockedOutUserPassword;
    }

    public boolean isLoginInAppLockedOutUser() {
        return isLoginInAppLockedOutUser;
    }

    public String getProblemUsername() {
        return problemUsername;
    }

    public String getProblemUserPassword() {
        return problemUserPassword;
    }

    public boolean isLoginInAppProblemUser() {
        return isLoginInAppProblemUser;
    }
}
