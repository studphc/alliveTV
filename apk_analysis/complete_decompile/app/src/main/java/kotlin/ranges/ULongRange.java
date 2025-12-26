package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.5")
@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\b\u001a\u00020\u00038VX\u0097\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d"}, m5569d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes2.dex */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d */
    public static final ULongRange f21243d = new ULongRange(-1, 0, null);

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "Lkotlin/ranges/ULongRange;", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final ULongRange getEMPTY() {
            return ULongRange.f21243d;
        }
    }

    public ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        super(j, j2, 1L, null);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    /* renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m8699getEndExclusivesVKNKU$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(ULong uLong) {
        return m8700containsVKZWuLQ(uLong.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m8700containsVKZWuLQ(long value) {
        long j = value ^ Long.MIN_VALUE;
        if (Long.compare(getFirst() ^ Long.MIN_VALUE, j) <= 0 && Long.compare(j, getLast() ^ Long.MIN_VALUE) <= 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(@Nullable Object other) {
        if (other instanceof ULongRange) {
            if (!isEmpty() || !((ULongRange) other).isEmpty()) {
                ULongRange uLongRange = (ULongRange) other;
                if (getFirst() != uLongRange.getFirst() || getLast() != uLongRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ ULong getEndExclusive() {
        return ULong.m8569boximpl(m8701getEndExclusivesVKNKU());
    }

    /* renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m8701getEndExclusivesVKNKU() {
        if (getLast() != -1) {
            return ULong.m8570constructorimpl(ULong.m8570constructorimpl(1 & 4294967295L) + getLast());
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getEndInclusive() {
        return ULong.m8569boximpl(m8702getEndInclusivesVKNKU());
    }

    /* renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m8702getEndInclusivesVKNKU() {
        return getLast();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getStart() {
        return ULong.m8569boximpl(m8703getStartsVKNKU());
    }

    /* renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m8703getStartsVKNKU() {
        return getFirst();
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m8570constructorimpl(getFirst() ^ ULong.m8570constructorimpl(getFirst() >>> 32))) * 31) + ((int) ULong.m8570constructorimpl(getLast() ^ ULong.m8570constructorimpl(getLast() >>> 32)));
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (Long.compare(getFirst() ^ Long.MIN_VALUE, getLast() ^ Long.MIN_VALUE) > 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    @NotNull
    public String toString() {
        return ((Object) ULong.m8574toStringimpl(getFirst())) + ".." + ((Object) ULong.m8574toStringimpl(getLast()));
    }
}
