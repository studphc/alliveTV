package androidx.leanback.app;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.util.StateMachine;
import p000.C1870uf;
import p000.C1907vf;
import p000.C1944wf;
import p000.C1981xf;
import p000.C2018yf;

/* loaded from: classes.dex */
public class BaseSupportFragment extends BrandedSupportFragment {

    /* renamed from: B0 */
    public Object f4758B0;

    /* renamed from: n0 */
    public final StateMachine.State f4760n0 = new StateMachine.State("START", true, false);

    /* renamed from: o0 */
    public final StateMachine.State f4761o0 = new StateMachine.State("ENTRANCE_INIT");

    /* renamed from: p0 */
    public final C1870uf f4762p0 = new C1870uf(this);

    /* renamed from: q0 */
    public final C1907vf f4763q0 = new C1907vf(this);

    /* renamed from: r0 */
    public final C1944wf f4764r0 = new C1944wf(this);

    /* renamed from: s0 */
    public final C1981xf f4765s0 = new C1981xf(this);

    /* renamed from: t0 */
    public final StateMachine.State f4766t0 = new StateMachine.State("ENTRANCE_COMPLETE", true, false);

    /* renamed from: u0 */
    public final StateMachine.Event f4767u0 = new StateMachine.Event("onCreate");

    /* renamed from: v0 */
    public final StateMachine.Event f4768v0 = new StateMachine.Event("onCreateView");

    /* renamed from: w0 */
    public final StateMachine.Event f4769w0 = new StateMachine.Event("prepareEntranceTransition");

    /* renamed from: x0 */
    public final StateMachine.Event f4770x0 = new StateMachine.Event("startEntranceTransition");

    /* renamed from: y0 */
    public final StateMachine.Event f4771y0 = new StateMachine.Event("onEntranceTransitionEnd");

    /* renamed from: z0 */
    public final C2018yf f4772z0 = new StateMachine.Condition("EntranceTransitionNotSupport");

    /* renamed from: A0 */
    public final StateMachine f4757A0 = new StateMachine();

    /* renamed from: C0 */
    public final ProgressBarManager f4759C0 = new ProgressBarManager();

    public Object createEntranceTransition() {
        return null;
    }

    public final ProgressBarManager getProgressBarManager() {
        return this.f4759C0;
    }

    /* renamed from: l */
    public void mo1261l() {
        StateMachine.State state = this.f4760n0;
        StateMachine stateMachine = this.f4757A0;
        stateMachine.addState(state);
        stateMachine.addState(this.f4761o0);
        stateMachine.addState(this.f4762p0);
        stateMachine.addState(this.f4763q0);
        stateMachine.addState(this.f4764r0);
        stateMachine.addState(this.f4765s0);
        stateMachine.addState(this.f4766t0);
    }

    /* renamed from: m */
    public void mo1262m() {
        StateMachine.State state = this.f4760n0;
        StateMachine.State state2 = this.f4761o0;
        StateMachine stateMachine = this.f4757A0;
        stateMachine.addTransition(state, state2, this.f4767u0);
        StateMachine.State state3 = this.f4766t0;
        stateMachine.addTransition(state2, state3, this.f4772z0);
        StateMachine.Event event = this.f4768v0;
        stateMachine.addTransition(state2, state3, event);
        StateMachine.Event event2 = this.f4769w0;
        C1870uf c1870uf = this.f4762p0;
        stateMachine.addTransition(state2, c1870uf, event2);
        C1907vf c1907vf = this.f4763q0;
        stateMachine.addTransition(c1870uf, c1907vf, event);
        StateMachine.Event event3 = this.f4770x0;
        C1944wf c1944wf = this.f4764r0;
        stateMachine.addTransition(c1870uf, c1944wf, event3);
        stateMachine.addTransition(c1907vf, c1944wf);
        StateMachine.Event event4 = this.f4771y0;
        C1981xf c1981xf = this.f4765s0;
        stateMachine.addTransition(c1944wf, c1981xf, event4);
        stateMachine.addTransition(c1981xf, state3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        mo1261l();
        mo1262m();
        StateMachine stateMachine = this.f4757A0;
        stateMachine.start();
        super.onCreate(bundle);
        stateMachine.fireEvent(this.f4767u0);
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProgressBarManager progressBarManager = this.f4759C0;
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

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4757A0.fireEvent(this.f4768v0);
    }

    public void prepareEntranceTransition() {
        this.f4757A0.fireEvent(this.f4769w0);
    }

    public void runEntranceTransition(Object obj) {
    }

    public void startEntranceTransition() {
        this.f4757A0.fireEvent(this.f4770x0);
    }
}
