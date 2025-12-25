package p000;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.MotionButton;

/* loaded from: classes.dex */
public final class bp1 extends ViewOutlineProvider {

    /* renamed from: a */
    public final /* synthetic */ int f8120a;

    /* renamed from: b */
    public final /* synthetic */ MotionButton f8121b;

    public /* synthetic */ bp1(MotionButton motionButton, int i) {
        this.f8120a = i;
        this.f8121b = motionButton;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f8120a) {
            case 0:
                MotionButton motionButton = this.f8121b;
                outline.setRoundRect(0, 0, motionButton.getWidth(), motionButton.getHeight(), (Math.min(r3, r4) * motionButton.f3067d) / 2.0f);
                return;
            default:
                MotionButton motionButton2 = this.f8121b;
                outline.setRoundRect(0, 0, motionButton2.getWidth(), motionButton2.getHeight(), motionButton2.f3068e);
                return;
        }
    }
}
