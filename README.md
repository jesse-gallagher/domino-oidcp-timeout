# Domino OIDCP Testbed

Once launched, the servers are available at:

- OIDCP server: https://domino-oidcp.example.com:12443/
- Nomad: https://domino-nomad.example.com:12444/
- Webapp: http://oidcp-testapp.example.com:12445/oidcp-client-app/

## Reproduction Process

- Add hosts file entries for your Docker host for `domino-oidcp.example.com` and `domino-nomad.example.com`
    - This is "/etc/hosts" on Linux/macOS or "C:\Windows\System32\drivers\etc\hosts" on Windows
- Run `docker compose up` in the root directory and wait for Domino's startup messages to get to at least "HTTP Server: Started"
    - The compose.yml picks the Domino container image to use, which by default is hosted on HCL's Harbor. To use another image, change the BASEIMAGE argument
- Visit https://domino-nomad.example.com:12444/ (you'll need to accept the self-signed certificate)
    - It's probably a good idea to do this in a private-browsing window if you intend to start/stop the containers multiple times
- Log in as "OIDCP Admin" with password "password"
- Open "idpcat.nsf" on server "OIDCPTest/OIDCP"
    - Go to "Domino OIDC Provider" and click "Add Domino OIDC Provider"
        - Pick "domino-oidcp.example.com" as the Internet site
        - Save and close
    - Go to "Registered OAuth Clients" and click "Add OAuth Client"
        - Pick "domino-oidcp.example.com" as the OIDC provider
        - Name can be anything
        - Set client ID to "example-clientid"
        - Set Authentication method to "Client secret post"
        - Set client secret to "supersecret"
        - Set redirect URIs to "http://oidcp-testapp.example.com:12445/oidcp-client-app/callback"
        - Set audience to "https://domino-oidcp.example.com:12443/
        - Keep scopes the default "openid email"
        - Set "PKCE optional" to "Yes" and accept the warning (the Liberty app needs this off for now)
        - Save and close
- Open "admincentral.nsf" on server "OIDCPTest/OIDCP"
    - Click on the "server console" command on the bottom left
    - Type "res ta http" in Command and click Send
    - Wait for HTTP to restart
    - Visit https://domino-oidcp.example.com:12443/auth/protocol/oidc/.well-known/openid-configuration to ensure that it worked - it should show a bunch of OIDC config data
- Visit http://oidcp-testapp.example.com:12445/oidcp-client-app
    - Click "Token Page" on the left
    - Log in as "OIDCP Admin" with password "password"
- Wait a while - I tend to leave it overnight (if using a private window, keep it open). It seems like the timeout is 16-ish hours
- Re-visit http://oidcp-testapp.example.com:12445/oidcp-client-app in the same browser session
    - This should redirect back to the Domino login page, but the page content will be sparse
    - Specifically, the JS and CSS files will themselves be login pages instead of the expected content
    - Removing the `__Secure-DomOidcpFailover` cookie fixes the trouble until the next day