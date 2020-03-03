public class Phone {
    private String CPU;
    private String memory;
    private String battery;
    private String screen;
    private String camera;
    private String GPS;
    private String fingerprint;
    private String NFC;

    public Phone() {
    }

    public Phone(String CPU, String memory, String battery, String screen, String camera, String GPS, String fingerprint, String NFC) {
        this.CPU = CPU;
        this.memory = memory;
        this.battery = battery;
        this.screen = screen;
        this.camera = camera;
        this.GPS = GPS;
        this.fingerprint = fingerprint;
        this.NFC = NFC;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getNFC() {
        return NFC;
    }

    public void setNFC(String NFC) {
        this.NFC = NFC;
    }

    public String toString(){
        return "Phone [CPU=" + CPU + ", Memory=" + memory + ", Battery=" + battery + ", Screen=" + screen
                + ", Camera=" + camera + ", GPS=" + GPS + ", Fingerprint=" + fingerprint + ", NFC=" + NFC + "]";
    }
}
