package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.sz2;

@SinceKotlin(version = "1.5")
@Metadata(m5568d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0017\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B$\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006$"}, m5569d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "", "step", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "iterator", "()Ljava/util/Iterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "J", "getFirst-s-VKNKU", "()J", "first", "b", "getLast-s-VKNKU", "last", "c", "getStep", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes2.dex */
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final long first;

    /* renamed from: b, reason: from kotlin metadata */
    public final long last;

    /* renamed from: c, reason: from kotlin metadata */
    public final long step;

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m5569d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "Lkotlin/ULong;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/ULongProgression;", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "fromClosedRange", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        /* renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final ULongProgression m8698fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new ULongProgression(rangeStart, rangeEnd, step, null);
        }
    }

    public ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        if (j3 != 0) {
            if (j3 != Long.MIN_VALUE) {
                this.first = j;
                this.last = UProgressionUtilKt.m8677getProgressionLastElement7ftBX0g(j, j2, j3);
                this.step = j3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) other).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) other;
                if (this.first != uLongProgression.first || this.last != uLongProgression.last || this.step != uLongProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-s-VKNKU, reason: not valid java name and from getter */
    public final long getFirst() {
        return this.first;
    }

    /* renamed from: getLast-s-VKNKU, reason: not valid java name and from getter */
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
        long j = this.first;
        int m8570constructorimpl = ((int) ULong.m8570constructorimpl(j ^ ULong.m8570constructorimpl(j >>> 32))) * 31;
        long j2 = this.last;
        int m8570constructorimpl2 = (m8570constructorimpl + ((int) ULong.m8570constructorimpl(j2 ^ ULong.m8570constructorimpl(j2 >>> 32)))) * 31;
        long j3 = this.step;
        return m8570constructorimpl2 + ((int) ((j3 >>> 32) ^ j3));
    }

    public boolean isEmpty() {
        long j = this.step;
        long j2 = this.last;
        long j3 = this.first;
        if (j > 0) {
            if (Long.compare(j3 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) <= 0) {
                return false;
            }
        } else if (Long.compare(j3 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<ULong> iterator() {
        return new sz2(this.first, this.last, this.step);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j = this.step;
        long j2 = this.last;
        long j3 = this.first;
        if (j > 0) {
            sb = new StringBuilder();
            sb.append((Object) ULong.m8574toStringimpl(j3));
            sb.append("..");
            sb.append((Object) ULong.m8574toStringimpl(j2));
            sb.append(" step ");
            sb.append(j);
        } else {
            sb = new StringBuilder();
            sb.append((Object) ULong.m8574toStringimpl(j3));
            sb.append(" downTo ");
            sb.append((Object) ULong.m8574toStringimpl(j2));
            sb.append(" step ");
            sb.append(-j);
        }
        return sb.toString();
    }
}
