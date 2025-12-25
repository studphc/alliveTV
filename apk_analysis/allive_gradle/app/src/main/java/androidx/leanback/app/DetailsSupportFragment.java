package androidx.leanback.app;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
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
import p000.C1870uf;
import p000.a30;
import p000.b30;
import p000.e30;
import p000.f30;
import p000.g30;
import p000.h30;
import p000.i30;
import p000.j30;
import p000.k30;
import p000.l30;
import p000.m30;
import p000.n30;
import p000.o30;
import p000.p30;
import p000.q20;

/* loaded from: classes.dex */
public class DetailsSupportFragment extends BaseSupportFragment {

    /* renamed from: S0 */
    public BrowseFrameLayout f4950S0;

    /* renamed from: T0 */
    public View f4951T0;

    /* renamed from: U0 */
    public DetailsParallaxDrawable f4952U0;

    /* renamed from: V0 */
    public Fragment f4953V0;

    /* renamed from: W0 */
    public DetailsParallax f4954W0;

    /* renamed from: X0 */
    public RowsSupportFragment f4955X0;

    /* renamed from: Y0 */
    public ObjectAdapter f4956Y0;

    /* renamed from: Z0 */
    public int f4957Z0;

    /* renamed from: a1 */
    public BaseOnItemViewSelectedListener f4958a1;

    /* renamed from: b1 */
    public BaseOnItemViewClickedListener f4959b1;

    /* renamed from: c1 */
    public DetailsSupportFragmentBackgroundController f4960c1;

    /* renamed from: e1 */
    public Object f4962e1;

    /* renamed from: D0 */
    public final h30 f4935D0 = new h30(this);

    /* renamed from: E0 */
    public final StateMachine.State f4936E0 = new StateMachine.State("STATE_ENTER_TRANSIITON_INIT");

    /* renamed from: F0 */
    public final i30 f4937F0 = new i30(this);

    /* renamed from: G0 */
    public final j30 f4938G0 = new j30(this);

    /* renamed from: H0 */
    public final StateMachine.State f4939H0 = new StateMachine.State("STATE_ENTER_TRANSIITON_COMPLETE", true, false);

    /* renamed from: I0 */
    public final k30 f4940I0 = new k30(this);

    /* renamed from: J0 */
    public final l30 f4941J0 = new l30(this);

    /* renamed from: K0 */
    public final m30 f4942K0 = new m30(this);

    /* renamed from: L0 */
    public final StateMachine.Event f4943L0 = new StateMachine.Event("onStart");

    /* renamed from: M0 */
    public final StateMachine.Event f4944M0 = new StateMachine.Event("EVT_NO_ENTER_TRANSITION");

    /* renamed from: N0 */
    public final StateMachine.Event f4945N0 = new StateMachine.Event("onFirstRowLoaded");

    /* renamed from: O0 */
    public final StateMachine.Event f4946O0 = new StateMachine.Event("onEnterTransitionDone");

    /* renamed from: P0 */
    public final StateMachine.Event f4947P0 = new StateMachine.Event("switchToVideo");

    /* renamed from: Q0 */
    public final p30 f4948Q0 = new p30(this);

    /* renamed from: R0 */
    public final a30 f4949R0 = new a30(this);

    /* renamed from: d1 */
    public boolean f4961d1 = false;

    /* renamed from: f1 */
    public final b30 f4963f1 = new b30(1, this);

    /* renamed from: g1 */
    public final n30 f4964g1 = new n30(this);

