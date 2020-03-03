public class Phone2Builder implements Builder {
    private Phone phone = new Phone();
    @Override
    public void buildCPU() {
        phone.setCPU("CPU");
    }

    @Override
    public void buildMemory() {
        phone.setMemory("memory");
    }

    @Override
    public void buildBattery() {
        phone.setBattery("battery");
    }

    @Override
    public void buildScreen() {
        phone.setScreen("screen");
    }

    @Override
    public void buildFingerPrint() {
        phone.setFingerprint("无fingerprint");
    }

    @Override
    public void buildNFC() {
        phone.setNFC("无NFC");
    }

    @Override
    public void buildGPS() {
        phone.setGPS("无GPS");
    }

    @Override
    public void buildCarema() {
        phone.setCamera("carema");
    }

    @Override
    public Phone getResult() {
        return phone;
    }
}
