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

public class PersonListFragment extends Fragment {

    private PersonListFragmentBinding binding; // Binding para el layout
    private ArrayList<DataPerson>  persons; // Lista de juegos
    private PersonRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = PersonListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadPerson(); // Cargar los personajes (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new PersonRecyclerViewAdapter(persons, getActivity());
        binding.personRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personRecyclerview.setAdapter(adapter);


    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private void loadPerson() {
        persons = new ArrayList<DataPerson>();
        // Llenar la lista con datos de videojuegos
        persons.add(new DataPerson(R.drawable.mario, getString(R.string.mario_name),getString(R.string.mario_description), getString(R.string.mario_skills)));
        persons.add(new DataPerson(R.drawable.luigi,getString(R.string.luigi_name),getString(R.string.luigi_description), getString(R.string.luigi_skills)));
        persons.add(new DataPerson(R.drawable.peach, getString(R.string.peach_name),getString(R.string.peach_description), getString(R.string.peach_skills)));
        persons.add(new DataPerson(R.drawable.toad, getString(R.string.toad_name),getString(R.string.toad_description), getString(R.string.toad_skills)));
        persons.add(new DataPerson(R.drawable.toadette, getString(R.string.toadette_name),getString(R.string.toadette_description), getString(R.string.toadette_skills)));
        persons.add(new DataPerson(R.drawable.bowser,getString(R.string.bowser_name),getString(R.string.bowser_description), getString(R.string.bowser_skills)));
    }





}
