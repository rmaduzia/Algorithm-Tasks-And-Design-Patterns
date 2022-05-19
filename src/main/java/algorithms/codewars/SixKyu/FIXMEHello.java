package algorithms.codewars.SixKyu;

import java.util.LinkedHashMap;

public class FIXMEHello {

    class Dinglemouse {

        LinkedHashMap<String, String> content = new LinkedHashMap<>();

        public Dinglemouse setAge(int age) {
            content.put("age", " I am " + age + ".");
            return this;
        }

        public Dinglemouse setSex(char sex) {
            content.put("sex", sex == 'M' ? " I am male." : " I am female.");
            return this;
        }

        public Dinglemouse setName(String name) {
            content.put("name", " My name is " + name + ".");
            return this;
        }

        public String hello() {
            return "Hello." + String.join("", content.values());
        }
    }
}
