package com.example.coba.gejala.Detection;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Owner on 29/04/2018.
 */

public class Compute {
    public double priorPrimer;
    public double priorSekunder;

    public double likelihoodDemamPrimer_Ya;
    public double likelihoodDefisitPrimer_Ya;
    public double likelihoodKejangPrimer_Ya;
    public double likelihoodNkprogresifPrimer_Ya;
    public double likelihoodOnsetMendadakPrimer_Ya;
    public double likelihoodFpencetusPrimer_Ya;
    public double likelihoodEdemaPrimer_Ya;
    public double likelihoodRiwayatPrimer_Ya;
    public double likelihoodUsiaTuaPrimer_Ya;
    public double likelihoodMualPrimer_Ya;
    public double likelihoodMhBerairPrimer_Ya;
    public double likelihoodJkPrimer_Laki;
    public double likelihoodDemamPrimer_Tidak;
    public double likelihoodDefisitPrimer_Tidak;
    public double likelihoodKejangPrimer_Tidak;
    public double likelihoodNkprogresifPrimer_Tidak;
    public double likelihoodOnsetMendadakPrimer_Tidak;
    public double likelihoodFpencetusPrimer_Tidak;
    public double likelihoodEdemaPrimer_Tidak;
    public double likelihoodRiwayatPrimer_Tidak;
    public double likelihoodUsiaTuaPrimer_Tidak;
    public double likelihoodMualPrimer_Tidak;
    public double likelihoodMhBerairPrimer_Tidak;
    public double likelihoodJkPrimer_Perempuan;

    public double likelihoodDemamSekunder_Ya;
    public double likelihoodDefisitSekunder_Ya;
    public double likelihoodKejangSekunder_Ya;
    public double likelihoodNkprogresifSekunder_Ya;
    public double likelihoodOnsetMendadakSekunder_Ya;
    public double likelihoodFpencetusSekunder_Ya;
    public double likelihoodEdemaSekunder_Ya;
    public double likelihoodRiwayatSekunder_Ya;
    public double likelihoodUsiaTuaSekunder_Ya;
    public double likelihoodMualSekunder_Ya;
    public double likelihoodMhBerairSekunder_Ya;
    public double likelihoodJkSekunder_Laki;
    public double likelihoodDemamSekunder_Tidak;
    public double likelihoodDefisitSekunder_Tidak;
    public double likelihoodKejangSekunder_Tidak;
    public double likelihoodNkprogresifSekunder_Tidak;
    public double likelihoodOnsetMendadakSekunder_Tidak;
    public double likelihoodFpencetusSekunder_Tidak;
    public double likelihoodEdemaSekunder_Tidak;
    public double likelihoodRiwayatSekunder_Tidak;
    public double likelihoodUsiaTuaSekunder_Tidak;
    public double likelihoodMualSekunder_Tidak;
    public double likelihoodMhBerairSekunder_Tidak;
    public double likelihoodJkSekunder_Perempuan;

    private Context context;

    public Compute(Context context) {
        this.context = context;
    }

