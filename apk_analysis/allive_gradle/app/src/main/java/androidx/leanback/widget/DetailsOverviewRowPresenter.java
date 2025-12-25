package androidx.leanback.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import p000.d30;
import p000.tc2;

@Deprecated
/* loaded from: classes.dex */
public class DetailsOverviewRowPresenter extends RowPresenter {

    /* renamed from: e */
    public final Presenter f5619e;

    /* renamed from: f */
    public OnActionClickedListener f5620f;

    /* renamed from: h */
    public boolean f5622h;

    /* renamed from: j */
    public C0333f0 f5624j;

    /* renamed from: g */
    public int f5621g = 0;

    /* renamed from: i */
    public boolean f5623i = true;

    /* loaded from: classes.dex */
    public final class ViewHolder extends RowPresenter.ViewHolder {

        /* renamed from: A */
        public final ViewOnLayoutChangeListenerC0411z f5625A;
        public final Presenter.ViewHolder mDetailsDescriptionViewHolder;

        /* renamed from: n */
        public final FrameLayout f5627n;

        /* renamed from: o */
        public final ViewGroup f5628o;

        /* renamed from: p */
        public final ImageView f5629p;

        /* renamed from: q */
        public final ViewGroup f5630q;

        /* renamed from: r */
        public final FrameLayout f5631r;

        /* renamed from: s */
        public final HorizontalGridView f5632s;

        /* renamed from: t */
        public int f5633t;

        /* renamed from: u */
        public boolean f5634u;

        /* renamed from: v */
        public boolean f5635v;

        /* renamed from: w */
        public C0399w f5636w;

        /* renamed from: x */
        public final Handler f5637x;

        /* renamed from: y */
        public final RunnableC0403x f5638y;

        /* renamed from: z */
        public final C0407y f5639z;

