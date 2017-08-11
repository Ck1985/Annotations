package example;

import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public @interface Uniqueness_1 {
    Constrains_1 constrains() default @Constrains_1(unique = true);
}
