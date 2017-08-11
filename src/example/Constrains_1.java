package example;

import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains_1 {
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
