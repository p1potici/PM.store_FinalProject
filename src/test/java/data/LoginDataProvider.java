package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginDataProvider {

    public static Stream<Arguments> validLoginData() {
        return Stream.of(
                Arguments.of("John.Doee@example.com","Test123!")
        );
    }

    public static Stream<Arguments> invalidLoginData() {
        return Stream.of(
                Arguments.of("","Test123!"),
                Arguments.of("John.Doee@example.com","")
        );
    }
}
