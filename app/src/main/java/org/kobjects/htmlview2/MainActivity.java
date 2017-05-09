package org.kobjects.htmlview2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainActivity extends Activity {

    HtmlProcessor htmlProcessor = new HtmlProcessor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Reader reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("index.html")));

            HtmlView htmlView = new HtmlView(this);
            htmlProcessor.parse(reader, htmlView);

            ScrollView scrollView = new ScrollView(this);
            scrollView.addView(htmlView);
            setContentView(scrollView);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