    public void compute() {
        ArrayList<Orang> data = FileHelper.ReadFile(context);
        Log.e("file",data.toString());

        double jumPrimer = 0.0,
                demamPrimer_Ya = 0.0,
                defisitPrimer_Ya = 0.0,
                kejangPrimer_Ya = 0.0,
                nkprogresifPrimer_Ya = 0.0,
                onsetMendadakPrimer_Ya = 0.0,
                edemaPrimer_Ya = 0.0,
                riwayatPrimer_Ya = 0.0,
                fpencetusPrimer_Ya = 0.0,
                usiaTuaPrimer_Ya = 0.0,
                jkPrimer_Laki = 0.0,
                mhBerairPrimer_Ya = 0.0,
                mualPrimer_Ya = 0.0,
                demamPrimer_Tidak = 0.0,
                defisitPrimer_Tidak = 0.0,
                kejangPrimer_Tidak = 0.0,
                nkprogresifPrimer_Tidak = 0.0,
                onsetMendadakPrimer_Tidak = 0.0,
                edemaPrimer_Tidak = 0.0,
                riwayatPrimer_Tidak = 0.0,
                fpencetusPrimer_Tidak = 0.0,
                usiaTuaPrimer_Tidak = 0.0,
                jkPrimer_Perempuan = 0.0,
                mhBerairPrimer_Tidak = 0.0,
                mualPrimer_Tidak = 0.0;

        for (int i=0;i<data.size();i++) {
            if (data.get(i).getDiagnosaPertama() == 0) {
                jumPrimer++;
            }
            if (data.get(i).getDemam() == 1 && data.get(i).getDiagnosaPertama() == 0) {
                demamPrimer_Ya++;
            }
            if (data.get(i).getDefisit() == 1 && data.get(i).getDiagnosaPertama() == 0){
                defisitPrimer_Ya++;
            }
            if (data.get(i).getKejang() == 1 && data.get(i).getDiagnosaPertama() == 0){
                kejangPrimer_Ya++;
            }
            if (data.get(i).getNkprogresif() == 1 && data.get(i).getDiagnosaPertama() == 0){
                nkprogresifPrimer_Ya++;
            }
            if (data.get(i).getOnsetMendadak() == 1 && data.get(i).getDiagnosaPertama() == 0){
                onsetMendadakPrimer_Ya++;
            }
            if (data.get(i).getEdema() == 1 && data.get(i).getDiagnosaPertama() == 0){
                edemaPrimer_Ya++;
            }
            if (data.get(i).getRiwayat() == 1 && data.get(i).getDiagnosaPertama() == 0){
                riwayatPrimer_Ya++;
            }
            if (data.get(i).getFpencetus() == 1 && data.get(i).getDiagnosaPertama() == 0){
                fpencetusPrimer_Ya++;
            }
            if (data.get(i).getUsiatua() == 1 && data.get(i).getDiagnosaPertama() == 0){
                usiaTuaPrimer_Ya++;
            }
            if (data.get(i).getJk() == 1 && data.get(i).getDiagnosaPertama() == 0){
                jkPrimer_Laki++;
            }
            if (data.get(i).getMhBerair() == 1 && data.get(i).getDiagnosaPertama() == 0){
                mhBerairPrimer_Ya++;
            }
            if (data.get(i).getMual() == 1 && data.get(i).getDiagnosaPertama() == 0){
                mualPrimer_Ya++;
            }
            if (data.get(i).getDemam() == 0 && data.get(i).getDiagnosaPertama() == 0) {
                demamPrimer_Tidak++;
            }
            if (data.get(i).getDefisit() == 0 && data.get(i).getDiagnosaPertama() == 0){
                defisitPrimer_Tidak++;
            }
            if (data.get(i).getKejang() == 0 && data.get(i).getDiagnosaPertama() == 0){
                kejangPrimer_Tidak++;
            }
            if (data.get(i).getNkprogresif() == 0 && data.get(i).getDiagnosaPertama() == 0){
                nkprogresifPrimer_Tidak++;
            }
            if (data.get(i).getOnsetMendadak() == 0 && data.get(i).getDiagnosaPertama() == 0){
                onsetMendadakPrimer_Tidak++;
            }
            if (data.get(i).getEdema() == 0 && data.get(i).getDiagnosaPertama() == 0){
                edemaPrimer_Tidak++;
            }
            if (data.get(i).getRiwayat() == 0 && data.get(i).getDiagnosaPertama() == 0){
                riwayatPrimer_Tidak++;
            }
            if (data.get(i).getFpencetus() == 0 && data.get(i).getDiagnosaPertama() == 0){
                fpencetusPrimer_Tidak++;
            }
            if (data.get(i).getUsiatua() == 0 && data.get(i).getDiagnosaPertama() == 0){
                usiaTuaPrimer_Tidak++;
            }
            if (data.get(i).getJk() == 0 && data.get(i).getDiagnosaPertama() == 0){
                jkPrimer_Perempuan++;
            }
            if (data.get(i).getMhBerair() == 0 && data.get(i).getDiagnosaPertama() == 0){
                mhBerairPrimer_Tidak++;
            }
            if (data.get(i).getMual() == 0 && data.get(i).getDiagnosaPertama() == 0){
                mualPrimer_Tidak++;
            }
        }
        priorPrimer = jumPrimer/160.0;
        likelihoodDemamPrimer_Ya = demamPrimer_Ya/jumPrimer;
        likelihoodDefisitPrimer_Ya = defisitPrimer_Ya/jumPrimer;
        likelihoodNkprogresifPrimer_Ya = nkprogresifPrimer_Ya/jumPrimer;
        likelihoodKejangPrimer_Ya = kejangPrimer_Ya/jumPrimer;
        likelihoodOnsetMendadakPrimer_Ya = onsetMendadakPrimer_Ya/jumPrimer;
        likelihoodEdemaPrimer_Ya = edemaPrimer_Ya/jumPrimer;
        likelihoodRiwayatPrimer_Ya = riwayatPrimer_Ya/jumPrimer;
        likelihoodFpencetusPrimer_Ya = fpencetusPrimer_Ya/jumPrimer;
        likelihoodUsiaTuaPrimer_Ya = usiaTuaPrimer_Ya/jumPrimer;
        likelihoodJkPrimer_Laki = jkPrimer_Laki/jumPrimer;
        likelihoodMhBerairPrimer_Ya = mhBerairPrimer_Ya/jumPrimer;
        likelihoodMualPrimer_Ya =  mualPrimer_Ya/jumPrimer;

        likelihoodDemamPrimer_Tidak = demamPrimer_Tidak/jumPrimer;
        likelihoodDefisitPrimer_Tidak = defisitPrimer_Tidak/jumPrimer;
        likelihoodNkprogresifPrimer_Tidak = nkprogresifPrimer_Tidak/jumPrimer;
        likelihoodKejangPrimer_Tidak = kejangPrimer_Tidak/jumPrimer;
        likelihoodOnsetMendadakPrimer_Tidak = onsetMendadakPrimer_Tidak/jumPrimer;
        likelihoodEdemaPrimer_Tidak = edemaPrimer_Tidak/jumPrimer;
        likelihoodRiwayatPrimer_Tidak = riwayatPrimer_Tidak/jumPrimer;
        likelihoodFpencetusPrimer_Tidak = fpencetusPrimer_Tidak/jumPrimer;
        likelihoodUsiaTuaPrimer_Tidak = usiaTuaPrimer_Tidak/jumPrimer;
        likelihoodJkPrimer_Perempuan = jkPrimer_Perempuan/jumPrimer;
        likelihoodMhBerairPrimer_Tidak = mhBerairPrimer_Tidak/jumPrimer;
        likelihoodMualPrimer_Tidak = mualPrimer_Tidak/jumPrimer;



        double jumSekunder = 0.0,
                demamSekunder_Ya = 0.0,
                defisitSekunder_Ya = 0.0,
                kejangSekunder_Ya = 0.0,
                nkprogresifSekunder_Ya = 0.0,
                onsetMendadakSekunder_Ya = 0.0,
                edemaSekunder_Ya = 0.0,
                riwayatSekunder_Ya = 0.0,
                fpencetusSekunder_Ya = 0.0,
                usiaTuaSekunder_Ya = 0.0,
                jkSekunder_Laki = 0.0,
                mhBerairSekunder_Ya = 0.0,
                mualSekunder_Ya = 0.0,
                demamSekunder_Tidak = 0.0,
                defisitSekunder_Tidak = 0.0,
                kejangSekunder_Tidak = 0.0,
                nkprogresifSekunder_Tidak = 0.0,
                onsetMendadakSekunder_Tidak = 0.0,
                edemaSekunder_Tidak = 0.0,
                riwayatSekunder_Tidak = 0.0,
                fpencetusSekunder_Tidak = 0.0,
                usiaTuaSekunder_Tidak = 0.0,
                jkSekunder_Perempuan = 0.0,
                mhBerairSekunder_Tidak = 0.0,
                mualSekunder_Tidak = 0.0;
        for (int i=0;i<data.size();i++) {
            if (data.get(i).getDiagnosaPertama() == 1) {
                jumSekunder++;

            }
            if (data.get(i).getDemam() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                demamSekunder_Ya++;
            }
            if (data.get(i).getDefisit() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                defisitSekunder_Ya++;
            }
            if (data.get(i).getKejang() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                kejangSekunder_Ya++;
            }
            if (data.get(i).getNkprogresif() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                nkprogresifSekunder_Ya++;
            }
            if (data.get(i).getOnsetMendadak() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                onsetMendadakSekunder_Ya++;
            }
            if (data.get(i).getEdema() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                edemaSekunder_Ya++;
            }
            if (data.get(i).getRiwayat() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                riwayatSekunder_Ya++;
            }
            if (data.get(i).getFpencetus() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                fpencetusSekunder_Ya++;
            }
            if (data.get(i).getUsiatua() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                usiaTuaSekunder_Ya++;
            }
            if (data.get(i).getJk() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                jkSekunder_Laki++;
            }
            if (data.get(i).getMhBerair() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                mhBerairSekunder_Ya++;
            }
            if (data.get(i).getMual() == 1 && data.get(i).getDiagnosaPertama() == 1) {
                mualSekunder_Ya++;
            }

            if (data.get(i).getDemam() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                demamSekunder_Tidak++;
            }
            if (data.get(i).getDefisit() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                defisitSekunder_Tidak++;
            }
            if (data.get(i).getKejang() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                kejangSekunder_Tidak++;
            }
            if (data.get(i).getNkprogresif() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                nkprogresifSekunder_Tidak++;
            }
            if (data.get(i).getOnsetMendadak() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                onsetMendadakSekunder_Tidak++;
            }
            if (data.get(i).getEdema() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                edemaSekunder_Tidak++;
            }
            if (data.get(i).getRiwayat() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                riwayatSekunder_Tidak++;
            }
            if (data.get(i).getFpencetus() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                fpencetusSekunder_Tidak++;
            }
            if (data.get(i).getUsiatua() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                usiaTuaSekunder_Tidak++;
            }
            if (data.get(i).getJk() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                jkSekunder_Perempuan++;
            }
            if (data.get(i).getMhBerair() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                mhBerairSekunder_Tidak++;
            }
            if (data.get(i).getMual() == 0 && data.get(i).getDiagnosaPertama() == 1) {
                mualSekunder_Tidak++;
            }
        }
        priorSekunder = jumSekunder/160.0;
        likelihoodDemamSekunder_Ya = demamSekunder_Ya/jumSekunder;
        likelihoodDefisitSekunder_Ya = defisitSekunder_Ya/jumSekunder;
        likelihoodNkprogresifSekunder_Ya = nkprogresifSekunder_Ya/jumSekunder;
        likelihoodKejangSekunder_Ya = kejangSekunder_Ya/jumSekunder;
        likelihoodEdemaSekunder_Ya = edemaSekunder_Ya/jumSekunder;
        likelihoodOnsetMendadakSekunder_Ya = onsetMendadakSekunder_Ya/jumSekunder;
        likelihoodRiwayatSekunder_Ya = riwayatSekunder_Ya/jumSekunder;
        likelihoodFpencetusSekunder_Ya = fpencetusSekunder_Ya/jumSekunder;
        likelihoodUsiaTuaSekunder_Ya = usiaTuaSekunder_Ya/jumSekunder;
        likelihoodJkSekunder_Laki = jkSekunder_Laki/jumSekunder;
        likelihoodMhBerairSekunder_Ya = mhBerairSekunder_Ya/jumSekunder;
        likelihoodMualSekunder_Ya = mualSekunder_Ya/jumSekunder;

        likelihoodDemamSekunder_Tidak = demamSekunder_Tidak/jumSekunder;
        likelihoodDefisitSekunder_Tidak = defisitSekunder_Tidak/jumSekunder;
        likelihoodNkprogresifSekunder_Tidak = nkprogresifSekunder_Tidak/jumSekunder;
        likelihoodKejangSekunder_Tidak = kejangSekunder_Tidak/jumSekunder;
        likelihoodEdemaSekunder_Tidak = edemaSekunder_Tidak/jumSekunder;
        likelihoodOnsetMendadakSekunder_Tidak = onsetMendadakSekunder_Tidak/jumSekunder;
        likelihoodRiwayatSekunder_Tidak = riwayatSekunder_Tidak/jumSekunder;
        likelihoodFpencetusSekunder_Tidak = fpencetusSekunder_Tidak/jumSekunder;
        likelihoodUsiaTuaSekunder_Tidak = usiaTuaSekunder_Tidak/jumSekunder;
        likelihoodJkSekunder_Perempuan = jkSekunder_Perempuan/jumSekunder;
        likelihoodMhBerairSekunder_Tidak = mhBerairSekunder_Tidak/jumSekunder;
        likelihoodMualSekunder_Tidak = mualSekunder_Tidak/jumSekunder;



    }
}
