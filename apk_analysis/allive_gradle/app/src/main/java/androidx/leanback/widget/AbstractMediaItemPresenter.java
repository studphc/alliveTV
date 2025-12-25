package androidx.leanback.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.leanback.widget.MultiActionsProvider;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.C0542b2;

/* loaded from: classes.dex */
public abstract class AbstractMediaItemPresenter extends RowPresenter {
    public static final int PLAY_STATE_INITIAL = 0;
    public static final int PLAY_STATE_PAUSED = 1;
    public static final int PLAY_STATE_PLAYING = 2;

    /* renamed from: j */
    public static final Rect f5532j = new Rect();

    /* renamed from: e */
    public int f5533e;

    /* renamed from: f */
    public boolean f5534f;

    /* renamed from: g */
    public boolean f5535g;

    /* renamed from: h */
    public int f5536h;

    /* renamed from: i */
    public Presenter f5537i;

    /* loaded from: classes.dex */
    public static class ViewHolder extends RowPresenter.ViewHolder {

        /* renamed from: A */
        public AbstractMediaItemPresenter f5538A;

        /* renamed from: B */
        public ValueAnimator f5539B;

        /* renamed from: n */
        public final View f5540n;

        /* renamed from: o */
        public final View f5541o;

        /* renamed from: p */
        public final View f5542p;

        /* renamed from: q */
        public final ViewFlipper f5543q;

        /* renamed from: r */
        public final TextView f5544r;

        /* renamed from: s */
        public final View f5545s;

        /* renamed from: t */
        public final View f5546t;

        /* renamed from: u */
        public final TextView f5547u;

        /* renamed from: v */
        public final TextView f5548v;

        /* renamed from: w */
        public final View f5549w;

        /* renamed from: x */
        public final ViewGroup f5550x;

        /* renamed from: y */
        public final ArrayList f5551y;

        /* renamed from: z */
        public MultiActionsProvider.MultiAction[] f5552z;

        public ViewHolder(View view) {
            super(view);
            int i;
            this.f5541o = view.findViewById(androidx.leanback.R.id.mediaRowSelector);
            this.f5540n = view.findViewById(androidx.leanback.R.id.mediaItemRow);
            this.f5542p = view.findViewById(androidx.leanback.R.id.mediaItemDetails);
            this.f5547u = (TextView) view.findViewById(androidx.leanback.R.id.mediaItemName);
            this.f5548v = (TextView) view.findViewById(androidx.leanback.R.id.mediaItemDuration);
            this.f5549w = view.findViewById(androidx.leanback.R.id.mediaRowSeparator);
            this.f5550x = (ViewGroup) view.findViewById(androidx.leanback.R.id.mediaItemActionsContainer);
            this.f5551y = new ArrayList();
            getMediaItemDetailsView().setOnClickListener(new ViewOnClickListenerC0320c(this));
            getMediaItemDetailsView().setOnFocusChangeListener(new ViewOnFocusChangeListenerC0324d(this));
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(androidx.leanback.R.id.mediaItemNumberViewFlipper);
            this.f5543q = viewFlipper;
            TypedValue typedValue = new TypedValue();
            boolean resolveAttribute = view.getContext().getTheme().resolveAttribute(androidx.leanback.R.attr.playbackMediaItemNumberViewFlipperLayout, typedValue, true);
            LayoutInflater from = LayoutInflater.from(view.getContext());
            if (resolveAttribute) {
                i = typedValue.resourceId;
            } else {
                i = androidx.leanback.R.layout.lb_media_item_number_view_flipper;
            }
            View inflate = from.inflate(i, (ViewGroup) viewFlipper, true);
            this.f5544r = (TextView) inflate.findViewById(androidx.leanback.R.id.initial);
            this.f5545s = inflate.findViewById(androidx.leanback.R.id.paused);
            this.f5546t = inflate.findViewById(androidx.leanback.R.id.playing);
        }

        public ViewGroup getMediaItemActionsContainer() {
            return this.f5550x;
        }

        public View getMediaItemDetailsView() {
            return this.f5542p;
        }

        public TextView getMediaItemDurationView() {
            return this.f5548v;
        }

        public TextView getMediaItemNameView() {
            return this.f5547u;
        }

        public TextView getMediaItemNumberView() {
            return this.f5544r;
        }

