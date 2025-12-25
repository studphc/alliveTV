package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.j1 */
/* loaded from: classes.dex */
public final class C0485j1 {

    /* renamed from: d */
    public static final Pools.SimplePool f7414d = new Pools.SimplePool(20);

    /* renamed from: a */
    public int f7415a;

    /* renamed from: b */
    public RecyclerView.ItemAnimator.ItemHolderInfo f7416b;

    /* renamed from: c */
    public RecyclerView.ItemAnimator.ItemHolderInfo f7417c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.recyclerview.widget.j1, java.lang.Object] */
    /* renamed from: a */
    public static C0485j1 m1873a() {
        C0485j1 c0485j1 = (C0485j1) f7414d.acquire();
        if (c0485j1 == null) {
            return new Object();
        }
        return c0485j1;
    }
}
