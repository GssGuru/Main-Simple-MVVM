package guru.gss.mytestapplication.ui.main.character;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import guru.gss.mytestapplication.R;
import guru.gss.mytestapplication.databinding.FragmentCharacterBinding;
import guru.gss.mytestapplication.model.interactors.Interactor;
import guru.gss.mytestapplication.utils.dagger.modules.character.СharacterModule;
import guru.gss.mytestapplication.utils.dagger.utils.Injectors;

public class CharacterFragment extends Fragment {

    @Inject
    Interactor.CharacterInteractor model;

    public CharacterFragment() {}

    public static CharacterFragment newInstance() {
        CharacterFragment fragment = new CharacterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injectors.get(getActivity()).plus(new СharacterModule()).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentCharacterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character, container, false);
        View view = binding.getRoot();
//        binding.setCharacters(model);


//        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
//        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_character_animation);
//        recyclerView.setLayoutAnimation(animation);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        CharacterAdapter adapter = new CharacterAdapter();
//        recyclerView.setAdapter(adapter);
//
//        Toolbar mToolbar = v.findViewById(R.id.toolbar);
//        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//        mToolbar.setNavigationIcon(R.drawable.ic_menu);
//        mToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mListener != null) {
//                    mListener.openDrover();
//                }
//            }
//        });
//
//        mToolbar.setTitle("CharacterInteractor");
//        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorIcons));
//
//        model.getList(0).;

        return view;
    }

    private OnFragmentInteractionListener mListener;

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.openDrover();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void openDrover();
    }
}
