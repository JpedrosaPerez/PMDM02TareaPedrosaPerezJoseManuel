package pedrosaperez.josemanuel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pedrosaperez.josemanuel.databinding.PersonCardviewBinding;


public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final ArrayList<DataPerson> persons;
    private final Context context;

    public PersonRecyclerViewAdapter(ArrayList<DataPerson> person, Context context){
        this.persons = person;
        this.context = context;
    }

    // Método que crea el ViewHolder
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonCardviewBinding binding = PersonCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new PersonViewHolder(binding);
    }

//    Método para enlazar datos con ek ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        DataPerson currentPerson = this.persons.get(position);
        holder.bind(currentPerson);

//        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentPerson, view));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    private void itemClicked(DataPerson currentGame, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).gameClicked(currentGame, view);
    }
}

