package com.bluelinelabs.conductor.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class FragmentLifecycleHandlerComponent extends Fragment implements LifecycleHandlerComponent {

    private final LifecycleHandler lifecycleHandler;

    public FragmentLifecycleHandlerComponent() {
        setRetainInstance(true);
        setHasOptionsMenu(true);
        lifecycleHandler = new LifecycleHandler(this);
    }

    @NonNull
    @Override
    public LifecycleHandler getLifecycleHandler() {
        return lifecycleHandler;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleHandler.restoreState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleHandler.saveState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycleHandler.onDestroy();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        lifecycleHandler.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lifecycleHandler.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        lifecycleHandler.onDetach();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lifecycleHandler.onActivityResult(requestCode, resultCode, data);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void doRequestPermissions(@NonNull String[] permissions, int requestCode) {
        requestPermissions(permissions, requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        lifecycleHandler.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean handled = lifecycleHandler.shouldShowRequestPermissionRationale(permission);
        if (handled != null) {
            return handled;
        } else {
            return super.shouldShowRequestPermissionRationale(permission);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        lifecycleHandler.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        lifecycleHandler.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = lifecycleHandler.onOptionsItemSelected(item);
        return handled || super.onOptionsItemSelected(item);
    }

    @Override
    public void invalidateOptionsMenu() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.invalidateOptionsMenu();
        }
    }

}