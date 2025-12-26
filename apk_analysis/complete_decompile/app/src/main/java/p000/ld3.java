package p000;

import com.google.android.gms.measurement.internal.zzgn;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ld3 extends zzgn {

    /* renamed from: a */
    public final /* synthetic */ AtomicReference f22473a;

    public ld3(AtomicReference atomicReference) {
        this.f22473a = atomicReference;
    }

    @Override // com.google.android.gms.measurement.internal.zzgo
    public final void zze(List list) {
        AtomicReference atomicReference = this.f22473a;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
