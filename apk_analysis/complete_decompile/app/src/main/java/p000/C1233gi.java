package p000;

import android.util.Log;
import androidx.activity.BackEventCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ObjectAdapter;

/* renamed from: gi */
/* loaded from: classes.dex */
public final class C1233gi implements FragmentManager.OnBackStackChangedListener {

    /* renamed from: a */
    public int f17701a;

    /* renamed from: b */
    public int f17702b = -1;

    /* renamed from: c */
    public final /* synthetic */ BrowseSupportFragment f17703c;

    public C1233gi(BrowseSupportFragment browseSupportFragment) {
        this.f17703c = browseSupportFragment;
        this.f17701a = browseSupportFragment.getFragmentManager().getBackStackEntryCount();
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final /* synthetic */ void onBackStackChangeCancelled() {
        yt0.m8319a(this);
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final /* synthetic */ void onBackStackChangeCommitted(Fragment fragment, boolean z) {
        yt0.m8320b(this, fragment, z);
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final /* synthetic */ void onBackStackChangeProgressed(BackEventCompat backEventCompat) {
        yt0.m8321c(this, backEventCompat);
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final /* synthetic */ void onBackStackChangeStarted(Fragment fragment, boolean z) {
        yt0.m8322d(this, fragment, z);
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        BrowseSupportFragment browseSupportFragment = this.f17703c;
        if (browseSupportFragment.getFragmentManager() == null) {
            Log.w("BrowseSupportFragment", "getFragmentManager() is null, stack:", new Exception());
            return;
        }
        int backStackEntryCount = browseSupportFragment.getFragmentManager().getBackStackEntryCount();
        int i = this.f17701a;
        if (backStackEntryCount > i) {
            int i2 = backStackEntryCount - 1;
            if (browseSupportFragment.f4863V0.equals(browseSupportFragment.getFragmentManager().getBackStackEntryAt(i2).getName())) {
                this.f17702b = i2;
            }
        } else if (backStackEntryCount < i && this.f17702b >= backStackEntryCount) {
            ObjectAdapter objectAdapter = browseSupportFragment.f4855N0;
            if (objectAdapter != null && objectAdapter.size() != 0) {
                this.f17702b = -1;
                if (!browseSupportFragment.f4864W0) {
                    browseSupportFragment.m1284w(true);
                }
            } else {
                browseSupportFragment.getFragmentManager().beginTransaction().addToBackStack(browseSupportFragment.f4863V0).commit();
                return;
            }
        }
        this.f17701a = backStackEntryCount;
    }
}
