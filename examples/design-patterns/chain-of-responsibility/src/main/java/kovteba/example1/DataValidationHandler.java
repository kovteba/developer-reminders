package kovteba.example1;

// tag::DataValidationHandler[]
public class DataValidationHandler extends Handler {

    @Override
    protected boolean process(Request request) {
        if (!request.isValidData()) {
            System.out.println("❌ Data validation failed");
            return false;
        }
        System.out.println("✔ Data is valid");
        return true;
    }
}
// end::DataValidationHandler[]
