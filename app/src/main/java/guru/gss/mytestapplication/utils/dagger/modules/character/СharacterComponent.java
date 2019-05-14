package guru.gss.mytestapplication.utils.dagger.modules.character;



import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import guru.gss.mytestapplication.ui.main.character.CharacterFragment;
import guru.gss.mytestapplication.ui.main.navigation.NavigationMenuFragment;
import guru.gss.mytestapplication.utils.dagger.utils.ActivityScope;

@Subcomponent(modules = {СharacterModule.class})
@ActivityScope
public interface СharacterComponent extends AndroidInjector<DaggerApplication> {

    void inject(NavigationMenuFragment fragment);
    void inject(CharacterFragment fragment);

}
