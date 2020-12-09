package com.example.one.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.one.R;

public class PoemActivity extends AppCompatActivity {
    public static final String TITLE="标题";
    public static final String AUTHOR="作者";
    public static final String CONTENT="内容";
    public static final String INTRO="注释";
    private TextView showTitle;
    private TextView showAuthor;
    private TextView showContent;
    private TextView showIntro;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);
        showTitle=(TextView)findViewById(R.id.title_in_activity);
        showAuthor=(TextView)findViewById(R.id.author_in_activity);
        showContent=(TextView)findViewById(R.id.poem_content);
        showIntro=(TextView)findViewById(R.id.intro);
        intent=getIntent();
        showTitle.setText(intent.getStringExtra(TITLE));
        showAuthor.setText(intent.getStringExtra(AUTHOR));
        showContent.setText(intent.getStringExtra(CONTENT));
        showIntro.setText(intent.getStringExtra(INTRO));
    }
}
