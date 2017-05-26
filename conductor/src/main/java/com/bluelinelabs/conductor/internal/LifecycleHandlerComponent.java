package com.bluelinelabs.conductor.internal;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface LifecycleHandlerComponent {
    @NonNull
    LifecycleHandler getLifecycleHandler();
    void startActivity(@NonNull Intent intent);
    void startActivityForResult(@NonNull Intent intent, int requestCode, @Nullable Bundle options);
    void startIntentSenderForResult(@NonNull IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException;
    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);
    void doRequestPermissions(@NonNull String[] permissions, int requestCode);
    void invalidateOptionsMenu();
}
