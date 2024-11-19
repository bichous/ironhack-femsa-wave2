# Scenario 1: Pseudo-Code for Authentication System

- Using provided pseudo-code examples, participants will identify potential security vulnerabilities, simulating a SAST process.
- The task will involve writing theoretical mitigation plans to address these vulnerabilities, applying SAST and DAST principles learned in the lessons.

```
FUNCTION authenticateUser(username, password):
QUERY database WITH username AND password
IF found RETURN True
ELSE RETURN False
```

- **Injection flows.** This type of attacks must be prevented with prepared statement queries, to avoid vulnerabilities when queries are exposed, such as SQL Injection.
- **Broken Authentication** Mitigate sensitive data from being hard-coded in the database by encrypting passwords in the database. Also, making use of technologies such as:
- Multi-factor authentication
  - Time-based one time password
  - OAuth