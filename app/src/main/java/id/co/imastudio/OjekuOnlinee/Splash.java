package id.co.imastudio.OjekuOnlinee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.co.imastudio.OjekuOnlinee.Helper.SessionManager;
import id.co.imastudio.OjekuOnlinee.View.login;

public class Splash extends AppCompatActivity {

    SessionManager sesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // inisialisasi
        sesi = new SessionManager(Splash.this);

        //
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // pengecekan sesi
                if (sesi.isLogin()){
                    // start new activity
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(Splash.this, login.class));
                    finish();
                }
            }
        }, 3000 ); // satuan dalam milisecond

    }
}
