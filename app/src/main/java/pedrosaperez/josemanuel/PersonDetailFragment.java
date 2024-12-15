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

public class PersonDetailFragment extends Fragment {

    private PersonDetailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = PersonDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skills = getArguments().getString("skills");

            // Asignar los datos a los componentes

            binding.name.setText(name);
            binding.image.setImageResource(image);
            binding.description.setText(description);
            binding.skills.setText(skills);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Detalles del juego");
        }
        String name = getArguments().getString("name");
        //binding.name.setText(name);

        Toast.makeText( getContext(),getString(R.string.toast_text) +" "+ name, Toast.LENGTH_SHORT).show();

    }
}
