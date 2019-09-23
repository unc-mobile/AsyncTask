package com.example.scroggo.processeslive;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    ImageView mImageView;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mImageView = findViewById(R.id.imageView);
        mTextView = findViewById(R.id.textView);
    }
    
    public void onClick(View view) {
        mTextView.setText("Loading");
        new BitmapLoader().execute(R.raw.big);
    }

    private class BitmapLoader extends AsyncTask<Integer, Void, Bitmap> {
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
            mTextView.setText("Loaded!");
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            return BitmapFactory.decodeResource(getResources(), integers[0]);
        }
    }
}
