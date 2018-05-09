package com.example.coba.gejala.Detection;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.provider.FontsContract;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Owner on 19/03/2018.
 */

public class FileHelper {
    final static String fileName = "datalatihsekunder.txt";
    //final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/instinctcoder/readwrite/" ;
//    final static String path = "/data/data/com.example.coba/gejalas/" ;
    final static String TAG = FileHelper.class.getName();

//    public class datas {
//        int jumlah;
//        String jenis_diagnosa;
//
//        public datas(int jumlah, String jenis_diagnosa) {
//            this.jumlah = jumlah;
//            this.jenis_diagnosa = jenis_diagnosa;
//        }
//
//        public int getJumlah() {
//            return jumlah;
//        }
//
//        public String getJenis_Diagnosa() {
//            return jenis_diagnosa;
//        }
//
//        public void setJumlah(int jumlah) {
//            this.jumlah = jumlah;
//        }
//
//        public void setJenis_Diagnosa(String jenis_diagnosa) {
//            this.jenis_diagnosa = jenis_diagnosa;
//        }
//    }
//
//    public ArrayList<datas> tes(ArrayList<Orang> data) {
//        ArrayList<datas> asd = new ArrayList<>();
//        for(int i=0;i<data.size();i++) {
//            if(asd.size() == 0) {
//                datas temp = new datas(1,data.get(i).getDiagnosa());
//                asd.add(temp);
//            }
//            else if (asd.get(asd.size()-1).getJenis_Diagnosa().equals(data.get(i).getDiagnosa())) {
//                asd.get(asd.size()-1).setJumlah(asd.get(asd.size()-1).getJumlah()+1);
//            }
//            else {
//                datas temp = new datas(1,data.get(i).getDiagnosa());
//                asd.add(temp);
//            }
//        }
//        return asd;
//    }
//
//    public ArrayList<datas> tesa(ArrayList<Orang> data) {
//        ArrayList<datas> asd = new ArrayList<>();
//        String last_name = data.get(0).getDiagnosa();
//        int last_count = 1;
//        for(int i=1;i<data.size();i++) {
//            if (last_name.equals(data.get(i).getDiagnosa())) last_count++;
//            else {
//                datas temp = new datas(last_count,last_name);
//                asd.add(temp);
//
//                last_name = data.get(i).getDiagnosa();
//                last_count = 1;
//            }
//        }
//        datas temp = new datas(last_count,last_name);
//        asd.add(temp);
//        return asd;
//    }
//
//    public static void dsa(ArrayList<Orang> data) {
//        ArrayList<datas> data_diagnosa = tesa(data);
//        ArrayList<datas> data_diagnosi = tes(data);
//
//        int n = 0;
//        if (n < data_diagnosa.size()) n = data_diagnosa.size();
//        if (n < data_diagnosi.size()) n = data_diagnosi.size();
//
//        int a[][];
//        for(int i=0;i<n;i++) {
//            if(data_diagnosa.size() < i) {
//                a[i][0] = 0;
//            }
//            else {
//                a[i][0] = data_diagnosa.get(i).getJumlah();
//            }
//            a[i][1] = data_diagnosi.get(i).getJumlah();
//        }
//    }

//    if (int c = 11) {

//    }
    private static String getValue(String [] pasien,int ke) {
        if(pasien.length -1<ke) return "";
        else if (pasien[ke]==null) return "";
        else return pasien[ke];
    }
    
