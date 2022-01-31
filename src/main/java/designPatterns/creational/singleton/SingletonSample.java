package designPatterns.creational.singleton;

public class SingletonSample {

    private static SingletonSample singletonSample;
    private String value;

    private SingletonSample(String value) {
        this.value = value;
    }

    public static SingletonSample getInstance(String value) {
        if (singletonSample == null) {
            singletonSample = new SingletonSample(value);
        }
        return singletonSample;
    }
}