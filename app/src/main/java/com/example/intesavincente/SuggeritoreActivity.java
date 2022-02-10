package com.example.intesavincente;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.widget.TextView;

import com.example.intesavincente.repository.words.IWordsRepository;
import com.example.intesavincente.repository.words.WordsRepository;
import com.example.intesavincente.utils.ResponseCallback;

public class SuggeritoreActivity extends AppCompatActivity implements ResponseCallback, IndovinatoreResponse {

    TextView parolaDaIndovinare;
    private IWordsRepository mIWordsRepository;
    private IIndovinatore mIIndovinatore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggeritore);
        mIWordsRepository = new WordsRepository(this.getApplication(), this);
        mIWordsRepository.fetchWords();
        mIIndovinatore=new Indovinatore(this.getApplication(), this);
        mIIndovinatore.salva();
    }

    @Override
    public void onResponse(String parola) {
        System.out.println("Prova " + parola);
        // parolaDaIndovinare = findViewById(R.id.parolaDaIndovinare);
        //parolaDaIndovinare.setText(parola);
    }

    @Override
    public void onFailure(String errorMessage) {

    }

    @Override
    public void saveParola(String parola) {
        System.out.println("ProvaGiusta" + parola);
        parolaDaIndovinare = findViewById(R.id.parolaDaIndovinare);
        parolaDaIndovinare.setText(parola);
    }
}