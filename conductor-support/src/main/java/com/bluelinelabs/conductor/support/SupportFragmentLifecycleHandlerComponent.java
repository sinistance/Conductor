package com.bluelinelabs.conductor.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bluelinelabs.conductor.internal.LifecycleHandler;
import com.bluelinelabs.conductor.internal.LifecycleHandlerComponent;

public class SupportFragmentLifecycleHandlerComponent extends Fragment implements LifecycleHandlerComponent {

    private final LifecycleHandler lifecycleHandler;

    public SupportFragmentLifecycleHandlerComponent() {
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
        Activity activity = getActivity();
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
    }
}