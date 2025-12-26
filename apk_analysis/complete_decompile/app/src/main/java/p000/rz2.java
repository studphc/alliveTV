package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes2.dex */
public final class rz2 implements Iterator, KMappedMarker {

    /* renamed from: a */
    public final int f26196a;

    /* renamed from: b */
    public boolean f26197b;

    /* renamed from: c */
    public final int f26198c;

    /* renamed from: d */
    public int f26199d;

    public rz2(int i, int i2, int i3) {
        this.f26196a = i2;
        boolean z = false;
        if (i3 <= 0 ? Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) >= 0 : Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) <= 0) {
            z = true;
        }
        this.f26197b = z;
        this.f26198c = UInt.m8546constructorimpl(i3);
        this.f26199d = this.f26197b ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f26197b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f26199d;
        if (i == this.f26196a) {
            if (this.f26197b) {
                this.f26197b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f26199d = UInt.m8546constructorimpl(this.f26198c + i);
        }
        return UInt.m8545boximpl(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
