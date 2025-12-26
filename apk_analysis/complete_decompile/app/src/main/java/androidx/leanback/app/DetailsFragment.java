package androidx.leanback.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.DetailsParallax;
import androidx.leanback.widget.DetailsParallaxDrawable;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import p000.C0016af;
import p000.a30;
import p000.b30;
import p000.n20;
import p000.o20;
import p000.ou0;
import p000.p20;
import p000.q20;
import p000.r20;
import p000.s20;
import p000.t20;
import p000.u20;
import p000.v20;
import p000.w20;
import p000.x20;
import p000.y20;
import p000.z20;

@Deprecated
/* loaded from: classes.dex */
public class DetailsFragment extends BaseFragment {

    /* renamed from: O */
    public BrowseFrameLayout f4909O;

    /* renamed from: P */
    public View f4910P;

    /* renamed from: Q */
    public DetailsParallaxDrawable f4911Q;

    /* renamed from: R */
    public Fragment f4912R;

    /* renamed from: S */
    public DetailsParallax f4913S;

    /* renamed from: T */
    public RowsFragment f4914T;

    /* renamed from: U */
    public ObjectAdapter f4915U;

    /* renamed from: V */
    public int f4916V;

    /* renamed from: W */
    public BaseOnItemViewSelectedListener f4917W;

    /* renamed from: X */
    public BaseOnItemViewClickedListener f4918X;

    /* renamed from: Y */
    public DetailsFragmentBackgroundController f4919Y;

    /* renamed from: a0 */
    public Object f4921a0;

    /* renamed from: z */
    public final r20 f4924z = new r20(this);

    /* renamed from: A */
    public final StateMachine.State f4895A = new StateMachine.State("STATE_ENTER_TRANSIITON_INIT");

    /* renamed from: B */
    public final s20 f4896B = new s20(this);

    /* renamed from: C */
    public final t20 f4897C = new t20(this);

    /* renamed from: D */
    public final StateMachine.State f4898D = new StateMachine.State("STATE_ENTER_TRANSIITON_COMPLETE", true, false);

    /* renamed from: E */
    public final u20 f4899E = new u20(this);

    /* renamed from: F */
    public final v20 f4900F = new v20(this);

    /* renamed from: G */
    public final w20 f4901G = new w20(this);

    /* renamed from: H */
    public final StateMachine.Event f4902H = new StateMachine.Event("onStart");

    /* renamed from: I */
    public final StateMachine.Event f4903I = new StateMachine.Event("EVT_NO_ENTER_TRANSITION");

    /* renamed from: J */
    public final StateMachine.Event f4904J = new StateMachine.Event("onFirstRowLoaded");

    /* renamed from: K */
    public final StateMachine.Event f4905K = new StateMachine.Event("onEnterTransitionDone");

    /* renamed from: L */
    public final StateMachine.Event f4906L = new StateMachine.Event("switchToVideo");

    /* renamed from: M */
    public final z20 f4907M = new z20(this);

    /* renamed from: N */
    public final a30 f4908N = new a30(this);

    /* renamed from: Z */
    public boolean f4920Z = false;

    /* renamed from: b0 */
    public final b30 f4922b0 = new b30(0, this);

    /* renamed from: c0 */
    public final x20 f4923c0 = new x20(this);

    @Override // androidx.leanback.app.BaseFragment
    /* renamed from: a */
    public final void mo1259a() {
        super.mo1259a();
        StateMachine stateMachine = this.f4754w;
        stateMachine.addState(this.f4924z);
        stateMachine.addState(this.f4901G);
        stateMachine.addState(this.f4896B);
        stateMachine.addState(this.f4895A);
        stateMachine.addState(this.f4899E);
        stateMachine.addState(this.f4897C);
        stateMachine.addState(this.f4900F);
        stateMachine.addState(this.f4898D);
    }

    @Override // androidx.leanback.app.BaseFragment
    /* renamed from: b */
    public final void mo1260b() {
        super.mo1260b();
        StateMachine.State state = this.f4741j;
        StateMachine.State state2 = this.f4895A;
        StateMachine stateMachine = this.f4754w;
        stateMachine.addTransition(state, state2, this.f4748q);
        StateMachine.State state3 = this.f4898D;
        stateMachine.addTransition(state2, state3, this.f4753v);
        stateMachine.addTransition(state2, state3, this.f4903I);
        t20 t20Var = this.f4897C;
        StateMachine.Event event = this.f4906L;
        stateMachine.addTransition(state2, t20Var, event);
        stateMachine.addTransition(t20Var, state3);
        StateMachine.Event event2 = this.f4749r;
        u20 u20Var = this.f4899E;
        stateMachine.addTransition(state2, u20Var, event2);
        StateMachine.Event event3 = this.f4905K;
        stateMachine.addTransition(u20Var, state3, event3);
        StateMachine.Event event4 = this.f4904J;
        v20 v20Var = this.f4900F;
        stateMachine.addTransition(u20Var, v20Var, event4);
        stateMachine.addTransition(v20Var, state3, event3);
        stateMachine.addTransition(state3, this.f4745n);
        StateMachine.State state4 = this.f4742k;
        s20 s20Var = this.f4896B;
        stateMachine.addTransition(state4, s20Var, event);
        StateMachine.State state5 = this.f4747p;
        stateMachine.addTransition(s20Var, state5);
        stateMachine.addTransition(state5, s20Var, event);
        C0016af c0016af = this.f4743l;
        r20 r20Var = this.f4924z;
        StateMachine.Event event5 = this.f4902H;
        stateMachine.addTransition(c0016af, r20Var, event5);
        w20 w20Var = this.f4901G;
        stateMachine.addTransition(state, w20Var, event5);
        stateMachine.addTransition(state5, w20Var);
        stateMachine.addTransition(state3, w20Var);
    }

