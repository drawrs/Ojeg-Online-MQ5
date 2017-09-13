package id.co.imastudio.OjekuOnlinee.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.co.imastudio.OjekuOnlinee.Helper.HeroHelper;
import id.co.imastudio.OjekuOnlinee.InitRetrofit.ApiServices;
import id.co.imastudio.OjekuOnlinee.InitRetrofit.InitLibrary;
import id.co.imastudio.OjekuOnlinee.R;
import id.co.imastudio.OjekuOnlinee.Response.ResponseDaftar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {

    EditText daftarusername, daftaremail, daftarhp, daftarpassword, daftarconfirmasipass;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        // inisialisasi
        daftarusername = (EditText) findViewById(R.id.daftarusername);
        daftaremail = (EditText) findViewById(R.id.daftaremail);
        daftarhp = (EditText) findViewById(R.id.daftarhp);
        daftarpassword = (EditText) findViewById(R.id.daftarpassword);
        daftarconfirmasipass = (EditText) findViewById(R.id.daftarconfirmasipass);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = daftarusername.getText().toString();
                String email = daftaremail.getText().toString();
                String no_hp = daftarhp.getText().toString();
                String password = daftarpassword.getText().toString();
                String password_check = daftarconfirmasipass.getText().toString();

                // pastikan input password dan password check sama
                if (!password.equals(password_check)){
                    Toast.makeText(Daftar.this, "Konfirmasi password tidak cocok ", Toast.LENGTH_SHORT).show();
                } else if (!nama.isEmpty()
                            && !email.isEmpty()
                            && !no_hp.isEmpty()
                            && !password.isEmpty()
                            && !password_check.isEmpty()){
                    // submit data to server
                    ApiServices api = InitLibrary.getInstance();

                    // siapkan request
                    Call<ResponseDaftar> call = api.request_daftar(nama, email, password, no_hp);
                    // kirim
                    call.enqueue(new Callback<ResponseDaftar>() {
                        @Override
                        public void onResponse(Call<ResponseDaftar> call, Response<ResponseDaftar> response) {
                            if (response.isSuccessful()){
                                String result = response.body().getResult();
                                String message = response.body().getMsg();
                                //
                                if (result.equals("1")){
                                    startActivity(new Intent(Daftar.this, login.class));
                                } else {
                                    // nampilin toast
                                    HeroHelper.pesan(Daftar.this, message);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseDaftar> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
