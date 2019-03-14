package SndExample;

import java.util.UUID;

public class StringGenerator {
    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }
}
