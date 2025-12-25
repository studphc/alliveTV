package androidx.leanback.app;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import p000.o52;
import p000.p52;
import p000.q52;
import p000.r52;
import p000.s52;
import p000.t52;
import p000.u52;
import p000.v52;

/* loaded from: classes.dex */
public class PlaybackSupportFragment extends Fragment {
    public static final int BG_DARK = 1;
    public static final int BG_LIGHT = 2;
    public static final int BG_NONE = 0;

    /* renamed from: A0 */
    public int f5150A0;

    /* renamed from: B0 */
    public int f5151B0;

    /* renamed from: C0 */
    public int f5152C0;

    /* renamed from: D0 */
    public int f5153D0;

    /* renamed from: E0 */
    public OnFadeCompleteListener f5154E0;

    /* renamed from: F0 */
    public View.OnKeyListener f5155F0;

    /* renamed from: G0 */
    public boolean f5156G0;

    /* renamed from: H0 */
    public boolean f5157H0;

    /* renamed from: I0 */
    public boolean f5158I0;

    /* renamed from: J0 */
    public boolean f5159J0;

    /* renamed from: K0 */
    public int f5160K0;

    /* renamed from: L0 */
    public ValueAnimator f5161L0;

    /* renamed from: M0 */
    public ValueAnimator f5162M0;

    /* renamed from: N0 */
    public ValueAnimator f5163N0;

    /* renamed from: O0 */
    public ValueAnimator f5164O0;

    /* renamed from: P0 */
    public ValueAnimator f5165P0;

    /* renamed from: Q0 */
    public ValueAnimator f5166Q0;

    /* renamed from: R0 */
    public final C0284r f5167R0;

    /* renamed from: S0 */
    public final HandlerC1714q7 f5168S0;

    /* renamed from: T0 */
    public final s52 f5169T0;

    /* renamed from: U0 */
    public final t52 f5170U0;

    /* renamed from: V0 */
    public final LogDecelerateInterpolator f5171V0;

    /* renamed from: W0 */
    public final LogAccelerateInterpolator f5172W0;

    /* renamed from: X0 */
    public final o52 f5173X0;

    /* renamed from: Y0 */
    public final p52 f5174Y0;

    /* renamed from: e0 */
    public PlaybackGlueHost.HostCallback f5175e0;

    /* renamed from: f0 */
    public PlaybackSeekUi.Client f5176f0;

    /* renamed from: g0 */
    public boolean f5177g0;

    /* renamed from: h0 */
    public final ProgressBarManager f5178h0;

    /* renamed from: i0 */
    public RowsSupportFragment f5179i0;

    /* renamed from: j0 */
    public ObjectAdapter f5180j0;

    /* renamed from: k0 */
    public PlaybackRowPresenter f5181k0;

    /* renamed from: l0 */
    public Row f5182l0;

    /* renamed from: m0 */
    public BaseOnItemViewSelectedListener f5183m0;

    /* renamed from: n0 */
    public BaseOnItemViewClickedListener f5184n0;

    /* renamed from: o0 */
    public BaseOnItemViewClickedListener f5185o0;

    /* renamed from: p0 */
    public final q52 f5186p0;

    /* renamed from: q0 */
    public final r52 f5187q0;

    /* renamed from: r0 */
    public final b30 f5188r0;

    /* renamed from: s0 */
    public int f5189s0;

    /* renamed from: t0 */
    public int f5190t0;

    /* renamed from: u0 */
    public View f5191u0;

    /* renamed from: v0 */
    public View f5192v0;

    /* renamed from: w0 */
    public int f5193w0;

    /* renamed from: x0 */
    public int f5194x0;

    /* renamed from: y0 */
    public int f5195y0;

    /* renamed from: z0 */
    public int f5196z0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class OnFadeCompleteListener {
        public void onFadeInComplete() {
        }

        public void onFadeOutComplete() {
        }
    }

