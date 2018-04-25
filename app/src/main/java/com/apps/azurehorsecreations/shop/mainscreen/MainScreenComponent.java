package com.apps.azurehorsecreations.shop.mainscreen;

import com.apps.azurehorsecreations.shop.MainActivity;
import com.apps.azurehorsecreations.shop.data.component.NetComponent;
import com.apps.azurehorsecreations.shop.util.CustomScope;

import dagger.Component;

/**
 * Created by pattycase on 4/24/18.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
