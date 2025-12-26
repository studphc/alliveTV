package p000;

import android.graphics.PointF;
import androidx.leanback.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class xx0 extends yx0 {

    /* renamed from: n */
    public final /* synthetic */ GridLayoutManager f28760n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx0(GridLayoutManager gridLayoutManager) {
        super(gridLayoutManager);
        this.f28760n = gridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final PointF computeScrollVectorForPosition(int i) {
        int i2;
        if (getChildCount() == 0) {
            return null;
        }
        GridLayoutManager gridLayoutManager = this.f28760n;
        int position = gridLayoutManager.getPosition(gridLayoutManager.getChildAt(0));
        if ((gridLayoutManager.f5677D & 262144) == 0 ? i < position : i > position) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        if (gridLayoutManager.f5715t == 0) {
            return new PointF(i2, RecyclerView.f7068F0);
        }
        return new PointF(RecyclerView.f7068F0, i2);
    }
}
