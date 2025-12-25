package p000;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class e01 implements View.OnLayoutChangeListener {

    /* renamed from: a */
    public final /* synthetic */ int f16636a;

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        float f;
        float f2;
        switch (this.f16636a) {
            case 0:
                if (view.getLayoutDirection() == 1) {
                    f = view.getWidth();
                } else {
                    f = RecyclerView.f7068F0;
                }
                view.setPivotX(f);
                view.setPivotY(view.getMeasuredHeight() / 2);
                return;
            default:
                if (view.getLayoutDirection() == 1) {
                    f2 = view.getWidth();
                } else {
                    f2 = RecyclerView.f7068F0;
                }
                view.setPivotX(f2);
                view.setPivotY(view.getMeasuredHeight() / 2);
                return;
        }
    }
}
