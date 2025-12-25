package p000;

import android.app.FragmentManager;
import android.util.Log;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.ObjectAdapter;

/* renamed from: zh */
/* loaded from: classes.dex */
public final class C2057zh implements FragmentManager.OnBackStackChangedListener {

    /* renamed from: a */
    public int f29373a;

    /* renamed from: b */
    public int f29374b = -1;

    /* renamed from: c */
    public final /* synthetic */ BrowseFragment f29375c;

    public C2057zh(BrowseFragment browseFragment) {
        this.f29375c = browseFragment;
        this.f29373a = browseFragment.getFragmentManager().getBackStackEntryCount();
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        BrowseFragment browseFragment = this.f29375c;
        if (browseFragment.getFragmentManager() == null) {
            Log.w("BrowseFragment", "getFragmentManager() is null, stack:", new Exception());
            return;
        }
        int backStackEntryCount = browseFragment.getFragmentManager().getBackStackEntryCount();
        int i = this.f29373a;
        if (backStackEntryCount > i) {
            int i2 = backStackEntryCount - 1;
            if (browseFragment.f4810R.equals(browseFragment.getFragmentManager().getBackStackEntryAt(i2).getName())) {
                this.f29374b = i2;
            }
        } else if (backStackEntryCount < i && this.f29374b >= backStackEntryCount) {
            ObjectAdapter objectAdapter = browseFragment.f4802J;
            if (objectAdapter != null && objectAdapter.size() != 0) {
                this.f29374b = -1;
                if (!browseFragment.f4811S) {
                    browseFragment.m1272l(true);
                }
            } else {
                browseFragment.getFragmentManager().beginTransaction().addToBackStack(browseFragment.f4810R).commit();
                return;
            }
        }
        this.f29373a = backStackEntryCount;
    }
}
