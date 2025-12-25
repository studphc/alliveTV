package androidx.leanback.app;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.leanback.animation.LogAccelerateInterpolator;
import androidx.leanback.animation.LogDecelerateInterpolator;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridView;
import p000.HandlerC1714q7;
import p000.b30;
import p000.b52;
import p000.c52;
import p000.d52;
import p000.e52;
import p000.f52;
import p000.g52;
import p000.h52;
import p000.i52;
import p000.ou0;

@Deprecated
/* loaded from: classes.dex */
public class PlaybackFragment extends Fragment {
    public static final int BG_DARK = 1;
    public static final int BG_LIGHT = 2;
    public static final int BG_NONE = 0;

    /* renamed from: A */
    public OnFadeCompleteListener f5101A;

    /* renamed from: B */
    public View.OnKeyListener f5102B;

    /* renamed from: C */
    public boolean f5103C;

    /* renamed from: D */
    public boolean f5104D;

    /* renamed from: E */
    public boolean f5105E;

    /* renamed from: F */
    public boolean f5106F;

    /* renamed from: G */
    public int f5107G;

    /* renamed from: H */
    public ValueAnimator f5108H;

    /* renamed from: I */
    public ValueAnimator f5109I;

    /* renamed from: J */
    public ValueAnimator f5110J;

    /* renamed from: K */
    public ValueAnimator f5111K;

    /* renamed from: L */
    public ValueAnimator f5112L;

    /* renamed from: M */
    public ValueAnimator f5113M;

    /* renamed from: N */
    public final C0283q f5114N;

    /* renamed from: O */
    public final HandlerC1714q7 f5115O;

    /* renamed from: P */
    public final f52 f5116P;

    /* renamed from: Q */
    public final g52 f5117Q;

    /* renamed from: R */
    public final LogDecelerateInterpolator f5118R;

    /* renamed from: S */
    public final LogAccelerateInterpolator f5119S;

    /* renamed from: T */
    public final b52 f5120T;

    /* renamed from: U */
    public final c52 f5121U;

    /* renamed from: a */
    public PlaybackGlueHost.HostCallback f5122a;

    /* renamed from: b */
    public PlaybackSeekUi.Client f5123b;

    /* renamed from: c */
    public boolean f5124c;

    /* renamed from: d */
    public final ProgressBarManager f5125d;

    /* renamed from: e */
    public RowsFragment f5126e;

    /* renamed from: f */
    public ObjectAdapter f5127f;

    /* renamed from: g */
    public PlaybackRowPresenter f5128g;

    /* renamed from: h */
    public Row f5129h;

    /* renamed from: i */
    public BaseOnItemViewSelectedListener f5130i;

    /* renamed from: j */
    public BaseOnItemViewClickedListener f5131j;

    /* renamed from: k */
    public BaseOnItemViewClickedListener f5132k;

    /* renamed from: l */
    public final d52 f5133l;

    /* renamed from: m */
    public final e52 f5134m;

    /* renamed from: n */
    public final b30 f5135n;

    /* renamed from: o */
    public int f5136o;

    /* renamed from: p */
    public int f5137p;

    /* renamed from: q */
    public View f5138q;

    /* renamed from: r */
    public View f5139r;

    /* renamed from: s */
    public int f5140s;

    /* renamed from: t */
    public int f5141t;

    /* renamed from: u */
    public int f5142u;

    /* renamed from: v */
    public int f5143v;

    /* renamed from: w */
    public int f5144w;

    /* renamed from: x */
    public int f5145x;

    /* renamed from: y */
    public int f5146y;

    /* renamed from: z */
    public int f5147z;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class OnFadeCompleteListener {
        public void onFadeInComplete() {
        }

        public void onFadeOutComplete() {
        }
    }

