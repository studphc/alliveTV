package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.Comparator;

/* renamed from: androidx.viewpager.widget.c */
/* loaded from: classes.dex */
public final class C0526c implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) ((View) obj).getLayoutParams();
        ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams) ((View) obj2).getLayoutParams();
        boolean z = layoutParams.isDecor;
        if (z != layoutParams2.isDecor) {
            if (z) {
                return 1;
            }
            return -1;
        }
        return layoutParams.f7677c - layoutParams2.f7677c;
    }
}
