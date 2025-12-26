package p000;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ab */
/* loaded from: classes2.dex */
public final class C0012ab extends CharIterator {

    /* renamed from: a */
    public final char[] f104a;

    /* renamed from: b */
    public int f105b;

    public C0012ab(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f104a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f105b < this.f104a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.CharIterator
    public final char nextChar() {
        try {
            char[] cArr = this.f104a;
            int i = this.f105b;
            this.f105b = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f105b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
