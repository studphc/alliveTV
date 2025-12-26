package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import p000.ExecutorC0582c6;
import p000.p63;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    @NonNull
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";

    @NonNull
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";

    @NonNull
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";

    @NonNull
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        Bundle extras;
        File cacheDir;
        Context createDeviceProtectedStorageContext;
        Context createDeviceProtectedStorageContext2;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (ACTION_INSTALL_PROFILE.equals(action)) {
            ProfileInstaller.m1600b(context, new ExecutorC0582c6(0), new C0453a(this), true);
            return;
        }
        if (ACTION_SKIP_FILE.equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    C0453a c0453a = new C0453a(this);
                    try {
                        ProfileInstaller.m1599a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                        c0453a.onResultReceived(10, null);
                        return;
                    } catch (PackageManager.NameNotFoundException e) {
                        c0453a.onResultReceived(7, e);
                        return;
                    }
                }
                if ("DELETE_SKIP_FILE".equals(string)) {
                    new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                    Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                    setResultCode(11);
                    return;
                }
                return;
            }
            return;
        }
        if (ACTION_SAVE_PROFILE.equals(action)) {
            C0453a c0453a2 = new C0453a(this);
            if (Build.VERSION.SDK_INT >= 24) {
                Process.sendSignal(Process.myPid(), 10);
                c0453a2.onResultReceived(12, null);
                return;
            } else {
                c0453a2.onResultReceived(13, null);
                return;
            }
        }
        if (ACTION_BENCHMARK_OPERATION.equals(action) && (extras = intent.getExtras()) != null) {
            String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
            C0453a c0453a3 = new C0453a(this);
            if ("DROP_SHADER_CACHE".equals(string2)) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 34) {
                    createDeviceProtectedStorageContext2 = context.createDeviceProtectedStorageContext();
                    cacheDir = createDeviceProtectedStorageContext2.getCacheDir();
                } else if (i >= 24) {
                    createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                    cacheDir = createDeviceProtectedStorageContext.getCodeCacheDir();
                } else if (i == 23) {
                    cacheDir = context.getCodeCacheDir();
                } else {
                    cacheDir = context.getCacheDir();
                }
                if (p63.m6880z(cacheDir)) {
                    c0453a3.onResultReceived(14, null);
                    return;
                } else {
                    c0453a3.onResultReceived(15, null);
                    return;
                }
            }
            c0453a3.onResultReceived(16, null);
        }
    }
}
