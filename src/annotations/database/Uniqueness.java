package annotations.database;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public @interface Uniqueness {
    Constrains constrain() default @Constrains(unique = true);
}
