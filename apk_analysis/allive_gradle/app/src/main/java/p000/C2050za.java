package p000;

import java.util.NoSuchElementException;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: za */
/* loaded from: classes2.dex */
public final class C2050za extends ByteIterator {

    /* renamed from: a */
    public final byte[] f29295a;

    /* renamed from: b */
    public int f29296b;

    public C2050za(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f29295a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f29296b < this.f29295a.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.ByteIterator
    public final byte nextByte() {
        try {
            byte[] bArr = this.f29295a;
            int i = this.f29296b;
            this.f29296b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29296b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
