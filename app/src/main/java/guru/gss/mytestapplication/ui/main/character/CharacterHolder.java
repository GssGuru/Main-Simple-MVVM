package guru.gss.mytestapplication.ui.main.character;

import android.support.v7.widget.RecyclerView;

import guru.gss.mytestapplication.databinding.ItemPositionBinding;
import guru.gss.mytestapplication.utils.models.Character;

public class CharacterHolder extends RecyclerView.ViewHolder {

    ItemPositionBinding binding;

    public CharacterHolder(ItemPositionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Character character) {
        binding.setCharacter(character);
        binding.executePendingBindings();
    }

}
