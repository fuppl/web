public class PhoneFactory {
    public Phone getPhone(String phone){

        if(phone == null){
            System.out.println("wrong");
            return null;
        }
        else if(phone.equals("Phone1"))
            return new Phone1();
        else if(phone.equals("Phone2"))
            return new Phone2();
        else if(phone.equals("Phone3"))
            return new Phone3();

        return null;
    }
}
