package kovteba;

import kovteba.entity.User;

// tag::BuilderDemo[]
public class BuilderDemo {

    public static void main(String[] args) {

        User user = new User.Builder()
                            .username("dmytro")
                            .email("dmytro@example.com")
                            .age(30)
                            .address("Ukraine")
                            .build();

        System.out.println(user);
    }
}
// end::BuilderDemo[]
