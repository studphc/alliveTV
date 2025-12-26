package p000;

import com.google.common.collect.EnumMultiset;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class s90 implements Iterator {

    /* renamed from: a */
    public int f26319a = 0;

    /* renamed from: b */
    public int f26320b = -1;

    /* renamed from: c */
    public final /* synthetic */ EnumMultiset f26321c;

    public s90(EnumMultiset enumMultiset) {
        this.f26321c = enumMultiset;
    }

    /* renamed from: a */
    public abstract Object mo4165a(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f26319a;
            EnumMultiset enumMultiset = this.f26321c;
            if (i < enumMultiset.f14631d.length) {
                if (enumMultiset.f14632e[i] > 0) {
                    return true;
                }
                this.f26319a = i + 1;
            } else {
                return false;
            }
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Object mo4165a = mo4165a(this.f26319a);
            int i = this.f26319a;
            this.f26320b = i;
            this.f26319a = i + 1;
            return mo4165a;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        if (this.f26320b >= 0) {
            z = true;
        } else {
            z = false;
        }
        p63.m6876t(z);
        EnumMultiset enumMultiset = this.f26321c;
        int[] iArr = enumMultiset.f14632e;
        int i = this.f26320b;
        int i2 = iArr[i];
        if (i2 > 0) {
            enumMultiset.f14633f--;
            enumMultiset.f14634g -= i2;
            iArr[i] = 0;
        }
        this.f26320b = -1;
    }
}
