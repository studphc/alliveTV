package p000;

import java.util.NoSuchElementException;
import kotlin.collections.BooleanIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ya */
/* loaded from: classes2.dex */
public final class C2013ya extends BooleanIterator {

    /* renamed from: a */
    public final boolean[] f28877a;

    /* renamed from: b */
    public int f28878b;

    public C2013ya(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f28877a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f28878b < this.f28877a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.BooleanIterator
    public final boolean nextBoolean() {
        try {
            boolean[] zArr = this.f28877a;
            int i = this.f28878b;
            this.f28878b = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f28878b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
