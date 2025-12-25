package p000;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: db */
/* loaded from: classes2.dex */
public final class C1116db extends IntIterator {

    /* renamed from: a */
    public final int[] f16325a;

    /* renamed from: b */
    public int f16326b;

    public C1116db(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f16325a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f16326b < this.f16325a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        try {
            int[] iArr = this.f16325a;
            int i = this.f16326b;
            this.f16326b = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f16326b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
