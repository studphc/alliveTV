package p000;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class du0 extends ViewModel {

    /* renamed from: k */
    public static final cu0 f16541k = new Object();

    /* renamed from: g */
    public final boolean f16545g;

    /* renamed from: d */
    public final HashMap f16542d = new HashMap();

    /* renamed from: e */
    public final HashMap f16543e = new HashMap();

    /* renamed from: f */
    public final HashMap f16544f = new HashMap();

    /* renamed from: h */
    public boolean f16546h = false;

    /* renamed from: i */
    public boolean f16547i = false;

    /* renamed from: j */
    public boolean f16548j = false;

    public du0(boolean z) {
        this.f16545g = z;
    }

    /* renamed from: c */
    public final void m4613c(Fragment fragment) {
        if (this.f16548j) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap hashMap = this.f16542d;
        if (hashMap.containsKey(fragment.f4452f)) {
            return;
        }
        hashMap.put(fragment.f4452f, fragment);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Updating retained Fragments: Added " + fragment);
        }
    }

    /* renamed from: d */
    public final void m4614d(Fragment fragment, boolean z) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "Clearing non-config state for " + fragment);
        }
        m4616f(fragment.f4452f, z);
    }

    /* renamed from: e */
    public final void m4615e(String str, boolean z) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "Clearing non-config state for saved state of Fragment " + str);
        }
        m4616f(str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || du0.class != obj.getClass()) {
            return false;
        }
        du0 du0Var = (du0) obj;
        if (this.f16542d.equals(du0Var.f16542d) && this.f16543e.equals(du0Var.f16543e) && this.f16544f.equals(du0Var.f16544f)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final void m4616f(String str, boolean z) {
        HashMap hashMap = this.f16543e;
        du0 du0Var = (du0) hashMap.get(str);
        if (du0Var != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(du0Var.f16543e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    du0Var.m4615e((String) it.next(), true);
                }
            }
            du0Var.onCleared();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f16544f;
        ViewModelStore viewModelStore = (ViewModelStore) hashMap2.get(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
            hashMap2.remove(str);
        }
    }

    /* renamed from: g */
    public final FragmentManagerNonConfig m4617g() {
        HashMap hashMap = this.f16542d;
        boolean isEmpty = hashMap.isEmpty();
        HashMap hashMap2 = this.f16543e;
        HashMap hashMap3 = this.f16544f;
        if (isEmpty && hashMap2.isEmpty() && hashMap3.isEmpty()) {
            return null;
        }
        HashMap hashMap4 = new HashMap();
        for (Map.Entry entry : hashMap2.entrySet()) {
            FragmentManagerNonConfig m4617g = ((du0) entry.getValue()).m4617g();
            if (m4617g != null) {
                hashMap4.put((String) entry.getKey(), m4617g);
            }
        }
        this.f16547i = true;
        if (hashMap.isEmpty() && hashMap4.isEmpty() && hashMap3.isEmpty()) {
            return null;
        }
        return new FragmentManagerNonConfig(new ArrayList(hashMap.values()), hashMap4, new HashMap(hashMap3));
    }

    /* renamed from: h */
    public final void m4618h(Fragment fragment) {
        if (this.f16548j) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f16542d.remove(fragment.f4452f) != null && FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final int hashCode() {
        return this.f16544f.hashCode() + ((this.f16543e.hashCode() + (this.f16542d.hashCode() * 31)) * 31);
    }

    /* renamed from: i */
    public final void m4619i(FragmentManagerNonConfig fragmentManagerNonConfig) {
        HashMap hashMap = this.f16542d;
        hashMap.clear();
        HashMap hashMap2 = this.f16543e;
        hashMap2.clear();
        HashMap hashMap3 = this.f16544f;
        hashMap3.clear();
        if (fragmentManagerNonConfig != null) {
            List<Fragment> list = fragmentManagerNonConfig.f4547a;
            if (list != null) {
                for (Fragment fragment : list) {
                    if (fragment != null) {
                        hashMap.put(fragment.f4452f, fragment);
                    }
                }
            }
            HashMap hashMap4 = fragmentManagerNonConfig.f4548b;
            if (hashMap4 != null) {
                for (Map.Entry entry : hashMap4.entrySet()) {
                    du0 du0Var = new du0(this.f16545g);
                    du0Var.m4619i((FragmentManagerNonConfig) entry.getValue());
                    hashMap2.put((String) entry.getKey(), du0Var);
                }
            }
            HashMap hashMap5 = fragmentManagerNonConfig.f4549c;
            if (hashMap5 != null) {
                hashMap3.putAll(hashMap5);
            }
        }
        this.f16547i = false;
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "onCleared called for " + this);
        }
        this.f16546h = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f16542d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f16543e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f16544f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
