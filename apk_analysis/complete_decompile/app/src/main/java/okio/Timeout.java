package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u0015\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m5569d2 = {"Lokio/Timeout;", "", "<init>", "()V", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "timeoutNanos", "()J", "", "hasDeadline", "()Z", "deadlineNanoTime", "(J)Lokio/Timeout;", TypedValues.TransitionType.S_DURATION, "deadline", "clearTimeout", "()Lokio/Timeout;", "clearDeadline", "", "throwIfReached", "monitor", "waitUntilNotified", "(Ljava/lang/Object;)V", ExifInterface.GPS_DIRECTION_TRUE, "other", "Lkotlin/Function0;", "block", "intersectWith", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class Timeout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Timeout NONE = new Timeout();

    /* renamed from: a */
    public boolean f24765a;

    /* renamed from: b */
    public long f24766b;

    /* renamed from: c */
    public long f24767c;

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"Lokio/Timeout$Companion;", "", "", "aNanos", "bNanos", "minTimeout", "(JJ)J", "Lokio/Timeout;", "NONE", "Lokio/Timeout;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final long minTimeout(long aNanos, long bNanos) {
            return (aNanos != 0 && (bNanos == 0 || aNanos < bNanos)) ? aNanos : bNanos;
        }
    }

    @NotNull
    public Timeout clearDeadline() {
        this.f24765a = false;
        return this;
    }

    @NotNull
    public Timeout clearTimeout() {
        this.f24767c = 0L;
        return this;
    }

    @NotNull
    public final Timeout deadline(long duration, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (duration > 0) {
            return deadlineNanoTime(unit.toNanos(duration) + System.nanoTime());
        }
        throw new IllegalArgumentException(ye0.m8294n(duration, "duration <= 0: ").toString());
    }

    public long deadlineNanoTime() {
        if (this.f24765a) {
            return this.f24766b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: hasDeadline, reason: from getter */
    public boolean getF24765a() {
        return this.f24765a;
    }

    public final <T> T intersectWith(@NotNull Timeout other, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(block, "block");
        long f24767c = getF24767c();
        long minTimeout = INSTANCE.minTimeout(other.getF24767c(), getF24767c());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(minTimeout, timeUnit);
        if (getF24765a()) {
            long deadlineNanoTime = deadlineNanoTime();
            if (other.getF24765a()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
            }
            try {
                T invoke = block.invoke();
                InlineMarker.finallyStart(1);
                timeout(f24767c, timeUnit);
                if (other.getF24765a()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout(f24767c, TimeUnit.NANOSECONDS);
                if (other.getF24765a()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        if (other.getF24765a()) {
            deadlineNanoTime(other.deadlineNanoTime());
        }
        try {
            T invoke2 = block.invoke();
            InlineMarker.finallyStart(1);
            timeout(f24767c, timeUnit);
            if (other.getF24765a()) {
                clearDeadline();
            }
            InlineMarker.finallyEnd(1);
            return invoke2;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            timeout(f24767c, TimeUnit.NANOSECONDS);
            if (other.getF24765a()) {
                clearDeadline();
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    public void throwIfReached() {
        if (!Thread.currentThread().isInterrupted()) {
            if (this.f24765a && this.f24766b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    @NotNull
    public Timeout timeout(long timeout, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (timeout >= 0) {
            this.f24767c = unit.toNanos(timeout);
            return this;
        }
        throw new IllegalArgumentException(ye0.m8294n(timeout, "timeout < 0: ").toString());
    }

    /* renamed from: timeoutNanos, reason: from getter */
    public long getF24767c() {
        return this.f24767c;
    }

    public final void waitUntilNotified(@NotNull Object monitor) {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        try {
            boolean f24765a = getF24765a();
            long f24767c = getF24767c();
            long j = 0;
            if (!f24765a && f24767c == 0) {
                monitor.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (f24765a && f24767c != 0) {
                f24767c = Math.min(f24767c, deadlineNanoTime() - nanoTime);
            } else if (f24765a) {
                f24767c = deadlineNanoTime() - nanoTime;
            }
            if (f24767c > 0) {
                long j2 = f24767c / 1000000;
                Long.signum(j2);
                monitor.wait(j2, (int) (f24767c - (1000000 * j2)));
                j = System.nanoTime() - nanoTime;
            }
            if (j < f24767c) {
            } else {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @NotNull
    public Timeout deadlineNanoTime(long deadlineNanoTime) {
        this.f24765a = true;
        this.f24766b = deadlineNanoTime;
        return this;
    }
}
