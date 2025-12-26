package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.DetailsOverviewRowPresenter;

/* renamed from: androidx.leanback.widget.a0 */
/* loaded from: classes.dex */
public final class C0312a0 implements OnChildSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsOverviewRowPresenter.ViewHolder f6263a;

    public C0312a0(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6263a = viewHolder;
    }

    @Override // androidx.leanback.widget.OnChildSelectedListener
    public final void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
        this.f6263a.m1391c(view);
    }
}
