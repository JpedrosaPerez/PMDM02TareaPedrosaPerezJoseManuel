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
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.Snackbar;

import pedrosaperez.josemanuel.databinding.ActivityMainBinding;

/**
 * Actividad principal del videojuego que gestiona la navegación y la interacción del usuario con el menú lateral (Drawer).
 * Incluye integración con NavController, manejo de un NavigationView y muestra detalles sobre los personajes del juego.
 *
 * @author [Jose Manuel Pedrosa Perez]
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /** Controlador del menú lateral (Drawer). */
    private ActionBarDrawerToggle toggle;

    /** Controlador de navegación que gestiona los fragmentos. */
    private NavController navController;

    /** Objeto para manejar el enlace con las vistas definidas en el layout. */
    private ActivityMainBinding binding;

    /**
     * Método que se ejecuta al crear la actividad. Configura la navegación y el menú lateral.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad, si existe.
     */
    @Override
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

    /**
     * Cambia la configuración del indicador del menú lateral según el destino de navegación actual.
     *
     * @param navController El controlador de navegación.
     * @param navDestination El destino de navegación actual.
     * @param bundle Datos adicionales que pueden pasarse entre destinos, si aplica.
     */
    private void onChangeImageView(NavController navController, NavDestination navDestination, Bundle bundle) {
        if (toggle == null) return;

        if (navDestination.getId() == R.id.person_Recyclerview) {
            toggle.setDrawerIndicatorEnabled(true);
        } else {
            toggle.setDrawerIndicatorEnabled(false);
        }
    }

    /**
     * Configura el menú lateral (Drawer) y su interacción con el ActionBar.
     */
    private void configureToggleMenu() {
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Maneja el clic en un personaje del juego y navega al detalle del mismo.
     *
     * @param person El personaje seleccionado.
     * @param view La vista desde la que se seleccionó el personaje.
     */
    public void gameClicked(DataPerson person, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", person.getName());
        bundle.putInt("image", person.getImage());
        bundle.putString("description", person.getDescription());
        bundle.putString("skills", person.getSkills());

        Navigation.findNavController(view).navigate(R.id.personDetailFragment, bundle);
    }

    /**
     * Permite manejar el botón de navegación hacia arriba en el ActionBar.
     *
     * @return {@code true} si la navegación hacia arriba es manejada correctamente; de lo contrario, delega al padre.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    /**
     * Infla el menú en el ActionBar.
     *
     * @param menu El menú a inflar.
     * @return {@code true} si el menú fue inflado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja las acciones seleccionadas en el menú.
     *
     * @param item El elemento del menú seleccionado.
     * @return {@code true} si la acción fue manejada; de lo contrario, delega al padre.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.about) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.about))
                    .setIcon(R.drawable.mario)
                    .setMessage(getString(R.string.about_text))
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un mensaje al usuario cuando la actividad se inicia.
     */
    @Override
    public void onStart() {
        super.onStart();
        Snackbar.make(binding.getRoot(), getString(R.string.snack_text), Snackbar.LENGTH_SHORT).show();
    }
}
