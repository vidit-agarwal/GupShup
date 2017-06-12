package com.hugeardor.vidit.gupshup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.quickblox.auth.session.QBSettings;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

public class MainActivity extends AppCompatActivity {

    static final String APP_ID = "58973";
    static final String AUTH_KEY = "ujn4FZSL9XQKLfc";
    static final String AUTH_SECRET = "5O7qNUARea9q6xJ";
    static final String ACCOUNT_KEY = "7y8XA42QWUQmSVKHArn_";

    Button btnLogin , btnSignup;
    EditText edtUser , edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFramework();

        btnLogin = (Button)findViewById(R.id.main_btnLogin);
        btnSignup=(Button)findViewById(R.id.main_btnSignup);
        edtPassword = (EditText)findViewById(R.id.main_editPassword);
        edtUser=(EditText)findViewById(R.id.main_editLogin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , SignUpActivity.class));

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =edtUser.getText().toString();
                String password = edtPassword.getText().toString();

                QBUser qbuser = new QBUser(user, password);

                QBUsers.signIn(qbuser).performAsync(new QBEntityCallback<QBUser>() {
                    @Override
                    public void onSuccess(QBUser qbUser, Bundle bundle) {
                        Toast.makeText(getBaseContext(), "login Sucessful" , Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(QBResponseException e) {
                        Toast.makeText(getBaseContext(), ""+e.getMessage() , Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

    private void initializeFramework() {

        QBSettings.getInstance().init(getApplicationContext() , APP_ID , AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);


    }
}
