package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* renamed from: c1 */
/* loaded from: classes2.dex */
public class C0577c1 implements Iterator, KMappedMarker {

    /* renamed from: a */
    public final /* synthetic */ int f8222a = 0;

    /* renamed from: b */
    public int f8223b;

    /* renamed from: c */
    public final Object f8224c;

    public C0577c1(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f8224c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f8222a) {
            case 0:
                if (this.f8223b < ((AbstractList) this.f8224c).size()) {
                    return true;
                }
                return false;
            case 1:
                if (this.f8223b < ((Object[]) this.f8224c).length) {
                    return true;
                }
                return false;
            case 2:
                if (this.f8223b < ((byte[]) this.f8224c).length) {
                    return true;
                }
                return false;
            case 3:
                if (this.f8223b < ((int[]) this.f8224c).length) {
                    return true;
                }
                return false;
            case 4:
                if (this.f8223b < ((long[]) this.f8224c).length) {
                    return true;
                }
                return false;
            default:
                if (this.f8223b < ((short[]) this.f8224c).length) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f8222a) {
            case 0:
                if (hasNext()) {
                    int i = this.f8223b;
                    this.f8223b = i + 1;
                    return ((AbstractList) this.f8224c).get(i);
                }
                throw new NoSuchElementException();
            case 1:
                try {
                    Object[] objArr = (Object[]) this.f8224c;
                    int i2 = this.f8223b;
                    this.f8223b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f8223b--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 2:
                int i3 = this.f8223b;
                byte[] bArr = (byte[]) this.f8224c;
                if (i3 < bArr.length) {
                    this.f8223b = i3 + 1;
                    return UByte.m8521boximpl(UByte.m8522constructorimpl(bArr[i3]));
                }
                throw new NoSuchElementException(String.valueOf(this.f8223b));
            case 3:
                int i4 = this.f8223b;
                int[] iArr = (int[]) this.f8224c;
                if (i4 < iArr.length) {
                    this.f8223b = i4 + 1;
                    return UInt.m8545boximpl(UInt.m8546constructorimpl(iArr[i4]));
                }
                throw new NoSuchElementException(String.valueOf(this.f8223b));
            case 4:
                int i5 = this.f8223b;
                long[] jArr = (long[]) this.f8224c;
                if (i5 < jArr.length) {
                    this.f8223b = i5 + 1;
                    return ULong.m8569boximpl(ULong.m8570constructorimpl(jArr[i5]));
                }
                throw new NoSuchElementException(String.valueOf(this.f8223b));
            default:
                int i6 = this.f8223b;
                short[] sArr = (short[]) this.f8224c;
                if (i6 < sArr.length) {
                    this.f8223b = i6 + 1;
                    return UShort.m8593boximpl(UShort.m8594constructorimpl(sArr[i6]));
                }
                throw new NoSuchElementException(String.valueOf(this.f8223b));
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f8222a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 4:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0577c1(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f8224c = array;
    }

    public C0577c1(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f8224c = array;
    }

    public C0577c1(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f8224c = array;
    }

    public C0577c1(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f8224c = array;
    }

    public C0577c1(AbstractList abstractList) {
        this.f8224c = abstractList;
    }
}
