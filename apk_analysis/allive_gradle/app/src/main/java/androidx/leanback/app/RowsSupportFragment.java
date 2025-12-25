package androidx.leanback.app;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.AbstractC1833tf;
import p000.bd2;
import p000.dd2;
import p000.ed2;

/* loaded from: classes.dex */
public class RowsSupportFragment extends AbstractC1833tf implements BrowseSupportFragment.MainFragmentRowsAdapterProvider, BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: m0 */
    public MainFragmentAdapter f5223m0;

    /* renamed from: n0 */
    public MainFragmentRowsAdapter f5224n0;

    /* renamed from: o0 */
    public ItemBridgeAdapter.ViewHolder f5225o0;

    /* renamed from: p0 */
    public int f5226p0;

    /* renamed from: r0 */
    public boolean f5228r0;

    /* renamed from: u0 */
    public boolean f5231u0;

    /* renamed from: v0 */
    public BaseOnItemViewSelectedListener f5232v0;

    /* renamed from: w0 */
    public BaseOnItemViewClickedListener f5233w0;

    /* renamed from: x0 */
    public RecyclerView.RecycledViewPool f5234x0;

    /* renamed from: y0 */
    public ArrayList f5235y0;

    /* renamed from: z0 */
    public ItemBridgeAdapter.AdapterListener f5236z0;

    /* renamed from: q0 */
    public boolean f5227q0 = true;

    /* renamed from: s0 */
    public int f5229s0 = Integer.MIN_VALUE;

    /* renamed from: t0 */
    public boolean f5230t0 = true;

    /* renamed from: A0 */
    public final bd2 f5222A0 = new bd2(this);

    /* loaded from: classes.dex */
    public static class MainFragmentAdapter extends BrowseSupportFragment.MainFragmentAdapter<RowsSupportFragment> {
        public MainFragmentAdapter(RowsSupportFragment rowsSupportFragment) {
            super(rowsSupportFragment);
            setScalingEnabled(true);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public boolean isScrolling() {
            return getFragment().isScrolling();
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public void onTransitionEnd() {
            getFragment().onTransitionEnd();
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public boolean onTransitionPrepare() {
            return getFragment().onTransitionPrepare();
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public void onTransitionStart() {
            getFragment().onTransitionStart();
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public void setAlignment(int i) {
            getFragment().setAlignment(i);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public void setEntranceTransitionState(boolean z) {
            getFragment().setEntranceTransitionState(z);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapter
        public void setExpand(boolean z) {
            getFragment().setExpand(z);
        }
    }

    /* loaded from: classes.dex */
    public static class MainFragmentRowsAdapter extends BrowseSupportFragment.MainFragmentRowsAdapter<RowsSupportFragment> {
        public MainFragmentRowsAdapter(RowsSupportFragment rowsSupportFragment) {
            super(rowsSupportFragment);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
            return getFragment().findRowViewHolderByPosition(i);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public int getSelectedPosition() {
            return getFragment().getSelectedPosition();
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public void setAdapter(ObjectAdapter objectAdapter) {
            getFragment().setAdapter(objectAdapter);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
            getFragment().setOnItemViewClickedListener(onItemViewClickedListener);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
            getFragment().setOnItemViewSelectedListener(onItemViewSelectedListener);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
            getFragment().setSelectedPosition(i, z, viewHolderTask);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapter
        public void setSelectedPosition(int i, boolean z) {
            getFragment().setSelectedPosition(i, z);
        }
    }

    /* renamed from: q */
    public static RowPresenter.ViewHolder m1342q(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
    }

    /* renamed from: r */
    public static void m1343r(ItemBridgeAdapter.ViewHolder viewHolder, boolean z, boolean z2) {
        float f;
        ed2 ed2Var = (ed2) viewHolder.getExtraObject();
        TimeAnimator timeAnimator = ed2Var.f16771c;
        timeAnimator.end();
        if (z) {
            f = 1.0f;
        } else {
            f = RecyclerView.f7068F0;
        }
        Presenter.ViewHolder viewHolder2 = ed2Var.f16770b;
        RowPresenter rowPresenter = ed2Var.f16769a;
        if (z2) {
            rowPresenter.setSelectLevel(viewHolder2, f);
        } else if (rowPresenter.getSelectLevel(viewHolder2) != f) {
            float selectLevel = rowPresenter.getSelectLevel(viewHolder2);
            ed2Var.f16774f = selectLevel;
            ed2Var.f16775g = f - selectLevel;
            timeAnimator.start();
        }
        ((RowPresenter) viewHolder.getPresenter()).setRowViewSelected(viewHolder.getViewHolder(), z);
    }

    @Deprecated
    public void enableRowScaling(boolean z) {
    }

    @Override // p000.AbstractC1833tf
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.container_list);
    }

    public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView == null) {
            return null;
        }
        return m1342q((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i));
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapterProvider
    public BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        if (this.f5223m0 == null) {
            this.f5223m0 = new MainFragmentAdapter(this);
        }
        return this.f5223m0;
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentRowsAdapterProvider
    public BrowseSupportFragment.MainFragmentRowsAdapter getMainFragmentRowsAdapter() {
        if (this.f5224n0 == null) {
            this.f5224n0 = new MainFragmentRowsAdapter(this);
        }
        return this.f5224n0;
    }

    public BaseOnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f5233w0;
    }

    public BaseOnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.f5232v0;
    }

    public RowPresenter.ViewHolder getRowViewHolder(int i) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return null;
        }
        return m1342q((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i));
    }

    public int getSelectedPosition() {
        return this.f26796i0;
    }

    public boolean isScrolling() {
        if (getVerticalGridView() == null || getVerticalGridView().getScrollState() == 0) {
            return false;
        }
        return true;
    }

    @Override // p000.AbstractC1833tf
    /* renamed from: l */
    public final int mo1307l() {
        return R.layout.lb_rows_fragment;
    }

    @Override // p000.AbstractC1833tf
    /* renamed from: m */
    public final void mo1308m(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        ItemBridgeAdapter.ViewHolder viewHolder2 = this.f5225o0;
        boolean z = true;
        if (viewHolder2 != viewHolder || this.f5226p0 != i2) {
            this.f5226p0 = i2;
            if (viewHolder2 != null) {
                m1343r(viewHolder2, false, false);
            }
            ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) viewHolder;
            this.f5225o0 = viewHolder3;
            if (viewHolder3 != null) {
                m1343r(viewHolder3, true, false);
            }
        }
        MainFragmentAdapter mainFragmentAdapter = this.f5223m0;
        if (mainFragmentAdapter != null) {
            BrowseSupportFragment.FragmentHost fragmentHost = mainFragmentAdapter.getFragmentHost();
            if (i > 0) {
                z = false;
            }
            fragmentHost.showTitleView(z);
        }
    }

    @Override // p000.AbstractC1833tf
    /* renamed from: o */
    public final void mo1309o() {
        ItemBridgeAdapter itemBridgeAdapter = this.f26795h0;
        itemBridgeAdapter.setAdapter(this.f26792e0);
        itemBridgeAdapter.setPresenter(this.f26794g0);
        if (this.f26793f0 != null) {
            m7494n();
        }
        this.f5225o0 = null;
        this.f5228r0 = false;
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        if (bridgeAdapter != null) {
            bridgeAdapter.setAdapterListener(this.f5222A0);
        }
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f5228r0 = false;
        this.f5225o0 = null;
        this.f5234x0 = null;
        super.onDestroyView();
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // p000.AbstractC1833tf
    public void onTransitionEnd() {
        super.onTransitionEnd();
        m1344p(false);
    }

    @Override // p000.AbstractC1833tf
    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.f26793f0;
        boolean z = false;
        if (verticalGridView != null) {
            verticalGridView.setAnimateChildLayout(false);
            this.f26793f0.setScrollEnabled(false);
            z = true;
        } else {
            this.f26797j0 = true;
        }
        if (z) {
            m1344p(true);
        }
        return z;
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.setPruneChild(false);
            this.f26793f0.setLayoutFrozen(true);
            this.f26793f0.setFocusSearchDisabled(true);
        }
    }

    @Override // p000.AbstractC1833tf, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        getVerticalGridView().setItemAlignmentViewId(R.id.row_content);
        getVerticalGridView().setSaveChildrenPolicy(2);
        setAlignment(this.f5229s0);
        this.f5234x0 = null;
        this.f5235y0 = null;
        MainFragmentAdapter mainFragmentAdapter = this.f5223m0;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.getFragmentHost().notifyViewCreated(this.f5223m0);
        }
    }

    /* renamed from: p */
    public final void m1344p(boolean z) {
        this.f5231u0 = z;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.freeze(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), z);
            }
        }
    }

    public void setAlignment(int i) {
        if (i == Integer.MIN_VALUE) {
            return;
        }
        this.f5229s0 = i;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffsetWithPadding(true);
            verticalGridView.setWindowAlignmentOffset(this.f5229s0);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setWindowAlignment(0);
        }
    }

    public void setEntranceTransitionState(boolean z) {
        this.f5230t0 = z;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.setEntranceTransitionState(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), this.f5230t0);
            }
        }
    }

    public void setExpand(boolean z) {
        this.f5227q0 = z;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                ((RowPresenter) viewHolder.getPresenter()).setRowViewExpanded(viewHolder.getViewHolder(), this.f5227q0);
            }
        }
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.f5233w0 = baseOnItemViewClickedListener;
        if (!this.f5228r0) {
        } else {
            throw new IllegalStateException("Item clicked listener must be set before views are created");
        }
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.f5232v0 = baseOnItemViewSelectedListener;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m1342q((ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i))).setOnItemViewSelectedListener(this.f5232v0);
            }
        }
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setSelectedPosition(int i, boolean z) {
        if (this.f26796i0 == i) {
            return;
        }
        this.f26796i0 = i;
        VerticalGridView verticalGridView = this.f26793f0;
        if (verticalGridView == null || this.f26798k0.f26401a) {
            return;
        }
        if (z) {
            verticalGridView.setSelectedPositionSmooth(i);
        } else {
            verticalGridView.setSelectedPosition(i);
        }
    }

    public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return;
        }
        dd2 dd2Var = viewHolderTask != null ? new dd2(viewHolderTask) : null;
        if (z) {
            verticalGridView.setSelectedPositionSmooth(i, dd2Var);
        } else {
            verticalGridView.setSelectedPosition(i, dd2Var);
        }
    }
}
