using Xunit;
public class UserAuthenticationTests
{
    /** This test validates that the authentication process should work correctly when correct credentials are provided. **/
    [Fact]
    public void Authenticate_ShouldSucceed_WithValidCredentials()
    {
        var username = "validUser";
        var password = "validPass";
        var result = Authenticate(username, password);
        
        Assert.True(result, "The authentication should succeed when correct credentials are provided.");
    }

    /** This test verifies that authentication fails when an incorrect password is provided. **/
    [Fact]
    public void Authenticate_ShouldFail_WithIncorrectPassword()
    {
        var username = "validUser";
        var password = "wrongPass";
        var result = Authenticate(username, password);
        
        Assert.False(result, "The authentication should fail when an incorrect password is provided.");
    }

    /** This test verifies that the authentication process should fail when an incorrect user name is provided. **/
    [Fact]
    public void Authenticate_ShouldFail_WithIncorrectUsername()
    {
        var username = "wrongUser";
        var password = "validPass";
        var result = Authenticate(username, password);
        
        Assert.False(result, "The authentication should fail when an incorrect username is provided.");
    }

    /** This test verifies that if the username is empty, authentication must fail. **/
    [Fact]
    public void Authenticate_ShouldFail_WhenUsernameIsEmpty()
    {
        var username = "";
        var password = "validPass";
        var result = Authenticate(username, password);
        
        Assert.False(result, "The authentication should fail when the username is empty.");
    }

    /** This test validates that authentication fails when the password is empty. **/
    [Fact]
    public void Authenticate_ShouldFail_WhenPasswordIsEmpty()
    {
        var username = "validUser";
        var password = "";
        var result = Authenticate(username, password);
        
        Assert.False(result, "The authentication should fail when the password is empty.");
    }
    
    /** Dummy authentication method **/
    private bool Authenticate(string username, string password)
    {
        return username == "validUser" && password == "validPass";
    }
}