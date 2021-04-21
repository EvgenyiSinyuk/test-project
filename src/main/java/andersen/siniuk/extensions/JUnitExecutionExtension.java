package andersen.siniuk.extensions;

import andersen.siniuk.drivers.DriverFactory;
import andersen.siniuk.utils.ScreenshotMaker;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class JUnitExecutionExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource, TestWatcher {

    private static boolean started = false;
    private static Logger logger = LoggerFactory.getLogger(WebDriver.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenshotMaker.makeScreenshot(DriverFactory.getDriver());
        logger.error("On exception screenshot saved");
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            DriverFactory.getDriver();
            context.getRoot().getStore(GLOBAL).put("init driver", this);
        }
    }

    @Override
    public void close() {
        DriverFactory.getDriver().close();
    }
}