    public PlaybackFragment() {
        ProgressBarManager progressBarManager = new ProgressBarManager();
        this.f5125d = progressBarManager;
        this.f5133l = new d52(this);
        this.f5134m = new e52(this);
        this.f5135n = new b30(2, this);
        this.f5140s = 1;
        this.f5103C = true;
        this.f5104D = true;
        this.f5105E = true;
        this.f5106F = true;
        this.f5114N = new C0283q(this);
        this.f5115O = new HandlerC1714q7(3, this);
        this.f5116P = new f52(this);
        this.f5117Q = new g52(this);
        this.f5118R = new LogDecelerateInterpolator(100, 0);
        this.f5119S = new LogAccelerateInterpolator(100, 0);
        this.f5120T = new b52(this);
        this.f5121U = new c52(this);
        progressBarManager.setInitialDelay(500L);
    }

    /* renamed from: a */
    public static void m1318a(ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        if (valueAnimator.isStarted()) {
            valueAnimator.end();
        } else if (valueAnimator2.isStarted()) {
            valueAnimator2.end();
        }
    }

    /* renamed from: c */
    public static ValueAnimator m1319c(int i, Context context) {
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(context, i);
        valueAnimator.setDuration(valueAnimator.getDuration());
        return valueAnimator;
    }

    /* renamed from: e */
    public static void m1320e(ValueAnimator valueAnimator, ValueAnimator valueAnimator2, boolean z) {
        if (valueAnimator.isStarted()) {
            valueAnimator.reverse();
            if (!z) {
                valueAnimator.end();
                return;
            }
            return;
        }
        valueAnimator2.start();
        if (!z) {
            valueAnimator2.end();
        }
    }

    /* renamed from: b */
    public final VerticalGridView m1321b() {
        RowsFragment rowsFragment = this.f5126e;
        if (rowsFragment == null) {
            return null;
        }
        return rowsFragment.getVerticalGridView();
    }

