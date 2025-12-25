package p000;

import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: ic */
/* loaded from: classes.dex */
public final class C1301ic extends AbstractC1386kc {

    /* renamed from: b */
    public final long f18359b;

    /* renamed from: c */
    public final ArrayList f18360c;

    /* renamed from: d */
    public final ArrayList f18361d;

    public C1301ic(int i, long j) {
        super(i);
        this.f18359b = j;
        this.f18360c = new ArrayList();
        this.f18361d = new ArrayList();
    }

    /* renamed from: c */
    public final C1301ic m5206c(int i) {
        ArrayList arrayList = this.f18361d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1301ic c1301ic = (C1301ic) arrayList.get(i2);
            if (c1301ic.f20817a == i) {
                return c1301ic;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final C1349jc m5207d(int i) {
        ArrayList arrayList = this.f18360c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1349jc c1349jc = (C1349jc) arrayList.get(i2);
            if (c1349jc.f20817a == i) {
                return c1349jc;
            }
        }
        return null;
    }

    @Override // p000.AbstractC1386kc
    public final String toString() {
        return AbstractC1386kc.m5517a(this.f20817a) + " leaves: " + Arrays.toString(this.f18360c.toArray()) + " containers: " + Arrays.toString(this.f18361d.toArray());
    }
}
