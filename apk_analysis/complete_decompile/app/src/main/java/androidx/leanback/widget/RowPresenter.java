package androidx.leanback.widget;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.graphics.ColorOverlayDimmer;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class RowPresenter extends Presenter {
    public static final int SYNC_ACTIVATED_CUSTOM = 0;
    public static final int SYNC_ACTIVATED_TO_EXPANDED = 1;
    public static final int SYNC_ACTIVATED_TO_EXPANDED_AND_SELECTED = 3;
    public static final int SYNC_ACTIVATED_TO_SELECTED = 2;

    /* renamed from: b */
    public RowHeaderPresenter f6107b;

    /* renamed from: c */
    public boolean f6108c;

    /* renamed from: d */
    public int f6109d;

    /* loaded from: classes.dex */
    public static class ViewHolder extends Presenter.ViewHolder {

        /* renamed from: b */
        public C0375p2 f6110b;

        /* renamed from: c */
        public RowHeaderPresenter.ViewHolder f6111c;

        /* renamed from: d */
        public Row f6112d;

        /* renamed from: e */
        public Object f6113e;

        /* renamed from: f */
        public int f6114f;

        /* renamed from: g */
        public boolean f6115g;

        /* renamed from: h */
        public boolean f6116h;

        /* renamed from: i */
        public boolean f6117i;

        /* renamed from: j */
        public float f6118j;

        /* renamed from: k */
        public View.OnKeyListener f6119k;

        /* renamed from: l */
        public BaseOnItemViewSelectedListener f6120l;

        /* renamed from: m */
        public BaseOnItemViewClickedListener f6121m;
        protected final ColorOverlayDimmer mColorDimmer;

        public ViewHolder(View view) {
            super(view);
            this.f6114f = 0;
            this.f6118j = RecyclerView.f7068F0;
            this.mColorDimmer = ColorOverlayDimmer.createDefault(view.getContext());
        }

        public final RowHeaderPresenter.ViewHolder getHeaderViewHolder() {
            return this.f6111c;
        }

        public final BaseOnItemViewClickedListener getOnItemViewClickedListener() {
            return this.f6121m;
        }

        public final BaseOnItemViewSelectedListener getOnItemViewSelectedListener() {
            return this.f6120l;
        }

        public View.OnKeyListener getOnKeyListener() {
            return this.f6119k;
        }

        public final Row getRow() {
            return this.f6112d;
        }

        public final Object getRowObject() {
            return this.f6113e;
        }

        public final float getSelectLevel() {
            return this.f6118j;
        }

        @Nullable
        public Object getSelectedItem() {
            return null;
        }

        @Nullable
        public Presenter.ViewHolder getSelectedItemViewHolder() {
            return null;
        }

        public final boolean isExpanded() {
            return this.f6116h;
        }

        public final boolean isSelected() {
            return this.f6115g;
        }

        public final void setActivated(boolean z) {
            int i;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            this.f6114f = i;
        }

        public final void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
            this.f6121m = baseOnItemViewClickedListener;
        }

        public final void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
            this.f6120l = baseOnItemViewSelectedListener;
        }

        public void setOnKeyListener(View.OnKeyListener onKeyListener) {
            this.f6119k = onKeyListener;
        }

        public final void syncActivatedStatus(View view) {
            int i = this.f6114f;
            if (i == 1) {
                view.setActivated(true);
            } else if (i == 2) {
                view.setActivated(false);
            }
        }
    }

    public RowPresenter() {
        RowHeaderPresenter rowHeaderPresenter = new RowHeaderPresenter();
        this.f6107b = rowHeaderPresenter;
        this.f6108c = true;
        this.f6109d = 1;
        rowHeaderPresenter.setNullItemVisibilityGone(true);
    }

    /* renamed from: a */
    public final void m1479a(ViewHolder viewHolder, View view) {
        int i = this.f6109d;
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (!viewHolder.isExpanded() || !viewHolder.isSelected()) {
                        z = false;
                    }
                    viewHolder.setActivated(z);
                }
            } else {
                viewHolder.setActivated(viewHolder.isSelected());
            }
        } else {
            viewHolder.setActivated(viewHolder.isExpanded());
        }
        viewHolder.syncActivatedStatus(view);
    }

    /* renamed from: b */
    public final void m1480b(ViewHolder viewHolder) {
        int i;
        if (this.f6107b != null && viewHolder.f6111c != null) {
            RowContainerView rowContainerView = (RowContainerView) viewHolder.f6110b.view;
            boolean isExpanded = viewHolder.isExpanded();
            rowContainerView.getClass();
            if (isExpanded) {
                i = 0;
            } else {
                i = 8;
            }
            rowContainerView.f6096a.setVisibility(i);
        }
    }

    @NonNull
    public abstract ViewHolder createRowViewHolder(@NonNull ViewGroup viewGroup);

    public void dispatchItemSelectedListener(ViewHolder viewHolder, boolean z) {
        BaseOnItemViewSelectedListener baseOnItemViewSelectedListener;
        if (z && (baseOnItemViewSelectedListener = viewHolder.f6120l) != null) {
            baseOnItemViewSelectedListener.onItemSelected(null, null, viewHolder, viewHolder.getRowObject());
        }
    }

    public void freeze(@NonNull ViewHolder viewHolder, boolean z) {
    }

    public final RowHeaderPresenter getHeaderPresenter() {
        return this.f6107b;
    }

    public final ViewHolder getRowViewHolder(Presenter.ViewHolder viewHolder) {
        if (viewHolder instanceof C0375p2) {
            return ((C0375p2) viewHolder).f6344b;
        }
        return (ViewHolder) viewHolder;
    }

    public final boolean getSelectEffectEnabled() {
        return this.f6108c;
    }

    public final float getSelectLevel(Presenter.ViewHolder viewHolder) {
        return getRowViewHolder(viewHolder).f6118j;
    }

    public final int getSyncActivatePolicy() {
        return this.f6109d;
    }

    public void initializeRowViewHolder(ViewHolder viewHolder) {
        viewHolder.f6117i = true;
        if (!isClippingChildren()) {
            View view = viewHolder.view;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(false);
            }
            C0375p2 c0375p2 = viewHolder.f6110b;
            if (c0375p2 != null) {
                ((ViewGroup) c0375p2.view).setClipChildren(false);
            }
        }
    }

    public boolean isClippingChildren() {
        return false;
    }

    public boolean isUsingDefaultSelectEffect() {
        return true;
    }

    public void onBindRowViewHolder(@NonNull ViewHolder viewHolder, @NonNull Object obj) {
        Row row;
        viewHolder.f6113e = obj;
        if (obj instanceof Row) {
            row = (Row) obj;
        } else {
            row = null;
        }
        viewHolder.f6112d = row;
        if (viewHolder.f6111c != null && viewHolder.getRow() != null) {
            this.f6107b.onBindViewHolder(viewHolder.f6111c, obj);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object obj) {
        onBindRowViewHolder(getRowViewHolder(viewHolder), obj);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Presenter.ViewHolder c0375p2;
        ViewHolder createRowViewHolder = createRowViewHolder(viewGroup);
        createRowViewHolder.f6117i = false;
        if (this.f6107b == null && (!isUsingDefaultSelectEffect() || !getSelectEffectEnabled())) {
            c0375p2 = createRowViewHolder;
        } else {
            RowContainerView rowContainerView = new RowContainerView(viewGroup.getContext(), null, 0);
            RowHeaderPresenter rowHeaderPresenter = this.f6107b;
            if (rowHeaderPresenter != null) {
                createRowViewHolder.f6111c = (RowHeaderPresenter.ViewHolder) rowHeaderPresenter.onCreateViewHolder((ViewGroup) createRowViewHolder.view);
            }
            c0375p2 = new C0375p2(rowContainerView, createRowViewHolder);
        }
        initializeRowViewHolder(createRowViewHolder);
        if (createRowViewHolder.f6117i) {
            return c0375p2;
        }
        throw new RuntimeException("super.initializeRowViewHolder() must be called");
    }

    public void onRowViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.f6111c;
        if (viewHolder2 != null) {
            this.f6107b.onViewAttachedToWindow(viewHolder2);
        }
    }

    public void onRowViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.f6111c;
        if (viewHolder2 != null) {
            this.f6107b.onViewDetachedFromWindow(viewHolder2);
        }
        Presenter.cancelAnimationsRecursive(viewHolder.view);
    }

    public void onRowViewExpanded(ViewHolder viewHolder, boolean z) {
        m1480b(viewHolder);
        m1479a(viewHolder, viewHolder.view);
    }

    public void onRowViewSelected(@NonNull ViewHolder viewHolder, boolean z) {
        dispatchItemSelectedListener(viewHolder, z);
        m1480b(viewHolder);
        m1479a(viewHolder, viewHolder.view);
    }

    public void onSelectLevelChanged(ViewHolder viewHolder) {
        if (getSelectEffectEnabled()) {
            viewHolder.mColorDimmer.setActiveLevel(viewHolder.f6118j);
            RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.f6111c;
            if (viewHolder2 != null) {
                this.f6107b.setSelectLevel(viewHolder2, viewHolder.f6118j);
            }
            if (isUsingDefaultSelectEffect()) {
                RowContainerView rowContainerView = (RowContainerView) viewHolder.f6110b.view;
                int color = viewHolder.mColorDimmer.getPaint().getColor();
                Drawable drawable = rowContainerView.f6097b;
                if (drawable instanceof ColorDrawable) {
                    ((ColorDrawable) drawable.mutate()).setColor(color);
                    rowContainerView.invalidate();
                } else {
                    rowContainerView.setForeground(new ColorDrawable(color));
                }
            }
        }
    }

    public void onUnbindRowViewHolder(@NonNull ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.f6111c;
        if (viewHolder2 != null) {
            this.f6107b.onUnbindViewHolder(viewHolder2);
        }
        viewHolder.f6112d = null;
        viewHolder.f6113e = null;
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {
        onUnbindRowViewHolder(getRowViewHolder(viewHolder));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onViewAttachedToWindow(@NonNull Presenter.ViewHolder viewHolder) {
        onRowViewAttachedToWindow(getRowViewHolder(viewHolder));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onViewDetachedFromWindow(@NonNull Presenter.ViewHolder viewHolder) {
        onRowViewDetachedFromWindow(getRowViewHolder(viewHolder));
    }

    public void setEntranceTransitionState(@NonNull ViewHolder viewHolder, boolean z) {
        int i;
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.f6111c;
        if (viewHolder2 != null && viewHolder2.view.getVisibility() != 8) {
            View view = viewHolder.f6111c.view;
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    public final void setHeaderPresenter(RowHeaderPresenter rowHeaderPresenter) {
        this.f6107b = rowHeaderPresenter;
    }

    public final void setRowViewExpanded(Presenter.ViewHolder viewHolder, boolean z) {
        ViewHolder rowViewHolder = getRowViewHolder(viewHolder);
        rowViewHolder.f6116h = z;
        onRowViewExpanded(rowViewHolder, z);
    }

    public final void setRowViewSelected(Presenter.ViewHolder viewHolder, boolean z) {
        ViewHolder rowViewHolder = getRowViewHolder(viewHolder);
        rowViewHolder.f6115g = z;
        onRowViewSelected(rowViewHolder, z);
    }

    public final void setSelectEffectEnabled(boolean z) {
        this.f6108c = z;
    }

    public final void setSelectLevel(Presenter.ViewHolder viewHolder, float f) {
        ViewHolder rowViewHolder = getRowViewHolder(viewHolder);
        rowViewHolder.f6118j = f;
        onSelectLevelChanged(rowViewHolder);
    }

    public final void setSyncActivatePolicy(int i) {
        this.f6109d = i;
    }
}
