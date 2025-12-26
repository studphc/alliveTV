package androidx.leanback.widget;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.recyclerview.widget.RecyclerView;
import p000.tc2;

/* loaded from: classes.dex */
public class FullWidthDetailsOverviewRowPresenter extends RowPresenter {
    public static final int ALIGN_MODE_MIDDLE = 1;
    public static final int ALIGN_MODE_START = 0;
    public static final int STATE_FULL = 1;
    public static final int STATE_HALF = 0;
    public static final int STATE_SMALL = 2;

    /* renamed from: o */
    public static final Handler f5644o = new Handler();

    /* renamed from: e */
    public final Presenter f5645e;

    /* renamed from: f */
    public final DetailsOverviewLogoPresenter f5646f;

    /* renamed from: g */
    public OnActionClickedListener f5647g;

    /* renamed from: h */
    public int f5648h;

    /* renamed from: i */
    public int f5649i;

    /* renamed from: j */
    public boolean f5650j;

    /* renamed from: k */
    public boolean f5651k;

    /* renamed from: l */
    public Listener f5652l;

    /* renamed from: m */
    public boolean f5653m;
    protected int mInitialState;

    /* renamed from: n */
    public int f5654n;

    /* loaded from: classes.dex */
    public static abstract class Listener {
        public void onBindLogo(ViewHolder viewHolder) {
        }
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RowPresenter.ViewHolder {
        protected final DetailsOverviewRow.Listener mRowListener;

        /* renamed from: n */
        public final FrameLayout f5655n;

        /* renamed from: o */
        public final ViewGroup f5656o;

        /* renamed from: p */
        public final HorizontalGridView f5657p;

        /* renamed from: q */
        public final Presenter.ViewHolder f5658q;

        /* renamed from: r */
        public final DetailsOverviewLogoPresenter.ViewHolder f5659r;

        /* renamed from: s */
        public int f5660s;

        /* renamed from: t */
        public C0349j0 f5661t;

        /* renamed from: u */
        public int f5662u;

        /* renamed from: v */
        public final RunnableC0353k0 f5663v;

        /* renamed from: w */
        public final ViewOnLayoutChangeListenerC0357l0 f5664w;

        /* loaded from: classes.dex */
        public class DetailsOverviewRowListener extends DetailsOverviewRow.Listener {
            public DetailsOverviewRowListener() {
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onActionsAdapterChanged(@NonNull DetailsOverviewRow detailsOverviewRow) {
                ObjectAdapter actionsAdapter = detailsOverviewRow.getActionsAdapter();
                ViewHolder viewHolder = ViewHolder.this;
                viewHolder.f5661t.setAdapter(actionsAdapter);
                viewHolder.f5657p.setAdapter(viewHolder.f5661t);
                viewHolder.f5660s = viewHolder.f5661t.getItemCount();
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onImageDrawableChanged(@NonNull DetailsOverviewRow detailsOverviewRow) {
                Handler handler = FullWidthDetailsOverviewRowPresenter.f5644o;
                ViewHolder viewHolder = ViewHolder.this;
                handler.removeCallbacks(viewHolder.f5663v);
                handler.post(viewHolder.f5663v);
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onItemChanged(@NonNull DetailsOverviewRow detailsOverviewRow) {
                ViewHolder viewHolder = ViewHolder.this;
                Presenter.ViewHolder viewHolder2 = viewHolder.f5658q;
                if (viewHolder2 != null) {
                    FullWidthDetailsOverviewRowPresenter.this.f5645e.onUnbindViewHolder(viewHolder2);
                }
                FullWidthDetailsOverviewRowPresenter.this.f5645e.onBindViewHolder(viewHolder.f5658q, detailsOverviewRow.getItem());
            }
        }

        public ViewHolder(View view, Presenter presenter, DetailsOverviewLogoPresenter detailsOverviewLogoPresenter) {
            super(view);
            this.mRowListener = createRowListener();
            this.f5662u = 0;
            this.f5663v = new RunnableC0353k0(this);
            this.f5664w = new ViewOnLayoutChangeListenerC0357l0(this);
            C0361m0 c0361m0 = new C0361m0(this);
            C0365n0 c0365n0 = new C0365n0(this);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_root);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(androidx.leanback.R.id.details_frame);
            this.f5655n = frameLayout;
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview_description);
            this.f5656o = viewGroup2;
            HorizontalGridView horizontalGridView = (HorizontalGridView) frameLayout.findViewById(androidx.leanback.R.id.details_overview_actions);
            this.f5657p = horizontalGridView;
            horizontalGridView.setHasOverlappingRendering(false);
            horizontalGridView.setOnScrollListener(c0365n0);
            horizontalGridView.setAdapter(this.f5661t);
            horizontalGridView.setOnChildSelectedListener(c0361m0);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_actions_fade_size);
            horizontalGridView.setFadingRightEdgeLength(dimensionPixelSize);
            horizontalGridView.setFadingLeftEdgeLength(dimensionPixelSize);
            Presenter.ViewHolder onCreateViewHolder = presenter.onCreateViewHolder(viewGroup2);
            this.f5658q = onCreateViewHolder;
            viewGroup2.addView(onCreateViewHolder.view);
            DetailsOverviewLogoPresenter.ViewHolder viewHolder = (DetailsOverviewLogoPresenter.ViewHolder) detailsOverviewLogoPresenter.onCreateViewHolder(viewGroup);
            this.f5659r = viewHolder;
            viewGroup.addView(viewHolder.view);
        }

        /* renamed from: a */
        public final void m1393a() {
            int i = this.f5660s - 1;
            HorizontalGridView horizontalGridView = this.f5657p;
            RecyclerView.ViewHolder findViewHolderForPosition = horizontalGridView.findViewHolderForPosition(i);
            if (findViewHolderForPosition != null) {
                findViewHolderForPosition.itemView.getRight();
                horizontalGridView.getWidth();
            }
            RecyclerView.ViewHolder findViewHolderForPosition2 = horizontalGridView.findViewHolderForPosition(0);
            if (findViewHolderForPosition2 != null) {
                findViewHolderForPosition2.itemView.getLeft();
            }
        }

        public DetailsOverviewRow.Listener createRowListener() {
            return new DetailsOverviewRowListener();
        }

        public final ViewGroup getActionsRow() {
            return this.f5657p;
        }

        public final ViewGroup getDetailsDescriptionFrame() {
            return this.f5656o;
        }

        public final Presenter.ViewHolder getDetailsDescriptionViewHolder() {
            return this.f5658q;
        }

        public final DetailsOverviewLogoPresenter.ViewHolder getLogoViewHolder() {
            return this.f5659r;
        }

        public final ViewGroup getOverviewView() {
            return this.f5655n;
        }

        public final int getState() {
            return this.f5662u;
        }
    }

