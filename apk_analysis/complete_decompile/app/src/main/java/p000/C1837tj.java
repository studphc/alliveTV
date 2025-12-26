package p000;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* renamed from: tj */
/* loaded from: classes2.dex */
public final class C1837tj {

    /* renamed from: k */
    public static final String f26832k;

    /* renamed from: l */
    public static final String f26833l;

    /* renamed from: a */
    public final HttpUrl f26834a;

    /* renamed from: b */
    public final Headers f26835b;

    /* renamed from: c */
    public final String f26836c;

    /* renamed from: d */
    public final Protocol f26837d;

    /* renamed from: e */
    public final int f26838e;

    /* renamed from: f */
    public final String f26839f;

    /* renamed from: g */
    public final Headers f26840g;

    /* renamed from: h */
    public final Handshake f26841h;

    /* renamed from: i */
    public final long f26842i;

    /* renamed from: j */
    public final long f26843j;

    static {
        final DefaultConstructorMarker defaultConstructorMarker = null;
        new Object(defaultConstructorMarker) { // from class: okhttp3.Cache$Entry$Companion
        };
        StringBuilder sb = new StringBuilder();
        Platform.Companion companion = Platform.INSTANCE;
        sb.append(companion.get().getPrefix());
        sb.append("-Sent-Millis");
        f26832k = sb.toString();
        f26833l = companion.get().getPrefix() + "-Received-Millis";
    }

    public C1837tj(Source rawSource) {
        TlsVersion tlsVersion;
        Intrinsics.checkNotNullParameter(rawSource, "rawSource");
        try {
            BufferedSource buffer = Okio.buffer(rawSource);
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            HttpUrl parse = HttpUrl.INSTANCE.parse(readUtf8LineStrict);
            if (parse != null) {
                this.f26834a = parse;
                this.f26836c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.INSTANCE.readInt$okhttp(buffer);
                for (int i = 0; i < readInt$okhttp; i++) {
                    builder.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                this.f26835b = builder.build();
                StatusLine parse2 = StatusLine.INSTANCE.parse(buffer.readUtf8LineStrict());
                this.f26837d = parse2.protocol;
                this.f26838e = parse2.code;
                this.f26839f = parse2.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.INSTANCE.readInt$okhttp(buffer);
                for (int i2 = 0; i2 < readInt$okhttp2; i2++) {
                    builder2.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                String str = f26832k;
                String str2 = builder2.get(str);
                String str3 = f26833l;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.f26842i = str2 != null ? Long.parseLong(str2) : 0L;
                this.f26843j = str4 != null ? Long.parseLong(str4) : 0L;
                this.f26840g = builder2.build();
                if (this.f26834a.getIsHttps()) {
                    String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict2.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.INSTANCE.forJavaName(buffer.readUtf8LineStrict());
                        List<? extends Certificate> m7496a = m7496a(buffer);
                        List<? extends Certificate> m7496a2 = m7496a(buffer);
                        if (!buffer.exhausted()) {
                            tlsVersion = TlsVersion.INSTANCE.forJavaName(buffer.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.f26841h = Handshake.INSTANCE.get(tlsVersion, forJavaName, m7496a, m7496a2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict2 + Typography.quote);
                    }
                } else {
                    this.f26841h = null;
                }
                CloseableKt.closeFinally(rawSource, null);
                return;
            }
            IOException iOException = new IOException("Cache corruption for " + readUtf8LineStrict);
            Platform.INSTANCE.get().log("cache corruption", 5, iOException);
            throw iOException;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(rawSource, th);
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static List m7496a(BufferedSource bufferedSource) {
        int readInt$okhttp = Cache.INSTANCE.readInt$okhttp(bufferedSource);
        if (readInt$okhttp == -1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList(readInt$okhttp);
            for (int i = 0; i < readInt$okhttp; i++) {
                String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                Buffer buffer = new Buffer();
                ByteString decodeBase64 = ByteString.INSTANCE.decodeBase64(readUtf8LineStrict);
                Intrinsics.checkNotNull(decodeBase64);
                buffer.write(decodeBase64);
                arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
            }
            return arrayList;
        } catch (CertificateException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: b */
    public static void m7497b(BufferedSink bufferedSink, List list) {
        try {
            bufferedSink.writeDecimalLong(list.size()).writeByte(10);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                byte[] bytes = ((Certificate) it.next()).getEncoded();
                ByteString.Companion companion = ByteString.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                bufferedSink.writeUtf8(ByteString.Companion.of$default(companion, bytes, 0, 0, 3, null).base64()).writeByte(10);
            }
        } catch (CertificateEncodingException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: c */
    public final void m7498c(DiskLruCache.Editor editor) {
        HttpUrl httpUrl = this.f26834a;
        Handshake handshake = this.f26841h;
        Headers headers = this.f26840g;
        Headers headers2 = this.f26835b;
        Intrinsics.checkNotNullParameter(editor, "editor");
        BufferedSink buffer = Okio.buffer(editor.newSink(0));
        try {
            buffer.writeUtf8(httpUrl.getF23968i()).writeByte(10);
            buffer.writeUtf8(this.f26836c).writeByte(10);
            buffer.writeDecimalLong(headers2.size()).writeByte(10);
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(headers2.name(i)).writeUtf8(": ").writeUtf8(headers2.value(i)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f26837d, this.f26838e, this.f26839f).toString()).writeByte(10);
            buffer.writeDecimalLong(headers.size() + 2).writeByte(10);
            int size2 = headers.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(headers.name(i2)).writeUtf8(": ").writeUtf8(headers.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(f26832k).writeUtf8(": ").writeDecimalLong(this.f26842i).writeByte(10);
            buffer.writeUtf8(f26833l).writeUtf8(": ").writeDecimalLong(this.f26843j).writeByte(10);
            if (httpUrl.getIsHttps()) {
                buffer.writeByte(10);
                Intrinsics.checkNotNull(handshake);
                buffer.writeUtf8(handshake.cipherSuite().javaName()).writeByte(10);
                m7497b(buffer, handshake.peerCertificates());
                m7497b(buffer, handshake.localCertificates());
                buffer.writeUtf8(handshake.tlsVersion().javaName()).writeByte(10);
            }
            CloseableKt.closeFinally(buffer, null);
        } finally {
        }
    }

    public C1837tj(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.f26834a = response.request().url();
        this.f26835b = Cache.INSTANCE.varyHeaders(response);
        this.f26836c = response.request().method();
        this.f26837d = response.protocol();
        this.f26838e = response.code();
        this.f26839f = response.message();
        this.f26840g = response.headers();
        this.f26841h = response.handshake();
        this.f26842i = response.sentRequestAtMillis();
        this.f26843j = response.receivedResponseAtMillis();
    }
}
