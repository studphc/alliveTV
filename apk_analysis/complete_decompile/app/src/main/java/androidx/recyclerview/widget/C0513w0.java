package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import p000.q23;

/* renamed from: androidx.recyclerview.widget.w0 */
/* loaded from: classes.dex */
public final class C0513w0 implements q23 {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.LayoutManager f7514a;

    public C0513w0(RecyclerView.LayoutManager layoutManager) {
        this.f7514a = layoutManager;
    }

    @Override // p000.q23
    /* renamed from: a */
    public final int mo1900a(View view) {
        return this.f7514a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // p000.q23
    /* renamed from: b */
    public final int mo1901b() {
        return this.f7514a.getPaddingTop();
    }

    @Override // p000.q23
    /* renamed from: c */
    public final int mo1902c() {
        RecyclerView.LayoutManager layoutManager = this.f7514a;
        return layoutManager.getHeight() - layoutManager.getPaddingBottom();
    }

    @Override // p000.q23
    /* renamed from: d */
    public final View mo1903d(int i) {
        return this.f7514a.getChildAt(i);
    }

    @Override // p000.q23
    /* renamed from: e */
    public final int mo1904e(View view) {
        return this.f7514a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }
}
