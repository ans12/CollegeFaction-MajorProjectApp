package com.mp.collegefaction.collegefaction;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mp.collegefaction.collegefaction.data.ColFacDbHelper;
import com.mp.collegefaction.collegefaction.utilities.NetworkUtils;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;


public class LoginActivity extends AppCompatActivity {

    LoginTask myTask;
    private EditText username,password;
    Button btnLogin;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.ed_username);
        password = (EditText) findViewById(R.id.ed_password);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkEnabled()) {
//                    if (myTask != null)
//                        myTask.cancel(true);
//
//                    HashMap<String, String> values = new HashMap<>();
//                    values.put("email", username.getText().toString().trim());
//                    values.put("password", password.getText().toString().trim());
//                    myTask = new LoginTask(getApplicationContext());
//                    myTask.execute(values);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Snackbar.make(view, "No internet available",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton btnFbLogin = (ImageButton) findViewById(R.id.btn_fb_login);
        ImageButton btnGoogleLogin = (ImageButton) findViewById(R.id.btn_google_login);
        ImageButton btnLinkedInLogin = (ImageButton) findViewById(R.id.btn_linkedin_login);

        TextView tvForgetPassword = (TextView) findViewById(R.id.tv_forget_password);
        TextView tvSignUp = (TextView) findViewById(R.id.tv_signup);

        btnGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Google login will be implemented.", Snackbar.LENGTH_LONG).show();
            }
        });

        btnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "fb-Not implemented yet.", Snackbar.LENGTH_LONG).show();
            }
        });

        btnLinkedInLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Not implemented yet.", Snackbar.LENGTH_LONG).show();
            }
        });

        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Not implemented yet.", Snackbar.LENGTH_LONG).show();
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isNetworkEnabled(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(LoginActivity.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo= connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo!=null && activeNetworkInfo.isConnected();
    }

    class LoginTask extends AsyncTask<HashMap<String,String>,Void,String>{

        private final Context context;
        ProgressDialog progressDialog;

        LoginTask(Context context) {
            this.context = context;
        }

        @Override


        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialog = new ProgressDialog(context);
//            progressDialog.setMessage("Logging in...");
//            progressDialog.setCancelable(false);
//            progressDialog.show();
        }

        @Override
        protected String doInBackground(HashMap<String, String>[] hashMaps) {
            try {
                URL url = NetworkUtils.getUrl(NetworkUtils.GET_LOGIN_URL);
                Log.v("LOGIN",url.toString());
                if (hashMaps[0] != null)
                    return NetworkUtils.getResponseFromHttpUrl(url,hashMaps[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            if (progressDialog.isShowing())
//                progressDialog.cancel();
            Log.v("LOGIN","respose: "+s);
            Toast.makeText(getApplicationContext(),"Lggin: "+s,Toast.LENGTH_LONG).show();

            if (s!=null){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }
}

