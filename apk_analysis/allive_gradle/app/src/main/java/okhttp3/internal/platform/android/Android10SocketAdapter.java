package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.bl2;

@SuppressSignatureCheck
@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, m5569d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class Android10SocketAdapter implements SocketAdapter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SuppressSignatureCheck
    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5569d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter$Companion;", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildIfSupported", "()Lokhttp3/internal/platform/android/SocketAdapter;", "", "isSupported", "()Z", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Nullable
        public final SocketAdapter buildIfSupported() {
            if (isSupported()) {
                return new Android10SocketAdapter();
            }
            return null;
        }

        public final boolean isSupported() {
            if (Platform.INSTANCE.isAndroid() && Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<? extends Protocol> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sSLParameters = sslSocket.getSSLParameters();
            Object[] array = Platform.INSTANCE.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array != null) {
                sSLParameters.setApplicationProtocols((String[]) array);
                sslSocket.setSSLParameters(sSLParameters);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        String applicationProtocol;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(applicationProtocol, "");
            }
            if (areEqual) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return INSTANCE.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        boolean isSupportedSocket;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        isSupportedSocket = SSLSockets.isSupportedSocket(sslSocket);
        return isSupportedSocket;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final /* synthetic */ boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return bl2.m2104a(this, sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final /* synthetic */ X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return bl2.m2105b(this, sSLSocketFactory);
    }
}
