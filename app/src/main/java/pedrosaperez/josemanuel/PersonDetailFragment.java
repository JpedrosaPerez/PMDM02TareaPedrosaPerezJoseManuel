package pedrosaperez.josemanuel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import pedrosaperez.josemanuel.databinding.PersonDetailFragmentBinding;

/**
 * Fragmento que muestra los detalles de un personaje del videojuego.
 * Se utiliza para visualizar información específica como la imagen, el nombre, la descripción y las habilidades del personaje.
 *
 * @author [Jose Manuel Pedrosa Perez]
 * @version 1.0
 */
public class PersonDetailFragment extends Fragment {

    /** Objeto de enlace para acceder a las vistas del layout de este fragmento. */
    private PersonDetailFragmentBinding binding;

    /**
     * Crea e infla la vista asociada al fragmento.
     *
     * @param inflater El inflador de layouts.
     * @param container El contenedor padre del fragmento.
     * @param savedInstanceState Estado guardado previamente, si existe.
     * @return La vista raíz del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = PersonDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método que se ejecuta después de que la vista ha sido creada.
     * Configura los datos obtenidos de los argumentos y los asigna a las vistas correspondientes.
     *
     * @param view La vista creada para el fragmento.
     * @param savedInstanceState Estado guardado previamente, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos de los argumentos que inician este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skills = getArguments().getString("skills");

            // Asignar los datos a los componentes de la interfaz
            binding.name.setText(name);
            binding.image.setImageResource(image);
            binding.description.setText(description);
            binding.skills.setText(skills);
        }
    }

    /**
     * Método que se ejecuta al iniciar el fragmento.
     * Cambia el título del ActionBar y muestra un mensaje Toast con el nombre del personaje.
     */
    @Override
    public void onStart() {
        super.onStart();

        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Detalles del juego");
        }

        // Muestra un mensaje Toast con el nombre del personaje
        if (getArguments() != null) {
            String name = getArguments().getString("name");
            Toast.makeText(getContext(), getString(R.string.toast_text) + " " + name, Toast.LENGTH_SHORT).show();
        }
    }
}
