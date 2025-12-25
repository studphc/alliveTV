package androidx.recyclerview.widget;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.x */
/* loaded from: classes.dex */
public final class C0514x extends AbstractC0466d0 {

    /* renamed from: n */
    public final /* synthetic */ int f7515n;

    /* renamed from: o */
    public final /* synthetic */ RecyclerView.ViewHolder f7516o;

    /* renamed from: p */
    public final /* synthetic */ ItemTouchHelper f7517p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0514x(ItemTouchHelper itemTouchHelper, RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.ViewHolder viewHolder2) {
        super(viewHolder, i2, f, f2, f3, f4);
        this.f7517p = itemTouchHelper;
        this.f7515n = i3;
        this.f7516o = viewHolder2;
    }

    @Override // androidx.recyclerview.widget.AbstractC0466d0, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.f7347k) {
            return;
        }
        int i = this.f7515n;
        RecyclerView.ViewHolder viewHolder = this.f7516o;
        ItemTouchHelper itemTouchHelper = this.f7517p;
        if (i <= 0) {
            itemTouchHelper.f7017m.clearView(itemTouchHelper.f7022r, viewHolder);
        } else {
            itemTouchHelper.f7005a.add(viewHolder.itemView);
            this.f7344h = true;
            if (i > 0) {
                itemTouchHelper.f7022r.post(new RunnableC0516y(itemTouchHelper, this, i));
            }
        }
        View view = itemTouchHelper.f7027w;
        View view2 = viewHolder.itemView;
        if (view == view2) {
            itemTouchHelper.m1638i(view2);
        }
    }
}
