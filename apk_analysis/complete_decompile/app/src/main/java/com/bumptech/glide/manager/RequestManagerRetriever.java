package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p000.dx0;
import p000.vu0;
import p000.wd0;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: j */
    public static final C0637c f8971j = new Object();

    /* renamed from: a */
    public volatile RequestManager f8972a;

    /* renamed from: d */
    public final Handler f8975d;

    /* renamed from: e */
    public final RequestManagerFactory f8976e;

    /* renamed from: i */
    public final vu0 f8980i;

    /* renamed from: b */
    public final HashMap f8973b = new HashMap();

    /* renamed from: c */
    public final HashMap f8974c = new HashMap();

    /* renamed from: f */
    public final ArrayMap f8977f = new ArrayMap();

    /* renamed from: g */
    public final ArrayMap f8978g = new ArrayMap();

    /* renamed from: h */
    public final Bundle f8979h = new Bundle();

    /* loaded from: classes.dex */
    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory, GlideExperiments glideExperiments) {
        vu0 vu0Var;
        this.f8976e = requestManagerFactory == null ? f8971j : requestManagerFactory;
        this.f8975d = new Handler(Looper.getMainLooper(), this);
        if (HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED && HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED) {
            if (glideExperiments.isEnabled(GlideBuilder.WaitForFramesAfterTrimMemory.class)) {
                vu0Var = new Object();
            } else {
                vu0Var = new dx0(15);
            }
        } else {
            vu0Var = new wd0(11);
        }
        this.f8980i = vu0Var;
    }

    /* renamed from: a */
    public static Activity m2366a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m2366a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: c */
    public static void m2367c(List list, ArrayMap arrayMap) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                m2367c(fragment.getChildFragmentManager().getFragments(), arrayMap);
            }
        }
    }

    /* renamed from: b */
    public final void m2368b(FragmentManager fragmentManager, ArrayMap arrayMap) {
        android.app.Fragment fragment;
        List<android.app.Fragment> fragments;
        if (Build.VERSION.SDK_INT >= 26) {
            fragments = fragmentManager.getFragments();
            for (android.app.Fragment fragment2 : fragments) {
                if (fragment2.getView() != null) {
                    arrayMap.put(fragment2.getView(), fragment2);
                    m2368b(fragment2.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Bundle bundle = this.f8979h;
            bundle.putInt("key", i);
            try {
                fragment = fragmentManager.getFragment(bundle, "key");
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                m2368b(fragment.getChildFragmentManager(), arrayMap);
            }
            i = i2;
        }
    }

    /* renamed from: d */
    public final RequestManager m2369d(Activity activity, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment m2370e = m2370e(fragmentManager, fragment);
        RequestManager requestManager = m2370e.getRequestManager();
        if (requestManager == null) {
            requestManager = this.f8976e.build(Glide.get(activity), m2370e.f8965a, m2370e.getRequestManagerTreeNode(), activity);
            if (z) {
                requestManager.onStart();
            }
            m2370e.setRequestManager(requestManager);
        }
        return requestManager;
    }

    /* renamed from: e */
    public final RequestManagerFragment m2370e(FragmentManager fragmentManager, android.app.Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null) {
            HashMap hashMap = this.f8973b;
            RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) hashMap.get(fragmentManager);
            if (requestManagerFragment2 == null) {
                requestManagerFragment2 = new RequestManagerFragment();
                requestManagerFragment2.f8970f = fragment;
                if (fragment != null && fragment.getActivity() != null) {
                    requestManagerFragment2.m2365b(fragment.getActivity());
                }
                hashMap.put(fragmentManager, requestManagerFragment2);
                fragmentManager.beginTransaction().add(requestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f8975d.obtainMessage(1, fragmentManager).sendToTarget();
            }
            return requestManagerFragment2;
        }
        return requestManagerFragment;
    }

    /* renamed from: f */
    public final SupportRequestManagerFragment m2371f(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            HashMap hashMap = this.f8974c;
            SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) hashMap.get(fragmentManager);
            if (supportRequestManagerFragment2 == null) {
                supportRequestManagerFragment2 = new SupportRequestManagerFragment();
                supportRequestManagerFragment2.f8989j0 = fragment;
                if (fragment != null && fragment.getContext() != null) {
                    Fragment fragment2 = fragment;
                    while (fragment2.getParentFragment() != null) {
                        fragment2 = fragment2.getParentFragment();
                    }
                    androidx.fragment.app.FragmentManager fragmentManager2 = fragment2.getFragmentManager();
                    if (fragmentManager2 != null) {
                        supportRequestManagerFragment2.m2374m(fragment.getContext(), fragmentManager2);
                    }
                }
                hashMap.put(fragmentManager, supportRequestManagerFragment2);
                fragmentManager.beginTransaction().add(supportRequestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f8975d.obtainMessage(2, fragmentManager).sendToTarget();
            }
            return supportRequestManagerFragment2;
        }
        return supportRequestManagerFragment;
    }

    /* renamed from: g */
    public final RequestManager m2372g(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        SupportRequestManagerFragment m2371f = m2371f(fragmentManager, fragment);
        RequestManager requestManager = m2371f.getRequestManager();
        if (requestManager == null) {
            requestManager = this.f8976e.build(Glide.get(context), m2371f.f8984e0, m2371f.getRequestManagerTreeNode(), context);
            if (z) {
                requestManager.onStart();
            }
            m2371f.setRequestManager(requestManager);
        }
        return requestManager;
    }

    @NonNull
    public RequestManager get(@NonNull Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return get(contextWrapper.getBaseContext());
                    }
                }
            }
            if (this.f8972a == null) {
                synchronized (this) {
                    try {
                        if (this.f8972a == null) {
                            this.f8972a = this.f8976e.build(Glide.get(context.getApplicationContext()), new dx0(5), new dx0(11), context.getApplicationContext());
                        }
                    } finally {
                    }
                }
            }
            return this.f8972a;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        Object obj3;
        int i = message.what;
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                obj3 = null;
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f8974c.remove(obj);
        } else {
            obj = (FragmentManager) message.obj;
            remove = this.f8973b.remove(obj);
        }
        Object obj4 = remove;
        obj2 = obj;
        obj3 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        if (!fragmentActivity.isDestroyed()) {
            this.f8980i.getClass();
            androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Activity m2366a = m2366a(fragmentActivity);
            return m2372g(fragmentActivity, supportFragmentManager, null, m2366a == null || !m2366a.isFinishing());
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @NonNull
    public RequestManager get(@NonNull Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            fragment.getActivity();
            this.f8980i.getClass();
        }
        return m2372g(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public RequestManager get(@NonNull Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return get((FragmentActivity) activity);
        }
        if (!activity.isDestroyed()) {
            this.f8980i.getClass();
            FragmentManager fragmentManager = activity.getFragmentManager();
            Activity m2366a = m2366a(activity);
            return m2369d(activity, fragmentManager, null, m2366a == null || !m2366a.isFinishing());
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public RequestManager get(@NonNull View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity m2366a = m2366a(view.getContext());
        if (m2366a == null) {
            return get(view.getContext().getApplicationContext());
        }
        android.app.Fragment fragment = null;
        Fragment fragment2 = null;
        if (m2366a instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) m2366a;
            ArrayMap arrayMap = this.f8977f;
            arrayMap.clear();
            m2367c(fragmentActivity.getSupportFragmentManager().getFragments(), arrayMap);
            View findViewById = fragmentActivity.findViewById(R.id.content);
            while (!view.equals(findViewById) && (fragment2 = (Fragment) arrayMap.get(view)) == null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            arrayMap.clear();
            return fragment2 != null ? get(fragment2) : get(fragmentActivity);
        }
        ArrayMap arrayMap2 = this.f8978g;
        arrayMap2.clear();
        m2368b(m2366a.getFragmentManager(), arrayMap2);
        View findViewById2 = m2366a.findViewById(R.id.content);
        while (!view.equals(findViewById2) && (fragment = (android.app.Fragment) arrayMap2.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        arrayMap2.clear();
        if (fragment == null) {
            return get(m2366a);
        }
        return get(fragment);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager get(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!Util.isOnBackgroundThread()) {
                if (fragment.getActivity() != null) {
                    fragment.getActivity();
                    this.f8980i.getClass();
                }
                return m2369d(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
