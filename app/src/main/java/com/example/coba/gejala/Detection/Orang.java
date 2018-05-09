package com.example.coba.gejala.Detection;

import android.util.Log;

/**
 * Created by Owner on 28/03/2018.
 */

public class Orang {
    String nama;
    int demam;
    int defisit;
    int nkprogresif;
    int kejang;
    int fpencetus;
    int onsetMendadak;
    int edema;
    int riwayat;
    int usiaTua;
    int jk;
    int mual;
    int lokasi;
    int karakteristik;
    int skala;
    int durasi;
    int mhBerair;
    int diagnosaPertama;
    int diagnosaKedua;

//    public Orang(String nama, String demam, String defisit, String nkprogresif, String kejang, String fpencetus, String onsetMendadak, String riwayat, String mual, String usiaTua, String jk, String lokasi, String karakteristik, String skala, String durasi, String mhBerair, String diagnosaPertama, String diagnosaKedua) {
//        this.nama = nama;
//        this.demam = _convert_yes_no(demam);
//        this.defisit = _convert_yes_no(defisit);
//        this.nkprogresif = _convert_yes_no(nkprogresif);
//        this.kejang = _convert_yes_no(kejang);
//        this.fpencetus = _convert_yes_no(fpencetus);
//        this.onsetMendadak = _convert_yes_no(onsetMendadak);
//        this.riwayat = _convert_yes_no(riwayat);
//        this.usiaTua = _convert_yes_no(usiaTua);
//        this.jk = _convert_jk(jk);
//        this.lokasi = _convert_lokasi(lokasi);
//        this.karakteristik = _convert_karakteristik(karakteristik);
//        this.skala = _convert_skala(skala);
//        this.durasi = _convert_durasi(durasi);
//        this.mhBerair = _convert_yes_no(mhBerair);
//        this.mual = _convert_yes_no(mual);
//        this.diagnosaPertama = _convert_diagnosaPertama(diagnosaPertama);
//        this.diagnosaKedua = _convert_diagnosaKedua(diagnosaKedua);
//    }

    public Orang(String nama, String demam, String defisit, String nkprogresif, String kejang, String edema, String fpencetus, String onsetMendadak, String riwayat, String mual, String usiaTua, String diagnosaPertama) {
        this.nama = nama;
        this.demam = _convert_yes_no(demam);
        this.defisit = _convert_yes_no(defisit);
        this.nkprogresif = _convert_yes_no(nkprogresif);
        this.kejang = _convert_yes_no(kejang);
        this.edema = _convert_yes_no(edema);
        this.fpencetus = _convert_yes_no(fpencetus);
        this.onsetMendadak = _convert_yes_no(onsetMendadak);
        this.riwayat = _convert_yes_no(riwayat);
        this.usiaTua = _convert_yes_no(usiaTua);
        this.mual = _convert_yes_no(mual);
        this.diagnosaPertama = _convert_diagnosaPertama(diagnosaPertama);
    }

    private int _convert_diagnosaPertama(String text){
        switch (text) {
            case  "Primer":
                return 0;
            case "Sekunder":
                return 1;
            default:
                return -1;
        }
    }
    private int _convert_diagnosaKedua(String text) {
        switch(text) {
            case "Migren":
                return 0;
            case "Cluster":
                return 1;
            case "Tth":
                return 2;
            default:
                return -1;
        }
    }

    private int _convert_yes_no(String text) {
        switch(text) {
            case "Ya":
                return 1;
            case "Tidak":
                return 0;
            default:
                return -1;
        }
    }
    private int _convert_lokasi (String text) {
        switch (text) {
            case "Unilateral":
                return 0;
            case "Bilateral":
                return 1;
            default:
                return -1;
        }
    }

    private int _convert_jk (String text) {
        switch (text) {
            case "L":
                return 1;
            case "P":
                return 0;
            default:
                return -1;
        }
    }

    private int _convert_karakteristik (String text) {
        switch (text) {
            case "Berdenyut":
                return 0;
            case "Dibor":
                return 1;
            case "Tekan":
                return 2;
            default:
                return -1;
        }
    }

