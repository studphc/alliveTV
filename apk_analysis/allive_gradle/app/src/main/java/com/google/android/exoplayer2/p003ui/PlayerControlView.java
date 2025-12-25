package com.google.android.exoplayer2.p003ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p003ui.PlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.e62;
import p000.f62;

/* loaded from: classes.dex */
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    /* renamed from: A */
    public final Drawable f12055A;

    /* renamed from: B */
    public final Drawable f12056B;

    /* renamed from: C */
    public final float f12057C;

    /* renamed from: D */
    public final float f12058D;

    /* renamed from: E */
    public final String f12059E;

    /* renamed from: F */
    public final String f12060F;

    /* renamed from: G */
    public Player f12061G;

    /* renamed from: H */
    public ProgressUpdateListener f12062H;

    /* renamed from: I */
    public boolean f12063I;

    /* renamed from: J */
    public boolean f12064J;

    /* renamed from: K */
    public boolean f12065K;

    /* renamed from: L */
    public boolean f12066L;

    /* renamed from: M */
    public int f12067M;

    /* renamed from: N */
    public int f12068N;

    /* renamed from: O */
    public int f12069O;

    /* renamed from: P */
    public boolean f12070P;

    /* renamed from: Q */
    public boolean f12071Q;

    /* renamed from: R */
    public boolean f12072R;

    /* renamed from: S */
    public boolean f12073S;

    /* renamed from: T */
    public boolean f12074T;

    /* renamed from: U */
    public long f12075U;

    /* renamed from: V */
    public long[] f12076V;

    /* renamed from: W */
    public boolean[] f12077W;

    /* renamed from: a */
    public final ViewOnClickListenerC0720b f12078a;

    /* renamed from: a0 */
    public long[] f12079a0;

    /* renamed from: b */
    public final CopyOnWriteArrayList f12080b;

    /* renamed from: b0 */
    public boolean[] f12081b0;

    /* renamed from: c */
    public final View f12082c;

    /* renamed from: c0 */
    public long f12083c0;

    /* renamed from: d */
    public final View f12084d;

    /* renamed from: d0 */
    public long f12085d0;

    /* renamed from: e */
    public final View f12086e;

    /* renamed from: e0 */
    public long f12087e0;

    /* renamed from: f */
    public final View f12088f;

    /* renamed from: g */
    public final View f12089g;

    /* renamed from: h */
    public final View f12090h;

    /* renamed from: i */
    public final ImageView f12091i;

    /* renamed from: j */
    public final ImageView f12092j;

    /* renamed from: k */
    public final View f12093k;

    /* renamed from: l */
    public final TextView f12094l;

    /* renamed from: m */
    public final TextView f12095m;

    /* renamed from: n */
    public final TimeBar f12096n;

    /* renamed from: o */
    public final StringBuilder f12097o;

    /* renamed from: p */
    public final Formatter f12098p;

    /* renamed from: q */
    public final Timeline.Period f12099q;

    /* renamed from: r */
    public final Timeline.Window f12100r;

    /* renamed from: s */
    public final e62 f12101s;

    /* renamed from: t */
    public final e62 f12102t;

    /* renamed from: u */
    public final Drawable f12103u;

    /* renamed from: v */
    public final Drawable f12104v;

    /* renamed from: w */
    public final Drawable f12105w;

    /* renamed from: x */
    public final String f12106x;

    /* renamed from: y */
    public final String f12107y;

    /* renamed from: z */
    public final String f12108z;

    /* loaded from: classes.dex */
    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    /* loaded from: classes.dex */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static void m2901a(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            player.prepare();
        } else if (playbackState == 4) {
            player.seekTo(player.getCurrentMediaItemIndex(), C0643C.TIME_UNSET);
        }
        player.play();
    }

    public void addVisibilityListener(VisibilityListener visibilityListener) {
        Assertions.checkNotNull(visibilityListener);
        this.f12080b.add(visibilityListener);
    }

    /* renamed from: b */
    public final void m2902b() {
        e62 e62Var = this.f12102t;
        removeCallbacks(e62Var);
        if (this.f12067M > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.f12067M;
            this.f12075U = uptimeMillis + j;
            if (this.f12063I) {
                postDelayed(e62Var, j);
                return;
            }
            return;
        }
        this.f12075U = C0643C.TIME_UNSET;
    }

    /* renamed from: c */
    public final boolean m2903c() {
        Player player = this.f12061G;
        if (player != null && player.getPlaybackState() != 4 && this.f12061G.getPlaybackState() != 1 && this.f12061G.getPlayWhenReady()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public final void m2904d(View view, boolean z, boolean z2) {
        float f;
        int i;
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        if (z2) {
            f = this.f12057C;
        } else {
            f = this.f12058D;
        }
        view.setAlpha(f);
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
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
        Player player = this.f12061G;
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
                                        m2901a(player);
                                    }
                                } else {
                                    player.seekToPrevious();
                                }
                            } else {
                                player.seekToNext();
                            }
                        } else {
                            int playbackState = player.getPlaybackState();
                            if (playbackState != 1 && playbackState != 4 && player.getPlayWhenReady()) {
                                player.pause();
                            } else {
                                m2901a(player);
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

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f12102t);
        } else if (motionEvent.getAction() == 1) {
            m2902b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: e */
    public final void m2905e() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (isVisible() && this.f12063I) {
            Player player = this.f12061G;
            if (player != null) {
                z = player.isCommandAvailable(5);
                z3 = player.isCommandAvailable(7);
                z4 = player.isCommandAvailable(11);
                z5 = player.isCommandAvailable(12);
                z2 = player.isCommandAvailable(9);
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            m2904d(this.f12082c, this.f12072R, z3);
            m2904d(this.f12090h, this.f12070P, z4);
            m2904d(this.f12089g, this.f12071Q, z5);
            m2904d(this.f12084d, this.f12073S, z2);
            TimeBar timeBar = this.f12096n;
            if (timeBar != null) {
                timeBar.setEnabled(z);
            }
        }
    }

    /* renamed from: f */
    public final void m2906f() {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        if (isVisible() && this.f12063I) {
            boolean m2903c = m2903c();
            View view = this.f12086e;
            boolean z4 = true;
            int i2 = 0;
            if (view != null) {
                if (m2903c && view.isFocused()) {
                    z = true;
                } else {
                    z = false;
                }
                if (Util.SDK_INT < 21) {
                    z2 = z;
                } else if (m2903c && f62.m4776a(view)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m2903c) {
                    i = 8;
                } else {
                    i = 0;
                }
                view.setVisibility(i);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.f12088f;
            if (view2 != null) {
                if (!m2903c && view2.isFocused()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z |= z3;
                if (Util.SDK_INT < 21) {
                    z4 = z;
                } else if (m2903c || !f62.m4776a(view2)) {
                    z4 = false;
                }
                z2 |= z4;
                if (!m2903c) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
            if (z) {
                boolean m2903c2 = m2903c();
                if (!m2903c2 && view != null) {
                    view.requestFocus();
                } else if (m2903c2 && view2 != null) {
                    view2.requestFocus();
                }
            }
            if (z2) {
                boolean m2903c3 = m2903c();
                if (!m2903c3 && view != null) {
                    view.sendAccessibilityEvent(8);
                } else if (m2903c3 && view2 != null) {
                    view2.sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* renamed from: g */
    public final void m2907g() {
        long j;
        long j2;
        boolean z;
        int playbackState;
        long j3;
        if (isVisible() && this.f12063I) {
            Player player = this.f12061G;
            if (player != null) {
                j = player.getContentPosition() + this.f12083c0;
                j2 = player.getContentBufferedPosition() + this.f12083c0;
            } else {
                j = 0;
                j2 = 0;
            }
            boolean z2 = false;
            if (j != this.f12085d0) {
                z = true;
            } else {
                z = false;
            }
            if (j2 != this.f12087e0) {
                z2 = true;
            }
            this.f12085d0 = j;
            this.f12087e0 = j2;
            TextView textView = this.f12095m;
            if (textView != null && !this.f12066L && z) {
                textView.setText(Util.getStringForTime(this.f12097o, this.f12098p, j));
            }
            TimeBar timeBar = this.f12096n;
            if (timeBar != null) {
                timeBar.setPosition(j);
                timeBar.setBufferedPosition(j2);
            }
            ProgressUpdateListener progressUpdateListener = this.f12062H;
            if (progressUpdateListener != null && (z || z2)) {
                progressUpdateListener.onProgressUpdate(j, j2);
            }
            e62 e62Var = this.f12101s;
            removeCallbacks(e62Var);
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
                postDelayed(e62Var, Util.constrainValue(j4, this.f12068N, 1000L));
                return;
            }
            if (playbackState != 4 && playbackState != 1) {
                postDelayed(e62Var, 1000L);
            }
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.f12061G;
    }

    public int getRepeatToggleModes() {
        return this.f12069O;
    }

    public boolean getShowShuffleButton() {
        return this.f12074T;
    }

    public int getShowTimeoutMs() {
        return this.f12067M;
    }

    public boolean getShowVrButton() {
        View view = this.f12093k;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public final void m2908h() {
        ImageView imageView;
        if (isVisible() && this.f12063I && (imageView = this.f12091i) != null) {
            if (this.f12069O == 0) {
                m2904d(imageView, false, false);
                return;
            }
            Player player = this.f12061G;
            String str = this.f12106x;
            Drawable drawable = this.f12103u;
            if (player == null) {
                m2904d(imageView, true, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            m2904d(imageView, true, true);
            int repeatMode = player.getRepeatMode();
            if (repeatMode != 0) {
                if (repeatMode != 1) {
                    if (repeatMode == 2) {
                        imageView.setImageDrawable(this.f12105w);
                        imageView.setContentDescription(this.f12108z);
                    }
                } else {
                    imageView.setImageDrawable(this.f12104v);
                    imageView.setContentDescription(this.f12107y);
                }
            } else {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            }
            imageView.setVisibility(0);
        }
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator it = this.f12080b.iterator();
            while (it.hasNext()) {
                ((VisibilityListener) it.next()).onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.f12101s);
            removeCallbacks(this.f12102t);
            this.f12075U = C0643C.TIME_UNSET;
        }
    }

    /* renamed from: i */
    public final void m2909i() {
        ImageView imageView;
        if (isVisible() && this.f12063I && (imageView = this.f12092j) != null) {
            Player player = this.f12061G;
            if (!this.f12074T) {
                m2904d(imageView, false, false);
                return;
            }
            String str = this.f12060F;
            Drawable drawable = this.f12056B;
            if (player == null) {
                m2904d(imageView, true, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            m2904d(imageView, true, true);
            if (player.getShuffleModeEnabled()) {
                drawable = this.f12055A;
            }
            imageView.setImageDrawable(drawable);
            if (player.getShuffleModeEnabled()) {
                str = this.f12059E;
            }
            imageView.setContentDescription(str);
        }
    }

    public boolean isVisible() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0109  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2910j() {
        boolean z;
        Timeline currentTimeline;
        int i;
        TextView textView;
        TimeBar timeBar;
        int i2;
        int i3;
        int length;
        Player player = this.f12061G;
        if (player == null) {
            return;
        }
        boolean z2 = this.f12064J;
        long j = C0643C.TIME_UNSET;
        Timeline.Window window = this.f12100r;
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
                this.f12065K = z;
                long j2 = 0;
                this.f12083c0 = 0L;
                currentTimeline = player.getCurrentTimeline();
                if (currentTimeline.isEmpty()) {
                    int currentMediaItemIndex = player.getCurrentMediaItemIndex();
                    boolean z4 = this.f12065K;
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
                            this.f12083c0 = Util.usToMs(j3);
                        }
                        currentTimeline.getWindow(i2, window);
                        if (window.durationUs == j) {
                            Assertions.checkState(this.f12065K ^ z3);
                            break;
                        }
                        int i5 = window.firstPeriodIndex;
                        while (i5 <= window.lastPeriodIndex) {
                            Timeline.Period period = this.f12099q;
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
                                    long[] jArr = this.f12076V;
                                    if (i == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f12076V = Arrays.copyOf(jArr, length);
                                        this.f12077W = Arrays.copyOf(this.f12077W, length);
                                    }
                                    this.f12076V[i] = Util.usToMs(positionInWindowUs + j3);
                                    this.f12077W[i] = period.hasPlayedAdGroup(i6);
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
                textView = this.f12094l;
                if (textView != null) {
                    textView.setText(Util.getStringForTime(this.f12097o, this.f12098p, usToMs));
                }
                timeBar = this.f12096n;
                if (timeBar != null) {
                    timeBar.setDuration(usToMs);
                    int length2 = this.f12079a0.length;
                    int i8 = i + length2;
                    long[] jArr2 = this.f12076V;
                    if (i8 > jArr2.length) {
                        this.f12076V = Arrays.copyOf(jArr2, i8);
                        this.f12077W = Arrays.copyOf(this.f12077W, i8);
                    }
                    System.arraycopy(this.f12079a0, 0, this.f12076V, i, length2);
                    System.arraycopy(this.f12081b0, 0, this.f12077W, i, length2);
                    timeBar.setAdGroupTimesMs(this.f12076V, this.f12077W, i8);
                }
                m2907g();
            }
        }
        z = false;
        this.f12065K = z;
        long j22 = 0;
        this.f12083c0 = 0L;
        currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
        }
        long usToMs2 = Util.usToMs(j22);
        textView = this.f12094l;
        if (textView != null) {
        }
        timeBar = this.f12096n;
        if (timeBar != null) {
        }
        m2907g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12063I = true;
        long j = this.f12075U;
        if (j != C0643C.TIME_UNSET) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.f12102t, uptimeMillis);
            }
        } else if (isVisible()) {
            m2902b();
        }
        m2906f();
        m2905e();
        m2908h();
        m2909i();
        m2910j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12063I = false;
        removeCallbacks(this.f12101s);
        removeCallbacks(this.f12102t);
    }

    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.f12080b.remove(visibilityListener);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.f12079a0 = new long[0];
            this.f12081b0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            if (jArr.length == zArr2.length) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.f12079a0 = jArr;
            this.f12081b0 = zArr2;
        }
        m2910j();
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
        Player player2 = this.f12061G;
        if (player2 == player) {
            return;
        }
        ViewOnClickListenerC0720b viewOnClickListenerC0720b = this.f12078a;
        if (player2 != null) {
            player2.removeListener(viewOnClickListenerC0720b);
        }
        this.f12061G = player;
        if (player != null) {
            player.addListener(viewOnClickListenerC0720b);
        }
        m2906f();
        m2905e();
        m2908h();
        m2909i();
        m2910j();
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.f12062H = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i) {
        this.f12069O = i;
        Player player = this.f12061G;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.f12061G.setRepeatMode(0);
            } else if (i == 1 && repeatMode == 2) {
                this.f12061G.setRepeatMode(1);
            } else if (i == 2 && repeatMode == 1) {
                this.f12061G.setRepeatMode(2);
            }
        }
        m2908h();
    }

    public void setShowFastForwardButton(boolean z) {
        this.f12071Q = z;
        m2905e();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.f12064J = z;
        m2910j();
    }

    public void setShowNextButton(boolean z) {
        this.f12073S = z;
        m2905e();
    }

    public void setShowPreviousButton(boolean z) {
        this.f12072R = z;
        m2905e();
    }

    public void setShowRewindButton(boolean z) {
        this.f12070P = z;
        m2905e();
    }

    public void setShowShuffleButton(boolean z) {
        this.f12074T = z;
        m2909i();
    }

    public void setShowTimeoutMs(int i) {
        this.f12067M = i;
        if (isVisible()) {
            m2902b();
        }
    }

    public void setShowVrButton(boolean z) {
        int i;
        View view = this.f12093k;
        if (view != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.f12068N = Util.constrainValue(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        boolean z;
        View view = this.f12093k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            boolean showVrButton = getShowVrButton();
            if (onClickListener != null) {
                z = true;
            } else {
                z = false;
            }
            m2904d(view, showVrButton, z);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator it = this.f12080b.iterator();
            while (it.hasNext()) {
                ((VisibilityListener) it.next()).onVisibilityChange(getVisibility());
            }
            m2906f();
            m2905e();
            m2908h();
            m2909i();
            m2910j();
            boolean m2903c = m2903c();
            View view = this.f12088f;
            View view2 = this.f12086e;
            if (!m2903c && view2 != null) {
                view2.requestFocus();
            } else if (m2903c && view != null) {
                view.requestFocus();
            }
            boolean m2903c2 = m2903c();
            if (!m2903c2 && view2 != null) {
                view2.sendAccessibilityEvent(8);
            } else if (m2903c2 && view != null) {
                view.sendAccessibilityEvent(8);
            }
        }
        m2902b();
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [e62] */
    /* JADX WARN: Type inference failed for: r3v3, types: [e62] */
    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i2 = R.layout.exo_player_control_view;
        this.f12067M = 5000;
        this.f12069O = 0;
        this.f12068N = 200;
        this.f12075U = C0643C.TIME_UNSET;
        this.f12070P = true;
        this.f12071Q = true;
        this.f12072R = true;
        this.f12073S = true;
        this.f12074T = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerControlView, i, 0);
            try {
                this.f12067M = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_show_timeout, this.f12067M);
                i2 = obtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_controller_layout_id, i2);
                this.f12069O = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, this.f12069O);
                this.f12070P = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_rewind_button, this.f12070P);
                this.f12071Q = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_fastforward_button, this.f12071Q);
                this.f12072R = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_previous_button, this.f12072R);
                this.f12073S = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_next_button, this.f12073S);
                this.f12074T = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, this.f12074T);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.PlayerControlView_time_bar_min_update_interval, this.f12068N));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f12080b = new CopyOnWriteArrayList();
        this.f12099q = new Timeline.Period();
        this.f12100r = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.f12097o = sb;
        this.f12098p = new Formatter(sb, Locale.getDefault());
        this.f12076V = new long[0];
        this.f12077W = new boolean[0];
        this.f12079a0 = new long[0];
        this.f12081b0 = new boolean[0];
        ViewOnClickListenerC0720b viewOnClickListenerC0720b = new ViewOnClickListenerC0720b(this);
        this.f12078a = viewOnClickListenerC0720b;
        final int i3 = 0;
        this.f12101s = new Runnable(this) { // from class: e62

            /* renamed from: b */
            public final /* synthetic */ PlayerControlView f16684b;

            {
                this.f16684b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.f16684b;
                switch (i3) {
                    case 0:
                        int i4 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                        playerControlView.m2907g();
                        return;
                    default:
                        playerControlView.hide();
                        return;
                }
            }
        };
        final int i4 = 1;
        this.f12102t = new Runnable(this) { // from class: e62

            /* renamed from: b */
            public final /* synthetic */ PlayerControlView f16684b;

            {
                this.f16684b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.f16684b;
                switch (i4) {
                    case 0:
                        int i42 = PlayerControlView.DEFAULT_SHOW_TIMEOUT_MS;
                        playerControlView.m2907g();
                        return;
                    default:
                        playerControlView.hide();
                        return;
                }
            }
        };
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        int i5 = R.id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i5);
        View findViewById = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.f12096n = timeBar;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i5);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f12096n = defaultTimeBar;
        } else {
            this.f12096n = null;
        }
        this.f12094l = (TextView) findViewById(R.id.exo_duration);
        this.f12095m = (TextView) findViewById(R.id.exo_position);
        TimeBar timeBar2 = this.f12096n;
        if (timeBar2 != null) {
            timeBar2.addListener(viewOnClickListenerC0720b);
        }
        View findViewById2 = findViewById(R.id.exo_play);
        this.f12086e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(viewOnClickListenerC0720b);
        }
        View findViewById3 = findViewById(R.id.exo_pause);
        this.f12088f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(viewOnClickListenerC0720b);
        }
        View findViewById4 = findViewById(R.id.exo_prev);
        this.f12082c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(viewOnClickListenerC0720b);
        }
        View findViewById5 = findViewById(R.id.exo_next);
        this.f12084d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(viewOnClickListenerC0720b);
        }
        View findViewById6 = findViewById(R.id.exo_rew);
        this.f12090h = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(viewOnClickListenerC0720b);
        }
        View findViewById7 = findViewById(R.id.exo_ffwd);
        this.f12089g = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(viewOnClickListenerC0720b);
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f12091i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(viewOnClickListenerC0720b);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f12092j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(viewOnClickListenerC0720b);
        }
        View findViewById8 = findViewById(R.id.exo_vr);
        this.f12093k = findViewById8;
        setShowVrButton(false);
        m2904d(findViewById8, false, false);
        Resources resources = context.getResources();
        this.f12057C = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.f12058D = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f12103u = resources.getDrawable(R.drawable.exo_controls_repeat_off);
        this.f12104v = resources.getDrawable(R.drawable.exo_controls_repeat_one);
        this.f12105w = resources.getDrawable(R.drawable.exo_controls_repeat_all);
        this.f12055A = resources.getDrawable(R.drawable.exo_controls_shuffle_on);
        this.f12056B = resources.getDrawable(R.drawable.exo_controls_shuffle_off);
        this.f12106x = resources.getString(R.string.exo_controls_repeat_off_description);
        this.f12107y = resources.getString(R.string.exo_controls_repeat_one_description);
        this.f12108z = resources.getString(R.string.exo_controls_repeat_all_description);
        this.f12059E = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.f12060F = resources.getString(R.string.exo_controls_shuffle_off_description);
        this.f12085d0 = C0643C.TIME_UNSET;
        this.f12087e0 = C0643C.TIME_UNSET;
    }
}
