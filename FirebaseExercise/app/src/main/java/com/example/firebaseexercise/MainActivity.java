package com.example.firebaseexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText mLastNameInput;
    private EditText mFirstNameInput;
    private TextView mDatabase;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLastNameInput = (EditText) findViewById(R.id.LastNameinput);
        mFirstNameInput = (EditText) findViewById(R.id.FirstNameInput);

        mDatabase = (TextView) findViewById(R.id.Database);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("employees");
        Log.i("MAINACTIVITY", myRef.toString());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Employee person;
                int c = 1;
                String databaseOutput="";
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    person = (Employee)ds.getValue(Employee.class);
                    Log.i("MAINACTIVITY", "Employee " + c + ": " + person.getFirstName() + " " + person.getLastName());
                    databaseOutput = databaseOutput + "Employee " + c + ": " + person.getFirstName() + " " + person.getLastName()+ "\n";
                    c++;
                }
                mDatabase.setText(databaseOutput);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("MAINACTIVITY", "Failed to read value.", error.toException());
            }
        });
    }

    public void addEmployee(View view) {
        myRef = database.getReference("employees");
        String firstName = mFirstNameInput.getText().toString();
        String lastName = mLastNameInput.getText().toString();

        if(!(firstName.isEmpty()||lastName.isEmpty())){
            Employee emp = new Employee(lastName, firstName);
            myRef.push().setValue(emp);
        }else{
            Toast.makeText(MainActivity.this,"Please enter a first and last name",Toast.LENGTH_SHORT).show();
        }
    }

}