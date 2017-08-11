package example;

import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable_1 {
    String name() default "";
}
