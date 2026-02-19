package config;

import java.util.Collections;
import java.util.Set;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class LoginGroupIdentityStore implements IdentityStore {

  @Override
  public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
    return Collections.singleton("users");
  }
  
  @Override
  public Set<ValidationType> validationTypes() {
    return Collections.singleton(ValidationType.PROVIDE_GROUPS);
  }

}