package p000;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes2.dex */
public final class a11 extends y01 {

    /* renamed from: d */
    public final HttpUrl f16d;

    /* renamed from: e */
    public long f17e;

    /* renamed from: f */
    public boolean f18f;

    /* renamed from: g */
    public final /* synthetic */ Http1ExchangeCodec f19g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a11(Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
        super(http1ExchangeCodec);
        Intrinsics.checkNotNullParameter(url, "url");
        this.f19g = http1ExchangeCodec;
        this.f16d = url;
        this.f17e = -1L;
        this.f18f = true;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f28781b) {
            return;
        }
        if (this.f18f && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.f19g.getCarrier().noNewExchanges();
            m8207a();
        }
        this.f28781b = true;
    }

    @Override // p000.y01, okio.Source
    public final long read(Buffer sink, long j) {
        BufferedSource bufferedSource;
        BufferedSource bufferedSource2;
        HeadersReader headersReader;
        OkHttpClient okHttpClient;
        Headers headers;
        BufferedSource bufferedSource3;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            if (!this.f28781b) {
                if (!this.f18f) {
                    return -1L;
                }
                long j2 = this.f17e;
                Http1ExchangeCodec http1ExchangeCodec = this.f19g;
                if (j2 == 0 || j2 == -1) {
                    if (j2 != -1) {
                        bufferedSource3 = http1ExchangeCodec.f24408c;
                        bufferedSource3.readUtf8LineStrict();
                    }
                    try {
                        bufferedSource = http1ExchangeCodec.f24408c;
                        this.f17e = bufferedSource.readHexadecimalUnsignedLong();
                        bufferedSource2 = http1ExchangeCodec.f24408c;
                        String obj = StringsKt__StringsKt.trim(bufferedSource2.readUtf8LineStrict()).toString();
                        if (this.f17e >= 0 && (obj.length() <= 0 || ro2.startsWith$default(obj, ";", false, 2, null))) {
                            if (this.f17e == 0) {
                                this.f18f = false;
                                headersReader = http1ExchangeCodec.f24411f;
                                http1ExchangeCodec.f24412g = headersReader.readHeaders();
                                okHttpClient = http1ExchangeCodec.f24406a;
                                Intrinsics.checkNotNull(okHttpClient);
                                CookieJar cookieJar = okHttpClient.cookieJar();
                                headers = http1ExchangeCodec.f24412g;
                                Intrinsics.checkNotNull(headers);
                                HttpHeaders.receiveHeaders(cookieJar, this.f16d, headers);
                                m8207a();
                            }
                            if (!this.f18f) {
                                return -1L;
                            }
                        } else {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f17e + obj + Typography.quote);
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long read = super.read(sink, Math.min(j, this.f17e));
                if (read != -1) {
                    this.f17e -= read;
                    return read;
                }
                http1ExchangeCodec.getCarrier().noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m8207a();
                throw protocolException;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "byteCount < 0: ").toString());
    }
}
