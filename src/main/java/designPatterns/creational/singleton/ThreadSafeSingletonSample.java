package designPatterns.creational.singleton;

public class ThreadSafeSingletonSample {

    private static ThreadSafeSingletonSample threadSafeSingletonSample;
    private String value;

    private ThreadSafeSingletonSample(String value) {
        this.value = value;
    }

    synchronized public static ThreadSafeSingletonSample getInstance(String value) {
        if (threadSafeSingletonSample == null) {
            threadSafeSingletonSample = new ThreadSafeSingletonSample(value);
        }
        return threadSafeSingletonSample;
    }
}