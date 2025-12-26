package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import p000.q23;

/* renamed from: androidx.recyclerview.widget.v0 */
/* loaded from: classes.dex */
public final class C0511v0 implements q23 {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.LayoutManager f7512a;

    public C0511v0(RecyclerView.LayoutManager layoutManager) {
        this.f7512a = layoutManager;
    }

    @Override // p000.q23
    /* renamed from: a */
    public final int mo1900a(View view) {
        return this.f7512a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // p000.q23
    /* renamed from: b */
    public final int mo1901b() {
        return this.f7512a.getPaddingLeft();
    }

    @Override // p000.q23
    /* renamed from: c */
    public final int mo1902c() {
        RecyclerView.LayoutManager layoutManager = this.f7512a;
        return layoutManager.getWidth() - layoutManager.getPaddingRight();
    }

    @Override // p000.q23
    /* renamed from: d */
    public final View mo1903d(int i) {
        return this.f7512a.getChildAt(i);
    }

    @Override // p000.q23
    /* renamed from: e */
    public final int mo1904e(View view) {
        return this.f7512a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }
}
