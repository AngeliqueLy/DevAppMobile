package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class MainActivity extends AppCompatActivity {
    private RadioGroup radioMidiOuSoirGroup;
    private RadioButton radioMidi;
    private RadioButton radioSoir;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meteo);
        /*radioMidiOuSoirGroup = (RadioGroup)findViewById(R.id.radiogroup1);
        radioMidi = (RadioButton)findViewById(R.id.radiobutton1);
        radioSoir = (RadioButton)findViewById(R.id.radiobutton2);
        radioMidi.setChecked(false);
        radioSoir.setChecked(false);
        if(radioMidi.isChecked()==true)
        {
            radioSoir.setChecked(false);
        }
        if(radioSoir.isChecked()==true)
        {
            radioMidi.setChecked(false);
        }

*/

    }
}