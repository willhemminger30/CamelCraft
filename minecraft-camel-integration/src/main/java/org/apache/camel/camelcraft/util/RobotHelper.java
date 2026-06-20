package org.apache.camel.camelcraft.util;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotHelper {
    public static void typeString (String str) {
        str = "/w " + Properties.USERNAME + " " + str;
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(str), null);

        try {
            Robot robot = new Robot();
            robot.setAutoWaitForIdle(true);

            pressKey(robot, KeyEvent.VK_T);
            pressKey(robot, KeyEvent.VK_BACK_SPACE);
            pressKey(robot, KeyEvent.VK_BACK_SPACE);
            paste(robot);
            pressKey(robot, KeyEvent.VK_ENTER);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void pressKey(Robot robot, int keycode) throws InterruptedException {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
    }

    private static void paste(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }
}
