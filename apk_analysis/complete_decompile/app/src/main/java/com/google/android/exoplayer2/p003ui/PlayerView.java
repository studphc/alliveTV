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
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.p003ui.PlayerControlView;
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

@Deprecated
/* loaded from: classes.dex */
public class PlayerView extends FrameLayout implements AdViewProvider {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;

    /* renamed from: a */
    public final ViewOnLayoutChangeListenerC0722d f12152a;

    /* renamed from: b */
    public final AspectRatioFrameLayout f12153b;

    /* renamed from: c */
    public final View f12154c;

    /* renamed from: d */
    public final View f12155d;

    /* renamed from: e */
    public final boolean f12156e;

    /* renamed from: f */
    public final ImageView f12157f;

    /* renamed from: g */
    public final SubtitleView f12158g;

    /* renamed from: h */
    public final View f12159h;

    /* renamed from: i */
    public final TextView f12160i;

    /* renamed from: j */
    public final PlayerControlView f12161j;

    /* renamed from: k */
    public final FrameLayout f12162k;

    /* renamed from: l */
    public final FrameLayout f12163l;

    /* renamed from: m */
    public Player f12164m;

    /* renamed from: n */
    public boolean f12165n;

    /* renamed from: o */
    public PlayerControlView.VisibilityListener f12166o;

    /* renamed from: p */
    public boolean f12167p;

    /* renamed from: q */
    public Drawable f12168q;

    /* renamed from: r */
    public int f12169r;

    /* renamed from: s */
    public boolean f12170s;

    /* renamed from: t */
    public ErrorMessageProvider f12171t;

    /* renamed from: u */
    public CharSequence f12172u;

    /* renamed from: v */
    public int f12173v;

    /* renamed from: w */
    public boolean f12174w;

    /* renamed from: x */
    public boolean f12175x;

    /* renamed from: y */
    public boolean f12176y;

