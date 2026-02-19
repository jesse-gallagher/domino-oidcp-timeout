package config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.ClaimsDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.OpenIdProviderMetadata;

@ApplicationScoped
@OpenIdAuthenticationMechanismDefinition(
    clientId = "example-clientid",
    clientSecret = "supersecret",
    redirectURI = "${baseURL}/callback",
    providerURI = "https://domino-oidcp.example.com:12443/auth/protocol/oidc",
    scope = { "openid", "email" },
    providerMetadata = @OpenIdProviderMetadata(
        idTokenSigningAlgorithmsSupported = "ES256",
        // Domino in the container doesn't include the port in the issuer
        issuer = "https://domino-oidcp.example.com/auth/protocol/oidc"
    ),
    claimsDefinition = @ClaimsDefinition(
        callerNameClaim = "sub"
    ),
    tokenAutoRefresh = true,
    redirectToOriginalResource = true
)
public class AppSecurity {
    
}
