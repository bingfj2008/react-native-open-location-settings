package com.openlocationsettings.module.android.location;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.net.Uri;
import android.os.Build;
import android.webkit.ConsoleMessage;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class LocationModule extends ReactContextBaseJavaModule {

    /* constructor */
    public LocationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        /**
         * return the string name of the NativeModule which represents this class in JavaScript
         * In JS access this module through React.NativeModules.LocationServicesUtil
         */
        return "LocationModule";
    }

    /**
     * TEST
     * @param callback
     */
    @ReactMethod
    public void test(Callback callback) {
        callback.invoke("aaaaaaaaaaaaaaaaaaa");
//        callback.invoke(Context.getPackageName(), BuildConfig.APPLICATION_ID);
    }

    /**
     * チェック
     * @param callback
     */
    @ReactMethod
    public void checkLocationServicesStatus(Callback callback) {
        callback.invoke("aaaaaaaaaaaaaaaaaaa");
    }

    /**
     * ANDROID OS の位置情報設定画面を開く
     * @param callback
     */
    @ReactMethod
    public void openSystemLocationSettings(Callback callback) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke("error");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            currentActivity.startActivity(intent);
            callback.invoke("");
        } catch (Exception e) {
            callback.invoke(e.getMessage());
        }
    }

    /**
     * APP
     * @param callback
     */
    @ReactMethod
    public void openAppLocationSettings(Callback callback) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke("error");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.fromParts("package", "com.openlocationsettings", null));
            currentActivity.startActivity(intent);
            callback.invoke("");
        } catch (Exception e) {
            callback.invoke(e.getMessage());
        }
    }
}