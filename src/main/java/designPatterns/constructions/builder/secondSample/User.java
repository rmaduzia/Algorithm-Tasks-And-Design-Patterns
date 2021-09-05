package designPatterns.constructions.builder.secondSample;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private String firstName;
    private String secondName;
    private String city;


    private User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.secondName = userBuilder.secondName;
        this.city = userBuilder.city;
    }

    public static class UserBuilder {
        private String firstName;
        private String secondName;
        private String city;


        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
