package p000;

import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.C0086g;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.customview.widget.ViewDragHelper;
import androidx.leanback.app.ProgressBarManager;
import androidx.leanback.app.VerticalGridFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.recyclerview.widget.C0471f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.TileList$Tile;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.RequestManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.C0743a;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzhw;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzlw;
import com.google.android.gms.measurement.internal.zzmo;
import com.google.android.gms.measurement.internal.zzoa;
import com.google.android.gms.measurement.internal.zzoy;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzpw;
import com.google.android.gms.measurement.internal.zzx;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.SlidingPanel;
import com.hisona.allive.VolumePanel;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
public final class sn1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f26502a;

    /* renamed from: b */
    public Object f26503b;

    public /* synthetic */ sn1() {
        this.f26502a = 9;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v45, types: [re3, l93] */
    /* JADX WARN: Type inference failed for: r1v46, types: [re3, gd3] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        ListenableFuture listenableFuture;
        MenuBuilder menuBuilder;
        String str;
        switch (this.f26502a) {
            case 0:
                break;
            case 1:
                ((View) this.f26503b).setNestedScrollingEnabled(true);
                return;
            case 2:
                ((wz1) this.f26503b).f28407c.dispose();
                return;
            case 3:
                ((j02) this.f26503b).m4899d();
                return;
            case 4:
                ProgressBarManager progressBarManager = (ProgressBarManager) this.f26503b;
                if (progressBarManager.f5203e) {
                    boolean z = progressBarManager.f5204f;
                    if ((z || progressBarManager.f5200b != null) && progressBarManager.f5205g) {
                        View view = progressBarManager.f5201c;
                        if (view == null) {
                            progressBarManager.f5201c = new ProgressBar(progressBarManager.f5200b.getContext(), null, R.attr.progressBarStyleLarge);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 17;
                            progressBarManager.f5200b.addView(progressBarManager.f5201c, layoutParams);
                            return;
                        }
                        if (z) {
                            view.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                RecyclerView recyclerView = (RecyclerView) this.f26503b;
                if (recyclerView.f7142v && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.f7138t) {
                        recyclerView.requestLayout();
                        return;
                    } else if (recyclerView.f7148y) {
                        recyclerView.f7146x = true;
                        return;
                    } else {
                        recyclerView.m1714m();
                        return;
                    }
                }
                return;
            case 6:
                RequestManager requestManager = (RequestManager) this.f26503b;
                requestManager.f8533a.addListener(requestManager);
                return;
            case 7:
                ((SlidingPanel) this.f26503b).hideSlidingPanel(true);
                return;
            case 8:
                ((StaggeredGridLayoutManager) this.f26503b).m1795n();
                return;
            case 9:
                wt2 wt2Var = (wt2) this.f26503b;
                if (wt2Var != null && (listenableFuture = wt2Var.f28329h) != null) {
                    this.f26503b = null;
                    if (listenableFuture.isDone()) {
                        wt2Var.setFuture(listenableFuture);
                        return;
                    }
                    try {
                        ScheduledFuture scheduledFuture = wt2Var.f28330i;
                        wt2Var.f28330i = null;
                        String str2 = "Timed out";
                        if (scheduledFuture != null) {
                            try {
                                long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                                if (abs > 10) {
                                    StringBuilder sb = new StringBuilder("Timed out".length() + 66);
                                    sb.append("Timed out (timeout delayed by ");
                                    sb.append(abs);
                                    sb.append(" ms after scheduled time)");
                                    str2 = sb.toString();
                                }
                            } catch (Throwable th) {
                                wt2Var.setException(new TimeoutException(str2));
                                throw th;
                            }
                        }
                        String valueOf = String.valueOf(str2);
                        String valueOf2 = String.valueOf(listenableFuture);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
                        sb2.append(valueOf);
                        sb2.append(": ");
                        sb2.append(valueOf2);
                        wt2Var.setException(new TimeoutException(sb2.toString()));
                        return;
                    } finally {
                        listenableFuture.cancel(true);
                    }
                }
                return;
            case 10:
                ((Toolbar) this.f26503b).showOverflowMenu();
                return;
            case 11:
                C0086g c0086g = (C0086g) this.f26503b;
                Window.Callback callback = c0086g.f739b;
                boolean z2 = c0086g.f742e;
                ToolbarWidgetWrapper toolbarWidgetWrapper = c0086g.f738a;
                if (!z2) {
                    toolbarWidgetWrapper.setMenuCallbacks(new mu2(c0086g), new nu2(c0086g));
                    c0086g.f742e = true;
                }
                Menu menu = toolbarWidgetWrapper.getMenu();
                if (menu instanceof MenuBuilder) {
                    menuBuilder = (MenuBuilder) menu;
                } else {
                    menuBuilder = null;
                }
                if (menuBuilder != null) {
                    menuBuilder.stopDispatchingItemsChanged();
                }
                try {
                    menu.clear();
                    if (callback.onCreatePanelMenu(0, menu)) {
                        if (!callback.onPreparePanel(0, null, menu)) {
                        }
                        if (menuBuilder == null) {
                            menuBuilder.startDispatchingItemsChanged();
                            return;
                        }
                        return;
                    }
                    menu.clear();
                    if (menuBuilder == null) {
                    }
                } catch (Throwable th2) {
                    if (menuBuilder != null) {
                        menuBuilder.startDispatchingItemsChanged();
                    }
                    throw th2;
                }
            case 12:
                VerticalGridFragment verticalGridFragment = (VerticalGridFragment) this.f26503b;
                verticalGridFragment.f5287A.setEntranceTransitionState(verticalGridFragment.f5288B, true);
                return;
            case 13:
                VerticalGridSupportFragment verticalGridSupportFragment = (VerticalGridSupportFragment) this.f26503b;
                verticalGridSupportFragment.f5298E0.setEntranceTransitionState(verticalGridSupportFragment.f5299F0, true);
                return;
            case 14:
                ((ViewDragHelper) this.f26503b).m1044k(0);
                return;
            case 15:
                ViewPager viewPager = (ViewPager) this.f26503b;
                viewPager.setScrollState(0);
                viewPager.m1945o();
                return;
            case 16:
                ((VolumePanel) this.f26503b).hideVolumePanel();
                return;
            case 17:
                zaaw zaawVar = (zaaw) this.f26503b;
                zaawVar.f13198d.cancelAvailabilityErrorNotifications(zaawVar.f13197c);
                return;
            case 18:
                ((zabq) this.f26503b).m3117f();
                return;
            case 19:
                ((zact) this.f26503b).f13284g.zae(new ConnectionResult(4));
                return;
            case 20:
                C0743a c0743a = (C0743a) this.f26503b;
                c0743a.f13177m.lock();
                try {
                    C0743a.m3092d(c0743a);
                    return;
                } finally {
                    c0743a.f13177m.unlock();
                }
            case 21:
                synchronized (((pb3) this.f26503b).f25110c) {
                    try {
                        OnCanceledListener onCanceledListener = (OnCanceledListener) ((pb3) this.f26503b).f25111d;
                        if (onCanceledListener != null) {
                            onCanceledListener.onCanceled();
                        }
                    } finally {
                    }
                }
                return;
            case 22:
                ((tb3) this.f26503b).f26768a.m3661x();
                return;
            case 23:
                zzx zzxVar = ((zzlw) this.f26503b).f14314p;
                zzio zzioVar = zzxVar.f14413a;
                zzioVar.zzaX().zzg();
                if (zzxVar.m3745b()) {
                    if (zzxVar.m3746c()) {
                        zzioVar.zzm().f27214w.zzb(null);
                        Bundle bundle = new Bundle();
                        bundle.putString(FirebaseAnalytics.Param.SOURCE, "(not set)");
                        bundle.putString(FirebaseAnalytics.Param.MEDIUM, "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        zzioVar.zzq().m3567c(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmpx", bundle);
                    } else {
                        String zza = zzioVar.zzm().f27214w.zza();
                        if (TextUtils.isEmpty(zza)) {
                            zzioVar.zzaW().zzh().zza("Cache still valid but referrer not found");
                        } else {
                            long zza2 = zzioVar.zzm().f27215x.zza() / 3600000;
                            Uri parse = Uri.parse(zza);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(parse.getPath(), bundle2);
                            for (String str3 : parse.getQueryParameterNames()) {
                                bundle2.putString(str3, parse.getQueryParameter(str3));
                            }
                            ((Bundle) pair.second).putLong("_cc", (zza2 - 1) * 3600000);
                            Object obj = pair.first;
                            if (obj == null) {
                                str = "app";
                            } else {
                                str = (String) obj;
                            }
                            zzioVar.zzq().m3567c(str, "_cmp", (Bundle) pair.second);
                        }
                        zzioVar.zzm().f27214w.zzb(null);
                    }
                    zzioVar.zzm().f27215x.zzb(0L);
                    return;
                }
                return;
            case 24:
                ((zzmo) this.f26503b).f14331h = null;
                return;
            default:
                zzpv zzpvVar = (zzpv) this.f26503b;
                zzpvVar.zzaX().zzg();
                zzpvVar.f14379k = new zzhw(zzpvVar);
                v93 v93Var = new v93(zzpvVar);
                v93Var.zzaw();
                zzpvVar.f14371c = v93Var;
                zzpvVar.zzi().f14123c = (r93) Preconditions.checkNotNull(zzpvVar.f14369a);
                zzoa zzoaVar = new zzoa(zzpvVar);
                zzoaVar.zzaw();
                zzpvVar.f14377i = zzoaVar;
                ?? re3Var = new re3(zzpvVar);
                re3Var.zzaw();
                zzpvVar.f14374f = re3Var;
                ?? re3Var2 = new re3(zzpvVar);
                re3Var2.zzaw();
                zzpvVar.f14376h = re3Var2;
                zzoy zzoyVar = new zzoy(zzpvVar);
                zzoyVar.zzaw();
                zzpvVar.f14373e = zzoyVar;
                zzpvVar.f14372d = new tb3(zzpvVar);
                if (zzpvVar.f14386r != zzpvVar.f14387s) {
                    zzpvVar.zzaW().zze().zzc("Not all upload components initialized", Integer.valueOf(zzpvVar.f14386r), Integer.valueOf(zzpvVar.f14387s));
                }
                zzpvVar.f14381m.set(true);
                zzpvVar.zzaW().zzj().zza("UploadController is now fully initialized");
                zzpvVar.zzam();
                return;
        }
        while (true) {
            tn1 tn1Var = (tn1) this.f26503b;
            un1 m6100j = tn1Var.f26900a.m6100j();
            if (m6100j == null) {
                tn1Var.f26902c.set(false);
                return;
            }
            int i = m6100j.f27386a;
            C1540m9 c1540m9 = tn1Var.f26900a;
            C0471f c0471f = tn1Var.f26904e;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + m6100j.f27386a);
                        } else {
                            c0471f.recycleTile((TileList$Tile) m6100j.f27393h);
                        }
                    } else {
                        c0471f.loadTile(m6100j.f27387b, m6100j.f27388c);
                    }
                } else {
                    c1540m9.m6106p(2);
                    c1540m9.m6106p(3);
                    c0471f.updateRange(m6100j.f27387b, m6100j.f27388c, m6100j.f27389d, m6100j.f27390e, m6100j.f27391f);
                }
            } else {
                c1540m9.m6106p(1);
                c0471f.refresh(m6100j.f27387b);
            }
        }
    }

    public /* synthetic */ sn1(int i, Object obj) {
        this.f26502a = i;
        this.f26503b = obj;
    }

    public sn1(zzpv zzpvVar, zzpw zzpwVar) {
        this.f26502a = 25;
        this.f26503b = zzpvVar;
    }

    public sn1(tb3 tb3Var, boolean z) {
        this.f26502a = 22;
        this.f26503b = tb3Var;
    }
}
