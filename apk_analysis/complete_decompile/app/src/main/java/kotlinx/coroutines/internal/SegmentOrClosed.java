package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m5569d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class SegmentOrClosed<S extends Segment<S>> {

    /* renamed from: a */
    public final Object f22040a;

    public /* synthetic */ SegmentOrClosed(Object obj) {
        this.f22040a = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SegmentOrClosed m8900boximpl(Object obj) {
        return new SegmentOrClosed(obj);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <S extends Segment<S>> Object m8901constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m8902equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && Intrinsics.areEqual(obj, ((SegmentOrClosed) obj2).getF22040a());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8903equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    @NotNull
    /* renamed from: getSegment-impl, reason: not valid java name */
    public static final S m8904getSegmentimpl(Object obj) {
        if (obj != ConcurrentLinkedListKt.f22005a) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m8905hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m8906isClosedimpl(Object obj) {
        if (obj == ConcurrentLinkedListKt.f22005a) {
            return true;
        }
        return false;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m8907toStringimpl(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m8902equalsimpl(this.f22040a, obj);
    }

    public int hashCode() {
        return m8905hashCodeimpl(this.f22040a);
    }

    public String toString() {
        return m8907toStringimpl(this.f22040a);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Object getF22040a() {
        return this.f22040a;
    }
}
