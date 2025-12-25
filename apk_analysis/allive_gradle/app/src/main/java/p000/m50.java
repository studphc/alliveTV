package p000;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class m50 extends AbstractIterator {

    /* renamed from: c */
    public final Iterator f22802c;

    /* renamed from: d */
    public final Function1 f22803d;

    /* renamed from: e */
    public final HashSet f22804e;

    public m50(Iterator source, Function1 keySelector) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        this.f22802c = source;
        this.f22803d = keySelector;
        this.f22804e = new HashSet();
    }

    @Override // kotlin.collections.AbstractIterator
    public final void computeNext() {
        Object next;
        do {
            Iterator it = this.f22802c;
            if (it.hasNext()) {
                next = it.next();
            } else {
                done();
                return;
            }
        } while (!this.f22804e.add(this.f22803d.invoke(next)));
        setNext(next);
    }
}
