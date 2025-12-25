package p000;

import com.google.android.gms.internal.measurement.zzat;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class j93 implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ Iterator f20430a;

    /* renamed from: b */
    public final /* synthetic */ Iterator f20431b;

    public j93(Iterator it, Iterator it2) {
        this.f20430a = it;
        this.f20431b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f20430a.hasNext()) {
            return true;
        }
        return this.f20431b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.f20430a;
        if (it.hasNext()) {
            return new zzat(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f20431b;
        if (it2.hasNext()) {
            return new zzat((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
