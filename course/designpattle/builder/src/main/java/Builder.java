public interface Builder {
    void buildCPU();
    void buildMemory();
    void buildBattery();
    void buildScreen();
    void buildFingerPrint();
    void buildNFC();
    void buildGPS();
    void buildCarema();

    Phone getResult();
}
