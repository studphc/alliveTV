package com.google.android.exoplayer2.p003ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ForwardingPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.do2;
import p000.mp2;
import p000.np2;
import p000.pp2;

/* loaded from: classes.dex */
public class StyledPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    /* renamed from: y0 */
    public static final float[] f12178y0;

    /* renamed from: A */
    public final Drawable f12179A;

    /* renamed from: B */
    public final Drawable f12180B;

    /* renamed from: C */
    public final float f12181C;

    /* renamed from: D */
    public final float f12182D;

    /* renamed from: E */
    public final String f12183E;

    /* renamed from: F */
    public final String f12184F;

    /* renamed from: G */
    public final Drawable f12185G;

    /* renamed from: H */
    public final Drawable f12186H;

    /* renamed from: I */
    public final String f12187I;

    /* renamed from: J */
    public final String f12188J;

    /* renamed from: K */
    public final Drawable f12189K;

    /* renamed from: L */
    public final Drawable f12190L;

    /* renamed from: M */
    public final String f12191M;

    /* renamed from: N */
    public final String f12192N;

    /* renamed from: O */
    public Player f12193O;

    /* renamed from: P */
    public ProgressUpdateListener f12194P;

    /* renamed from: Q */
    public OnFullScreenModeChangedListener f12195Q;

    /* renamed from: R */
    public boolean f12196R;

    /* renamed from: S */
    public boolean f12197S;

    /* renamed from: T */
    public boolean f12198T;

    /* renamed from: U */
    public boolean f12199U;

    /* renamed from: V */
    public boolean f12200V;

    /* renamed from: W */
    public int f12201W;

    /* renamed from: a */
    public final ViewOnClickListenerC0724f f12202a;

    /* renamed from: a0 */
    public int f12203a0;

    /* renamed from: b */
    public final CopyOnWriteArrayList f12204b;

    /* renamed from: b0 */
    public int f12205b0;

    /* renamed from: c */
    public final View f12206c;

    /* renamed from: c0 */
    public long[] f12207c0;

    /* renamed from: d */
    public final View f12208d;

    /* renamed from: d0 */
    public boolean[] f12209d0;

    /* renamed from: e */
    public final View f12210e;

    /* renamed from: e0 */
    public long[] f12211e0;

    /* renamed from: f */
    public final View f12212f;

    /* renamed from: f0 */
    public boolean[] f12213f0;

    /* renamed from: g */
    public final View f12214g;

    /* renamed from: g0 */
    public long f12215g0;

    /* renamed from: h */
    public final TextView f12216h;

    /* renamed from: h0 */
    public final C0731m f12217h0;

    /* renamed from: i */
    public final TextView f12218i;

    /* renamed from: i0 */
    public final Resources f12219i0;

    /* renamed from: j */
    public final ImageView f12220j;

    /* renamed from: j0 */
    public final RecyclerView f12221j0;

    /* renamed from: k */
    public final ImageView f12222k;

    /* renamed from: k0 */
    public final C0727i f12223k0;

    /* renamed from: l */
    public final View f12224l;

    /* renamed from: l0 */
    public final C0725g f12225l0;

    /* renamed from: m */
    public final TextView f12226m;

    /* renamed from: m0 */
    public final PopupWindow f12227m0;

    /* renamed from: n */
    public final TextView f12228n;

    /* renamed from: n0 */
    public boolean f12229n0;

    /* renamed from: o */
    public final TimeBar f12230o;

    /* renamed from: o0 */
    public final int f12231o0;

    /* renamed from: p */
    public final StringBuilder f12232p;

    /* renamed from: p0 */
    public final C0729k f12233p0;

    /* renamed from: q */
    public final Formatter f12234q;

    /* renamed from: q0 */
    public final C0723e f12235q0;

    /* renamed from: r */
    public final Timeline.Period f12236r;

    /* renamed from: r0 */
    public final DefaultTrackNameProvider f12237r0;

    /* renamed from: s */
    public final Timeline.Window f12238s;

    /* renamed from: s0 */
    public final ImageView f12239s0;

    /* renamed from: t */
    public final do2 f12240t;

    /* renamed from: t0 */
    public final ImageView f12241t0;

    /* renamed from: u */
    public final Drawable f12242u;

    /* renamed from: u0 */
    public final ImageView f12243u0;

    /* renamed from: v */
    public final Drawable f12244v;

    /* renamed from: v0 */
    public final View f12245v0;

    /* renamed from: w */
    public final Drawable f12246w;

    /* renamed from: w0 */
    public final View f12247w0;

    /* renamed from: x */
    public final String f12248x;

    /* renamed from: x0 */
    public final View f12249x0;

    /* renamed from: y */
    public final String f12250y;

    /* renamed from: z */
    public final String f12251z;

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnFullScreenModeChangedListener {
        void onFullScreenModeChanged(boolean z);
    }

    /* loaded from: classes.dex */
    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
        f12178y0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static void m2926a(StyledPlayerControlView styledPlayerControlView) {
        if (styledPlayerControlView.f12195Q != null) {
            boolean z = styledPlayerControlView.f12196R;
            styledPlayerControlView.f12196R = !z;
            ImageView imageView = styledPlayerControlView.f12241t0;
            String str = styledPlayerControlView.f12192N;
            Drawable drawable = styledPlayerControlView.f12190L;
            String str2 = styledPlayerControlView.f12191M;
            Drawable drawable2 = styledPlayerControlView.f12189K;
            if (imageView != null) {
                if (!z) {
                    imageView.setImageDrawable(drawable2);
                    imageView.setContentDescription(str2);
                } else {
                    imageView.setImageDrawable(drawable);
                    imageView.setContentDescription(str);
                }
            }
            ImageView imageView2 = styledPlayerControlView.f12243u0;
            boolean z2 = styledPlayerControlView.f12196R;
            if (imageView2 != null) {
                if (z2) {
                    imageView2.setImageDrawable(drawable2);
                    imageView2.setContentDescription(str2);
                } else {
                    imageView2.setImageDrawable(drawable);
                    imageView2.setContentDescription(str);
                }
            }
            OnFullScreenModeChangedListener onFullScreenModeChangedListener = styledPlayerControlView.f12195Q;
            if (onFullScreenModeChangedListener != null) {
                onFullScreenModeChangedListener.onFullScreenModeChanged(styledPlayerControlView.f12196R);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f) {
        Player player = this.f12193O;
        if (player == null) {
            return;
        }
        player.setPlaybackParameters(player.getPlaybackParameters().withSpeed(f));
    }

    @Deprecated
    public void addVisibilityListener(VisibilityListener visibilityListener) {
        Assertions.checkNotNull(visibilityListener);
        this.f12204b.add(visibilityListener);
    }

    /* renamed from: c */
    public final void m2928c(RecyclerView.Adapter adapter) {
        this.f12221j0.setAdapter(adapter);
        m2937l();
        this.f12229n0 = false;
        PopupWindow popupWindow = this.f12227m0;
        popupWindow.dismiss();
        this.f12229n0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i = this.f12231o0;
        popupWindow.showAsDropDown(this, width - i, (-popupWindow.getHeight()) - i);
    }

    /* renamed from: d */
    public final ImmutableList m2929d(Tracks tracks, int i) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Tracks.Group> groups = tracks.getGroups();
        for (int i2 = 0; i2 < groups.size(); i2++) {
            Tracks.Group group = groups.get(i2);
            if (group.getType() == i) {
                for (int i3 = 0; i3 < group.length; i3++) {
                    if (group.isTrackSupported(i3)) {
                        Format trackFormat = group.getTrackFormat(i3);
                        if ((trackFormat.selectionFlags & 2) == 0) {
                            builder.add((ImmutableList.Builder) new pp2(tracks, i2, i3, this.f12237r0.getTrackName(trackFormat)));
                        }
                    }
                }
            }
        }
        return builder.build();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!dispatchMediaKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.f12193O;
        if (player != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (player.getPlaybackState() != 4) {
                            player.seekForward();
                        }
                    } else if (keyCode == 89) {
                        player.seekBack();
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode != 79 && keyCode != 85) {
                            if (keyCode != 87) {
                                if (keyCode != 88) {
                                    if (keyCode != 126) {
                                        if (keyCode == 127) {
                                            player.pause();
                                        }
                                    } else {
                                        int playbackState = player.getPlaybackState();
                                        if (playbackState == 1) {
                                            player.prepare();
                                        } else if (playbackState == 4) {
                                            player.seekTo(player.getCurrentMediaItemIndex(), C0643C.TIME_UNSET);
                                        }
                                        player.play();
                                    }
                                } else {
                                    player.seekToPrevious();
                                }
                            } else {
                                player.seekToNext();
                            }
                        } else {
                            int playbackState2 = player.getPlaybackState();
                            if (playbackState2 != 1 && playbackState2 != 4 && player.getPlayWhenReady()) {
                                player.pause();
                            } else {
                                int playbackState3 = player.getPlaybackState();
                                if (playbackState3 == 1) {
                                    player.prepare();
                                } else if (playbackState3 == 4) {
                                    player.seekTo(player.getCurrentMediaItemIndex(), C0643C.TIME_UNSET);
                                }
                                player.play();
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: e */
    public final void m2930e() {
        m2933h();
        m2932g();
        m2936k();
        m2938m();
        m2940o();
        m2934i();
        m2939n();
    }

    /* renamed from: f */
    public final void m2931f(View view, boolean z) {
        float f;
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        if (z) {
            f = this.f12181C;
        } else {
            f = this.f12182D;
        }
        view.setAlpha(f);
    }

    /* renamed from: g */
    public final void m2932g() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        long j;
        long j2;
        if (isVisible() && this.f12197S) {
            Player player = this.f12193O;
            if (player != null) {
                z2 = player.isCommandAvailable(5);
                z3 = player.isCommandAvailable(7);
                z4 = player.isCommandAvailable(11);
                z5 = player.isCommandAvailable(12);
                z = player.isCommandAvailable(9);
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            Resources resources = this.f12219i0;
            View view = this.f12214g;
            if (z4) {
                Player player2 = this.f12193O;
                if (player2 != null) {
                    j2 = player2.getSeekBackIncrement();
                } else {
                    j2 = 5000;
                }
                int i = (int) (j2 / 1000);
                TextView textView = this.f12218i;
                if (textView != null) {
                    textView.setText(String.valueOf(i));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_rewind_by_amount_description, i, Integer.valueOf(i)));
                }
            }
            View view2 = this.f12212f;
            if (z5) {
                Player player3 = this.f12193O;
                if (player3 != null) {
                    j = player3.getSeekForwardIncrement();
                } else {
                    j = C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
                }
                int i2 = (int) (j / 1000);
                TextView textView2 = this.f12216h;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(i2));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(R.plurals.exo_controls_fastforward_by_amount_description, i2, Integer.valueOf(i2)));
                }
            }
            m2931f(this.f12206c, z3);
            m2931f(view, z4);
            m2931f(view2, z5);
            m2931f(this.f12208d, z);
            TimeBar timeBar = this.f12230o;
            if (timeBar != null) {
                timeBar.setEnabled(z2);
            }
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.f12193O;
    }

    public int getRepeatToggleModes() {
        return this.f12205b0;
    }

    public boolean getShowShuffleButton() {
        return this.f12217h0.m2968b(this.f12222k);
    }

    public boolean getShowSubtitleButton() {
        return this.f12217h0.m2968b(this.f12239s0);
    }

    public int getShowTimeoutMs() {
        return this.f12201W;
    }

    public boolean getShowVrButton() {
        return this.f12217h0.m2968b(this.f12224l);
    }

    /* renamed from: h */
    public final void m2933h() {
        View view;
        if (isVisible() && this.f12197S && (view = this.f12210e) != null) {
            Player player = this.f12193O;
            Resources resources = this.f12219i0;
            if (player != null && player.getPlaybackState() != 4 && this.f12193O.getPlaybackState() != 1 && this.f12193O.getPlayWhenReady()) {
                ((ImageView) view).setImageDrawable(resources.getDrawable(R.drawable.exo_styled_controls_pause));
                view.setContentDescription(resources.getString(R.string.exo_controls_pause_description));
            } else {
                ((ImageView) view).setImageDrawable(resources.getDrawable(R.drawable.exo_styled_controls_play));
                view.setContentDescription(resources.getString(R.string.exo_controls_play_description));
            }
        }
    }

    public void hide() {
        C0731m c0731m = this.f12217h0;
        int i = c0731m.f12381z;
        if (i != 3 && i != 2) {
            c0731m.m2970f();
            if (!c0731m.f12355C) {
                c0731m.m2973i(2);
            } else if (c0731m.f12381z == 1) {
                c0731m.f12368m.start();
            } else {
                c0731m.f12369n.start();
            }
        }
    }

    public void hideImmediately() {
        C0731m c0731m = this.f12217h0;
        int i = c0731m.f12381z;
        if (i != 3 && i != 2) {
            c0731m.m2970f();
            c0731m.m2973i(2);
        }
    }

    /* renamed from: i */
    public final void m2934i() {
        Player player = this.f12193O;
        if (player == null) {
            return;
        }
        float f = player.getPlaybackParameters().speed;
        float f2 = Float.MAX_VALUE;
        int i = 0;
        int i2 = 0;
        while (true) {
            C0725g c0725g = this.f12225l0;
            float[] fArr = c0725g.f12337e;
            if (i < fArr.length) {
                float abs = Math.abs(f - fArr[i]);
                if (abs < f2) {
                    i2 = i;
                    f2 = abs;
                }
                i++;
            } else {
                c0725g.f12338f = i2;
                this.f12223k0.f12345e[0] = c0725g.f12336d[c0725g.f12338f];
                return;
            }
        }
    }

    public boolean isAnimationEnabled() {
        return this.f12217h0.f12355C;
    }

    public boolean isFullyVisible() {
        C0731m c0731m = this.f12217h0;
        if (c0731m.f12381z == 0 && c0731m.f12356a.isVisible()) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final void m2935j() {
        long j;
        long j2;
        int playbackState;
        long j3;
        if (isVisible() && this.f12197S) {
            Player player = this.f12193O;
            if (player != null) {
                j = player.getContentPosition() + this.f12215g0;
                j2 = player.getContentBufferedPosition() + this.f12215g0;
            } else {
                j = 0;
                j2 = 0;
            }
            TextView textView = this.f12228n;
            if (textView != null && !this.f12200V) {
                textView.setText(Util.getStringForTime(this.f12232p, this.f12234q, j));
            }
            TimeBar timeBar = this.f12230o;
            if (timeBar != null) {
                timeBar.setPosition(j);
                timeBar.setBufferedPosition(j2);
            }
            ProgressUpdateListener progressUpdateListener = this.f12194P;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(j, j2);
            }
            do2 do2Var = this.f12240t;
            removeCallbacks(do2Var);
            if (player == null) {
                playbackState = 1;
            } else {
                playbackState = player.getPlaybackState();
            }
            long j4 = 1000;
            if (player != null && player.isPlaying()) {
                if (timeBar != null) {
                    j3 = timeBar.getPreferredUpdateDelay();
                } else {
                    j3 = 1000;
                }
                long min = Math.min(j3, 1000 - (j % 1000));
                float f = player.getPlaybackParameters().speed;
                if (f > RecyclerView.f7068F0) {
                    j4 = ((float) min) / f;
                }
                postDelayed(do2Var, Util.constrainValue(j4, this.f12203a0, 1000L));
                return;
            }
            if (playbackState != 4 && playbackState != 1) {
                postDelayed(do2Var, 1000L);
            }
        }
    }

    /* renamed from: k */
    public final void m2936k() {
        ImageView imageView;
        if (isVisible() && this.f12197S && (imageView = this.f12220j) != null) {
            if (this.f12205b0 == 0) {
                m2931f(imageView, false);
                return;
            }
            Player player = this.f12193O;
            String str = this.f12248x;
            Drawable drawable = this.f12242u;
            if (player == null) {
                m2931f(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            m2931f(imageView, true);
            int repeatMode = player.getRepeatMode();
            if (repeatMode != 0) {
                if (repeatMode != 1) {
                    if (repeatMode == 2) {
                        imageView.setImageDrawable(this.f12246w);
                        imageView.setContentDescription(this.f12251z);
                        return;
                    }
                    return;
                }
                imageView.setImageDrawable(this.f12244v);
                imageView.setContentDescription(this.f12250y);
                return;
            }
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str);
        }
    }

    /* renamed from: l */
    public final void m2937l() {
        RecyclerView recyclerView = this.f12221j0;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i = this.f12231o0;
        int min = Math.min(recyclerView.getMeasuredWidth(), width - (i * 2));
        PopupWindow popupWindow = this.f12227m0;
        popupWindow.setWidth(min);
        popupWindow.setHeight(Math.min(getHeight() - (i * 2), recyclerView.getMeasuredHeight()));
    }

    /* renamed from: m */
    public final void m2938m() {
        ImageView imageView;
        if (isVisible() && this.f12197S && (imageView = this.f12222k) != null) {
            Player player = this.f12193O;
            if (!this.f12217h0.m2968b(imageView)) {
                m2931f(imageView, false);
                return;
            }
            String str = this.f12184F;
            Drawable drawable = this.f12180B;
            if (player == null) {
                m2931f(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            m2931f(imageView, true);
            if (player.getShuffleModeEnabled()) {
                drawable = this.f12179A;
            }
            imageView.setImageDrawable(drawable);
            if (player.getShuffleModeEnabled()) {
                str = this.f12183E;
            }
            imageView.setContentDescription(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0109  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2939n() {
        boolean z;
        Timeline currentTimeline;
        int i;
        TextView textView;
        TimeBar timeBar;
        int i2;
        int i3;
        int length;
        Player player = this.f12193O;
        if (player == null) {
            return;
        }
        boolean z2 = this.f12198T;
        long j = C0643C.TIME_UNSET;
        Timeline.Window window = this.f12238s;
        boolean z3 = true;
        if (z2) {
            Timeline currentTimeline2 = player.getCurrentTimeline();
            if (currentTimeline2.getWindowCount() <= 100) {
                int windowCount = currentTimeline2.getWindowCount();
                for (int i4 = 0; i4 < windowCount; i4++) {
                    if (currentTimeline2.getWindow(i4, window).durationUs != C0643C.TIME_UNSET) {
                    }
                }
                z = true;
                this.f12199U = z;
                long j2 = 0;
                this.f12215g0 = 0L;
                currentTimeline = player.getCurrentTimeline();
                if (currentTimeline.isEmpty()) {
                    int currentMediaItemIndex = player.getCurrentMediaItemIndex();
                    boolean z4 = this.f12199U;
                    if (z4) {
                        i2 = 0;
                    } else {
                        i2 = currentMediaItemIndex;
                    }
                    if (z4) {
                        i3 = currentTimeline.getWindowCount() - 1;
                    } else {
                        i3 = currentMediaItemIndex;
                    }
                    long j3 = 0;
                    i = 0;
                    while (true) {
                        if (i2 > i3) {
                            break;
                        }
                        if (i2 == currentMediaItemIndex) {
                            this.f12215g0 = Util.usToMs(j3);
                        }
                        currentTimeline.getWindow(i2, window);
                        if (window.durationUs == j) {
                            Assertions.checkState(this.f12199U ^ z3);
                            break;
                        }
                        int i5 = window.firstPeriodIndex;
                        while (i5 <= window.lastPeriodIndex) {
                            Timeline.Period period = this.f12236r;
                            currentTimeline.getPeriod(i5, period);
                            int removedAdGroupCount = period.getRemovedAdGroupCount();
                            int adGroupCount = period.getAdGroupCount();
                            int i6 = removedAdGroupCount;
                            while (i6 < adGroupCount) {
                                long adGroupTimeUs = period.getAdGroupTimeUs(i6);
                                int i7 = adGroupCount;
                                if (adGroupTimeUs == Long.MIN_VALUE) {
                                    long j4 = period.durationUs;
                                    if (j4 != j) {
                                        adGroupTimeUs = j4;
                                    } else {
                                        i6++;
                                        adGroupCount = i7;
                                        j = C0643C.TIME_UNSET;
                                    }
                                }
                                long positionInWindowUs = period.getPositionInWindowUs() + adGroupTimeUs;
                                if (positionInWindowUs >= 0) {
                                    long[] jArr = this.f12207c0;
                                    if (i == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f12207c0 = Arrays.copyOf(jArr, length);
                                        this.f12209d0 = Arrays.copyOf(this.f12209d0, length);
                                    }
                                    this.f12207c0[i] = Util.usToMs(positionInWindowUs + j3);
                                    this.f12209d0[i] = period.hasPlayedAdGroup(i6);
                                    i++;
                                }
                                i6++;
                                adGroupCount = i7;
                                j = C0643C.TIME_UNSET;
                            }
                            i5++;
                            j = C0643C.TIME_UNSET;
                        }
                        j3 += window.durationUs;
                        i2++;
                        j = C0643C.TIME_UNSET;
                        z3 = true;
                    }
                    j2 = j3;
                } else {
                    i = 0;
                }
                long usToMs = Util.usToMs(j2);
                textView = this.f12226m;
                if (textView != null) {
                    textView.setText(Util.getStringForTime(this.f12232p, this.f12234q, usToMs));
                }
                timeBar = this.f12230o;
                if (timeBar != null) {
                    timeBar.setDuration(usToMs);
                    int length2 = this.f12211e0.length;
                    int i8 = i + length2;
                    long[] jArr2 = this.f12207c0;
                    if (i8 > jArr2.length) {
                        this.f12207c0 = Arrays.copyOf(jArr2, i8);
                        this.f12209d0 = Arrays.copyOf(this.f12209d0, i8);
                    }
                    System.arraycopy(this.f12211e0, 0, this.f12207c0, i, length2);
                    System.arraycopy(this.f12213f0, 0, this.f12209d0, i, length2);
                    timeBar.setAdGroupTimesMs(this.f12207c0, this.f12209d0, i8);
                }
                m2935j();
            }
        }
        z = false;
        this.f12199U = z;
        long j22 = 0;
        this.f12215g0 = 0L;
        currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
        }
        long usToMs2 = Util.usToMs(j22);
        textView = this.f12226m;
        if (textView != null) {
        }
        timeBar = this.f12230o;
        if (timeBar != null) {
        }
        m2935j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o */
    public final void m2940o() {
        C0729k c0729k = this.f12233p0;
        c0729k.getClass();
        c0729k.f12351d = Collections.emptyList();
        C0723e c0723e = this.f12235q0;
        c0723e.getClass();
        c0723e.f12351d = Collections.emptyList();
        Player player = this.f12193O;
        ImageView imageView = this.f12239s0;
        boolean z = true;
        if (player != null && player.isCommandAvailable(30) && this.f12193O.isCommandAvailable(29)) {
            Tracks currentTracks = this.f12193O.getCurrentTracks();
            ImmutableList m2929d = m2929d(currentTracks, 1);
            c0723e.f12351d = m2929d;
            StyledPlayerControlView styledPlayerControlView = c0723e.f12334f;
            TrackSelectionParameters trackSelectionParameters = ((Player) Assertions.checkNotNull(styledPlayerControlView.f12193O)).getTrackSelectionParameters();
            boolean isEmpty = m2929d.isEmpty();
            C0727i c0727i = styledPlayerControlView.f12223k0;
            if (isEmpty) {
                c0727i.f12345e[1] = styledPlayerControlView.getResources().getString(R.string.exo_track_selection_none);
            } else if (!c0723e.m2961d(trackSelectionParameters)) {
                c0727i.f12345e[1] = styledPlayerControlView.getResources().getString(R.string.exo_track_selection_auto);
            } else {
                int i = 0;
                while (true) {
                    if (i >= m2929d.size()) {
                        break;
                    }
                    pp2 pp2Var = (pp2) m2929d.get(i);
                    if (pp2Var.f25254a.isTrackSelected(pp2Var.f25255b)) {
                        c0727i.f12345e[1] = pp2Var.f25256c;
                        break;
                    }
                    i++;
                }
            }
            if (this.f12217h0.m2968b(imageView)) {
                c0729k.m2963d(m2929d(currentTracks, 3));
            } else {
                c0729k.m2963d(ImmutableList.m3902of());
            }
        }
        if (c0729k.getItemCount() <= 0) {
            z = false;
        }
        m2931f(imageView, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0731m c0731m = this.f12217h0;
        c0731m.f12356a.addOnLayoutChangeListener(c0731m.f12379x);
        this.f12197S = true;
        if (isFullyVisible()) {
            c0731m.m2971g();
        }
        m2930e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0731m c0731m = this.f12217h0;
        c0731m.f12356a.removeOnLayoutChangeListener(c0731m.f12379x);
        this.f12197S = false;
        removeCallbacks(this.f12240t);
        c0731m.m2970f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f12217h0.f12357b;
        if (view != null) {
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Deprecated
    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.f12204b.remove(visibilityListener);
    }

    public void setAnimationEnabled(boolean z) {
        this.f12217h0.f12355C = z;
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.f12211e0 = new long[0];
            this.f12213f0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            if (jArr.length == zArr2.length) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.f12211e0 = jArr;
            this.f12213f0 = zArr2;
        }
        m2939n();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        boolean z;
        this.f12195Q = onFullScreenModeChangedListener;
        boolean z2 = true;
        if (onFullScreenModeChangedListener != null) {
            z = true;
        } else {
            z = false;
        }
        ImageView imageView = this.f12241t0;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        if (onFullScreenModeChangedListener == null) {
            z2 = false;
        }
        ImageView imageView2 = this.f12243u0;
        if (imageView2 != null) {
            if (z2) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    public void setPlayer(@Nullable Player player) {
        boolean z;
        boolean z2 = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (player == null || player.getApplicationLooper() == Looper.getMainLooper()) {
            z2 = true;
        }
        Assertions.checkArgument(z2);
        Player player2 = this.f12193O;
        if (player2 == player) {
            return;
        }
        ViewOnClickListenerC0724f viewOnClickListenerC0724f = this.f12202a;
        if (player2 != null) {
            player2.removeListener(viewOnClickListenerC0724f);
        }
        this.f12193O = player;
        if (player != null) {
            player.addListener(viewOnClickListenerC0724f);
        }
        if (player instanceof ForwardingPlayer) {
            ((ForwardingPlayer) player).getWrappedPlayer();
        }
        m2930e();
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.f12194P = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i) {
        this.f12205b0 = i;
        Player player = this.f12193O;
        boolean z = false;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.f12193O.setRepeatMode(0);
            } else if (i == 1 && repeatMode == 2) {
                this.f12193O.setRepeatMode(1);
            } else if (i == 2 && repeatMode == 1) {
                this.f12193O.setRepeatMode(2);
            }
        }
        if (i != 0) {
            z = true;
        }
        this.f12217h0.m2972h(this.f12220j, z);
        m2936k();
    }

    public void setShowFastForwardButton(boolean z) {
        this.f12217h0.m2972h(this.f12212f, z);
        m2932g();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.f12198T = z;
        m2939n();
    }

    public void setShowNextButton(boolean z) {
        this.f12217h0.m2972h(this.f12208d, z);
        m2932g();
    }

    public void setShowPreviousButton(boolean z) {
        this.f12217h0.m2972h(this.f12206c, z);
        m2932g();
    }

    public void setShowRewindButton(boolean z) {
        this.f12217h0.m2972h(this.f12214g, z);
        m2932g();
    }

    public void setShowShuffleButton(boolean z) {
        this.f12217h0.m2972h(this.f12222k, z);
        m2938m();
    }

    public void setShowSubtitleButton(boolean z) {
        this.f12217h0.m2972h(this.f12239s0, z);
    }

    public void setShowTimeoutMs(int i) {
        this.f12201W = i;
        if (isFullyVisible()) {
            this.f12217h0.m2971g();
        }
    }

    public void setShowVrButton(boolean z) {
        this.f12217h0.m2972h(this.f12224l, z);
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.f12203a0 = Util.constrainValue(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        boolean z;
        View view = this.f12224l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            if (onClickListener != null) {
                z = true;
            } else {
                z = false;
            }
            m2931f(view, z);
        }
    }

    public void show() {
        C0731m c0731m = this.f12217h0;
        StyledPlayerControlView styledPlayerControlView = c0731m.f12356a;
        if (!styledPlayerControlView.isVisible()) {
            styledPlayerControlView.setVisibility(0);
            styledPlayerControlView.m2930e();
            View view = styledPlayerControlView.f12210e;
            if (view != null) {
                view.requestFocus();
            }
        }
        c0731m.m2974k();
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ViewOnClickListenerC0724f viewOnClickListenerC0724f;
        boolean z9;
        boolean z10;
        int i2 = R.layout.exo_styled_player_control_view;
        this.f12201W = 5000;
        int i3 = 0;
        this.f12205b0 = 0;
        this.f12203a0 = 200;
        int i4 = 1;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.StyledPlayerControlView, i, 0);
            try {
                i2 = obtainStyledAttributes.getResourceId(R.styleable.StyledPlayerControlView_controller_layout_id, i2);
                this.f12201W = obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_show_timeout, this.f12201W);
                this.f12205b0 = obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_repeat_toggle_modes, this.f12205b0);
                boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z14 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_next_button, true);
                boolean z15 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z17 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_time_bar_min_update_interval, this.f12203a0));
                boolean z18 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_animation_enabled, true);
                obtainStyledAttributes.recycle();
                z2 = z15;
                z3 = z16;
                z5 = z11;
                z6 = z12;
                z7 = z13;
                z4 = z18;
                z8 = z14;
                z = z17;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = true;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        ViewOnClickListenerC0724f viewOnClickListenerC0724f2 = new ViewOnClickListenerC0724f(this);
        this.f12202a = viewOnClickListenerC0724f2;
        this.f12204b = new CopyOnWriteArrayList();
        this.f12236r = new Timeline.Period();
        this.f12238s = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.f12232p = sb;
        this.f12234q = new Formatter(sb, Locale.getDefault());
        this.f12207c0 = new long[0];
        this.f12209d0 = new boolean[0];
        this.f12211e0 = new long[0];
        this.f12213f0 = new boolean[0];
        this.f12240t = new do2(i4, this);
        this.f12226m = (TextView) findViewById(R.id.exo_duration);
        this.f12228n = (TextView) findViewById(R.id.exo_position);
        ImageView imageView = (ImageView) findViewById(R.id.exo_subtitle);
        this.f12239s0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(viewOnClickListenerC0724f2);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_fullscreen);
        this.f12241t0 = imageView2;
        mp2 mp2Var = new mp2(i3, this);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            imageView2.setOnClickListener(mp2Var);
        }
        ImageView imageView3 = (ImageView) findViewById(R.id.exo_minimal_fullscreen);
        this.f12243u0 = imageView3;
        mp2 mp2Var2 = new mp2(i3, this);
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            imageView3.setOnClickListener(mp2Var2);
        }
        View findViewById = findViewById(R.id.exo_settings);
        this.f12245v0 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(viewOnClickListenerC0724f2);
        }
        View findViewById2 = findViewById(R.id.exo_playback_speed);
        this.f12247w0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(viewOnClickListenerC0724f2);
        }
        View findViewById3 = findViewById(R.id.exo_audio_track);
        this.f12249x0 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(viewOnClickListenerC0724f2);
        }
        int i5 = R.id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i5);
        View findViewById4 = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.f12230o = timeBar;
            viewOnClickListenerC0724f = viewOnClickListenerC0724f2;
            z9 = z4;
            z10 = z;
        } else if (findViewById4 != null) {
            viewOnClickListenerC0724f = viewOnClickListenerC0724f2;
            z9 = z4;
            z10 = z;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R.style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i5);
            defaultTimeBar.setLayoutParams(findViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById4);
            viewGroup.removeView(findViewById4);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f12230o = defaultTimeBar;
        } else {
            viewOnClickListenerC0724f = viewOnClickListenerC0724f2;
            z9 = z4;
            z10 = z;
            this.f12230o = null;
        }
        TimeBar timeBar2 = this.f12230o;
        ViewOnClickListenerC0724f viewOnClickListenerC0724f3 = viewOnClickListenerC0724f;
        if (timeBar2 != null) {
            timeBar2.addListener(viewOnClickListenerC0724f3);
        }
        View findViewById5 = findViewById(R.id.exo_play_pause);
        this.f12210e = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(viewOnClickListenerC0724f3);
        }
        View findViewById6 = findViewById(R.id.exo_prev);
        this.f12206c = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(viewOnClickListenerC0724f3);
        }
        View findViewById7 = findViewById(R.id.exo_next);
        this.f12208d = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(viewOnClickListenerC0724f3);
        }
        Typeface font = ResourcesCompat.getFont(context, R.font.roboto_medium_numbers);
        View findViewById8 = findViewById(R.id.exo_rew);
        TextView textView = findViewById8 == null ? (TextView) findViewById(R.id.exo_rew_with_amount) : null;
        this.f12218i = textView;
        if (textView != null) {
            textView.setTypeface(font);
        }
        findViewById8 = findViewById8 == null ? textView : findViewById8;
        this.f12214g = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(viewOnClickListenerC0724f3);
        }
        View findViewById9 = findViewById(R.id.exo_ffwd);
        TextView textView2 = findViewById9 == null ? (TextView) findViewById(R.id.exo_ffwd_with_amount) : null;
        this.f12216h = textView2;
        if (textView2 != null) {
            textView2.setTypeface(font);
        }
        findViewById9 = findViewById9 == null ? textView2 : findViewById9;
        this.f12212f = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(viewOnClickListenerC0724f3);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f12220j = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(viewOnClickListenerC0724f3);
        }
        ImageView imageView5 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f12222k = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(viewOnClickListenerC0724f3);
        }
        Resources resources = context.getResources();
        this.f12219i0 = resources;
        this.f12181C = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.f12182D = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View findViewById10 = findViewById(R.id.exo_vr);
        this.f12224l = findViewById10;
        if (findViewById10 != null) {
            m2931f(findViewById10, false);
        }
        C0731m c0731m = new C0731m(this);
        this.f12217h0 = c0731m;
        c0731m.f12355C = z9;
        C0727i c0727i = new C0727i(this, new String[]{resources.getString(R.string.exo_controls_playback_speed), resources.getString(R.string.exo_track_selection_title_audio)}, new Drawable[]{resources.getDrawable(R.drawable.exo_styled_controls_speed), resources.getDrawable(R.drawable.exo_styled_controls_audiotrack)});
        this.f12223k0 = c0727i;
        this.f12231o0 = resources.getDimensionPixelSize(R.dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.exo_styled_settings_list, (ViewGroup) null);
        this.f12221j0 = recyclerView;
        recyclerView.setAdapter(c0727i);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.f12227m0 = popupWindow;
        if (Util.SDK_INT < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(viewOnClickListenerC0724f3);
        this.f12229n0 = true;
        this.f12237r0 = new DefaultTrackNameProvider(getResources());
        this.f12185G = resources.getDrawable(R.drawable.exo_styled_controls_subtitle_on);
        this.f12186H = resources.getDrawable(R.drawable.exo_styled_controls_subtitle_off);
        this.f12187I = resources.getString(R.string.exo_controls_cc_enabled_description);
        this.f12188J = resources.getString(R.string.exo_controls_cc_disabled_description);
        this.f12233p0 = new C0729k(this);
        this.f12235q0 = new C0723e(this);
        this.f12225l0 = new C0725g(this, resources.getStringArray(R.array.exo_controls_playback_speeds), f12178y0);
        this.f12189K = resources.getDrawable(R.drawable.exo_styled_controls_fullscreen_exit);
        this.f12190L = resources.getDrawable(R.drawable.exo_styled_controls_fullscreen_enter);
        this.f12242u = resources.getDrawable(R.drawable.exo_styled_controls_repeat_off);
        this.f12244v = resources.getDrawable(R.drawable.exo_styled_controls_repeat_one);
        this.f12246w = resources.getDrawable(R.drawable.exo_styled_controls_repeat_all);
        this.f12179A = resources.getDrawable(R.drawable.exo_styled_controls_shuffle_on);
        this.f12180B = this.f12219i0.getDrawable(R.drawable.exo_styled_controls_shuffle_off);
        this.f12191M = this.f12219i0.getString(R.string.exo_controls_fullscreen_exit_description);
        this.f12192N = this.f12219i0.getString(R.string.exo_controls_fullscreen_enter_description);
        this.f12248x = this.f12219i0.getString(R.string.exo_controls_repeat_off_description);
        this.f12250y = this.f12219i0.getString(R.string.exo_controls_repeat_one_description);
        this.f12251z = this.f12219i0.getString(R.string.exo_controls_repeat_all_description);
        this.f12183E = this.f12219i0.getString(R.string.exo_controls_shuffle_on_description);
        this.f12184F = this.f12219i0.getString(R.string.exo_controls_shuffle_off_description);
        this.f12217h0.m2972h((ViewGroup) findViewById(R.id.exo_bottom_bar), true);
        this.f12217h0.m2972h(this.f12212f, z6);
        this.f12217h0.m2972h(this.f12214g, z5);
        this.f12217h0.m2972h(this.f12206c, z7);
        this.f12217h0.m2972h(this.f12208d, z8);
        this.f12217h0.m2972h(this.f12222k, z2);
        this.f12217h0.m2972h(this.f12239s0, z3);
        this.f12217h0.m2972h(this.f12224l, z10);
        this.f12217h0.m2972h(this.f12220j, this.f12205b0 != 0);
        addOnLayoutChangeListener(new np2(0, this));
    }
}
