import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LimiterTest {


    public static void main(String[] args) throws InterruptedException {


        RateLimiter limiter = RateLimiter.create(2);

        TimeUnit.SECONDS.sleep(2);

        IntStream.rangeClosed(1, 100)
                .forEach(t -> {
                    boolean acquire = limiter.tryAcquire();
                    System.out.println(acquire);
                });


    }


}
