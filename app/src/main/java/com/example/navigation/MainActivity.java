package com.example.navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigation.databinding.ActivityMainBinding;

//Fusio entre les cuatre Activity juntes
public class MainActivity extends AppCompatActivity {

    //Java agafat de DrawerActivity i Main Activity en OnCreate
    ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                //Noves lineas per que totes les pantalles tinguin el menu drawer tots els layouts

                R.id.bottom1Fragment, R.id.bottom2Fragment,R.id.bottom3Fragment

                ,R.id.drawer1Fragment, R.id.drawer2Fragment,R.id.drawer3Fragment

                ,R.id.options1Fragment, R.id.options2Fragment,R.id.options3Fragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();

        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        //Nova linea afegida OptionsActivity
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

    }

    //Java agafat de TabbedActivity i OptionsActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    //Java agafat de OptionsActivity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

}
