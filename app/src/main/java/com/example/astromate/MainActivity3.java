package com.example.astromate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
TextView text;
Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        text=findViewById(R.id.text);
        share= findViewById(R.id.share);

        Intent intent=getIntent();
        String rashi= intent.getStringExtra("rashi");
        String color= intent.getStringExtra("color");
        String desc= intent.getStringExtra("desc");
        String age= intent.getStringExtra("year");
        String traits=intent.getStringExtra("About");
        String name=intent.getStringExtra("name");
        text.setText(
                "Rashi : " +rashi+
                        "\n\nLucky Color : "+color+
                        "\n\nDescription : "+desc+
                        "\n\nTrait : \n"+traits

        );
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "🔮 Astrology Result by Astromate app\n\n"
                        + "Name: " + name + "\n"
                        + "Rashi: " + rashi + "\n"
                        + "Color: " + color + "\n"
                        + "Traits:\n " + traits + "\n\n"
                        + "✨ Sent from Astromate App,Explore this app";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, msg);

                startActivity(Intent.createChooser(intent, "Share with friend"));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}