        public ViewFlipper getMediaItemNumberViewFlipper() {
            return this.f5543q;
        }

        public View getMediaItemPausedView() {
            return this.f5545s;
        }

        public View getMediaItemPlayingView() {
            return this.f5546t;
        }

        public MultiActionsProvider.MultiAction[] getMediaItemRowActions() {
            return this.f5552z;
        }

        public View getMediaItemRowSeparator() {
            return this.f5549w;
        }

        public View getSelectorView() {
            return this.f5541o;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void notifyActionChanged(MultiActionsProvider.MultiAction multiAction) {
            int i;
            Presenter actionPresenter = this.f5538A.getActionPresenter();
            if (actionPresenter == null) {
                return;
            }
            if (this.f5552z != null) {
                i = 0;
                while (true) {
                    MultiActionsProvider.MultiAction[] multiActionArr = this.f5552z;
                    if (i >= multiActionArr.length) {
                        break;
                    } else if (multiActionArr[i] == multiAction) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    Presenter.ViewHolder viewHolder = (Presenter.ViewHolder) this.f5551y.get(i);
                    actionPresenter.onUnbindViewHolder(viewHolder);
                    actionPresenter.onBindViewHolder(viewHolder, multiAction);
                    return;
                }
                return;
            }
            i = -1;
            if (i < 0) {
            }
        }

        public void notifyDetailsChanged() {
            this.f5538A.onUnbindMediaDetails(this);
            this.f5538A.onBindMediaDetails(this, getRowObject());
        }

        public void notifyPlayStateChanged() {
            this.f5538A.onBindMediaPlayState(this);
        }

        public void onBindRowActions() {
            ArrayList arrayList;
            int childCount = getMediaItemActionsContainer().getChildCount();
            while (true) {
                childCount--;
                arrayList = this.f5551y;
                if (childCount < arrayList.size()) {
                    break;
                }
                getMediaItemActionsContainer().removeViewAt(childCount);
                arrayList.remove(childCount);
            }
            this.f5552z = null;
            Object rowObject = getRowObject();
            if (rowObject instanceof MultiActionsProvider) {
                MultiActionsProvider.MultiAction[] actions = ((MultiActionsProvider) rowObject).getActions();
                Presenter actionPresenter = this.f5538A.getActionPresenter();
                if (actionPresenter == null) {
                    return;
                }
                this.f5552z = actions;
                for (int size = arrayList.size(); size < actions.length; size++) {
                    Presenter.ViewHolder onCreateViewHolder = actionPresenter.onCreateViewHolder(getMediaItemActionsContainer());
                    getMediaItemActionsContainer().addView(onCreateViewHolder.view);
                    arrayList.add(onCreateViewHolder);
                    onCreateViewHolder.view.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0328e(this));
                    onCreateViewHolder.view.setOnClickListener(new ViewOnClickListenerC0332f(this, onCreateViewHolder, size));
                }
                if (this.f5550x != null) {
                    for (int i = 0; i < actions.length; i++) {
                        Presenter.ViewHolder viewHolder = (Presenter.ViewHolder) arrayList.get(i);
                        actionPresenter.onUnbindViewHolder(viewHolder);
                        actionPresenter.onBindViewHolder(viewHolder, this.f5552z[i]);
                    }
                }
            }
        }

        public void setSelectedMediaItemNumberView(int i) {
            if (i >= 0) {
                ViewFlipper viewFlipper = this.f5543q;
                if (i < viewFlipper.getChildCount()) {
                    viewFlipper.setDisplayedChild(i);
                }
            }
        }
    }

    public AbstractMediaItemPresenter() {
        this(0);
    }

