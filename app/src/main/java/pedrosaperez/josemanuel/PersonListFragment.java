package pedrosaperez.josemanuel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import pedrosaperez.josemanuel.databinding.PersonListFragmentBinding;

/**
 * Fragmento que muestra una lista de personajes en un RecyclerView.
 * Permite visualizar información básica de los personajes, como su imagen, nombre, descripción y habilidades.
 *
 * @author [Jose Manuel Pedrosa Perez]
 * @version 1.0
 */
public class PersonListFragment extends Fragment {

    /** Binding para acceder a las vistas del layout de este fragmento. */
    private PersonListFragmentBinding binding;

    /** Lista de personajes que se mostrarán en el RecyclerView. */
    private ArrayList<DataPerson> persons;

    /** Adaptador para gestionar los datos y vistas del RecyclerView. */
    private PersonRecyclerViewAdapter adapter;

    /**
     * Infla el layout del fragmento utilizando el binding.
     *
     * @param inflater El inflador de layouts.
     * @param container El contenedor padre donde se añadirá la vista del fragmento.
     * @param savedInstanceState Estado guardado previamente, si existe.
     * @return La vista raíz del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = PersonListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Configura la lógica del fragmento después de que la vista ha sido creada.
     * Inicializa la lista de personajes y configura el RecyclerView.
     *
     * @param view La vista creada para el fragmento.
     * @param savedInstanceState Estado guardado previamente, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadPerson(); // Cargar los personajes

        // Configurar el RecyclerView
        adapter = new PersonRecyclerViewAdapter(persons, getActivity());
        binding.personRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personRecyclerview.setAdapter(adapter);
    }

    /**
     * Método para cargar los personajes que se mostrarán en la lista.
     * Los datos de los personajes son obtenidos de los recursos del proyecto.
     */
    private void loadPerson() {
        persons = new ArrayList<>();
        // Llenar la lista con datos de personajes
        persons.add(new DataPerson(R.drawable.mario, getString(R.string.mario_name), getString(R.string.mario_description), getString(R.string.mario_skills)));
        persons.add(new DataPerson(R.drawable.luigi, getString(R.string.luigi_name), getString(R.string.luigi_description), getString(R.string.luigi_skills)));
        persons.add(new DataPerson(R.drawable.peach, getString(R.string.peach_name), getString(R.string.peach_description), getString(R.string.peach_skills)));
        persons.add(new DataPerson(R.drawable.toad, getString(R.string.toad_name), getString(R.string.toad_description), getString(R.string.toad_skills)));
        persons.add(new DataPerson(R.drawable.toadette, getString(R.string.toadette_name), getString(R.string.toadette_description), getString(R.string.toadette_skills)));
        persons.add(new DataPerson(R.drawable.bowser, getString(R.string.bowser_name), getString(R.string.bowser_description), getString(R.string.bowser_skills)));
    }
}
