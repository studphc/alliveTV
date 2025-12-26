package p000;

import java.util.NoSuchElementException;
import kotlin.collections.ShortIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: kb */
/* loaded from: classes2.dex */
public final class C1385kb extends ShortIterator {

    /* renamed from: a */
    public final short[] f20808a;

    /* renamed from: b */
    public int f20809b;

    public C1385kb(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f20808a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f20809b < this.f20808a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.ShortIterator
    public final short nextShort() {
        try {
            short[] sArr = this.f20808a;
            int i = this.f20809b;
            this.f20809b = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f20809b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
