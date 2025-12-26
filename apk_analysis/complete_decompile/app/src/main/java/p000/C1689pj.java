package p000;

import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: pj */
/* loaded from: classes.dex */
public final class C1689pj implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f25193a;

    /* renamed from: b */
    public int f25194b;

    /* renamed from: c */
    public Iterable f25195c;

    public /* synthetic */ C1689pj() {
        this.f25193a = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f25193a) {
            case 0:
                if (this.f25194b < ((CLObject) this.f25195c).size()) {
                    return true;
                }
                return false;
            default:
                if (this.f25194b < ((zzae) this.f25195c).zzc()) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f25193a) {
            case 0:
                CLKey cLKey = (CLKey) ((CLObject) this.f25195c).f2277c.get(this.f25194b);
                this.f25194b++;
                return cLKey;
            default:
                int i = this.f25194b;
                zzae zzaeVar = (zzae) this.f25195c;
                if (i < zzaeVar.zzc()) {
                    int i2 = this.f25194b;
                    this.f25194b = i2 + 1;
                    return zzaeVar.zze(i2);
                }
                throw new NoSuchElementException(ye0.m8291k(this.f25194b, "Out of bounds index: "));
        }
    }

    public C1689pj(zzae zzaeVar) {
        this.f25193a = 1;
        this.f25195c = zzaeVar;
        this.f25194b = 0;
    }
}
