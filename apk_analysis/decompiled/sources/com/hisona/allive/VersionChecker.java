package com.hisona.allive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes2.dex */
public class VersionChecker {
    public static c0 c;
    public static String d;
    public static String e;
    public static String f;
    public final Activity a;
    public String b;

    public VersionChecker(Activity activity) {
        this.a = activity;
        FirebaseAnalytics.getInstance(activity);
        try {
            d = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean checkPermission(Activity activity) {
        boolean z;
        boolean z2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            z = activity.getPackageManager().canRequestPackageInstalls();
        } else {
            z = true;
        }
        if (i == 23 && (activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0 || activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && z2) {
            return true;
        }
        return false;
    }

    public static String getStringById(Context context, int i) {
        return context.getResources().getString(i);
    }

    public static boolean requestPermission(Activity activity) {
        boolean z;
        boolean z2;
        boolean canRequestPackageInstalls;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            canRequestPackageInstalls = activity.getPackageManager().canRequestPackageInstalls();
            if (!canRequestPackageInstalls) {
                activity.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES").setData(Uri.parse("package:" + activity.getPackageName())), 999);
                z = false;
                if (i != 23 && (activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0 || activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
                    if (activity.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        Toast.makeText(activity, activity.getResources().getString(R.string.storage_permission_str), 0).show();
                    }
                    activity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 2);
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z && z2) {
                    return true;
                }
            }
        }
        z = true;
        if (i != 23) {
        }
        z2 = true;
        return !z ? false : false;
    }

    public void cancel() {
        c.cancel();
    }

    public void check() {
        new d0(this.a, this.b).execute();
    }

    public void setcheckJsonUrl(String str) {
        this.b = str;
    }
}