    public FullWidthDetailsOverviewRowPresenter(Presenter presenter) {
        this(presenter, new DetailsOverviewLogoPresenter());
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false);
        Presenter presenter = this.f5645e;
        DetailsOverviewLogoPresenter detailsOverviewLogoPresenter = this.f5646f;
        ViewHolder viewHolder = new ViewHolder(inflate, presenter, detailsOverviewLogoPresenter);
        detailsOverviewLogoPresenter.setContext(viewHolder.f5659r, viewHolder, this);
        setState(viewHolder, this.mInitialState);
        viewHolder.f5661t = new C0349j0(this, viewHolder);
        boolean z = this.f5650j;
        FrameLayout frameLayout = viewHolder.f5655n;
        if (z) {
            frameLayout.setBackgroundColor(this.f5648h);
        }
        if (this.f5651k) {
            frameLayout.findViewById(androidx.leanback.R.id.details_overview_actions_background).setBackgroundColor(this.f5649i);
        }
        tc2.m7490a(frameLayout, true);
        if (!getSelectEffectEnabled()) {
            frameLayout.setForeground(null);
        }
        viewHolder.f5657p.setOnUnhandledKeyListener(new C0341h0(viewHolder));
        return viewHolder;
    }

    public final int getActionsBackgroundColor() {
        return this.f5649i;
    }

    public final int getAlignmentMode() {
        return this.f5654n;
    }

    public final int getBackgroundColor() {
        return this.f5648h;
    }

    public final int getInitialState() {
        return this.mInitialState;
    }

    public int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_fullwidth_details_overview;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.f5647g;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isClippingChildren() {
        return true;
    }

