package p000;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class rv2 implements Iterator {

    /* renamed from: a */
    public final Iterator f26165a;

    public rv2(Iterator it) {
        this.f26165a = (Iterator) Preconditions.checkNotNull(it);
    }

    /* renamed from: a */
    public abstract Object mo4106a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f26165a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return mo4106a(this.f26165a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f26165a.remove();
    }
}
