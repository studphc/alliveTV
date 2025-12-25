package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0014\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0016\u0010\u0017\u0088\u0001\u0003\u0092\u0001\u00020\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m5569d2 = {"Lkotlin/UShort;", "", "", DataSchemeDataSource.SCHEME_DATA, "constructor-impl", "(S)S", "", "toString-impl", "(S)Ljava/lang/String;", "toString", "", "hashCode-impl", "(S)I", "hashCode", "", "other", "", "equals-impl", "(SLjava/lang/Object;)Z", "equals", "a", ExifInterface.LATITUDE_SOUTH, "getData$annotations", "()V", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes2.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;

    /* renamed from: a, reason: from kotlin metadata */
    public final short data;

    public /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m8593boximpl(short s) {
        return new UShort(s);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m8594constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m8595equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8596equalsimpl0(short s, short s2) {
        return s == s2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m8597hashCodeimpl(short s) {
        return s;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m8598toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(getData() & MAX_VALUE, uShort.getData() & MAX_VALUE);
    }

    public boolean equals(Object obj) {
        return m8595equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m8597hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m8598toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }
}
