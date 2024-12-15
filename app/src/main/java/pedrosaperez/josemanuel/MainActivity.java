package pedrosaperez.josemanuel;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.Snackbar;

import pedrosaperez.josemanuel.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private NavController navController;
    private ActivityMainBinding binding; // Declaramos binding como variable de instancia


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener(this::onChangeImageView);
        NavigationUI.setupActionBarWithNavController(this, navController);
        configureToggleMenu();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Configura el listener para NavigationView
        binding.navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (navController.getCurrentDestination() != null &&
                    navController.getCurrentDestination().getId() != R.id.person_Recyclerview) {
                if (id == R.id.nav_home) {
                    navController.navigate(R.id.personDetailFragment);
                }

            } else if (id == R.id.nav_settings) {
                navController.navigate(R.id.personDetailFragment);
            }

            // Cierra el Drawer después de seleccionar
            binding.drawerLayout.closeDrawer(binding.navView);
            return true;
        });
    }


    private void onChangeImageView(NavController navController, NavDestination navDestination, Bundle bundle){
        if(toggle == null) return;

        if(navDestination.getId()==R.id.person_Recyclerview){
            toggle.setDrawerIndicatorEnabled(true);
        }else{
            toggle.setDrawerIndicatorEnabled(false);
        }


    }
    private void configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    // Método para manejar el clic en un juego
    public void gameClicked(DataPerson person, View view) {
        // Crear un Bundle para pasar los datos al GameDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", person.getName()); // Pasa el nombre del juego
        bundle.putInt("image", person.getImage()); // Pasa la imagen del juego
        bundle.putString("description", person.getDescription());
        bundle.putString("skills",person.getSkills());// Pasa la descripción o más datos que necesites

        // Navegar al GameDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.personDetailFragment, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú; agrega elementos al ActionBar si está presente
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.about) {
            new AlertDialog.Builder(this) // 'this' se refiere al contexto de la Activity
                    .setTitle(getString(R.string.about))
                    .setIcon(R.drawable.mario)
                    .setMessage(getString(R.string.about_text))
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
public void onStart(){
        super.onStart();
    Snackbar.make(binding.getRoot(),getString(R.string.snack_text),Snackbar.LENGTH_SHORT).show();

}


}