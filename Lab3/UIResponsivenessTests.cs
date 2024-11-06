using Xunit;
public class UIResponsivenessTests
{
    /** This test is focused on a single responsibility: verifying that the UI component correctly fits the 1024 pixel width. The name of the test is clear and describes specifically what is being verified **/
    [Fact]
    public void UIComponent_ShouldAdjustToWidth_WhenScreenWidthIs1024()
    {
        var uiComponent = SetupUIComponent(1024);
        var adjustsToWidth = uiComponent.AdjustsToScreenSize(1024);
        Assert.True(adjustsToWidth, "UI should adjust to width of 1024 pixels.");
    }

    /** This test validates that the UI component is not set to an incorrect width (800 pixels). This test focuses exclusively on the size adjustment. **/
    [Fact]
    public void UIComponent_ShouldNotAdjust_WhenScreenWidthIsIncorrect()
    {
        var uiComponent = SetupUIComponent(1024);
        var adjustsToWidth = uiComponent.AdjustsToScreenSize(800);
        Assert.False(adjustsToWidth, "UI should not adjust to width of 800 pixels.");
    }

    /** This test validates that the UI component adjusts its height proportionally when the screen height is changed. **/
    [Fact]
    public void UIComponent_ShouldAdjustProportionally_WhenScreenHeightChanges()
    {
        var uiComponent = SetupUIComponent(1024);
        var adjustsToHeight = uiComponent.AdjustsToScreenSize(1024, 768); // New height
        Assert.True(adjustsToHeight, "UI should adjust proportionally when height changes.");
    }

    /** This test focuses on validating the UI on smaller screen sizes, such as 480 pixels wide. **/
    [Fact]
    public void UIComponent_ShouldHandleSmallScreens_WhenScreenWidthIsLessThan1024()
    {
        // Arrange
        var uiComponent = SetupUIComponent(1024);
        // Act
        var handlesSmallScreen = uiComponent.AdjustsToScreenSize(480); // Smaller screen
        // Assert
        Assert.True(handlesSmallScreen, "UI should adjust to smaller screen widths (e.g., 480 pixels).");
    }
}