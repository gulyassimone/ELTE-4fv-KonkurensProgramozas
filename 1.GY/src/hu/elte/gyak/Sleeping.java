package hu.elte.gyak;

import java.time.Duration;
import java.time.Instant;

public class Sleeping {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("started");
        Instant start = Instant.now();
        Thread.sleep(5_000);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
}