    public PlaybackSupportFragment() {
        ProgressBarManager progressBarManager = new ProgressBarManager();
        this.f5178h0 = progressBarManager;
        this.f5186p0 = new q52(this);
        this.f5187q0 = new r52(this);
        this.f5188r0 = new b30(3, this);
        this.f5193w0 = 1;
        this.f5156G0 = true;
        this.f5157H0 = true;
        this.f5158I0 = true;
        this.f5159J0 = true;
        this.f5167R0 = new C0284r(this);
        this.f5168S0 = new HandlerC1714q7(4, this);
        this.f5169T0 = new s52(this);
        this.f5170U0 = new t52(this);
        this.f5171V0 = new LogDecelerateInterpolator(100, 0);
        this.f5172W0 = new LogAccelerateInterpolator(100, 0);
        this.f5173X0 = new o52(this);
        this.f5174Y0 = new p52(this);
        progressBarManager.setInitialDelay(500L);
    }

    /* renamed from: l */
    public static void m1329l(ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        if (valueAnimator.isStarted()) {
            valueAnimator.end();
        } else if (valueAnimator2.isStarted()) {
            valueAnimator2.end();
        }
    }

    /* renamed from: m */
    public static ValueAnimator m1330m(int i, Context context) {
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(context, i);
        valueAnimator.setDuration(valueAnimator.getDuration());
        return valueAnimator;
    }

    /* renamed from: o */
    public static void m1331o(ValueAnimator valueAnimator, ValueAnimator valueAnimator2, boolean z) {
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

    @Deprecated
    public void fadeOut() {
        m1337t(false, false);
    }

    public ObjectAdapter getAdapter() {
        return this.f5180j0;
    }

    public int getBackgroundType() {
        return this.f5193w0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public OnFadeCompleteListener getFadeCompleteListener() {
        return this.f5154E0;
    }

    public ProgressBarManager getProgressBarManager() {
        return this.f5178h0;
    }

    public final VerticalGridView getVerticalGridView() {
        RowsSupportFragment rowsSupportFragment = this.f5179i0;
        if (rowsSupportFragment == null) {
            return null;
        }
        return rowsSupportFragment.getVerticalGridView();
    }

    public void hideControlsOverlay(boolean z) {
        m1337t(false, z);
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.f5156G0;
    }

    public boolean isControlsOverlayVisible() {
        return this.f5158I0;
    }

    @Deprecated
    public boolean isFadingEnabled() {
        return isControlsOverlayAutoHideEnabled();
    }

    public boolean isShowOrHideControlsOverlayOnUserInteraction() {
        return this.f5159J0;
    }

    /* renamed from: n */
    public final boolean m1332n(InputEvent inputEvent) {
        boolean z;
        int i;
        int i2;
        boolean z2 = this.f5158I0;
        if (inputEvent instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) inputEvent;
            i = keyEvent.getKeyCode();
            i2 = keyEvent.getAction();
            View.OnKeyListener onKeyListener = this.f5155F0;
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
                    if (this.f5159J0 && i2 == 0) {
                        tickle();
                        return z;
                    }
                    return z;
                default:
                    if (this.f5159J0 && z && i2 == 0) {
                        tickle();
                        return z;
                    }
                    return z;
            }
        }
        if (this.f5177g0) {
            return false;
        }
        if (this.f5159J0 && z2) {
            if (((KeyEvent) inputEvent).getAction() == 1) {
                hideControlsOverlay(true);
            }
            return true;
        }
        return z;
    }

