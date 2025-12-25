package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.NoSuchElementException;

/* renamed from: a1 */
/* loaded from: classes.dex */
public abstract class AbstractC0002a1 extends UnmodifiableListIterator {

    /* renamed from: a */
    public final int f12a;

    /* renamed from: b */
    public int f13b;

    public AbstractC0002a1(int i, int i2) {
        Preconditions.checkPositionIndex(i2, i);
        this.f12a = i;
        this.f13b = i2;
    }

    /* renamed from: a */
    public abstract Object mo1a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f13b < this.f12a) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f13b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i = this.f13b;
            this.f13b = i + 1;
            return mo1a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.f13b - 1;
            this.f13b = i;
            return mo1a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13b - 1;
    }
}
