package androidx.leanback.app;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.app.BrowseFragment;
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
import p000.AbstractFragmentC1722qf;
import p000.ad2;
import p000.xc2;
import p000.zc2;

@Deprecated
/* loaded from: classes.dex */
public class RowsFragment extends AbstractFragmentC1722qf implements BrowseFragment.MainFragmentRowsAdapterProvider, BrowseFragment.MainFragmentAdapterProvider {

    /* renamed from: i */
    public MainFragmentAdapter f5207i;

    /* renamed from: j */
    public MainFragmentRowsAdapter f5208j;

    /* renamed from: k */
    public ItemBridgeAdapter.ViewHolder f5209k;

    /* renamed from: l */
    public int f5210l;

    /* renamed from: n */
    public boolean f5212n;

    /* renamed from: q */
    public boolean f5215q;

    /* renamed from: r */
    public BaseOnItemViewSelectedListener f5216r;

    /* renamed from: s */
    public BaseOnItemViewClickedListener f5217s;

    /* renamed from: t */
    public RecyclerView.RecycledViewPool f5218t;

    /* renamed from: u */
    public ArrayList f5219u;

    /* renamed from: v */
    public ItemBridgeAdapter.AdapterListener f5220v;

    /* renamed from: m */
    public boolean f5211m = true;

    /* renamed from: o */
    public int f5213o = Integer.MIN_VALUE;

    /* renamed from: p */
    public boolean f5214p = true;

    /* renamed from: w */
    public final xc2 f5221w = new xc2(this);

