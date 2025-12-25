package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.o0 */
/* loaded from: classes.dex */
public final class RunnableC0497o0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView f7453a;

    public RunnableC0497o0(RecyclerView recyclerView) {
        this.f7453a = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView = this.f7453a;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.f7090N;
        if (itemAnimator != null) {
            itemAnimator.runPendingAnimations();
        }
        recyclerView.f7129o0 = false;
    }
}
