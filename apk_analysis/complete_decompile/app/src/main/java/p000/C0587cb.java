package p000;

import java.util.NoSuchElementException;
import kotlin.collections.FloatIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: cb */
/* loaded from: classes2.dex */
public final class C0587cb extends FloatIterator {

    /* renamed from: a */
    public final float[] f8312a;

    /* renamed from: b */
    public int f8313b;

    public C0587cb(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f8312a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8313b < this.f8312a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.FloatIterator
    public final float nextFloat() {
        try {
            float[] fArr = this.f8312a;
            int i = this.f8313b;
            this.f8313b = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f8313b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
