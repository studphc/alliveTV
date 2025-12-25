package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class er2 extends gr2 {
    private static final long serialVersionUID = 0;

    @Override // p000.gr2, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new rg1(this, super.iterator(), 2);
    }
}
