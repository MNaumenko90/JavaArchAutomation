package mobile.config.base.impl;

import com.google.common.collect.ImmutableList;
import mobile.config.base.methods.Swipes;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static mobile.config.base.impl.Condition.visible;


public class BaseMethods extends WebElementControl implements Swipes {

    private PointerInput finger = null;
    private Sequence swipe = null;

    public void swipeUp(By by, int time) {
        pointerInput(PointerInput.Kind.TOUCH, "finger");
        sequence(finger, 1);

        for (int i = 0; i < 5; i++) {
            if (isElementVisible(by)) {
                break;
            }
            Dimension dimension = driver.manage().window().getSize();

            int x = dimension.width / 2;

            int start = (int) (dimension.height * 0.8);
            int end = (int) (dimension.height * 0.2);

            addActionForSwipe(x, start, 0);
            swipe.addAction(new Pause(finger, Duration.ofMillis(time)));
            addActionForSwipe(x, end, 1000);
            driver.perform(ImmutableList.of(swipe));
        }
    }


    public void swipeElementRight(By by, int time) {
        pointerInput(PointerInput.Kind.TOUCH, "finger");
        sequence(finger, 1);
        WebElement element = element(by).shouldBe(visible);
        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        int endX = startX - 500;

        addActionForSwipe(startX, startY, 0);
        swipe.addAction(new Pause(finger, Duration.ofMillis(time)));
        addActionForSwipe(endX, startY, 1000);
        driver.perform(List.of(swipe));
    }

    public void getPhotoFromArticle(By by) {
        WebElement element = element(by).shouldBe(visible);

        byte[] imageBytes = element.getScreenshotAs(OutputType.BYTES);

        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
            File outputFile = new File("odesa_photo.png");
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void addActionForSwipe(Integer firstPoint, Integer secondPoint, int timeout) {
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(timeout), PointerInput.Origin.viewport(), firstPoint, secondPoint));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
    }

    private void pointerInput(PointerInput.Kind kind, String fingerName) {
        finger = new PointerInput(kind, fingerName);
    }

    private void sequence(PointerInput input, Integer initialLength) {
        swipe = new Sequence(input, initialLength);
    }

    private void setPointerInput(PointerInput pointer) {
        this.finger = pointer;
    }

    private void setSwipe(Sequence swipe) {
        this.swipe = swipe;
    }

    private boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
