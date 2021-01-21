package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.ifood.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Activity.AutenticacaoActivity;

public class SplashActivity extends AppCompatActivity {

    private DatabaseReference reference= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //Teste para ver se faz alteracao no FIreBase
        reference.child("teste").setValue("lelo");

        //Vai aparecer por 3 segundos depois vai abrir a tela de autenticacao

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirAutenticacao();
            }
        }, 5000); // 3 segundos

    }

    //Vai abrir a tela de Autenticacao

    public void abrirAutenticacao(){
        Intent intent=new Intent(SplashActivity.this, AutenticacaoActivity.class);
        startActivity(intent);
        finish(); // fecha a SplashActivity

    }

}