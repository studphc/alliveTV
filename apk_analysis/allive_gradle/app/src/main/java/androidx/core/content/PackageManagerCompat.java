package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.Executors;
import p000.RunnableC0006a5;
import p000.u03;
import p000.z70;

/* loaded from: classes.dex */
public final class PackageManagerCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface UnusedAppRestrictionsStatus {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager packageManager) {
        boolean z;
        boolean z2;
        boolean z3;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            z = true;
        } else {
            z = false;
        }
        if (i < 30) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (getPermissionRevocationVerifierApp(packageManager) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z && (!z2 || !z3)) {
            return false;
        }
        return true;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager packageManager) {
        String str = null;
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @NonNull
    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(@NonNull Context context) {
        ResolvableFuture create = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            create.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return create;
        }
        if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            create.set(1);
            return create;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (i < 30) {
            create.set(0);
            Log.e(LOG_TAG, "Target SDK version below API 30");
            return create;
        }
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 2;
        int i4 = 4;
        if (i2 >= 31) {
            if (z70.m8394a(context)) {
                if (i >= 31) {
                    i4 = 5;
                }
                create.set(Integer.valueOf(i4));
            } else {
                create.set(2);
            }
            return create;
        }
        if (i2 == 30) {
            if (z70.m8394a(context)) {
                i3 = 4;
            }
            create.set(Integer.valueOf(i3));
            return create;
        }
        u03 u03Var = new u03(context);
        create.addListener(new RunnableC0006a5(25, u03Var), Executors.newSingleThreadExecutor());
        if (!u03Var.f27062d) {
            u03Var.f27062d = true;
            u03Var.f27060b = create;
            context.bindService(new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(getPermissionRevocationVerifierApp(context.getPackageManager())), u03Var, 1);
            return create;
        }
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }
}
