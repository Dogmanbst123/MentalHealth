package com.example.freeecodecamptutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    private KonfettiView konfettiView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KonfettiView konfettiView = findViewById(R.id.theUIKonfettiView);
        EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .sizes(new Size(12, 5f, 0.2f))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();
        konfettiView.setOnClickListener(view ->
                konfettiView.start(party)
        );
    }

    public void buttonClick (View view) {
        String[] dailyChallengeArray = {"Take a piece of paper and write down how your day has been going. This activity should take 5 minutes"
                , "Isolate yourself from distractions and find a silent place to rest. Then reflect on everything bad that happened today. This activity should take 5 minutes."
        };
        String dailyChallengeText = dailyChallengeArray[random.nextInt(5)];
        TextView dailyChallenge = findViewById(R.id.dailyChallenge);
        dailyChallenge.setText(dailyChallengeText);
        System.out.println(random.nextInt(1));
    }
}