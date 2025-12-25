package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.random.Random;
import p000.AbstractC1726qj;
import p000.C1786s5;
import p000.C1823t5;
import p000.C1860u5;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a */
    public final HashMap f537a = new HashMap();

    /* renamed from: b */
    public final HashMap f538b = new HashMap();

    /* renamed from: c */
    public final HashMap f539c = new HashMap();

    /* renamed from: d */
    public ArrayList f540d = new ArrayList();

    /* renamed from: e */
    public final transient HashMap f541e = new HashMap();

    /* renamed from: f */
    public final HashMap f542f = new HashMap();

    /* renamed from: g */
    public final Bundle f543g = new Bundle();

    /* renamed from: a */
    public final void m150a(String str) {
        HashMap hashMap = this.f538b;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        int nextInt = Random.INSTANCE.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            HashMap hashMap2 = this.f537a;
            if (hashMap2.containsKey(Integer.valueOf(i))) {
                nextInt = Random.INSTANCE.nextInt(2147418112);
            } else {
                hashMap2.put(Integer.valueOf(i), str);
                hashMap.put(str, Integer.valueOf(i));
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m151b(String str) {
        Integer num;
        if (!this.f540d.contains(str) && (num = (Integer) this.f538b.remove(str)) != null) {
            this.f537a.remove(num);
        }
        this.f541e.remove(str);
        HashMap hashMap = this.f542f;
        if (hashMap.containsKey(str)) {
            StringBuilder m7065u = AbstractC1726qj.m7065u("Dropping pending result for request ", str, ": ");
            m7065u.append(hashMap.get(str));
            Log.w("ActivityResultRegistry", m7065u.toString());
            hashMap.remove(str);
        }
        Bundle bundle = this.f543g;
        if (bundle.containsKey(str)) {
            StringBuilder m7065u2 = AbstractC1726qj.m7065u("Dropping pending result for request ", str, ": ");
            m7065u2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", m7065u2.toString());
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f539c;
        C1860u5 c1860u5 = (C1860u5) hashMap2.get(str);
        if (c1860u5 != null) {
            ArrayList arrayList = c1860u5.f27111b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c1860u5.f27110a.removeObserver((LifecycleEventObserver) it.next());
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }

    @MainThread
    public final boolean dispatchResult(int i, int i2, @Nullable Intent intent) {
        ActivityResultCallback activityResultCallback;
        String str = (String) this.f537a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        C1823t5 c1823t5 = (C1823t5) this.f541e.get(str);
        if (c1823t5 != null && (activityResultCallback = c1823t5.f26695a) != null && this.f540d.contains(str)) {
            activityResultCallback.onActivityResult(c1823t5.f26696b.parseResult(i2, intent));
            this.f540d.remove(str);
            return true;
        }
        this.f542f.remove(str);
        this.f543g.putParcelable(str, new ActivityResult(i2, intent));
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i2, @Nullable ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null && integerArrayList != null) {
            this.f540d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle3 = this.f543g;
            bundle3.putAll(bundle2);
            for (int i = 0; i < stringArrayList.size(); i++) {
                String str = stringArrayList.get(i);
                HashMap hashMap = this.f538b;
                boolean containsKey = hashMap.containsKey(str);
                HashMap hashMap2 = this.f537a;
                if (containsKey) {
                    Integer num = (Integer) hashMap.remove(str);
                    if (!bundle3.containsKey(str)) {
                        hashMap2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i);
                num2.intValue();
                String str2 = stringArrayList.get(i);
                hashMap2.put(num2, str2);
                hashMap.put(str2, num2);
            }
        }
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        HashMap hashMap = this.f538b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f540d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f543g.clone());
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            m150a(str);
            HashMap hashMap = this.f539c;
            C1860u5 c1860u5 = (C1860u5) hashMap.get(str);
            if (c1860u5 == null) {
                c1860u5 = new C1860u5(lifecycle);
            }
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                    boolean equals = Lifecycle.Event.ON_START.equals(event);
                    String str2 = str;
                    ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
                    if (equals) {
                        HashMap hashMap2 = activityResultRegistry.f541e;
                        ActivityResultCallback activityResultCallback2 = activityResultCallback;
                        ActivityResultContract activityResultContract2 = activityResultContract;
                        hashMap2.put(str2, new C1823t5(activityResultContract2, activityResultCallback2));
                        HashMap hashMap3 = activityResultRegistry.f542f;
                        if (hashMap3.containsKey(str2)) {
                            Object obj = hashMap3.get(str2);
                            hashMap3.remove(str2);
                            activityResultCallback2.onActivityResult(obj);
                        }
                        Bundle bundle = activityResultRegistry.f543g;
                        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str2);
                        if (activityResult != null) {
                            bundle.remove(str2);
                            activityResultCallback2.onActivityResult(activityResultContract2.parseResult(activityResult.getResultCode(), activityResult.getData()));
                            return;
                        }
                        return;
                    }
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        activityResultRegistry.f541e.remove(str2);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        activityResultRegistry.m151b(str2);
                    }
                }
            };
            c1860u5.f27110a.addObserver(lifecycleEventObserver);
            c1860u5.f27111b.add(lifecycleEventObserver);
            hashMap.put(str, c1860u5);
            return new C1786s5(this, str, activityResultContract, 0);
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    @MainThread
    public final <O> boolean dispatchResult(int i, @SuppressLint({"UnknownNullness"}) O o) {
        ActivityResultCallback activityResultCallback;
        String str = (String) this.f537a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        C1823t5 c1823t5 = (C1823t5) this.f541e.get(str);
        if (c1823t5 != null && (activityResultCallback = c1823t5.f26695a) != null) {
            if (!this.f540d.remove(str)) {
                return true;
            }
            activityResultCallback.onActivityResult(o);
            return true;
        }
        this.f543g.remove(str);
        this.f542f.put(str, o);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull String str, @NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        m150a(str);
        this.f541e.put(str, new C1823t5(activityResultContract, activityResultCallback));
        HashMap hashMap = this.f542f;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.f543g;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new C1786s5(this, str, activityResultContract, 1);
    }
}
