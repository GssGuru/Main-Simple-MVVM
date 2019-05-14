package guru.gss.mytestapplication.ui.main.character;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import javax.inject.Inject;

import guru.gss.mytestapplication.R;
import guru.gss.mytestapplication.model.interactors.Interactor;
import guru.gss.mytestapplication.utils.dagger.modules.character.СharacterModule;
import guru.gss.mytestapplication.utils.dagger.utils.Injectors;

public class CharacterFragment extends Fragment {

    @Inject
    Interactor.Сharacter model;

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

        View v = inflater.inflate(R.layout.fragment_character, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_character_animation);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        adapter = new Adapter(getContext());
//        recyclerView.setAdapter(adapter);

        Toolbar mToolbar = v.findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        mToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.openDrover();
                }
            }
        });

        mToolbar.setTitle("Character");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorIcons));

        return v;
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
