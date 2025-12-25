package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001b¨\u0006#"}, m5569d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "<init>", "(JJJ)V", "Lkotlin/collections/LongIterator;", "iterator", "()Lkotlin/collections/LongIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "J", "getFirst", "()J", "first", "b", "getLast", "last", "c", "getStep", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final long first;

    /* renamed from: b, reason: from kotlin metadata */
    public final long last;

    /* renamed from: c, reason: from kotlin metadata */
    public final long step;

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/LongProgression;", "fromClosedRange", "(JJJ)Lkotlin/ranges/LongProgression;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final LongProgression fromClosedRange(long rangeStart, long rangeEnd, long step) {
            return new LongProgression(rangeStart, rangeEnd, step);
        }
    }

    public LongProgression(long j, long j2, long j3) {
        if (j3 != 0) {
            if (j3 != Long.MIN_VALUE) {
                this.first = j;
                this.last = ProgressionUtilKt.getProgressionLastElement(j, j2, j3);
                this.step = j3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof LongProgression) {
            if (!isEmpty() || !((LongProgression) other).isEmpty()) {
                LongProgression longProgression = (LongProgression) other;
                if (this.first != longProgression.first || this.last != longProgression.last || this.step != longProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = 31;
        long j2 = this.first;
        long j3 = this.last;
        long j4 = (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32))) * j;
        long j5 = this.step;
        return (int) (j4 + (j5 ^ (j5 >>> 32)));
    }

    public boolean isEmpty() {
        long j = this.step;
        long j2 = this.last;
        long j3 = this.first;
        if (j > 0) {
            if (j3 <= j2) {
                return false;
            }
        } else if (j3 >= j2) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j = this.step;
        long j2 = this.last;
        long j3 = this.first;
        if (j > 0) {
            sb = new StringBuilder();
            sb.append(j3);
            sb.append("..");
            sb.append(j2);
            sb.append(" step ");
            sb.append(j);
        } else {
            sb = new StringBuilder();
            sb.append(j3);
            sb.append(" downTo ");
            sb.append(j2);
            sb.append(" step ");
            sb.append(-j);
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Long> iterator() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }
}
