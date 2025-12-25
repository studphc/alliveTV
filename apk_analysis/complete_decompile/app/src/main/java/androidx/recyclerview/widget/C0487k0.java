package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import p000.g43;

/* renamed from: androidx.recyclerview.widget.k0 */
/* loaded from: classes.dex */
public final class C0487k0 {

    /* renamed from: a */
    public final ViewTypeStorage$ViewTypeLookup f7422a;

    /* renamed from: b */
    public final StableIdStorage$StableIdLookup f7423b;

    /* renamed from: c */
    public final RecyclerView.Adapter f7424c;

    /* renamed from: d */
    public final C0477h f7425d;

    /* renamed from: e */
    public int f7426e;

    /* renamed from: f */
    public final C0484j0 f7427f;

    public C0487k0(RecyclerView.Adapter adapter, C0477h c0477h, g43 g43Var, StableIdStorage$StableIdLookup stableIdStorage$StableIdLookup) {
        C0484j0 c0484j0 = new C0484j0(this);
        this.f7427f = c0484j0;
        this.f7424c = adapter;
        this.f7425d = c0477h;
        this.f7422a = g43Var.createViewTypeWrapper(this);
        this.f7423b = stableIdStorage$StableIdLookup;
        this.f7426e = adapter.getItemCount();
        adapter.registerAdapterDataObserver(c0484j0);
    }
}
