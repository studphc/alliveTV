package p000;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

/* loaded from: classes.dex */
public final class z11 extends ViewOutlineProvider {

    /* renamed from: a */
    public final /* synthetic */ int f29217a;

    /* renamed from: b */
    public final /* synthetic */ ImageFilterButton f29218b;

    public /* synthetic */ z11(ImageFilterButton imageFilterButton, int i) {
        this.f29217a = i;
        this.f29218b = imageFilterButton;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f29217a) {
            case 0:
                ImageFilterButton imageFilterButton = this.f29218b;
                outline.setRoundRect(0, 0, imageFilterButton.getWidth(), imageFilterButton.getHeight(), (Math.min(r3, r4) * imageFilterButton.f3027f) / 2.0f);
                return;
            default:
                ImageFilterButton imageFilterButton2 = this.f29218b;
                outline.setRoundRect(0, 0, imageFilterButton2.getWidth(), imageFilterButton2.getHeight(), imageFilterButton2.f3028g);
                return;
        }
    }
}
