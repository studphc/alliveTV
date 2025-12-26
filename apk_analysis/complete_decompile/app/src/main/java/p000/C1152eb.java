package p000;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: eb */
/* loaded from: classes2.dex */
public final class C1152eb extends LongIterator {

    /* renamed from: a */
    public final long[] f16745a;

    /* renamed from: b */
    public int f16746b;

    public C1152eb(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f16745a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f16746b < this.f16745a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.LongIterator
    public final long nextLong() {
        try {
            long[] jArr = this.f16745a;
            int i = this.f16746b;
            this.f16746b = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f16746b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
