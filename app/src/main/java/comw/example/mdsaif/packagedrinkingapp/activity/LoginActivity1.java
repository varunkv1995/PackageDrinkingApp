package comw.example.mdsaif.packagedrinkingapp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import comw.example.mdsaif.packagedrinkingapp.Fragment.MyProfile;
import comw.example.mdsaif.packagedrinkingapp.R;

/**
 * Created by DELL on 24-02-2018.
 */

public class LoginActivity1 extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button buttonLogin,buttonSignUp,buttonForgot;
    private EditText editTextMobile, editTextPass;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonSignUp = (Button) findViewById(R.id.buttonSignup);
        buttonForgot = (Button) findViewById(R.id.buttonForgot);
        buttonForgot.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity1.this, ForgotActivity.class);
                startActivity(intent);
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity1.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
                buttonLogin.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        final ProgressDialog dialog = new ProgressDialog(LoginActivity1.this);
                        final String email = editTextMobile.getText().toString();
                        String pass = editTextPass.getText().toString();
                        dialog.setMessage("Logging in");
                        if (TextUtils.isEmpty(email)) {
                            editTextMobile.setError("This field can't be empty");
                            return;
                        }
                        if (TextUtils.isEmpty(pass)) {
                            editTextPass.setError("This field can't be empty");
                            return;
                        }
                        dialog.setMessage("Logging In");
                        dialog.show();
                        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dialog.dismiss();
                                    Intent intent = new Intent(LoginActivity1.this, MainActivity.class);
                                    intent.putExtra("email", email);
                                    MyProfile myObj = new MyProfile();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("email", email);
// set MyFragment Arguments

                                    myObj.setArguments(bundle);
                                    startActivity(intent);
                                    finish();
                                } else
                                    try {
                                        dialog.dismiss();
                                        throw task.getException();
                                    } catch (FirebaseAuthInvalidCredentialsException e) {
                                        Snackbar.make(v, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                            }
                        });

                    }
                });

            }
        }



