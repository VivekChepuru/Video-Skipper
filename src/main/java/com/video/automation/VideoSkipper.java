package com.video.automation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoSkipper {
    public static void main(String[] args) {
        // Setup FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless"); // Run in headless mode (no GUI)
        options.addArguments("--headless=new"); // For Firefox 109+ (new headless mode)
        WebDriver driver = new FirefoxDriver(options);

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. Open the video platform
            driver.get("https://careerpedia.mylearnworlds.com/path-player?courseid=core-java&unit=64be0f645bf1b05b06018accUnit");

            // 2. Login if login page is visible
            try {
                WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
                WebElement password = driver.findElement(By.name("password"));
                WebElement loginButton = driver.findElement(By.id("submitLogin")); // Change selector as needed

                username.sendKeys("vivekchepuru9@gmail.com");
                password.sendKeys("Chvivek@246");
                loginButton.click();
                System.out.println("✅ Logged in successfully");
            } catch (TimeoutException e) {
                System.out.println("🔄 Already logged in or login page not detected.");
            }

            // 3. Main loop to skip and go to next video
            while (true) {
                // Wait for video or play button
                try {
                    WebElement playButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".playButton"))); // Change selector
                    if (playButton.isDisplayed()) {
                        playButton.click();
                        System.out.println("▶️ Clicked play button");
                    }
                } catch (TimeoutException ignored) {
                }

                // 4. Seek to the end of the video
                try {
                    WebElement video = driver.findElement(By.tagName("video"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].currentTime = arguments[0].duration;", video);
                    System.out.println("⏩ Skipped video to the end");
                } catch (Exception e) {
                    System.out.println("⚠️ Could not skip video");
                }

                // 5. Wait for "Next" button to appear
                try {
                    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".next"))); // Change selector
                    nextButton.click();
                    System.out.println("➡️ Clicked Next button");
                } catch (TimeoutException e) {
                    System.out.println("✅ No more next video or end of course");
                    break;
                }

                // Optional: short pause to let page update
                Thread.sleep(100);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
