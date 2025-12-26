package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.g0 */
/* loaded from: classes.dex */
public final class C0475g0 {

    /* renamed from: a */
    public boolean f7380a;

    /* renamed from: b */
    public int f7381b;

    /* renamed from: c */
    public int f7382c;

    /* renamed from: d */
    public int f7383d;

    /* renamed from: e */
    public int f7384e;

    /* renamed from: f */
    public int f7385f;

    /* renamed from: g */
    public int f7386g;

    /* renamed from: h */
    public int f7387h;

    /* renamed from: i */
    public int f7388i;

    /* renamed from: j */
    public int f7389j;

    /* renamed from: k */
    public List f7390k;

    /* renamed from: l */
    public boolean f7391l;

    /* renamed from: a */
    public final void m1843a(View view) {
        int viewLayoutPosition;
        int size = this.f7390k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((RecyclerView.ViewHolder) this.f7390k.get(i2)).itemView;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
            if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.f7383d) * this.f7384e) >= 0 && viewLayoutPosition < i) {
                view2 = view3;
                if (viewLayoutPosition == 0) {
                    break;
                } else {
                    i = viewLayoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f7383d = -1;
        } else {
            this.f7383d = ((RecyclerView.LayoutParams) view2.getLayoutParams()).getViewLayoutPosition();
        }
    }

    /* renamed from: b */
    public final View m1844b(RecyclerView.Recycler recycler) {
        List list = this.f7390k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = ((RecyclerView.ViewHolder) this.f7390k.get(i)).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.f7383d == layoutParams.getViewLayoutPosition()) {
                    m1843a(view);
                    return view;
                }
            }
            return null;
        }
        View viewForPosition = recycler.getViewForPosition(this.f7383d);
        this.f7383d += this.f7384e;
        return viewForPosition;
    }
}
