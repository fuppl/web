public class Charge implements TypeC {
    Adapt adapt;

    @Override
    public void charge(String type) {
        if(type.equals("charge"))
            System.out.println("用TypeC充电");
        else if(type.equals("read")){
            adapt = new Adapt();
            adapt.charge("read");
        }
    }
}
