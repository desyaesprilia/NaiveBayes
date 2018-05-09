package com.example.coba.gejala.Detection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coba.gejala.R;

public class Deteksi extends AppCompatActivity {
    private Button btnReadFile, buttonDeteksi;
    private EditText text_demam;
    private RadioGroup rgDemam, rgDefisit, rgNkprogresif, rgKejang, rgOnsetMendadak, rgEdema, rgRiwayat, rgFpencetus, rgJk, rgUsia, rgMhberair, rgMual;
    private RadioButton rbDemam, rbDefisit, rbNkprogresif, rbKejang, rbOnsetMendadak, rbEdema, rbRiwayat, rbFpencetus, rbJk, rbUsia, rbMhberair, rbMual;
    private TextView tvHasilDeteksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);


        //find radiogroup demam by id
        rgDemam = (RadioGroup) findViewById(R.id.RG_demam);
        rgDefisit = (RadioGroup) findViewById(R.id.RG_defisit);
        rgKejang = (RadioGroup) findViewById(R.id.RG_kejang);
        rgNkprogresif = (RadioGroup) findViewById(R.id.RG_nkprogresif);
        rgEdema = (RadioGroup) findViewById(R.id.RG_edema);
        rgOnsetMendadak = (RadioGroup) findViewById(R.id.RG_Onset);
        rgFpencetus = (RadioGroup) findViewById(R.id.RG_fpencetus);
        rgRiwayat = (RadioGroup) findViewById(R.id.RG_riwayat);
        rgJk = (RadioGroup) findViewById(R.id.RG_jk);
        rgUsia = (RadioGroup) findViewById(R.id.RG_usia);
        rgMual = (RadioGroup) findViewById(R.id.RG_mual);
        tvHasilDeteksi = (TextView) findViewById(R.id.tv_hasilsekunder);
        buttonDeteksi = (Button) findViewById(R.id.btn_hasilSekunder);

        AddlistennerOnButtonDeteksi();

    }

    private class temporary {
        double primer;
        double sekunder;

        public temporary(double primer, double sekunder) {
            this.primer = primer;
            this.sekunder = sekunder;
        }

        public temporary() {
            this.primer = 0;
            this.sekunder = 0;
        }

        public double getPrimer() {
            return primer;
        }

        public double getSekunder() {
            return sekunder;
        }
    }

    private temporary primer_sekunder(RadioGroup radioGroup,int button_ya,int button_tidak,double primer_ya,double primer_tidak,double sekunder_ya,double sekunder_tidak,String message) {
        int checked = radioGroup.getCheckedRadioButtonId();
        if (checked == button_ya){
            return new temporary(primer_ya,sekunder_ya);
        }
        else if(checked == button_tidak){
            return new temporary(primer_tidak,sekunder_tidak);
        }
        else {
            Toast.makeText(Deteksi.this, message, Toast.LENGTH_SHORT).show();
            return new temporary();
        }
    }
