public class Test {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();

        Phone phone = phoneFactory.getPhone("Phone1");
        phone.assembly();

        Phone phone1 = phoneFactory.getPhone("Phone2");
        phone1.assembly();

        Phone phone2 = phoneFactory.getPhone("Phone3");
        phone2.assembly();
    }
}