    @Override // androidx.leanback.app.BaseSupportFragment
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_details_enter_transition);
    }

    public ObjectAdapter getAdapter() {
        return this.f4956Y0;
    }

    public BaseOnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f4959b1;
    }

    public DetailsParallax getParallax() {
        if (this.f4954W0 == null) {
            this.f4954W0 = new DetailsParallax();
            RowsSupportFragment rowsSupportFragment = this.f4955X0;
            if (rowsSupportFragment != null && rowsSupportFragment.getView() != null) {
                this.f4954W0.setRecyclerView(this.f4955X0.getVerticalGridView());
            }
        }
        return this.f4954W0;
    }

    public RowsSupportFragment getRowsSupportFragment() {
        return this.f4955X0;
    }

    public final VerticalGridView getVerticalGridView() {
        RowsSupportFragment rowsSupportFragment = this.f4955X0;
        if (rowsSupportFragment == null) {
            return null;
        }
        return rowsSupportFragment.getVerticalGridView();
    }

    @Deprecated
    public View inflateTitle(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onInflateTitleView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    /* renamed from: l */
    public final void mo1261l() {
        super.mo1261l();
        StateMachine stateMachine = this.f4757A0;
        stateMachine.addState(this.f4935D0);
        stateMachine.addState(this.f4942K0);
        stateMachine.addState(this.f4937F0);
        stateMachine.addState(this.f4936E0);
        stateMachine.addState(this.f4940I0);
        stateMachine.addState(this.f4938G0);
        stateMachine.addState(this.f4941J0);
        stateMachine.addState(this.f4939H0);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    /* renamed from: m */
    public final void mo1262m() {
        super.mo1262m();
        StateMachine.State state = this.f4760n0;
        StateMachine.State state2 = this.f4936E0;
        StateMachine stateMachine = this.f4757A0;
        stateMachine.addTransition(state, state2, this.f4767u0);
        StateMachine.State state3 = this.f4939H0;
        stateMachine.addTransition(state2, state3, this.f4772z0);
        stateMachine.addTransition(state2, state3, this.f4944M0);
        j30 j30Var = this.f4938G0;
        StateMachine.Event event = this.f4947P0;
        stateMachine.addTransition(state2, j30Var, event);
        stateMachine.addTransition(j30Var, state3);
        StateMachine.Event event2 = this.f4768v0;
        k30 k30Var = this.f4940I0;
        stateMachine.addTransition(state2, k30Var, event2);
        StateMachine.Event event3 = this.f4946O0;
        stateMachine.addTransition(k30Var, state3, event3);
        StateMachine.Event event4 = this.f4945N0;
        l30 l30Var = this.f4941J0;
        stateMachine.addTransition(k30Var, l30Var, event4);
        stateMachine.addTransition(l30Var, state3, event3);
        stateMachine.addTransition(state3, this.f4764r0);
        StateMachine.State state4 = this.f4761o0;
        i30 i30Var = this.f4937F0;
        stateMachine.addTransition(state4, i30Var, event);
        StateMachine.State state5 = this.f4766t0;
        stateMachine.addTransition(i30Var, state5);
        stateMachine.addTransition(state5, i30Var, event);
        C1870uf c1870uf = this.f4762p0;
        h30 h30Var = this.f4935D0;
        StateMachine.Event event5 = this.f4943L0;
        stateMachine.addTransition(c1870uf, h30Var, event5);
        m30 m30Var = this.f4942K0;
        stateMachine.addTransition(state, m30Var, event5);
        stateMachine.addTransition(state5, m30Var);
        stateMachine.addTransition(state3, m30Var);
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4957Z0 = getResources().getDimensionPixelSize(R.dimen.lb_details_rows_align_top);
        FragmentActivity activity = getActivity();
        StateMachine.Event event = this.f4944M0;
        StateMachine stateMachine = this.f4757A0;
        if (activity != null) {
            if (TransitionHelper.getEnterTransition(activity.getWindow()) == null) {
                stateMachine.fireEvent(event);
            }
            Object returnTransition = TransitionHelper.getReturnTransition(activity.getWindow());
            if (returnTransition != null) {
                TransitionHelper.addTransitionListener(returnTransition, this.f4949R0);
                return;
            }
            return;
        }
        stateMachine.fireEvent(event);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) layoutInflater.inflate(R.layout.lb_details_fragment, viewGroup, false);
        this.f4950S0 = browseFrameLayout;
        View findViewById = browseFrameLayout.findViewById(R.id.details_background_view);
        this.f4951T0 = findViewById;
        if (findViewById != null) {
            findViewById.setBackground(this.f4952U0);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.details_rows_dock;
        RowsSupportFragment rowsSupportFragment = (RowsSupportFragment) childFragmentManager.findFragmentById(i);
        this.f4955X0 = rowsSupportFragment;
        if (rowsSupportFragment == null) {
            this.f4955X0 = new RowsSupportFragment();
            getChildFragmentManager().beginTransaction().replace(i, this.f4955X0).commit();
        }
        installTitleView(layoutInflater, this.f4950S0, bundle);
        this.f4955X0.setAdapter(this.f4956Y0);
        this.f4955X0.setOnItemViewSelectedListener(this.f4964g1);
        this.f4955X0.setOnItemViewClickedListener(this.f4959b1);
        this.f4962e1 = TransitionHelper.createScene(this.f4950S0, new e30(this, 1));
        this.f4950S0.setOnChildFocusListener(new f30(this));
        this.f4950S0.setOnFocusSearchListener(new g30(this));
        this.f4950S0.setOnDispatchKeyListener(new q20(1, this));
        this.f4955X0.f5236z0 = new o30(this);
        return this.f4950S0;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        DetailsParallax detailsParallax = this.f4954W0;
        if (detailsParallax != null) {
            detailsParallax.setRecyclerView(null);
        }
        this.f4950S0 = null;
        this.f4951T0 = null;
        this.f4955X0 = null;
        this.f4953V0 = null;
        this.f4962e1 = null;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionEnd() {
        this.f4955X0.onTransitionEnd();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionPrepare() {
        this.f4955X0.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionStart() {
        this.f4955X0.onTransitionStart();
    }

    @Override // androidx.leanback.app.BrandedSupportFragment
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

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.f4955X0.getVerticalGridView();
        verticalGridView.setItemAlignmentOffset(-this.f4957Z0);
        verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignmentOffset(0);
        verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignment(0);
        this.f4757A0.fireEvent(this.f4943L0);
        DetailsParallax detailsParallax = this.f4954W0;
        if (detailsParallax != null) {
            detailsParallax.setRecyclerView(this.f4955X0.getVerticalGridView());
        }
        if (this.f4961d1) {
            if (getVerticalGridView() != null) {
                getVerticalGridView().animateOut();
            }
        } else if (!getView().hasFocus()) {
            this.f4955X0.getVerticalGridView().requestFocus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        PlaybackGlue playbackGlue;
        DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController = this.f4960c1;
        if (detailsSupportFragmentBackgroundController != null && (playbackGlue = detailsSupportFragmentBackgroundController.f4968d) != null) {
            playbackGlue.pause();
        }
        super.onStop();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.f4962e1, obj);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.f4956Y0 = objectAdapter;
        Presenter[] presenters = objectAdapter.getPresenterSelector().getPresenters();
        if (presenters != null) {
            for (Presenter presenter : presenters) {
                setupPresenter(presenter);
            }
        } else {
            Log.e("DetailsSupportFragment", "PresenterSelector.getPresenters() not implemented");
        }
        RowsSupportFragment rowsSupportFragment = this.f4955X0;
        if (rowsSupportFragment != null) {
            rowsSupportFragment.setAdapter(objectAdapter);
        }
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        if (this.f4959b1 != baseOnItemViewClickedListener) {
            this.f4959b1 = baseOnItemViewClickedListener;
            RowsSupportFragment rowsSupportFragment = this.f4955X0;
            if (rowsSupportFragment != null) {
                rowsSupportFragment.setOnItemViewClickedListener(baseOnItemViewClickedListener);
            }
        }
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.f4958a1 = baseOnItemViewSelectedListener;
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
        b30 b30Var = this.f4963f1;
        b30Var.f7877b = i;
        b30Var.f7878c = z;
        if (getView() == null || getView().getHandler() == null) {
            return;
        }
        getView().getHandler().post(b30Var);
    }
}
