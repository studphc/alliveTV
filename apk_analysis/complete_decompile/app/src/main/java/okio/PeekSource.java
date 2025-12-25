package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5569d2 = {"Lokio/PeekSource;", "Lokio/Source;", "Lokio/BufferedSource;", "upstream", "<init>", "(Lokio/BufferedSource;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class PeekSource implements Source {

    /* renamed from: a */
    public final BufferedSource f24734a;

    /* renamed from: b */
    public final Buffer f24735b;

    /* renamed from: c */
    public Segment f24736c;

    /* renamed from: d */
    public int f24737d;

    /* renamed from: e */
    public boolean f24738e;

    /* renamed from: f */
    public long f24739f;

    public PeekSource(@NotNull BufferedSource upstream) {
        int i;
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.f24734a = upstream;
        Buffer buffer = upstream.getBuffer();
        this.f24735b = buffer;
        Segment segment = buffer.head;
        this.f24736c = segment;
        if (segment != null) {
            i = segment.pos;
        } else {
            i = -1;
        }
        this.f24737d = i;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f24738e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3 == r5.pos) goto L15;
     */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(@NotNull Buffer sink, long byteCount) {
        Segment segment;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (!this.f24738e) {
                Segment segment2 = this.f24736c;
                Buffer buffer = this.f24735b;
                if (segment2 != null) {
                    Segment segment3 = buffer.head;
                    if (segment2 == segment3) {
                        int i = this.f24737d;
                        Intrinsics.checkNotNull(segment3);
                    }
                    throw new IllegalStateException("Peek source is invalid because upstream source was used");
                }
                if (byteCount == 0) {
                    return 0L;
                }
                if (!this.f24734a.request(this.f24739f + 1)) {
                    return -1L;
                }
                if (this.f24736c == null && (segment = buffer.head) != null) {
                    this.f24736c = segment;
                    Intrinsics.checkNotNull(segment);
                    this.f24737d = segment.pos;
                }
                long min = Math.min(byteCount, buffer.size() - this.f24739f);
                this.f24735b.copyTo(sink, this.f24739f, min);
                this.f24739f += min;
                return min;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(byteCount, "byteCount < 0: ").toString());
    }

    @Override // okio.Source
    @NotNull
    /* renamed from: timeout */
    public Timeout getF24750a() {
        return this.f24734a.getF24750a();
    }
}
