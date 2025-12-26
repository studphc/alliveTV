package p000;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/* loaded from: classes.dex */
public final class a21 extends ViewOutlineProvider {

    /* renamed from: a */
    public final /* synthetic */ int f23a;

    /* renamed from: b */
    public final /* synthetic */ ImageFilterView f24b;

    public /* synthetic */ a21(ImageFilterView imageFilterView, int i) {
        this.f23a = i;
        this.f24b = imageFilterView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f23a) {
            case 0:
                ImageFilterView imageFilterView = this.f24b;
                outline.setRoundRect(0, 0, imageFilterView.getWidth(), imageFilterView.getHeight(), (Math.min(r3, r4) * imageFilterView.f3046i) / 2.0f);
                return;
            default:
                ImageFilterView imageFilterView2 = this.f24b;
                outline.setRoundRect(0, 0, imageFilterView2.getWidth(), imageFilterView2.getHeight(), imageFilterView2.f3047j);
                return;
        }
    }
}
