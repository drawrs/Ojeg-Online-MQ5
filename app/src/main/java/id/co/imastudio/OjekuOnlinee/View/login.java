package id.co.imastudio.OjekuOnlinee.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.co.imastudio.OjekuOnlinee.Helper.GPSTracker;
import id.co.imastudio.OjekuOnlinee.Helper.HeroHelper;
import id.co.imastudio.OjekuOnlinee.R;

public class login extends AppCompatActivity {

    // deklasi
    EditText loginemail, loginpassword;
    Button signin;
    TextView textlink;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // inisilisasi
        loginemail = (EditText) findViewById(R.id.loginemail);
        loginpassword = (EditText) findViewById(R.id.loginpassword);
        signin = (Button) findViewById(R.id.signin);
        textlink = (TextView) findViewById(R.id.textlink);

        //
        textlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, Daftar.class));
            }
        });
    }
}
