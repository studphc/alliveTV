package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes2.dex */
public final class sz2 implements Iterator, KMappedMarker {

    /* renamed from: a */
    public final long f26640a;

    /* renamed from: b */
    public boolean f26641b;

    /* renamed from: c */
    public final long f26642c;

    /* renamed from: d */
    public long f26643d;

    public sz2(long j, long j2, long j3) {
        this.f26640a = j2;
        boolean z = false;
        if (j3 <= 0 ? Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) >= 0 : Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) <= 0) {
            z = true;
        }
        this.f26641b = z;
        this.f26642c = ULong.m8570constructorimpl(j3);
        this.f26643d = this.f26641b ? j : j2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f26641b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j = this.f26643d;
        if (j == this.f26640a) {
            if (this.f26641b) {
                this.f26641b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f26643d = ULong.m8570constructorimpl(this.f26642c + j);
        }
        return ULong.m8569boximpl(j);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
