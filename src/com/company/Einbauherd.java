package com.company;

public class Einbauherd implements IKochfeld, IOfen {
    // Statusvariablen:
    private boolean hatStrom = false;
    private int[] kochfelderStatus;
    private int ofenTempIst;
    private int ofenTempSoll;
    private boolean ofenTuerOffen;
    private int programm;

    // Rahmenvariablen:
    private int anzahlKochfelder;
    private int maxOfenGrad;
    private int anzahlProgramme;
    private int anzahlStufen;

    // Konstruktor:
    Einbauherd(int anzahlKochfelder, int anzahlStufen, int maxOfenTemp, int anzahlProgramme){
        this.anzahlKochfelder = anzahlKochfelder;
        kochfelderStatus = new int[anzahlKochfelder];
        for (int i : kochfelderStatus){
            kochfelderStatus[i]=0;
        }
        this.maxOfenGrad = maxOfenTemp;
        this.anzahlProgramme = anzahlProgramme;
        this.anzahlStufen = anzahlStufen;
    }

    // klasseneigene Methoden:
    void stromAnschließen(){
        hatStrom = true;
    }

    void stromAbklemmen(){
        hatStrom = false;
    }

    void ofenVorheizen(int grad, int minuten){
        ofenTempSoll = grad;
        programm = 1;
        for (int zeit = 0; zeit <= minuten; zeit++){
            if (ofenTempIst<ofenTempSoll){
                ofenTempIst += 25;
                System.out.println("Temperatur: " + ofenTempIst);
            }
            else System.out.println("piep");
        }
    }

    // Methoden aus IKochfeld:
    @Override
    public int getStufe(int kochfeld) {
        return kochfelderStatus[kochfeld];
    }

    @Override
    public int getAnzahlKochfelder() {
        return anzahlKochfelder;
    }

    @Override
    public void setStufe(int kochfeld, int stufe) {
        if (stufe<=anzahlStufen && stufe >= 0) kochfelderStatus[kochfeld]=stufe;
        else System.out.println("Fehlerhafte einstellung");
    }

    // Methoden aus IOfen:
    @Override
    public void setOfenTemp(int grad) {
        if (grad<=maxOfenGrad && grad >= 0){
            while(ofenTempIst < ofenTempSoll){
                ofenTempIst += 20;
                System.out.println("Temperatur: " + ofenTempIst);
            }
        } else System.out.println("Fehlerhafte einstellung");
    }

    @Override
    public void ofentuerAuf() {
        ofenTuerOffen = true;
        ofenTempIst -= 50;
    }

    @Override
    public void ofentuerZu() {
        ofenTuerOffen = false;
    }

    @Override
    public void setProgramm(int programmnummer) {
        if (programmnummer <= anzahlProgramme && programmnummer >= 0) programm = programmnummer;
        else System.out.println("Fehlerhafte einstellung");
    }

}
