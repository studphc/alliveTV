package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.r72;
import p000.s72;

/* loaded from: classes.dex */
public final class ProfileVerifier {

    /* renamed from: a */
    public static final ResolvableFuture f6905a = ResolvableFuture.create();

    /* renamed from: b */
    public static final Object f6906b = new Object();

    /* renamed from: c */
    public static CompilationStatus f6907c = null;

    /* loaded from: classes.dex */
    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;

        /* renamed from: RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE */
        public static final int f6908xf2722a21 = 196608;
        public static final int RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED = 327680;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;

        @Deprecated
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_NO_PROFILE_INSTALLED = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;

        /* renamed from: a */
        public final int f6909a;

        /* renamed from: b */
        public final boolean f6910b;

        /* renamed from: c */
        public final boolean f6911c;

        /* renamed from: d */
        public final boolean f6912d;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface ResultCode {
        }

        public CompilationStatus(int i, boolean z, boolean z2, boolean z3) {
            this.f6909a = i;
            this.f6911c = z2;
            this.f6910b = z;
            this.f6912d = z3;
        }

        public boolean appApkHasEmbeddedProfile() {
            return this.f6912d;
        }

        public int getProfileInstallResultCode() {
            return this.f6909a;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.f6911c;
        }

        public boolean isCompiledWithProfile() {
            return this.f6910b;
        }
    }

    /* renamed from: a */
    public static long m1601a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return r72.m7227a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    /* renamed from: b */
    public static CompilationStatus m1602b(int i, boolean z, boolean z2, boolean z3) {
        CompilationStatus compilationStatus = new CompilationStatus(i, z, z2, z3);
        f6907c = compilationStatus;
        f6905a.set(compilationStatus);
        return f6907c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:23|(1:89)(1:27)|28|(1:88)(1:32)|33|34|35|(2:74|75)(1:37)|38|(8:45|(1:49)|(1:56)|57|(2:64|65)|61|62|63)|(1:71)(1:(1:73))|(1:49)|(3:51|54|56)|57|(1:59)|64|65|61|62|63) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fd, code lost:
    
        r5 = androidx.profileinstaller.ProfileVerifier.CompilationStatus.f6908xf2722a21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
    
        r5 = androidx.profileinstaller.ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CompilationStatus m1603c(Context context, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        s72 m7346a;
        s72 s72Var;
        int i;
        CompilationStatus compilationStatus;
        if (!z && (compilationStatus = f6907c) != null) {
            return compilationStatus;
        }
        synchronized (f6906b) {
            if (!z) {
                CompilationStatus compilationStatus2 = f6907c;
                if (compilationStatus2 != null) {
                    return compilationStatus2;
                }
            }
            int i2 = 0;
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd("dexopt/baseline.prof");
                try {
                    if (openFd.getLength() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    openFd.close();
                } finally {
                }
            } catch (IOException unused) {
                z2 = false;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28 && i3 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                if (file.exists() && length > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                if (file2.exists() && length2 > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                try {
                    long m1601a = m1601a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            m7346a = s72.m7346a(file3);
                        } catch (IOException unused2) {
                            return m1602b(131072, z3, z4, z2);
                        }
                    } else {
                        m7346a = null;
                    }
                    if (m7346a != null && m7346a.f26309c == m1601a && (i = m7346a.f26308b) != 2) {
                        i2 = i;
                        if (z && z4 && i2 != 1) {
                            i2 = 2;
                        }
                        if (m7346a != null && m7346a.f26308b == 2 && i2 == 1 && length < m7346a.f26310d) {
                            i2 = 3;
                        }
                        s72Var = new s72(1, m1601a, i2, length2);
                        if (m7346a != null || !m7346a.equals(s72Var)) {
                            s72Var.m7347b(file3);
                        }
                        return m1602b(i2, z3, z4, z2);
                    }
                    if (z3) {
                        i2 = 1;
                    } else if (z4) {
                        i2 = 2;
                    }
                    if (z) {
                        i2 = 2;
                    }
                    if (m7346a != null) {
                        i2 = 3;
                    }
                    s72Var = new s72(1, m1601a, i2, length2);
                    if (m7346a != null) {
                    }
                    s72Var.m7347b(file3);
                    return m1602b(i2, z3, z4, z2);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return m1602b(65536, z3, z4, z2);
                }
            }
            return m1602b(262144, false, false, z2);
        }
    }

    @NonNull
    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return f6905a;
    }

    @NonNull
    @WorkerThread
    public static CompilationStatus writeProfileVerification(@NonNull Context context) {
        return m1603c(context, false);
    }
}
