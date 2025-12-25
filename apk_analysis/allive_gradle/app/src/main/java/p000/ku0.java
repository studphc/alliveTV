package p000;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ku0 implements Transition.TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ Object f22203a;

    /* renamed from: b */
    public final /* synthetic */ ArrayList f22204b;

    /* renamed from: c */
    public final /* synthetic */ Object f22205c;

    /* renamed from: d */
    public final /* synthetic */ ArrayList f22206d;

    /* renamed from: e */
    public final /* synthetic */ Object f22207e;

    /* renamed from: f */
    public final /* synthetic */ ArrayList f22208f;

    /* renamed from: g */
    public final /* synthetic */ mu0 f22209g;

    public ku0(mu0 mu0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f22209g = mu0Var;
        this.f22203a = obj;
        this.f22204b = arrayList;
        this.f22205c = obj2;
        this.f22206d = arrayList2;
        this.f22207e = obj3;
        this.f22208f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        mu0 mu0Var = this.f22209g;
        Object obj = this.f22203a;
        if (obj != null) {
            mu0Var.replaceTargets(obj, this.f22204b, null);
        }
        Object obj2 = this.f22205c;
        if (obj2 != null) {
            mu0Var.replaceTargets(obj2, this.f22206d, null);
        }
        Object obj3 = this.f22207e;
        if (obj3 != null) {
            mu0Var.replaceTargets(obj3, this.f22208f, null);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }
}
