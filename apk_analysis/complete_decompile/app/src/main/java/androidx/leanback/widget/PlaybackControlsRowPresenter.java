package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.recyclerview.widget.RecyclerView;
import p000.tc2;

/* loaded from: classes.dex */
public class PlaybackControlsRowPresenter extends PlaybackRowPresenter {

    /* renamed from: n */
    public static float f6001n;

    /* renamed from: e */
    public int f6002e;

    /* renamed from: f */
    public boolean f6003f;

    /* renamed from: g */
    public int f6004g;

    /* renamed from: h */
    public boolean f6005h;

    /* renamed from: i */
    public boolean f6006i;

    /* renamed from: j */
    public final Presenter f6007j;

    /* renamed from: k */
    public final C0314a2 f6008k;

    /* renamed from: l */
    public final C0376q f6009l;

    /* renamed from: m */
    public OnActionClickedListener f6010m;

    /* loaded from: classes.dex */
    public class ViewHolder extends PlaybackRowPresenter.ViewHolder {

        /* renamed from: A */
        public final C0331e2 f6011A;

        /* renamed from: B */
        public final C0331e2 f6012B;

        /* renamed from: C */
        public Presenter.ViewHolder f6013C;

        /* renamed from: D */
        public Object f6014D;

        /* renamed from: E */
        public final C0335f2 f6015E;
        public final Presenter.ViewHolder mDescriptionViewHolder;

        /* renamed from: n */
        public final ViewGroup f6017n;

        /* renamed from: o */
        public final ViewGroup f6018o;

        /* renamed from: p */
        public final ImageView f6019p;

        /* renamed from: q */
        public final ViewGroup f6020q;

        /* renamed from: r */
        public final ViewGroup f6021r;

        /* renamed from: s */
        public final ViewGroup f6022s;

        /* renamed from: t */
        public final View f6023t;

        /* renamed from: u */
        public final View f6024u;

        /* renamed from: v */
        public View f6025v;

        /* renamed from: w */
        public int f6026w;

        /* renamed from: x */
        public int f6027x;

        /* renamed from: y */
        public C0413z1 f6028y;