//    temporary demam = primer_sekunder(
//            rgDemam,
//            R.id.RB_demam_ya,
//            R.id.RB_demam_tidak,
//            hitung.likelihoodDemamPrimer_Ya,
//            hitung.likelihoodDemamPrimer_Tidak,
//            hitung.likelihoodDemamSekunder_Ya,
//            hitung.likelihoodDemamSekunder_Tidak,
//            "demam tidak diisi");
//    demamPrimer = demam.getPrimer();
//    demamSekunder = demam.getSekunder();
    public void AddlistennerOnButtonDeteksi() {
        buttonDeteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDemamChecked = false;
                boolean isDefisitChecked = false;
                boolean isKejangChecked = false;
                boolean isNkprogresifChecked = false;
                boolean isEdemaChecked = false;
                boolean isOnsetMendadakChecked = false;
                boolean isJkLakiChecked = false;
                boolean isUsiaTuaChecked = false;
                boolean isRiwayatChecked = false;
                boolean isFpencetusChecked = false;
                boolean isMualChecked = false;
                double demamPrimer = 0,
                        demamSekunder = 0,
                        kejangPrimer,
                        kejangSekunder,
                        nkprogresifPrimer,
                        nkprogresifSekunder,
                        edemaPrimer,
                        edemaSekunder,
                        onsetMendadakPrimer,
                        onsetMendadakSekunder,
                        riwayatPrimer,
                        riwayatSekunder,
                        fpencetusPrimer,
                        fpencetusSekunder,
                        defisitPrimer,
                        defisitSekunder,
                        jkPrimer,
                        jkSekunder,
                        usiaTuaPrimer,
                        usiaTuaSekunder,
                        mualPrimer,
                        mualSekunder,
                        hmapSekunder,
                        hmapPrimer;

                Compute hitung = new Compute(Deteksi.this);
                hitung.compute();

                temporary demam = primer_sekunder(
                        rgDemam,
                        R.id.RB_demam_ya,
                        R.id.RB_demam_tidak,
                        hitung.likelihoodDemamPrimer_Ya,
                        hitung.likelihoodDemamPrimer_Tidak,
                        hitung.likelihoodDemamSekunder_Ya,
                        hitung.likelihoodDemamSekunder_Tidak,
                        "demam tidak diisi");
                demamPrimer = demam.getPrimer();
                demamSekunder = demam.getSekunder();

                temporary defisit = primer_sekunder(
                        rgDefisit,
                        R.id.RB_defisit_ya,
                        R.id.RB_defisit_tidak,
                        hitung.likelihoodDefisitPrimer_Ya,
                        hitung.likelihoodDefisitPrimer_Tidak,
                        hitung.likelihoodDefisitSekunder_Ya,
                        hitung.likelihoodDefisitSekunder_Tidak,
                        "defisit tidak diisi");
                defisitPrimer = defisit.getPrimer();
                defisitSekunder = defisit.getSekunder();

                temporary kejang = primer_sekunder(
                        rgKejang,
                        R.id.RB_kejang_ya,
                        R.id.RB_kejang_tidak,
                        hitung.likelihoodKejangPrimer_Ya,
                        hitung.likelihoodKejangPrimer_Tidak,
                        hitung.likelihoodKejangSekunder_Ya,
                        hitung.likelihoodKejangSekunder_Tidak,
                        "kejang tidak diisi");
                kejangPrimer = kejang.getPrimer();
                kejangSekunder = kejang.getSekunder();

                temporary edema = primer_sekunder(
                        rgEdema,
                        R.id.RB_edema_ya,
                        R.id.RB_edema_tidak,
                        hitung.likelihoodEdemaPrimer_Ya,
                        hitung.likelihoodEdemaPrimer_Tidak,
                        hitung.likelihoodEdemaSekunder_Ya,
                        hitung.likelihoodEdemaSekunder_Tidak,
                        "edema tidak diisi");
                edemaPrimer = edema.getPrimer();
                edemaSekunder = edema.getSekunder();

                temporary nkprogresif = primer_sekunder(
                        rgNkprogresif,
                        R.id.RB_nkprogresif_ya,
                        R.id.RB_nkprogresif_tidak,
                        hitung.likelihoodNkprogresifPrimer_Ya,
                        hitung.likelihoodNkprogresifPrimer_Tidak,
                        hitung.likelihoodNkprogresifSekunder_Ya,
                        hitung.likelihoodNkprogresifSekunder_Tidak,
                        "nyeri kepala progresif tidak diisi");
                nkprogresifPrimer = nkprogresif.getPrimer();
                nkprogresifSekunder = nkprogresif.getSekunder();

                temporary onsetMendadak = primer_sekunder(
                        rgOnsetMendadak,
                        R.id.RB_OnsetMendadak_ya,
                        R.id.RB_OnsetMendadak_tidak,
                        hitung.likelihoodOnsetMendadakPrimer_Ya,
                        hitung.likelihoodOnsetMendadakPrimer_Tidak,
                        hitung.likelihoodOnsetMendadakSekunder_Ya,
                        hitung.likelihoodOnsetMendadakSekunder_Tidak,
                        "onset mendadak tidak diisi");
                onsetMendadakPrimer = onsetMendadak.getPrimer();
                onsetMendadakSekunder = onsetMendadak.getSekunder();

                temporary fpencetus = primer_sekunder(
                        rgFpencetus,
                        R.id.RB_fpencetus_ya,
                        R.id.RB_fpencetus_tidak,
                        hitung.likelihoodFpencetusPrimer_Ya,
                        hitung.likelihoodFpencetusPrimer_Tidak,
                        hitung.likelihoodFpencetusSekunder_Ya,
                        hitung.likelihoodFpencetusSekunder_Tidak,
                        "faktor pencetus tidak diisi");
                fpencetusPrimer = fpencetus.getPrimer();
                fpencetusSekunder = fpencetus.getSekunder();

                temporary riwayat = primer_sekunder(
                        rgRiwayat,
                        R.id.RB_riwayat_ya,
                        R.id.RB_riwayat_tidak,
                        hitung.likelihoodRiwayatPrimer_Ya,
                        hitung.likelihoodRiwayatPrimer_Tidak,
                        hitung.likelihoodRiwayatSekunder_Ya,
                        hitung.likelihoodRiwayatSekunder_Tidak,
                        "riwayat tidak diisi");
                riwayatPrimer = riwayat.getPrimer();
                riwayatSekunder = riwayat.getSekunder();

                temporary usiaTua = primer_sekunder(
                        rgUsia,
                        R.id.RB_usia_ya,
                        R.id.RB_usia_tidak,
                        hitung.likelihoodUsiaTuaPrimer_Ya,
                        hitung.likelihoodUsiaTuaPrimer_Tidak,
                        hitung.likelihoodUsiaTuaSekunder_Ya,
                        hitung.likelihoodUsiaTuaSekunder_Tidak,
                        "usia tua tidak diisi");
                usiaTuaPrimer = usiaTua.getPrimer();
                usiaTuaSekunder = usiaTua.getSekunder();

//                //Jenis Kelamin
//                int Jkid = rgJk.getCheckedRadioButtonId();
//                if (Jkid==R.id.RB_jk_lk){
//                    isJkLakiChecked=true;
//                }
//                if(isJkLakiChecked) {
//                    jkPrimer = hitung.likelihoodJkPrimer_Laki;
//                    jkSekunder = hitung.likelihoodJkSekunder_Laki;
//                }
//                else {
//                    jkPrimer = hitung.likelihoodJkPrimer_Perempuan;
//                    jkSekunder = hitung.likelihoodJkSekunder_Perempuan;
//                }

                temporary mual = primer_sekunder(
                        rgMual,
                        R.id.RB_mual_ya,
                        R.id.RB_mual_tidak,
                        hitung.likelihoodMualPrimer_Ya,
                        hitung.likelihoodMualPrimer_Tidak,
                        hitung.likelihoodMualSekunder_Ya,
                        hitung.likelihoodMualSekunder_Tidak,
                        "mual tidak diisi");
                mualPrimer = mual.getPrimer();
                mualSekunder = mual.getSekunder();


                hmapSekunder = hitung.priorSekunder * (demamSekunder * defisitSekunder * kejangSekunder * edemaSekunder * nkprogresifSekunder * onsetMendadakSekunder * fpencetusSekunder * riwayatSekunder * usiaTuaSekunder * mualSekunder);
                hmapPrimer = hitung.priorPrimer * (demamPrimer * defisitPrimer * kejangPrimer * edemaPrimer * nkprogresifPrimer * onsetMendadakPrimer * fpencetusPrimer * riwayatPrimer * usiaTuaPrimer * mualPrimer);

                Log.e("nilai sekunder",hitung.priorSekunder +" "+ demamSekunder +" "+ defisitSekunder +" "+ kejangSekunder +" "+ edemaSekunder +" "+ nkprogresifSekunder +" "+ onsetMendadakSekunder +" "+ fpencetusSekunder +" "+ riwayatSekunder +" "+ usiaTuaSekunder +" "+ mualSekunder);
                Log.e("nilai primer",hitung.priorPrimer +" "+ demamPrimer +" "+ defisitPrimer +" "+ kejangPrimer +" "+ edemaPrimer +" "+ nkprogresifPrimer +" "+ onsetMendadakPrimer +" "+ fpencetusPrimer +" "+ riwayatPrimer +" "+ usiaTuaPrimer +" "+ mualPrimer);

                Log.e("bbb", "4444");

                String sekunder = "Anda mengalami nyeri kepala sekunder";
                String primer = "Anda mengalami nyeri kepala primer, silahkan pilih tombol next untuk melanjutkan diagnosis";
                String hasil;
                if (hmapSekunder > hmapPrimer) {
                    hasil = sekunder;
                }
                else {
                    hasil = primer;
                }
                tvHasilDeteksi.setText(hasil + "\nPrimer : " + hmapPrimer + "\nSekunder" + hmapSekunder);

                Log.e("ccc", "555");
            }
        });
    }
}

