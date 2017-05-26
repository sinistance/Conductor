package com.bluelinelabs.conductor.internal;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bluelinelabs.conductor.LifecycleHandlerProvider;

class FragmentLifecycleHandlerProvider implements LifecycleHandlerProvider {

    private static final String FRAGMENT_TAG = "LifecycleHandlerComponent";

    @Override
    public LifecycleHandler install(@NonNull Activity activity) {
        FragmentLifecycleHandlerComponent component = new FragmentLifecycleHandlerComponent();
        activity.getFragmentManager().beginTransaction().add(component, FRAGMENT_TAG).commit();
        return component.getLifecycleHandler();
    }

    @Nullable
    @Override
    public LifecycleHandler findInActivity(@NonNull Activity activity) {
        LifecycleHandlerComponent component = (LifecycleHandlerComponent) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (component != null) {
            return component.getLifecycleHandler();
        } else {
            return null;
        }
    }

}
