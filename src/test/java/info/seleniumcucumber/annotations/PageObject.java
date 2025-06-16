package info.seleniumcucumber.annotations;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactoryFinder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

// This annotation will be available at runtime
@Retention(RUNTIME)

// This annotation can be used on fields and types
@Target({ElementType.FIELD, ElementType.TYPE})

// This links the annotation with Selenium’s FindByBuilder logic (so it can locate elements)
@PageFactoryFinder(FindBy.FindByBuilder.class)
@Lazy
@Component

// Define a custom annotation named @PageObject
public @interface PageObject {

}
