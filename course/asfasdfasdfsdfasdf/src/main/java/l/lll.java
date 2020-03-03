package l;

public class lll {
    public static void main(String[] args) {
        Director director = new Director();
        /*P1*/
        PhoneBuilder P1Builder = new P1Builder();
        director.construct(P1Builder);
        Phone P1 = P1Builder.build();
        System.out.println(P1);
        /*P2*/
        PhoneBuilder P2Builder = new P2Builder();
        director.construct(P2Builder);
        Phone P2 = P2Builder.build();
        System.out.println(P2);
        /*P3*/
        PhoneBuilder P3Builder = new P3Builder();
        director.construct(P3Builder);
        Phone P3 = P3Builder.build();
        System.out.println(P3);
    }
}

/*手机产品*/
class Phone {
    /*必选*/
    private String CPU;
    private String Memory;
    private String Battery;
    private String Screen;
    /*可选*/
    private String Camera;
    private String GPS;
    private String Fingerprint;
    private String NFC;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String Memory) {
        this.Memory = Memory;
    }

    public String getBattery() {
        return Battery;
    }

    public void setBattery(String Battery) {
        this.Battery = Battery;
    }

    public String getScreen() {
        return Screen;
    }

    public void setScreen(String Screen) {
        this.Screen = Screen;
    }

    /*可选*/
    public String getCamera() {
        return Camera;
    }

    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getFingerprint() {
        return Fingerprint;
    }

    public void setFingerprint(String Fingerprint) {
        this.Fingerprint = Fingerprint;
    }

    public String getNFC() {
        return NFC;
    }

    public void setNFC(String NFC) {
        this.NFC = NFC;
    }

    public String toString() {
        return "Phone [CPU=" + CPU + ", Memory=" + Memory + ", Battery=" + Battery + ", Screen=" + Screen
                + ", Camera=" + Camera + ", GPS=" + GPS + ", Fingerprint=" + Fingerprint + ", NFC=" + NFC + "]";
    }
}

/*建造者接口*/
interface PhoneBuilder {

    void buildCPU();

    void buildMemory();

    void buildBattery();

    void buildScreen();

    void buildCamera();

    void buildGPS();

    void buildFingerprint();

    void buildNFC();

    Phone build();
}

/*P1老年机手机建造者*/
class P1Builder implements PhoneBuilder {

    private Phone phone = new Phone();

    public void buildCPU() {
        phone.setCPU("配置手机CPU");
    }

    public void buildMemory() {
        phone.setMemory("配置手机内存");
    }

    public void buildBattery() {
        phone.setBattery("配置手机电池");
    }

    public void buildScreen() {
        phone.setScreen("配置手机屏幕");
    }

    public void buildCamera() {
        phone.setCamera("无摄像头");
    }

    public void buildGPS() {
        phone.setGPS("无GPS");
    }

    public void buildFingerprint() {
        phone.setFingerprint("无指纹识别");
    }

    public void buildNFC() {
        phone.setNFC("无NFC");
    }

    public Phone build() {
        return phone;
    }
}

/*P2拍照手机建造者*/
class P2Builder implements PhoneBuilder {

    private Phone phone = new Phone();

    public void buildCPU() {
        phone.setCPU("配置手机CPU");
    }

    public void buildMemory() {
        phone.setMemory("配置手机内存");
    }

    public void buildBattery() {
        phone.setBattery("配置手机电池");
    }

    public void buildScreen() {
        phone.setScreen("配置手机屏幕");
    }

    public void buildCamera() {
        phone.setCamera("配置高端摄像头");
    }

    public void buildGPS() {
        phone.setGPS("无GPS");
    }

    public void buildFingerprint() {
        phone.setFingerprint("无指纹识别");
    }

    public void buildNFC() {
        phone.setNFC("无NFC");
    }

    public Phone build() {
        return phone;
    }
}

/*P3旗舰版手机建造者*/
class P3Builder implements PhoneBuilder {

    private Phone phone = new Phone();

    public void buildCPU() {
        phone.setCPU("配置手机CPU");
    }

    public void buildMemory() {
        phone.setMemory("配置手机内存");
    }

    public void buildBattery() {
        phone.setBattery("配置手机电池");
    }

    public void buildScreen() {
        phone.setScreen("配置手机屏幕");
    }

    public void buildCamera() {
        phone.setCamera("配置高端摄像头");
    }

    public void buildGPS() {
        phone.setGPS("配置GPS");
    }

    public void buildFingerprint() {
        phone.setFingerprint("配置指纹识别");
    }

    public void buildNFC() {
        phone.setNFC("配置NFC");
    }

    public Phone build() {
        return phone;
    }
}

/*建造指导*/
class Director {
    public void construct(PhoneBuilder builder) {
        builder.buildCPU();
        builder.buildMemory();
        builder.buildBattery();
        builder.buildScreen();
        builder.buildCamera();
        builder.buildGPS();
        builder.buildFingerprint();
        builder.buildNFC();
    }
}