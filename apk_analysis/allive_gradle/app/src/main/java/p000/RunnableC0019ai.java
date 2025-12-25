package p000;

import android.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.HeadersFragment;
import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.widget.VerticalGridView;

/* renamed from: ai */
/* loaded from: classes.dex */
public final class RunnableC0019ai implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f202a;

    /* renamed from: b */
    public int f203b = -1;

    /* renamed from: c */
    public int f204c = -1;

    /* renamed from: d */
    public boolean f205d = false;

    /* renamed from: e */
    public final /* synthetic */ Object f206e;

    public /* synthetic */ RunnableC0019ai(int i, Object obj) {
        this.f202a = i;
        this.f206e = obj;
    }

    /* renamed from: a */
    public final void m90a(int i, int i2, boolean z) {
        switch (this.f202a) {
            case 0:
                if (i2 >= this.f204c) {
                    this.f203b = i;
                    this.f204c = i2;
                    this.f205d = z;
                    BrowseFragment browseFragment = (BrowseFragment) this.f206e;
                    browseFragment.f4807O.removeCallbacks(this);
                    if (!browseFragment.f4822d0) {
                        browseFragment.f4807O.post(this);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (i2 >= this.f204c) {
                    this.f203b = i;
                    this.f204c = i2;
                    this.f205d = z;
                    BrowseSupportFragment browseSupportFragment = (BrowseSupportFragment) this.f206e;
                    browseSupportFragment.f4860S0.removeCallbacks(this);
                    if (!browseSupportFragment.f4875h1) {
                        browseSupportFragment.f4860S0.post(this);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        switch (this.f202a) {
            case 0:
                int i = this.f203b;
                boolean z3 = this.f205d;
                BrowseFragment browseFragment = (BrowseFragment) this.f206e;
                if (i == -1) {
                    browseFragment.getClass();
                } else {
                    browseFragment.f4818Z = i;
                    HeadersFragment headersFragment = browseFragment.f4799G;
                    if (headersFragment != null && browseFragment.f4797E != null) {
                        headersFragment.setSelectedPosition(i, z3);
                        if (browseFragment.m1264d(browseFragment.f4802J, i)) {
                            if (!browseFragment.f4822d0) {
                                VerticalGridView verticalGridView = browseFragment.f4799G.getVerticalGridView();
                                if (browseFragment.isShowingHeaders() && verticalGridView != null && verticalGridView.getScrollState() != 0) {
                                    browseFragment.getChildFragmentManager().beginTransaction().replace(R.id.scale_frame, new Fragment()).commit();
                                    C1835th c1835th = browseFragment.f4835q0;
                                    verticalGridView.removeOnScrollListener(c1835th);
                                    verticalGridView.addOnScrollListener(c1835th);
                                } else {
                                    browseFragment.m1263c();
                                }
                            }
                            if (browseFragment.f4812T && browseFragment.f4811S) {
                                z = false;
                            } else {
                                z = true;
                            }
                            browseFragment.m1265e(z);
                        }
                        BrowseFragment.MainFragmentRowsAdapter mainFragmentRowsAdapter = browseFragment.f4800H;
                        if (mainFragmentRowsAdapter != null) {
                            mainFragmentRowsAdapter.setSelectedPosition(i, z3);
                        }
                        browseFragment.m1274n();
                    }
                }
                this.f203b = -1;
                this.f204c = -1;
                this.f205d = false;
                return;
            default:
                int i2 = this.f203b;
                boolean z4 = this.f205d;
                BrowseSupportFragment browseSupportFragment = (BrowseSupportFragment) this.f206e;
                if (i2 == -1) {
                    browseSupportFragment.getClass();
                } else {
                    browseSupportFragment.f4871d1 = i2;
                    HeadersSupportFragment headersSupportFragment = browseSupportFragment.f4852K0;
                    if (headersSupportFragment != null && browseSupportFragment.f4850I0 != null) {
                        headersSupportFragment.setSelectedPosition(i2, z4);
                        if (browseSupportFragment.m1276o(browseSupportFragment.f4855N0, i2)) {
                            if (!browseSupportFragment.f4875h1) {
                                VerticalGridView verticalGridView2 = browseSupportFragment.f4852K0.getVerticalGridView();
                                if (browseSupportFragment.isShowingHeaders() && verticalGridView2 != null && verticalGridView2.getScrollState() != 0) {
                                    browseSupportFragment.getChildFragmentManager().beginTransaction().replace(R.id.scale_frame, new androidx.fragment.app.Fragment()).commit();
                                    C0558bi c0558bi = browseSupportFragment.f4888u1;
                                    verticalGridView2.removeOnScrollListener(c0558bi);
                                    verticalGridView2.addOnScrollListener(c0558bi);
                                } else {
                                    browseSupportFragment.m1275n();
                                }
                            }
                            if (browseSupportFragment.f4865X0 && browseSupportFragment.f4864W0) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            browseSupportFragment.m1277p(z2);
                        }
                        BrowseSupportFragment.MainFragmentRowsAdapter mainFragmentRowsAdapter2 = browseSupportFragment.f4853L0;
                        if (mainFragmentRowsAdapter2 != null) {
                            mainFragmentRowsAdapter2.setSelectedPosition(i2, z4);
                        }
                        browseSupportFragment.m1286y();
                    }
                }
                this.f203b = -1;
                this.f204c = -1;
                this.f205d = false;
                return;
        }
    }
}
