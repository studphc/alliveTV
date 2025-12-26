package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r¨\u0006\u0010"}, m5569d2 = {"Lokio/SegmentPool;", "", "Lokio/Segment;", "take", "()Lokio/Segment;", "segment", "", "recycle", "(Lokio/Segment;)V", "", "MAX_SIZE", "I", "getMAX_SIZE", "()I", "getByteCount", "byteCount", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SegmentPool {

    @NotNull
    public static final SegmentPool INSTANCE = new Object();

    /* renamed from: a */
    public static final Segment f24754a = new Segment(new byte[0], 0, 0, false, false);

    /* renamed from: b */
    public static final int f24755b;

    /* renamed from: c */
    public static final AtomicReference[] f24756c;

    /* JADX WARN: Type inference failed for: r0v0, types: [okio.SegmentPool, java.lang.Object] */
    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f24755b = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f24756c = atomicReferenceArr;
    }

    /* renamed from: a */
    public static AtomicReference m6670a() {
        return f24756c[(int) (Thread.currentThread().getId() & (f24755b - 1))];
    }

    @JvmStatic
    public static final void recycle(@NotNull Segment segment) {
        int i;
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.next == null && segment.prev == null) {
            if (segment.shared) {
                return;
            }
            INSTANCE.getClass();
            AtomicReference m6670a = m6670a();
            Segment segment2 = (Segment) m6670a.get();
            if (segment2 == f24754a) {
                return;
            }
            if (segment2 != null) {
                i = segment2.limit;
            } else {
                i = 0;
            }
            if (i >= 65536) {
                return;
            }
            segment.next = segment2;
            segment.pos = 0;
            segment.limit = i + 8192;
            while (!m6670a.compareAndSet(segment2, segment)) {
                if (m6670a.get() != segment2) {
                    segment.next = null;
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @JvmStatic
    @NotNull
    public static final Segment take() {
        INSTANCE.getClass();
        AtomicReference m6670a = m6670a();
        Segment segment = f24754a;
        Segment segment2 = (Segment) m6670a.getAndSet(segment);
        if (segment2 == segment) {
            return new Segment();
        }
        if (segment2 == null) {
            m6670a.set(null);
            return new Segment();
        }
        m6670a.set(segment2.next);
        segment2.next = null;
        segment2.limit = 0;
        return segment2;
    }

    public final int getByteCount() {
        Segment segment = (Segment) m6670a().get();
        if (segment == null) {
            return 0;
        }
        return segment.limit;
    }

    public final int getMAX_SIZE() {
        return 65536;
    }
}
