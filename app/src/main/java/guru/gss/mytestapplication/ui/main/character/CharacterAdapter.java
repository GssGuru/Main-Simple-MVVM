package guru.gss.mytestapplication.ui.main.character;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import guru.gss.mytestapplication.R;
import guru.gss.mytestapplication.databinding.ItemPositionBinding;
import guru.gss.mytestapplication.utils.models.Character;

/*Simple adapter for News*/
public class CharacterAdapter extends RecyclerView.Adapter<CharacterHolder> {

    private ArrayList<Character> list = new ArrayList<>();

    public void setData(ArrayList<Character> list) {
        this.list.clear();
        this.list.addAll(list);
    }

    void addData(ArrayList<Character> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPositionBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_position, parent, false);
        return new CharacterHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}