package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.system.Settings;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ShadowOverlayHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ListRowPresenter extends RowPresenter {

    /* renamed from: r */
    public static int f5884r;

    /* renamed from: s */
    public static int f5885s;

    /* renamed from: t */
    public static int f5886t;

    /* renamed from: e */
    public int f5887e;

    /* renamed from: f */
    public int f5888f;

    /* renamed from: g */
    public int f5889g;

    /* renamed from: h */
    public PresenterSelector f5890h;

    /* renamed from: i */
    public final int f5891i;

    /* renamed from: j */
    public final boolean f5892j;

    /* renamed from: k */
    public boolean f5893k;

    /* renamed from: l */
    public int f5894l;

    /* renamed from: m */
    public boolean f5895m;

    /* renamed from: n */
    public boolean f5896n;

    /* renamed from: o */
    public final HashMap f5897o;

    /* renamed from: p */
    public ShadowOverlayHelper f5898p;

    /* renamed from: q */
    public ItemBridgeAdapterShadowOverlayWrapper f5899q;

    /* loaded from: classes.dex */
    public static class SelectItemViewHolderTask extends Presenter.ViewHolderTask {

        /* renamed from: a */
        public int f5900a;

        /* renamed from: b */
        public boolean f5901b = true;

        /* renamed from: c */
        public Presenter.ViewHolderTask f5902c;

        public SelectItemViewHolderTask(int i) {
            setItemPosition(i);
        }

        public int getItemPosition() {
            return this.f5900a;
        }

        @Nullable
        public Presenter.ViewHolderTask getItemTask() {
            return this.f5902c;
        }

        public boolean isSmoothScroll() {
            return this.f5901b;
        }

        @Override // androidx.leanback.widget.Presenter.ViewHolderTask
        public void run(@Nullable Presenter.ViewHolder viewHolder) {
            C0362m1 c0362m1;
            if (viewHolder instanceof ViewHolder) {
                HorizontalGridView gridView = ((ViewHolder) viewHolder).getGridView();
                if (this.f5902c != null) {
                    c0362m1 = new C0362m1(this);
                } else {
                    c0362m1 = null;
                }
                if (isSmoothScroll()) {
                    gridView.setSelectedPositionSmooth(this.f5900a, c0362m1);
                } else {
                    gridView.setSelectedPosition(this.f5900a, c0362m1);
                }
            }
        }

        public void setItemPosition(int i) {
            this.f5900a = i;
        }

        public void setItemTask(@Nullable Presenter.ViewHolderTask viewHolderTask) {
            this.f5902c = viewHolderTask;
        }

        public void setSmoothScroll(boolean z) {
            this.f5901b = z;
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RowPresenter.ViewHolder {

        /* renamed from: n */
        public final ListRowPresenter f5903n;

        /* renamed from: o */
        public final HorizontalGridView f5904o;

        /* renamed from: p */
        public C0358l1 f5905p;

        /* renamed from: q */
        public final HorizontalHoverCardSwitcher f5906q;

        /* renamed from: r */
        public final int f5907r;

        /* renamed from: s */
        public final int f5908s;

        /* renamed from: t */
        public final int f5909t;

        /* renamed from: u */
        public final int f5910u;

        public ViewHolder(@NonNull View view, @NonNull HorizontalGridView horizontalGridView, @NonNull ListRowPresenter listRowPresenter) {
            super(view);
            this.f5906q = new HorizontalHoverCardSwitcher();
            this.f5904o = horizontalGridView;
            this.f5903n = listRowPresenter;
            this.f5907r = horizontalGridView.getPaddingTop();
            this.f5908s = horizontalGridView.getPaddingBottom();
            this.f5909t = horizontalGridView.getPaddingLeft();
            this.f5910u = horizontalGridView.getPaddingRight();
        }

        @NonNull
        public final ItemBridgeAdapter getBridgeAdapter() {
            return this.f5905p;
        }

        @NonNull
        public final HorizontalGridView getGridView() {
            return this.f5904o;
        }

        @Nullable
        public Presenter.ViewHolder getItemViewHolder(int i) {
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) this.f5904o.findViewHolderForAdapterPosition(i);
            if (viewHolder == null) {
                return null;
            }
            return viewHolder.getViewHolder();
        }

        @NonNull
        public final ListRowPresenter getListRowPresenter() {
            return this.f5903n;
        }

        @Override // androidx.leanback.widget.RowPresenter.ViewHolder
        @Nullable
        public Object getSelectedItem() {
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) this.f5904o.findViewHolderForAdapterPosition(getSelectedPosition());
            if (viewHolder == null) {
                return null;
            }
            return viewHolder.getItem();
        }

        @Override // androidx.leanback.widget.RowPresenter.ViewHolder
        @Nullable
        public Presenter.ViewHolder getSelectedItemViewHolder() {
            return getItemViewHolder(getSelectedPosition());
        }

        public int getSelectedPosition() {
            return this.f5904o.getSelectedPosition();
        }
    }

    public ListRowPresenter() {
        this(2);
    }

    public void applySelectLevelToChild(ViewHolder viewHolder, View view) {
        ShadowOverlayHelper shadowOverlayHelper = this.f5898p;
        if (shadowOverlayHelper != null && shadowOverlayHelper.needsOverlay()) {
            this.f5898p.setOverlayColor(view, viewHolder.mColorDimmer.getPaint().getColor());
        }
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.f5895m;
    }

    /* renamed from: c */
    public final void m1447c(ViewHolder viewHolder, View view, boolean z) {
        if (view != null) {
            if (viewHolder.f6115g) {
                HorizontalGridView horizontalGridView = viewHolder.f5904o;
                ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.getChildViewHolder(view);
                if (this.f5890h != null) {
                    viewHolder.f5906q.select(horizontalGridView, view, viewHolder2.f5877v);
                }
                if (z && viewHolder.getOnItemViewSelectedListener() != null) {
                    viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder2.f5876u, viewHolder2.f5877v, viewHolder, viewHolder.f6112d);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f5890h != null) {
            viewHolder.f5906q.unselect();
        }
        if (z && viewHolder.getOnItemViewSelectedListener() != null) {
            viewHolder.getOnItemViewSelectedListener().onItemSelected(null, null, viewHolder, viewHolder.f6112d);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (f5884r == 0) {
            f5884r = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_selected_row_top_padding);
            f5885s = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_expanded_selected_row_top_padding);
            f5886t = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_expanded_row_no_hovercard_bottom_padding);
        }
        ListRowView listRowView = new ListRowView(viewGroup.getContext());
        HorizontalGridView gridView = listRowView.getGridView();
        if (this.f5894l < 0) {
            TypedArray obtainStyledAttributes = gridView.getContext().obtainStyledAttributes(androidx.leanback.R.styleable.LeanbackTheme);
            this.f5894l = (int) obtainStyledAttributes.getDimension(androidx.leanback.R.styleable.LeanbackTheme_browseRowsFadingEdgeLength, RecyclerView.f7068F0);
            obtainStyledAttributes.recycle();
        }
        gridView.setFadingLeftEdgeLength(this.f5894l);
        if (this.f5888f != 0) {
            listRowView.getGridView().setRowHeight(this.f5888f);
        }
        return new ViewHolder(listRowView, listRowView.getGridView(), this);
    }

    public ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    /* renamed from: d */
    public final void m1448d(ViewHolder viewHolder) {
        int i;
        boolean isExpanded = viewHolder.isExpanded();
        int i2 = 0;
        int i3 = viewHolder.f5908s;
        if (isExpanded) {
            RowHeaderPresenter.ViewHolder headerViewHolder = viewHolder.getHeaderViewHolder();
            if (headerViewHolder != null) {
                if (getHeaderPresenter() != null) {
                    i2 = getHeaderPresenter().getSpaceUnderBaseline(headerViewHolder);
                } else {
                    i2 = headerViewHolder.view.getPaddingBottom();
                }
            }
            if (viewHolder.isSelected()) {
                i = f5885s;
            } else {
                i = viewHolder.f5907r;
            }
            i2 = i - i2;
            if (this.f5890h == null) {
                i3 = f5886t;
            }
        } else if (viewHolder.isSelected()) {
            int i4 = f5884r;
            i2 = i4 - i3;
            i3 = i4;
        }
        viewHolder.getGridView().setPadding(viewHolder.f5909t, i2, viewHolder.f5910u, i3);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void dispatchItemSelectedListener(RowPresenter.ViewHolder viewHolder, boolean z) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        HorizontalGridView horizontalGridView = viewHolder2.f5904o;
        ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
        if (viewHolder3 == null) {
            super.dispatchItemSelectedListener(viewHolder, z);
        } else if (z && viewHolder.getOnItemViewSelectedListener() != null) {
            viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder3.getViewHolder(), viewHolder3.f5877v, viewHolder2, viewHolder2.getRow());
        }
    }

    /* renamed from: e */
    public final void m1449e(ViewHolder viewHolder) {
        View view;
        boolean z = viewHolder.f6116h;
        HorizontalHoverCardSwitcher horizontalHoverCardSwitcher = viewHolder.f5906q;
        if (z && viewHolder.f6115g) {
            PresenterSelector presenterSelector = this.f5890h;
            if (presenterSelector != null) {
                horizontalHoverCardSwitcher.init((ViewGroup) viewHolder.view, presenterSelector);
            }
            HorizontalGridView horizontalGridView = viewHolder.f5904o;
            ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
            if (viewHolder2 == null) {
                view = null;
            } else {
                view = viewHolder2.itemView;
            }
            m1447c(viewHolder, view, false);
            return;
        }
        if (this.f5890h != null) {
            horizontalHoverCardSwitcher.unselect();
        }
    }

    public final void enableChildRoundedCorners(boolean z) {
        this.f5895m = z;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void freeze(@NonNull RowPresenter.ViewHolder viewHolder, boolean z) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f5904o.setScrollEnabled(!z);
        viewHolder2.f5904o.setAnimateChildLayout(!z);
    }

    public int getExpandedRowHeight() {
        int i = this.f5889g;
        if (i == 0) {
            return this.f5888f;
        }
        return i;
    }

    public final int getFocusZoomFactor() {
        return this.f5891i;
    }

    public final PresenterSelector getHoverCardPresenterSelector() {
        return this.f5890h;
    }

    public int getRecycledPoolSize(Presenter presenter) {
        HashMap hashMap = this.f5897o;
        if (hashMap.containsKey(presenter)) {
            return ((Integer) hashMap.get(presenter)).intValue();
        }
        return 24;
    }

    public int getRowHeight() {
        return this.f5888f;
    }

    public final boolean getShadowEnabled() {
        return this.f5893k;
    }

    @Deprecated
    public final int getZoomFactor() {
        return this.f5891i;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void initializeRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        boolean z;
        boolean z2;
        boolean z3;
        super.initializeRowViewHolder(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Context context = viewHolder.view.getContext();
        boolean z4 = false;
        if (this.f5898p == null) {
            ShadowOverlayHelper.Builder builder = new ShadowOverlayHelper.Builder();
            if (isUsingDefaultListSelectEffect() && getSelectEffectEnabled()) {
                z = true;
            } else {
                z = false;
            }
            ShadowOverlayHelper.Builder needsOverlay = builder.needsOverlay(z);
            if (isUsingDefaultShadow() && getShadowEnabled()) {
                z2 = true;
            } else {
                z2 = false;
            }
            ShadowOverlayHelper.Builder needsShadow = needsOverlay.needsShadow(z2);
            if (isUsingOutlineClipping(context) && areChildRoundedCornersEnabled()) {
                z3 = true;
            } else {
                z3 = false;
            }
            ShadowOverlayHelper build = needsShadow.needsRoundedCorner(z3).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.f5896n).options(createShadowOverlayOptions()).build(context);
            this.f5898p = build;
            if (build.needsWrapper()) {
                this.f5899q = new ItemBridgeAdapterShadowOverlayWrapper(this.f5898p);
            }
        }
        C0358l1 c0358l1 = new C0358l1(this, viewHolder2);
        viewHolder2.f5905p = c0358l1;
        c0358l1.setWrapper(this.f5899q);
        ShadowOverlayHelper shadowOverlayHelper = this.f5898p;
        HorizontalGridView horizontalGridView = viewHolder2.f5904o;
        shadowOverlayHelper.prepareParentForShadow(horizontalGridView);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder2.f5905p, this.f5891i, this.f5892j);
        if (this.f5898p.getShadowType() != 3) {
            z4 = true;
        }
        horizontalGridView.setFocusDrawingOrderEnabled(z4);
        horizontalGridView.setOnChildSelectedListener(new C0346i1(this, viewHolder2));
        horizontalGridView.setOnUnhandledKeyListener(new C0350j1(viewHolder2));
        horizontalGridView.setNumRows(this.f5887e);
    }

    public final boolean isFocusDimmerUsed() {
        return this.f5892j;
    }

    public final boolean isKeepChildForeground() {
        return this.f5896n;
    }

    public boolean isUsingDefaultListSelectEffect() {
        return true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public boolean isUsingOutlineClipping(Context context) {
        return !Settings.getInstance(context).isOutlineClippingDisabled();
    }

    public boolean isUsingZOrder(Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ListRow listRow = (ListRow) obj;
        viewHolder2.f5905p.setAdapter(listRow.getAdapter());
        C0358l1 c0358l1 = viewHolder2.f5905p;
        HorizontalGridView horizontalGridView = viewHolder2.f5904o;
        horizontalGridView.setAdapter(c0358l1);
        horizontalGridView.setContentDescription(listRow.getContentDescription());
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewExpanded(RowPresenter.ViewHolder viewHolder, boolean z) {
        int rowHeight;
        super.onRowViewExpanded(viewHolder, z);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (getRowHeight() != getExpandedRowHeight()) {
            if (z) {
                rowHeight = getExpandedRowHeight();
            } else {
                rowHeight = getRowHeight();
            }
            viewHolder2.getGridView().setRowHeight(rowHeight);
        }
        m1448d(viewHolder2);
        m1449e(viewHolder2);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z) {
        super.onRowViewSelected(viewHolder, z);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        m1448d(viewHolder2);
        m1449e(viewHolder2);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int childCount = viewHolder2.f5904o.getChildCount();
        for (int i = 0; i < childCount; i++) {
            applySelectLevelToChild(viewHolder2, viewHolder2.f5904o.getChildAt(i));
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f5904o.setAdapter(null);
        viewHolder2.f5905p.clear();
        super.onUnbindRowViewHolder(viewHolder);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void setEntranceTransitionState(@NonNull RowPresenter.ViewHolder viewHolder, boolean z) {
        int i;
        super.setEntranceTransitionState(viewHolder, z);
        HorizontalGridView horizontalGridView = ((ViewHolder) viewHolder).f5904o;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        horizontalGridView.setChildrenVisibility(i);
    }

    public void setExpandedRowHeight(int i) {
        this.f5889g = i;
    }

    public final void setHoverCardPresenterSelector(PresenterSelector presenterSelector) {
        this.f5890h = presenterSelector;
    }

    public final void setKeepChildForeground(boolean z) {
        this.f5896n = z;
    }

    public void setNumRows(int i) {
        this.f5887e = i;
    }

    public void setRecycledPoolSize(Presenter presenter, int i) {
        this.f5897o.put(presenter, Integer.valueOf(i));
    }

    public void setRowHeight(int i) {
        this.f5888f = i;
    }

    public final void setShadowEnabled(boolean z) {
        this.f5893k = z;
    }

    public ListRowPresenter(int i) {
        this(i, false);
    }

    public ListRowPresenter(int i, boolean z) {
        int i2;
        boolean z2 = true;
        this.f5887e = 1;
        this.f5893k = true;
        this.f5894l = -1;
        this.f5895m = true;
        this.f5896n = true;
        this.f5897o = new HashMap();
        if (i != 0) {
            if (i == 1) {
                i2 = androidx.leanback.R.fraction.lb_focus_zoom_factor_small;
            } else if (i == 2) {
                i2 = androidx.leanback.R.fraction.lb_focus_zoom_factor_medium;
            } else if (i != 3) {
                i2 = i != 4 ? 0 : androidx.leanback.R.fraction.lb_focus_zoom_factor_xsmall;
            } else {
                i2 = androidx.leanback.R.fraction.lb_focus_zoom_factor_large;
            }
            if (i2 <= 0) {
                z2 = false;
            }
        }
        if (z2) {
            this.f5891i = i;
            this.f5892j = z;
            return;
        }
        throw new IllegalArgumentException("Unhandled zoom factor");
    }
}
