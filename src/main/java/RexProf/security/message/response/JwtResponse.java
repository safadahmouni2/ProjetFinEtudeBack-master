package RexProf.security.message.response;

public class JwtResponse {
    private String token;
    private String username;
    private String authorities;
    private String type = "Bearer";

    public JwtResponse(String accessToken, String username, String role) {
        this.token = accessToken;
        this.username=username;
        this.authorities=role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}