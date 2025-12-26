package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.VerticalGridPresenter;
import p000.ai2;
import p000.sn1;
import p000.y13;
import p000.z13;

/* loaded from: classes.dex */
public class VerticalGridSupportFragment extends BaseSupportFragment {

    /* renamed from: D0 */
    public ObjectAdapter f5297D0;

    /* renamed from: E0 */
    public VerticalGridPresenter f5298E0;

    /* renamed from: F0 */
    public VerticalGridPresenter.ViewHolder f5299F0;

    /* renamed from: G0 */
    public OnItemViewSelectedListener f5300G0;

    /* renamed from: H0 */
    public OnItemViewClickedListener f5301H0;

    /* renamed from: I0 */
    public Object f5302I0;

    /* renamed from: J0 */
    public int f5303J0 = -1;

    /* renamed from: K0 */
    public final y13 f5304K0 = new y13(this);

    /* renamed from: L0 */
    public final z13 f5305L0 = new z13(this);

    /* renamed from: M0 */
    public final ai2 f5306M0 = new ai2(10, this);

    @Override // androidx.leanback.app.BaseSupportFragment
    @NonNull
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_vertical_grid_entrance_transition);
    }

    @Nullable
    public ObjectAdapter getAdapter() {
        return this.f5297D0;
    }

    @Nullable
    public VerticalGridPresenter getGridPresenter() {
        return this.f5298E0;
    }

    @Nullable
    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f5301H0;
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    /* renamed from: l */
    public final void mo1261l() {
        super.mo1261l();
        this.f4757A0.addState(this.f5304K0);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    /* renamed from: m */
    public final void mo1262m() {
        super.mo1262m();
        this.f4757A0.addTransition(this.f4762p0, this.f5304K0, this.f4768v0);
    }

    /* renamed from: n */
    public final void m1354n() {
        if (this.f5299F0.getGridView().findViewHolderForAdapterPosition(this.f5303J0) == null) {
            return;
        }
        if (!this.f5299F0.getGridView().hasPreviousViewInSameRow(this.f5303J0)) {
            showTitle(true);
        } else {
            showTitle(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.lb_vertical_grid_fragment, viewGroup, false);
        installTitleView(layoutInflater, (ViewGroup) viewGroup2.findViewById(R.id.grid_frame), bundle);
        getProgressBarManager().setRootView(viewGroup2);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.browse_grid_dock);
        VerticalGridPresenter.ViewHolder onCreateViewHolder = this.f5298E0.onCreateViewHolder(viewGroup3);
        this.f5299F0 = onCreateViewHolder;
        viewGroup3.addView(onCreateViewHolder.view);
        this.f5299F0.getGridView().setOnChildLaidOutListener(this.f5306M0);
        this.f5302I0 = TransitionHelper.createScene(viewGroup3, new sn1(13, this));
        VerticalGridPresenter.ViewHolder viewHolder = this.f5299F0;
        if (viewHolder != null) {
            this.f5298E0.onBindViewHolder(viewHolder, this.f5297D0);
            if (this.f5303J0 != -1) {
                this.f5299F0.getGridView().setSelectedPosition(this.f5303J0);
            }
        }
        return viewGroup2;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f5299F0.getGridView().swapAdapter(null, true);
        this.f5299F0 = null;
        this.f5302I0 = null;
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((BrowseFrameLayout) getView().findViewById(R.id.grid_frame)).setOnFocusSearchListener(this.f4790m0.getOnFocusSearchListener());
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void runEntranceTransition(@Nullable Object obj) {
        TransitionHelper.runTransition(this.f5302I0, obj);
    }

    public void setAdapter(@Nullable ObjectAdapter objectAdapter) {
        this.f5297D0 = objectAdapter;
        VerticalGridPresenter.ViewHolder viewHolder = this.f5299F0;
        if (viewHolder != null) {
            this.f5298E0.onBindViewHolder(viewHolder, objectAdapter);
            if (this.f5303J0 != -1) {
                this.f5299F0.getGridView().setSelectedPosition(this.f5303J0);
            }
        }
    }

    public void setGridPresenter(@NonNull VerticalGridPresenter verticalGridPresenter) {
        if (verticalGridPresenter != null) {
            this.f5298E0 = verticalGridPresenter;
            verticalGridPresenter.setOnItemViewSelectedListener(this.f5305L0);
            OnItemViewClickedListener onItemViewClickedListener = this.f5301H0;
            if (onItemViewClickedListener != null) {
                this.f5298E0.setOnItemViewClickedListener(onItemViewClickedListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Grid presenter may not be null");
    }

    public void setOnItemViewClickedListener(@Nullable OnItemViewClickedListener onItemViewClickedListener) {
        this.f5301H0 = onItemViewClickedListener;
        VerticalGridPresenter verticalGridPresenter = this.f5298E0;
        if (verticalGridPresenter != null) {
            verticalGridPresenter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public void setOnItemViewSelectedListener(@Nullable OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f5300G0 = onItemViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        this.f5303J0 = i;
        VerticalGridPresenter.ViewHolder viewHolder = this.f5299F0;
        if (viewHolder != null && viewHolder.getGridView().getAdapter() != null) {
            this.f5299F0.getGridView().setSelectedPositionSmooth(i);
        }
    }
}
