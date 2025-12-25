package p000;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.leanback.app.VerticalGridFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.OnChildLaidOutListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzju;
import com.google.android.gms.measurement.internal.zzjw;
import com.google.android.gms.measurement.internal.zzjx;
import com.google.android.gms.measurement.internal.zzlw;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Splitter;
import com.google.common.collect.C0915o3;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.orhanobut.hawk.Storage;
import java.lang.reflect.Type;
import java.util.ConcurrentModificationException;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes2.dex */
public class ai2 implements Storage, DashSegmentIndex, em2, RequestManagerTreeNode, JsonSerializationContext, JsonDeserializationContext, OnChildLaidOutListener, h23, c43, ViewPropertyAnimatorUpdateListener, OnDelegateCreatedListener, zaj, OnSuccessListener, OnFailureListener, OnCanceledListener, zzgw, qd3, OnTokenCanceledListener {

    /* renamed from: a */
    public final /* synthetic */ int f215a;

    /* renamed from: b */
    public Object f216b;

    public /* synthetic */ ai2(int i, Object obj) {
        this.f215a = i;
        this.f216b = obj;
    }

    /* renamed from: g */
    public static ai2 m91g(String str) {
        zzju zzjuVar;
        if (!TextUtils.isEmpty(str) && str.length() <= 1) {
            zzjuVar = zzjx.m3563c(str.charAt(0));
        } else {
            zzjuVar = zzju.UNINITIALIZED;
        }
        return new ai2(20, zzjuVar);
    }

    @Override // p000.em2
    /* renamed from: a */
    public Iterator mo92a(Splitter splitter, CharSequence charSequence) {
        switch (this.f215a) {
            case 3:
                return new dm2(this, splitter, charSequence, 0);
            default:
                return new dm2(splitter, charSequence, new b01(((h61) this.f216b).f17953a.matcher(charSequence)));
        }
    }

    @Override // p000.h23
    /* renamed from: b */
    public void mo93b(C1294i5 c1294i5) {
        c1294i5.onDefaultDisplayChanged(((WindowManager) this.f216b).getDefaultDisplay());
    }

