package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import p000.AbstractC1534m3;
import p000.gm1;
import p000.hm1;
import p000.km1;

/* loaded from: classes.dex */
public final class MediaSessionManager {

    /* renamed from: b */
    public static final boolean f6673b = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: c */
    public static final Object f6674c = new Object();

    /* renamed from: d */
    public static volatile MediaSessionManager f6675d;

    /* renamed from: a */
    public gm1 f6676a;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, androidx.media.MediaSessionManager] */
    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager;
        if (context != null) {
            synchronized (f6674c) {
                try {
                    if (f6675d == null) {
                        Context applicationContext = context.getApplicationContext();
                        ?? obj = new Object();
                        if (Build.VERSION.SDK_INT >= 28) {
                            gm1 gm1Var = new gm1(applicationContext);
                            obj.f6676a = gm1Var;
                        } else {
                            obj.f6676a = new gm1(applicationContext);
                        }
                        f6675d = obj;
                    }
                    mediaSessionManager = f6675d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return mediaSessionManager;
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.f6676a.mo4815a(remoteUserInfo.f6677a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    /* loaded from: classes.dex */
    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int UNKNOWN_PID = -1;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int UNKNOWN_UID = -1;

        /* renamed from: a */
        public final km1 f6677a;

        public RemoteUserInfo(@NonNull String str, int i, int i2) {
            if (str != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        km1 km1Var = new km1(str, i, i2);
                        hm1.m5113u(i, i2, str);
                        this.f6677a = km1Var;
                        return;
                    }
                    this.f6677a = new km1(str, i, i2);
                    return;
                }
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            throw new NullPointerException("package shouldn't be null");
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.f6677a.equals(((RemoteUserInfo) obj).f6677a);
        }

        @NonNull
        public String getPackageName() {
            return this.f6677a.f20897a;
        }

        public int getPid() {
            return this.f6677a.f20898b;
        }

        public int getUid() {
            return this.f6677a.f20899c;
        }

        public int hashCode() {
            return this.f6677a.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String m6033o = AbstractC1534m3.m6033o(remoteUserInfo);
            if (m6033o != null) {
                if (!TextUtils.isEmpty(m6033o)) {
                    this.f6677a = new km1(AbstractC1534m3.m6033o(remoteUserInfo), AbstractC1534m3.m6019a(remoteUserInfo), AbstractC1534m3.m6041w(remoteUserInfo));
                    return;
                }
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            throw new NullPointerException("package shouldn't be null");
        }
    }
}
