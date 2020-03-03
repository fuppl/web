public class Test {
    public static void main(String[] args) {
        Director director = new Director();
//        p1
        Builder phone1Builder = new Phone1Builder();
        director.construct(phone1Builder);
        Phone phone1 = phone1Builder.getResult();
        System.out.println(phone1);
//        p2
        Builder phone2Builder = new Phone2Builder();
        director.construct(phone2Builder);
        Phone phone2 = phone2Builder.getResult();
        System.out.println(phone2);
//        p3
        Builder phone3Builder = new Phone3Builder();
        director.construct(phone3Builder);
        Phone phone3 = phone3Builder.getResult();
        System.out.println(phone3);
    }
}
