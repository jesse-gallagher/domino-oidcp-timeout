package controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.security.enterprise.identitystore.openid.OpenIdContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("token")
@Controller
@RolesAllowed("users")
public class TokenController {
    @Inject
    private OpenIdContext context;

    @Inject
    private Models models;

    @GET
    @View("token.jsp")
    public void showToken() {
        models.put("token", context.getAccessToken());
    }
}
