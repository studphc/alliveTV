package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m5569d2 = {"Lkotlin/UByteArray;", "array", "", "fromIndex", "toIndex", "", "sortArray-4UcCI2c", "([BII)V", "sortArray", "Lkotlin/UShortArray;", "sortArray-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "sortArray-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "sortArray--nroSd4", "([JII)V", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class UArraySortingKt {
    /* renamed from: a */
    public static final void m5582a(long[] jArr, int i, int i2) {
        long j;
        long m8583getsVKNKU = ULongArray.m8583getsVKNKU(jArr, (i + i2) / 2);
        int i3 = i;
        int i4 = i2;
        while (i3 <= i4) {
            while (true) {
                j = m8583getsVKNKU ^ Long.MIN_VALUE;
                if (Long.compare(ULongArray.m8583getsVKNKU(jArr, i3) ^ Long.MIN_VALUE, j) >= 0) {
                    break;
                } else {
                    i3++;
                }
            }
            while (Long.compare(ULongArray.m8583getsVKNKU(jArr, i4) ^ Long.MIN_VALUE, j) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                long m8583getsVKNKU2 = ULongArray.m8583getsVKNKU(jArr, i3);
                ULongArray.m8588setk8EXiF4(jArr, i3, ULongArray.m8583getsVKNKU(jArr, i4));
                ULongArray.m8588setk8EXiF4(jArr, i4, m8583getsVKNKU2);
                i3++;
                i4--;
            }
        }
        int i5 = i3 - 1;
        if (i < i5) {
            m5582a(jArr, i, i5);
        }
        if (i3 < i2) {
            m5582a(jArr, i3, i2);
        }
    }

    /* renamed from: b */
    public static final void m5583b(byte[] bArr, int i, int i2) {
        int i3;
        byte m8535getw2LRezQ = UByteArray.m8535getw2LRezQ(bArr, (i + i2) / 2);
        int i4 = i;
        int i5 = i2;
        while (i4 <= i5) {
            while (true) {
                i3 = m8535getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m8535getw2LRezQ(bArr, i4) & 255, i3) >= 0) {
                    break;
                } else {
                    i4++;
                }
            }
            while (Intrinsics.compare(UByteArray.m8535getw2LRezQ(bArr, i5) & 255, i3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                byte m8535getw2LRezQ2 = UByteArray.m8535getw2LRezQ(bArr, i4);
                UByteArray.m8540setVurrAj0(bArr, i4, UByteArray.m8535getw2LRezQ(bArr, i5));
                UByteArray.m8540setVurrAj0(bArr, i5, m8535getw2LRezQ2);
                i4++;
                i5--;
            }
        }
        int i6 = i4 - 1;
        if (i < i6) {
            m5583b(bArr, i, i6);
        }
        if (i4 < i2) {
            m5583b(bArr, i4, i2);
        }
    }

    /* renamed from: c */
    public static final void m5584c(short[] sArr, int i, int i2) {
        int i3;
        short m8607getMh2AYeg = UShortArray.m8607getMh2AYeg(sArr, (i + i2) / 2);
        int i4 = i;
        int i5 = i2;
        while (i4 <= i5) {
            while (true) {
                int m8607getMh2AYeg2 = UShortArray.m8607getMh2AYeg(sArr, i4) & UShort.MAX_VALUE;
                i3 = m8607getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m8607getMh2AYeg2, i3) >= 0) {
                    break;
                } else {
                    i4++;
                }
            }
            while (Intrinsics.compare(UShortArray.m8607getMh2AYeg(sArr, i5) & UShort.MAX_VALUE, i3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                short m8607getMh2AYeg3 = UShortArray.m8607getMh2AYeg(sArr, i4);
                UShortArray.m8612set01HTLdE(sArr, i4, UShortArray.m8607getMh2AYeg(sArr, i5));
                UShortArray.m8612set01HTLdE(sArr, i5, m8607getMh2AYeg3);
                i4++;
                i5--;
            }
        }
        int i6 = i4 - 1;
        if (i < i6) {
            m5584c(sArr, i, i6);
        }
        if (i4 < i2) {
            m5584c(sArr, i4, i2);
        }
    }

    /* renamed from: d */
    public static final void m5585d(int i, int i2, int[] iArr) {
        int i3;
        int m8559getpVg5ArA = UIntArray.m8559getpVg5ArA(iArr, (i + i2) / 2);
        int i4 = i;
        int i5 = i2;
        while (i4 <= i5) {
            while (true) {
                i3 = m8559getpVg5ArA ^ Integer.MIN_VALUE;
                if (Integer.compare(UIntArray.m8559getpVg5ArA(iArr, i4) ^ Integer.MIN_VALUE, i3) >= 0) {
                    break;
                } else {
                    i4++;
                }
            }
            while (Integer.compare(UIntArray.m8559getpVg5ArA(iArr, i5) ^ Integer.MIN_VALUE, i3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                int m8559getpVg5ArA2 = UIntArray.m8559getpVg5ArA(iArr, i4);
                UIntArray.m8564setVXSXFK8(iArr, i4, UIntArray.m8559getpVg5ArA(iArr, i5));
                UIntArray.m8564setVXSXFK8(iArr, i5, m8559getpVg5ArA2);
                i4++;
                i5--;
            }
        }
        int i6 = i4 - 1;
        if (i < i6) {
            m5585d(i, i6, iArr);
        }
        if (i4 < i2) {
            m5585d(i4, i2, iArr);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m8629sortArraynroSd4(@NotNull long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5582a(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m8630sortArray4UcCI2c(@NotNull byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5583b(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m8631sortArrayAa5vz7o(@NotNull short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5584c(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m8632sortArrayoBK06Vg(@NotNull int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5585d(i, i2 - 1, array);
    }
}
