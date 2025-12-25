package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003*\u001e\b\u0002\u0010\b\u001a\u0004\b\u0000\u0010\u0006\"\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0012\u0004\u0012\u00028\u00000\u0007¨\u0006\t"}, m5569d2 = {"", "timeMillis", "delayToNanos", "(J)J", "timeNanos", "delayNanosToMillis", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class EventLoop_commonKt {

    /* renamed from: a */
    public static final Symbol f21415a = new Symbol("REMOVED_TASK");

    /* renamed from: b */
    public static final Symbol f21416b = new Symbol("CLOSED_EMPTY");

    public static final long delayNanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