    /* renamed from: z */
    public int f12177z;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ShowBuffering {
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static void m2914a(TextureView textureView, int i) {
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

    public static void switchTargetView(Player player, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(player);
        }
        if (playerView != null) {
            playerView.setPlayer(null);
        }
    }

    /* renamed from: b */
    public final boolean m2915b() {
        Player player = this.f12164m;
        if (player != null && player.isPlayingAd() && this.f12164m.getPlayWhenReady()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final void m2916c(boolean z) {
        boolean z2;
        if ((!m2915b() || !this.f12175x) && m2925l()) {
            PlayerControlView playerControlView = this.f12161j;
            int i = 0;
            if (playerControlView.isVisible() && playerControlView.getShowTimeoutMs() <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean m2918e = m2918e();
            if ((z || z2 || m2918e) && m2925l()) {
                if (!m2918e) {
                    i = this.f12173v;
                }
                playerControlView.setShowTimeoutMs(i);
                playerControlView.show();
            }
        }
    }

    /* renamed from: d */
    public final boolean m2917d(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(this.f12153b, intrinsicWidth / intrinsicHeight);
                ImageView imageView = this.f12157f;
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
        Player player = this.f12164m;
        if (player != null && player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19 && keyCode != 270 && keyCode != 22 && keyCode != 271 && keyCode != 20 && keyCode != 269 && keyCode != 21 && keyCode != 268 && keyCode != 23) {
            z = false;
        } else {
            z = true;
        }
        if (z && m2925l() && !this.f12161j.isVisible()) {
            m2916c(true);
        } else {
            if (!dispatchMediaKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                if (!z || !m2925l()) {
                    return false;
                }
                m2916c(true);
                return false;
            }
            m2916c(true);
        }
        return true;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        if (m2925l() && this.f12161j.dispatchMediaKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m2918e() {
        Player player = this.f12164m;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        if (this.f12174w && (playbackState == 1 || playbackState == 4 || !this.f12164m.getPlayWhenReady())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final void m2919f() {
        if (m2925l() && this.f12164m != null) {
            PlayerControlView playerControlView = this.f12161j;
            if (!playerControlView.isVisible()) {
                m2916c(true);
            } else if (this.f12176y) {
                playerControlView.hide();
            }
        }
    }

    /* renamed from: g */
    public final void m2920g() {
        VideoSize videoSize;
        float f;
        Player player = this.f12164m;
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
        View view = this.f12155d;
        if (view instanceof TextureView) {
            if (f > RecyclerView.f7068F0 && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            int i4 = this.f12177z;
            ViewOnLayoutChangeListenerC0722d viewOnLayoutChangeListenerC0722d = this.f12152a;
            if (i4 != 0) {
                view.removeOnLayoutChangeListener(viewOnLayoutChangeListenerC0722d);
            }
            this.f12177z = i3;
            if (i3 != 0) {
                view.addOnLayoutChangeListener(viewOnLayoutChangeListenerC0722d);
            }
            m2914a((TextureView) view, this.f12177z);
        }
        if (!this.f12156e) {
            f2 = f;
        }
        onContentAspectRatioChanged(this.f12153b, f2);
    }

    @Override // com.google.android.exoplayer2.p003ui.AdViewProvider
    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f12163l;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.f12161j;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo(playerControlView, 1));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // com.google.android.exoplayer2.p003ui.AdViewProvider
    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.checkStateNotNull(this.f12162k, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f12174w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f12176y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f12173v;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f12168q;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f12163l;
    }

    @Nullable
    public Player getPlayer() {
        return this.f12164m;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f12153b;
        Assertions.checkStateNotNull(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f12158g;
    }

    public boolean getUseArtwork() {
        return this.f12167p;
    }

    public boolean getUseController() {
        return this.f12165n;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f12155d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r5.f12164m.getPlayWhenReady() == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2921h() {
        boolean z;
        View view = this.f12159h;
        if (view != null) {
            Player player = this.f12164m;
            int i = 0;
            if (player != null && player.getPlaybackState() == 2) {
                int i2 = this.f12169r;
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
        PlayerControlView playerControlView = this.f12161j;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    /* renamed from: i */
    public final void m2922i() {
        String str = null;
        PlayerControlView playerControlView = this.f12161j;
        if (playerControlView != null && this.f12165n) {
            if (playerControlView.getVisibility() == 0) {
                if (this.f12176y) {
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

    public boolean isControllerVisible() {
        PlayerControlView playerControlView = this.f12161j;
        if (playerControlView != null && playerControlView.isVisible()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final void m2923j() {
        PlaybackException playbackException;
        ErrorMessageProvider errorMessageProvider;
        TextView textView = this.f12160i;
        if (textView != null) {
            CharSequence charSequence = this.f12172u;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            Player player = this.f12164m;
            if (player != null) {
                playbackException = player.getPlayerError();
            } else {
                playbackException = null;
            }
            if (playbackException != null && (errorMessageProvider = this.f12171t) != null) {
                textView.setText((CharSequence) errorMessageProvider.getErrorMessage(playbackException).second);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    /* renamed from: k */
    public final void m2924k(boolean z) {
        Player player = this.f12164m;
        View view = this.f12154c;
        ImageView imageView = this.f12157f;
        boolean z2 = false;
        if (player != null && player.isCommandAvailable(30) && !player.getCurrentTracks().isEmpty()) {
            if (z && !this.f12170s && view != null) {
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
            if (this.f12167p) {
                Assertions.checkStateNotNull(imageView);
                byte[] bArr = player.getMediaMetadata().artworkData;
                if (bArr != null) {
                    z2 = m2917d(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                }
                if (z2 || m2917d(this.f12168q)) {
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
        if (!this.f12170s) {
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
    public final boolean m2925l() {
        if (this.f12165n) {
            Assertions.checkStateNotNull(this.f12161j);
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
        View view = this.f12155d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.f12155d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m2925l() && this.f12164m != null) {
            m2916c(true);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        m2919f();
        return super.performClick();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f12153b;
        Assertions.checkStateNotNull(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aspectRatioListener);
    }

    public void setControllerAutoShow(boolean z) {
        this.f12174w = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.f12175x = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        Assertions.checkStateNotNull(this.f12161j);
        this.f12176y = z;
        m2922i();
    }

    public void setControllerShowTimeoutMs(int i) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        this.f12173v = i;
        if (playerControlView.isVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.VisibilityListener visibilityListener) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        PlayerControlView.VisibilityListener visibilityListener2 = this.f12166o;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        if (visibilityListener2 != null) {
            playerControlView.removeVisibilityListener(visibilityListener2);
        }
        this.f12166o = visibilityListener;
        if (visibilityListener != null) {
            playerControlView.addVisibilityListener(visibilityListener);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        boolean z;
        if (this.f12160i != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f12172u = charSequence;
        m2923j();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f12168q != drawable) {
            this.f12168q = drawable;
            m2924k(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.f12171t != errorMessageProvider) {
            this.f12171t = errorMessageProvider;
            m2923j();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.f12170s != z) {
            this.f12170s = z;
            m2924k(false);
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
        Player player2 = this.f12164m;
        if (player2 == player) {
            return;
        }
        View view = this.f12155d;
        ViewOnLayoutChangeListenerC0722d viewOnLayoutChangeListenerC0722d = this.f12152a;
        if (player2 != null) {
            player2.removeListener(viewOnLayoutChangeListenerC0722d);
            if (player2.isCommandAvailable(27)) {
                if (view instanceof TextureView) {
                    player2.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player2.clearVideoSurfaceView((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f12158g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f12164m = player;
        if (m2925l()) {
            this.f12161j.setPlayer(player);
        }
        m2921h();
        m2923j();
        m2924k(true);
        if (player != null) {
            if (player.isCommandAvailable(27)) {
                if (view instanceof TextureView) {
                    player.setVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player.setVideoSurfaceView((SurfaceView) view);
                }
                m2920g();
            }
            if (subtitleView != null && player.isCommandAvailable(28)) {
                subtitleView.setCues(player.getCurrentCues().cues);
            }
            player.addListener(viewOnLayoutChangeListenerC0722d);
            m2916c(false);
            return;
        }
        hideController();
    }

    public void setRepeatToggleModes(int i) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f12153b;
        Assertions.checkStateNotNull(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.f12169r != i) {
            this.f12169r = i;
            m2921h();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        PlayerControlView playerControlView = this.f12161j;
        Assertions.checkStateNotNull(playerControlView);
        playerControlView.setShowShuffleButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.f12154c;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        boolean z2;
        if (z && this.f12157f == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (this.f12167p != z) {
            this.f12167p = z;
            m2924k(false);
        }
    }

    public void setUseController(boolean z) {
        boolean z2;
        boolean z3 = true;
        PlayerControlView playerControlView = this.f12161j;
        if (z && playerControlView == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.checkState(z2);
        if (!z && !hasOnClickListeners()) {
            z3 = false;
        }
        setClickable(z3);
        if (this.f12165n == z) {
            return;
        }
        this.f12165n = z;
        if (m2925l()) {
            playerControlView.setPlayer(this.f12164m);
        } else if (playerControlView != null) {
            playerControlView.hide();
            playerControlView.setPlayer(null);
        }
        m2922i();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f12155d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void showController() {
        int i;
        boolean m2918e = m2918e();
        if (m2925l()) {
            if (m2918e) {
                i = 0;
            } else {
                i = this.f12173v;
            }
            PlayerControlView playerControlView = this.f12161j;
            playerControlView.setShowTimeoutMs(i);
            playerControlView.show();
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        ViewOnLayoutChangeListenerC0722d viewOnLayoutChangeListenerC0722d = new ViewOnLayoutChangeListenerC0722d(this);
        this.f12152a = viewOnLayoutChangeListenerC0722d;
        if (isInEditMode()) {
            this.f12153b = null;
            this.f12154c = null;
            this.f12155d = null;
            this.f12156e = false;
            this.f12157f = null;
            this.f12158g = null;
            this.f12159h = null;
            this.f12160i = null;
            this.f12161j = null;
            this.f12162k = null;
            this.f12163l = null;
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
        int i9 = R.layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlayerView, i, 0);
            try {
                int i10 = R.styleable.PlayerView_shutter_background_color;
                boolean hasValue = obtainStyledAttributes.hasValue(i10);
                int color = obtainStyledAttributes.getColor(i10, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PlayerView_player_layout_id, i9);
                boolean z9 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.PlayerView_default_artwork, 0);
                boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_controller, true);
                int i11 = obtainStyledAttributes.getInt(R.styleable.PlayerView_surface_type, 1);
                int i12 = obtainStyledAttributes.getInt(R.styleable.PlayerView_resize_mode, 0);
                int i13 = obtainStyledAttributes.getInt(R.styleable.PlayerView_show_timeout, 5000);
                boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_on_touch, true);
                boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_auto_show, true);
                int integer = obtainStyledAttributes.getInteger(R.styleable.PlayerView_show_buffering, 0);
                this.f12170s = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_keep_content_on_player_reset, this.f12170s);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_during_ads, true);
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
        this.f12153b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i4);
        }
        View findViewById = findViewById(R.id.exo_shutter);
        this.f12154c = findViewById;
        if (findViewById != null && z4) {
            findViewById.setBackgroundColor(i6);
        }
        if (aspectRatioFrameLayout != null && i5 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i5 == 2) {
                this.f12155d = new TextureView(context);
            } else if (i5 == 3) {
                try {
                    int i14 = SphericalGLSurfaceView.f12897l;
                    this.f12155d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z8 = true;
                    this.f12155d.setLayoutParams(layoutParams);
                    this.f12155d.setOnClickListener(viewOnLayoutChangeListenerC0722d);
                    this.f12155d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f12155d, 0);
                    z7 = z8;
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i5 != 4) {
                this.f12155d = new SurfaceView(context);
            } else {
                try {
                    int i15 = VideoDecoderGLSurfaceView.f12870b;
                    this.f12155d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            z8 = false;
            this.f12155d.setLayoutParams(layoutParams);
            this.f12155d.setOnClickListener(viewOnLayoutChangeListenerC0722d);
            this.f12155d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f12155d, 0);
            z7 = z8;
        } else {
            this.f12155d = null;
            z7 = false;
        }
        this.f12156e = z7;
        this.f12162k = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.f12163l = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.f12157f = imageView2;
        this.f12167p = z5 && imageView2 != null;
        if (i7 != 0) {
            this.f12168q = ContextCompat.getDrawable(getContext(), i7);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.f12158g = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View findViewById2 = findViewById(R.id.exo_buffering);
        this.f12159h = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f12169r = i3;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.f12160i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i16 = R.id.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i16);
        View findViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f12161j = playerControlView;
            i8 = 0;
        } else if (findViewById3 != null) {
            i8 = 0;
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f12161j = playerControlView2;
            playerControlView2.setId(i16);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            i8 = 0;
            this.f12161j = null;
        }
        PlayerControlView playerControlView3 = this.f12161j;
        this.f12173v = playerControlView3 != null ? i2 : i8;
        this.f12176y = z3;
        this.f12174w = z;
        this.f12175x = z2;
        this.f12165n = (!z6 || playerControlView3 == null) ? i8 : 1;
        if (playerControlView3 != null) {
            playerControlView3.hide();
            this.f12161j.addVisibilityListener(viewOnLayoutChangeListenerC0722d);
        }
        if (z6) {
            setClickable(true);
        }
        m2922i();
    }
}
