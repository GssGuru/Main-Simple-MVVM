package guru.gss.mytestapplication.ui.main.navigation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import javax.inject.Inject;

import guru.gss.mytestapplication.R;
import guru.gss.mytestapplication.model.interactors.Interactor;
import guru.gss.mytestapplication.ui.main.character.CharacterFragment;
import guru.gss.mytestapplication.utils.dagger.modules.character.СharacterModule;
import guru.gss.mytestapplication.utils.dagger.utils.Injectors;

public class NavigationMenuFragment extends Fragment {

    @Inject
    Interactor.CharacterInteractor model;

    String[] data = {"Dead", "Alive", "All"};

    public NavigationMenuFragment() { }

    public static NavigationMenuFragment newInstance() {
        NavigationMenuFragment fragment = new NavigationMenuFragment();
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
        View v = inflater.inflate(R.layout.fragment_navigation_menu, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner)v.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Show");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Position = " + position  + ", Data = " + data[position], Toast.LENGTH_SHORT).show();
                mListener.setFragment(CharacterFragment.newInstance());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
        return v;
    }


    private OnFragmentInteractionListener mListener;
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.setFragment(CharacterFragment.newInstance());
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
        void setFragment(Fragment fragment);
    }
}
