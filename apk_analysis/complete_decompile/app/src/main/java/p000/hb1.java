package p000;

import com.google.common.cache.ConcurrentMapC0840e;

/* loaded from: classes.dex */
public final class hb1 extends jb1 {

    /* renamed from: j */
    public final /* synthetic */ int f18003j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hb1(ConcurrentMapC0840e concurrentMapC0840e, int i) {
        super(concurrentMapC0840e);
        this.f18003j = i;
    }

    @Override // p000.jb1, java.util.Iterator
    public Object next() {
        switch (this.f18003j) {
            case 1:
                return m5427d().f18017a;
            case 2:
                return m5427d().f18018b;
            default:
                return super.next();
        }
    }
}
