public class Adapt implements TypeC {
    Micro micro;

    public Adapt() {
        micro = new Read();
    }

    @Override
    public void charge(String type) {
        if(type.equals("read"))
            micro.read();
    }
}
