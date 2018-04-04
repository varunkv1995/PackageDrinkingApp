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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import comw.example.mdsaif.packagedrinkingapp.R;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private EditText editTextUser,editTextNumber,editTextPass,editTextCPass,editTextAddress,editTextPin,editTextEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        editTextCPass = (EditText) findViewById(R.id.editTextCPass);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextPin = (EditText) findViewById(R.id.editTextPin);
        Button button = (Button) findViewById(R.id.buttonNext);
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("RegisteredUsers");

        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(final View v) {
                final ProgressDialog dialog = new ProgressDialog(SignUpActivity.this);
                dialog.setMessage("Registering User");
                dialog.show();
                String name = editTextUser.getText().toString();
                String number = editTextNumber.getText().toString();
                String password = editTextPass.getText().toString();
                String confirm = editTextCPass.getText().toString();
                String address = editTextAddress.getText().toString();
                String pin = editTextPin.getText().toString();
                String email = editTextEmail.getText().toString();


                if (TextUtils.isEmpty(name)) {
                    editTextUser.setError("This field can' be empty");
                    return;
                }
                if (TextUtils.isEmpty(number)) {
                    editTextNumber.setError("This field can' be empty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    editTextPass.setError("This field can' be empty");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError("This field can' be empty");
                    return;
                }
                if (!password.equals(confirm)) {
                    editTextCPass.setError("passwords not match");
                    return;
                }
                if (password.length() < 6) {
                    editTextPass.setError("passwords must be min 4 char");
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    editTextAddress.setError("This field can' be empty");
                    return;
                }
                if (TextUtils.isEmpty(pin)) {
                    editTextPin.setError("This field can' be empty");
                    return;
                }
                if (pin.length() < 6) {
                    editTextPin.setError("Invalid Pincode");
                    return;
                }
                if (!email.matches("^[a-zA-Z0-9.]+@[a-zA-Z]+.(com|in)")) {
                    editTextEmail.setError("Invalid Email");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if (task.isSuccessful()){
                            startActivity(new Intent(SignUpActivity.this,PhoneAuthActivity.class));}
                        else
                            try {
                                throw task.getException();
                            }catch (FirebaseAuthUserCollisionException e){
                                Snackbar.make(v,e.getMessage(), Snackbar.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    }
                });
                Intent intent = new Intent(SignUpActivity.this, PhoneAuthActivity.class);
                startActivity(intent);

                User u=new User(name,number,email,password,address,pin);
                databaseReference.push().setValue(u);
            }
        });

    }
}

