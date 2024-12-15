package pedrosaperez.josemanuel;

import androidx.recyclerview.widget.RecyclerView;

import pedrosaperez.josemanuel.databinding.PersonCardviewBinding;

/**
 * ViewHolder personalizado para gestionar los elementos del RecyclerView que muestran datos de personajes.
 * Utiliza Data Binding para acceder y actualizar los componentes de la interfaz en cada elemento.
 *
 * @author [Jose Manuel Pedrosa Perez]
 * @version 1.0
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {

    /** Enlace de datos generado para el diseño del CardView. */
    private final PersonCardviewBinding binding;

    /**
     * Constructor de la clase ViewHolder.
     *
     * @param binding Instancia de {@link PersonCardviewBinding} generada por Data Binding
     *                para acceder a los componentes del layout.
     */
    public PersonViewHolder(PersonCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un personaje a los componentes de la vista.
     *
     * @param person Objeto {@link DataPerson} que contiene los datos del personaje.
     */
    public void bind(DataPerson person) {
        // Asignar datos a los componentes del layout
        binding.name.setText(person.getName());
        binding.image.setImageResource(person.getImage());
        binding.executePendingBindings(); // Asegura que los cambios se reflejen de inmediato
    }
}


