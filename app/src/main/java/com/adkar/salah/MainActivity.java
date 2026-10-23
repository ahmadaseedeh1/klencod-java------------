package com.adkar.salah;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout mainLayout;
    private TextView counterText;
    private int counter = 0;

    private final int green = Color.rgb(18, 92, 67);
    private final int background = Color.rgb(244, 248, 245);

    private final String[] adhkar = {
        "أَسْتَغْفِرُ اللَّهَ",
        "أَسْتَغْفِرُ اللَّهَ",
        "أَسْتَغْفِرُ اللَّهَ",
        "اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ، تَبَارَكْتَ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ.",
        "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ.",
        "اللَّهُمَّ لَا مَانِعَ لِمَا أَعْطَيْتَ، وَلَا مُعْطِيَ لِمَا مَنَعْتَ، وَلَا يَنْفَعُ ذَا الْجَدِّ مِنْكَ الْجَدُّ.",
        "سُبْحَانَ اللَّهِ (33 مرة)",
        "الْحَمْدُ لِلَّهِ (33 مرة)",
        "اللَّهُ أَكْبَرُ (33 مرة)",
        "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ.",
        "قُلْ هُوَ اللَّهُ أَحَدٌ",
        "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ",
        "قُلْ أَعُوذُ بِرَبِّ النَّاسِ",
        "اللَّهُمَّ أَعِنِّي عَلَى ذِكْرِكَ وَشُكْرِكَ وَحُسْنِ عِبَادَتِكَ."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private TextView makeText(String text, int size, int color) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setPadding(20, 18, 20, 18);
        t.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
        return t;
    }

    private void showHome() {
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(background);

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(18, 24, 18, 24);

        TextView title = makeText("أذكار ما بعد الصلاة", 28, Color.WHITE);
        title.setBackgroundColor(green);
        title.setTypeface(null, Typeface.BOLD);
        mainLayout.addView(title);

        TextView subtitle = makeText(
            "وَاذْكُرُوا اللَّهَ كَثِيرًا لَعَلَّكُمْ تُفْلِحُونَ",
            18, green
        );
        mainLayout.addView(subtitle);

        TextView button = makeText("ابدأ الأذكار", 22, Color.WHITE);
        button.setBackgroundColor(green);
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(
            -1, -2
        );
        bp.setMargins(0, 20, 0, 20);
        mainLayout.addView(button, bp);

        button.setOnClickListener(v -> showAdhkar());

        TextView note = makeText(
            "أذكار تقرؤها بعد الصلاة المفروضة\n\n" +
            "• الاستغفار\n" +
            "• أذكار بعد السلام\n" +
            "• التسبيح والتحميد والتكبير\n" +
            "• قراءة آية الكرسي والمعوذات",
            19, Color.DKGRAY
        );
        mainLayout.addView(note);

        scroll.addView(mainLayout);
        setContentView(scroll);
    }

    private void showAdhkar() {
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(background);

        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        list.setPadding(16, 16, 16, 24);

        TextView title = makeText("أذكار ما بعد الصلاة", 26, green);
        title.setTypeface(null, Typeface.BOLD);
        list.addView(title);

        counterText = makeText("عدد التسبيحات: 0", 20, green);
        list.addView(counterText);

        TextView countButton = makeText("اضغط للتسبيح", 22, Color.WHITE);
        countButton.setBackgroundColor(green);
        list.addView(countButton);

        countButton.setOnClickListener(v -> {
            counter++;
            counterText.setText("عدد التسبيحات: " + counter);
        });

        TextView resetButton = makeText("تصفير العدّاد", 18, green);
        list.addView(resetButton);

        resetButton.setOnClickListener(v -> {
            counter = 0;
            counterText.setText("عدد التسبيحات: 0");
        });

        for (int i = 0; i < adhkar.length; i++) {
            TextView item = makeText(
                (i + 1) + ".\n" + adhkar[i],
                21, Color.rgb(35, 55, 45)
            );
            item.setBackgroundColor(Color.WHITE);

            LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(-1, -2);
            params.setMargins(0, 10, 0, 10);
            list.addView(item, params);
        }

        TextView back = makeText("العودة للرئيسية", 19, Color.WHITE);
        back.setBackgroundColor(green);
        list.addView(back);
        back.setOnClickListener(v -> showHome());

        scroll.addView(list);
        setContentView(scroll);
    }
}