    public void notifyPlaybackRowChanged() {
        ObjectAdapter objectAdapter = this.f5180j0;
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5190t0 = getResources().getDimensionPixelSize(R.dimen.lb_playback_other_rows_center_to_bottom);
        this.f5189s0 = getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_padding_bottom);
        this.f5194x0 = getResources().getColor(R.color.lb_playback_controls_background_dark);
        this.f5195y0 = getResources().getColor(R.color.lb_playback_controls_background_light);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.playbackControlsAutoHideTimeout, typedValue, true);
        this.f5196z0 = typedValue.data;
        getContext().getTheme().resolveAttribute(R.attr.playbackControlsAutoHideTickleTimeout, typedValue, true);
        this.f5150A0 = typedValue.data;
        this.f5151B0 = getResources().getDimensionPixelSize(R.dimen.lb_playback_major_fade_translate_y);
        this.f5152C0 = getResources().getDimensionPixelSize(R.dimen.lb_playback_minor_fade_translate_y);
        u52 u52Var = new u52(this, 0);
        Context context = getContext();
        ValueAnimator m1330m = m1330m(R.animator.lb_playback_bg_fade_in, context);
        this.f5161L0 = m1330m;
        m1330m.addUpdateListener(u52Var);
        ValueAnimator valueAnimator = this.f5161L0;
        C0284r c0284r = this.f5167R0;
        valueAnimator.addListener(c0284r);
        ValueAnimator m1330m2 = m1330m(R.animator.lb_playback_bg_fade_out, context);
        this.f5162M0 = m1330m2;
        m1330m2.addUpdateListener(u52Var);
        this.f5162M0.addListener(c0284r);
        v52 v52Var = new v52(this);
        Context context2 = getContext();
        int i = R.animator.lb_playback_controls_fade_in;
        ValueAnimator m1330m3 = m1330m(i, context2);
        this.f5163N0 = m1330m3;
        m1330m3.addUpdateListener(v52Var);
        ValueAnimator valueAnimator2 = this.f5163N0;
        LogDecelerateInterpolator logDecelerateInterpolator = this.f5171V0;
        valueAnimator2.setInterpolator(logDecelerateInterpolator);
        int i2 = R.animator.lb_playback_controls_fade_out;
        ValueAnimator m1330m4 = m1330m(i2, context2);
        this.f5164O0 = m1330m4;
        m1330m4.addUpdateListener(v52Var);
        this.f5164O0.setInterpolator(this.f5172W0);
        u52 u52Var2 = new u52(this, 1);
        Context context3 = getContext();
        ValueAnimator m1330m5 = m1330m(i, context3);
        this.f5165P0 = m1330m5;
        m1330m5.addUpdateListener(u52Var2);
        this.f5165P0.setInterpolator(logDecelerateInterpolator);
        ValueAnimator m1330m6 = m1330m(i2, context3);
        this.f5166Q0 = m1330m6;
        m1330m6.addUpdateListener(u52Var2);
        this.f5166Q0.setInterpolator(new AccelerateInterpolator());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lb_playback_fragment, viewGroup, false);
        this.f5191u0 = inflate;
        this.f5192v0 = inflate.findViewById(R.id.playback_fragment_background);
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.playback_controls_dock;
        RowsSupportFragment rowsSupportFragment = (RowsSupportFragment) childFragmentManager.findFragmentById(i);
        this.f5179i0 = rowsSupportFragment;
        if (rowsSupportFragment == null) {
            this.f5179i0 = new RowsSupportFragment();
            getChildFragmentManager().beginTransaction().replace(i, this.f5179i0).commit();
        }
        ObjectAdapter objectAdapter = this.f5180j0;
        if (objectAdapter == null) {
            setAdapter(new ArrayObjectAdapter(new ClassPresenterSelector()));
        } else {
            this.f5179i0.setAdapter(objectAdapter);
        }
        this.f5179i0.setOnItemViewSelectedListener(this.f5187q0);
        this.f5179i0.setOnItemViewClickedListener(this.f5186p0);
        this.f5160K0 = 255;
        m1338u();
        this.f5179i0.f5236z0 = this.f5173X0;
        ProgressBarManager progressBarManager = getProgressBarManager();
        if (progressBarManager != null) {
            progressBarManager.setRootView((ViewGroup) this.f5191u0);
        }
        return this.f5191u0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        PlaybackGlueHost.HostCallback hostCallback = this.f5175e0;
        if (hostCallback != null) {
            hostCallback.onHostDestroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f5191u0 = null;
        this.f5192v0 = null;
        super.onDestroyView();
    }

    public void onError(int i, CharSequence charSequence) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        PlaybackGlueHost.HostCallback hostCallback = this.f5175e0;
        if (hostCallback != null) {
            hostCallback.onHostPause();
        }
        HandlerC1714q7 handlerC1714q7 = this.f5168S0;
        if (handlerC1714q7.hasMessages(1)) {
            handlerC1714q7.removeMessages(1);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f5158I0 && this.f5156G0) {
            int i = this.f5196z0;
            HandlerC1714q7 handlerC1714q7 = this.f5168S0;
            if (handlerC1714q7 != null) {
                handlerC1714q7.removeMessages(1);
                handlerC1714q7.sendEmptyMessageDelayed(1, i);
            }
        }
        getVerticalGridView().setOnTouchInterceptListener(this.f5169T0);
        getVerticalGridView().setOnKeyInterceptListener(this.f5170U0);
        PlaybackGlueHost.HostCallback hostCallback = this.f5175e0;
        if (hostCallback != null) {
            hostCallback.onHostResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.f5179i0.getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setWindowAlignmentOffset(-this.f5189s0);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffset(this.f5190t0 - this.f5189s0);
            verticalGridView.setItemAlignmentOffsetPercent(50.0f);
            verticalGridView.setPadding(verticalGridView.getPaddingLeft(), verticalGridView.getPaddingTop(), verticalGridView.getPaddingRight(), this.f5189s0);
            verticalGridView.setWindowAlignment(2);
        }
        this.f5179i0.setAdapter(this.f5180j0);
        PlaybackGlueHost.HostCallback hostCallback = this.f5175e0;
        if (hostCallback != null) {
            hostCallback.onHostStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        PlaybackGlueHost.HostCallback hostCallback = this.f5175e0;
        if (hostCallback != null) {
            hostCallback.onHostStop();
        }
        super.onStop();
    }

    public void onVideoSizeChanged(int i, int i2) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5158I0 = true;
        if (!this.f5157H0) {
            m1337t(false, false);
            this.f5157H0 = true;
        }
    }

    /* renamed from: p */
    public final void m1333p() {
        Presenter[] presenters;
        ObjectAdapter objectAdapter = this.f5180j0;
        if (objectAdapter != null && objectAdapter.getPresenterSelector() != null && (presenters = this.f5180j0.getPresenterSelector().getPresenters()) != null) {
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

    /* renamed from: q */
    public final void m1334q(boolean z) {
        int i;
        HandlerC1714q7 handlerC1714q7;
        if (this.f5177g0 == z) {
            return;
        }
        this.f5177g0 = z;
        getVerticalGridView().setSelectedPosition(0);
        if (this.f5177g0 && (handlerC1714q7 = this.f5168S0) != null) {
            handlerC1714q7.removeMessages(1);
        }
        showControlsOverlay(true);
        int childCount = getVerticalGridView().getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getVerticalGridView().getChildAt(i2);
            if (getVerticalGridView().getChildAdapterPosition(childAt) > 0) {
                if (this.f5177g0) {
                    i = 4;
                } else {
                    i = 0;
                }
                childAt.setVisibility(i);
            }
        }
    }

    /* renamed from: r */
    public final void m1335r() {
        ObjectAdapter objectAdapter = this.f5180j0;
        if (objectAdapter != null && this.f5182l0 != null && this.f5181k0 != null) {
            PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
            if (presenterSelector == null) {
                ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
                classPresenterSelector.addClassPresenter(this.f5182l0.getClass(), this.f5181k0);
                this.f5180j0.setPresenterSelector(classPresenterSelector);
            } else if (presenterSelector instanceof ClassPresenterSelector) {
                ((ClassPresenterSelector) presenterSelector).addClassPresenter(this.f5182l0.getClass(), this.f5181k0);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void resetFocus() {
        ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) getVerticalGridView().findViewHolderForAdapterPosition(0);
        if (viewHolder != null && (viewHolder.getPresenter() instanceof PlaybackRowPresenter)) {
            ((PlaybackRowPresenter) viewHolder.getPresenter()).onReappear((RowPresenter.ViewHolder) viewHolder.getViewHolder());
        }
    }

    /* renamed from: s */
    public final void m1336s() {
        Row row;
        ObjectAdapter objectAdapter = this.f5180j0;
        if ((objectAdapter instanceof ArrayObjectAdapter) && this.f5182l0 != null) {
            ArrayObjectAdapter arrayObjectAdapter = (ArrayObjectAdapter) objectAdapter;
            if (arrayObjectAdapter.size() == 0) {
                arrayObjectAdapter.add(this.f5182l0);
                return;
            } else {
                arrayObjectAdapter.replace(0, this.f5182l0);
                return;
            }
        }
        if ((objectAdapter instanceof SparseArrayObjectAdapter) && (row = this.f5182l0) != null) {
            ((SparseArrayObjectAdapter) objectAdapter).set(0, row);
        }
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.f5180j0 = objectAdapter;
        m1336s();
        m1335r();
        m1333p();
        RowsSupportFragment rowsSupportFragment = this.f5179i0;
        if (rowsSupportFragment != null) {
            rowsSupportFragment.setAdapter(objectAdapter);
        }
    }

    public void setBackgroundType(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Invalid background type");
        }
        if (i != this.f5193w0) {
            this.f5193w0 = i;
            m1338u();
        }
    }

    public void setControlsOverlayAutoHideEnabled(boolean z) {
        if (z != this.f5156G0) {
            this.f5156G0 = z;
            if (isResumed() && getView().hasFocus()) {
                showControlsOverlay(true);
                HandlerC1714q7 handlerC1714q7 = this.f5168S0;
                if (z) {
                    int i = this.f5196z0;
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
        this.f5154E0 = onFadeCompleteListener;
    }

    @Deprecated
    public void setFadingEnabled(boolean z) {
        setControlsOverlayAutoHideEnabled(z);
    }

    public void setHostCallback(PlaybackGlueHost.HostCallback hostCallback) {
        this.f5175e0 = hostCallback;
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.f5184n0 = baseOnItemViewClickedListener;
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.f5183m0 = baseOnItemViewSelectedListener;
    }

    public final void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
        this.f5155F0 = onKeyListener;
    }

    public void setOnPlaybackItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.f5185o0 = baseOnItemViewClickedListener;
    }

    public void setPlaybackRow(Row row) {
        this.f5182l0 = row;
        m1336s();
        m1335r();
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.f5181k0 = playbackRowPresenter;
        m1335r();
        m1333p();
    }

    public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
        this.f5176f0 = client;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void setShowOrHideControlsOverlayOnUserInteraction(boolean z) {
        this.f5159J0 = z;
    }

    public void showControlsOverlay(boolean z) {
        m1337t(true, z);
    }

    /* renamed from: t */
    public final void m1337t(boolean z, boolean z2) {
        int i;
        int i2;
        HandlerC1714q7 handlerC1714q7;
        if (getView() == null) {
            this.f5157H0 = z;
            return;
        }
        if (!isResumed()) {
            z2 = false;
        }
        if (z == this.f5158I0) {
            if (!z2) {
                m1329l(this.f5161L0, this.f5162M0);
                m1329l(this.f5163N0, this.f5164O0);
                m1329l(this.f5165P0, this.f5166Q0);
                return;
            }
            return;
        }
        this.f5158I0 = z;
        if (!z && (handlerC1714q7 = this.f5168S0) != null) {
            handlerC1714q7.removeMessages(1);
        }
        if (getVerticalGridView() != null && getVerticalGridView().getSelectedPosition() != 0) {
            i = this.f5152C0;
        } else {
            i = this.f5151B0;
        }
        this.f5153D0 = i;
        if (z) {
            m1331o(this.f5162M0, this.f5161L0, z2);
            m1331o(this.f5164O0, this.f5163N0, z2);
            m1331o(this.f5166Q0, this.f5165P0, z2);
        } else {
            m1331o(this.f5161L0, this.f5162M0, z2);
            m1331o(this.f5163N0, this.f5164O0, z2);
            m1331o(this.f5165P0, this.f5166Q0, z2);
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

    public void tickle() {
        HandlerC1714q7 handlerC1714q7 = this.f5168S0;
        if (handlerC1714q7 != null) {
            handlerC1714q7.removeMessages(1);
        }
        showControlsOverlay(true);
        int i = this.f5150A0;
        if (i > 0 && this.f5156G0 && handlerC1714q7 != null) {
            handlerC1714q7.removeMessages(1);
            handlerC1714q7.sendEmptyMessageDelayed(1, i);
        }
    }

    /* renamed from: u */
    public final void m1338u() {
        View view = this.f5192v0;
        if (view != null) {
            int i = this.f5194x0;
            int i2 = this.f5193w0;
            if (i2 != 0) {
                if (i2 == 2) {
                    i = this.f5195y0;
                }
            } else {
                i = 0;
            }
            view.setBackground(new ColorDrawable(i));
            int i3 = this.f5160K0;
            this.f5160K0 = i3;
            View view2 = this.f5192v0;
            if (view2 != null) {
                view2.getBackground().setAlpha(i3);
            }
        }
    }

    public void setSelectedPosition(int i, boolean z) {
        b30 b30Var = this.f5188r0;
        b30Var.f7877b = i;
        b30Var.f7878c = z;
        if (getView() == null || getView().getHandler() == null) {
            return;
        }
        getView().getHandler().post(b30Var);
    }
}
