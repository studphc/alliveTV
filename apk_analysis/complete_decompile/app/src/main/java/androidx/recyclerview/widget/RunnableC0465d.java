package androidx.recyclerview.widget;

import java.util.List;

/* renamed from: androidx.recyclerview.widget.d */
/* loaded from: classes.dex */
public final class RunnableC0465d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ List f7332a;

    /* renamed from: b */
    public final /* synthetic */ List f7333b;

    /* renamed from: c */
    public final /* synthetic */ int f7334c;

    /* renamed from: d */
    public final /* synthetic */ Runnable f7335d;

    /* renamed from: e */
    public final /* synthetic */ AsyncListDiffer f7336e;

    public RunnableC0465d(AsyncListDiffer asyncListDiffer, List list, List list2, int i, Runnable runnable) {
        this.f7336e = asyncListDiffer;
        this.f7332a = list;
        this.f7333b = list2;
        this.f7334c = i;
        this.f7335d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7336e.f6933c.execute(new RunnableC0462c(this, DiffUtil.calculateDiff(new C0459b(this))));
    }
}
