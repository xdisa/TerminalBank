package services;

public class PinValidator {
    private boolean starting = false;
    private long endTimeMillis;
    private final long blockingTimeMillis;

    public PinValidator(long blockingTimeMillis) {
        this.blockingTimeMillis = blockingTimeMillis;
    }

    public long getSecondsCountToEnd() {
        return (endTimeMillis - System.currentTimeMillis()) / 1000L;
    }

    public void start() {
        long startTimeMillis = System.currentTimeMillis();
        endTimeMillis = startTimeMillis + blockingTimeMillis;
        starting = true;
    }

    private void stop() {
        starting = false;
    }

    public boolean checkBlocking() {
        if (!starting || System.currentTimeMillis() >= endTimeMillis) {
            stop();
            return false;
        } else {
            return true;
        }
    }
}
