package p000;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: jr */
/* loaded from: classes.dex */
public final class C1364jr implements Iterator {

    /* renamed from: a */
    public int f20588a;

    /* renamed from: b */
    public int f20589b;

    /* renamed from: c */
    public int f20590c = -1;

    /* renamed from: d */
    public final /* synthetic */ C1484kr f20591d;

    public C1364jr(C1484kr c1484kr) {
        this.f20591d = c1484kr;
        this.f20588a = c1484kr.f22163d;
        this.f20589b = c1484kr.mo5770f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f20589b >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C1484kr c1484kr = this.f20591d;
        if (c1484kr.f22163d == this.f20588a) {
            if (hasNext()) {
                int i = this.f20589b;
                this.f20590c = i;
                Object obj = c1484kr.m5776l()[i];
                this.f20589b = c1484kr.mo5771g(this.f20589b);
                return obj;
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        C1484kr c1484kr = this.f20591d;
        if (c1484kr.f22163d == this.f20588a) {
            if (this.f20590c >= 0) {
                z = true;
            } else {
                z = false;
            }
            p63.m6876t(z);
            this.f20588a += 32;
            c1484kr.remove(c1484kr.m5776l()[this.f20590c]);
            this.f20589b = c1484kr.mo5766a(this.f20589b, this.f20590c);
            this.f20590c = -1;
            return;
        }
        throw new ConcurrentModificationException();
    }
}
