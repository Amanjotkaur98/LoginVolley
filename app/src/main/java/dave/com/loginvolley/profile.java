package dave.com.loginvolley;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView textView ;
    Button button ;
    public static final String MyPreferences="MyPref";
    public static final String Email="emailkey";
    public static final String Password="password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = (TextView)findViewById(R.id.textviewprofile);

        button = (Button)findViewById(R.id.button) ;

        Intent intent = getIntent();

        String username = intent.getStringExtra(Login_Activity.UserEmail);
        String password = intent.getStringExtra(Login_Activity.UserPass);

        textView.setText(username);
        sharedPreferences=getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit();
        editor.putString(Email,username);
        editor.putString(Password,password);
        editor.commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(profile.this, Login_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                editor.clear();
                editor.commit();
                Toast.makeText(profile.this, "Logged Out Successfully", Toast.LENGTH_LONG).show();

            }
        });

    }


}
