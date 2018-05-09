package com.example.coba.gejala.Detection;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.coba.gejala.R;

import java.util.ArrayList;

public class ComputeKedua {
    public double priorTTH;
    public double priorMigren;
    public double priorKlaster;

    public double likelihoodJkTTH_Laki;
    public double likelihoodJkMigren_Laki;
    public double likelihoodJkKlaster_Laki;
    public double likelihoodLokasiTTH_Unilateral;
    public double likelihoodLokasiMigren_Unilateral;
    public double likelihoodLokasiKlaster_Unilateral;
    public double likelihoodLokasiTTH_Bilateral;
    public double likelihoodLokasiMigren_Bilateral;
    public double likelihoodLokasiKlaster_Bilateral;
    public double likelihoodKarakteristikTTH_Berdenyut;
    public double likelihoodKarakteristikMigren_Berdenyut;
    public double likelihoodKarakteristikKlaster_Berdenyut;
    public double likelihoodKarakteristikTTH_Dibor;
    public double likelihoodKarakteristikMigren_Dibor;
    public double likelihoodKarakteristikKlaster_Dibor;
    public double likelihoodKarakteristikTTH_Tekan;
    public double likelihoodKarakteristikMigren_Tekan;
    public double likelihoodKarakteristikKlaster_Tekan;
    public double likelihoodSkalaTTH_Ringan;
    public double likelihoodSkalaMigren_Ringan;
    public double likelihoodSkalaTTH_Sedang;
    public double likelihoodSkalaMigren_Sedang;
    public double likelihoodSkalaKlaster_Sedang;
    public double likelihoodSkalaTTH_Berat;
    public double likelihoodSkalaMigren_Berat;
    public double likelihoodSkalaKlaster_Berat;
    public double likelihoodDurasiTTH_Pendek;
    public double likelihoodDurasiMigren_Pendek;
    public double likelihoodDurasiKlaster_Pendek;
    public double likelihoodDurasiTTH_Penjang;
    public double likelihoodDurasiMigren_Panjang;
    public double likelihoodDurasiKlaster_Panjang;
    public double likelihoodMhBerairTTH_Ya;
    public double likelihoodMhBerairMigren_Ya;
    public double likelihoodMhBerairKlaster_Ya;
    public double likelihoodMhBerairTTH_Tidak;
    public double likelihoodMhBerairMigren_Tidak;
    public double likelihoodMhBerairKlaster_Tidak;

    private Context context;

    public ComputeKedua(Context context) {
        this.context = context;
    }

    public void compute() {
        ArrayList<Pasien> dataPrimer = FileHelperPrimer.ReadFile(context);
        Log.e("file", dataPrimer.toString());

        double jumTTH = 0.0,
                jumMigren = 0.0,
                jumKlaster = 0.0,
                lokasiTTH_Unilateral = 0.0,
                lokasiMigren_Unilateral = 0.0,
                lokasiKlaster_Unilateral = 0.0,
                lokasiTTH_Bilateral = 0.0,
                lokasiMigren_Bilateral = 0.0,
                lokasiKlaster_Bilateral = 0.0,
                karakteristikTTH_Berdenyut = 0.0,
                karakteristikMigren_Berdenyut = 0.0,
                karakteristikKlaster_Berdenyut = 0.0,
                karakteristikTTH_Dibor = 0.0,
                karaktersitikMigren_Dibor = 0.0,
                karakteristikKlaster_Dibor = 0.0,
                karakteristikTTH_Tekan = 0.0,
                karakteristikMigren_Tekan = 0.0,
                karaktersitikKlater_Tekan = 0.0,
                skalaTTH_Ringan = 0.0,
                skalaMigren_Ringan = 0.0,
                skalaKlaster_Ringan = 0.0,
                skalaTTH_Sedang = 0.0,
                skalaMigren_Sedang = 0.0,
                skalaKlaster_Sedang = 0.0,
                skalaTTH_Berat = 0.0,
                skalaMigren_Berat = 0.0,
                skalaKlaster_Berat = 0.0,
                mhBerairTTH_Ya = 0.0,
                mhBerairMigren_Ya = 0.0,
                mhBerairKlaster_Ya = 0.0,
                mhBerairTTH_Tidak = 0.0,
                mhBerairMigren_Tidak = 0.0,
                mhBerairKlaster_Tidak = 0.0,
                durasiTTH_Pendek = 0.0,
                durasiMigren_Pendek = 0.0,
                durasiKlaster_Pendek = 0.0,
                durasiTTH_Panjang = 0.0,
                durasiMigren_Panjang = 0.0,
                durasiKlaster_Panjang = 0.0;

        for (int i=0;i<dataPrimer.size();i++) {
            if (dataPrimer.get(i).getDiagnosaKedua() == 2) {
                jumTTH++;
            }
            if (dataPrimer.get(i).getLokasi() == 0 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                lokasiTTH_Unilateral++;
            }
            if (dataPrimer.get(i).getLokasi() == 1 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                lokasiTTH_Bilateral++;
            }
            if (dataPrimer.get(i).getKarakteristik() == 0 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                karakteristikTTH_Berdenyut++;
            }
            if (dataPrimer.get(i).getKarakteristik() == 1 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                karakteristikTTH_Dibor++;
            }
            if (dataPrimer.get(i).getKarakteristik() == 2 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                karakteristikTTH_Tekan++;
            }
            if (dataPrimer.get(i).getSkala() == 0 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                skalaKlaster_Ringan++;
            }
            if (dataPrimer.get(i).getSkala() == 1 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                skalaKlaster_Sedang++;
            }
            if (dataPrimer.get(i).getSkala() == 2 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                skalaKlaster_Berat++;
            }
            if (dataPrimer.get(i).getSkala() == 0 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                mhBerairTTH_Ya++;
            }
            if (dataPrimer.get(i).getSkala() == 0 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                mhBerairTTH_Tidak++;
            }
            if (dataPrimer.get(i).getDurasi() == 0 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                durasiTTH_Pendek++;
            }
            if (dataPrimer.get(i).getDurasi() == 1 && dataPrimer.get(i).getDiagnosaKedua() == 2) {
                durasiTTH_Panjang++;
            }
            priorTTH = jumTTH / 80.0;
            likelihoodLokasiTTH_Unilateral = lokasiTTH_Unilateral / jumTTH;
            likelihoodLokasiTTH_Bilateral = lokasiTTH_Bilateral / jumTTH;
            likelihoodKarakteristikTTH_Berdenyut = karakteristikTTH_Berdenyut / jumTTH;
            likelihoodKarakteristikTTH_Dibor = karakteristikTTH_Dibor / jumTTH;
            likelihoodKarakteristikTTH_Tekan = karakteristikTTH_Tekan / jumTTH;
            likelihoodSkalaTTH_Ringan = skalaTTH_Ringan / jumTTH;
            likelihoodSkalaTTH_Sedang = skalaTTH_Sedang / jumTTH;
            likelihoodSkalaTTH_Berat = skalaTTH_Berat / jumTTH;
            likelihoodMhBerairTTH_Ya = mhBerairTTH_Ya / jumTTH;
            likelihoodMhBerairTTH_Tidak = mhBerairTTH_Tidak / jumTTH;
            likelihoodDurasiTTH_Pendek = durasiTTH_Pendek / jumTTH;
            likelihoodDurasiTTH_Penjang = durasiTTH_Panjang / jumTTH;
        }
    }
}
