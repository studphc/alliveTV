package p000;

import com.google.android.gms.internal.measurement.zzkz;
import com.google.android.gms.internal.measurement.zzld;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class qc3 implements zzkz {

    /* renamed from: a */
    public int f25515a = 0;

    /* renamed from: b */
    public final int f25516b;

    /* renamed from: c */
    public final /* synthetic */ zzld f25517c;

    public qc3(zzld zzldVar) {
        this.f25517c = zzldVar;
        this.f25516b = zzldVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f25515a < this.f25516b) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(zza());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final byte zza() {
        int i = this.f25515a;
        if (i < this.f25516b) {
            this.f25515a = i + 1;
            return this.f25517c.mo3463a(i);
        }
        throw new NoSuchElementException();
    }
}
