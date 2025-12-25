package p000;

import android.app.Activity;
import android.app.Application;
import android.graphics.SurfaceTexture;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentDialog;
import androidx.activity.FullyDrawnReporter;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.C0253h;
import androidx.fragment.app.C0254i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.drm.C0660b;
import com.google.android.exoplayer2.drm.C0662d;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.p003ui.DefaultTimeBar;
import com.google.android.exoplayer2.source.hls.HlsMediaPeriod;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.firebase.installations.FirebaseInstallations;
import com.hisona.allive.BrowseErrorActivity;
import com.hisona.allive.ErrorFragment;
import com.hisona.allive.R;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* renamed from: a5 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0006a5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f39a;

    /* renamed from: b */
    public final /* synthetic */ Object f40b;

    public /* synthetic */ RunnableC0006a5(int i, Object obj) {
        this.f39a = i;
        this.f40b = obj;
    }

    /* renamed from: a */
    private final void m19a() {
        FullyDrawnReporter this$0 = (FullyDrawnReporter) this.f40b;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.f489c) {
            this$0.f491e = false;
            if (this$0.f490d == 0 && !this$0.f492f) {
                this$0.f488b.invoke();
                this$0.fullyDrawnReported();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Object obj;
        boolean z2;
        int i = 5;
        int i2 = 2;
        int i3 = 3;
        boolean z3 = false;
        switch (this.f39a) {
            case 0:
                Activity activity = (Activity) this.f40b;
                if (!activity.isFinishing()) {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 28) {
                        Class cls = AbstractC1712q5.f25446a;
                        activity.recreate();
                        return;
                    }
                    Class cls2 = AbstractC1712q5.f25446a;
                    if (i4 != 26 && i4 != 27) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Method method = AbstractC1712q5.f25451f;
                    if ((!z || method != null) && (AbstractC1712q5.f25450e != null || AbstractC1712q5.f25449d != null)) {
                        try {
                            Object obj2 = AbstractC1712q5.f25448c.get(activity);
                            if (obj2 != null && (obj = AbstractC1712q5.f25447b.get(activity)) != null) {
                                Application application = activity.getApplication();
                                C1675p5 c1675p5 = new C1675p5(activity);
                                application.registerActivityLifecycleCallbacks(c1675p5);
                                Handler handler = AbstractC1712q5.f25452g;
                                handler.post(new xy1(i2, c1675p5, obj2, z3));
                                if (i4 != 26 && i4 != 27) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                try {
                                    if (z2) {
                                        Boolean bool = Boolean.FALSE;
                                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                    } else {
                                        activity.recreate();
                                    }
                                    handler.post(new xy1(3, application, c1675p5, z3));
                                    return;
                                } catch (Throwable th) {
                                    handler.post(new xy1(3, application, c1675p5, z3));
                                    throw th;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    activity.recreate();
                    return;
                }
                return;
            case 1:
                C1264hc c1264hc = (C1264hc) this.f40b;
                synchronized (c1264hc.f18004a) {
                    try {
                        if (!c1264hc.f18015l) {
                            long j = c1264hc.f18014k - 1;
                            c1264hc.f18014k = j;
                            if (j <= 0) {
                                if (j < 0) {
                                    c1264hc.m5051b(new IllegalStateException());
                                    return;
                                } else {
                                    c1264hc.m5050a();
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            case 2:
                int i5 = BrowseErrorActivity.f15797E;
                BrowseErrorActivity browseErrorActivity = (BrowseErrorActivity) this.f40b;
                browseErrorActivity.getSupportFragmentManager().beginTransaction().remove(browseErrorActivity.f15799D).commit();
                ErrorFragment errorFragment = browseErrorActivity.f15798C;
                errorFragment.setImageDrawable(ContextCompat.getDrawable(errorFragment.getContext(), R.drawable.lb_ic_sad_cloud));
                errorFragment.setMessage(errorFragment.getResources().getString(R.string.error_fragment_message));
                errorFragment.setDefaultBackground(true);
                errorFragment.setButtonText(errorFragment.getResources().getString(R.string.dismiss_error));
                errorFragment.setButtonClickListener(new ViewOnClickListenerC1109d4(i3, errorFragment));
                return;
            case 3:
                Carousel carousel = (Carousel) this.f40b;
                carousel.f2618i.setTransitionDuration(carousel.f2631v);
                if (carousel.f2630u < carousel.f2617h) {
                    carousel.f2618i.transitionToState(carousel.f2623n, carousel.f2631v);
                    return;
                } else {
                    carousel.f2618i.transitionToState(carousel.f2624o, carousel.f2631v);
                    return;
                }
            case 4:
                ((ComponentActivity) this.f40b).invalidateMenu();
                return;
            case 5:
                ExecutorC1884ut executorC1884ut = (ExecutorC1884ut) this.f40b;
                Runnable runnable = executorC1884ut.f27432b;
                if (runnable != null) {
                    runnable.run();
                    executorC1884ut.f27432b = null;
                    return;
                }
                return;
            case 6:
                ComponentDialog.m143a((ComponentDialog) this.f40b);
                return;
            case 7:
                DefaultAnalyticsCollector defaultAnalyticsCollector = (DefaultAnalyticsCollector) this.f40b;
                AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = defaultAnalyticsCollector.generateCurrentPlayerMediaPeriodEventTime();
                defaultAnalyticsCollector.sendEvent(generateCurrentPlayerMediaPeriodEventTime, AnalyticsListener.EVENT_PLAYER_RELEASED, new C1816sz(generateCurrentPlayerMediaPeriodEventTime, i));
                defaultAnalyticsCollector.f9517f.release();
                return;
            case 8:
                C0662d c0662d = (C0662d) this.f40b;
                if (!c0662d.f10030c) {
                    DrmSession drmSession = c0662d.f10029b;
                    if (drmSession != null) {
                        drmSession.release(c0662d.f10028a);
                    }
                    c0662d.f10031d.f9950m.remove(c0662d);
                    c0662d.f10030c = true;
                    return;
                }
                return;
            case 9:
                ((C0660b) this.f40b).release(null);
                return;
            case 10:
                Ref.ObjectRef seekCancelLambda = (Ref.ObjectRef) this.f40b;
                Intrinsics.checkNotNullParameter(seekCancelLambda, "$seekCancelLambda");
                Function0 function0 = (Function0) seekCancelLambda.element;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            case 11:
                ArrayList transitioningViews = (ArrayList) this.f40b;
                Intrinsics.checkNotNullParameter(transitioningViews, "$transitioningViews");
                FragmentTransition.setViewVisibility(transitioningViews, 4);
                return;
            case 12:
                C0253h this$0 = (C0253h) this.f40b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Transition for all operations has completed");
                }
                Iterator it = this$0.f4663c.iterator();
                while (it.hasNext()) {
                    ((C0254i) it.next()).getOperation().completeEffect(this$0);
                }
                return;
            case 13:
                int i6 = DefaultTimeBar.DEFAULT_BAR_HEIGHT_DP;
                ((DefaultTimeBar) this.f40b).m2894d(false);
                return;
            case 14:
                DownloadHelper downloadHelper = (DownloadHelper) this.f40b;
                ((DownloadHelper.Callback) Assertions.checkNotNull(downloadHelper.f10789i)).onPrepared(downloadHelper);
                return;
            case 15:
                ((f60) this.f40b).m4775a();
                return;
            case 16:
                Object obj3 = FirebaseInstallations.f15566m;
                ((FirebaseInstallations) this.f40b).m4380b(false);
                return;
            case 17:
                ((Disposable) this.f40b).dispose();
                return;
            case 18:
                Fragment fragment = (Fragment) this.f40b;
                fragment.f4439V.f25304f.performRestore(fragment.f4450d);
                fragment.f4450d = null;
                return;
            case 19:
                Iterator it2 = ((FragmentManager) this.f40b).f4529o.iterator();
                while (it2.hasNext()) {
                    ((FragmentManager.OnBackStackChangedListener) it2.next()).onBackStackChangeCancelled();
                }
                return;
            case 20:
                m19a();
                return;
            case 21:
                ((HlsMediaPeriod) this.f40b).onPrepared();
                return;
            case 22:
                g61 g61Var = (g61) this.f40b;
                g61Var.getClass();
                try {
                    Uninterruptibles.getUninterruptibly(g61Var.f17559d);
                } catch (Throwable unused2) {
                }
                g61Var.f17557b.execute();
                return;
            case 23:
                fd1 fd1Var = (fd1) this.f40b;
                fd1Var.f17218f = null;
                fd1Var.onLocationChanged((Location) null);
                return;
            case 24:
                ((MainThreadDisposable) this.f40b).onDispose();
                return;
            case 25:
                u03 u03Var = (u03) this.f40b;
                if (u03Var.f27062d) {
                    u03Var.f27062d = false;
                    u03Var.f27061c.unbindService(u03Var);
                    return;
                }
                throw new IllegalStateException("bindService must be called before unbind");
            case 26:
                ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.Companion;
                ProcessLifecycleOwner this$02 = (ProcessLifecycleOwner) this.f40b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                this$02.dispatchPauseIfNeeded$lifecycle_process_release();
                this$02.dispatchStopIfNeeded$lifecycle_process_release();
                return;
            case 27:
                View view = (View) this.f40b;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                return;
            case 28:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) this.f40b;
                Surface surface = sphericalGLSurfaceView.f12905h;
                if (surface != null) {
                    Iterator it3 = sphericalGLSurfaceView.f12898a.iterator();
                    while (it3.hasNext()) {
                        ((SphericalGLSurfaceView.VideoSurfaceListener) it3.next()).onVideoSurfaceDestroyed(surface);
                    }
                }
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f12904g;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                sphericalGLSurfaceView.f12904g = null;
                sphericalGLSurfaceView.f12905h = null;
                return;
            default:
                int i7 = SsMediaSource.f11641A;
                ((SsMediaSource) this.f40b).m2829b();
                return;
        }
    }
}