    @Override // p000.c43
    /* renamed from: c */
    public Animation mo94c(Context context) {
        return (Animation) this.f216b;
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean contains(String str) {
        return ((SharedPreferences) this.f216b).contains(str);
    }

    @Override // com.orhanobut.hawk.Storage
    public long count() {
        return ((SharedPreferences) this.f216b).getAll().size();
    }

    /* renamed from: d */
    public void m95d(C0915o3 c0915o3, C0915o3 c0915o32) {
        if (((C0915o3) this.f216b) == c0915o3) {
            this.f216b = c0915o32;
            return;
        }
        throw new ConcurrentModificationException();
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean delete(String str) {
        return ((SharedPreferences) this.f216b).edit().remove(str).commit();
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean deleteAll() {
        return ((SharedPreferences) this.f216b).edit().clear().commit();
    }

    @Override // com.google.gson.JsonDeserializationContext
    public Object deserialize(JsonElement jsonElement, Type type) {
        return ((TreeTypeAdapter) this.f216b).f15772c.fromJson(jsonElement, type);
    }

    /* renamed from: e */
    public void mo96e() {
        View view = (View) this.f216b;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: f */
    public void mo97f() {
        View view;
        View view2 = (View) this.f216b;
        if (view2 == null) {
            return;
        }
        if (!view2.isInEditMode() && !view2.onCheckIsTextEditor()) {
            view = view2.getRootView().findFocus();
        } else {
            view2.requestFocus();
            view = view2;
        }
        if (view == null) {
            view = view2.getRootView().findViewById(R.id.content);
        }
        if (view != null && view.hasWindowFocus()) {
            view.post(new RunnableC0006a5(27, view));
        }
    }

    @Override // com.orhanobut.hawk.Storage
    public Object get(String str) {
        return ((SharedPreferences) this.f216b).getString(str, null);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getAvailableSegmentCount(long j, long j2) {
        return 1L;
    }

    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set getDescendants() {
        Set<SupportRequestManagerFragment> m2373l = ((SupportRequestManagerFragment) this.f216b).m2373l();
        HashSet hashSet = new HashSet(m2373l.size());
        for (SupportRequestManagerFragment supportRequestManagerFragment : m2373l) {
            if (supportRequestManagerFragment.getRequestManager() != null) {
                hashSet.add(supportRequestManagerFragment.getRequestManager());
            }
        }
        return hashSet;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstAvailableSegmentNum(long j, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getFirstSegmentNum() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getNextSegmentAvailableTimeUs(long j, long j2) {
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentCount(long j) {
        return 1L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getSegmentNum(long j, long j2) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public RangedUri getSegmentUrl(long j) {
        return (RangedUri) this.f216b;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(long j) {
        return 0L;
    }

    /* renamed from: h */
    public void m98h(String str, String str2, Bundle bundle) {
        switch (this.f215a) {
            case 22:
                boolean isEmpty = TextUtils.isEmpty(str);
                zzlw zzlwVar = (zzlw) this.f216b;
                if (!isEmpty) {
                    zzlwVar.zzQ(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle, str);
                    return;
                } else {
                    zzlwVar.zzO(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
                    return;
                }
            default:
                boolean isEmpty2 = TextUtils.isEmpty(str);
                zzpv zzpvVar = (zzpv) this.f216b;
                if (isEmpty2) {
                    zzio zzioVar = zzpvVar.f14380l;
                    if (zzioVar != null) {
                        zzioVar.zzaW().zze().zzb("AppId not known when logging event", str2);
                        return;
                    }
                    return;
                }
                zzpvVar.zzaX().zzq(new RunnableC1199fl(6, this, str, str2, bundle));
                return;
        }
    }

    /* renamed from: i */
    public void m99i(zzjw zzjwVar, int i) {
        s93 s93Var = s93.UNSET;
        if (i != -30) {
            if (i != -20) {
                if (i != -10) {
                    if (i != 0) {
                        if (i == 30) {
                            s93Var = s93.INITIALIZATION;
                        }
                    }
                } else {
                    s93Var = s93.MANIFEST;
                }
            }
            s93Var = s93.API;
        } else {
            s93Var = s93.TCF;
        }
        ((EnumMap) this.f216b).put((EnumMap) zzjwVar, (zzjw) s93Var);
    }

    @Override // com.google.android.gms.common.internal.zaj
    public boolean isConnected() {
        return ((zabe) this.f216b).isConnected();
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }

    /* renamed from: j */
    public void m100j(zzjw zzjwVar, s93 s93Var) {
        ((EnumMap) this.f216b).put((EnumMap) zzjwVar, (zzjw) s93Var);
    }

    @Override // p000.qd3
    /* renamed from: m */
    public wd3 mo101m(Class cls) {
        for (int i = 0; i < 2; i++) {
            qd3 qd3Var = ((qd3[]) this.f216b)[i];
            if (qd3Var.mo102o(cls)) {
                return qd3Var.mo101m(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // p000.qd3
    /* renamed from: o */
    public boolean mo102o(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((qd3[]) this.f216b)[i].mo102o(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        ((View) ((WindowDecorActionBar) this.f216b).f643e.getParent()).invalidate();
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener, com.google.android.gms.tasks.OnTokenCanceledListener
    public void onCanceled() {
        switch (this.f215a) {
            case 18:
                ((CountDownLatch) this.f216b).countDown();
                return;
            default:
                ((TaskCompletionSource) this.f216b).f14452a.m4715c();
                return;
        }
    }

    @Override // androidx.leanback.widget.OnChildLaidOutListener
    public void onChildLaidOut(ViewGroup viewGroup, View view, int i, long j) {
        switch (this.f215a) {
            case 9:
                if (i == 0) {
                    ((VerticalGridFragment) this.f216b).m1353c();
                    return;
                }
                return;
            default:
                if (i == 0) {
                    ((VerticalGridSupportFragment) this.f216b).m1354n();
                    return;
                }
                return;
        }
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper deferredLifecycleHelper = (DeferredLifecycleHelper) this.f216b;
        deferredLifecycleHelper.f13692a = lifecycleDelegate;
        Iterator it = deferredLifecycleHelper.f13694c.iterator();
        while (it.hasNext()) {
            ((o83) it.next()).zab();
        }
        deferredLifecycleHelper.f13694c.clear();
        deferredLifecycleHelper.f13693b = null;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        ((CountDownLatch) this.f216b).countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f215a) {
            case 17:
                ((OnTokenCanceledListener) this.f216b).onCanceled();
                return;
            default:
                ((CountDownLatch) this.f216b).countDown();
                return;
        }
    }

    @Override // com.orhanobut.hawk.Storage
    public boolean put(String str, Object obj) {
        p63.m6871o(str, "key");
        return ((SharedPreferences) this.f216b).edit().putString(str, String.valueOf(obj)).commit();
    }

    @Override // com.google.gson.JsonSerializationContext
    public JsonElement serialize(Object obj) {
        return ((TreeTypeAdapter) this.f216b).f15772c.toJsonTree(obj);
    }

    public String toString() {
        switch (this.f215a) {
            case 5:
                return super.toString() + "{fragment=" + ((SupportRequestManagerFragment) this.f216b) + "}";
            case 19:
                StringBuilder sb = new StringBuilder(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                for (zzjw zzjwVar : zzjw.values()) {
                    s93 s93Var = (s93) ((EnumMap) this.f216b).get(zzjwVar);
                    if (s93Var == null) {
                        s93Var = s93.UNSET;
                    }
                    sb.append(s93Var.f26340a);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public boolean zza() {
        zzio zzioVar = (zzio) this.f216b;
        if (zzioVar.zzL() && Log.isLoggable(zzioVar.zzaW().zzr(), 3)) {
            return true;
        }
        return false;
    }

    public ai2(int i) {
        this.f215a = i;
        switch (i) {
            case 18:
                this.f216b = new CountDownLatch(1);
                return;
            case 19:
                this.f216b = new EnumMap(zzjw.class);
                return;
            default:
                return;
        }
    }

    @Override // com.google.gson.JsonSerializationContext
    public JsonElement serialize(Object obj, Type type) {
        return ((TreeTypeAdapter) this.f216b).f15772c.toJsonTree(obj, type);
    }

    public ai2(EnumMap enumMap) {
        this.f215a = 19;
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.f216b = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public ai2(Context context) {
        this.f215a = 0;
        this.f216b = context.getSharedPreferences("Hawk2", 0);
    }

    @Override // p000.h23
    public void unregister() {
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(long j, long j2) {
        return j2;
    }
}
