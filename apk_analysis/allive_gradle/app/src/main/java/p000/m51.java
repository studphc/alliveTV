package p000;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class m51 implements ItemTouchUIUtil {

    /* renamed from: a */
    public static final m51 f22805a = new Object();

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public final void clearView(View view) {
        int i = R.id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i);
        if (tag instanceof Float) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(i, null);
        view.setTranslationX(RecyclerView.f7068F0);
        view.setTranslationY(RecyclerView.f7068F0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
            int childCount = recyclerView.getChildCount();
            float f3 = RecyclerView.f7068F0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    float elevation = ViewCompat.getElevation(childAt);
                    if (elevation > f3) {
                        f3 = elevation;
                    }
                }
            }
            ViewCompat.setElevation(view, f3 + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public final void onSelected(View view) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
    }
}