    /* renamed from: c */
    public final VerticalGridView m1287c() {
        RowsFragment rowsFragment = this.f4914T;
        if (rowsFragment == null) {
            return null;
        }
        return rowsFragment.getVerticalGridView();
    }

    @Override // androidx.leanback.app.BaseFragment
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(ou0.m6729a(this), R.transition.lb_details_enter_transition);
    }

    public ObjectAdapter getAdapter() {
        return this.f4915U;
    }

    public BaseOnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f4918X;
    }

    public DetailsParallax getParallax() {
        if (this.f4913S == null) {
            this.f4913S = new DetailsParallax();
            RowsFragment rowsFragment = this.f4914T;
            if (rowsFragment != null && rowsFragment.getView() != null) {
                this.f4913S.setRecyclerView(this.f4914T.getVerticalGridView());
            }
        }
        return this.f4913S;
    }

    public RowsFragment getRowsFragment() {
        return this.f4914T;
    }

    @Deprecated
    public View inflateTitle(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onInflateTitleView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.leanback.app.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4916V = getResources().getDimensionPixelSize(R.dimen.lb_details_rows_align_top);
        Activity activity = getActivity();
        StateMachine.Event event = this.f4903I;
        StateMachine stateMachine = this.f4754w;
        if (activity != null) {
            if (TransitionHelper.getEnterTransition(activity.getWindow()) == null) {
                stateMachine.fireEvent(event);
            }
            Object returnTransition = TransitionHelper.getReturnTransition(activity.getWindow());
            if (returnTransition != null) {
                TransitionHelper.addTransitionListener(returnTransition, this.f4908N);
                return;
            }
            return;
        }
        stateMachine.fireEvent(event);
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) layoutInflater.inflate(R.layout.lb_details_fragment, viewGroup, false);
        this.f4909O = browseFrameLayout;
        View findViewById = browseFrameLayout.findViewById(R.id.details_background_view);
        this.f4910P = findViewById;
        if (findViewById != null) {
            findViewById.setBackground(this.f4911Q);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.details_rows_dock;
        RowsFragment rowsFragment = (RowsFragment) childFragmentManager.findFragmentById(i);
        this.f4914T = rowsFragment;
        if (rowsFragment == null) {
            this.f4914T = new RowsFragment();
            getChildFragmentManager().beginTransaction().replace(i, this.f4914T).commit();
        }
        installTitleView(layoutInflater, this.f4909O, bundle);
        this.f4914T.setAdapter(this.f4915U);
        this.f4914T.setOnItemViewSelectedListener(this.f4923c0);
        this.f4914T.setOnItemViewClickedListener(this.f4918X);
        this.f4921a0 = TransitionHelper.createScene(this.f4909O, new n20(this, 1));
        this.f4909O.setOnChildFocusListener(new o20(this));
        this.f4909O.setOnFocusSearchListener(new p20(this));
        this.f4909O.setOnDispatchKeyListener(new q20(0, this));
        this.f4914T.f5220v = new y20(this);
        return this.f4909O;
    }

    @Override // androidx.leanback.app.BaseFragment, androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onDestroyView() {
        DetailsParallax detailsParallax = this.f4913S;
        if (detailsParallax != null) {
            detailsParallax.setRecyclerView(null);
        }
        this.f4909O = null;
        this.f4910P = null;
        this.f4914T = null;
        this.f4912R = null;
        this.f4921a0 = null;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void onEntranceTransitionEnd() {
        this.f4914T.onTransitionEnd();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void onEntranceTransitionPrepare() {
        this.f4914T.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void onEntranceTransitionStart() {
        this.f4914T.onTransitionStart();
    }

    @Override // androidx.leanback.app.BrandedFragment
    @NonNull
    public View onInflateTitleView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return inflateTitle(layoutInflater, viewGroup, bundle);
    }

    public void onSetDetailsOverviewRowStatus(FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter, FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder, int i, int i2, int i3) {
        if (i2 > i) {
            fullWidthDetailsOverviewRowPresenter.setState(viewHolder, 0);
            return;
        }
        if (i2 == i && i3 == 1) {
            fullWidthDetailsOverviewRowPresenter.setState(viewHolder, 0);
        } else if (i2 == i && i3 == 0) {
            fullWidthDetailsOverviewRowPresenter.setState(viewHolder, 1);
        } else {
            fullWidthDetailsOverviewRowPresenter.setState(viewHolder, 2);
        }
    }

    public void onSetRowStatus(RowPresenter rowPresenter, RowPresenter.ViewHolder viewHolder, int i, int i2, int i3) {
        if (rowPresenter instanceof FullWidthDetailsOverviewRowPresenter) {
            onSetDetailsOverviewRowStatus((FullWidthDetailsOverviewRowPresenter) rowPresenter, (FullWidthDetailsOverviewRowPresenter.ViewHolder) viewHolder, i, i2, i3);
        }
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.f4914T.getVerticalGridView();
        verticalGridView.setItemAlignmentOffset(-this.f4916V);
        verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignmentOffset(0);
        verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignment(0);
        this.f4754w.fireEvent(this.f4902H);
        DetailsParallax detailsParallax = this.f4913S;
        if (detailsParallax != null) {
            detailsParallax.setRecyclerView(this.f4914T.getVerticalGridView());
        }
        if (this.f4920Z) {
            if (m1287c() != null) {
                m1287c().animateOut();
            }
        } else if (!getView().hasFocus()) {
            this.f4914T.getVerticalGridView().requestFocus();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        PlaybackGlue playbackGlue;
        DetailsFragmentBackgroundController detailsFragmentBackgroundController = this.f4919Y;
        if (detailsFragmentBackgroundController != null && (playbackGlue = detailsFragmentBackgroundController.f4928d) != null) {
            playbackGlue.pause();
        }
        super.onStop();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.f4921a0, obj);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.f4915U = objectAdapter;
        Presenter[] presenters = objectAdapter.getPresenterSelector().getPresenters();
        if (presenters != null) {
            for (Presenter presenter : presenters) {
                setupPresenter(presenter);
            }
        } else {
            Log.e("DetailsFragment", "PresenterSelector.getPresenters() not implemented");
        }
        RowsFragment rowsFragment = this.f4914T;
        if (rowsFragment != null) {
            rowsFragment.setAdapter(objectAdapter);
        }
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        if (this.f4918X != baseOnItemViewClickedListener) {
            this.f4918X = baseOnItemViewClickedListener;
            RowsFragment rowsFragment = this.f4914T;
            if (rowsFragment != null) {
                rowsFragment.setOnItemViewClickedListener(baseOnItemViewClickedListener);
            }
        }
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.f4917W = baseOnItemViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setupDetailsOverviewRowPresenter(FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter) {
        ItemAlignmentFacet itemAlignmentFacet = new ItemAlignmentFacet();
        ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef = new ItemAlignmentFacet.ItemAlignmentDef();
        int i = R.id.details_frame;
        itemAlignmentDef.setItemAlignmentViewId(i);
        itemAlignmentDef.setItemAlignmentOffset(-getResources().getDimensionPixelSize(R.dimen.lb_details_v2_align_pos_for_actions));
        itemAlignmentDef.setItemAlignmentOffsetPercent(RecyclerView.f7068F0);
        ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef2 = new ItemAlignmentFacet.ItemAlignmentDef();
        itemAlignmentDef2.setItemAlignmentViewId(i);
        itemAlignmentDef2.setItemAlignmentFocusViewId(R.id.details_overview_description);
        itemAlignmentDef2.setItemAlignmentOffset(-getResources().getDimensionPixelSize(R.dimen.lb_details_v2_align_pos_for_description));
        itemAlignmentDef2.setItemAlignmentOffsetPercent(RecyclerView.f7068F0);
        itemAlignmentFacet.setAlignmentDefs(new ItemAlignmentFacet.ItemAlignmentDef[]{itemAlignmentDef, itemAlignmentDef2});
        fullWidthDetailsOverviewRowPresenter.setFacet(ItemAlignmentFacet.class, itemAlignmentFacet);
    }

    public void setupPresenter(Presenter presenter) {
        if (presenter instanceof FullWidthDetailsOverviewRowPresenter) {
            setupDetailsOverviewRowPresenter((FullWidthDetailsOverviewRowPresenter) presenter);
        }
    }

    public void setSelectedPosition(int i, boolean z) {
        b30 b30Var = this.f4922b0;
        b30Var.f7877b = i;
        b30Var.f7878c = z;
        if (getView() == null || getView().getHandler() == null) {
            return;
        }
        getView().getHandler().post(b30Var);
    }
}
