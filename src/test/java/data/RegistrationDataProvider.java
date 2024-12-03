package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class RegistrationDataProvider {

    public static Stream<Arguments> validRegistrationData() {
        return Stream.of(
                Arguments.of("John.Doeei@example.com", "John", "Doe", "Test123!", "Test123!")
        );
    }

    public static Stream<Arguments> invalidRegistrationData() {
        return Stream.of(
                Arguments.of("", "John", "Doe", "Test123!", "Test123!"),
                Arguments.of("invalid-email", "John", "Doe", "Test123!", "Test123!")
        );
    }
}
