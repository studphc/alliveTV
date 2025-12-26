package p000;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.C0095d;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.recyclerview.widget.C0494n;
import androidx.recyclerview.widget.C0496o;
import androidx.recyclerview.widget.C0498p;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzhv;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlw;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzr;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.coroutines.internal.LimitedDispatcher;

/* loaded from: classes2.dex */
public final class xy1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28765a;

    /* renamed from: b */
    public Object f28766b;

    /* renamed from: c */
    public final Object f28767c;

    public /* synthetic */ xy1(int i, Object obj, Object obj2) {
        this.f28765a = i;
        this.f28767c = obj;
        this.f28766b = obj2;
    }

    /* renamed from: a */
    private final void m8201a() {
        try {
            m8205d();
        } catch (Error e) {
            synchronized (((sg2) this.f28767c).f26421b) {
                ((sg2) this.f28767c).f26422c = 1;
                throw e;
            }
        }
    }

    /* renamed from: b */
    private final void m8202b() {
        synchronized (((pb3) this.f28767c).f25110c) {
            try {
                OnCompleteListener onCompleteListener = (OnCompleteListener) ((pb3) this.f28767c).f25111d;
                if (onCompleteListener != null) {
                    onCompleteListener.onComplete((Task) this.f28766b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    private final void m8203c() {
        synchronized (((pb3) this.f28767c).f25110c) {
            try {
                OnFailureListener onFailureListener = (OnFailureListener) ((pb3) this.f28767c).f25111d;
                if (onFailureListener != null) {
                    onFailureListener.onFailure((Exception) Preconditions.checkNotNull(((Task) this.f28766b).getException()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        ((java.lang.Runnable) r10.f28766b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        r10.f28766b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        p000.rg2.f25961f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f28766b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m8204e() {
        boolean z = false;
        boolean z2 = false;
        while (true) {
            try {
                synchronized (((rg2) this.f28767c).f25963b) {
                    if (!z) {
                        rg2 rg2Var = (rg2) this.f28767c;
                        if (rg2Var.f25964c != 4) {
                            rg2Var.f25965d++;
                            rg2Var.f25964c = 4;
                            z = true;
                        }
                    }
                    Runnable runnable = (Runnable) ((rg2) this.f28767c).f25963b.poll();
                    this.f28766b = runnable;
                    if (runnable == null) {
                        ((rg2) this.f28767c).f25964c = 1;
                    }
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                    return;
                }
                return;
            } finally {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        ((java.lang.Runnable) r10.f28766b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        r4 = p000.sg2.f26419f;
        r5 = java.util.logging.Level.SEVERE;
        r6 = java.lang.String.valueOf((java.lang.Runnable) r10.f28766b);
        r8 = new java.lang.StringBuilder(r6.length() + 35);
        r8.append("Exception while executing runnable ");
        r8.append(r6);
        r4.log(r5, r8.toString(), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        r10.f28766b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (r1 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m8205d() {
        switch (this.f28765a) {
            case 15:
                m8204e();
                return;
            default:
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    try {
                        synchronized (((sg2) this.f28767c).f26421b) {
                            if (!z) {
                                sg2 sg2Var = (sg2) this.f28767c;
                                if (sg2Var.f26422c != 4) {
                                    sg2Var.f26423d++;
                                    sg2Var.f26422c = 4;
                                    z = true;
                                }
                            }
                            Runnable runnable = (Runnable) ((sg2) this.f28767c).f26421b.poll();
                            this.f28766b = runnable;
                            if (runnable == null) {
                                ((sg2) this.f28767c).f26422c = 1;
                                break;
                            }
                        }
                        if (!z2) {
                            return;
                        }
                    } finally {
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        MenuBuilder menuBuilder;
        Object obj;
        MenuBuilder menuBuilder2;
        View view;
        View view2;
        GoogleApiClient googleApiClient;
        int i = 0;
        switch (this.f28765a) {
            case 0:
                ((ObservableSubscribeOn) this.f28767c).source.subscribe((wy1) this.f28766b);
                return;
            case 1:
                C0095d c0095d = (C0095d) this.f28767c;
                menuBuilder = ((BaseMenuPresenter) c0095d).mMenu;
                if (menuBuilder != null) {
                    menuBuilder2 = ((BaseMenuPresenter) c0095d).mMenu;
                    menuBuilder2.changeMenuMode();
                }
                obj = ((BaseMenuPresenter) c0095d).mMenuView;
                View view3 = (View) obj;
                if (view3 != null && view3.getWindowToken() != null) {
                    C1378k4 c1378k4 = (C1378k4) this.f28766b;
                    if (c1378k4.tryShow()) {
                        c0095d.f1607o = c1378k4;
                    }
                }
                c0095d.f1609q = null;
                return;
            case 2:
                ((C1675p5) this.f28766b).f25035a = this.f28767c;
                return;
            case 3:
                ((Application) this.f28766b).unregisterActivityLifecycleCallbacks((C1675p5) this.f28767c);
                return;
            case 4:
                try {
                    Method method = AbstractC1712q5.f25449d;
                    Object obj2 = this.f28767c;
                    Object obj3 = this.f28766b;
                    if (method != null) {
                        method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        AbstractC1712q5.f25450e.invoke(obj3, obj2, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 5:
                ArrayList arrayList = (ArrayList) this.f28766b;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) this.f28767c;
                    if (hasNext) {
                        C0498p c0498p = (C0498p) it.next();
                        defaultItemAnimator.getClass();
                        RecyclerView.ViewHolder viewHolder = c0498p.f7454a;
                        if (viewHolder == null) {
                            view = null;
                        } else {
                            view = viewHolder.itemView;
                        }
                        RecyclerView.ViewHolder viewHolder2 = c0498p.f7455b;
                        if (viewHolder2 != null) {
                            view2 = viewHolder2.itemView;
                        } else {
                            view2 = null;
                        }
                        ArrayList arrayList2 = defaultItemAnimator.f6974r;
                        if (view != null) {
                            ViewPropertyAnimator duration = view.animate().setDuration(defaultItemAnimator.getChangeDuration());
                            arrayList2.add(c0498p.f7454a);
                            duration.translationX(c0498p.f7458e - c0498p.f7456c);
                            duration.translationY(c0498p.f7459f - c0498p.f7457d);
                            duration.alpha(RecyclerView.f7068F0).setListener(new C0494n(defaultItemAnimator, c0498p, duration, view)).start();
                        }
                        if (view2 != null) {
                            ViewPropertyAnimator animate = view2.animate();
                            arrayList2.add(c0498p.f7455b);
                            animate.translationX(RecyclerView.f7068F0).translationY(RecyclerView.f7068F0).setDuration(defaultItemAnimator.getChangeDuration()).alpha(1.0f).setListener(new C0496o(defaultItemAnimator, c0498p, animate, view2)).start();
                        }
                    } else {
                        arrayList.clear();
                        defaultItemAnimator.f6970n.remove(arrayList);
                        return;
                    }
                }
            case 6:
                pa0 pa0Var = (pa0) this.f28766b;
                pa0Var.f25094b.replace(((ExecutorScheduler) this.f28767c).scheduleDirect(pa0Var));
                return;
            case 7:
                ((bl0) this.f28767c).f8059a.onNext(this.f28766b);
                return;
            case 8:
                break;
            case 9:
                ((MaybeSource) this.f28767c).subscribe((jj1) this.f28766b);
                return;
            case 10:
                ((hv1) this.f28767c).f18197a.onNext(this.f28766b);
                return;
            case 11:
                ((zs0) this.f28766b).accept(this.f28767c);
                return;
            case 12:
                ((CancellableContinuation) this.f28767c).resumeUndispatched((ExecutorCoroutineDispatcherImpl) this.f28766b, Unit.INSTANCE);
                return;
            case 13:
                CompletableObserver completableObserver = (CompletableObserver) this.f28766b;
                try {
                    ((Runnable) this.f28767c).run();
                    return;
                } finally {
                    completableObserver.onComplete();
                }
            case 14:
                View view4 = (View) this.f28766b;
                int left = view4.getLeft();
                ScrollingTabContainerView scrollingTabContainerView = (ScrollingTabContainerView) this.f28767c;
                scrollingTabContainerView.smoothScrollTo(left - ((scrollingTabContainerView.getWidth() - view4.getWidth()) / 2), 0);
                scrollingTabContainerView.f1347a = null;
                return;
            case 15:
                try {
                    m8205d();
                    return;
                } catch (Error e2) {
                    synchronized (((rg2) this.f28767c).f25963b) {
                        ((rg2) this.f28767c).f25964c = 1;
                        throw e2;
                    }
                }
            case 16:
                m8201a();
                return;
            case 17:
                ((pi2) this.f28767c).f25191b.onError((Throwable) this.f28766b);
                return;
            case 18:
                ((pi2) this.f28767c).f25191b.onSuccess(this.f28766b);
                return;
            case 19:
                ((iv2) this.f28766b).f20283d = true;
                ((jv2) this.f28767c).f20651a.remove((iv2) this.f28766b);
                return;
            case 20:
                Api.AbstractClientBuilder abstractClientBuilder = zact.f13277h;
                zak zakVar = (zak) this.f28766b;
                ConnectionResult zaa = zakVar.zaa();
                boolean isSuccess = zaa.isSuccess();
                zact zactVar = (zact) this.f28767c;
                if (isSuccess) {
                    zav zavVar = (zav) Preconditions.checkNotNull(zakVar.zab());
                    ConnectionResult zaa2 = zavVar.zaa();
                    if (!zaa2.isSuccess()) {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(zaa2)), new Exception());
                        zactVar.f13284g.zae(zaa2);
                        zactVar.f13283f.disconnect();
                        return;
                    }
                    zactVar.f13284g.zaf(zavVar.zab(), zactVar.f13281d);
                } else {
                    zactVar.f13284g.zae(zaa);
                }
                zactVar.f13283f.disconnect();
                return;
            case 21:
                Result result = (Result) this.f28766b;
                zada zadaVar = (zada) this.f28767c;
                try {
                    try {
                        C1851tx c1851tx = BasePendingResult.f13088n;
                        c1851tx.set(Boolean.TRUE);
                        PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(zadaVar.f13285a)).onSuccess(result);
                        p73 p73Var = zadaVar.f13292h;
                        p73Var.sendMessage(p73Var.obtainMessage(0, onSuccess));
                        c1851tx.set(Boolean.FALSE);
                        zada.m3123d(result);
                        googleApiClient = (GoogleApiClient) zadaVar.f13291g.get();
                        if (googleApiClient == null) {
                            return;
                        }
                    } catch (RuntimeException e3) {
                        p73 p73Var2 = zadaVar.f13292h;
                        p73Var2.sendMessage(p73Var2.obtainMessage(1, e3));
                        BasePendingResult.f13088n.set(Boolean.FALSE);
                        zada.m3123d(result);
                        googleApiClient = (GoogleApiClient) zadaVar.f13291g.get();
                        if (googleApiClient == null) {
                            return;
                        }
                    }
                    googleApiClient.zap(zadaVar);
                    return;
                } catch (Throwable th2) {
                    BasePendingResult.f13088n.set(Boolean.FALSE);
                    zada.m3123d(result);
                    GoogleApiClient googleApiClient2 = (GoogleApiClient) zadaVar.f13291g.get();
                    if (googleApiClient2 != null) {
                        googleApiClient2.zap(zadaVar);
                    }
                    throw th2;
                }
            case 22:
                hc3 hc3Var = (hc3) this.f28766b;
                hc3Var.zzaV();
                if (zzaf.zza()) {
                    hc3Var.zzaX().zzq(this);
                    return;
                }
                w93 w93Var = (w93) this.f28767c;
                if (w93Var.f28111c != 0) {
                    i = 1;
                }
                w93Var.f28111c = 0L;
                if (i != 0) {
                    w93Var.mo3493b();
                    return;
                }
                return;
            case 23:
                Task task = (Task) this.f28766b;
                boolean isCanceled = task.isCanceled();
                la3 la3Var = (la3) this.f28767c;
                if (isCanceled) {
                    la3Var.f22430d.m4715c();
                    return;
                }
                try {
                    la3Var.f22430d.m4714b(la3Var.f22429c.then(task));
                    return;
                } catch (RuntimeExecutionException e4) {
                    if (e4.getCause() instanceof Exception) {
                        la3Var.f22430d.m4713a((Exception) e4.getCause());
                        return;
                    } else {
                        la3Var.f22430d.m4713a(e4);
                        return;
                    }
                } catch (Exception e5) {
                    la3Var.f22430d.m4713a(e5);
                    return;
                }
            case 24:
                la3 la3Var2 = (la3) this.f28767c;
                try {
                    Task task2 = (Task) la3Var2.f22429c.then((Task) this.f28766b);
                    if (task2 == null) {
                        la3Var2.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    d40 d40Var = TaskExecutors.f14453a;
                    task2.addOnSuccessListener(d40Var, la3Var2);
                    task2.addOnFailureListener(d40Var, la3Var2);
                    task2.addOnCanceledListener(d40Var, la3Var2);
                    return;
                } catch (RuntimeExecutionException e6) {
                    if (e6.getCause() instanceof Exception) {
                        la3Var2.f22430d.m4713a((Exception) e6.getCause());
                        return;
                    } else {
                        la3Var2.f22430d.m4713a(e6);
                        return;
                    }
                } catch (Exception e7) {
                    la3Var2.f22430d.m4713a(e7);
                    return;
                }
            case 25:
                zzhv zzhvVar = (zzhv) this.f28767c;
                String str = zzhvVar.f14222a;
                zzio zzioVar = zzhvVar.f14223b.f14224a;
                zzioVar.zzaX().zzg();
                Bundle bundle = new Bundle();
                bundle.putString("package_name", str);
                try {
                    if (((zzbr) this.f28766b).zze(bundle) == null) {
                        zzioVar.zzaW().zze().zza("Install Referrer Service returned a null response");
                    }
                } catch (Exception e8) {
                    zzioVar.zzaW().zze().zzb("Exception occurred while retrieving the Install Referrer", e8.getMessage());
                }
                zzioVar.zzaX().zzg();
                throw new IllegalStateException("Unexpected call on client side");
            case 26:
                m8202b();
                return;
            case 27:
                zzjp zzjpVar = (zzjp) this.f28767c;
                zzjpVar.f14280a.m3643c();
                zzai zzaiVar = (zzai) this.f28766b;
                Object zza = zzaiVar.zzc.zza();
                zzpv zzpvVar = zzjpVar.f14280a;
                if (zza == null) {
                    zzpvVar.getClass();
                    zzr m3656r = zzpvVar.m3656r((String) Preconditions.checkNotNull(zzaiVar.zza));
                    if (m3656r != null) {
                        zzpvVar.m3621H(zzaiVar, m3656r);
                        return;
                    }
                    return;
                }
                zzpvVar.getClass();
                zzr m3656r2 = zzpvVar.m3656r((String) Preconditions.checkNotNull(zzaiVar.zza));
                if (m3656r2 != null) {
                    zzpvVar.m3626M(zzaiVar, m3656r2);
                    return;
                }
                return;
            case 28:
                m8203c();
                return;
            default:
                ((zzlw) this.f28767c).m3573i((Boolean) this.f28766b, true);
                return;
        }
        while (true) {
            try {
                ((Runnable) this.f28766b).run();
            } catch (Throwable th3) {
                CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th3);
            }
            LimitedDispatcher limitedDispatcher = (LimitedDispatcher) this.f28767c;
            Runnable access$obtainTaskOrDeallocateWorker = LimitedDispatcher.access$obtainTaskOrDeallocateWorker(limitedDispatcher);
            if (access$obtainTaskOrDeallocateWorker != null) {
                this.f28766b = access$obtainTaskOrDeallocateWorker;
                i++;
                if (i >= 16 && LimitedDispatcher.access$getDispatcher$p(limitedDispatcher).isDispatchNeeded(limitedDispatcher)) {
                    LimitedDispatcher.access$getDispatcher$p(limitedDispatcher).dispatch(limitedDispatcher, this);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        String str;
        String str2;
        switch (this.f28765a) {
            case 15:
                Runnable runnable = (Runnable) this.f28766b;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i = ((rg2) this.f28767c).f25964c;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                str = "null";
                            } else {
                                str = DebugCoroutineInfoImplKt.RUNNING;
                            }
                        } else {
                            str = "QUEUED";
                        }
                    } else {
                        str = "QUEUING";
                    }
                } else {
                    str = "IDLE";
                }
                sb.append(str);
                sb.append("}");
                return sb.toString();
            case 16:
                Runnable runnable2 = (Runnable) this.f28766b;
                if (runnable2 != null) {
                    String valueOf = String.valueOf(runnable2);
                    return AbstractC1726qj.m7059o("SequentialExecutorWorker{running=", valueOf, "}", valueOf.length() + 34);
                }
                int i2 = ((sg2) this.f28767c).f26422c;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                str2 = "null";
                            } else {
                                str2 = DebugCoroutineInfoImplKt.RUNNING;
                            }
                        } else {
                            str2 = "QUEUED";
                        }
                    } else {
                        str2 = "QUEUING";
                    }
                } else {
                    str2 = "IDLE";
                }
                return AbstractC1726qj.m7059o("SequentialExecutorWorker{state=", str2, "}", str2.length() + 32);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ xy1(int i, Object obj, Object obj2, boolean z) {
        this.f28765a = i;
        this.f28766b = obj;
        this.f28767c = obj2;
    }

    public xy1(zzhv zzhvVar, zzbr zzbrVar, zzhv zzhvVar2) {
        this.f28765a = 25;
        this.f28766b = zzbrVar;
        this.f28767c = zzhvVar;
    }

    public /* synthetic */ xy1(Executor executor, int i) {
        this.f28765a = i;
        this.f28767c = executor;
    }
}
