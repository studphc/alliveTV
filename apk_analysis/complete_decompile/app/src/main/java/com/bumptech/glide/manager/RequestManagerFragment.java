package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p000.C1342j5;
import p000.b01;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a */
    public final C1342j5 f8965a;

    /* renamed from: b */
    public final b01 f8966b;

    /* renamed from: c */
    public final HashSet f8967c;

    /* renamed from: d */
    public RequestManager f8968d;

    /* renamed from: e */
    public RequestManagerFragment f8969e;

    /* renamed from: f */
    public Fragment f8970f;

    public RequestManagerFragment() {
        C1342j5 c1342j5 = new C1342j5();
        this.f8966b = new b01(28, this);
        this.f8967c = new HashSet();
        this.f8965a = c1342j5;
    }

    /* renamed from: a */
    public final Set m2364a() {
        if (equals(this.f8969e)) {
            return Collections.unmodifiableSet(this.f8967c);
        }
        if (this.f8969e != null) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f8969e.m2364a()) {
                Fragment parentFragment = requestManagerFragment.getParentFragment();
                Fragment parentFragment2 = getParentFragment();
                while (true) {
                    Fragment parentFragment3 = parentFragment.getParentFragment();
                    if (parentFragment3 == null) {
                        break;
                    }
                    if (parentFragment3.equals(parentFragment2)) {
                        hashSet.add(requestManagerFragment);
                        break;
                    }
                    parentFragment = parentFragment.getParentFragment();
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* renamed from: b */
    public final void m2365b(Activity activity) {
        RequestManagerFragment requestManagerFragment = this.f8969e;
        if (requestManagerFragment != null) {
            requestManagerFragment.f8967c.remove(this);
            this.f8969e = null;
        }
        RequestManagerRetriever requestManagerRetriever = Glide.get(activity).getRequestManagerRetriever();
        requestManagerRetriever.getClass();
        RequestManagerFragment m2370e = requestManagerRetriever.m2370e(activity.getFragmentManager(), null);
        this.f8969e = m2370e;
        if (!equals(m2370e)) {
            this.f8969e.f8967c.add(this);
        }
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.f8968d;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.f8966b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m2365b(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1342j5 c1342j5 = this.f8965a;
        c1342j5.f20373c = true;
        Iterator it = Util.getSnapshot(c1342j5.f20371a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        RequestManagerFragment requestManagerFragment = this.f8969e;
        if (requestManagerFragment != null) {
            requestManagerFragment.f8967c.remove(this);
            this.f8969e = null;
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        RequestManagerFragment requestManagerFragment = this.f8969e;
        if (requestManagerFragment != null) {
            requestManagerFragment.f8967c.remove(this);
            this.f8969e = null;
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        C1342j5 c1342j5 = this.f8965a;
        c1342j5.f20372b = true;
        Iterator it = Util.getSnapshot(c1342j5.f20371a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        C1342j5 c1342j5 = this.f8965a;
        c1342j5.f20372b = false;
        Iterator it = Util.getSnapshot(c1342j5.f20371a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.f8968d = requestManager;
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f8970f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
