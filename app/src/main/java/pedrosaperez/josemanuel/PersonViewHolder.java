package pedrosaperez.josemanuel;

import androidx.recyclerview.widget.RecyclerView;

import pedrosaperez.josemanuel.databinding.PersonCardviewBinding;


public class PersonViewHolder extends RecyclerView.ViewHolder {

    private final PersonCardviewBinding binding;

    public PersonViewHolder(PersonCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (DataPerson person){

        binding.name.setText(person.getName());
        binding.image.setImageResource(person.getImage());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}

