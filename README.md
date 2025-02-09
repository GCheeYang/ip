# Tom boi


> Tom frees your mind of having to remember things you need to do. It's

* text-based
* easy to learn
* ~FAST~ *SUPER* FAST to use

All you need to do is,

1. download it from here.
1. double-click it.
1. add your tasks.
1. let it manage your tasks for you 😉

And it is **FREE!**

Features:

[x] Managing tasks
[ ]Managing deadlines (coming soon)
[ ] Reminders (coming soon)

If you are a Java programmer, you can use it to practice Java too. Here's the main method: 

```
public class Main {
   public static void main(String[] args) {
      Application.launch(MainApp.class, args);
   }
}
```

###

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