    public static ArrayList<Orang> ReadFile(Context context){
//    String ReadFile (Context context) {
//
        String line = null;
        boolean pertama = false;
        ArrayList<Orang> data = new ArrayList<>(); //memanggil data array di kelas Orang

        try {
            //FileInputStream fileInputStream = new FileInputStream (new File(path + fileName));
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(fileName));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                while ( (line = bufferedReader.readLine()) != null )
                {
                    if (!pertama) {
                        pertama = true; //menghilangkan baris pertama
//                        System.out.println(pertama);
                    }
                    else {
                        String [] parts = line.split(";"); // menghilangkan ;
                        Log.e("aaa","" + (++i) + " " + String.valueOf(parts.length));
                        String nama = getValue(parts,0);
                        String demam = getValue(parts,1);
////                        int nilai_demam = Integer.parseInt(demam);
////                        //selain demam nilainya -1
////                        if (demam.equals(Constant.YA)) nilai_demam = 1;
////                        else if (demam.equals(Constant.TIDAK)) nilai_demam = 0;
////                    int demam_ya = demam.equals("T") ? 0 : 1; // jika tidak demam = 0, inisiasi awal demam ya = 1
//
                        String defisit = getValue(parts,2);
////                        int lain_defisit = Integer.parseInt(defisit);
////                        if (defisit.equals(Constant.YA)) lain_defisit = 1;
////                        else if (defisit.equals(Constant.TIDAK)) lain_defisit = 0;
////                    int defisit_ya = defisit.equals("T") ? 0 : 1;
//
                        String nkprogresif = getValue(parts,3);
////                        int nilai_nkprogresif = Integer.parseInt(nkprogresif);
////                        if (nkprogresif.equals(Constant.YA)) nilai_nkprogresif = 1;
////                        else if (nkprogresif.equals(Constant.TIDAK)) nilai_nkprogresif = 0;
////                    int nkprogresif_ya = nkprogresif.equals("T") ? 0 : 1;
//
                        String kejang = getValue(parts,4);
////                        int nilai_kejang = Integer.parseInt(kejang);
////                        if (kejang.equals(Constant.YA)) nilai_kejang = 1;
////                        else if (kejang.equals(Constant.TIDAK)) nilai_kejang = 0;
////                    int kejang_ya = kejang.equals("T") ? 0 : 1;
//
                        String edema = getValue(parts,5);
////                        int nilai_edema = Integer.parseInt(edema);
////                        if (edema.equals(Constant.YA)) nilai_edema = 1;
////                        else if (edema.equals(Constant.TIDAK)) nilai_edema = 0;
////                    int fpencetus_ya = fpencetus.equals("T") ? 0 : 1;
//
                        String fpencetus = getValue(parts,6);
////                    int onset_nadak = onset.equals("T") ? 0 : 1;
////                        int nilai_fpencetus = Integer.parseInt(fpencetus);
////                        if (fpencetus.equals(Constant.YA)) nilai_fpencetus = 1;
////                        else if (fpencetus.equals(Constant.TIDAK)) nilai_fpencetus = 0;
//
                        String onsetMendadak = getValue(parts,7);
////                    int riwayat_ya = riwayat.equals("T") ? 0 : 1;
////                        int nilai_onset = Integer.parseInt(onsetMendadak);
////                        if (onsetendadak.equals(Constant.YA)) nilai_onset = 1;
////                        else if (onset_mendadak.equals(Constant.TIDAK)) nilai_onset = 0;
//
                        String riwayat = getValue(parts,8);
////                    int umur_ya = umur.equals("T") ? 0 : 1;
////                        int nilai_riwayat = Integer.parseInt(riwayat);
////                        if (riwayat.equals(Constant.YA)) nilai_riwayat = 1;
////                        else if (riwayat.equals(Constant.TIDAK)) nilai_riwayat = 0;
//
                        String mual = getValue(parts,9);
////                        int nilai_mual = Integer.parseInt(mual);
////                        if (mual.equals(Constant.YA)) nilai_mual = 1;
////                        else if (mual.equals(Constant.TIDAK)) nilai_mual = 0;
//
                        String usiaTua = getValue(parts,10);
////                        int nilai_usia = -1;
////                        if (usiatua.equals(Constant.YA)) nilai_usia = 1;
////                        else if (usiatua.equals(Constant.TIDAK)) nilai_usia = 0;
//
//                        String jk = getValue(parts,11);
////                        int jenis_jk = Integer.parseInt(jk);
////                        if (jk.equals(Constant.JK_PEREMPUAN)) jenis_jk = 0;
////                        else if (jk.equals(Constant.JK_LAKI)) jenis_jk = 1;
////                    int jk_i = jk.equals("Perempuan") ? 0 : 1;
////                    int jk_laki = -1;
////                    if (jk.equals("P")) jk_laki = 0;
////                    else jk_laki = 1;
//
//                        String lokasi = getValue(parts,12);
////                        int lokasinya = Integer.parseInt(lokasi) ;
////                        if (lokasi.equals(Constant.LOKASI_UNILATERAL)) lokasinya = 0;
////                        else if (lokasi.equals(Constant.LOKASI_BILATERAL)) lokasinya= 1;
////                        else lokasinya = -1;
//
//                        String karakteristik = getValue(parts,13);
////                        int nilai_karakter = Integer.parseInt(karakteristik);
////                        if (karakteristik.equals(Constant.KARAKTERISTIK_BERDENYUT)) nilai_karakter = 0;
////                        else if (karakteristik.equals(Constant.KARAKTERISTIK_TEKAN)) nilai_karakter = 1;
////                        else if (karakteristik.equals(Constant.KARAKTERISTIK_DIBOR)) nilai_karakter = 2;
//
//                        String skala = getValue(parts,14);
////                        int skalanya = Integer.parseInt(skala);
////                        if (skala.equals(Constant.SKALA_RINGAN)) skalanya = 0;
////                        else if (skala.equals(Constant.SKALA_SEDANG)) skalanya = 1;
////                        else if (skala.equals(Constant.SKALA_BERAT)) skalanya = 2;
//                        String durasi = getValue(parts,15);
//
//                        String mhBerair = getValue(parts,16);
////                        int nilai_mhberair = Integer.parseInt(mhberair);
////                        if (mhberair.equals(Constant.YA)) nilai_mhberair = 1;
////                        else if (mhberair.equals(Constant.TIDAK)) nilai_mhberair = 0;
//
                        String diagnosaPertama = getValue(parts,11);
////                        int diagnosanya = Integer.parseInt(diagnosa);
////                        if (diagnosa.equals(Constant.PRIMER)) diagnosanya = 0;
////                        else if (diagnosa.equals(Constant.SEKUNDER)) diagnosanya = 1;
//
//                        String diagnosaKedua = getValue(parts,18);

                        Orang tipe = new Orang(nama, demam, defisit, nkprogresif, kejang, edema, fpencetus, onsetMendadak, riwayat, mual, usiaTua, diagnosaPertama);
                        data.add(tipe);
                        //System.out.println(tipe);
                    }
//                    stringBuilder.append(line + System.getProperty("line.separator"));
            }



            inputStreamReader.close();
//            line = stringBuilder.toString();

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }
        catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return data;
    }
}
