package p000;

import com.google.android.gms.internal.measurement.zzat;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class t93 implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f26732a;

    /* renamed from: b */
    public int f26733b = 0;

    /* renamed from: c */
    public final /* synthetic */ zzat f26734c;

    public /* synthetic */ t93(zzat zzatVar, int i) {
        this.f26732a = i;
        this.f26734c = zzatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f26732a) {
            case 0:
                if (this.f26733b < this.f26734c.f13785a.length()) {
                    return true;
                }
                return false;
            default:
                if (this.f26733b < this.f26734c.f13785a.length()) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        switch (this.f26732a) {
            case 0:
                int i = this.f26733b;
                if (i < this.f26734c.f13785a.length()) {
                    this.f26733b = i + 1;
                    return new zzat(String.valueOf(i));
                }
                throw new NoSuchElementException();
            default:
                int i2 = this.f26733b;
                zzat zzatVar = this.f26734c;
                if (i2 < zzatVar.f13785a.length()) {
                    this.f26733b = i2 + 1;
                    return new zzat(String.valueOf(zzatVar.f13785a.charAt(i2)));
                }
                throw new NoSuchElementException();
        }
    }
}
