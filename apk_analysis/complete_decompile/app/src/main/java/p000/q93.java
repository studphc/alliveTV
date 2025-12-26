package p000;

import com.google.android.gms.internal.measurement.zzat;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q93 implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ Iterator f25494a;

    public q93(Iterator it) {
        this.f25494a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25494a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new zzat((String) this.f25494a.next());
    }
}
