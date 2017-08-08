package annotations;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Testable {
    public void execute() {
        System.out.println("Executing ....");
    }
    @Test public void testExecute() {
        execute();
    }
}
