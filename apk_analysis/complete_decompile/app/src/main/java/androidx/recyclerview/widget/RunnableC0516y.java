package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: androidx.recyclerview.widget.y */
/* loaded from: classes.dex */
public final class RunnableC0516y implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0514x f7522a;

    /* renamed from: b */
    public final /* synthetic */ int f7523b;

    /* renamed from: c */
    public final /* synthetic */ ItemTouchHelper f7524c;

    public RunnableC0516y(ItemTouchHelper itemTouchHelper, C0514x c0514x, int i) {
        this.f7524c = itemTouchHelper;
        this.f7522a = c0514x;
        this.f7523b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ItemTouchHelper itemTouchHelper = this.f7524c;
        RecyclerView recyclerView = itemTouchHelper.f7022r;
        if (recyclerView != null && recyclerView.isAttachedToWindow()) {
            C0514x c0514x = this.f7522a;
            if (!c0514x.f7347k) {
                RecyclerView.ViewHolder viewHolder = c0514x.f7341e;
                if (viewHolder.getAbsoluteAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = itemTouchHelper.f7022r.getItemAnimator();
                    if (itemAnimator == null || !itemAnimator.isRunning(null)) {
                        ArrayList arrayList = itemTouchHelper.f7020p;
                        int size = arrayList.size();
                        for (int i = 0; i < size; i++) {
                            if (((AbstractC0466d0) arrayList.get(i)).f7348l) {
                            }
                        }
                        itemTouchHelper.f7017m.onSwiped(viewHolder, this.f7523b);
                        return;
                    }
                    itemTouchHelper.f7022r.post(this);
                }
            }
        }
    }
}
