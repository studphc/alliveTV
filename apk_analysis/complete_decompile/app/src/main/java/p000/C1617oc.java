package p000;

import androidx.collection.LruCache;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* renamed from: oc */
/* loaded from: classes.dex */
public final class C1617oc implements InterfaceC1580nc {

    /* renamed from: c */
    public Object f23761c = new C1617oc[256];

    /* renamed from: a */
    public int f23759a = 0;

    /* renamed from: b */
    public int f23760b = 0;

    @Override // p000.InterfaceC1580nc
    /* renamed from: a */
    public int mo6340a() {
        return this.f23759a;
    }

    @Override // p000.InterfaceC1580nc
    /* renamed from: b */
    public int mo6341b() {
        return this.f23760b;
    }

    @Override // p000.InterfaceC1580nc
    /* renamed from: c */
    public int mo6342c() {
        int i = this.f23759a;
        if (i == -1) {
            return ((ParsableByteArray) this.f23761c).readUnsignedIntToInt();
        }
        return i;
    }

    /* renamed from: d */
    public void m6560d() {
        int i = this.f23759a;
        if (i == 2) {
            if (this.f23760b > 0) {
                LruCache lruCache = (LruCache) this.f23761c;
                if (lruCache == null || lruCache.maxSize() != this.f23760b) {
                    this.f23761c = new LruCache(this.f23760b);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException();
        }
        if (i != 3 && i != 1) {
            this.f23761c = null;
            return;
        }
        LruCache lruCache2 = (LruCache) this.f23761c;
        if (lruCache2 == null || lruCache2.maxSize() != Integer.MAX_VALUE) {
            this.f23761c = new LruCache(Integer.MAX_VALUE);
        }
    }
}
