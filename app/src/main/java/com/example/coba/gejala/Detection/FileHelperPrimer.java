package com.example.coba.gejala.Detection;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Owner on 07/05/2018.
 */

public class FileHelperPrimer {
    final static String fileName = "datalatihprimer.txt";
    final static String TAG = FileHelperPrimer.class.getName();

    private static String getValue(String [] pasien,int ke) {
        if(pasien.length -1<ke) return "";
        else if (pasien[ke]==null) return "";
        else return pasien[ke];
    }

    public static ArrayList<Pasien> ReadFile(Context context){
        String line = null;
        boolean pertama = false;
        ArrayList<Pasien> dataPrimer = new ArrayList<>();
        try {
            //FileInputStream fileInputStream = new FileInputStream (new File(path + fileName));
            InputStreamReader inputStreamReaders = new InputStreamReader(context.getAssets().open(fileName));
            BufferedReader bufferedReaders = new BufferedReader(inputStreamReaders);
//            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while ( (line = bufferedReaders.readLine()) != null )
            {
                if (!pertama) {
                    pertama = true; //menghilangkan baris pertama
                    System.out.println(pertama);
                }
                else {
                    String [] parts = line.split(";"); // menghilangkan ;
                    //Log.e("aaa","" + (++i) + " " + String.valueOf(parts.length));
                    String nama = getValue(parts,0);
                    String jk = getValue(parts,1);
                    String lokasi = getValue(parts,2);
                    String karakteristik = getValue(parts,3);
                    String skala = getValue(parts,4);
                    String durasi = getValue(parts,5);
                    String mhBerair = getValue(parts,6);
                    String diagnosaKedua = getValue(parts,7);

                    Pasien primer = new Pasien(nama, jk, lokasi, karakteristik, skala, durasi, mhBerair, diagnosaKedua);
                    dataPrimer.add(primer);

                }
//                    stringBuilder.append(line + System.getProperty("line.separator"));
            }



            inputStreamReaders.close();
//            line = stringBuilder.toString();

            bufferedReaders.close();
        }
        catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }
        catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return dataPrimer;

    }
}
