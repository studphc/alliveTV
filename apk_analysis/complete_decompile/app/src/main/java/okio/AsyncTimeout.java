package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0588cc;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0019\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, m5569d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "<init>", "()V", "", "enter", "", "exit", "()Z", "timedOut", "Lokio/Sink;", "sink", "(Lokio/Sink;)Lokio/Sink;", "Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "(Lokio/Source;)Lokio/Source;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "withTimeout", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/io/IOException;", "cause", "access$newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "newTimeoutException", "Companion", "cc", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g */
    public static final long f24667g;

    /* renamed from: h */
    public static final long f24668h;

    /* renamed from: i */
    public static AsyncTimeout f24669i;

    /* renamed from: d */
    public boolean f24670d;

    /* renamed from: e */
    public AsyncTimeout f24671e;

    /* renamed from: f */
    public long f24672f;

    @Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lokio/AsyncTimeout$Companion;", "", "Lokio/AsyncTimeout;", "awaitTimeout$okio", "()Lokio/AsyncTimeout;", "awaitTimeout", "", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", "head", "Lokio/AsyncTimeout;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final boolean access$cancelScheduledTimeout(Companion companion, AsyncTimeout asyncTimeout) {
            companion.getClass();
            synchronized (AsyncTimeout.class) {
                if (asyncTimeout.f24670d) {
                    asyncTimeout.f24670d = false;
                    for (AsyncTimeout asyncTimeout2 = AsyncTimeout.f24669i; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.f24671e) {
                        if (asyncTimeout2.f24671e == asyncTimeout) {
                            asyncTimeout2.f24671e = asyncTimeout.f24671e;
                            asyncTimeout.f24671e = null;
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        public static final void access$scheduleTimeout(Companion companion, AsyncTimeout asyncTimeout, long j, boolean z) {
            companion.getClass();
            synchronized (AsyncTimeout.class) {
                try {
                    if (!asyncTimeout.f24670d) {
                        asyncTimeout.f24670d = true;
                        if (AsyncTimeout.f24669i == null) {
                            AsyncTimeout.f24669i = new AsyncTimeout();
                            C0588cc c0588cc = new C0588cc("Okio Watchdog");
                            c0588cc.setDaemon(true);
                            c0588cc.start();
                        }
                        long nanoTime = System.nanoTime();
                        if (j != 0 && z) {
                            asyncTimeout.f24672f = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                        } else if (j != 0) {
                            asyncTimeout.f24672f = j + nanoTime;
                        } else if (z) {
                            asyncTimeout.f24672f = asyncTimeout.deadlineNanoTime();
                        } else {
                            throw new AssertionError();
                        }
                        long access$remainingNanos = AsyncTimeout.access$remainingNanos(asyncTimeout, nanoTime);
                        AsyncTimeout asyncTimeout2 = AsyncTimeout.f24669i;
                        Intrinsics.checkNotNull(asyncTimeout2);
                        while (asyncTimeout2.f24671e != null) {
                            AsyncTimeout asyncTimeout3 = asyncTimeout2.f24671e;
                            Intrinsics.checkNotNull(asyncTimeout3);
                            if (access$remainingNanos < AsyncTimeout.access$remainingNanos(asyncTimeout3, nanoTime)) {
                                break;
                            }
                            asyncTimeout2 = asyncTimeout2.f24671e;
                            Intrinsics.checkNotNull(asyncTimeout2);
                        }
                        asyncTimeout.f24671e = asyncTimeout2.f24671e;
                        asyncTimeout2.f24671e = asyncTimeout;
                        if (asyncTimeout2 == AsyncTimeout.f24669i) {
                            AsyncTimeout.class.notify();
                        }
                    } else {
                        throw new IllegalStateException("Unbalanced enter/exit");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Nullable
        public final AsyncTimeout awaitTimeout$okio() {
            AsyncTimeout asyncTimeout = AsyncTimeout.f24669i;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.f24671e;
            if (asyncTimeout2 == null) {
                long nanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.f24667g);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.f24669i;
                Intrinsics.checkNotNull(asyncTimeout3);
                if (asyncTimeout3.f24671e == null && System.nanoTime() - nanoTime >= AsyncTimeout.f24668h) {
                    return AsyncTimeout.f24669i;
                }
                return null;
            }
            long access$remainingNanos = AsyncTimeout.access$remainingNanos(asyncTimeout2, System.nanoTime());
            if (access$remainingNanos <= 0) {
                AsyncTimeout asyncTimeout4 = AsyncTimeout.f24669i;
                Intrinsics.checkNotNull(asyncTimeout4);
                asyncTimeout4.f24671e = asyncTimeout2.f24671e;
                asyncTimeout2.f24671e = null;
                return asyncTimeout2;
            }
            long j = access$remainingNanos / 1000000;
            AsyncTimeout.class.wait(j, (int) (access$remainingNanos - (1000000 * j)));
            return null;
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f24667g = millis;
        f24668h = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final long access$remainingNanos(AsyncTimeout asyncTimeout, long j) {
        return asyncTimeout.f24672f - j;
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException cause) {
        return newTimeoutException(cause);
    }

    public final void enter() {
        long f24767c = getF24767c();
        boolean f24765a = getF24765a();
        if (f24767c == 0 && !f24765a) {
            return;
        }
        Companion.access$scheduleTimeout(INSTANCE, this, f24767c, f24765a);
    }

    public final boolean exit() {
        return Companion.access$cancelScheduledTimeout(INSTANCE, this);
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Sink sink2 = sink;
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    sink2.close();
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                Sink sink2 = sink;
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    sink2.flush();
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @NotNull
            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(@NotNull Buffer source, long byteCount) {
                Intrinsics.checkNotNullParameter(source, "source");
                _UtilKt.checkOffsetAndCount(source.size(), 0L, byteCount);
                while (true) {
                    long j = 0;
                    if (byteCount > 0) {
                        Segment segment = source.head;
                        Intrinsics.checkNotNull(segment);
                        while (true) {
                            if (j >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                break;
                            }
                            j += segment.limit - segment.pos;
                            if (j >= byteCount) {
                                j = byteCount;
                                break;
                            } else {
                                segment = segment.next;
                                Intrinsics.checkNotNull(segment);
                            }
                        }
                        Sink sink2 = sink;
                        AsyncTimeout asyncTimeout = AsyncTimeout.this;
                        asyncTimeout.enter();
                        try {
                            sink2.write(source, j);
                            if (!asyncTimeout.exit()) {
                                byteCount -= j;
                            } else {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                        } catch (IOException e) {
                            if (!asyncTimeout.exit()) {
                                throw e;
                            }
                            throw asyncTimeout.access$newTimeoutException(e);
                        } finally {
                            asyncTimeout.exit();
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // okio.Sink
            @NotNull
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getF24673a() {
                return AsyncTimeout.this;
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Source source2 = source;
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    source2.close();
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                Source source2 = source;
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    long read = source2.read(sink, byteCount);
                    if (!asyncTimeout.exit()) {
                        return read;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @NotNull
            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override // okio.Source
            @NotNull
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getF24675a() {
                return AsyncTimeout.this;
            }
        };
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(@NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        enter();
        try {
            try {
                T invoke = block.invoke();
                InlineMarker.finallyStart(1);
                if (!exit()) {
                    InlineMarker.finallyEnd(1);
                    return invoke;
                }
                throw access$newTimeoutException(null);
            } catch (IOException e) {
                if (!exit()) {
                    throw e;
                }
                throw access$newTimeoutException(e);
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            exit();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
