package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void switchWindowToChild() {
		Set<String> handles = driver.getWindowHandles();
	    Iterator<String> i1 = handles.iterator();
	    String parentWindowHandle = i1.next();
	    String childWindowHandle = i1.next();
	    driver.switchTo().window(childWindowHandle);
	}

}