    public final boolean isParticipatingEntranceTransition() {
        return this.f5653m;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public final void notifyOnBindLogo(ViewHolder viewHolder) {
        onLayoutOverviewFrame(viewHolder, viewHolder.getState(), true);
        onLayoutLogo(viewHolder, viewHolder.getState(), true);
        Listener listener = this.f5652l;
        if (listener != null) {
            listener.onBindLogo(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        this.f5646f.onBindViewHolder(viewHolder2.f5659r, detailsOverviewRow);
        this.f5645e.onBindViewHolder(viewHolder2.f5658q, detailsOverviewRow.getItem());
        DetailsOverviewRow detailsOverviewRow2 = (DetailsOverviewRow) viewHolder2.getRow();
        viewHolder2.f5661t.setAdapter(detailsOverviewRow2.getActionsAdapter());
        viewHolder2.f5657p.setAdapter(viewHolder2.f5661t);
        viewHolder2.f5660s = viewHolder2.f5661t.getItemCount();
        detailsOverviewRow2.m1385a(viewHolder2.mRowListener);
    }

    public void onLayoutLogo(ViewHolder viewHolder, int i, boolean z) {
        View view = viewHolder.getLogoViewHolder().view;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (this.f5654n != 1) {
            marginLayoutParams.setMarginStart(view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_logo_margin_start));
        } else {
            marginLayoutParams.setMarginStart(view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_left) - marginLayoutParams.width);
        }
        int state = viewHolder.getState();
        if (state != 0) {
            if (state != 2) {
                marginLayoutParams.topMargin = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_blank_height) - (marginLayoutParams.height / 2);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        } else {
            marginLayoutParams.topMargin = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_description_margin_top) + view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_actions_height) + view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_blank_height);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public void onLayoutOverviewFrame(ViewHolder viewHolder, int i, boolean z) {
        boolean z2;
        boolean z3;
        int i2;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i3 = 0;
        if (i == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (viewHolder.getState() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 != z3 || z) {
            Resources resources = viewHolder.view.getResources();
            if (this.f5646f.isBoundToImage(viewHolder.getLogoViewHolder(), (DetailsOverviewRow) viewHolder.getRow())) {
                i2 = viewHolder.getLogoViewHolder().view.getLayoutParams().width;
            } else {
                i2 = 0;
            }
            if (this.f5654n != 1) {
                if (z3) {
                    dimensionPixelSize = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_logo_margin_start);
                } else {
                    i2 += resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_logo_margin_start);
                    dimensionPixelSize = 0;
                }
            } else if (z3) {
                dimensionPixelSize = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_left) - i2;
            } else {
                i2 = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_left);
                dimensionPixelSize = 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.getOverviewView().getLayoutParams();
            if (z3) {
                dimensionPixelSize2 = 0;
            } else {
                dimensionPixelSize2 = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_blank_height);
            }
            marginLayoutParams.topMargin = dimensionPixelSize2;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = dimensionPixelSize;
            viewHolder.getOverviewView().setLayoutParams(marginLayoutParams);
            ViewGroup detailsDescriptionFrame = viewHolder.getDetailsDescriptionFrame();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) detailsDescriptionFrame.getLayoutParams();
            marginLayoutParams2.setMarginStart(i2);
            detailsDescriptionFrame.setLayoutParams(marginLayoutParams2);
            ViewGroup actionsRow = viewHolder.getActionsRow();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) actionsRow.getLayoutParams();
            marginLayoutParams3.setMarginStart(i2);
            if (!z3) {
                i3 = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_actions_height);
            }
            marginLayoutParams3.height = i3;
            actionsRow.setLayoutParams(marginLayoutParams3);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewAttachedToWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        this.f5645e.onViewAttachedToWindow(viewHolder2.f5658q);
        this.f5646f.onViewAttachedToWindow(viewHolder2.f5659r);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewDetachedFromWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        this.f5645e.onViewDetachedFromWindow(viewHolder2.f5658q);
        this.f5646f.onViewDetachedFromWindow(viewHolder2.f5659r);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        if (getSelectEffectEnabled()) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            ((ColorDrawable) viewHolder2.f5655n.getForeground().mutate()).setColor(viewHolder2.mColorDimmer.getPaint().getColor());
        }
    }

    public void onStateChanged(ViewHolder viewHolder, int i) {
        onLayoutOverviewFrame(viewHolder, i, false);
        onLayoutLogo(viewHolder, i, false);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f5661t.setAdapter(null);
        viewHolder2.f5657p.setAdapter(null);
        viewHolder2.f5660s = 0;
        ((DetailsOverviewRow) viewHolder2.getRow()).m1387c(viewHolder2.mRowListener);
        f5644o.removeCallbacks(viewHolder2.f5663v);
        this.f5645e.onUnbindViewHolder(viewHolder2.f5658q);
        this.f5646f.onUnbindViewHolder(viewHolder2.f5659r);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public final void setActionsBackgroundColor(int i) {
        this.f5649i = i;
        this.f5651k = true;
    }

    public final void setAlignmentMode(int i) {
        this.f5654n = i;
    }

    public final void setBackgroundColor(int i) {
        this.f5648h = i;
        this.f5650j = true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void setEntranceTransitionState(@NonNull RowPresenter.ViewHolder viewHolder, boolean z) {
        int i;
        super.setEntranceTransitionState(viewHolder, z);
        if (this.f5653m) {
            View view = viewHolder.view;
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    public final void setInitialState(int i) {
        this.mInitialState = i;
    }

    public final void setListener(Listener listener) {
        this.f5652l = listener;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.f5647g = onActionClickedListener;
    }

    public final void setParticipatingEntranceTransition(boolean z) {
        this.f5653m = z;
    }

    public final void setState(ViewHolder viewHolder, int i) {
        if (viewHolder.getState() != i) {
            int state = viewHolder.getState();
            viewHolder.f5662u = i;
            onStateChanged(viewHolder, state);
        }
    }

    public FullWidthDetailsOverviewRowPresenter(Presenter presenter, DetailsOverviewLogoPresenter detailsOverviewLogoPresenter) {
        this.mInitialState = 0;
        this.f5648h = 0;
        this.f5649i = 0;
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        this.f5645e = presenter;
        this.f5646f = detailsOverviewLogoPresenter;
    }
}
