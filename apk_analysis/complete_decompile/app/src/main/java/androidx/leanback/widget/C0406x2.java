package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.leanback.widget.SearchOrbView;

/* renamed from: androidx.leanback.widget.x2 */
/* loaded from: classes.dex */
public final class C0406x2 extends TitleViewAdapter {

    /* renamed from: a */
    public final /* synthetic */ TitleView f6437a;

    public C0406x2(TitleView titleView) {
        this.f6437a = titleView;
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final Drawable getBadgeDrawable() {
        return this.f6437a.getBadgeDrawable();
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final SearchOrbView.Colors getSearchAffordanceColors() {
        return this.f6437a.getSearchAffordanceColors();
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final View getSearchAffordanceView() {
        return this.f6437a.getSearchAffordanceView();
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final CharSequence getTitle() {
        return this.f6437a.getTitle();
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final void setAnimationEnabled(boolean z) {
        this.f6437a.enableAnimation(z);
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final void setBadgeDrawable(Drawable drawable) {
        this.f6437a.setBadgeDrawable(drawable);
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.f6437a.setOnSearchClickedListener(onClickListener);
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        this.f6437a.setSearchAffordanceColors(colors);
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final void setTitle(CharSequence charSequence) {
        this.f6437a.setTitle(charSequence);
    }

    @Override // androidx.leanback.widget.TitleViewAdapter
    public final void updateComponentsVisibility(int i) {
        this.f6437a.updateComponentsVisibility(i);
    }
}