    private int _convert_skala (String text) {
        switch (text) {
            case "Ringan":
                return 0;
            case "Sedang":
                return 1;
            case "Berat":
                return 2;
            default:
                return -1;
        }
    }

    private int _convert_durasi(String durasi) {
        int range1 = 15;
        int range2 = 30;
        int range3 = 180*60*60;
        int range4 = 7*24*60*60;

        int durasinya = Integer.valueOf(durasi);
        if (durasinya >= range2 && durasinya <= range4) return 2;
        else return 0;
//        else if ()

    }



    private int _convert_usiaTua(String usiaTua) {
        int usia = Integer.valueOf(usiaTua);
        if (usia >= 50) return 1;
        else return 0;
    }

    /*public Orang(String nama, String demam, String defisit, String nkprogresif, String kejang, String fpencetus, String onset, String riwayat, String umur, String jk, String lokasi, String karakteristik, String skala
    , String durasi, String mhberair, String diagnosa)
*/
    public Orang() {
    }

    public int getDiagnosaPertama() {
        return diagnosaPertama;
    }

    public int getDiagnosaKedua() {
        return diagnosaKedua;
    }

    public int getMhBerair() {

        return mhBerair;
    }

    public int getDurasi() {

        return durasi;
    }

    public int getSkala() {

        return skala;
    }


    public int getKarakteristik() {

        return karakteristik;
    }

    public int getLokasi() {

        return lokasi;
    }

    public int getJk() {

        return jk;
    }

    public int getUsiatua() {

        return usiaTua;
    }

    public int getRiwayat() {

        return riwayat;
    }

    public int getMual() {
        return mual;
    }

    public int getOnsetMendadak() {

        return onsetMendadak;
    }

    public int getFpencetus() {

        return fpencetus;
    }

    public int getKejang() {

        return kejang;
    }

    public int getNkprogresif() {

        return nkprogresif;
    }

    public int getDefisit() {

        return defisit;
    }

    public int getDemam() {

        return demam;
    }

    public String getNama() {

        return nama;
    }

    public int getEdema() {
        return edema;
    }

    public void setEdema(String edema) {
        this.edema = _convert_yes_no (edema);
    }

    public void setDefisit(String defisit) {
        this.defisit = _convert_yes_no (defisit);
    }

    public void setNkprogresif(String nkprogresif) {
        this.nkprogresif = _convert_yes_no (nkprogresif);
    }

    public void setKejang(String kejang) {
        this.kejang = _convert_yes_no (kejang);
    }

    public void setFpencetus(String fpencetus) {
        this.fpencetus = _convert_yes_no (fpencetus);
    }

    public void setMual(int mual) {
        this.mual = mual;
    }

    public void setOnset(String onsetMendadak) {
        this.onsetMendadak = _convert_yes_no (onsetMendadak);
    }

    public void setRiwayat(String riwayat) {
        this.riwayat = _convert_yes_no (riwayat);
    }

    public void setUmur(String usiaTua) {
        this.usiaTua = _convert_yes_no (usiaTua);
    }

    public void setJk(String jk) {
        this.jk = _convert_jk(jk);
    }

    public void setLokasi(String lokasi) {
        this.lokasi = _convert_lokasi (lokasi);
    }

    public void setKarakteristik(String karakteristik) {
        this.karakteristik = _convert_karakteristik (karakteristik);
    }

    public void setSkala(String skala) {
        this.skala = _convert_skala (skala);
    }

    public void setDurasi(String durasi) {
        this.durasi = _convert_durasi (durasi);
    }

    public void setMhberair(String mhBerair) {
        this.mhBerair = _convert_yes_no (mhBerair);
    }

    public void setDiagnosaPertama(String diagnosaPertama) {
        this.diagnosaPertama = _convert_diagnosaPertama (diagnosaPertama);
    }

    public void setDiagnosaKedua(String diagnosaKedua) {
        this.diagnosaKedua = _convert_diagnosaKedua(diagnosaKedua);
    }

    public void setDemam(String demam) {

        this.demam = _convert_yes_no (demam);
    }

    public void setNama(String nama) {

        this.nama = nama;
    }
}

