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
import p000.ou0;
import p000.sn1;
import p000.w13;
import p000.x13;

@Deprecated
/* loaded from: classes.dex */
public class VerticalGridFragment extends BaseFragment {

    /* renamed from: A */
    public VerticalGridPresenter f5287A;

    /* renamed from: B */
    public VerticalGridPresenter.ViewHolder f5288B;

    /* renamed from: C */
    public OnItemViewSelectedListener f5289C;

    /* renamed from: D */
    public OnItemViewClickedListener f5290D;

    /* renamed from: E */
    public Object f5291E;

    /* renamed from: F */
    public int f5292F = -1;

    /* renamed from: G */
    public final w13 f5293G = new w13(this);

    /* renamed from: H */
    public final x13 f5294H = new x13(this);

    /* renamed from: I */
    public final ai2 f5295I = new ai2(9, this);

    /* renamed from: z */
    public ObjectAdapter f5296z;

    @Override // androidx.leanback.app.BaseFragment
    /* renamed from: a */
    public final void mo1259a() {
        super.mo1259a();
        this.f4754w.addState(this.f5293G);
    }

    @Override // androidx.leanback.app.BaseFragment
    /* renamed from: b */
    public final void mo1260b() {
        super.mo1260b();
        this.f4754w.addTransition(this.f4743l, this.f5293G, this.f4749r);
    }

    /* renamed from: c */
    public final void m1353c() {
        if (this.f5288B.getGridView().findViewHolderForAdapterPosition(this.f5292F) == null) {
            return;
        }
        if (!this.f5288B.getGridView().hasPreviousViewInSameRow(this.f5292F)) {
            showTitle(true);
        } else {
            showTitle(false);
        }
    }

    @Override // androidx.leanback.app.BaseFragment
    @NonNull
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(ou0.m6729a(this), R.transition.lb_vertical_grid_entrance_transition);
    }

    @Nullable
    public ObjectAdapter getAdapter() {
        return this.f5296z;
    }

    @Nullable
    public VerticalGridPresenter getGridPresenter() {
        return this.f5287A;
    }

    @Nullable
    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f5290D;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.lb_vertical_grid_fragment, viewGroup, false);
        installTitleView(layoutInflater, (ViewGroup) viewGroup2.findViewById(R.id.grid_frame), bundle);
        getProgressBarManager().setRootView(viewGroup2);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.browse_grid_dock);
        VerticalGridPresenter.ViewHolder onCreateViewHolder = this.f5287A.onCreateViewHolder(viewGroup3);
        this.f5288B = onCreateViewHolder;
        viewGroup3.addView(onCreateViewHolder.view);
        this.f5288B.getGridView().setOnChildLaidOutListener(this.f5295I);
        this.f5291E = TransitionHelper.createScene(viewGroup3, new sn1(12, this));
        VerticalGridPresenter.ViewHolder viewHolder = this.f5288B;
        if (viewHolder != null) {
            this.f5287A.onBindViewHolder(viewHolder, this.f5296z);
            if (this.f5292F != -1) {
                this.f5288B.getGridView().setSelectedPosition(this.f5292F);
            }
        }
        return viewGroup2;
    }

    @Override // androidx.leanback.app.BaseFragment, androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f5288B.getGridView().swapAdapter(null, true);
        this.f5288B = null;
        this.f5291E = null;
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        ((BrowseFrameLayout) getView().findViewById(R.id.grid_frame)).setOnFocusSearchListener(this.f4781i.getOnFocusSearchListener());
    }

    @Override // androidx.leanback.app.BaseFragment
    public void runEntranceTransition(@Nullable Object obj) {
        TransitionHelper.runTransition(this.f5291E, obj);
    }

    public void setAdapter(@Nullable ObjectAdapter objectAdapter) {
        this.f5296z = objectAdapter;
        VerticalGridPresenter.ViewHolder viewHolder = this.f5288B;
        if (viewHolder != null) {
            this.f5287A.onBindViewHolder(viewHolder, objectAdapter);
            if (this.f5292F != -1) {
                this.f5288B.getGridView().setSelectedPosition(this.f5292F);
            }
        }
    }

    public void setGridPresenter(@NonNull VerticalGridPresenter verticalGridPresenter) {
        if (verticalGridPresenter != null) {
            this.f5287A = verticalGridPresenter;
            verticalGridPresenter.setOnItemViewSelectedListener(this.f5294H);
            OnItemViewClickedListener onItemViewClickedListener = this.f5290D;
            if (onItemViewClickedListener != null) {
                this.f5287A.setOnItemViewClickedListener(onItemViewClickedListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Grid presenter may not be null");
    }

    public void setOnItemViewClickedListener(@Nullable OnItemViewClickedListener onItemViewClickedListener) {
        this.f5290D = onItemViewClickedListener;
        VerticalGridPresenter verticalGridPresenter = this.f5287A;
        if (verticalGridPresenter != null) {
            verticalGridPresenter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public void setOnItemViewSelectedListener(@Nullable OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f5289C = onItemViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        this.f5292F = i;
        VerticalGridPresenter.ViewHolder viewHolder = this.f5288B;
        if (viewHolder != null && viewHolder.getGridView().getAdapter() != null) {
            this.f5288B.getGridView().setSelectedPositionSmooth(i);
        }
    }
}
