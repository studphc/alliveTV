package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J+\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m5569d2 = {"Lokio/Throttler;", "", "", "allocatedUntil", "<init>", "(J)V", "()V", "bytesPerSecond", "waitByteCount", "maxByteCount", "", "(JJJ)V", "byteCount", "take$okio", "(J)J", "take", "now", "byteCountOrWaitNanos$okio", "(JJ)J", "byteCountOrWaitNanos", "Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "(Lokio/Source;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Sink;)Lokio/Sink;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Throttler {

    /* renamed from: a */
    public long f24759a;

    /* renamed from: b */
    public long f24760b;

    /* renamed from: c */
    public long f24761c;

    /* renamed from: d */
    public long f24762d;

    public Throttler(long j) {
        this.f24759a = j;
        this.f24761c = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.f24762d = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = throttler.f24761c;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            j3 = throttler.f24762d;
        }
        throttler.bytesPerSecond(j, j4, j3);
    }

    public final long byteCountOrWaitNanos$okio(long now, long byteCount) {
        if (this.f24760b == 0) {
            return byteCount;
        }
        long max = Math.max(this.f24759a - now, 0L);
        long j = this.f24762d;
        long j2 = this.f24760b;
        long j3 = j - ((max * j2) / C0643C.NANOS_PER_SECOND);
        if (j3 >= byteCount) {
            this.f24759a = ((byteCount * C0643C.NANOS_PER_SECOND) / j2) + now + max;
            return byteCount;
        }
        long j4 = this.f24761c;
        if (j3 >= j4) {
            this.f24759a = ((j * C0643C.NANOS_PER_SECOND) / j2) + now;
            return j3;
        }
        long min = Math.min(j4, byteCount);
        long j5 = this.f24762d;
        long j6 = (min - j5) * C0643C.NANOS_PER_SECOND;
        long j7 = this.f24760b;
        long j8 = (j6 / j7) + max;
        if (j8 == 0) {
            this.f24759a = ((j5 * C0643C.NANOS_PER_SECOND) / j7) + now;
            return min;
        }
        return -j8;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0L, 0L, 6, null);
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long byteCount) {
                Intrinsics.checkNotNullParameter(source, "source");
                while (byteCount > 0) {
                    try {
                        long take$okio = this.take$okio(byteCount);
                        super.write(source, take$okio);
                        byteCount -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    return super.read(sink, this.take$okio(byteCount));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long byteCount) {
        long byteCountOrWaitNanos$okio;
        if (byteCount > 0) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), byteCount);
                    if (byteCountOrWaitNanos$okio < 0) {
                        long j = -byteCountOrWaitNanos$okio;
                        long j2 = j / 1000000;
                        Long.signum(j2);
                        wait(j2, (int) (j - (1000000 * j2)));
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @JvmOverloads
    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long bytesPerSecond, long waitByteCount, long maxByteCount) {
        synchronized (this) {
            if (bytesPerSecond < 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (waitByteCount <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (maxByteCount >= waitByteCount) {
                this.f24760b = bytesPerSecond;
                this.f24761c = waitByteCount;
                this.f24762d = maxByteCount;
                notifyAll();
            } else {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
