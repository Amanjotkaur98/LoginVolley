package dave.com.loginvolley;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import static dave.com.loginvolley.Login_Activity.Email;
import static dave.com.loginvolley.Login_Activity.Password;
import static dave.com.loginvolley.Login_Activity.UserEmail;
import static dave.com.loginvolley.Login_Activity.UserPass;
import static dave.com.loginvolley.profile.MyPreferences;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String email=null,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences=getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit();
        email=sharedPreferences.getString(Email,"");
        pass=sharedPreferences.getString(Password,"");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(email)){
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(SplashActivity.this,profile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra(UserEmail,email);
                    intent.putExtra(UserPass,pass);
                    startActivity(intent);
                }


            }
        },3000);
    }
}
