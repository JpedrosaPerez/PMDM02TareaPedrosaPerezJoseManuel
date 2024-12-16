package pedrosaperez.josemanuel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pedrosaperez.josemanuel.databinding.PersonCardviewBinding;

/**
 * Adaptador personalizado para un RecyclerView que muestra una lista de personajes.
 * Gestiona la creación y vinculación de los ViewHolders con los datos de los personajes.
 *
 * @author [Jose Manuel Pedrosa Perez]
 * @version 1.0
 */
public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    /** Lista de personajes a mostrar en el RecyclerView. */
    private final ArrayList<DataPerson> persons;

    /** Contexto de la actividad que utiliza el adaptador. */
    private final Context context;

    /**
     * Constructor del adaptador.
     *
     * @param person Lista de personajes que se mostrarán.
     * @param context Contexto de la actividad que usa este adaptador.
     */
    public PersonRecyclerViewAdapter(ArrayList<DataPerson> person, Context context) {
        this.persons = person;
        this.context = context;
    }

    /**
     * Crea un nuevo ViewHolder inflando el layout correspondiente.
     *
     * @param parent Vista padre del RecyclerView.
     * @param viewType Tipo de vista (en este caso, único).
     * @return Un nuevo {@link PersonViewHolder}.
     */
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonCardviewBinding binding = PersonCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PersonViewHolder(binding);
    }

    /**
     * Vincula los datos de un personaje específico con el ViewHolder.
     *
     * @param holder El ViewHolder que contendrá los datos.
     * @param position La posición del elemento en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        DataPerson currentPerson = this.persons.get(position);
        holder.bind(currentPerson);

        // Manejar el evento de clic en el elemento
        holder.itemView.setOnClickListener(view -> itemClicked(currentPerson, view));
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return El tamaño de la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return persons.size();
    }

    /**
     * Maneja el evento de clic en un elemento de la lista.
     * Navega al detalle del personaje utilizando un método de la actividad principal.
     *
     * @param currentPerson El personaje que se ha seleccionado.
     * @param view La vista en la que se hizo clic.
     */
    private void itemClicked(DataPerson currentPerson, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).gameClicked(currentPerson, view);
    }
}