        public ViewHolder(View view, Presenter presenter) {
            super(view);
            this.f5637x = new Handler();
            this.f5638y = new RunnableC0403x(this);
            this.f5639z = new C0407y(this);
            this.f5625A = new ViewOnLayoutChangeListenerC0411z(this);
            C0312a0 c0312a0 = new C0312a0(this);
            C0317b0 c0317b0 = new C0317b0(this);
            this.f5627n = (FrameLayout) view.findViewById(androidx.leanback.R.id.details_frame);
            this.f5628o = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview);
            this.f5629p = (ImageView) view.findViewById(androidx.leanback.R.id.details_overview_image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview_right_panel);
            this.f5630q = viewGroup;
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(androidx.leanback.R.id.details_overview_description);
            this.f5631r = frameLayout;
            HorizontalGridView horizontalGridView = (HorizontalGridView) viewGroup.findViewById(androidx.leanback.R.id.details_overview_actions);
            this.f5632s = horizontalGridView;
            horizontalGridView.setHasOverlappingRendering(false);
            horizontalGridView.setOnScrollListener(c0317b0);
            horizontalGridView.setAdapter(this.f5636w);
            horizontalGridView.setOnChildSelectedListener(c0312a0);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_actions_fade_size);
            horizontalGridView.setFadingRightEdgeLength(dimensionPixelSize);
            horizontalGridView.setFadingLeftEdgeLength(dimensionPixelSize);
            Presenter.ViewHolder onCreateViewHolder = presenter.onCreateViewHolder(frameLayout);
            this.mDetailsDescriptionViewHolder = onCreateViewHolder;
            frameLayout.addView(onCreateViewHolder.view);
        }

        /* renamed from: a */
        public final void m1389a(ObjectAdapter objectAdapter) {
            this.f5636w.setAdapter(objectAdapter);
            C0399w c0399w = this.f5636w;
            HorizontalGridView horizontalGridView = this.f5632s;
            horizontalGridView.setAdapter(c0399w);
            this.f5633t = this.f5636w.getItemCount();
            this.f5634u = false;
            this.f5635v = true;
            horizontalGridView.setFadingLeftEdge(false);
            this.f5635v = false;
        }

        /* renamed from: b */
        public final void m1390b() {
            boolean z;
            boolean z2 = true;
            int i = this.f5633t - 1;
            HorizontalGridView horizontalGridView = this.f5632s;
            RecyclerView.ViewHolder findViewHolderForPosition = horizontalGridView.findViewHolderForPosition(i);
            if (findViewHolderForPosition != null && findViewHolderForPosition.itemView.getRight() <= horizontalGridView.getWidth()) {
                z = false;
            } else {
                z = true;
            }
            RecyclerView.ViewHolder findViewHolderForPosition2 = horizontalGridView.findViewHolderForPosition(0);
            if (findViewHolderForPosition2 != null && findViewHolderForPosition2.itemView.getLeft() >= 0) {
                z2 = false;
            }
            if (z != this.f5634u) {
                horizontalGridView.setFadingRightEdge(z);
                this.f5634u = z;
            }
            if (z2 != this.f5635v) {
                horizontalGridView.setFadingLeftEdge(z2);
                this.f5635v = z2;
            }
        }

        /* renamed from: c */
        public final void m1391c(View view) {
            RecyclerView.ViewHolder findViewHolderForPosition;
            if (!isSelected()) {
                return;
            }
            HorizontalGridView horizontalGridView = this.f5632s;
            if (view != null) {
                findViewHolderForPosition = horizontalGridView.getChildViewHolder(view);
            } else {
                findViewHolderForPosition = horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
            }
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) findViewHolderForPosition;
            if (viewHolder == null) {
                if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                }
            } else if (getOnItemViewSelectedListener() != null) {
                getOnItemViewSelectedListener().onItemSelected(viewHolder.getViewHolder(), viewHolder.getItem(), this, getRow());
            }
        }
    }

    public DetailsOverviewRowPresenter(Presenter presenter) {
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        this.f5619e = presenter;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[ADDED_TO_REGION] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1388c(ViewHolder viewHolder) {
        int i;
        int intrinsicWidth;
        int intrinsicHeight;
        boolean z;
        int color;
        int i2;
        C0333f0 c0333f0;
        boolean z2;
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) viewHolder.getRow();
        ImageView imageView = viewHolder.f5629p;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        Context context = imageView.getContext();
        if (this.f5623i) {
            i = androidx.leanback.R.dimen.lb_details_overview_height_large;
        } else {
            i = androidx.leanback.R.dimen.lb_details_overview_height_small;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        int dimensionPixelSize2 = imageView.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_image_margin_vertical);
        int dimensionPixelSize3 = imageView.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_image_margin_horizontal);
        Drawable imageDrawable = detailsOverviewRow.getImageDrawable();
        if (imageDrawable == null) {
            intrinsicWidth = 0;
        } else {
            intrinsicWidth = imageDrawable.getIntrinsicWidth();
        }
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 0;
        }
        Drawable imageDrawable2 = detailsOverviewRow.getImageDrawable();
        if (imageDrawable2 == null) {
            intrinsicHeight = 0;
        } else {
            intrinsicHeight = imageDrawable2.getIntrinsicHeight();
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 0;
        }
        boolean isImageScaleUpAllowed = detailsOverviewRow.isImageScaleUpAllowed();
        if (detailsOverviewRow.getImageDrawable() != null) {
            if (intrinsicWidth > intrinsicHeight) {
                if (this.f5623i) {
                    z2 = true;
                    z = true;
                    if ((z2 && intrinsicWidth > dimensionPixelSize) || (!z2 && intrinsicHeight > dimensionPixelSize)) {
                        isImageScaleUpAllowed = true;
                    }
                    if (!isImageScaleUpAllowed) {
                        z = true;
                    }
                    if (z && !isImageScaleUpAllowed && ((z2 && intrinsicWidth > dimensionPixelSize - dimensionPixelSize3) || (!z2 && intrinsicHeight > dimensionPixelSize - (dimensionPixelSize2 * 2)))) {
                        isImageScaleUpAllowed = true;
                    }
                } else {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            z = false;
            if (z2) {
                isImageScaleUpAllowed = true;
                if (!isImageScaleUpAllowed) {
                }
                if (z) {
                    isImageScaleUpAllowed = true;
                }
            }
            isImageScaleUpAllowed = true;
            if (!isImageScaleUpAllowed) {
            }
            if (z) {
            }
        } else {
            z = false;
        }
        if (this.f5622h) {
            i2 = this.f5621g;
        } else {
            Context context2 = viewHolder.f5628o.getContext();
            TypedValue typedValue = new TypedValue();
            if (context2.getTheme().resolveAttribute(androidx.leanback.R.attr.defaultBrandColor, typedValue, true)) {
                color = context2.getResources().getColor(typedValue.resourceId);
            } else {
                color = context2.getResources().getColor(androidx.leanback.R.color.lb_default_brand_color);
            }
            i2 = color;
        }
        FrameLayout frameLayout = viewHolder.f5627n;
        ViewGroup viewGroup = viewHolder.f5630q;
        if (z) {
            marginLayoutParams.setMarginStart(dimensionPixelSize3);
            marginLayoutParams.bottomMargin = dimensionPixelSize2;
            marginLayoutParams.topMargin = dimensionPixelSize2;
            frameLayout.setBackgroundColor(i2);
            viewGroup.setBackground(null);
            imageView.setBackground(null);
        } else {
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            viewGroup.setBackgroundColor(i2);
            imageView.setBackgroundColor(i2);
            frameLayout.setBackground(null);
        }
        tc2.m7490a(frameLayout, true);
        if (isImageScaleUpAllowed) {
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxWidth(dimensionPixelSize);
            marginLayoutParams.height = -1;
            marginLayoutParams.width = -2;
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setAdjustViewBounds(false);
            marginLayoutParams.height = -2;
            marginLayoutParams.width = Math.min(dimensionPixelSize, intrinsicWidth);
        }
        imageView.setLayoutParams(marginLayoutParams);
        imageView.setImageDrawable(detailsOverviewRow.getImageDrawable());
        if (detailsOverviewRow.getImageDrawable() != null && (c0333f0 = this.f5624j) != null) {
            ViewHolder viewHolder2 = (ViewHolder) c0333f0.f6288b.get();
            if (viewHolder2 != null) {
                ViewCompat.setTransitionName(viewHolder2.f5627n, null);
            }
            c0333f0.f6288b = new WeakReference(viewHolder);
            viewGroup.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0321c0(c0333f0));
            viewGroup.postOnAnimation(new RunnableC0329e0(c0333f0));
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        int i;
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_details_overview, viewGroup, false), this.f5619e);
        viewHolder.f5636w = new C0399w(this, viewHolder);
        FrameLayout frameLayout = viewHolder.f5627n;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Context context = frameLayout.getContext();
        if (this.f5623i) {
            i = androidx.leanback.R.dimen.lb_details_overview_height_large;
        } else {
            i = androidx.leanback.R.dimen.lb_details_overview_height_small;
        }
        layoutParams.height = context.getResources().getDimensionPixelSize(i);
        frameLayout.setLayoutParams(layoutParams);
        if (!getSelectEffectEnabled()) {
            frameLayout.setForeground(null);
        }
        viewHolder.f5632s.setOnUnhandledKeyListener(new C0391u(viewHolder));
        return viewHolder;
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.f5621g;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.f5620f;
    }

    public boolean isStyleLarge() {
        return this.f5623i;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        m1388c(viewHolder2);
        this.f5619e.onBindViewHolder(viewHolder2.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
        viewHolder2.m1389a(detailsOverviewRow.getActionsAdapter());
        detailsOverviewRow.m1385a(viewHolder2.f5639z);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewAttachedToWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.f5619e;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDetailsDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewDetachedFromWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.f5619e;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDetailsDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z) {
        super.onRowViewSelected(viewHolder, z);
        if (z) {
            ((ViewHolder) viewHolder).m1391c(null);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        if (getSelectEffectEnabled()) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            ((ColorDrawable) viewHolder2.f5627n.getForeground().mutate()).setColor(viewHolder2.mColorDimmer.getPaint().getColor());
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ((DetailsOverviewRow) viewHolder2.getRow()).m1387c(viewHolder2.f5639z);
        Presenter.ViewHolder viewHolder3 = viewHolder2.mDetailsDescriptionViewHolder;
        if (viewHolder3 != null) {
            this.f5619e.onUnbindViewHolder(viewHolder3);
        }
        viewHolder2.f5632s.setAdapter(null);
        viewHolder2.f5636w.setAdapter(null);
        viewHolder2.f5633t = 0;
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void setBackgroundColor(@ColorInt int i) {
        this.f5621g = i;
        this.f5622h = true;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.f5620f = onActionClickedListener;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.core.app.SharedElementCallback, androidx.leanback.widget.f0] */
    public final void setSharedElementEnterTransition(Activity activity, String str, long j) {
        if (this.f5624j == null) {
            ?? sharedElementCallback = new SharedElementCallback();
            sharedElementCallback.f6288b = new WeakReference(null);
            this.f5624j = sharedElementCallback;
        }
        C0333f0 c0333f0 = this.f5624j;
        c0333f0.getClass();
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            throw new IllegalArgumentException();
        }
        if (activity == c0333f0.f6289c && TextUtils.equals(str, c0333f0.f6291e)) {
            return;
        }
        Activity activity2 = c0333f0.f6289c;
        if (activity2 != null) {
            ActivityCompat.setEnterSharedElementCallback(activity2, null);
        }
        c0333f0.f6289c = activity;
        c0333f0.f6291e = str;
        ActivityCompat.setEnterSharedElementCallback(activity, c0333f0);
        ActivityCompat.postponeEnterTransition(c0333f0.f6289c);
        if (j > 0) {
            new Handler().postDelayed(new d30(c0333f0), j);
        }
    }

    public void setStyleLarge(boolean z) {
        this.f5623i = z;
    }

    public final void setSharedElementEnterTransition(Activity activity, String str) {
        setSharedElementEnterTransition(activity, str, 5000L);
    }
}
