package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;

@Metadata(m5568d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m5569d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustRootIndex", "<init>", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: a */
    public final TrustRootIndex f24582a;

    public BasicCertificateChainCleaner(@NotNull TrustRootIndex trustRootIndex) {
        Intrinsics.checkNotNullParameter(trustRootIndex, "trustRootIndex");
        this.f24582a = trustRootIndex;
    }

    /* renamed from: a */
    public static boolean m6642a(X509Certificate x509Certificate, X509Certificate x509Certificate2, int i) {
        if (!Intrinsics.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN()) || x509Certificate2.getBasicConstraints() < i) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> chain, @NotNull String hostname) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        Intrinsics.checkNotNullExpressionValue(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) AbstractC1726qj.m7053i(arrayList, 1);
            X509Certificate findByIssuerAndSignature = this.f24582a.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !Intrinsics.areEqual(x509Certificate, findByIssuerAndSignature)) {
                    arrayList.add(findByIssuerAndSignature);
                }
                if (m6642a(findByIssuerAndSignature, findByIssuerAndSignature, arrayList.size() - 2)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next != null) {
                        X509Certificate x509Certificate2 = (X509Certificate) next;
                        if (m6642a(x509Certificate, x509Certificate2, arrayList.size() - 1)) {
                            it.remove();
                            arrayList.add(x509Certificate2);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BasicCertificateChainCleaner) && Intrinsics.areEqual(((BasicCertificateChainCleaner) other).f24582a, this.f24582a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24582a.hashCode();
    }
}
