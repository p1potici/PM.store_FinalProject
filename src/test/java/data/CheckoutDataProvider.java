package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Provides test data for checkout forms.
 */
public class CheckoutDataProvider {
    public static Stream<Arguments> validCheckoutData() {
        return Stream.of(
                Arguments.of(
                        "John.Doee@example.com", // Email
                        "VoieVod",               // Last Name
                        "Doei",                  // First Name
                        "0763001892",            // Phone
                        "Cluj",                  // County
                        "Cluj-Napoca",           // City
                        "Strada Principala 123"  // Address
                )
        );
    }
}
