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

    /* renamed from: c */
    public static C1069c0 f15959c;

    /* renamed from: d */
    public static String f15960d;

    /* renamed from: e */
    public static String f15961e;

    /* renamed from: f */
    public static String f15962f;

    /* renamed from: a */
    public final Activity f15963a;

    /* renamed from: b */
    public String f15964b;

    public VersionChecker(Activity activity) {
        this.f15963a = activity;
        FirebaseAnalytics.getInstance(activity);
        try {
            f15960d = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
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
        f15959c.cancel();
    }

    public void check() {
        new C1071d0(this.f15963a, this.f15964b).execute();
    }

    public void setcheckJsonUrl(String str) {
        this.f15964b = str;
    }
}
