package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import p000.ExecutorC0582c6;

/* loaded from: classes.dex */
public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;

    /* renamed from: a */
    public static final C0454b f6904a = new Object();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface DiagnosticCode {
    }

    /* loaded from: classes.dex */
    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int i, @Nullable Object obj);

        void onResultReceived(int i, @Nullable Object obj);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ResultCode {
    }

    /* renamed from: a */
    public static void m1599a(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m1600b(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback, boolean z) {
        boolean write;
        boolean z2;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z3 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long readLong = dataInputStream.readLong();
                            dataInputStream.close();
                            if (readLong == packageInfo.lastUpdateTime) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                diagnosticsCallback.onResultReceived(2, null);
                            }
                        } finally {
                        }
                    } catch (IOException unused) {
                    }
                    if (z2) {
                        Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                        ProfileVerifier.m1603c(context, false);
                        return;
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assets, executor, diagnosticsCallback, name, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof"));
            if (!deviceProfileWriter.deviceAllowsProfileInstallerAotWrites()) {
                write = false;
            } else {
                write = deviceProfileWriter.read().transcodeIfNeeded().write();
                if (write) {
                    m1599a(packageInfo, filesDir);
                }
            }
            if (write && z) {
                z3 = true;
            }
            ProfileVerifier.m1603c(context, z3);
        } catch (PackageManager.NameNotFoundException e) {
            diagnosticsCallback.onResultReceived(7, e);
            ProfileVerifier.m1603c(context, false);
        }
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context) {
        writeProfile(context, new ExecutorC0582c6(0), f6904a);
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        m1600b(context, executor, diagnosticsCallback, false);
    }
}
