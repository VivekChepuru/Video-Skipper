# 🎥 LearnWorlds Video Skipper Automation

A simple automation tool built with Java and Selenium WebDriver that helps you skip through LearnWorlds course videos by automatically logging in, playing the video, seeking to the end, and clicking the "Next" button — all in headless mode.

> ⚠️ **Note:** This tool is still in **development stage**. Contributions, suggestions, and improvements are welcome!

---

## 🚀 Features

- ✅ Auto-login using provided email and password
- ▶️ Clicks the play button (if video isn't auto-playing)
- ⏩ Seeks the video to its end to skip content
- ➡️ Navigates to the next unit by clicking "Next"
- 🧠 Runs in **headless mode** for efficient automation (optional GUI available)
- 🔁 Loops through all units in the course

---

## ⚙️ Prerequisites

Make sure you have the following installed:

```json
{
  "Java": "17 or higher",
  "Maven": "3.8 or higher",
  "GeckoDriver": "Managed by WebDriverManager",
  "Browser": "Firefox (tested with latest)",
  "Selenium": "4.x",
  "Bonigarcia WebDriverManager": "5.x"
}
```
🛠️ Setup & Run
 **Clone the Repository**

git clone `https://github.com/yourusername/video-skipper.git`
cd `video-skipper`

**Update Your Credentials**
Inside VideoSkipper.java, update the login section:

`emailField.sendKeys("your_email@example.com");`

`passwordField.sendKeys("your_password");`

**Update the Course URL**
Replace the hardcoded URL with your own LearnWorlds course unit URL:

`
driver.get("https://careerpedia.mylearnworlds.com/path-player?courseid=your-course-id&unit=your-unit-id");
`

💡 Tip: Click on the desired starting video manually to get its unique URL and paste it in the driver.get() call.

**Build and Run:
**
`
mvn clean compile exec:java -Dexec.mainClass="com.video.automation.VideoSkipper"
`

**🔄 Customizations
**
Reduce or increase delay between actions:

You can change the Thread.sleep() value near the end of each loop to control how quickly the automation moves to the next video:

`
Thread.sleep(800); // reduce to 300 or 400 for faster skipping
`

**Enable visible browser (optional):**
Uncomment this line to disable headless mode:

`
    // options.addArguments("--headless=new");
`

🧪 Still in Development

This project is in early stages, so:

🚧 Some UI elements or selectors might change — adjust them as needed.

🔄 Login or skip logic might require tweaks based on your course.

❗ If video fails to skip or you get a timeout, it's likely due to inconsistent video player behavior — report these cases if possible.

🙋 Notes for Users

 Always start from a valid unit URL (visit the course in browser and copy a unit URL).

 If you're already logged in, the automation will skip the login.

 Be sure that your course allows skipping or doesn't enforce watch time.

📬 Feedback or Issues?

Feel free to open issues or send pull requests.
For quick feedback, email: vivekchepuru9@gmail.com
