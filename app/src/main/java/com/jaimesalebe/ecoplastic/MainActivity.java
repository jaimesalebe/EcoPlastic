package com.jaimesalebe.ecoplastic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    TasksFragment tasksFragment = new TasksFragment(); //Se declaran 3 vistas nuevas para cada vista
    NewsFragment newsFragment = new NewsFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation); //Se referencia el bottom navigation
        navigation.setItemIconTintList(null);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener); // Se crea un lisener para cada vez que el usuario presione un boton sepa que fragmanto cargar.

        loadFragment(tasksFragment);
    }

    private final  BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.tasksFragment: // En caso de ser el primer fragmento o el TasksFragment para este caso, se carga y  asi con los demas
                    loadFragment(tasksFragment);
                    return true;
                case R.id.newsFragment:
                    loadFragment(newsFragment);
                    return true;
                case R.id.settingsFragment:
                    loadFragment(settingsFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){ // Con esto reemplazamos cada uno de los fragmentos para asi ir saltando de vista en vista
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();

    }
}