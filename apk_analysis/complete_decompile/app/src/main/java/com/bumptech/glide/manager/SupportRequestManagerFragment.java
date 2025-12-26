package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p000.C1342j5;
import p000.ai2;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: e0 */
    public final C1342j5 f8984e0;

    /* renamed from: f0 */
    public final ai2 f8985f0;

    /* renamed from: g0 */
    public final HashSet f8986g0;

    /* renamed from: h0 */
    public SupportRequestManagerFragment f8987h0;

    /* renamed from: i0 */
    public RequestManager f8988i0;

    /* renamed from: j0 */
    public Fragment f8989j0;

    public SupportRequestManagerFragment() {
        this(new C1342j5());
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.f8988i0;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.f8985f0;
    }

    /* renamed from: l */
    public final Set m2373l() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f8987h0;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f8986g0);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f8987h0.m2373l()) {
            Fragment parentFragment = supportRequestManagerFragment2.getParentFragment();
            if (parentFragment == null) {
                parentFragment = supportRequestManagerFragment2.f8989j0;
            }
            Fragment parentFragment2 = getParentFragment();
            if (parentFragment2 == null) {
                parentFragment2 = this.f8989j0;
            }
            while (true) {
                Fragment parentFragment3 = parentFragment.getParentFragment();
                if (parentFragment3 == null) {
                    break;
                }
                if (parentFragment3.equals(parentFragment2)) {
                    hashSet.add(supportRequestManagerFragment2);
                    break;
                }
                parentFragment = parentFragment.getParentFragment();
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: m */
    public final void m2374m(Context context, FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f8987h0;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.f8986g0.remove(this);
            this.f8987h0 = null;
        }
        SupportRequestManagerFragment m2371f = Glide.get(context).getRequestManagerRetriever().m2371f(fragmentManager, null);
        this.f8987h0 = m2371f;
        if (!equals(m2371f)) {
            this.f8987h0.f8986g0.add(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                m2374m(getContext(), fragmentManager);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1342j5 c1342j5 = this.f8984e0;
        c1342j5.f20373c = true;
        Iterator it = Util.getSnapshot(c1342j5.f20371a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        SupportRequestManagerFragment supportRequestManagerFragment = this.f8987h0;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.f8986g0.remove(this);
            this.f8987h0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8989j0 = null;
        SupportRequestManagerFragment supportRequestManagerFragment = this.f8987h0;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.f8986g0.remove(this);
            this.f8987h0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        C1342j5 c1342j5 = this.f8984e0;
        c1342j5.f20372b = true;
        Iterator it = Util.getSnapshot(c1342j5.f20371a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        C1342j5 c1342j5 = this.f8984e0;
        c1342j5.f20372b = false;
        Iterator it = Util.getSnapshot(c1342j5.f20371a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.f8988i0 = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f8989j0;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull C1342j5 c1342j5) {
        this.f8985f0 = new ai2(5, this);
        this.f8986g0 = new HashSet();
        this.f8984e0 = c1342j5;
    }
}
