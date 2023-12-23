package utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    @Contract(pure = true) public static @NotNull ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return driver -> {
            assert driver != null;
            return (Boolean) ((JavascriptExecutor)
                    driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
        };
    }
}
