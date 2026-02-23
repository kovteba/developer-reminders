package kovteba.java16.record.record4;

/*
// tag::Record4Demo[]
public class Record4Demo {
    public void printObject(Object obj) {
        if (obj instanceof UserDTO(Long id, String name, String email)) { // Deconstruction pattern can only be applied to a record, 'UserDTO' is not a record
            System.out.println("Привіт, " + name + "!");
        }

        if (obj instanceof UserRecord(Long id, String name, String email)) { // Correct usage with record
            System.out.println("Привіт, " + name + "!");
        }

        if (obj instanceof UserRecord ur) { // Correct usage with record
            System.out.println("Привіт, " + ur.name() + "!");
        }

        if (obj instanceof UserDTO) { // Traditional instanceof check
            UserDTO user = (UserDTO) obj;
            System.out.println("Привіт, " + user.getName() + "!");
        }
    }
}
// end::Record4Demo[]
*/
