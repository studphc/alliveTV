package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.rz2;

@SinceKotlin(version = "1.5")
@Metadata(m5568d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\b\u0017\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B$\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0014R\u001d\u0010\u001e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u0014ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\""}, m5569d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "", "step", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "iterator", "()Ljava/util/Iterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "I", "getFirst-pVg5ArA", "first", "b", "getLast-pVg5ArA", "last", "c", "getStep", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes2.dex */
public class UIntProgression implements Iterable<UInt>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final int first;

    /* renamed from: b, reason: from kotlin metadata */
    public final int last;

    /* renamed from: c, reason: from kotlin metadata */
    public final int step;

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m5569d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "Lkotlin/UInt;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/UIntProgression;", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "fromClosedRange", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        /* renamed from: fromClosedRange-Nkh28Cs, reason: not valid java name */
        public final UIntProgression m8690fromClosedRangeNkh28Cs(int rangeStart, int rangeEnd, int step) {
            return new UIntProgression(rangeStart, rangeEnd, step, null);
        }
    }

    public UIntProgression(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if (i3 != 0) {
            if (i3 != Integer.MIN_VALUE) {
                this.first = i;
                this.last = UProgressionUtilKt.m8678getProgressionLastElementNkh28Cs(i, i2, i3);
                this.step = i3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof UIntProgression) {
            if (!isEmpty() || !((UIntProgression) other).isEmpty()) {
                UIntProgression uIntProgression = (UIntProgression) other;
                if (this.first != uIntProgression.first || this.last != uIntProgression.last || this.step != uIntProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-pVg5ArA, reason: not valid java name and from getter */
    public final int getFirst() {
        return this.first;
    }

    /* renamed from: getLast-pVg5ArA, reason: not valid java name and from getter */
    public final int getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        int i = this.step;
        int i2 = this.last;
        int i3 = this.first;
        if (i > 0) {
            if (Integer.compare(i3 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) <= 0) {
                return false;
            }
        } else if (Integer.compare(i3 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<UInt> iterator() {
        return new rz2(this.first, this.last, this.step);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i = this.last;
        int i2 = this.first;
        int i3 = this.step;
        if (i3 > 0) {
            sb = new StringBuilder();
            sb.append((Object) UInt.m8550toStringimpl(i2));
            sb.append("..");
            sb.append((Object) UInt.m8550toStringimpl(i));
            sb.append(" step ");
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append((Object) UInt.m8550toStringimpl(i2));
            sb.append(" downTo ");
            sb.append((Object) UInt.m8550toStringimpl(i));
            sb.append(" step ");
            sb.append(-i3);
        }
        return sb.toString();
    }
}
