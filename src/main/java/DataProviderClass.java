import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider
    public static Object[][] dataFor_login(){
        return new Object[][]{
                {"mngr186603","pyqAbAt"},
                {"invalid_ID","pyqAbAt"},
                {"mngr186603","invalid_Password"},
                {"invalid_ID","invalid_Password"}
        };
    }

}
