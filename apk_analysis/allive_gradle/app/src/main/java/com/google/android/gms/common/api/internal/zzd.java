package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import p000.h71;

/* loaded from: classes.dex */
public final class zzd extends Fragment implements LifecycleFragment {

    /* renamed from: f0 */
    public static final WeakHashMap f13310f0 = new WeakHashMap();

    /* renamed from: e0 */
    public final h71 f13311e0 = new h71(5, false);

    public static zzd zza(FragmentActivity fragmentActivity) {
        zzd zzdVar;
        WeakHashMap weakHashMap = f13310f0;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (zzdVar = (zzd) weakReference.get()) != null) {
            return zzdVar;
        }
        try {
            zzd zzdVar2 = (zzd) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SLifecycleFragmentImpl");
            if (zzdVar2 == null || zzdVar2.isRemoving()) {
                zzdVar2 = new zzd();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzdVar2, "SLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(zzdVar2));
            return zzdVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, @NonNull LifecycleCallback lifecycleCallback) {
        this.f13311e0.m5042c(str, lifecycleCallback);
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = ((Map) this.f13311e0.f17965b).values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    @Nullable
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return cls.cast(((Map) this.f13311e0.f17965b).get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    @Nullable
    public final Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        if (this.f13311e0.f17964a > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        if (this.f13311e0.f17964a >= 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator it = ((Map) this.f13311e0.f17965b).values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f13311e0.m5043d(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        h71 h71Var = this.f13311e0;
        h71Var.f17964a = 5;
        Iterator it = ((Map) h71Var.f17965b).values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        h71 h71Var = this.f13311e0;
        h71Var.f17964a = 3;
        Iterator it = ((Map) h71Var.f17965b).values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f13311e0.m5044e(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        h71 h71Var = this.f13311e0;
        h71Var.f17964a = 2;
        Iterator it = ((Map) h71Var.f17965b).values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        h71 h71Var = this.f13311e0;
        h71Var.f17964a = 4;
        Iterator it = ((Map) h71Var.f17965b).values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onStop();
        }
    }
}
