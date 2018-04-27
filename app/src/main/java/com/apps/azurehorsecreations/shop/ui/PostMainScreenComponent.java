package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.di.component.NetComponent;
import com.apps.azurehorsecreations.shop.di.scope.CustomScope;
import dagger.Component;

/**
 * Created by pattycase on 4/24/18.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = PostMainScreenModule.class)
public interface PostMainScreenComponent {
    void inject(MainActivity activity);
}
