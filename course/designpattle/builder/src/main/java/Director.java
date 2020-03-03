public class Director {

    public void construct(Builder builder){
        builder.buildBattery();
        builder.buildCPU();
        builder.buildMemory();
        builder.buildScreen();
        builder.buildCarema();
        builder.buildFingerPrint();
        builder.buildGPS();
        builder.buildNFC();
    }
}
