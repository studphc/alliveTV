package p000;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionMediaSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final /* synthetic */ class wg2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28180a;

    /* renamed from: b */
    public final /* synthetic */ Object f28181b;

    /* renamed from: c */
    public final /* synthetic */ Object f28182c;

    public /* synthetic */ wg2(int i, Object obj, Object obj2) {
        this.f28180a = i;
        this.f28181b = obj;
        this.f28182c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdPlaybackState adPlaybackState;
        Object obj = this.f28182c;
        Object obj2 = this.f28181b;
        switch (this.f28180a) {
            case 0:
                ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource = (ServerSideAdInsertionMediaSource) obj2;
                Iterator it = serverSideAdInsertionMediaSource.f11112i.values().iterator();
                while (true) {
                    ImmutableMap immutableMap = (ImmutableMap) obj;
                    if (it.hasNext()) {
                        ah2 ah2Var = (ah2) it.next();
                        AdPlaybackState adPlaybackState2 = (AdPlaybackState) immutableMap.get(ah2Var.f194d);
                        if (adPlaybackState2 != null) {
                            ah2Var.f195e = adPlaybackState2;
                        }
                    } else {
                        ah2 ah2Var2 = serverSideAdInsertionMediaSource.f11117n;
                        if (ah2Var2 != null && (adPlaybackState = (AdPlaybackState) immutableMap.get(ah2Var2.f194d)) != null) {
                            serverSideAdInsertionMediaSource.f11117n.f195e = adPlaybackState;
                        }
                        serverSideAdInsertionMediaSource.f11119p = immutableMap;
                        if (serverSideAdInsertionMediaSource.f11118o != null) {
                            serverSideAdInsertionMediaSource.refreshSourceInfo(new zg2(serverSideAdInsertionMediaSource.f11118o, immutableMap));
                            return;
                        }
                        return;
                    }
                }
                break;
            case 1:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj2;
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f12904g;
                Surface surface = sphericalGLSurfaceView.f12905h;
                SurfaceTexture surfaceTexture2 = (SurfaceTexture) obj;
                Surface surface2 = new Surface(surfaceTexture2);
                sphericalGLSurfaceView.f12904g = surfaceTexture2;
                sphericalGLSurfaceView.f12905h = surface2;
                Iterator it2 = sphericalGLSurfaceView.f12898a.iterator();
                while (it2.hasNext()) {
                    ((SphericalGLSurfaceView.VideoSurfaceListener) it2.next()).onVideoSurfaceCreated(surface2);
                }
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                    return;
                }
                return;
            case 2:
                aq2 aq2Var = (aq2) obj2;
                aq2Var.getClass();
                try {
                    aq2Var.mo1960a(obj);
                    return;
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    EventBus eventBus = aq2Var.f7711a;
                    SubscriberExceptionContext subscriberExceptionContext = new SubscriberExceptionContext(eventBus, obj, aq2Var.f7712b, aq2Var.f7713c);
                    eventBus.getClass();
                    Preconditions.checkNotNull(cause);
                    Preconditions.checkNotNull(subscriberExceptionContext);
                    try {
                        eventBus.f15024c.handleException(cause, subscriberExceptionContext);
                        return;
                    } catch (Throwable th) {
                        EventBus.f15021f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th, cause), th);
                        return;
                    }
                }
            case 3:
                ((VideoRendererEventListener) Util.castNonNull(((VideoRendererEventListener.EventDispatcher) obj2).f12890b)).onVideoSizeChanged((VideoSize) obj);
                return;
            case 4:
                ((VideoRendererEventListener) Util.castNonNull(((VideoRendererEventListener.EventDispatcher) obj2).f12890b)).onVideoDecoderReleased((String) obj);
                return;
            case 5:
                ((VideoRendererEventListener) Util.castNonNull(((VideoRendererEventListener.EventDispatcher) obj2).f12890b)).onVideoCodecError((Exception) obj);
                return;
            default:
                ViewTransition viewTransition = (ViewTransition) obj2;
                View[] viewArr = (View[]) obj;
                if (viewTransition.f2971p != -1) {
                    for (View view : viewArr) {
                        view.setTag(viewTransition.f2971p, Long.valueOf(System.nanoTime()));
                    }
                }
                if (viewTransition.f2972q != -1) {
                    for (View view2 : viewArr) {
                        view2.setTag(viewTransition.f2972q, null);
                    }
                    return;
                }
                return;
        }
    }
}
