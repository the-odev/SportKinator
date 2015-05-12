package com.epsi.sportkinator.sportkinator.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.epsi.sportkinator.sportkinator.R;
import com.epsi.sportkinator.sportkinator.entities.Question;
import com.epsi.sportkinator.sportkinator.entities.Sport;
import com.epsi.sportkinator.sportkinator.parser.SportXmlParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FormSport extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_sport);
        Button buttonLoadImage = (Button)findViewById(R.id.imageButton);

        buttonLoadImage.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            //textTargetUri.setText(targetUri.toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_sport, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* public void buttonAddQuestion(View view){
        SportXmlParser sportXmlParser = new SportXmlParser();
        InputStream inputStream = null;
        // inputStream = getResources().openRawResource(R.raw.connaissance);

        File mFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/bdConnaissance.xml");

        try {
            inputStream = new FileInputStream(mFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(!sportXmlParser.sportAllReadyExists(inputStream,editTextSport.getText().toString())){
            //inputStream = getResources().getXml(R.xml.connaissance);
            Question newQuestion = new Question(editTextQuestion.getText().toString(),response,"id");
            Sport newSport= new Sport(editTextSport.getText().toString());
            try {
                sportXmlParser.addQuestion(this,question.getResponse(),newQuestion,newSport);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Une erreur est survenue", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Le sport a bien été ajouté", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Le sport existe deja !", Toast.LENGTH_SHORT).show();
        }

    }*/
}
