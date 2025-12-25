package p000;

import java.util.NoSuchElementException;
import kotlin.collections.DoubleIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: bb */
/* loaded from: classes2.dex */
public final class C0551bb extends DoubleIterator {

    /* renamed from: a */
    public final double[] f7945a;

    /* renamed from: b */
    public int f7946b;

    public C0551bb(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f7945a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f7946b < this.f7945a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.DoubleIterator
    public final double nextDouble() {
        try {
            double[] dArr = this.f7945a;
            int i = this.f7946b;
            this.f7946b = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f7946b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
