package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.exoplayer2.p003ui.C0731m;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final class up2 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f27403a;

    /* renamed from: b */
    public final /* synthetic */ StyledPlayerControlView f27404b;

    /* renamed from: c */
    public final /* synthetic */ C0731m f27405c;

    public /* synthetic */ up2(C0731m c0731m, StyledPlayerControlView styledPlayerControlView, int i) {
        this.f27403a = i;
        this.f27405c = c0731m;
        this.f27404b = styledPlayerControlView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f27403a) {
            case 0:
                C0731m c0731m = this.f27405c;
                c0731m.m2973i(1);
                if (c0731m.f12354B) {
                    this.f27404b.post(c0731m.f12374s);
                    c0731m.f12354B = false;
                    return;
                }
                return;
            case 1:
                C0731m c0731m2 = this.f27405c;
                c0731m2.m2973i(2);
                if (c0731m2.f12354B) {
                    this.f27404b.post(c0731m2.f12374s);
                    c0731m2.f12354B = false;
                    return;
                }
                return;
            default:
                C0731m c0731m3 = this.f27405c;
                c0731m3.m2973i(2);
                if (c0731m3.f12354B) {
                    this.f27404b.post(c0731m3.f12374s);
                    c0731m3.f12354B = false;
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f27403a) {
            case 0:
                this.f27405c.m2973i(3);
                return;
            case 1:
                this.f27405c.m2973i(3);
                return;
            default:
                this.f27405c.m2973i(3);
                return;
        }
    }
}
