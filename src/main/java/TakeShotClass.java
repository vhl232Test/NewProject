import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeShotClass {
    public static void takeScreenShot(WebDriver driver,String methodName, String filePath){

        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File fileScren = screenshot.getScreenshotAs(OutputType.FILE);


        File destscreenfile = new File(filePath,methodName + " "+DateQ.timeScreenShot()+".png");

        try {
            FileUtils.copyFile(fileScren,destscreenfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
