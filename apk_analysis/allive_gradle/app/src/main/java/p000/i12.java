package p000;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i12 implements Iterable {

    /* renamed from: a */
    public final /* synthetic */ int f18254a;

    /* renamed from: b */
    public final Iterable f18255b;

    public /* synthetic */ i12(Iterable iterable, int i) {
        this.f18254a = i;
        this.f18255b = iterable;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f18254a) {
            case 0:
                return new h12(this);
            case 1:
                return new oj2(this.f18255b.iterator(), 0);
            default:
                return ((ArrayList) this.f18255b).iterator();
        }
    }
}
