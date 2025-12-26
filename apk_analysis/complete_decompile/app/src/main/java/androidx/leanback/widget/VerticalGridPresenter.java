package androidx.leanback.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.system.Settings;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.ShadowOverlayHelper;

/* loaded from: classes.dex */
public class VerticalGridPresenter extends Presenter {

    /* renamed from: b */
    public int f6249b;

    /* renamed from: c */
    public final int f6250c;

    /* renamed from: d */
    public final boolean f6251d;

    /* renamed from: e */
    public boolean f6252e;

    /* renamed from: f */
    public boolean f6253f;

    /* renamed from: g */
    public OnItemViewSelectedListener f6254g;

    /* renamed from: h */
    public OnItemViewClickedListener f6255h;

    /* renamed from: i */
    public boolean f6256i;

    /* renamed from: j */
    public ShadowOverlayHelper f6257j;

    /* renamed from: k */
    public ItemBridgeAdapterShadowOverlayWrapper f6258k;

    /* loaded from: classes.dex */
    public static class ViewHolder extends Presenter.ViewHolder {

        /* renamed from: b */
        public C0315a3 f6259b;

        /* renamed from: c */
        public final VerticalGridView f6260c;

        /* renamed from: d */
        public boolean f6261d;

        public ViewHolder(@NonNull VerticalGridView verticalGridView) {
            super(verticalGridView);
            this.f6260c = verticalGridView;
        }

        @NonNull
        public VerticalGridView getGridView() {
            return this.f6260c;
        }
    }

    public VerticalGridPresenter() {
        this(3);
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.f6256i;
    }

    @NonNull
    public ViewHolder createGridViewHolder(@NonNull ViewGroup viewGroup) {
        return new ViewHolder((VerticalGridView) LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_vertical_grid, viewGroup, false).findViewById(androidx.leanback.R.id.browse_grid));
    }

    @NonNull
    public ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    public final void enableChildRoundedCorners(boolean z) {
        this.f6256i = z;
    }

    public final int getFocusZoomFactor() {
        return this.f6250c;
    }

    public final boolean getKeepChildForeground() {
        return this.f6253f;
    }

    public int getNumberOfColumns() {
        return this.f6249b;
    }

    @Nullable
    public final OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f6255h;
    }

    @Nullable
    public final OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.f6254g;
    }

    public final boolean getShadowEnabled() {
        return this.f6252e;
    }

    public void initializeGridViewHolder(@NonNull ViewHolder viewHolder) {
        boolean z;
        if (this.f6249b != -1) {
            viewHolder.getGridView().setNumColumns(this.f6249b);
            boolean z2 = true;
            viewHolder.f6261d = true;
            VerticalGridView verticalGridView = viewHolder.f6260c;
            Context context = verticalGridView.getContext();
            ShadowOverlayHelper shadowOverlayHelper = this.f6257j;
            boolean z3 = this.f6251d;
            if (shadowOverlayHelper == null) {
                ShadowOverlayHelper.Builder needsOverlay = new ShadowOverlayHelper.Builder().needsOverlay(z3);
                if (isUsingDefaultShadow() && getShadowEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                ShadowOverlayHelper build = needsOverlay.needsShadow(z).needsRoundedCorner(areChildRoundedCornersEnabled()).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.f6253f).options(createShadowOverlayOptions()).build(context);
                this.f6257j = build;
                if (build.needsWrapper()) {
                    this.f6258k = new ItemBridgeAdapterShadowOverlayWrapper(this.f6257j);
                }
            }
            viewHolder.f6259b.setWrapper(this.f6258k);
            this.f6257j.prepareParentForShadow(verticalGridView);
            VerticalGridView gridView = viewHolder.getGridView();
            if (this.f6257j.getShadowType() == 3) {
                z2 = false;
            }
            gridView.setFocusDrawingOrderEnabled(z2);
            FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder.f6259b, this.f6250c, z3);
            viewHolder.getGridView().setOnChildSelectedListener(new C0410y2(this, viewHolder));
            return;
        }
        throw new IllegalStateException("Number of columns must be set");
    }

    public final boolean isFocusDimmerUsed() {
        return this.f6251d;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public boolean isUsingZOrder(@NonNull Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f6259b.setAdapter((ObjectAdapter) obj);
        viewHolder2.getGridView().setAdapter(viewHolder2.f6259b);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f6259b.setAdapter(null);
        viewHolder2.getGridView().setAdapter(null);
    }

    public void setEntranceTransitionState(@NonNull ViewHolder viewHolder, boolean z) {
        int i;
        VerticalGridView verticalGridView = viewHolder.f6260c;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        verticalGridView.setChildrenVisibility(i);
    }

    public final void setKeepChildForeground(boolean z) {
        this.f6253f = z;
    }

    public void setNumberOfColumns(int i) {
        if (i >= 0) {
            if (this.f6249b != i) {
                this.f6249b = i;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid number of columns");
    }

    public final void setOnItemViewClickedListener(@Nullable OnItemViewClickedListener onItemViewClickedListener) {
        this.f6255h = onItemViewClickedListener;
    }

    public final void setOnItemViewSelectedListener(@Nullable OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f6254g = onItemViewSelectedListener;
    }

    public final void setShadowEnabled(boolean z) {
        this.f6252e = z;
    }

    public VerticalGridPresenter(int i) {
        this(i, true);
    }

    @Override // androidx.leanback.widget.Presenter
    @NonNull
    public final ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        ViewHolder createGridViewHolder = createGridViewHolder(viewGroup);
        createGridViewHolder.f6261d = false;
        createGridViewHolder.f6259b = new C0315a3(this);
        initializeGridViewHolder(createGridViewHolder);
        if (createGridViewHolder.f6261d) {
            return createGridViewHolder;
        }
        throw new RuntimeException("super.initializeGridViewHolder() must be called");
    }

    public VerticalGridPresenter(int i, boolean z) {
        this.f6249b = -1;
        this.f6252e = true;
        this.f6253f = true;
        this.f6256i = true;
        this.f6250c = i;
        this.f6251d = z;
    }
}
