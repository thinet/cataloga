package br.com.trama.cataloga.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.com.trama.cataloga.R;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity{

    @ViewById
    Toolbar toolbar;

    @AfterViews
    void init(){
        setSupportActionBar(toolbar);
        replaceFragment(new ListBooksFragment_());
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}
