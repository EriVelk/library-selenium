package org.example.controller.screen;

import org.apache.commons.io.FileUtils;
import org.example.utils.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public String screenShoot(WebDriver driver){
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFileToDirectory(srcFile, new File(Constants.pathImg), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Constants.pathImg.concat(srcFile.getName());
    }
}
