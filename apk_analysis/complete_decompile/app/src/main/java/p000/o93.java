package p000;

import com.google.android.gms.internal.common.zzak;
import com.google.android.gms.internal.common.zzao;
import com.google.android.gms.internal.common.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class o93 extends zzao {

    /* renamed from: a */
    public final int f23674a;

    /* renamed from: b */
    public int f23675b;

    /* renamed from: c */
    public final zzak f23676c;

    public o93(zzak zzakVar, int i) {
        int size = zzakVar.size();
        zzv.zzb(i, size, FirebaseAnalytics.Param.INDEX);
        this.f23674a = size;
        this.f23675b = i;
        this.f23676c = zzakVar;
    }

    /* renamed from: a */
    public final Object m6524a(int i) {
        return this.f23676c.get(i);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f23675b < this.f23674a) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f23675b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i = this.f23675b;
            this.f23675b = i + 1;
            return m6524a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f23675b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.f23675b - 1;
            this.f23675b = i;
            return m6524a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f23675b - 1;
    }
}
