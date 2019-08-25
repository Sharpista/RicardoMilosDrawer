package com.example.mydrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout myDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle
                (this,myDrawerLayout,R.string.aberto,R.string.fechado);
        myDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.informaçõespessoais:
                Intent intent = new Intent(this,InfoPessoal.class);
                startActivity(intent);
                break;
            case R.id.experienciaprofissional:
                Intent intent1 = new Intent(this,ExpProfissional.class);
                startActivity(intent1);
                break;
            case R.id.formacao:
                Intent intent2 = new Intent(this,Fomacao.class);
                startActivity(intent2);
                break;
            case R.id.cursos:
                Intent intent3 = new Intent(this,Cursos.class);
                startActivity(intent3);
                break;
            case R.id.publicacoes:
                Intent intent4 = new Intent(this,Publicacoes.class);
                startActivity(intent4);
                break;
            default:
                Toast.makeText(this,"Menu Default",Toast.LENGTH_SHORT).show();
                break;
        }
        myDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
