package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.q0 */
/* loaded from: classes.dex */
public final class C0501q0 {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView f7466a;

    public C0501q0(RecyclerView recyclerView) {
        this.f7466a = recyclerView;
    }

    /* renamed from: a */
    public final void m1878a(int i) {
        RecyclerView recyclerView = this.f7466a;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            recyclerView.m1716o(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
