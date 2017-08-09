package annotations;

import java.util.*;
import java.lang.reflect.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("UseCase Founded: " + useCase.id() + " " + useCase.description());
                useCases.remove(new Integer(useCase.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing UseCase: " + i);
        }
    }
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCase(useCases, PasswordUtils.class);
    }
}
