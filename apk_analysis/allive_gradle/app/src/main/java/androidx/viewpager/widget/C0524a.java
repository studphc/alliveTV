package androidx.viewpager.widget;

import android.database.DataSetObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/* renamed from: androidx.viewpager.widget.a */
/* loaded from: classes.dex */
public final class C0524a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

    /* renamed from: a */
    public int f7682a;

    /* renamed from: b */
    public final /* synthetic */ PagerTitleStrip f7683b;

    public C0524a(PagerTitleStrip pagerTitleStrip) {
        this.f7683b = pagerTitleStrip;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public final void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        this.f7683b.m1929a(pagerAdapter, pagerAdapter2);
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.f7683b;
        pagerTitleStrip.m1930b(pagerTitleStrip.f7602a.getCurrentItem(), pagerTitleStrip.f7602a.getAdapter());
        float f = pagerTitleStrip.f7607f;
        if (f < RecyclerView.f7068F0) {
            f = 0.0f;
        }
        pagerTitleStrip.mo1928c(pagerTitleStrip.f7602a.getCurrentItem(), true, f);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        this.f7682a = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.f7683b.mo1928c(i, false, f);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        if (this.f7682a == 0) {
            PagerTitleStrip pagerTitleStrip = this.f7683b;
            pagerTitleStrip.m1930b(pagerTitleStrip.f7602a.getCurrentItem(), pagerTitleStrip.f7602a.getAdapter());
            float f = pagerTitleStrip.f7607f;
            if (f < RecyclerView.f7068F0) {
                f = 0.0f;
            }
            pagerTitleStrip.mo1928c(pagerTitleStrip.f7602a.getCurrentItem(), true, f);
        }
    }
}
