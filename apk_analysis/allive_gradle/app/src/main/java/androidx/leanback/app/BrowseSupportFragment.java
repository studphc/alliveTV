package androidx.leanback.app;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.InvisibleRowPresenter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ScaleFrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import p000.C0558bi;
import p000.C0594ci;
import p000.C1123di;
import p000.C1159ei;
import p000.C1233gi;
import p000.C1870uf;
import p000.C1909vh;
import p000.RunnableC0019ai;
import p000.RunnableC1196fi;
import p000.u91;
import p000.ye0;

/* loaded from: classes.dex */
public class BrowseSupportFragment extends BaseSupportFragment {
    public static final int HEADERS_DISABLED = 3;
    public static final int HEADERS_ENABLED = 1;
    public static final int HEADERS_HIDDEN = 2;

    /* renamed from: v1 */
    public static final String f4843v1 = BrowseSupportFragment.class.getCanonicalName() + ".title";

    /* renamed from: w1 */
    public static final String f4844w1 = BrowseSupportFragment.class.getCanonicalName() + ".headersState";

    /* renamed from: I0 */
    public MainFragmentAdapter f4850I0;

    /* renamed from: J0 */
    public Fragment f4851J0;

    /* renamed from: K0 */
    public HeadersSupportFragment f4852K0;

    /* renamed from: L0 */
    public MainFragmentRowsAdapter f4853L0;

    /* renamed from: M0 */
    public u91 f4854M0;

    /* renamed from: N0 */
    public ObjectAdapter f4855N0;

    /* renamed from: O0 */
    public PresenterSelector f4856O0;

    /* renamed from: R0 */
    public boolean f4859R0;

    /* renamed from: S0 */
    public BrowseFrameLayout f4860S0;

    /* renamed from: T0 */
    public ScaleFrameLayout f4861T0;

    /* renamed from: V0 */
    public String f4863V0;

    /* renamed from: Y0 */
    public int f4866Y0;

    /* renamed from: Z0 */
    public int f4867Z0;

    /* renamed from: b1 */
    public OnItemViewSelectedListener f4869b1;

    /* renamed from: c1 */
    public OnItemViewClickedListener f4870c1;

    /* renamed from: e1 */
    public float f4872e1;

    /* renamed from: f1 */
    public boolean f4873f1;

    /* renamed from: g1 */
    public Object f4874g1;

    /* renamed from: i1 */
    public PresenterSelector f4876i1;

    /* renamed from: k1 */
    public Object f4878k1;

    /* renamed from: l1 */
    public Object f4879l1;

    /* renamed from: m1 */
    public Object f4880m1;

    /* renamed from: n1 */
    public Object f4881n1;

    /* renamed from: o1 */
    public C1233gi f4882o1;

    /* renamed from: p1 */
    public BrowseTransitionListener f4883p1;

    /* renamed from: D0 */
    public final C0594ci f4845D0 = new C0594ci(this);

    /* renamed from: E0 */
    public final StateMachine.Event f4846E0 = new StateMachine.Event("headerFragmentViewCreated");

    /* renamed from: F0 */
    public final StateMachine.Event f4847F0 = new StateMachine.Event("mainFragmentViewCreated");

    /* renamed from: G0 */
    public final StateMachine.Event f4848G0 = new StateMachine.Event("screenDataReady");

    /* renamed from: H0 */
    public final MainFragmentAdapterRegistry f4849H0 = new MainFragmentAdapterRegistry();

    /* renamed from: P0 */
    public int f4857P0 = 1;

    /* renamed from: Q0 */
    public int f4858Q0 = 0;

    /* renamed from: U0 */
    public boolean f4862U0 = true;

    /* renamed from: W0 */
    public boolean f4864W0 = true;

    /* renamed from: X0 */
    public boolean f4865X0 = true;

    /* renamed from: a1 */
    public boolean f4868a1 = true;

    /* renamed from: d1 */
    public int f4871d1 = -1;

    /* renamed from: h1 */
    public boolean f4875h1 = true;

    /* renamed from: j1 */
    public final RunnableC0019ai f4877j1 = new RunnableC0019ai(1, this);

    /* renamed from: q1 */
    public final C1123di f4884q1 = new C1123di(this);

    /* renamed from: r1 */
    public final C1159ei f4885r1 = new C1159ei(this);

