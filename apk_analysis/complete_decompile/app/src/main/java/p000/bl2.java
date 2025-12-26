package p000;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.SocketAdapter;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class bl2 {
    /* renamed from: a */
    public static boolean m2104a(SocketAdapter socketAdapter, SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return false;
    }

    /* renamed from: b */
    public static X509TrustManager m2105b(SocketAdapter socketAdapter, SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return null;
    }
}
