package com.google.android.exoplayer2.p003ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class StyledPlayerView extends FrameLayout implements AdViewProvider {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;

    /* renamed from: A */
    public boolean f12252A;

    /* renamed from: B */
    public int f12253B;

    /* renamed from: a */
    public final ViewOnLayoutChangeListenerC0732n f12254a;

    /* renamed from: b */
    public final AspectRatioFrameLayout f12255b;

    /* renamed from: c */
    public final View f12256c;

    /* renamed from: d */
    public final View f12257d;

    /* renamed from: e */
    public final boolean f12258e;

    /* renamed from: f */
    public final ImageView f12259f;

    /* renamed from: g */
    public final SubtitleView f12260g;

    /* renamed from: h */
    public final View f12261h;

    /* renamed from: i */
    public final TextView f12262i;

    /* renamed from: j */
    public final StyledPlayerControlView f12263j;

    /* renamed from: k */
    public final FrameLayout f12264k;

    /* renamed from: l */
    public final FrameLayout f12265l;

    /* renamed from: m */
    public Player f12266m;

    /* renamed from: n */
    public boolean f12267n;

    /* renamed from: o */
    public ControllerVisibilityListener f12268o;

    /* renamed from: p */
    public StyledPlayerControlView.VisibilityListener f12269p;

    /* renamed from: q */
    public FullscreenButtonClickListener f12270q;

    /* renamed from: r */
    public boolean f12271r;

    /* renamed from: s */
    public Drawable f12272s;

    /* renamed from: t */
    public int f12273t;

    /* renamed from: u */
    public boolean f12274u;

    /* renamed from: v */
    public ErrorMessageProvider f12275v;

    /* renamed from: w */
    public CharSequence f12276w;

    /* renamed from: x */
    public int f12277x;

    /* renamed from: y */
    public boolean f12278y;

    /* renamed from: z */
    public boolean f12279z;

    /* loaded from: classes.dex */
    public interface ControllerVisibilityListener {
        void onVisibilityChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface FullscreenButtonClickListener {
        void onFullscreenButtonClick(boolean z);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ShowBuffering {
    }

    public StyledPlayerView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static void m2941a(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != RecyclerView.f7068F0 && height != RecyclerView.f7068F0 && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(RecyclerView.f7068F0, RecyclerView.f7068F0, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    public static void switchTargetView(Player player, @Nullable StyledPlayerView styledPlayerView, @Nullable StyledPlayerView styledPlayerView2) {
        if (styledPlayerView == styledPlayerView2) {
            return;
        }
        if (styledPlayerView2 != null) {
            styledPlayerView2.setPlayer(player);
        }
        if (styledPlayerView != null) {
            styledPlayerView.setPlayer(null);
        }
    }

    /* renamed from: b */
    public final boolean m2942b() {
        Player player = this.f12266m;
        if (player != null && player.isPlayingAd() && this.f12266m.getPlayWhenReady()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final void m2943c(boolean z) {
        boolean z2;
        if ((!m2942b() || !this.f12279z) && m2952l()) {
            StyledPlayerControlView styledPlayerControlView = this.f12263j;
            int i = 0;
            if (styledPlayerControlView.isFullyVisible() && styledPlayerControlView.getShowTimeoutMs() <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean m2945e = m2945e();
            if ((z || z2 || m2945e) && m2952l()) {
                if (!m2945e) {
                    i = this.f12277x;
                }
                styledPlayerControlView.setShowTimeoutMs(i);
                styledPlayerControlView.show();
            }
        }
    }

    /* renamed from: d */
    public final boolean m2944d(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(this.f12255b, intrinsicWidth / intrinsicHeight);
                ImageView imageView = this.f12259f;
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        Player player = this.f12266m;
        if (player != null && player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19 && keyCode != 270 && keyCode != 22 && keyCode != 271 && keyCode != 20 && keyCode != 269 && keyCode != 21 && keyCode != 268 && keyCode != 23) {
            z = false;
        } else {
            z = true;
        }
        if (z && m2952l() && !this.f12263j.isFullyVisible()) {
            m2943c(true);
        } else {
            if (!dispatchMediaKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                if (!z || !m2952l()) {
                    return false;
                }
                m2943c(true);
                return false;
            }
            m2943c(true);
        }
        return true;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        if (m2952l() && this.f12263j.dispatchMediaKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m2945e() {
        Player player = this.f12266m;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        if (this.f12278y && !this.f12266m.getCurrentTimeline().isEmpty() && (playbackState == 1 || playbackState == 4 || !((Player) Assertions.checkNotNull(this.f12266m)).getPlayWhenReady())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final void m2946f() {
        if (m2952l() && this.f12266m != null) {
            StyledPlayerControlView styledPlayerControlView = this.f12263j;
            if (!styledPlayerControlView.isFullyVisible()) {
                m2943c(true);
            } else if (this.f12252A) {
                styledPlayerControlView.hide();
            }
        }
    }

    /* renamed from: g */
    public final void m2947g() {
        VideoSize videoSize;
        float f;
        Player player = this.f12266m;
        if (player != null) {
            videoSize = player.getVideoSize();
        } else {
            videoSize = VideoSize.UNKNOWN;
        }
        int i = videoSize.width;
        int i2 = videoSize.height;
        int i3 = videoSize.unappliedRotationDegrees;
        float f2 = RecyclerView.f7068F0;
        if (i2 != 0 && i != 0) {
            f = (i * videoSize.pixelWidthHeightRatio) / i2;
        } else {
            f = 0.0f;
        }
        View view = this.f12257d;
        if (view instanceof TextureView) {
            if (f > RecyclerView.f7068F0 && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            int i4 = this.f12253B;
            ViewOnLayoutChangeListenerC0732n viewOnLayoutChangeListenerC0732n = this.f12254a;
            if (i4 != 0) {
                view.removeOnLayoutChangeListener(viewOnLayoutChangeListenerC0732n);
            }
            this.f12253B = i3;
            if (i3 != 0) {
                view.addOnLayoutChangeListener(viewOnLayoutChangeListenerC0732n);
            }
            m2941a((TextureView) view, this.f12253B);
        }
        if (!this.f12258e) {
            f2 = f;
        }
        onContentAspectRatioChanged(this.f12255b, f2);
    }

    @Override // com.google.android.exoplayer2.p003ui.AdViewProvider
    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f12265l;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        if (styledPlayerControlView != null) {
            arrayList.add(new AdOverlayInfo(styledPlayerControlView, 1));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // com.google.android.exoplayer2.p003ui.AdViewProvider
    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.checkStateNotNull(this.f12264k, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f12278y;
    }

    public boolean getControllerHideOnTouch() {
        return this.f12252A;
    }

    public int getControllerShowTimeoutMs() {
        return this.f12277x;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f12272s;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f12265l;
    }

    @Nullable
    public Player getPlayer() {
        return this.f12266m;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f12255b;
        Assertions.checkStateNotNull(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f12260g;
    }

    public boolean getUseArtwork() {
        return this.f12271r;
    }

    public boolean getUseController() {
        return this.f12267n;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f12257d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r5.f12266m.getPlayWhenReady() == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2948h() {
        boolean z;
        View view = this.f12261h;
        if (view != null) {
            Player player = this.f12266m;
            int i = 0;
            if (player != null && player.getPlaybackState() == 2) {
                int i2 = this.f12273t;
                z = true;
                if (i2 != 2) {
                    if (i2 == 1) {
                    }
                }
                if (!z) {
                    i = 8;
                }
                view.setVisibility(i);
            }
            z = false;
            if (!z) {
            }
            view.setVisibility(i);
        }
    }

    public void hideController() {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.hide();
        }
    }

    /* renamed from: i */
    public final void m2949i() {
        String str = null;
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        if (styledPlayerControlView != null && this.f12267n) {
            if (styledPlayerControlView.isFullyVisible()) {
                if (this.f12252A) {
                    str = getResources().getString(R.string.exo_controls_hide);
                }
                setContentDescription(str);
                return;
            }
            setContentDescription(getResources().getString(R.string.exo_controls_show));
            return;
        }
        setContentDescription(null);
    }

    public boolean isControllerFullyVisible() {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        if (styledPlayerControlView != null && styledPlayerControlView.isFullyVisible()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final void m2950j() {
        PlaybackException playbackException;
        ErrorMessageProvider errorMessageProvider;
        TextView textView = this.f12262i;
        if (textView != null) {
            CharSequence charSequence = this.f12276w;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            Player player = this.f12266m;
            if (player != null) {
                playbackException = player.getPlayerError();
            } else {
                playbackException = null;
            }
            if (playbackException != null && (errorMessageProvider = this.f12275v) != null) {
                textView.setText((CharSequence) errorMessageProvider.getErrorMessage(playbackException).second);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    /* renamed from: k */
    public final void m2951k(boolean z) {
        Player player = this.f12266m;
        View view = this.f12256c;
        ImageView imageView = this.f12259f;
        boolean z2 = false;
        if (player != null && !player.getCurrentTracks().isEmpty()) {
            if (z && !this.f12274u && view != null) {
                view.setVisibility(0);
            }
            if (player.getCurrentTracks().isTypeSelected(2)) {
                if (imageView != null) {
                    imageView.setImageResource(R.color.transparent);
                    imageView.setVisibility(4);
                    return;
                }
                return;
            }
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.f12271r) {
                Assertions.checkStateNotNull(imageView);
                byte[] bArr = player.getMediaMetadata().artworkData;
                if (bArr != null) {
                    z2 = m2944d(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                }
                if (z2 || m2944d(this.f12272s)) {
                    return;
                }
            }
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        if (!this.f12274u) {
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    /* renamed from: l */
    public final boolean m2952l() {
        if (this.f12267n) {
            Assertions.checkStateNotNull(this.f12263j);
            return true;
        }
        return false;
    }

    public void onContentAspectRatioChanged(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void onPause() {
        View view = this.f12257d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.f12257d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m2952l() && this.f12266m != null) {
            m2943c(true);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        m2946f();
        return super.performClick();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f12255b;
        Assertions.checkStateNotNull(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aspectRatioListener);
    }

    public void setControllerAutoShow(boolean z) {
        this.f12278y = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.f12279z = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        Assertions.checkStateNotNull(this.f12263j);
        this.f12252A = z;
        m2949i();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        this.f12270q = null;
        styledPlayerControlView.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    public void setControllerShowTimeoutMs(int i) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        this.f12277x = i;
        if (styledPlayerControlView.isFullyVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(@Nullable ControllerVisibilityListener controllerVisibilityListener) {
        this.f12268o = controllerVisibilityListener;
        setControllerVisibilityListener((StyledPlayerControlView.VisibilityListener) null);
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        boolean z;
        if (this.f12262i != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f12276w = charSequence;
        m2950j();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f12272s != drawable) {
            this.f12272s = drawable;
            m2951k(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.f12275v != errorMessageProvider) {
            this.f12275v = errorMessageProvider;
            m2950j();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(@Nullable FullscreenButtonClickListener fullscreenButtonClickListener) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        this.f12270q = fullscreenButtonClickListener;
        styledPlayerControlView.setOnFullScreenModeChangedListener(this.f12254a);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.f12274u != z) {
            this.f12274u = z;
            m2951k(false);
        }
    }

    public void setPlayer(@Nullable Player player) {
        boolean z;
        boolean z2;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (player != null && player.getApplicationLooper() != Looper.getMainLooper()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkArgument(z2);
        Player player2 = this.f12266m;
        if (player2 == player) {
            return;
        }
        View view = this.f12257d;
        ViewOnLayoutChangeListenerC0732n viewOnLayoutChangeListenerC0732n = this.f12254a;
        if (player2 != null) {
            player2.removeListener(viewOnLayoutChangeListenerC0732n);
            if (view instanceof TextureView) {
                player2.clearVideoTextureView((TextureView) view);
            } else if (view instanceof SurfaceView) {
                player2.clearVideoSurfaceView((SurfaceView) view);
            }
        }
        SubtitleView subtitleView = this.f12260g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f12266m = player;
        if (m2952l()) {
            this.f12263j.setPlayer(player);
        }
        m2948h();
        m2950j();
        m2951k(true);
        if (player != null) {
            if (player.isCommandAvailable(27)) {
                if (view instanceof TextureView) {
                    player.setVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player.setVideoSurfaceView((SurfaceView) view);
                }
                m2947g();
            }
            if (subtitleView != null && player.isCommandAvailable(28)) {
                subtitleView.setCues(player.getCurrentCues().cues);
            }
            player.addListener(viewOnLayoutChangeListenerC0732n);
            m2943c(false);
            return;
        }
        hideController();
    }

    public void setRepeatToggleModes(int i) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f12255b;
        Assertions.checkStateNotNull(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.f12273t != i) {
            this.f12273t = i;
            m2948h();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        styledPlayerControlView.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(@ColorInt int i) {
        View view = this.f12256c;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        boolean z2;
        if (z && this.f12259f == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (this.f12271r != z) {
            this.f12271r = z;
            m2951k(false);
        }
    }

    public void setUseController(boolean z) {
        boolean z2;
        boolean z3 = true;
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        if (z && styledPlayerControlView == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (!z && !hasOnClickListeners()) {
            z3 = false;
        }
        setClickable(z3);
        if (this.f12267n == z) {
            return;
        }
        this.f12267n = z;
        if (m2952l()) {
            styledPlayerControlView.setPlayer(this.f12266m);
        } else if (styledPlayerControlView != null) {
            styledPlayerControlView.hide();
            styledPlayerControlView.setPlayer(null);
        }
        m2949i();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f12257d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void showController() {
        int i;
        boolean m2945e = m2945e();
        if (m2952l()) {
            if (m2945e) {
                i = 0;
            } else {
                i = this.f12277x;
            }
            StyledPlayerControlView styledPlayerControlView = this.f12263j;
            styledPlayerControlView.setShowTimeoutMs(i);
            styledPlayerControlView.show();
        }
    }

    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        boolean z4;
        boolean z5;
        int i7;
        boolean z6;
        boolean z7;
        int i8;
        boolean z8;
        ViewOnLayoutChangeListenerC0732n viewOnLayoutChangeListenerC0732n = new ViewOnLayoutChangeListenerC0732n(this);
        this.f12254a = viewOnLayoutChangeListenerC0732n;
        if (isInEditMode()) {
            this.f12255b = null;
            this.f12256c = null;
            this.f12257d = null;
            this.f12258e = false;
            this.f12259f = null;
            this.f12260g = null;
            this.f12261h = null;
            this.f12262i = null;
            this.f12263j = null;
            this.f12264k = null;
            this.f12265l = null;
            ImageView imageView = new ImageView(context);
            if (Util.SDK_INT >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo, null));
                imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(R.drawable.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R.color.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i9 = R.layout.exo_styled_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.StyledPlayerView, i, 0);
            try {
                int i10 = R.styleable.StyledPlayerView_shutter_background_color;
                boolean hasValue = obtainStyledAttributes.hasValue(i10);
                int color = obtainStyledAttributes.getColor(i10, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.StyledPlayerView_player_layout_id, i9);
                boolean z9 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.StyledPlayerView_default_artwork, 0);
                boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_use_controller, true);
                int i11 = obtainStyledAttributes.getInt(R.styleable.StyledPlayerView_surface_type, 1);
                int i12 = obtainStyledAttributes.getInt(R.styleable.StyledPlayerView_resize_mode, 0);
                int i13 = obtainStyledAttributes.getInt(R.styleable.StyledPlayerView_show_timeout, 5000);
                boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_hide_on_touch, true);
                boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_auto_show, true);
                int integer = obtainStyledAttributes.getInteger(R.styleable.StyledPlayerView_show_buffering, 0);
                this.f12274u = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_keep_content_on_player_reset, this.f12274u);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                i9 = resourceId;
                i4 = i12;
                i2 = i13;
                z2 = z13;
                z3 = z11;
                z = z12;
                i3 = integer;
                z6 = z10;
                i7 = resourceId2;
                z5 = z9;
                z4 = hasValue;
                i6 = color;
                i5 = i11;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = 5000;
            i3 = 0;
            z = true;
            z2 = true;
            z3 = true;
            i4 = 0;
            i5 = 1;
            i6 = 0;
            z4 = false;
            z5 = true;
            i7 = 0;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i9, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.f12255b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i4);
        }
        View findViewById = findViewById(R.id.exo_shutter);
        this.f12256c = findViewById;
        if (findViewById != null && z4) {
            findViewById.setBackgroundColor(i6);
        }
        if (aspectRatioFrameLayout != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i5 == 2) {
                this.f12257d = new TextureView(context);
            } else if (i5 == 3) {
                try {
                    int i14 = SphericalGLSurfaceView.f12897l;
                    this.f12257d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z8 = true;
                    this.f12257d.setLayoutParams(layoutParams);
                    this.f12257d.setOnClickListener(viewOnLayoutChangeListenerC0732n);
                    this.f12257d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f12257d, 0);
                    z7 = z8;
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i5 != 4) {
                this.f12257d = new SurfaceView(context);
            } else {
                try {
                    int i15 = VideoDecoderGLSurfaceView.f12870b;
                    this.f12257d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            z8 = false;
            this.f12257d.setLayoutParams(layoutParams);
            this.f12257d.setOnClickListener(viewOnLayoutChangeListenerC0732n);
            this.f12257d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f12257d, 0);
            z7 = z8;
        } else {
            this.f12257d = null;
            z7 = false;
        }
        this.f12258e = z7;
        this.f12264k = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.f12265l = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.f12259f = imageView2;
        this.f12271r = z5 && imageView2 != null;
        if (i7 != 0) {
            this.f12272s = ContextCompat.getDrawable(getContext(), i7);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.f12260g = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View findViewById2 = findViewById(R.id.exo_buffering);
        this.f12261h = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f12273t = i3;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.f12262i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i16 = R.id.exo_controller;
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(i16);
        View findViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.f12263j = styledPlayerControlView;
            i8 = 0;
        } else if (findViewById3 != null) {
            i8 = 0;
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context, null, 0, attributeSet);
            this.f12263j = styledPlayerControlView2;
            styledPlayerControlView2.setId(i16);
            styledPlayerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(styledPlayerControlView2, indexOfChild);
        } else {
            i8 = 0;
            this.f12263j = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.f12263j;
        this.f12277x = styledPlayerControlView3 != null ? i2 : i8;
        this.f12252A = z3;
        this.f12278y = z;
        this.f12279z = z2;
        this.f12267n = (!z6 || styledPlayerControlView3 == null) ? i8 : 1;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.hideImmediately();
            this.f12263j.addVisibilityListener(viewOnLayoutChangeListenerC0732n);
        }
        if (z6) {
            setClickable(true);
        }
        m2949i();
    }

    @Deprecated
    public void setControllerVisibilityListener(@Nullable StyledPlayerControlView.VisibilityListener visibilityListener) {
        StyledPlayerControlView styledPlayerControlView = this.f12263j;
        Assertions.checkStateNotNull(styledPlayerControlView);
        StyledPlayerControlView.VisibilityListener visibilityListener2 = this.f12269p;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        if (visibilityListener2 != null) {
            styledPlayerControlView.removeVisibilityListener(visibilityListener2);
        }
        this.f12269p = visibilityListener;
        if (visibilityListener != null) {
            styledPlayerControlView.addVisibilityListener(visibilityListener);
        }
        setControllerVisibilityListener((ControllerVisibilityListener) null);
    }
}
