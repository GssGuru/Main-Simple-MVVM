package guru.gss.mytestapplication.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import guru.gss.mytestapplication.R;
import guru.gss.mytestapplication.ui.BaseActivity;
import guru.gss.mytestapplication.ui.main.character.CharacterFragment;
import guru.gss.mytestapplication.ui.main.navigation.NavigationMenuFragment;

public class MainActivity extends BaseActivity implements
        NavigationMenuFragment.OnFragmentInteractionListener, CharacterFragment.OnFragmentInteractionListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        setFragment(NavigationMenuFragment.newInstance(), R.id.conteinerFragmentNavigationMenu);

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setFragment(Fragment fragment) {
        setFragment(fragment, R.id.conteinerFragmentMain);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void openDrover() {
        drawer.openDrawer(GravityCompat.START);
    }
}
