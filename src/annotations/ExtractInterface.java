package annotations;

import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    String value();
}
