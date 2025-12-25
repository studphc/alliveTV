package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m5569d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Landroid/net/http/X509TrustManagerExtensions;", "x509TrustManagerExtensions", "<init>", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final X509TrustManager f24558a;

    /* renamed from: b */
    public final X509TrustManagerExtensions f24559b;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "buildIfSupported", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @SuppressSignatureCheck
        @Nullable
        public final AndroidCertificateChainCleaner buildIfSupported(@NotNull X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions == null) {
                return null;
            }
            return new AndroidCertificateChainCleaner(trustManager, x509TrustManagerExtensions);
        }
    }

    public AndroidCertificateChainCleaner(@NotNull X509TrustManager trustManager, @NotNull X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f24558a = trustManager;
        this.f24559b = x509TrustManagerExtensions;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @SuppressSignatureCheck
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> chain, @NotNull String hostname) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        if (array != null) {
            try {
                List<X509Certificate> checkServerTrusted = this.f24559b.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
                Intrinsics.checkNotNullExpressionValue(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
                return checkServerTrusted;
            } catch (CertificateException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) other).f24558a == this.f24558a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f24558a);
    }
}
