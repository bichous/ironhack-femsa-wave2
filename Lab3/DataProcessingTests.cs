using Xunit;
public class DataProcessingTests
{
    /** This test validates that the `fetchData()` function returns valid data. **/
    [Fact]
    public void FetchData_ShouldReturnValidData()
    { 
        var dataProcessor = new DataProcessor();  // The data processor is instantiated.
        var data = dataProcessor.FetchData();
        
        Assert.NotNull(data);  // It is verified that the data are not null.
        Assert.True(data.Any(), "Fetched data should not be empty.");  // It is verified that the data are not empty.
    }

    /** This test verifies that the data were processed correctly. **/
    [Fact]
    public void ProcessData_ShouldProcessDataSuccessfully()
    {
        var dataProcessor = new DataProcessor();
        var data = dataProcessor.FetchData();  // Get the data
        
        dataProcessor.ProcessData(data);  // Data processing        
        Assert.True(data.ProcessedSuccessfully, "Data should be processed successfully.");
    }

    /** It verifies that if an error occurs during data processing, it is handled correctly. **/
    [Fact]
    public void ProcessData_ShouldHandleErrorsGracefully()
    {
        var dataProcessor = new DataProcessor();
        var invalidData = new Data();  // A data object that causes an error is created.

        var exception = Assert.Throws<ProcessingException>(() => dataProcessor.ProcessData(invalidData));
        Assert.Equal("Data processing error", exception.Message);
    }

    /** // Invalid data is checked to ensure that it should not be processed. **/
    [Fact]
    public void ProcessData_ShouldNotProcessInvalidData()
    {
        var dataProcessor = new DataProcessor();
        var invalidData = new Data { IsValid = false };  // Invalid data
        
        dataProcessor.ProcessData(invalidData);
        Assert.False(invalidData.ProcessedSuccessfully, "Invalid data should not be processed.");
    }
}