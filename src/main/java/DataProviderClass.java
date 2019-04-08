import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider
    public static Object[][] dataFor_login_Valid_Data(){
        return new Object[][]{
                {"mngr186603","pyqAbAt"},

        };
    }

    @DataProvider
    public static Object[][] data_Invalid_UserID(){
        return new Object[][]{
                {"invalid_ID","pyqAbAt"}
        };
    }

    @DataProvider
    public static Object[][] data_Invalid_Password(){
        return new Object[][]{
                {"mngr186603","invalid_Password"}
        };
    }

    @DataProvider
    public static Object[][] data_Invalid_UserIDandPassword(){
        return new Object[][]{
                {"invalid_ID","invalid_Password"}
        };
    }
}
