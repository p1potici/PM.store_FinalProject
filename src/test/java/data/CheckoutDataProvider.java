package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CheckoutDataProvider {

    public static Stream<Arguments> validCheckoutData() {
        return Stream.of(
                Arguments.of(
                        "John.Doee@example.com",
                        "VoieVod",
                        "Doei",
                        "0763001892",
                        "Cluj",
                        "Cluj-Napoca",
                        "Strada Principala 123",
                        "metoda de plata"
                )
        );
    }
}

