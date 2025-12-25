package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.RecyclerViewParallax;

/* loaded from: classes.dex */
public class DetailsParallax extends RecyclerViewParallax {

    /* renamed from: j */
    public final RecyclerViewParallax.ChildPositionProperty f5640j;

    /* renamed from: k */
    public final RecyclerViewParallax.ChildPositionProperty f5641k;

    public DetailsParallax() {
        RecyclerViewParallax.ChildPositionProperty adapterPosition = addProperty("overviewRowTop").adapterPosition(0);
        int i = androidx.leanback.R.id.details_frame;
        this.f5640j = adapterPosition.viewId(i);
        this.f5641k = addProperty("overviewRowBottom").adapterPosition(0).viewId(i).fraction(1.0f);
    }

    public Parallax.IntProperty getOverviewRowBottom() {
        return this.f5641k;
    }

    public Parallax.IntProperty getOverviewRowTop() {
        return this.f5640j;
    }
}
