package p000;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.MotionLabel;

/* loaded from: classes.dex */
public final class fp1 extends ViewOutlineProvider {

    /* renamed from: a */
    public final /* synthetic */ int f17359a;

    /* renamed from: b */
    public final /* synthetic */ MotionLabel f17360b;

    public /* synthetic */ fp1(MotionLabel motionLabel, int i) {
        this.f17359a = i;
        this.f17360b = motionLabel;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f17359a) {
            case 0:
                MotionLabel motionLabel = this.f17360b;
                outline.setRoundRect(0, 0, motionLabel.getWidth(), motionLabel.getHeight(), (Math.min(r3, r4) * motionLabel.f3097f) / 2.0f);
                return;
            default:
                MotionLabel motionLabel2 = this.f17360b;
                outline.setRoundRect(0, 0, motionLabel2.getWidth(), motionLabel2.getHeight(), motionLabel2.f3098g);
                return;
        }
    }
}