    /* loaded from: classes.dex */
    public static class MainFragmentAdapter extends BrowseFragment.MainFragmentAdapter<RowsFragment> {
        public MainFragmentAdapter(RowsFragment rowsFragment) {
            super(rowsFragment);
            setScalingEnabled(true);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public boolean isScrolling() {
            return getFragment().isScrolling();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void onTransitionEnd() {
            getFragment().onTransitionEnd();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public boolean onTransitionPrepare() {
            return getFragment().onTransitionPrepare();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void onTransitionStart() {
            getFragment().onTransitionStart();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void setAlignment(int i) {
            getFragment().setAlignment(i);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void setEntranceTransitionState(boolean z) {
            getFragment().setEntranceTransitionState(z);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void setExpand(boolean z) {
            getFragment().setExpand(z);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class MainFragmentRowsAdapter extends BrowseFragment.MainFragmentRowsAdapter<RowsFragment> {
        public MainFragmentRowsAdapter(RowsFragment rowsFragment) {
            super(rowsFragment);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
            return getFragment().findRowViewHolderByPosition(i);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public int getSelectedPosition() {
            return getFragment().getSelectedPosition();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setAdapter(ObjectAdapter objectAdapter) {
            getFragment().setAdapter(objectAdapter);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
            getFragment().setOnItemViewClickedListener(onItemViewClickedListener);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
            getFragment().setOnItemViewSelectedListener(onItemViewSelectedListener);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
            getFragment().setSelectedPosition(i, z, viewHolderTask);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setSelectedPosition(int i, boolean z) {
            getFragment().setSelectedPosition(i, z);
        }
    }

    /* renamed from: f */
    public static RowPresenter.ViewHolder m1339f(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
    }

    /* renamed from: g */
    public static void m1340g(ItemBridgeAdapter.ViewHolder viewHolder, boolean z, boolean z2) {
        float f;
        ad2 ad2Var = (ad2) viewHolder.getExtraObject();
        TimeAnimator timeAnimator = ad2Var.f138c;
        timeAnimator.end();
        if (z) {
            f = 1.0f;
        } else {
            f = RecyclerView.f7068F0;
        }
        Presenter.ViewHolder viewHolder2 = ad2Var.f137b;
        RowPresenter rowPresenter = ad2Var.f136a;
        if (z2) {
            rowPresenter.setSelectLevel(viewHolder2, f);
        } else if (rowPresenter.getSelectLevel(viewHolder2) != f) {
            float selectLevel = rowPresenter.getSelectLevel(viewHolder2);
            ad2Var.f141f = selectLevel;
            ad2Var.f142g = f - selectLevel;
            timeAnimator.start();
        }
        ((RowPresenter) viewHolder.getPresenter()).setRowViewSelected(viewHolder.getViewHolder(), z);
    }

    @Override // p000.AbstractFragmentC1722qf
    /* renamed from: a */
    public final int mo1302a() {
        return R.layout.lb_rows_fragment;
    }

    @Override // p000.AbstractFragmentC1722qf
    /* renamed from: b */
    public final void mo1303b(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        ItemBridgeAdapter.ViewHolder viewHolder2 = this.f5209k;
        boolean z = true;
        if (viewHolder2 != viewHolder || this.f5210l != i2) {
            this.f5210l = i2;
            if (viewHolder2 != null) {
                m1340g(viewHolder2, false, false);
            }
            ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) viewHolder;
            this.f5209k = viewHolder3;
            if (viewHolder3 != null) {
                m1340g(viewHolder3, true, false);
            }
        }
        MainFragmentAdapter mainFragmentAdapter = this.f5207i;
        if (mainFragmentAdapter != null) {
            BrowseFragment.FragmentHost fragmentHost = mainFragmentAdapter.getFragmentHost();
            if (i > 0) {
                z = false;
            }
            fragmentHost.showTitleView(z);
        }
    }

    @Override // p000.AbstractFragmentC1722qf
    /* renamed from: d */
    public final void mo1304d() {
        ItemBridgeAdapter itemBridgeAdapter = this.f25563d;
        itemBridgeAdapter.setAdapter(this.f25560a);
        itemBridgeAdapter.setPresenter(this.f25562c);
        if (this.f25561b != null) {
            m7034c();
        }
        this.f5209k = null;
        this.f5212n = false;
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        if (bridgeAdapter != null) {
            bridgeAdapter.setAdapterListener(this.f5221w);
        }
    }

    /* renamed from: e */
    public final void m1341e(boolean z) {
        this.f5215q = z;
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

    @Deprecated
    public void enableRowScaling(boolean z) {
    }

    @Override // p000.AbstractFragmentC1722qf
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.container_list);
    }

    public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView == null) {
            return null;
        }
        return m1339f((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i));
    }

    @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapterProvider
    public BrowseFragment.MainFragmentAdapter getMainFragmentAdapter() {
        if (this.f5207i == null) {
            this.f5207i = new MainFragmentAdapter(this);
        }
        return this.f5207i;
    }

    @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapterProvider
    public BrowseFragment.MainFragmentRowsAdapter getMainFragmentRowsAdapter() {
        if (this.f5208j == null) {
            this.f5208j = new MainFragmentRowsAdapter(this);
        }
        return this.f5208j;
    }

    public BaseOnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f5217s;
    }

    public BaseOnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.f5216r;
    }

    public RowPresenter.ViewHolder getRowViewHolder(int i) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return null;
        }
        return m1339f((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i));
    }

    public int getSelectedPosition() {
        return this.f25564e;
    }

    public boolean isScrolling() {
        if (getVerticalGridView() == null || getVerticalGridView().getScrollState() == 0) {
            return false;
        }
        return true;
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    public void onDestroyView() {
        this.f5212n = false;
        this.f5209k = null;
        this.f5218t = null;
        super.onDestroyView();
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // p000.AbstractFragmentC1722qf
    public void onTransitionEnd() {
        super.onTransitionEnd();
        m1341e(false);
    }

    @Override // p000.AbstractFragmentC1722qf
    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.f25561b;
        boolean z = false;
        if (verticalGridView != null) {
            verticalGridView.setAnimateChildLayout(false);
            this.f25561b.setScrollEnabled(false);
            z = true;
        } else {
            this.f25565f = true;
        }
        if (z) {
            m1341e(true);
        }
        return z;
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView != null) {
            verticalGridView.setPruneChild(false);
            this.f25561b.setLayoutFrozen(true);
            this.f25561b.setFocusSearchDisabled(true);
        }
    }

    @Override // p000.AbstractFragmentC1722qf, android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        getVerticalGridView().setItemAlignmentViewId(R.id.row_content);
        getVerticalGridView().setSaveChildrenPolicy(2);
        setAlignment(this.f5213o);
        this.f5218t = null;
        this.f5219u = null;
        MainFragmentAdapter mainFragmentAdapter = this.f5207i;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.getFragmentHost().notifyViewCreated(this.f5207i);
        }
    }

    public void setAlignment(int i) {
        if (i == Integer.MIN_VALUE) {
            return;
        }
        this.f5213o = i;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffsetWithPadding(true);
            verticalGridView.setWindowAlignmentOffset(this.f5213o);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setWindowAlignment(0);
        }
    }

    public void setEntranceTransitionState(boolean z) {
        this.f5214p = z;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.setEntranceTransitionState(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), this.f5214p);
            }
        }
    }

    public void setExpand(boolean z) {
        this.f5211m = z;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                ((RowPresenter) viewHolder.getPresenter()).setRowViewExpanded(viewHolder.getViewHolder(), this.f5211m);
            }
        }
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.f5217s = baseOnItemViewClickedListener;
        if (!this.f5212n) {
        } else {
            throw new IllegalStateException("Item clicked listener must be set before views are created");
        }
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.f5216r = baseOnItemViewSelectedListener;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m1339f((ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i))).setOnItemViewSelectedListener(this.f5216r);
            }
        }
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setSelectedPosition(int i, boolean z) {
        if (this.f25564e == i) {
            return;
        }
        this.f25564e = i;
        VerticalGridView verticalGridView = this.f25561b;
        if (verticalGridView == null || this.f25566g.f25143a) {
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
        zc2 zc2Var = viewHolderTask != null ? new zc2(viewHolderTask) : null;
        if (z) {
            verticalGridView.setSelectedPositionSmooth(i, zc2Var);
        } else {
            verticalGridView.setSelectedPosition(i, zc2Var);
        }
    }
}
