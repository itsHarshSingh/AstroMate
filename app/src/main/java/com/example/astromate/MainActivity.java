package com.example.astromate;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText name,dob;
Button button;
int  dobyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        dob=findViewById(R.id.dob);
        button=findViewById(R.id.share);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

               int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int y, int m, int d) {
                                     dobyear=y;
                                dob.setText(d + "/" + (m+1) + "/" + y);
                            }
                        }, year, month, day);

                dp.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Info submitted", Toast.LENGTH_SHORT).show();
                String str=name.getText().toString();
                if(dobyear==0)
                {
                    dob.setError("Select dob");
                    return;
                }
                if(str.trim().isEmpty())
                {
                    name.setError("enter name");
                    return;
                }
                String rashi = "";
                String color = "";
                String desc = "";
                String Trait = "";



                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int age = currentYear-dobyear;

                char ch = Character.toUpperCase(str.charAt(0));
                switch(ch)
                {
                    case 'A':
                    case 'L':
                    case 'E':

                        rashi = "Mesh Rashi(Aries)";
                        color = "Red";
                        desc = "Energetic, confident aur leadership quality wale hote hain.";
                        Trait=". Bold \n. Confident\n. Energetic\n. Impulsive\n. Natural Leader";
                        break;

                    case 'B':
                    case 'V':
                    case 'U':

                        rashi = "Vrishabh Rashi(Taurus)";
                        color = "Green";
                        desc = "Calm, practical aur hardworking personality hoti hai.";
                        Trait=". Patients\n. Loyal\n. Calm Nature\n. Pratical\n. Strong will Power ";
                        break;

                    case 'K':
                    case 'C':
                    case 'G':

                        rashi = "Mithun Rashi(Gemini)";
                        color = "Yellow";
                        desc = "Smart aur communication me ache hote hain.";
                        Trait=". Intelligent\n. Talkative\n. Curios\n. Adaptable\n. Quick Learner";
                        break;

                    case 'D':
                    case 'H':

                        rashi = "Kark Rashi(Cancer)";
                        color = "White";
                        desc = "Caring aur emotional nature ke hote hain.";
                        Trait=". Emotional\n. Caring\n. Sensitive\n. Loyal\n. Family Oriented ";
                        break;

                    case 'M':
                    case 'T':

                        rashi = "Singh Rashi(Leo)";
                        color = "Gold";
                        desc = "Confident aur attractive personality hoti hai.";
                        Trait=". Confident\n. Natural Leader\n. Bold Personality\n. Proud & Ambitious";
                        break;

                    case 'P':
                    case 'N':

                        rashi = "Kanya Rashi(Virgo)";
                        color = "Sky Blue";
                        desc = "Intelligent aur detail-focused hote hain.";
                        Trait=". Analytical\n. Perfectionist\n. Hardworking\n. Pratical Nature\n. Detail Oriented";
                        break;

                    case 'R':

                        rashi = "Tula Rashi(Libra)";
                        color = "Pink";
                        desc = "Friendly aur balanced personality hoti hai.";
                        Trait=". Balanced\n. Charming\n. Diplomatic Nature\n. Peace Loving\n. Fair Decision maker";
                        break;

                    case 'S':

                        rashi = "Vrishchik Rashi(Scorpio)";
                        color = "Maroon";
                        desc = "Focused aur passionate nature hota hai.";
                        Trait=". Intense\n. Mysterious\n. Passionate\n. Loyal\n. strong will power";
                        break;

                    case 'Y':
                    case 'J':

                        rashi = "Dhanu Rashi(Sagittarius)";
                        color = "Purple";
                        desc = "Adventure aur travel pasand karte hain.";
                        Trait=". Optimistic\n. Adventurous\n. Honest\n. Free-spirited\n. Postive Thinker";
                        break;

                    case 'O':

                        rashi = "Makar Rashi(Capricorn)";
                        color = "Brown";
                        desc = "Responsible aur disciplined personality hoti hai.";
                        Trait=". Disciplined\n. Responsible\n. Hardworking\n. ppatient\n. Pratical mindset";
                        break;

                    case 'Q':
                    case 'Z':

                        rashi = "Kumbh Rashi(Aquarius)";
                        color = "Blue";
                        desc = "Creative aur unique thinking wale hote hain.";
                        Trait=". Independent\n. Innovative\n. Intelligent\n. Humanitarian\n. Unique Thinking";
                        break;

                    case 'F':
                    case 'I':

                        rashi = "Meen Rashi(Pisces)";
                        color = "Sea Green";
                        desc = "Kind aur imaginative personality hoti hai.";
                        Trait=". Emotional\n. Imaginative\n. Compassionate\n. sensitive\n. Creative";
                        break;

                    default:

                        rashi = "Unknown";
                        color = "None";
                        desc = "No data found.";
                }
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("rashi",rashi);
                intent.putExtra("color",color);
                intent.putExtra("desc",desc);
                 intent.putExtra("year",age);
                 intent.putExtra("About",Trait);
                 intent.putExtra("name",str);

startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}