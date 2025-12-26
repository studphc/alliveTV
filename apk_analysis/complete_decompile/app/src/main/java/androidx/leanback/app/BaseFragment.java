package androidx.leanback.app;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.util.StateMachine;
import p000.C0016af;
import p000.C0555bf;
import p000.C0591cf;
import p000.C1120df;
import p000.C1156ef;

@Deprecated
/* loaded from: classes.dex */
public class BaseFragment extends BrandedFragment {

    /* renamed from: x */
    public Object f4755x;

    /* renamed from: j */
    public final StateMachine.State f4741j = new StateMachine.State("START", true, false);

    /* renamed from: k */
    public final StateMachine.State f4742k = new StateMachine.State("ENTRANCE_INIT");

    /* renamed from: l */
    public final C0016af f4743l = new C0016af(this);

    /* renamed from: m */
    public final C0555bf f4744m = new C0555bf(this);

    /* renamed from: n */
    public final C0591cf f4745n = new C0591cf(this);

    /* renamed from: o */
    public final C1120df f4746o = new C1120df(this);

    /* renamed from: p */
    public final StateMachine.State f4747p = new StateMachine.State("ENTRANCE_COMPLETE", true, false);

    /* renamed from: q */
    public final StateMachine.Event f4748q = new StateMachine.Event("onCreate");

    /* renamed from: r */
    public final StateMachine.Event f4749r = new StateMachine.Event("onCreateView");

    /* renamed from: s */
    public final StateMachine.Event f4750s = new StateMachine.Event("prepareEntranceTransition");

    /* renamed from: t */
    public final StateMachine.Event f4751t = new StateMachine.Event("startEntranceTransition");

    /* renamed from: u */
    public final StateMachine.Event f4752u = new StateMachine.Event("onEntranceTransitionEnd");

    /* renamed from: v */
    public final C1156ef f4753v = new StateMachine.Condition("EntranceTransitionNotSupport");

    /* renamed from: w */
    public final StateMachine f4754w = new StateMachine();

    /* renamed from: y */
    public final ProgressBarManager f4756y = new ProgressBarManager();

    /* renamed from: a */
    public void mo1259a() {
        StateMachine.State state = this.f4741j;
        StateMachine stateMachine = this.f4754w;
        stateMachine.addState(state);
        stateMachine.addState(this.f4742k);
        stateMachine.addState(this.f4743l);
        stateMachine.addState(this.f4744m);
        stateMachine.addState(this.f4745n);
        stateMachine.addState(this.f4746o);
        stateMachine.addState(this.f4747p);
    }

    /* renamed from: b */
    public void mo1260b() {
        StateMachine.State state = this.f4741j;
        StateMachine.State state2 = this.f4742k;
        StateMachine stateMachine = this.f4754w;
        stateMachine.addTransition(state, state2, this.f4748q);
        StateMachine.State state3 = this.f4747p;
        stateMachine.addTransition(state2, state3, this.f4753v);
        StateMachine.Event event = this.f4749r;
        stateMachine.addTransition(state2, state3, event);
        StateMachine.Event event2 = this.f4750s;
        C0016af c0016af = this.f4743l;
        stateMachine.addTransition(state2, c0016af, event2);
        C0555bf c0555bf = this.f4744m;
        stateMachine.addTransition(c0016af, c0555bf, event);
        StateMachine.Event event3 = this.f4751t;
        C0591cf c0591cf = this.f4745n;
        stateMachine.addTransition(c0016af, c0591cf, event3);
        stateMachine.addTransition(c0555bf, c0591cf);
        StateMachine.Event event4 = this.f4752u;
        C1120df c1120df = this.f4746o;
        stateMachine.addTransition(c0591cf, c1120df, event4);
        stateMachine.addTransition(c1120df, state3);
    }

    public Object createEntranceTransition() {
        return null;
    }

    public final ProgressBarManager getProgressBarManager() {
        return this.f4756y;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        mo1259a();
        mo1260b();
        StateMachine stateMachine = this.f4754w;
        stateMachine.start();
        super.onCreate(bundle);
        stateMachine.fireEvent(this.f4748q);
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onDestroyView() {
        ProgressBarManager progressBarManager = this.f4756y;
        progressBarManager.setRootView(null);
        progressBarManager.setProgressBarView(null);
        super.onDestroyView();
    }

    public void onEntranceTransitionEnd() {
    }

    public void onEntranceTransitionPrepare() {
    }

    public void onEntranceTransitionStart() {
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4754w.fireEvent(this.f4749r);
    }

    public void prepareEntranceTransition() {
        this.f4754w.fireEvent(this.f4750s);
    }

    public void runEntranceTransition(Object obj) {
    }

    public void startEntranceTransition() {
        this.f4754w.fireEvent(this.f4751t);
    }
}
