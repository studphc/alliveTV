package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1919vr;

@Metadata(m5568d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 .2\u00020\u0001:\u0002/.B9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u0003\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b)\u0010(\u001a\u0004\b\u0004\u0010\u0014R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u00060"}, m5569d2 = {"Lokhttp3/ConnectionSpec;", "", "", "isTls", "supportsTlsExtensions", "", "", "cipherSuitesAsString", "tlsVersionsAsString", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "", "Lokhttp3/CipherSuite;", "-deprecated_cipherSuites", "()Ljava/util/List;", "cipherSuites", "Lokhttp3/TlsVersion;", "-deprecated_tlsVersions", "tlsVersions", "-deprecated_supportsTlsExtensions", "()Z", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "", "apply$okhttp", "(Ljavax/net/ssl/SSLSocket;Z)V", "apply", "socket", "isCompatible", "(Ljavax/net/ssl/SSLSocket;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Z", "b", "c", "[Ljava/lang/String;", "getCipherSuitesAsString$okhttp", "()[Ljava/lang/String;", "Companion", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConnectionSpec {

    @JvmField
    @NotNull
    public static final ConnectionSpec CLEARTEXT;

    @JvmField
    @NotNull
    public static final ConnectionSpec COMPATIBLE_TLS;

    @JvmField
    @NotNull
    public static final ConnectionSpec MODERN_TLS;

    @JvmField
    @NotNull
    public static final ConnectionSpec RESTRICTED_TLS;

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean isTls;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean supportsTlsExtensions;

    /* renamed from: c, reason: from kotlin metadata */
    public final String[] cipherSuitesAsString;

    /* renamed from: d */
    public final String[] f23911d;

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        Builder cipherSuites = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(new CipherSuite[]{cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9}, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = cipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        MODERN_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 16)).tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 16)).tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    public ConnectionSpec(boolean z, boolean z2, @Nullable String[] strArr, @Nullable String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.f23911d = strArr2;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuites", imports = {}))
    @JvmName(name = "-deprecated_cipherSuites")
    @Nullable
    /* renamed from: -deprecated_cipherSuites, reason: not valid java name */
    public final List<CipherSuite> m8942deprecated_cipherSuites() {
        return cipherSuites();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "supportsTlsExtensions", imports = {}))
    @JvmName(name = "-deprecated_supportsTlsExtensions")
    /* renamed from: -deprecated_supportsTlsExtensions, reason: not valid java name and from getter */
    public final boolean getSupportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersions", imports = {}))
    @JvmName(name = "-deprecated_tlsVersions")
    @Nullable
    /* renamed from: -deprecated_tlsVersions, reason: not valid java name */
    public final List<TlsVersion> m8944deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(@NotNull SSLSocket sslSocket, boolean isFallback) {
        String[] tlsVersionsIntersection;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String[] socketEnabledCipherSuites = sslSocket.getEnabledCipherSuites();
        Intrinsics.checkNotNullExpressionValue(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        String[] effectiveCipherSuites = Internal.effectiveCipherSuites(this, socketEnabledCipherSuites);
        String[] strArr = this.f23911d;
        if (strArr != null) {
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = _UtilCommonKt.intersect(enabledProtocols, strArr, AbstractC1919vr.naturalOrder());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int indexOf = _UtilCommonKt.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.INSTANCE.getORDER_BY_NAME$okhttp());
        if (isFallback && indexOf != -1) {
            String str = supportedCipherSuites[indexOf];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            effectiveCipherSuites = _UtilCommonKt.concat(effectiveCipherSuites, str);
        }
        Builder cipherSuites = new Builder(this).cipherSuites((String[]) Arrays.copyOf(effectiveCipherSuites, effectiveCipherSuites.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        ConnectionSpec build = cipherSuites.tlsVersions((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).build();
        if (build.tlsVersions() != null) {
            sslSocket.setEnabledProtocols(build.f23911d);
        }
        if (build.cipherSuites() != null) {
            sslSocket.setEnabledCipherSuites(build.cipherSuitesAsString);
        }
    }

    @JvmName(name = "cipherSuites")
    @Nullable
    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(CipherSuite.INSTANCE.forJavaName(str));
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        return null;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof ConnectionSpec)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) other;
        boolean z = connectionSpec.isTls;
        boolean z2 = this.isTls;
        if (z2 != z) {
            return false;
        }
        if (z2 && (!Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) || !Arrays.equals(this.f23911d, connectionSpec.f23911d) || this.supportsTlsExtensions != connectionSpec.supportsTlsExtensions)) {
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: getCipherSuitesAsString$okhttp, reason: from getter */
    public final String[] getCipherSuitesAsString() {
        return this.cipherSuitesAsString;
    }

    public int hashCode() {
        int i;
        if (this.isTls) {
            int i2 = 0;
            String[] strArr = this.cipherSuitesAsString;
            if (strArr != null) {
                i = Arrays.hashCode(strArr);
            } else {
                i = 0;
            }
            int i3 = (527 + i) * 31;
            String[] strArr2 = this.f23911d;
            if (strArr2 != null) {
                i2 = Arrays.hashCode(strArr2);
            }
            return ((i3 + i2) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public final boolean isCompatible(@NotNull SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.f23911d;
        if (strArr != null && !_UtilCommonKt.hasIntersection(strArr, socket.getEnabledProtocols(), AbstractC1919vr.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        if (strArr2 != null && !_UtilCommonKt.hasIntersection(strArr2, socket.getEnabledCipherSuites(), CipherSuite.INSTANCE.getORDER_BY_NAME$okhttp())) {
            return false;
        }
        return true;
    }

    @JvmName(name = "isTls")
    /* renamed from: isTls, reason: from getter */
    public final boolean getIsTls() {
        return this.isTls;
    }

    @JvmName(name = "supportsTlsExtensions")
    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @JvmName(name = "tlsVersions")
    @Nullable
    public final List<TlsVersion> tlsVersions() {
        String[] strArr = this.f23911d;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(TlsVersion.INSTANCE.forJavaName(str));
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        return null;
    }

    @NotNull
    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    @Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\r\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\r\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000b\"\u00020\u000f¢\u0006\u0004\b\r\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\nJ!\u0010\u0013\u001a\u00020\u00002\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u000b\"\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0013\u001a\u00020\u00002\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000b\"\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0005R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u0005¨\u0006*"}, m5569d2 = {"Lokhttp3/ConnectionSpec$Builder;", "", "", "tls", "<init>", "(Z)V", "Lokhttp3/ConnectionSpec;", "connectionSpec", "(Lokhttp3/ConnectionSpec;)V", "allEnabledCipherSuites", "()Lokhttp3/ConnectionSpec$Builder;", "", "Lokhttp3/CipherSuite;", "cipherSuites", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "allEnabledTlsVersions", "Lokhttp3/TlsVersion;", "tlsVersions", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "supportsTlsExtensions", "(Z)Lokhttp3/ConnectionSpec$Builder;", "build", "()Lokhttp3/ConnectionSpec;", "a", "Z", "getTls$okhttp", "()Z", "setTls$okhttp", "b", "[Ljava/lang/String;", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "c", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "d", "getSupportsTlsExtensions$okhttp", "setSupportsTlsExtensions$okhttp", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: from kotlin metadata */
        public boolean tls;

        /* renamed from: b, reason: from kotlin metadata */
        public String[] cipherSuites;

        /* renamed from: c, reason: from kotlin metadata */
        public String[] tlsVersions;

        /* renamed from: d, reason: from kotlin metadata */
        public boolean supportsTlsExtensions;

        public Builder(boolean z) {
            this.tls = z;
        }

        @NotNull
        public final Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        @NotNull
        public final Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }

        @NotNull
        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        @NotNull
        public final Builder cipherSuites(@NotNull CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(cipherSuites.length);
                for (CipherSuite cipherSuite : cipherSuites) {
                    arrayList.add(cipherSuite.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        @Nullable
        /* renamed from: getCipherSuites$okhttp, reason: from getter */
        public final String[] getCipherSuites() {
            return this.cipherSuites;
        }

        /* renamed from: getSupportsTlsExtensions$okhttp, reason: from getter */
        public final boolean getSupportsTlsExtensions() {
            return this.supportsTlsExtensions;
        }

        /* renamed from: getTls$okhttp, reason: from getter */
        public final boolean getTls() {
            return this.tls;
        }

        @Nullable
        /* renamed from: getTlsVersions$okhttp, reason: from getter */
        public final String[] getTlsVersions() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(@Nullable String[] strArr) {
            this.cipherSuites = strArr;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z) {
            this.supportsTlsExtensions = z;
        }

        public final void setTls$okhttp(boolean z) {
            this.tls = z;
        }

        public final void setTlsVersions$okhttp(@Nullable String[] strArr) {
            this.tlsVersions = strArr;
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        @NotNull
        public final Builder supportsTlsExtensions(boolean supportsTlsExtensions) {
            if (this.tls) {
                this.supportsTlsExtensions = supportsTlsExtensions;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }

        @NotNull
        public final Builder tlsVersions(@NotNull TlsVersion... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(tlsVersions.length);
                for (TlsVersion tlsVersion : tlsVersions) {
                    arrayList.add(tlsVersion.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }

        public Builder(@NotNull ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.getIsTls();
            this.cipherSuites = connectionSpec.getCipherSuitesAsString();
            this.tlsVersions = connectionSpec.f23911d;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        @NotNull
        public final Builder cipherSuites(@NotNull String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.tls) {
                if (!(cipherSuites.length == 0)) {
                    this.cipherSuites = (String[]) cipherSuites.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        @NotNull
        public final Builder tlsVersions(@NotNull String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.tls) {
                if (!(tlsVersions.length == 0)) {
                    this.tlsVersions = (String[]) tlsVersions.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
    }
}
