package com.bluelinelabs.conductor;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bluelinelabs.conductor.internal.LifecycleHandler;

public interface LifecycleHandlerProvider {
    LifecycleHandler install(@NonNull Activity activity);
    @Nullable
    LifecycleHandler findInActivity(@NonNull Activity activity);
}