//        Compute hitung = new Compute(Deteksi.this);
//                hitung.compute();
//                double demamPrimer, demamSekunder;
//                boolean checked = ((RadioButton) view).isChecked();
//                switch (view.getId())
//                {
//                    case R.id.RB_demam_ya:
//                        if(checked)
//                            break;
//                    case R.id.RB_demam_tidak:
//                        if(checked)
//                            break;
//                }

//                double defisitPrimer, defisitSekunder;
//                switch (view.getId())
//                {
//                    case R.id.RB_defisit_ya:
//                        if(checked)
//                            break;
//                    case R.id.RB_defisit_tidak:
//                        if(checked)
//                            break;
//                }




//                boolean checked = ((RadioButton) view).isChecked();
//                Compute hitung = new Compute(Deteksi.this);
//                hitung.compute();
//                double demamPrimer;
//                switch (view.getId())
//                {
//                    case R.id.RB_demam_ya:
//                        if(checked)
////                            demamPrimer = hitung.likelihoodDemamPrimer_Ya;
////                    else
////                        demamPrimer = hitung.likelihoodDemamPrimer_Tidak;
//                            break;


//        buttonDeteksi.setOnClickListener(new View.OnClickListener() {
//                                      @Override
//                                      public void onClick(View view) {
////                                          Compute hitung = new Compute(Deteksi.this);
//                                          hitung.compute();
//        //get selected radiobutton from radiogroup
//        int rbDemamYa = rgDemam.getCheckedRadioButtonId();
//        double demamPrimer;
////        if (rbDemamYa == R.id.RB_demam_ya) demamPrimer = hitung.likelihoodDemamPrimer_Ya;
////        else demamPrimer = hitung.likelihoodDemamPrimer_Tidak;
//
//        int rbDemamSekunder_Ya = rgDemam.getCheckedRadioButtonId();
//        double demamSekunder;
//        if (rbDemamSekunder_Ya == R.id.RB_demam_ya) demamSekunder = hitung.likelihoodDemamSekunder_Ya;
//        else demamSekunder = hitung.likelihoodDemamSekunder_Tidak;
//
//
//        //find radiogroup defisit by id
//
//        //get selected radiobutton from radiogroup
//        int rbDefisitPrimer_Ya = rgDefisit.getCheckedRadioButtonId();
//        double defisitPrimer;
//        if (rbDefisitPrimer_Ya == R.id.RB_defisit_ya) defisitPrimer = hitung.likelihoodDefisitPrimer_Ya;
//        else defisitPrimer = hitung.likelihoodDefisitPrimer_Tidak;
//
//        //get selected radiobutton from radiogroup
//        int rbDefisitSekunder_Ya = rgDefisit.getCheckedRadioButtonId();
//        double defisitSekunder;
//        if (rbDefisitSekunder_Ya == R.id.RB_defisit_ya) defisitSekunder = hitung.likelihoodDefisitSekunder_Ya;
//        else defisitSekunder = hitung.likelihoodDefisitSekunder_Tidak;
//
//        //find radiogroup kejang by id
//
//        //get selected radiobutton from radiogroup
//        int rbKejangPrimer_Ya = rgKejang.getCheckedRadioButtonId();
//        double kejangPrimer;
//        if (rbKejangPrimer_Ya == R.id.RB_kejang_ya) kejangPrimer = hitung.likelihoodKejangPrimer_Ya;
//        else kejangPrimer = hitung.likelihoodKejangPrimer_Tidak;
//
//        int rbKejangSekunder_Ya = rgKejang.getCheckedRadioButtonId();
//        double kejangSekunder;
//        if (rbKejangSekunder_Ya == R.id.RB_kejang_ya) kejangSekunder = hitung.likelihoodKejangSekunder_Ya;
//        else kejangSekunder = hitung.likelihoodKejangSekunder_Tidak;
//
//        //find radiogroup kejang by id
//
//        //get selected radiobutton from radiogroup
//        int rbNkprogresifPrimer_Ya = rgNkprogresif.getCheckedRadioButtonId();
//        double nkprogresifPrimer;
//        if (rbNkprogresifPrimer_Ya == R.id.RB_kejang_ya) nkprogresifPrimer = hitung.likelihoodNkprogresifPrimer_Ya;
//        else nkprogresifPrimer = hitung.likelihoodKejangPrimer_Tidak;
//
//        int rbNkprogresifSekunder_Ya = rgNkprogresif.getCheckedRadioButtonId();
//        double nkprogresifSekunder;
//        if (rbNkprogresifSekunder_Ya == R.id.RB_kejang_ya) nkprogresifSekunder = hitung.likelihoodNkprogresifSekunder_Ya;
//        else nkprogresifSekunder = hitung.likelihoodKejangSekunder_Tidak;
//
//        //find radiogroup onset mendadak by id
//
//        //get selected radiobutton from radiogroup
//        int rbOnsetMendadakPrimer_Ya = rgOnsetMendadak.getCheckedRadioButtonId();
//        double OnsetMendadakPrimer;
//        if (rbOnsetMendadakPrimer_Ya == R.id.RB_OnsetMendadak_ya) OnsetMendadakPrimer = hitung.likelihoodOnsetMendadakPrimer_Ya;
//        else OnsetMendadakPrimer = hitung.likelihoodOnsetMendadakPrimer_Tidak;
//
//        int rbOnsetMendadakSekunder_Ya = rgOnsetMendadak.getCheckedRadioButtonId();
//        double OnsetMendadakSekunder;
//        if (rbOnsetMendadakSekunder_Ya == R.id.RB_OnsetMendadak_ya) OnsetMendadakSekunder = hitung.likelihoodOnsetMendadakSekunder_Ya;
//        else OnsetMendadakSekunder = hitung.likelihoodOnsetMendadakSekunder_Tidak;
//
//        //find radiogroup kejang by id
//
//        //get selected radiobutton from radiogroup
//        int rbEdemaPrimer_Ya = rgEdema.getCheckedRadioButtonId();
//        double edemaPrimer;
//        if (rbEdemaPrimer_Ya == R.id.RB_edema_ya) edemaPrimer = hitung.likelihoodEdemaPrimer_Ya;
//        else edemaPrimer = hitung.likelihoodEdemaPrimer_Tidak;
//
//        int rbEdemaSekunder_Ya = rgEdema.getCheckedRadioButtonId();
//        double edemaSekunder;
//        if (rbEdemaSekunder_Ya == R.id.RB_edema_ya) edemaSekunder = hitung.likelihoodEdemaSekunder_Ya;
//        else edemaSekunder = hitung.likelihoodEdemaSekunder_Tidak;
//
//        //find radiogroup faktor pencetus by id
//
//        //get selected radiobutton from radiogroup
//        int rbfpencetusPrimer_Ya = rgFpencetus.getCheckedRadioButtonId();
//        double fpencetusPrimer;
//        if (rbfpencetusPrimer_Ya == R.id.RB_fpencetus_ya) fpencetusPrimer = hitung.likelihoodFpencetusPrimer_Ya;
//        else fpencetusPrimer = hitung.likelihoodFpencetusPrimer_Tidak;
//
//        int rbfpencetusSekunder_Ya = rgFpencetus.getCheckedRadioButtonId();
//        double fpencetusSekunder;
//        if (rbfpencetusSekunder_Ya == R.id.RB_fpencetus_ya) fpencetusPrimer = hitung.likelihoodFpencetusSekunder_Ya;
//        else fpencetusSekunder = hitung.likelihoodFpencetusSekunder_Tidak;
//
//        //find radiogroup riwayat by id
//
//        //get selected radiobutton from radiogroup
//        int rbriwayatPrimer_Ya = rgRiwayat.getCheckedRadioButtonId();
//        double riwayatPrimer;
//        if (rbriwayatPrimer_Ya == R.id.RB_riwayat_ya) riwayatPrimer = hitung.likelihoodRiwayatPrimer_Ya;
//        else riwayatPrimer = hitung.likelihoodRiwayatPrimer_Tidak;
//
//        int rbriwayatSekunder_Ya = rgRiwayat.getCheckedRadioButtonId();
//        double riwayatSekunder;
//        if (rbriwayatSekunder_Ya == R.id.RB_riwayat_ya) riwayatSekunder = hitung.likelihoodRiwayatSekunder_Ya;
//        else riwayatSekunder = hitung.likelihoodRiwayatSekunder_Tidak;
//
//        //find radiogroup jenis kelamin by id
//
//        //get selected radiobutton from radiogroup
//        int rbjkPrimer_Laki = rgJk.getCheckedRadioButtonId();
//        double jkPrimer;
//        if (rbjkPrimer_Laki == R.id.RB_jk_lk) jkPrimer = hitung.likelihoodJkPrimer_Laki;
//        else jkPrimer = hitung.likelihoodJkPrimer_Perempuan;
//
//        int rbjkSekunder_Laki = rgJk.getCheckedRadioButtonId();
//        double jkSekunder;
//        if (rbjkSekunder_Laki == R.id.RB_jk_lk) jkSekunder = hitung.likelihoodJkSekunder_Laki;
//        else jkSekunder = hitung.likelihoodJkSekunder_Perempuan;
//
//        //find radiogroup usia by id
//
//        //get selected radiobutton from radiogroup
//        int rbUsiaTuaPrimer_Ya = rgUsia.getCheckedRadioButtonId();
//        double usiaTua_Primer
//        if (rbUsiaTuaPrimer_Ya == R.id.RB_usia_ya) usiaTua_Primer = hitung.likelihoodUsiaTuaPrimer_Ya;
//        else usiaTua_Primer = hitung.likelihoodUsiaTuaPrimer_Tidak;
//
//        int rbUsiaTuaSekunder_Ya = rgUsia.getCheckedRadioButtonId();
//        double usiaTua_Sekunder;
//        if (rbUsiaTuaSekunder_Ya == R.id.RB_usia_ya) usiaTua_Sekunder = hitung.likelihoodUsiaTuaSekunder_Ya;
//        else usiaTua_Sekunder = hitung.likelihoodUsiaTuaSekunder_Tidak;
//
//        //find radiogroup jk by id
//
//        //get selected radiobutton from radiogroup
//        int rbMualPrimer_Ya = rgMual.getCheckedRadioButtonId();
//        double mual_Primer;
//        if (rbMualPrimer_Ya == R.id.RB_mual_ya) mual_Primer = hitung.likelihoodMualPrimer_Ya;
//        else mual_Primer = hitung.likelihoodMualPrimer_Tidak;
//
//        int rbMualSekunder_Ya = rgMual.getCheckedRadioButtonId();
//        double mual_Sekunder;
//        if (rbMualSekunder_Ya == R.id.RB_mual_ya) mual_Sekunder = hitung.likelihoodMualSekunder_Ya;
//        else mual_Sekunder = hitung.likelihoodMualSekunder_Tidak;
//
//        btnReadFile = (Button) findViewById(R.id.btn_readfile);
//        btnReadFile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),ComputeKedua.class);
//                startActivity(i);
//            }
//        });
//
//        text_demam = findViewById(R.id.textview); //belum ada xml nya
//        text_demam.getText();
//
//
//
//
//        double demam;
//        if (text_demam == 1) demam = hitung.demamYaPrimer; //demam ini yg masuk posterior
//        else demam = hitung.demamTidakPrimer;
//
//        text_durasi_angka = findViewById(R.id.);
//        text_durasi_string = findViewById(R.id.);
//        int durasi = _compute_durasi(text_durasi_angka.getText(),text_durasi_string.getText());
//        int converted_durasi = _convert_durasi(durasi);
//        if (converted_durasi == -1) {
//            // kasi pesan error
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        }
//        if(converted_durasi == 2) hitung.durasi2;
//        else if(converted_durasi == 1) hitung.durasi1;
//        else if(converted_durasi == 0) hitung.durasi0;
//    }
//
//    private int _compute_durasi(String angka,String text) {
//        int durasi_angka = Integer.valueOf(angka);
//        if (text == "hari") return durasi_angka*24*60*60;
//    }
//
//    private int _convert_durasi(int durasi) {
//        int range1 = 15;
//        int range2 = 30;
//        int range3 = 180*60*60;
//        int range4 = 7*24*60*60;
//
//        if (durasi >= range2 && durasi <= range4) return 2;
//        else return -1;
//    }
//}
////    @Override
////    public void onClick(View view) {
////        Intent i;
////        switch (view.getId()) {
////            case R.id.btn_readfile:
////                i = new Intent(this, NaiveBayes.class);
////                startActivity(i);
////                break;
////            default:
////                break;
////        }
