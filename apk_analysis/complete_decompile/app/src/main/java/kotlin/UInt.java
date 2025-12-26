package kotlin;

import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0014\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015\u0088\u0001\u0003\u0092\u0001\u00020\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m5569d2 = {"Lkotlin/UInt;", "", "", DataSchemeDataSource.SCHEME_DATA, "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "equals", "a", "I", "getData$annotations", "()V", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes2.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;

    /* renamed from: a, reason: from kotlin metadata */
    public final int data;

    public /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m8545boximpl(int i) {
        return new UInt(i);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m8546constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m8547equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8548equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m8549hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m8550toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    public boolean equals(Object obj) {
        return m8547equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m8549hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m8550toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }
}