    /* renamed from: d */
    public final boolean m1322d(InputEvent inputEvent) {
        boolean z;
        int i;
        int i2;
        boolean z2 = this.f5105E;
        if (inputEvent instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) inputEvent;
            i = keyEvent.getKeyCode();
            i2 = keyEvent.getAction();
            View.OnKeyListener onKeyListener = this.f5102B;
            if (onKeyListener != null) {
                z = onKeyListener.onKey(getView(), i, keyEvent);
            } else {
                z = false;
            }
        } else {
            z = false;
            i = 0;
            i2 = 0;
        }
        if (i != 4 && i != 111) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    if (!z2) {
                        z = true;
                    }
                    if (this.f5106F && i2 == 0) {
                        tickle();
                        return z;
                    }
                    return z;
                default:
                    if (this.f5106F && z && i2 == 0) {
                        tickle();
                        return z;
                    }
                    return z;
            }
        }
        if (this.f5124c) {
            return false;
        }
        if (this.f5106F && z2) {
            if (((KeyEvent) inputEvent).getAction() == 1) {
                hideControlsOverlay(true);
            }
            return true;
        }
        return z;
    }

    /* renamed from: f */
    public final void m1323f() {
        Presenter[] presenters;
        ObjectAdapter objectAdapter = this.f5127f;
        if (objectAdapter != null && objectAdapter.getPresenterSelector() != null && (presenters = this.f5127f.getPresenterSelector().getPresenters()) != null) {
            for (int i = 0; i < presenters.length; i++) {
                Presenter presenter = presenters[i];
                if ((presenter instanceof PlaybackRowPresenter) && presenter.getFacet(ItemAlignmentFacet.class) == null) {
                    ItemAlignmentFacet itemAlignmentFacet = new ItemAlignmentFacet();
                    ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef = new ItemAlignmentFacet.ItemAlignmentDef();
                    itemAlignmentDef.setItemAlignmentOffset(0);
                    itemAlignmentDef.setItemAlignmentOffsetPercent(100.0f);
                    itemAlignmentFacet.setAlignmentDefs(new ItemAlignmentFacet.ItemAlignmentDef[]{itemAlignmentDef});
                    presenters[i].setFacet(ItemAlignmentFacet.class, itemAlignmentFacet);
                }
            }
        }
    }

    @Deprecated
    public void fadeOut() {
        m1327j(false, false);
    }

    /* renamed from: g */
    public final void m1324g(boolean z) {
        int i;
        HandlerC1714q7 handlerC1714q7;
        if (this.f5124c == z) {
            return;
        }
        this.f5124c = z;
        m1321b().setSelectedPosition(0);
        if (this.f5124c && (handlerC1714q7 = this.f5115O) != null) {
            handlerC1714q7.removeMessages(1);
        }
        showControlsOverlay(true);
        int childCount = m1321b().getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = m1321b().getChildAt(i2);
            if (m1321b().getChildAdapterPosition(childAt) > 0) {
                if (this.f5124c) {
                    i = 4;
                } else {
                    i = 0;
                }
                childAt.setVisibility(i);
            }
        }
    }

    public ObjectAdapter getAdapter() {
        return this.f5127f;
    }

    public int getBackgroundType() {
        return this.f5140s;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public OnFadeCompleteListener getFadeCompleteListener() {
        return this.f5101A;
    }

    public ProgressBarManager getProgressBarManager() {
        return this.f5125d;
    }

    /* renamed from: h */
    public final void m1325h() {
        ObjectAdapter objectAdapter = this.f5127f;
        if (objectAdapter != null && this.f5129h != null && this.f5128g != null) {
            PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
            if (presenterSelector == null) {
                ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
                classPresenterSelector.addClassPresenter(this.f5129h.getClass(), this.f5128g);
                this.f5127f.setPresenterSelector(classPresenterSelector);
            } else if (presenterSelector instanceof ClassPresenterSelector) {
                ((ClassPresenterSelector) presenterSelector).addClassPresenter(this.f5129h.getClass(), this.f5128g);
            }
        }
    }

    public void hideControlsOverlay(boolean z) {
        m1327j(false, z);
    }

    /* renamed from: i */
    public final void m1326i() {
        Row row;
        ObjectAdapter objectAdapter = this.f5127f;
        if ((objectAdapter instanceof ArrayObjectAdapter) && this.f5129h != null) {
            ArrayObjectAdapter arrayObjectAdapter = (ArrayObjectAdapter) objectAdapter;
            if (arrayObjectAdapter.size() == 0) {
                arrayObjectAdapter.add(this.f5129h);
                return;
            } else {
                arrayObjectAdapter.replace(0, this.f5129h);
                return;
            }
        }
        if ((objectAdapter instanceof SparseArrayObjectAdapter) && (row = this.f5129h) != null) {
            ((SparseArrayObjectAdapter) objectAdapter).set(0, row);
        }
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.f5103C;
    }

    public boolean isControlsOverlayVisible() {
        return this.f5105E;
    }

    @Deprecated
    public boolean isFadingEnabled() {
        return isControlsOverlayAutoHideEnabled();
    }

    public boolean isShowOrHideControlsOverlayOnUserInteraction() {
        return this.f5106F;
    }

    /* renamed from: j */
    public final void m1327j(boolean z, boolean z2) {
        int i;
        int i2;
        HandlerC1714q7 handlerC1714q7;
        if (getView() == null) {
            this.f5104D = z;
            return;
        }
        if (!isResumed()) {
            z2 = false;
        }
        if (z == this.f5105E) {
            if (!z2) {
                m1318a(this.f5108H, this.f5109I);
                m1318a(this.f5110J, this.f5111K);
                m1318a(this.f5112L, this.f5113M);
                return;
            }
            return;
        }
        this.f5105E = z;
        if (!z && (handlerC1714q7 = this.f5115O) != null) {
            handlerC1714q7.removeMessages(1);
        }
        if (m1321b() != null && m1321b().getSelectedPosition() != 0) {
            i = this.f5146y;
        } else {
            i = this.f5145x;
        }
        this.f5147z = i;
        if (z) {
            m1320e(this.f5109I, this.f5108H, z2);
            m1320e(this.f5111K, this.f5110J, z2);
            m1320e(this.f5113M, this.f5112L, z2);
        } else {
            m1320e(this.f5108H, this.f5109I, z2);
            m1320e(this.f5110J, this.f5111K, z2);
            m1320e(this.f5112L, this.f5113M, z2);
        }
        if (z2) {
            View view = getView();
            if (z) {
                i2 = R.string.lb_playback_controls_shown;
            } else {
                i2 = R.string.lb_playback_controls_hidden;
            }
            view.announceForAccessibility(getString(i2));
        }
    }

    /* renamed from: k */
    public final void m1328k() {
        View view = this.f5139r;
        if (view != null) {
            int i = this.f5141t;
            int i2 = this.f5140s;
            if (i2 != 0) {
                if (i2 == 2) {
                    i = this.f5142u;
                }
            } else {
                i = 0;
            }
            view.setBackground(new ColorDrawable(i));
            int i3 = this.f5107G;
            this.f5107G = i3;
            View view2 = this.f5139r;
            if (view2 != null) {
                view2.getBackground().setAlpha(i3);
            }
        }
    }

    public void notifyPlaybackRowChanged() {
        ObjectAdapter objectAdapter = this.f5127f;
        if (objectAdapter == null) {
            return;
        }
        objectAdapter.notifyItemRangeChanged(0, 1);
    }

    public void onBufferingStateChanged(boolean z) {
        ProgressBarManager progressBarManager = getProgressBarManager();
        if (progressBarManager != null) {
            if (z) {
                progressBarManager.show();
            } else {
                progressBarManager.hide();
            }
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5137p = getResources().getDimensionPixelSize(R.dimen.lb_playback_other_rows_center_to_bottom);
        this.f5136o = getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_padding_bottom);
        this.f5141t = getResources().getColor(R.color.lb_playback_controls_background_dark);
        this.f5142u = getResources().getColor(R.color.lb_playback_controls_background_light);
        TypedValue typedValue = new TypedValue();
        ou0.m6729a(this).getTheme().resolveAttribute(R.attr.playbackControlsAutoHideTimeout, typedValue, true);
        this.f5143v = typedValue.data;
        ou0.m6729a(this).getTheme().resolveAttribute(R.attr.playbackControlsAutoHideTickleTimeout, typedValue, true);
        this.f5144w = typedValue.data;
        this.f5145x = getResources().getDimensionPixelSize(R.dimen.lb_playback_major_fade_translate_y);
        this.f5146y = getResources().getDimensionPixelSize(R.dimen.lb_playback_minor_fade_translate_y);
        h52 h52Var = new h52(this, 0);
        Context m6729a = ou0.m6729a(this);
        ValueAnimator m1319c = m1319c(R.animator.lb_playback_bg_fade_in, m6729a);
        this.f5108H = m1319c;
        m1319c.addUpdateListener(h52Var);
        ValueAnimator valueAnimator = this.f5108H;
        C0283q c0283q = this.f5114N;
        valueAnimator.addListener(c0283q);
        ValueAnimator m1319c2 = m1319c(R.animator.lb_playback_bg_fade_out, m6729a);
        this.f5109I = m1319c2;
        m1319c2.addUpdateListener(h52Var);
        this.f5109I.addListener(c0283q);
        i52 i52Var = new i52(this);
        Context m6729a2 = ou0.m6729a(this);
        int i = R.animator.lb_playback_controls_fade_in;
        ValueAnimator m1319c3 = m1319c(i, m6729a2);
        this.f5110J = m1319c3;
        m1319c3.addUpdateListener(i52Var);
        ValueAnimator valueAnimator2 = this.f5110J;
        LogDecelerateInterpolator logDecelerateInterpolator = this.f5118R;
        valueAnimator2.setInterpolator(logDecelerateInterpolator);
        int i2 = R.animator.lb_playback_controls_fade_out;
        ValueAnimator m1319c4 = m1319c(i2, m6729a2);
        this.f5111K = m1319c4;
        m1319c4.addUpdateListener(i52Var);
        this.f5111K.setInterpolator(this.f5119S);
        h52 h52Var2 = new h52(this, 1);
        Context m6729a3 = ou0.m6729a(this);
        ValueAnimator m1319c5 = m1319c(i, m6729a3);
        this.f5112L = m1319c5;
        m1319c5.addUpdateListener(h52Var2);
        this.f5112L.setInterpolator(logDecelerateInterpolator);
        ValueAnimator m1319c6 = m1319c(i2, m6729a3);
        this.f5113M = m1319c6;
        m1319c6.addUpdateListener(h52Var2);
        this.f5113M.setInterpolator(new AccelerateInterpolator());
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lb_playback_fragment, viewGroup, false);
        this.f5138q = inflate;
        this.f5139r = inflate.findViewById(R.id.playback_fragment_background);
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.playback_controls_dock;
        RowsFragment rowsFragment = (RowsFragment) childFragmentManager.findFragmentById(i);
        this.f5126e = rowsFragment;
        if (rowsFragment == null) {
            this.f5126e = new RowsFragment();
            getChildFragmentManager().beginTransaction().replace(i, this.f5126e).commit();
        }
        ObjectAdapter objectAdapter = this.f5127f;
        if (objectAdapter == null) {
            setAdapter(new ArrayObjectAdapter(new ClassPresenterSelector()));
        } else {
            this.f5126e.setAdapter(objectAdapter);
        }
        this.f5126e.setOnItemViewSelectedListener(this.f5134m);
        this.f5126e.setOnItemViewClickedListener(this.f5133l);
        this.f5107G = 255;
        m1328k();
        this.f5126e.f5220v = this.f5120T;
        ProgressBarManager progressBarManager = getProgressBarManager();
        if (progressBarManager != null) {
            progressBarManager.setRootView((ViewGroup) this.f5138q);
        }
        return this.f5138q;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        PlaybackGlueHost.HostCallback hostCallback = this.f5122a;
        if (hostCallback != null) {
            hostCallback.onHostDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f5138q = null;
        this.f5139r = null;
        super.onDestroyView();
    }

    public void onError(int i, CharSequence charSequence) {
    }

    @Override // android.app.Fragment
    public void onPause() {
        PlaybackGlueHost.HostCallback hostCallback = this.f5122a;
        if (hostCallback != null) {
            hostCallback.onHostPause();
        }
        HandlerC1714q7 handlerC1714q7 = this.f5115O;
        if (handlerC1714q7.hasMessages(1)) {
            handlerC1714q7.removeMessages(1);
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f5105E && this.f5103C) {
            int i = this.f5143v;
            HandlerC1714q7 handlerC1714q7 = this.f5115O;
            if (handlerC1714q7 != null) {
                handlerC1714q7.removeMessages(1);
                handlerC1714q7.sendEmptyMessageDelayed(1, i);
            }
        }
        m1321b().setOnTouchInterceptListener(this.f5116P);
        m1321b().setOnKeyInterceptListener(this.f5117Q);
        PlaybackGlueHost.HostCallback hostCallback = this.f5122a;
        if (hostCallback != null) {
            hostCallback.onHostResume();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.f5126e.getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setWindowAlignmentOffset(-this.f5136o);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffset(this.f5137p - this.f5136o);
            verticalGridView.setItemAlignmentOffsetPercent(50.0f);
            verticalGridView.setPadding(verticalGridView.getPaddingLeft(), verticalGridView.getPaddingTop(), verticalGridView.getPaddingRight(), this.f5136o);
            verticalGridView.setWindowAlignment(2);
        }
        this.f5126e.setAdapter(this.f5127f);
        PlaybackGlueHost.HostCallback hostCallback = this.f5122a;
        if (hostCallback != null) {
            hostCallback.onHostStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        PlaybackGlueHost.HostCallback hostCallback = this.f5122a;
        if (hostCallback != null) {
            hostCallback.onHostStop();
        }
        super.onStop();
    }

    public void onVideoSizeChanged(int i, int i2) {
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5105E = true;
        if (!this.f5104D) {
            m1327j(false, false);
            this.f5104D = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void resetFocus() {
        ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) m1321b().findViewHolderForAdapterPosition(0);
        if (viewHolder != null && (viewHolder.getPresenter() instanceof PlaybackRowPresenter)) {
            ((PlaybackRowPresenter) viewHolder.getPresenter()).onReappear((RowPresenter.ViewHolder) viewHolder.getViewHolder());
        }
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.f5127f = objectAdapter;
        m1326i();
        m1325h();
        m1323f();
        RowsFragment rowsFragment = this.f5126e;
        if (rowsFragment != null) {
            rowsFragment.setAdapter(objectAdapter);
        }
    }

    public void setBackgroundType(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Invalid background type");
        }
        if (i != this.f5140s) {
            this.f5140s = i;
            m1328k();
        }
    }

    public void setControlsOverlayAutoHideEnabled(boolean z) {
        if (z != this.f5103C) {
            this.f5103C = z;
            if (isResumed() && getView().hasFocus()) {
                showControlsOverlay(true);
                HandlerC1714q7 handlerC1714q7 = this.f5115O;
                if (z) {
                    int i = this.f5143v;
                    if (handlerC1714q7 != null) {
                        handlerC1714q7.removeMessages(1);
                        handlerC1714q7.sendEmptyMessageDelayed(1, i);
                        return;
                    }
                    return;
                }
                if (handlerC1714q7 != null) {
                    handlerC1714q7.removeMessages(1);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setFadeCompleteListener(OnFadeCompleteListener onFadeCompleteListener) {
        this.f5101A = onFadeCompleteListener;
    }

    @Deprecated
    public void setFadingEnabled(boolean z) {
        setControlsOverlayAutoHideEnabled(z);
    }

    public void setHostCallback(PlaybackGlueHost.HostCallback hostCallback) {
        this.f5122a = hostCallback;
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.f5131j = baseOnItemViewClickedListener;
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.f5130i = baseOnItemViewSelectedListener;
    }

    public final void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
        this.f5102B = onKeyListener;
    }

    public void setOnPlaybackItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.f5132k = baseOnItemViewClickedListener;
    }

    public void setPlaybackRow(Row row) {
        this.f5129h = row;
        m1326i();
        m1325h();
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.f5128g = playbackRowPresenter;
        m1325h();
        m1323f();
    }

    public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
        this.f5123b = client;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setShowOrHideControlsOverlayOnUserInteraction(boolean z) {
        this.f5106F = z;
    }

    public void showControlsOverlay(boolean z) {
        m1327j(true, z);
    }

    public void tickle() {
        HandlerC1714q7 handlerC1714q7 = this.f5115O;
        if (handlerC1714q7 != null) {
            handlerC1714q7.removeMessages(1);
        }
        showControlsOverlay(true);
        int i = this.f5144w;
        if (i > 0 && this.f5103C && handlerC1714q7 != null) {
            handlerC1714q7.removeMessages(1);
            handlerC1714q7.sendEmptyMessageDelayed(1, i);
        }
    }

    public void setSelectedPosition(int i, boolean z) {
        b30 b30Var = this.f5135n;
        b30Var.f7877b = i;
        b30Var.f7878c = z;
        if (getView() == null || getView().getHandler() == null) {
            return;
        }
        getView().getHandler().post(b30Var);
    }
}
