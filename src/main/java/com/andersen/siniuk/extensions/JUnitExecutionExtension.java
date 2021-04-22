package com.andersen.siniuk.extensions;

import com.andersen.siniuk.drivers.DriverFactory;
import com.andersen.siniuk.utils.ScreenshotMaker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

@Slf4j
public class JUnitExecutionExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource, TestWatcher {

    private static boolean started = false;
    final static Lock lock = new ReentrantLock();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenshotMaker.makeScreenshot(DriverFactory.getDriver());
        log.error("On exception screenshot saved");
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        lock.lock();
        if (!started) {
            started = true;
            DriverFactory.getDriver();
            context.getRoot().getStore(GLOBAL).put("init driver", this);
        }
        lock.unlock();
    }

    @Override
    public void close() {
        DriverFactory.getDriver().close();
    }
}
