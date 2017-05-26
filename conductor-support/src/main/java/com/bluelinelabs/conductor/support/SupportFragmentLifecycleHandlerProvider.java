package com.bluelinelabs.conductor.support;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.bluelinelabs.conductor.LifecycleHandlerProvider;
import com.bluelinelabs.conductor.internal.LifecycleHandler;
import com.bluelinelabs.conductor.internal.LifecycleHandlerComponent;

public class SupportFragmentLifecycleHandlerProvider implements LifecycleHandlerProvider {

    private static final String FRAGMENT_TAG = "LifecycleHandlerComponent";

    private void checkValidActivity(@NonNull Activity activity) {
        if (!(activity instanceof FragmentActivity)) {
            throw new RuntimeException("Must use an instance of FragmentActivity");
        }
    }

    @Override
    public LifecycleHandler install(@NonNull Activity activity) {
        checkValidActivity(activity);
        SupportFragmentLifecycleHandlerComponent component = new SupportFragmentLifecycleHandlerComponent();
        ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().add(component, FRAGMENT_TAG).commit();
        return component.getLifecycleHandler();
    }

    @Nullable
    @Override
    public LifecycleHandler findInActivity(@NonNull Activity activity) {
        checkValidActivity(activity);
        LifecycleHandlerComponent component = (LifecycleHandlerComponent) ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (component != null) {
            return component.getLifecycleHandler();
        } else {
            return null;
        }
    }

}