    /* renamed from: c */
    public static ValueAnimator m1381c(View view, View view2, ValueAnimator valueAnimator, boolean z) {
        ValueAnimator valueAnimator2;
        int integer = view2.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        int layoutDirection = ViewCompat.getLayoutDirection(view);
        if (!view2.hasFocus()) {
            view.animate().cancel();
            view.animate().alpha(RecyclerView.f7068F0).setDuration(integer).setInterpolator(decelerateInterpolator).start();
            return valueAnimator;
        }
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator2 = null;
        } else {
            valueAnimator2 = valueAnimator;
        }
        float alpha = view.getAlpha();
        long j = integer;
        view.animate().alpha(1.0f).setDuration(j).setInterpolator(decelerateInterpolator).start();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = view2.getWidth();
        int height = view2.getHeight();
        Rect rect = f5532j;
        rect.set(0, 0, width, height);
        viewGroup.offsetDescendantRectToMyCoords(view2, rect);
        if (z) {
            if (layoutDirection == 1) {
                rect.right = viewGroup.getHeight() + rect.right;
                rect.left -= viewGroup.getHeight() / 2;
            } else {
                rect.left -= viewGroup.getHeight();
                rect.right = (viewGroup.getHeight() / 2) + rect.right;
            }
        }
        int i = rect.left;
        int width2 = rect.width();
        float f = marginLayoutParams.width - width2;
        float f2 = marginLayoutParams.leftMargin - i;
        if (f2 != RecyclerView.f7068F0 || f != RecyclerView.f7068F0) {
            if (alpha == RecyclerView.f7068F0) {
                marginLayoutParams.width = width2;
                marginLayoutParams.leftMargin = i;
                view.requestLayout();
                return valueAnimator2;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(decelerateInterpolator);
            ofFloat.addUpdateListener(new C0542b2(marginLayoutParams, i, f2, width2, f, view));
            ofFloat.start();
            return ofFloat;
        }
        return valueAnimator2;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.f5536h != 0) {
            context = new ContextThemeWrapper(context, this.f5536h);
        }
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_row_media_item, viewGroup, false));
        viewHolder.f5538A = this;
        if (this.f5534f) {
            viewHolder.f5540n.setBackgroundColor(this.f5533e);
        }
        return viewHolder;
    }

    public Presenter getActionPresenter() {
        return this.f5537i;
    }

    public int getMediaPlayState(Object obj) {
        return 0;
    }

    public int getThemeId() {
        return this.f5536h;
    }

    public boolean hasMediaRowSeparator() {
        return this.f5535g;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isClippingChildren() {
        return true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public abstract void onBindMediaDetails(ViewHolder viewHolder, Object obj);

    public void onBindMediaPlayState(ViewHolder viewHolder) {
        int indexOfChild;
        View view;
        int mediaPlayState = viewHolder.f5538A.getMediaPlayState(viewHolder.getRowObject());
        ViewFlipper viewFlipper = viewHolder.f5543q;
        if (mediaPlayState != 0) {
            if (mediaPlayState != 1) {
                if (mediaPlayState == 2 && (view = viewHolder.f5546t) != null) {
                    indexOfChild = viewFlipper.indexOfChild(view);
                }
                indexOfChild = -1;
            } else {
                View view2 = viewHolder.f5545s;
                if (view2 != null) {
                    indexOfChild = viewFlipper.indexOfChild(view2);
                }
                indexOfChild = -1;
            }
        } else {
            TextView textView = viewHolder.f5544r;
            if (textView != null) {
                indexOfChild = viewFlipper.indexOfChild(textView);
            }
            indexOfChild = -1;
        }
        if (indexOfChild != -1 && viewFlipper.getDisplayedChild() != indexOfChild) {
            viewFlipper.setDisplayedChild(indexOfChild);
        }
    }

    public void onBindRowActions(ViewHolder viewHolder) {
        viewHolder.onBindRowActions();
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        int i;
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onBindRowActions(viewHolder2);
        View mediaItemRowSeparator = viewHolder2.getMediaItemRowSeparator();
        if (hasMediaRowSeparator()) {
            i = 0;
        } else {
            i = 8;
        }
        mediaItemRowSeparator.setVisibility(i);
        onBindMediaPlayState(viewHolder2);
        onBindMediaDetails(viewHolder2, obj);
    }

    public void onUnbindMediaDetails(ViewHolder viewHolder) {
    }

    public void onUnbindMediaPlayState(ViewHolder viewHolder) {
    }

    public void setActionPresenter(Presenter presenter) {
        this.f5537i = presenter;
    }

    public void setBackgroundColor(int i) {
        this.f5534f = true;
        this.f5533e = i;
    }

    public void setHasMediaRowSeparator(boolean z) {
        this.f5535g = z;
    }

    public void setThemeId(int i) {
        this.f5536h = i;
    }

    public AbstractMediaItemPresenter(int i) {
        this.f5533e = 0;
        this.f5537i = new Presenter();
        this.f5536h = i;
        setHeaderPresenter(null);
    }
}
