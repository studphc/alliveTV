package p000;

import android.graphics.PointF;
import android.view.View;
import androidx.leanback.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class zx0 extends yx0 {

    /* renamed from: n */
    public final boolean f29554n;

    /* renamed from: o */
    public int f29555o;

    /* renamed from: p */
    public final /* synthetic */ GridLayoutManager f29556p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zx0(GridLayoutManager gridLayoutManager, int i, boolean z) {
        super(gridLayoutManager);
        this.f29556p = gridLayoutManager;
        this.f29555o = i;
        this.f29554n = z;
        setTargetPosition(-2);
    }

    @Override // p000.yx0
    /* renamed from: b */
    public final void mo8330b() {
        super.mo8330b();
        this.f29555o = 0;
        View findViewByPosition = findViewByPosition(getTargetPosition());
        if (findViewByPosition != null) {
            this.f29556p.m1414S(findViewByPosition, true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final PointF computeScrollVectorForPosition(int i) {
        int i2;
        int i3 = this.f29555o;
        if (i3 == 0) {
            return null;
        }
        GridLayoutManager gridLayoutManager = this.f29556p;
        if ((gridLayoutManager.f5677D & 262144) == 0 ? i3 < 0 : i3 > 0) {
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
