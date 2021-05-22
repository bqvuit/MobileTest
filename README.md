## Note before start:
```
- Hardcode your deviceId in `src\main\resources\config.json`
- Please check the APK is up to date or not
- Install Lombok Plugin into Intellij IDE
```

## Install Appium
```
Install Appium by npm packages (npm install -g appium)
```

## Install Android Studio and additional Android SDK tools
## Set Environment Variables 
### Window
```
Set ANDROID_HOME equal to SDK folder location. Ex: C:\Users\{UserNAme}\AppData\Local\Android\sdk
Add folder locations to Path variable:
    %ANDROID_HOME%\platform-tools
    %ANDROID_HOME%\tools
    %ANDROID_HOME%\tools\bin
Check settings and installations: sdkmanager –list
```

##  Mac
```
edit - nano ~./bash_profile
export ANDROID_HOME=/Users/$USER/Library/Android/sdk/
export PATH=$PATH:$ANDROID_HOME
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
```

## Test case
##### 1/ Open CGV App then Login
Check login pass and failed

## Running the test
- Execute Maven Command
```
mvn clean test
```


## Viewing Test report
- Open file `*/reports/{DateTimeExecute}.html` on any browser