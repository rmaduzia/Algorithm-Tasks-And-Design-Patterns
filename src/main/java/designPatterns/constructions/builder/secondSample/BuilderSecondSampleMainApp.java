package designPatterns.constructions.builder.secondSample;

public class BuilderSecondSampleMainApp {

    public static void main(String[] args) {

        User user = new User.UserBuilder()
                .firstName("Rafal")
                .secondName("Maduzia")
                .city("Dębica")
                .build();
    }
}