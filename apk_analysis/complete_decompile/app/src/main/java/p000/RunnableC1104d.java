package p000;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;
import androidx.drawerlayout.widget.C0232b;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.leanback.media.MediaPlayerGlue;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.GridLayoutManager;
import androidx.lifecycle.LiveData;
import androidx.media.C0431h;
import androidx.recyclerview.widget.C0468e;
import androidx.recyclerview.widget.C0504s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.TileList$Tile;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.ClosingFuture;
import com.hisona.allive.IntroActivity;
import com.hisona.allive.MainActivity;
import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http.HttpStatusCodesKt;

/* renamed from: d */
/* loaded from: classes.dex */
public final class RunnableC1104d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16187a;

    /* renamed from: b */
    public final /* synthetic */ Object f16188b;

    public /* synthetic */ RunnableC1104d(int i, Object obj) {
        this.f16187a = i;
        this.f16188b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2042z2 c2042z2;
        boolean z;
        View m1051c;
        int width;
        int i;
        Object obj;
        int i2 = 3;
        switch (this.f16187a) {
            case 0:
                ((ActionBarContextView) this.f16188b).showOverflowMenu();
                return;
            case 1:
                C1105d0 c1105d0 = (C1105d0) this.f16188b;
                try {
                    ((AbstractExecutionThreadService) c1105d0.f16190q).startUp();
                    c1105d0.notifyStarted();
                    if (c1105d0.isRunning()) {
                        try {
                            ((AbstractExecutionThreadService) c1105d0.f16190q).run();
                        } catch (Throwable th) {
                            try {
                                ((AbstractExecutionThreadService) c1105d0.f16190q).shutDown();
                            } catch (Exception e) {
                                AbstractExecutionThreadService.f15249b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                            }
                            c1105d0.notifyFailed(th);
                            return;
                        }
                    }
                    ((AbstractExecutionThreadService) c1105d0.f16190q).shutDown();
                    c1105d0.notifyStopped();
                    return;
                } catch (Throwable th2) {
                    c1105d0.notifyFailed(th2);
                    return;
                }
            case 2:
                ((C2042z2) this.f16188b).f29223r.lock();
                try {
                    InterfaceC2005y2 interfaceC2005y2 = ((C2042z2) this.f16188b).f29221p;
                    Objects.requireNonNull(interfaceC2005y2);
                    if (interfaceC2005y2.isCancelled()) {
                        c2042z2 = (C2042z2) this.f16188b;
                    } else {
                        ((C2042z2) this.f16188b).f29225t.runOneIteration();
                        c2042z2 = (C2042z2) this.f16188b;
                    }
                } catch (Throwable th3) {
                    try {
                        try {
                            ((C2042z2) this.f16188b).f29225t.shutDown();
                        } catch (Throwable th4) {
                            ((C2042z2) this.f16188b).f29223r.unlock();
                            throw th4;
                        }
                    } catch (Exception e2) {
                        AbstractScheduledService.f15260b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e2);
                    }
                    ((C2042z2) this.f16188b).notifyFailed(th3);
                    InterfaceC2005y2 interfaceC2005y22 = ((C2042z2) this.f16188b).f29221p;
                    Objects.requireNonNull(interfaceC2005y22);
                    interfaceC2005y22.cancel();
                    c2042z2 = (C2042z2) this.f16188b;
                }
                c2042z2.f29223r.unlock();
                return;
            case 3:
                C1748r4 c1748r4 = (C1748r4) this.f16188b;
                while (!c1748r4.f25863f) {
                    try {
                        c1748r4.m7216b((C1711q4) c1748r4.f25861d.remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                return;
            case 4:
                LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = (LayoutInflaterFactory2C0084e) this.f16188b;
                if ((layoutInflaterFactory2C0084e.f712a0 & 1) != 0) {
                    layoutInflaterFactory2C0084e.m185n(0);
                }
                if ((layoutInflaterFactory2C0084e.f712a0 & 4096) != 0) {
                    layoutInflaterFactory2C0084e.m185n(108);
                }
                layoutInflaterFactory2C0084e.f711Z = false;
                layoutInflaterFactory2C0084e.f712a0 = 0;
                return;
            case 5:
                AutoScrollHelper autoScrollHelper = (AutoScrollHelper) this.f16188b;
                if (autoScrollHelper.f4040o) {
                    boolean z2 = autoScrollHelper.f4038m;
                    C1794sd c1794sd = autoScrollHelper.f4026a;
                    if (z2) {
                        autoScrollHelper.f4038m = false;
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        c1794sd.f26384e = currentAnimationTimeMillis;
                        c1794sd.f26386g = -1L;
                        c1794sd.f26385f = currentAnimationTimeMillis;
                        c1794sd.f26387h = 0.5f;
                    }
                    if ((c1794sd.f26386g > 0 && AnimationUtils.currentAnimationTimeMillis() > c1794sd.f26386g + c1794sd.f26388i) || !autoScrollHelper.m1016e()) {
                        autoScrollHelper.f4040o = false;
                        return;
                    }
                    boolean z3 = autoScrollHelper.f4039n;
                    View view = autoScrollHelper.f4028c;
                    if (z3) {
                        autoScrollHelper.f4039n = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, RecyclerView.f7068F0, RecyclerView.f7068F0, 0);
                        view.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (c1794sd.f26385f != 0) {
                        long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float m7359a = c1794sd.m7359a(currentAnimationTimeMillis2);
                        long j = currentAnimationTimeMillis2 - c1794sd.f26385f;
                        c1794sd.f26385f = currentAnimationTimeMillis2;
                        float f = ((float) j) * ((m7359a * 4.0f) + ((-4.0f) * m7359a * m7359a));
                        autoScrollHelper.scrollTargetBy((int) (c1794sd.f26382c * f), (int) (f * c1794sd.f26383d));
                        ViewCompat.postOnAnimation(view, this);
                        return;
                    }
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                return;
            case 6:
                ((C1266he) this.f16188b).f18037b.m1256c();
                return;
            case 7:
                ((BaseCardView) this.f16188b).m1382a(true);
                return;
            case 8:
                try {
                    ((Closeable) this.f16188b).close();
                    return;
                } catch (IOException | RuntimeException e3) {
                    ClosingFuture.f15283d.log(Level.WARNING, "thrown by close()", e3);
                    return;
                }
            case 9:
                EnumC1917vp enumC1917vp = EnumC1917vp.f27906c;
                EnumC1917vp enumC1917vp2 = EnumC1917vp.f27907d;
                Logger logger = ClosingFuture.f15283d;
                ClosingFuture closingFuture = (ClosingFuture) this.f16188b;
                Preconditions.checkState(closingFuture.m4323d(enumC1917vp, enumC1917vp2), "Expected state to be %s, but it was %s", enumC1917vp, enumC1917vp2);
                closingFuture.m4322b();
                EnumC1917vp enumC1917vp3 = EnumC1917vp.f27908e;
                Preconditions.checkState(closingFuture.m4323d(enumC1917vp2, enumC1917vp3), "Expected state to be %s, but it was %s", enumC1917vp2, enumC1917vp3);
                return;
            case 10:
                try {
                    ComponentActivity.m142a((ComponentActivity) this.f16188b);
                    return;
                } catch (IllegalStateException e4) {
                    if (TextUtils.equals(e4.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        return;
                    } else {
                        throw e4;
                    }
                } catch (NullPointerException e5) {
                    if (!TextUtils.equals(e5.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e5;
                    }
                    return;
                }
            case 11:
                ((m20) this.f16188b).m6009b(true, false);
                return;
            case 12:
                DialogFragment dialogFragment = (DialogFragment) this.f16188b;
                dialogFragment.f4404h0.onDismiss(dialogFragment.f4412p0);
                return;
            case 13:
                StateListDrawableCompat stateListDrawableCompat = (StateListDrawableCompat) this.f16188b;
                stateListDrawableCompat.m200a(true);
                stateListDrawableCompat.invalidateSelf();
                return;
            case 14:
                C0232b c0232b = (C0232b) this.f16188b;
                int edgeSize = c0232b.f4176b.getEdgeSize();
                int i3 = c0232b.f4175a;
                if (i3 == 3) {
                    z = true;
                } else {
                    z = false;
                }
                DrawerLayout drawerLayout = c0232b.f4178d;
                if (z) {
                    m1051c = drawerLayout.m1051c(3);
                    if (m1051c != null) {
                        i = -m1051c.getWidth();
                    } else {
                        i = 0;
                    }
                    width = i + edgeSize;
                } else {
                    m1051c = drawerLayout.m1051c(5);
                    width = drawerLayout.getWidth() - edgeSize;
                }
                if (m1051c != null) {
                    if (((z && m1051c.getLeft() < width) || (!z && m1051c.getLeft() > width)) && drawerLayout.getDrawerLockMode(m1051c) == 0) {
                        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) m1051c.getLayoutParams();
                        c0232b.f4176b.smoothSlideViewTo(m1051c, width, m1051c.getTop());
                        layoutParams.f4168b = true;
                        drawerLayout.invalidate();
                        if (i3 == 3) {
                            i2 = 5;
                        }
                        View m1051c2 = drawerLayout.m1051c(i2);
                        if (m1051c2 != null) {
                            drawerLayout.closeDrawer(m1051c2);
                        }
                        if (!drawerLayout.f4157q) {
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, RecyclerView.f7068F0, RecyclerView.f7068F0, 0);
                            int childCount = drawerLayout.getChildCount();
                            for (int i4 = 0; i4 < childCount; i4++) {
                                drawerLayout.getChildAt(i4).dispatchTouchEvent(obtain2);
                            }
                            obtain2.recycle();
                            drawerLayout.f4157q = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 15:
                e70 e70Var = (e70) this.f16188b;
                e70Var.f16696l = null;
                e70Var.drawableStateChanged();
                return;
            case 16:
                C0504s c0504s = (C0504s) this.f16188b;
                int i5 = c0504s.f7471A;
                ValueAnimator valueAnimator = c0504s.f7498z;
                if (i5 != 1) {
                    if (i5 != 2) {
                        return;
                    }
                } else {
                    valueAnimator.cancel();
                }
                c0504s.f7471A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), RecyclerView.f7068F0);
                valueAnimator.setDuration(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR);
                valueAnimator.start();
                return;
            case 17:
                ((tr0) this.f16188b).f26946c.cancel();
                return;
            case 18:
                ((hs0) this.f16188b).m4753d();
                return;
            case 19:
                SpecialEffectsController specialEffectsController = (SpecialEffectsController) this.f16188b;
                if (specialEffectsController.isPendingExecute()) {
                    specialEffectsController.executePendingOperations();
                    return;
                }
                return;
            case 20:
                ((FragmentManager) this.f16188b).m1201y(true);
                return;
            case 21:
                FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = (FullWidthDetailsOverviewSharedElementHelper) this.f16188b;
                if (!fullWidthDetailsOverviewSharedElementHelper.f5669c && fullWidthDetailsOverviewSharedElementHelper.f5667a.get() != null) {
                    ActivityCompat.startPostponedEnterTransition(fullWidthDetailsOverviewSharedElementHelper.f5668b);
                    fullWidthDetailsOverviewSharedElementHelper.f5669c = true;
                    return;
                }
                return;
            case 22:
                ((ScheduledFuture) this.f16188b).cancel(false);
                return;
            case 23:
                ((GridLayoutManager) this.f16188b).requestLayout();
                return;
            case 24:
                IntroActivity introActivity = (IntroActivity) this.f16188b;
                introActivity.startActivity(new Intent(introActivity.getApplicationContext(), (Class<?>) MainActivity.class));
                introActivity.finish();
                return;
            case 25:
                ListView listView = ((ListFragment) this.f16188b).f4617i0;
                listView.focusableViewAvailable(listView);
                return;
            case 26:
                synchronized (((LiveData) this.f16188b).f6505a) {
                    obj = ((LiveData) this.f16188b).f6510f;
                    ((LiveData) this.f16188b).f6510f = LiveData.f6504k;
                }
                ((LiveData) this.f16188b).setValue(obj);
                return;
            case 27:
                C0431h c0431h = (C0431h) this.f16188b;
                c0431h.f6707i.f6662d.remove(c0431h.f6704f.f255a.getBinder());
                return;
            case 28:
                MediaPlayerGlue mediaPlayerGlue = (MediaPlayerGlue) this.f16188b;
                mediaPlayerGlue.updateProgress();
                mediaPlayerGlue.f5408t.postDelayed(this, mediaPlayerGlue.getUpdatePeriod());
                return;
            default:
                mt2 mt2Var = (mt2) this.f16188b;
                for (un1 m6100j = ((C1540m9) mt2Var.f23107b).m6100j(); m6100j != null; m6100j = ((C1540m9) mt2Var.f23107b).m6100j()) {
                    int i6 = m6100j.f27386a;
                    C0468e c0468e = (C0468e) mt2Var.f23110e;
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                Log.e("ThreadUtil", "Unsupported message, what=" + m6100j.f27386a);
                            } else {
                                c0468e.removeTile(m6100j.f27387b, m6100j.f27388c);
                            }
                        } else {
                            c0468e.addTile(m6100j.f27387b, (TileList$Tile) m6100j.f27393h);
                        }
                    } else {
                        c0468e.updateItemCount(m6100j.f27387b, m6100j.f27388c);
                    }
                }
                return;
        }
    }
}
