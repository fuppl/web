public class Phone3Builder implements Builder {
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
        phone.setFingerprint("fingerprint");
    }

    @Override
    public void buildNFC() {
        phone.setNFC("NFC");
    }

    @Override
    public void buildGPS() {
        phone.setGPS("GPS");
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
