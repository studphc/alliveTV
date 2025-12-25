package p000;

import android.transition.Transition;
import androidx.leanback.transition.TransitionListener;

/* loaded from: classes.dex */
public final class lu0 implements Transition.TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ int f22668a;

    /* renamed from: b */
    public final /* synthetic */ Object f22669b;

    public /* synthetic */ lu0(int i, Object obj) {
        this.f22668a = i;
        this.f22669b = obj;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
        switch (this.f22668a) {
            case 0:
                return;
            default:
                ((TransitionListener) this.f22669b).onTransitionCancel(transition);
                return;
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        switch (this.f22668a) {
            case 0:
                ((Runnable) this.f22669b).run();
                return;
            default:
                ((TransitionListener) this.f22669b).onTransitionEnd(transition);
                return;
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
        switch (this.f22668a) {
            case 0:
                return;
            default:
                ((TransitionListener) this.f22669b).onTransitionPause(transition);
                return;
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
        switch (this.f22668a) {
            case 0:
                return;
            default:
                ((TransitionListener) this.f22669b).onTransitionResume(transition);
                return;
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        switch (this.f22668a) {
            case 0:
                return;
            default:
                ((TransitionListener) this.f22669b).onTransitionStart(transition);
                return;
        }
    }

    /* renamed from: a */
    private final void m5983a(Transition transition) {
    }

    /* renamed from: b */
    private final void m5984b(Transition transition) {
    }

    /* renamed from: c */
    private final void m5985c(Transition transition) {
    }

    /* renamed from: d */
    private final void m5986d(Transition transition) {
    }
}
