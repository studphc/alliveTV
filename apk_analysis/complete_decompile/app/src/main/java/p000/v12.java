package p000;

import android.view.View;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class v12 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f27624a;

    /* renamed from: b */
    public final /* synthetic */ PagerTabStrip f27625b;

    public /* synthetic */ v12(PagerTabStrip pagerTabStrip, int i) {
        this.f27624a = i;
        this.f27625b = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f27624a) {
            case 0:
                this.f27625b.f7602a.setCurrentItem(r2.getCurrentItem() - 1);
                return;
            default:
                ViewPager viewPager = this.f27625b.f7602a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                return;
        }
    }
}
