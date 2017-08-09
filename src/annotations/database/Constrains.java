package annotations.database;

import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains {
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
