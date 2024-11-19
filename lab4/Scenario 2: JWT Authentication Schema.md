# Scenario 2: JWT Authentication Schema

- Participants will design a JWT-based authentication system for a hypothetical application scenario. The focus will be on secure token generation, managing token expiration, and validating tokens.
- Designs will be critiqued for potential security flaws with suggestions for enhancements to ensure robust authentication.

```
DEFINE FUNCTION generateJWT(userCredentials):
  IF validateCredentials(userCredentials):
    SET tokenExpiration = currentTime + 3600 // Token expires in one hour
    RETURN encrypt(userCredentials + tokenExpiration, secretKey)
  ELSE:
    RETURN error
```

To have an authentication system using the JWT it is required to keep these considerations in mind:
- Do not send sensitive data in the Payload, as vulnerabilities are high, since the token is in Base 64, and this could cause data risks.
- The password should not be hard-coded, but encrypted, to avoid data exposure.
- A mechanism to manage the token lifetime must be guaranteed, as well as a token regeneration mechanism.
- The management of secret keys must be correctly managed, preventing attackers from generating false tokens and having a path through which they can attack us.