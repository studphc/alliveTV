package com.google.common.collect;

/* renamed from: com.google.common.collect.l3 */
/* loaded from: classes.dex */
public final class C0900l3 extends AbstractC0955y1 {

    /* renamed from: a */
    public final /* synthetic */ C0915o3 f14881a;

    /* renamed from: b */
    public final /* synthetic */ TreeMultiset f14882b;

    public C0900l3(TreeMultiset treeMultiset, C0915o3 c0915o3) {
        this.f14882b = treeMultiset;
        this.f14881a = c0915o3;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final int getCount() {
        C0915o3 c0915o3 = this.f14881a;
        int i = c0915o3.f14918b;
        if (i == 0) {
            return this.f14882b.count(c0915o3.f14917a);
        }
        return i;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final Object getElement() {
        return this.f14881a.f14917a;
    }
}