    /* renamed from: s1 */
    public final C0274h f4886s1 = new C0274h(this);

    /* renamed from: t1 */
    public final C0275i f4887t1 = new C0275i(this);

    /* renamed from: u1 */
    public final C0558bi f4888u1 = new C0558bi(this);

    /* loaded from: classes.dex */
    public static class BrowseTransitionListener {
        public void onHeadersTransitionStart(boolean z) {
        }

        public void onHeadersTransitionStop(boolean z) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class FragmentFactory<T extends Fragment> {
        public abstract T createFragment(Object obj);
    }

    /* loaded from: classes.dex */
    public interface FragmentHost {
        void notifyDataReady(MainFragmentAdapter mainFragmentAdapter);

        void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter);

        void showTitleView(boolean z);
    }

    /* loaded from: classes.dex */
    public static class ListRowFragmentFactory extends FragmentFactory<RowsSupportFragment> {
        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentFactory
        public RowsSupportFragment createFragment(Object obj) {
            return new RowsSupportFragment();
        }
    }

    /* loaded from: classes.dex */
    public static class MainFragmentAdapter<T extends Fragment> {

        /* renamed from: a */
        public boolean f4889a;

        /* renamed from: b */
        public final Fragment f4890b;

        /* renamed from: c */
        public C0279m f4891c;

        public MainFragmentAdapter(T t) {
            this.f4890b = t;
        }

        public final T getFragment() {
            return (T) this.f4890b;
        }

        public final FragmentHost getFragmentHost() {
            return this.f4891c;
        }

        public boolean isScalingEnabled() {
            return this.f4889a;
        }

        public boolean isScrolling() {
            return false;
        }

        public void onTransitionEnd() {
        }

        public boolean onTransitionPrepare() {
            return false;
        }

        public void onTransitionStart() {
        }

        public void setAlignment(int i) {
        }

        public void setEntranceTransitionState(boolean z) {
        }

        public void setExpand(boolean z) {
        }

        public void setScalingEnabled(boolean z) {
            this.f4889a = z;
        }
    }

    /* loaded from: classes.dex */
    public interface MainFragmentAdapterProvider {
        MainFragmentAdapter getMainFragmentAdapter();
    }

    /* loaded from: classes.dex */
    public static final class MainFragmentAdapterRegistry {

        /* renamed from: b */
        public static final ListRowFragmentFactory f4892b = new ListRowFragmentFactory();

        /* renamed from: a */
        public final HashMap f4893a = new HashMap();

        public MainFragmentAdapterRegistry() {
            registerFragment(ListRow.class, f4892b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.leanback.app.BrowseSupportFragment$FragmentFactory] */
        public Fragment createFragment(Object obj) {
            ListRowFragmentFactory listRowFragmentFactory;
            ListRowFragmentFactory listRowFragmentFactory2 = f4892b;
            if (obj == null) {
                listRowFragmentFactory = listRowFragmentFactory2;
            } else {
                listRowFragmentFactory = (FragmentFactory) this.f4893a.get(obj.getClass());
            }
            if (listRowFragmentFactory != null || (obj instanceof PageRow)) {
                listRowFragmentFactory2 = listRowFragmentFactory;
            }
            return listRowFragmentFactory2.createFragment(obj);
        }

        public void registerFragment(Class<?> cls, FragmentFactory fragmentFactory) {
            this.f4893a.put(cls, fragmentFactory);
        }
    }

    /* loaded from: classes.dex */
    public static class MainFragmentRowsAdapter<T extends Fragment> {

        /* renamed from: a */
        public final Fragment f4894a;

        public MainFragmentRowsAdapter(T t) {
            if (t != null) {
                this.f4894a = t;
                return;
            }
            throw new IllegalArgumentException("Fragment can't be null");
        }

        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
            return null;
        }

        public final T getFragment() {
            return (T) this.f4894a;
        }

        public int getSelectedPosition() {
            return 0;
        }