        /* renamed from: z */
        public Presenter.ViewHolder f6029z;

        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, androidx.leanback.widget.e2] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, androidx.leanback.widget.e2] */
        public ViewHolder(View view, Presenter presenter) {
            super(view);
            Presenter.ViewHolder onCreateViewHolder;
            this.f6011A = new Object();
            this.f6012B = new Object();
            this.f6015E = new C0335f2(this);
            this.f6017n = (ViewGroup) view.findViewById(androidx.leanback.R.id.controls_card);
            this.f6018o = (ViewGroup) view.findViewById(androidx.leanback.R.id.controls_card_right_panel);
            this.f6019p = (ImageView) view.findViewById(androidx.leanback.R.id.image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.description_dock);
            this.f6020q = viewGroup;
            this.f6021r = (ViewGroup) view.findViewById(androidx.leanback.R.id.controls_dock);
            this.f6022s = (ViewGroup) view.findViewById(androidx.leanback.R.id.secondary_controls_dock);
            this.f6023t = view.findViewById(androidx.leanback.R.id.spacer);
            this.f6024u = view.findViewById(androidx.leanback.R.id.bottom_spacer);
            if (presenter == null) {
                onCreateViewHolder = null;
            } else {
                onCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            }
            this.mDescriptionViewHolder = onCreateViewHolder;
            if (onCreateViewHolder != null) {
                viewGroup.addView(onCreateViewHolder.view);
            }
        }

        /* renamed from: a */
        public final void m1468a() {
            if (!isSelected()) {
                return;
            }
            if (this.f6013C == null) {
                if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                }
            } else if (getOnItemViewSelectedListener() != null) {
                getOnItemViewSelectedListener().onItemSelected(this.f6013C, this.f6014D, this, getRow());
            }
        }

        /* renamed from: b */
        public final Presenter m1469b(boolean z) {
            ObjectAdapter secondaryActionsAdapter;
            if (z) {
                secondaryActionsAdapter = ((PlaybackControlsRow) getRow()).getPrimaryActionsAdapter();
            } else {
                secondaryActionsAdapter = ((PlaybackControlsRow) getRow()).getSecondaryActionsAdapter();
            }
            Object obj = null;
            if (secondaryActionsAdapter == null) {
                return null;
            }
            if (secondaryActionsAdapter.getPresenterSelector() instanceof ControlButtonPresenterSelector) {
                ControlButtonPresenterSelector controlButtonPresenterSelector = (ControlButtonPresenterSelector) secondaryActionsAdapter.getPresenterSelector();
                if (z) {
                    return controlButtonPresenterSelector.getPrimaryPresenter();
                }
                return controlButtonPresenterSelector.getSecondaryPresenter();
            }
            if (secondaryActionsAdapter.size() > 0) {
                obj = secondaryActionsAdapter.get(0);
            }
            return secondaryActionsAdapter.getPresenter(obj);
        }

        /* renamed from: c */
        public final void m1470c(View view) {
            View view2 = this.f6025v;
            if (view2 != null) {
                tc2.m7490a(view2, false);
                ViewCompat.setZ(this.f6025v, RecyclerView.f7068F0);
            }
            this.f6025v = view;
            tc2.m7490a(view, true);
            if (PlaybackControlsRowPresenter.f6001n == RecyclerView.f7068F0) {
                PlaybackControlsRowPresenter.f6001n = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_z);
            }
            ViewCompat.setZ(view, PlaybackControlsRowPresenter.f6001n);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.leanback.widget.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.leanback.widget.q, androidx.leanback.widget.a2] */
    public PlaybackControlsRowPresenter(@Nullable Presenter presenter) {
        this.f6002e = 0;
        this.f6004g = 0;
        ?? obj = new Object();
        C0323c2 c0323c2 = new C0323c2(this);
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        this.f6007j = presenter;
        ?? c0376q = new C0376q(androidx.leanback.R.layout.lb_playback_controls);
        c0376q.f6267h = true;
        this.f6008k = c0376q;
        C0376q c0376q2 = new C0376q(androidx.leanback.R.layout.lb_control_bar);
        this.f6009l = c0376q2;
        c0376q.f6395c = obj;
        c0376q2.f6395c = obj;
        c0376q.f6394b = c0323c2;
        c0376q2.f6394b = c0323c2;
    }

    /* renamed from: c */
    public static int m1466c(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(androidx.leanback.R.attr.defaultBrandColor, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return context.getResources().getColor(androidx.leanback.R.color.lb_default_brand_color);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean areSecondaryActionsHidden() {
        return this.f6006i;
    }

    @Override // androidx.leanback.widget.RowPresenter
    @NonNull
    public RowPresenter.ViewHolder createRowViewHolder(@NonNull ViewGroup viewGroup) {
        int color;
        int m1466c;
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_playback_controls_row, viewGroup, false), this.f6007j);
        ViewGroup viewGroup2 = viewHolder.f6021r;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup2.getLayoutParams();
        viewHolder.f6026w = marginLayoutParams.getMarginStart();
        viewHolder.f6027x = marginLayoutParams.getMarginEnd();
        C0413z1 c0413z1 = (C0413z1) this.f6008k.onCreateViewHolder(viewGroup2);
        viewHolder.f6028y = c0413z1;
        if (this.f6005h) {
            color = this.f6004g;
        } else {
            Context context = viewGroup2.getContext();
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackProgressPrimaryColor, typedValue, true)) {
                color = context.getResources().getColor(typedValue.resourceId);
            } else {
                color = context.getResources().getColor(androidx.leanback.R.color.lb_playback_progress_color_no_theme);
            }
        }
        ((LayerDrawable) c0413z1.f6453q.getProgressDrawable()).setDrawableByLayerId(android.R.id.progress, new ClipDrawable(new ColorDrawable(color), 3, 1));
        C0413z1 c0413z12 = viewHolder.f6028y;
        if (this.f6003f) {
            m1466c = this.f6002e;
        } else {
            m1466c = m1466c(viewHolder.view.getContext());
        }
        c0413z12.f6339f.setBackgroundColor(m1466c);
        viewGroup2.addView(viewHolder.f6028y.view);
        C0376q c0376q = this.f6009l;
        ViewGroup viewGroup3 = viewHolder.f6022s;
        Presenter.ViewHolder onCreateViewHolder = c0376q.onCreateViewHolder(viewGroup3);
        viewHolder.f6029z = onCreateViewHolder;
        if (!this.f6006i) {
            viewGroup3.addView(onCreateViewHolder.view);
        }
        ((PlaybackControlsRowView) viewHolder.view).f6030a = new C0327d2(viewHolder);
        return viewHolder;
    }

    /* renamed from: d */
    public final void m1467d(ViewHolder viewHolder, int i) {
        int m1466c;
        ViewGroup.LayoutParams layoutParams = viewHolder.f6018o.getLayoutParams();
        layoutParams.height = i;
        viewHolder.f6018o.setLayoutParams(layoutParams);
        View view = viewHolder.f6021r;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ViewGroup viewGroup = viewHolder.f6020q;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
        C0314a2 c0314a2 = this.f6008k;
        View view2 = viewHolder.f6017n;
        if (i == -2) {
            layoutParams2.height = -2;
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(0);
            view2.setBackground(null);
            viewHolder.m1470c(view);
            C0413z1 c0413z1 = viewHolder.f6028y;
            c0314a2.getClass();
            C0314a2.m1491a(c0413z1, true);
        } else {
            layoutParams2.height = 0;
            layoutParams2.weight = 1.0f;
            marginLayoutParams.setMarginStart(viewHolder.f6026w);
            marginLayoutParams.setMarginEnd(viewHolder.f6027x);
            if (this.f6003f) {
                m1466c = this.f6002e;
            } else {
                m1466c = m1466c(view2.getContext());
            }
            view2.setBackgroundColor(m1466c);
            viewHolder.m1470c(view2);
            C0413z1 c0413z12 = viewHolder.f6028y;
            c0314a2.getClass();
            C0314a2.m1491a(c0413z12, false);
        }
        viewGroup.setLayoutParams(layoutParams2);
        view.setLayoutParams(marginLayoutParams);
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.f6002e;
    }

    @Nullable
    public OnActionClickedListener getOnActionClickedListener() {
        return this.f6010m;
    }

    @ColorInt
    public int getProgressColor() {
        return this.f6004g;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        boolean z = this.f6006i;
        C0314a2 c0314a2 = this.f6008k;
        c0314a2.f6267h = z;
        Object item = playbackControlsRow.getItem();
        View view = viewHolder2.f6023t;
        ViewGroup viewGroup = viewHolder2.f6020q;
        if (item == null) {
            viewGroup.setVisibility(8);
            view.setVisibility(8);
        } else {
            viewGroup.setVisibility(0);
            Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
            if (viewHolder3 != null) {
                this.f6007j.onBindViewHolder(viewHolder3, playbackControlsRow.getItem());
            }
            view.setVisibility(0);
        }
        Drawable imageDrawable = playbackControlsRow.getImageDrawable();
        ImageView imageView = viewHolder2.f6019p;
        if (imageDrawable != null && playbackControlsRow.getItem() != null) {
            imageView.setImageDrawable(playbackControlsRow.getImageDrawable());
            m1467d(viewHolder2, imageView.getLayoutParams().height);
        } else {
            imageView.setImageDrawable(null);
            m1467d(viewHolder2, -2);
        }
        ObjectAdapter primaryActionsAdapter = playbackControlsRow.getPrimaryActionsAdapter();
        C0331e2 c0331e2 = viewHolder2.f6011A;
        c0331e2.f43a = primaryActionsAdapter;
        c0331e2.f45c = playbackControlsRow.getSecondaryActionsAdapter();
        c0331e2.f44b = viewHolder2.m1469b(true);
        c0331e2.f6284d = viewHolder2;
        c0314a2.onBindViewHolder(viewHolder2.f6028y, c0331e2);
        ObjectAdapter secondaryActionsAdapter = playbackControlsRow.getSecondaryActionsAdapter();
        C0331e2 c0331e22 = viewHolder2.f6012B;
        c0331e22.f43a = secondaryActionsAdapter;
        c0331e22.f44b = viewHolder2.m1469b(false);
        c0331e22.f6284d = viewHolder2;
        this.f6009l.onBindViewHolder(viewHolder2.f6029z, c0331e22);
        C0314a2.m1494d(viewHolder2.f6028y, playbackControlsRow.getTotalTime());
        C0314a2.m1493c(viewHolder2.f6028y, playbackControlsRow.getCurrentTime());
        viewHolder2.f6028y.f6453q.setSecondaryProgress((int) ((playbackControlsRow.getBufferedProgress() / r0.f6455s) * 2.147483647E9d));
        playbackControlsRow.setOnPlaybackProgressChangedListener(viewHolder2.f6015E);
    }

    @Override // androidx.leanback.widget.PlaybackRowPresenter
    public void onReappear(@NonNull RowPresenter.ViewHolder viewHolder) {
        showPrimaryActions((ViewHolder) viewHolder);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewAttachedToWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.f6007j;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewDetachedFromWindow(@NonNull RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.f6007j;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewSelected(@NonNull RowPresenter.ViewHolder viewHolder, boolean z) {
        super.onRowViewSelected(viewHolder, z);
        if (z) {
            ((ViewHolder) viewHolder).m1468a();
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
        if (viewHolder3 != null) {
            this.f6007j.onUnbindViewHolder(viewHolder3);
        }
        this.f6008k.onUnbindViewHolder(viewHolder2.f6028y);
        this.f6009l.onUnbindViewHolder(viewHolder2.f6029z);
        playbackControlsRow.setOnPlaybackProgressChangedListener(null);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void setBackgroundColor(@ColorInt int i) {
        this.f6002e = i;
        this.f6003f = true;
    }

    public void setOnActionClickedListener(@Nullable OnActionClickedListener onActionClickedListener) {
        this.f6010m = onActionClickedListener;
    }

    public void setProgressColor(@ColorInt int i) {
        this.f6004g = i;
        this.f6005h = true;
    }

    public void setSecondaryActionsHidden(boolean z) {
        this.f6006i = z;
    }

    public void showBottomSpace(@NonNull ViewHolder viewHolder, boolean z) {
        int i;
        View view = viewHolder.f6024u;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void showPrimaryActions(@NonNull ViewHolder viewHolder) {
        C0413z1 c0413z1 = viewHolder.f6028y;
        this.f6008k.getClass();
        boolean z = c0413z1.f6450n;
        if (z) {
            c0413z1.f6450n = !z;
            c0413z1.m1503d(c0413z1.f6337d);
        }
        if (viewHolder.view.hasFocus()) {
            viewHolder.f6028y.f6338e.requestFocus();
        }
    }

    public PlaybackControlsRowPresenter() {
        this(null);
    }
}
