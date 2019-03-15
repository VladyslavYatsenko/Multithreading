package snd.example;

import java.util.UUID;

public class StringGenerator {
    private String uuid;
    public StringGenerator() {
        uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }
}