        public void setAdapter(ObjectAdapter objectAdapter) {
        }

        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        }

        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        }

        public void setSelectedPosition(int i, boolean z) {
        }

        public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
        }
    }

    /* loaded from: classes.dex */
    public interface MainFragmentRowsAdapterProvider {
        MainFragmentRowsAdapter getMainFragmentRowsAdapter();
    }

    public static Bundle createArgs(Bundle bundle, String str, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(f4843v1, str);
        bundle.putInt(f4844w1, i);
        return bundle;
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_browse_entrance_transition);
    }

    public void enableMainFragmentScaling(boolean z) {
        this.f4868a1 = z;
    }

    @Deprecated
    public void enableRowScaling(boolean z) {
        enableMainFragmentScaling(z);
    }

    public ObjectAdapter getAdapter() {
        return this.f4855N0;
    }

    @ColorInt
    public int getBrandColor() {
        return this.f4858Q0;
    }

    public int getHeadersState() {
        return this.f4857P0;
    }

    public HeadersSupportFragment getHeadersSupportFragment() {
        return this.f4852K0;
    }

    public Fragment getMainFragment() {
        return this.f4851J0;
    }

    public final MainFragmentAdapterRegistry getMainFragmentRegistry() {
        return this.f4849H0;
    }

    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f4870c1;
    }

    public OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.f4869b1;
    }

    public RowsSupportFragment getRowsSupportFragment() {
        Fragment fragment = this.f4851J0;
        if (fragment instanceof RowsSupportFragment) {
            return (RowsSupportFragment) fragment;
        }
        return null;
    }

    public int getSelectedPosition() {
        return this.f4871d1;
    }

    public RowPresenter.ViewHolder getSelectedRowViewHolder() {
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.f4853L0;
        if (mainFragmentRowsAdapter != null) {
            return this.f4853L0.findRowViewHolderByPosition(mainFragmentRowsAdapter.getSelectedPosition());
        }
        return null;
    }

    public final boolean isHeadersTransitionOnBackEnabled() {
        return this.f4862U0;
    }

    public boolean isInHeadersTransition() {
        if (this.f4881n1 != null) {
            return true;
        }
        return false;
    }

    public boolean isShowingHeaders() {
        return this.f4864W0;
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    /* renamed from: l */
    public final void mo1261l() {
        super.mo1261l();
        this.f4757A0.addState(this.f4845D0);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    /* renamed from: m */
    public final void mo1262m() {
        super.mo1262m();
        StateMachine stateMachine = this.f4757A0;
        C1870uf c1870uf = this.f4762p0;
        stateMachine.addTransition(c1870uf, this.f4845D0, this.f4846E0);
        stateMachine.addTransition(c1870uf, this.f4763q0, this.f4847F0);
        stateMachine.addTransition(c1870uf, this.f4764r0, this.f4848G0);
    }

    /* renamed from: n */
    public final void m1275n() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i) != this.f4851J0) {
            childFragmentManager.beginTransaction().replace(i, this.f4851J0).commit();
        }
    }

    /* renamed from: o */
    public final boolean m1276o(ObjectAdapter objectAdapter, int i) {
        Object obj;
        boolean z;
        boolean z2 = true;
        Object obj2 = null;
        if (!this.f4865X0) {
            obj = null;
        } else {
            if (objectAdapter == null || objectAdapter.size() == 0) {
                return false;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= objectAdapter.size()) {
                throw new IllegalArgumentException(String.format("Invalid position %d requested", Integer.valueOf(i)));
            }
            obj = objectAdapter.get(i);
        }
        boolean z3 = this.f4873f1;
        Object obj3 = this.f4874g1;
        if (this.f4865X0 && (obj instanceof PageRow)) {
            z = true;
        } else {
            z = false;
        }
        this.f4873f1 = z;
        if (z) {
            obj2 = obj;
        }
        this.f4874g1 = obj2;
        if (this.f4851J0 != null) {
            if (z3) {
                if (z && (obj3 == null || obj3 == obj2)) {
                    z2 = false;
                }
            } else {
                z2 = z;
            }
        }
        if (z2) {
            Fragment createFragment = this.f4849H0.createFragment(obj);
            this.f4851J0 = createFragment;
            if (createFragment instanceof MainFragmentAdapterProvider) {
                m1280s();
            } else {
                throw new IllegalArgumentException("Fragment must implement MainFragmentAdapterProvider");
            }
        }
        return z2;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.LeanbackTheme);
        this.f4866Y0 = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginStart, r0.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_start));
        this.f4867Z0 = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginTop, r0.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_top));
        obtainStyledAttributes.recycle();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String str = f4843v1;
            if (arguments.containsKey(str)) {
                setTitle(arguments.getString(str));
            }
            String str2 = f4844w1;
            if (arguments.containsKey(str2)) {
                setHeadersState(arguments.getInt(str2));
            }
        }
        if (this.f4865X0) {
            if (this.f4862U0) {
                this.f4863V0 = "lbHeadersBackStack_" + this;
                this.f4882o1 = new C1233gi(this);
                getFragmentManager().addOnBackStackChangedListener(this.f4882o1);
                C1233gi c1233gi = this.f4882o1;
                BrowseSupportFragment browseSupportFragment = c1233gi.f17703c;
                if (bundle != null) {
                    int i = bundle.getInt("headerStackIndex", -1);
                    c1233gi.f17702b = i;
                    if (i == -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    browseSupportFragment.f4864W0 = z;
                } else if (!browseSupportFragment.f4864W0) {
                    browseSupportFragment.getFragmentManager().beginTransaction().addToBackStack(browseSupportFragment.f4863V0).commit();
                }
            } else if (bundle != null) {
                this.f4864W0 = bundle.getBoolean("headerShow");
            }
        }
        this.f4872e1 = getResources().getFraction(R.fraction.lb_browse_rows_scale, 1, 1);
    }

    public HeadersSupportFragment onCreateHeadersSupportFragment() {
        return new HeadersSupportFragment();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        boolean z;
        int i;
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i2 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i2) == null) {
            this.f4852K0 = onCreateHeadersSupportFragment();
            m1276o(this.f4855N0, this.f4871d1);
            FragmentTransaction replace = getChildFragmentManager().beginTransaction().replace(R.id.browse_headers_dock, this.f4852K0);
            Fragment fragment = this.f4851J0;
            if (fragment != null) {
                replace.replace(i2, fragment);
            } else {
                MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(null);
                this.f4850I0 = mainFragmentAdapter;
                mainFragmentAdapter.f4891c = new C0279m(this);
            }
            replace.commit();
        } else {
            this.f4852K0 = (HeadersSupportFragment) getChildFragmentManager().findFragmentById(R.id.browse_headers_dock);
            this.f4851J0 = getChildFragmentManager().findFragmentById(i2);
            if (bundle != null && bundle.getBoolean("isPageRow", false)) {
                z = true;
            } else {
                z = false;
            }
            this.f4873f1 = z;
            if (bundle != null) {
                i = bundle.getInt("currentSelectedPosition", 0);
            } else {
                i = 0;
            }
            this.f4871d1 = i;
            m1280s();
        }
        HeadersSupportFragment headersSupportFragment = this.f4852K0;
        headersSupportFragment.f5034p0 = !this.f4865X0;
        headersSupportFragment.m1311q();
        PresenterSelector presenterSelector = this.f4876i1;
        if (presenterSelector != null) {
            this.f4852K0.setPresenterSelector(presenterSelector);
        }
        this.f4852K0.setAdapter(this.f4855N0);
        this.f4852K0.setOnHeaderViewSelectedListener(this.f4887t1);
        this.f4852K0.setOnHeaderClickedListener(this.f4886s1);
        View inflate = layoutInflater.inflate(R.layout.lb_browse_fragment, viewGroup, false);
        getProgressBarManager().setRootView((ViewGroup) inflate);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) inflate.findViewById(R.id.browse_frame);
        this.f4860S0 = browseFrameLayout;
        browseFrameLayout.setOnChildFocusListener(this.f4885r1);
        this.f4860S0.setOnFocusSearchListener(this.f4884q1);
        installTitleView(layoutInflater, this.f4860S0, bundle);
        ScaleFrameLayout scaleFrameLayout = (ScaleFrameLayout) inflate.findViewById(i2);
        this.f4861T0 = scaleFrameLayout;
        scaleFrameLayout.setPivotX(RecyclerView.f7068F0);
        this.f4861T0.setPivotY(this.f4867Z0);
        if (this.f4859R0) {
            HeadersSupportFragment headersSupportFragment2 = this.f4852K0;
            headersSupportFragment2.f5035q0 = this.f4858Q0;
            headersSupportFragment2.f5036r0 = true;
            if (headersSupportFragment2.getVerticalGridView() != null) {
                headersSupportFragment2.getVerticalGridView().setBackgroundColor(headersSupportFragment2.f5035q0);
                headersSupportFragment2.m1310p(headersSupportFragment2.f5035q0);
            }
        }
        this.f4878k1 = TransitionHelper.createScene(this.f4860S0, new RunnableC1196fi(this, 0));
        this.f4879l1 = TransitionHelper.createScene(this.f4860S0, new RunnableC1196fi(this, 1));
        this.f4880m1 = TransitionHelper.createScene(this.f4860S0, new RunnableC1196fi(this, 2));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.f4882o1 != null) {
            getFragmentManager().removeOnBackStackChangedListener(this.f4882o1);
        }
        super.onDestroy();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        m1282u(null);
        this.f4874g1 = null;
        this.f4850I0 = null;
        this.f4851J0 = null;
        this.f4852K0 = null;
        this.f4860S0 = null;
        this.f4861T0 = null;
        this.f4880m1 = null;
        this.f4878k1 = null;
        this.f4879l1 = null;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionEnd() {
        MainFragmentAdapter mainFragmentAdapter = this.f4850I0;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
        }
        HeadersSupportFragment headersSupportFragment = this.f4852K0;
        if (headersSupportFragment != null) {
            headersSupportFragment.onTransitionEnd();
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionPrepare() {
        this.f4852K0.onTransitionPrepare();
        this.f4850I0.setEntranceTransitionState(false);
        this.f4850I0.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionStart() {
        this.f4852K0.onTransitionStart();
        this.f4850I0.onTransitionStart();
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentSelectedPosition", this.f4871d1);
        bundle.putBoolean("isPageRow", this.f4873f1);
        C1233gi c1233gi = this.f4882o1;
        if (c1233gi != null) {
            bundle.putInt("headerStackIndex", c1233gi.f17702b);
        } else {
            bundle.putBoolean("headerShow", this.f4864W0);
        }
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Fragment fragment;
        HeadersSupportFragment headersSupportFragment;
        super.onStart();
        this.f4852K0.setAlignment(this.f4867Z0);
        m1281t();
        if (this.f4865X0 && this.f4864W0 && (headersSupportFragment = this.f4852K0) != null && headersSupportFragment.getView() != null) {
            this.f4852K0.getView().requestFocus();
        } else if ((!this.f4865X0 || !this.f4864W0) && (fragment = this.f4851J0) != null && fragment.getView() != null) {
            this.f4851J0.getView().requestFocus();
        }
        if (this.f4865X0) {
            m1283v(this.f4864W0);
        }
        this.f4757A0.fireEvent(this.f4846E0);
        this.f4875h1 = false;
        m1275n();
        RunnableC0019ai runnableC0019ai = this.f4877j1;
        if (runnableC0019ai.f204c != -1) {
            ((BrowseSupportFragment) runnableC0019ai.f206e).f4860S0.post(runnableC0019ai);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f4875h1 = true;
        RunnableC0019ai runnableC0019ai = this.f4877j1;
        ((BrowseSupportFragment) runnableC0019ai.f206e).f4860S0.removeCallbacks(runnableC0019ai);
        super.onStop();
    }

    /* renamed from: p */
    public final void m1277p(boolean z) {
        int i;
        float f;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4861T0.getLayoutParams();
        if (!z) {
            i = this.f4866Y0;
        } else {
            i = 0;
        }
        marginLayoutParams.setMarginStart(i);
        this.f4861T0.setLayoutParams(marginLayoutParams);
        this.f4850I0.setExpand(z);
        m1281t();
        if (!z && this.f4868a1 && this.f4850I0.isScalingEnabled()) {
            f = this.f4872e1;
        } else {
            f = 1.0f;
        }
        this.f4861T0.setLayoutScaleY(f);
        this.f4861T0.setChildScale(f);
    }

    /* renamed from: q */
    public final boolean m1278q(int i) {
        ObjectAdapter objectAdapter = this.f4855N0;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            for (int i2 = 0; i2 < this.f4855N0.size(); i2++) {
                if (((Row) this.f4855N0.get(i2)).isRenderedAsRowView()) {
                    if (i == i2) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: r */
    public final void m1279r(boolean z) {
        int i;
        View view = this.f4852K0.getView();
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (z) {
            i = 0;
        } else {
            i = -this.f4866Y0;
        }
        marginLayoutParams.setMarginStart(i);
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.f4880m1, obj);
    }

    /* renamed from: s */
    public final void m1280s() {
        boolean z;
        MainFragmentAdapter mainFragmentAdapter = ((MainFragmentAdapterProvider) this.f4851J0).getMainFragmentAdapter();
        this.f4850I0 = mainFragmentAdapter;
        mainFragmentAdapter.f4891c = new C0279m(this);
        if (!this.f4873f1) {
            ActivityResultCaller activityResultCaller = this.f4851J0;
            if (activityResultCaller instanceof MainFragmentRowsAdapterProvider) {
                m1282u(((MainFragmentRowsAdapterProvider) activityResultCaller).getMainFragmentRowsAdapter());
            } else {
                m1282u(null);
            }
            if (this.f4853L0 == null) {
                z = true;
            } else {
                z = false;
            }
            this.f4873f1 = z;
            return;
        }
        m1282u(null);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.f4855N0 = objectAdapter;
        if (objectAdapter == null) {
            this.f4856O0 = null;
        } else {
            PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
            if (presenterSelector != null) {
                if (presenterSelector != this.f4856O0) {
                    this.f4856O0 = presenterSelector;
                    Presenter[] presenters = presenterSelector.getPresenters();
                    InvisibleRowPresenter invisibleRowPresenter = new InvisibleRowPresenter();
                    int length = presenters.length;
                    Presenter[] presenterArr = new Presenter[length + 1];
                    System.arraycopy(presenterArr, 0, presenters, 0, presenters.length);
                    presenterArr[length] = invisibleRowPresenter;
                    this.f4855N0.setPresenterSelector(new C1909vh(presenterSelector, invisibleRowPresenter, presenterArr, 1));
                }
            } else {
                throw new IllegalArgumentException("Adapter.getPresenterSelector() is null");
            }
        }
        if (getView() == null) {
            return;
        }
        m1285x();
        this.f4852K0.setAdapter(this.f4855N0);
    }

    public void setBrandColor(@ColorInt int i) {
        this.f4858Q0 = i;
        this.f4859R0 = true;
        HeadersSupportFragment headersSupportFragment = this.f4852K0;
        if (headersSupportFragment != null) {
            headersSupportFragment.f5035q0 = i;
            headersSupportFragment.f5036r0 = true;
            if (headersSupportFragment.getVerticalGridView() != null) {
                headersSupportFragment.getVerticalGridView().setBackgroundColor(headersSupportFragment.f5035q0);
                headersSupportFragment.m1310p(headersSupportFragment.f5035q0);
            }
        }
    }

    public void setBrowseTransitionListener(BrowseTransitionListener browseTransitionListener) {
        this.f4883p1 = browseTransitionListener;
    }

    public void setHeaderPresenterSelector(PresenterSelector presenterSelector) {
        this.f4876i1 = presenterSelector;
        HeadersSupportFragment headersSupportFragment = this.f4852K0;
        if (headersSupportFragment != null) {
            headersSupportFragment.setPresenterSelector(presenterSelector);
        }
    }

    public void setHeadersState(int i) {
        if (i >= 1 && i <= 3) {
            if (i != this.f4857P0) {
                this.f4857P0 = i;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            Log.w("BrowseSupportFragment", "Unknown headers state: " + i);
                        } else {
                            this.f4865X0 = false;
                            this.f4864W0 = false;
                        }
                    } else {
                        this.f4865X0 = true;
                        this.f4864W0 = false;
                    }
                } else {
                    this.f4865X0 = true;
                    this.f4864W0 = true;
                }
                HeadersSupportFragment headersSupportFragment = this.f4852K0;
                if (headersSupportFragment != null) {
                    headersSupportFragment.f5034p0 = true ^ this.f4865X0;
                    headersSupportFragment.m1311q();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Invalid headers state: "));
    }

    public final void setHeadersTransitionOnBackEnabled(boolean z) {
        this.f4862U0 = z;
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.f4870c1 = onItemViewClickedListener;
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.f4853L0;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f4869b1 = onItemViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void startHeadersTransition(boolean z) {
        if (this.f4865X0) {
            if (!isInHeadersTransition() && this.f4864W0 != z) {
                m1284w(z);
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot start headers transition");
    }

    /* renamed from: t */
    public final void m1281t() {
        int i = this.f4867Z0;
        if (this.f4868a1 && this.f4850I0.isScalingEnabled() && this.f4864W0) {
            i = (int) ((i / this.f4872e1) + 0.5f);
        }
        this.f4850I0.setAlignment(i);
    }

    /* renamed from: u */
    public final void m1282u(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        MainFragmentRowsAdapter mainFragmentRowsAdapter2 = this.f4853L0;
        if (mainFragmentRowsAdapter == mainFragmentRowsAdapter2) {
            return;
        }
        if (mainFragmentRowsAdapter2 != null) {
            mainFragmentRowsAdapter2.setAdapter(null);
        }
        this.f4853L0 = mainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewSelectedListener(new C0280n(this, mainFragmentRowsAdapter));
            this.f4853L0.setOnItemViewClickedListener(this.f4870c1);
        }
        m1285x();
    }

    /* renamed from: v */
    public final void m1283v(boolean z) {
        HeadersSupportFragment headersSupportFragment = this.f4852K0;
        headersSupportFragment.f5033o0 = z;
        headersSupportFragment.m1311q();
        m1279r(z);
        m1277p(!z);
    }

    /* renamed from: w */
    public final void m1284w(boolean z) {
        ObjectAdapter objectAdapter;
        if (!getFragmentManager().isDestroyed() && (objectAdapter = this.f4855N0) != null && objectAdapter.size() != 0) {
            this.f4864W0 = z;
            this.f4850I0.onTransitionPrepare();
            this.f4850I0.onTransitionStart();
            RunnableC0276j runnableC0276j = new RunnableC0276j(this, z);
            if (!z) {
                runnableC0276j.run();
                return;
            }
            MainFragmentAdapter mainFragmentAdapter = this.f4850I0;
            View view = getView();
            ViewTreeObserverOnPreDrawListenerC0278l viewTreeObserverOnPreDrawListenerC0278l = new ViewTreeObserverOnPreDrawListenerC0278l(this, runnableC0276j, mainFragmentAdapter, view);
            view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0278l);
            mainFragmentAdapter.setExpand(false);
            view.invalidate();
            viewTreeObserverOnPreDrawListenerC0278l.f5336c = 0;
        }
    }

    /* renamed from: x */
    public final void m1285x() {
        u91 u91Var = this.f4854M0;
        u91 u91Var2 = null;
        if (u91Var != null) {
            u91Var.f27154d.unregisterObserver(u91Var.f27156f);
            this.f4854M0 = null;
        }
        if (this.f4853L0 != null) {
            ObjectAdapter objectAdapter = this.f4855N0;
            if (objectAdapter != null) {
                u91Var2 = new u91(objectAdapter);
            }
            this.f4854M0 = u91Var2;
            this.f4853L0.setAdapter(u91Var2);
        }
    }

    /* renamed from: y */
    public final void m1286y() {
        boolean m1278q;
        int i;
        MainFragmentAdapter mainFragmentAdapter;
        boolean m1278q2;
        MainFragmentAdapter mainFragmentAdapter2;
        if (!this.f4864W0) {
            if (this.f4873f1 && (mainFragmentAdapter2 = this.f4850I0) != null) {
                m1278q2 = mainFragmentAdapter2.f4891c.f5339a;
            } else {
                m1278q2 = m1278q(this.f4871d1);
            }
            if (m1278q2) {
                showTitle(6);
                return;
            } else {
                showTitle(false);
                return;
            }
        }
        if (this.f4873f1 && (mainFragmentAdapter = this.f4850I0) != null) {
            m1278q = mainFragmentAdapter.f4891c.f5339a;
        } else {
            m1278q = m1278q(this.f4871d1);
        }
        int i2 = this.f4871d1;
        ObjectAdapter objectAdapter = this.f4855N0;
        boolean z = true;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            for (int i3 = 0; i3 < this.f4855N0.size(); i3++) {
                Row row = (Row) this.f4855N0.get(i3);
                if (row.isRenderedAsRowView() || (row instanceof PageRow)) {
                    if (i2 != i3) {
                        z = false;
                    }
                }
            }
        }
        if (m1278q) {
            i = 2;
        } else {
            i = 0;
        }
        if (z) {
            i |= 4;
        }
        if (i != 0) {
            showTitle(i);
        } else {
            showTitle(false);
        }
    }

    public void setSelectedPosition(int i, boolean z) {
        this.f4877j1.m90a(i, 1, z);
    }

    public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
        if (this.f4849H0 == null) {
            return;
        }
        if (viewHolderTask != null) {
            startHeadersTransition(false);
        }
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.f4853L0;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setSelectedPosition(i, z, viewHolderTask);
        }
    }
}
