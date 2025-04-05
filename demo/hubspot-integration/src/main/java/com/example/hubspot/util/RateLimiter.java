import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private final int maxRequests;
    private final long timeWindow;
    private final AtomicInteger requestCount;
    private long windowStart;

    public RateLimiter(int maxRequests, long timeWindow, TimeUnit timeUnit) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeUnit.toMillis(timeWindow);
        this.requestCount = new AtomicInteger(0);
        this.windowStart = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        if (now - windowStart > timeWindow) {
            requestCount.set(0);
            windowStart = now;
        }

        if (requestCount.get() < maxRequests) {
            requestCount.incrementAndGet();
            return true;
        }

        return false;
    }
}