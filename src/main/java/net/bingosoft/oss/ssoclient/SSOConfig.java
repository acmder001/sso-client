/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package net.bingosoft.oss.ssoclient;

/**
 * {@link SSOClient}的配置信息类。
 */
public class SSOConfig {

    protected String clientId;
    protected String clientSecret;
    protected String redirectUri;
    protected String publicKeyEndpointUrl;
    protected String tokenEndpointUrl;
    protected String authorizationEndpointUrl;
    protected String oauthLogoutEndpoint;

    //todo :

    public SSOConfig() {
        this(null,null);
    }

    public SSOConfig(String clientId, String clientSecret) {
        this.clientId     = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * @see {@link #autoConfigureUrls(String)}.
     */
    public SSOConfig(String serverUrl) {
        this.autoConfigureUrls(serverUrl);
    }

    /**
     * 返回应用标识
     */
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 返回应用密钥
     */
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * 返回应用的回调地址(redirect_uri) 
     */
    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    /**
     * 返回获取SSO服务器公钥的url
     */
    public String getPublicKeyEndpointUrl() {
        return publicKeyEndpointUrl;
    }

    public void setPublicKeyEndpointUrl(String publicKeyEndpointUrl) {
        this.publicKeyEndpointUrl = publicKeyEndpointUrl;
    }

    /**
     * 返回SSO生成access token的url
     */
    public String getTokenEndpointUrl() {
        return tokenEndpointUrl;
    }

    public void setTokenEndpointUrl(String tokenEndpointUrl) {
        this.tokenEndpointUrl = tokenEndpointUrl;
    }

    /**
     * 返回SSO登录验证地址
     */
    public String getAuthorizationEndpointUrl() {
        return authorizationEndpointUrl;
    }
    public void setAuthorizationEndpointUrl(String authorizationEndpointUrl) {
        this.authorizationEndpointUrl = authorizationEndpointUrl;
    }

    /**
     * 返回SSO单点注销地址
     */
    public String getOauthLogoutEndpoint() {
        return oauthLogoutEndpoint;
    }

    public void setOauthLogoutEndpoint(String oauthLogoutEndpoint) {
        this.oauthLogoutEndpoint = oauthLogoutEndpoint;
    }

    /**
     * 指定SSO服务器的基础地址,自动配置其他的地址属性。
     *
     * <p/>
     * 示例:
     * <pre>
     *
     *      String baseUrl = "https://sso.example.com/v3/oauth2";
     *
     *      SSOConfig config = new SSOConfig().autoConfigure(baseUrl);
     *
     * </pre>
     */
    public SSOConfig autoConfigureUrls(String baseUrl) {
        if(baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }
        //todo :
        this.setPublicKeyEndpointUrl(baseUrl + "/publickey");
        this.setTokenEndpointUrl(baseUrl+ "/oauth2/token");
        this.setAuthorizationEndpointUrl(baseUrl+"/oauth2/authorize");
        this.setOauthLogoutEndpoint(baseUrl+"/oauth2/logout");
        return this;
    }
    

    
}