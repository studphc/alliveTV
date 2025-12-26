package okhttp3;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.hq1;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0005\u0010\u0013¨\u0006\u0017"}, m5569d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "", "boundary", "<init>", "(Lokio/BufferedSource;Ljava/lang/String;)V", "Lokhttp3/ResponseBody;", "response", "(Lokhttp3/ResponseBody;)V", "Lokhttp3/MultipartReader$Part;", "nextPart", "()Lokhttp3/MultipartReader$Part;", "", "close", "()V", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "Companion", "Part", "hq1", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MultipartReader implements Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i */
    public static final Options f23997i;

    /* renamed from: a */
    public final BufferedSource f23998a;

    /* renamed from: b, reason: from kotlin metadata */
    public final String boundary;

    /* renamed from: c */
    public final ByteString f24000c;

    /* renamed from: d */
    public final ByteString f24001d;

    /* renamed from: e */
    public int f24002e;

    /* renamed from: f */
    public boolean f24003f;

    /* renamed from: g */
    public boolean f24004g;

    /* renamed from: h */
    public hq1 f24005h;

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/MultipartReader$Companion;", "", "Lokio/Options;", "afterBoundaryOptions", "Lokio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final Options getAfterBoundaryOptions() {
            return MultipartReader.f23997i;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "Lokhttp3/Headers;", "headers", "Lokio/BufferedSource;", "body", "<init>", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "", "close", "()V", "a", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "b", "Lokio/BufferedSource;", "()Lokio/BufferedSource;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Part implements Closeable {

        /* renamed from: a, reason: from kotlin metadata */
        public final Headers headers;

        /* renamed from: b, reason: from kotlin metadata */
        public final BufferedSource body;

        public Part(@NotNull Headers headers, @NotNull BufferedSource body) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(body, "body");
            this.headers = headers;
            this.body = body;
        }

        @JvmName(name = "body")
        @NotNull
        /* renamed from: body, reason: from getter */
        public final BufferedSource getBody() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        @JvmName(name = "headers")
        @NotNull
        /* renamed from: headers, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }
    }

    static {
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        f23997i = companion.m6669of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8("--"), companion2.encodeUtf8(" "), companion2.encodeUtf8("\t"));
    }

    public MultipartReader(@NotNull BufferedSource source, @NotNull String boundary) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.f23998a = source;
        this.boundary = boundary;
        this.f24000c = new Buffer().writeUtf8("--").writeUtf8(boundary).readByteString();
        this.f24001d = new Buffer().writeUtf8("\r\n--").writeUtf8(boundary).readByteString();
    }

    /* renamed from: a */
    public final long m6600a(long j) {
        ByteString byteString = this.f24001d;
        long size = byteString.size();
        BufferedSource bufferedSource = this.f23998a;
        bufferedSource.require(size);
        long indexOf = bufferedSource.getBuffer().indexOf(byteString);
        if (indexOf == -1) {
            return Math.min(j, (bufferedSource.getBuffer().size() - byteString.size()) + 1);
        }
        return Math.min(j, indexOf);
    }

    @JvmName(name = "boundary")
    @NotNull
    /* renamed from: boundary, reason: from getter */
    public final String getBoundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f24003f) {
            return;
        }
        this.f24003f = true;
        this.f24005h = null;
        this.f23998a.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Part nextPart() {
        int select;
        if (!this.f24003f) {
            if (this.f24004g) {
                return null;
            }
            int i = this.f24002e;
            BufferedSource bufferedSource = this.f23998a;
            if (i == 0) {
                if (bufferedSource.rangeEquals(0L, this.f24000c)) {
                    bufferedSource.skip(r0.size());
                    boolean z = false;
                    while (true) {
                        select = bufferedSource.select(f23997i);
                        if (select == -1) {
                            if (select != 0) {
                                if (select != 1) {
                                    if (select == 2 || select == 3) {
                                        z = true;
                                    }
                                } else {
                                    if (!z) {
                                        if (this.f24002e != 0) {
                                            this.f24004g = true;
                                            return null;
                                        }
                                        throw new ProtocolException("expected at least 1 part");
                                    }
                                    throw new ProtocolException("unexpected characters after boundary");
                                }
                            } else {
                                this.f24002e++;
                                Headers readHeaders = new HeadersReader(bufferedSource).readHeaders();
                                hq1 hq1Var = new hq1(this);
                                this.f24005h = hq1Var;
                                return new Part(readHeaders, Okio.buffer(hq1Var));
                            }
                        } else {
                            throw new ProtocolException("unexpected characters after boundary");
                        }
                    }
                }
            }
            while (true) {
                long m6600a = m6600a(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (m6600a == 0) {
                    break;
                }
                bufferedSource.skip(m6600a);
            }
            bufferedSource.skip(this.f24001d.size());
            boolean z2 = false;
            while (true) {
                select = bufferedSource.select(f23997i);
                if (select == -1) {
                }
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultipartReader(@NotNull ResponseBody response) {
        this(r0, r3);
        String parameter;
        Intrinsics.checkNotNullParameter(response, "response");
        BufferedSource f24402d = response.getF24402d();
        MediaType contentType = response.contentType();
        if (contentType != null && (parameter = contentType.parameter("boundary")) != null) {
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
