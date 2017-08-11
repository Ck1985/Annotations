package example;

import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger_1 {
    String name() default "";
    Constrains_1 constrains() default @Constrains_1;
}
