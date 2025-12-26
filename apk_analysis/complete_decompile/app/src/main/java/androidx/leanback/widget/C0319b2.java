package androidx.leanback.widget;

import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.Presenter;
import p000.a52;

/* renamed from: androidx.leanback.widget.b2 */
/* loaded from: classes.dex */
public final class C0319b2 implements InterfaceC0356l {
    @Override // androidx.leanback.widget.InterfaceC0356l
    /* renamed from: a */
    public final void mo1495a(Presenter.ViewHolder viewHolder, Object obj, a52 a52Var) {
        PlaybackControlsRowPresenter.ViewHolder viewHolder2 = ((C0331e2) a52Var).f6284d;
        if (viewHolder2.f6013C != viewHolder || viewHolder2.f6014D != obj) {
            viewHolder2.f6013C = viewHolder;
            viewHolder2.f6014D = obj;
            viewHolder2.m1468a();
        }
    }
}
