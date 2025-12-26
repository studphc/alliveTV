package androidx.leanback.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentCallbacks2;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
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
import p000.C0016af;
import p000.C1835th;
import p000.C1872uh;
import p000.C1909vh;
import p000.C1946wh;
import p000.C1983xh;
import p000.C2057zh;
import p000.RunnableC0019ai;
import p000.RunnableC2020yh;
import p000.ou0;
import p000.u91;
import p000.ye0;

@Deprecated
/* loaded from: classes.dex */
public class BrowseFragment extends BaseFragment {
    public static final int HEADERS_DISABLED = 3;
    public static final int HEADERS_ENABLED = 1;
    public static final int HEADERS_HIDDEN = 2;

    /* renamed from: r0 */
    public static final String f4791r0 = BrowseFragment.class.getCanonicalName() + ".title";

    /* renamed from: s0 */
    public static final String f4792s0 = BrowseFragment.class.getCanonicalName() + ".headersState";

    /* renamed from: E */
    public MainFragmentAdapter f4797E;

    /* renamed from: F */
    public Fragment f4798F;

    /* renamed from: G */
    public HeadersFragment f4799G;

    /* renamed from: H */
    public MainFragmentRowsAdapter f4800H;

    /* renamed from: I */
    public u91 f4801I;

    /* renamed from: J */
    public ObjectAdapter f4802J;

    /* renamed from: K */
    public PresenterSelector f4803K;

    /* renamed from: N */
    public boolean f4806N;

    /* renamed from: O */
    public BrowseFrameLayout f4807O;

    /* renamed from: P */
    public ScaleFrameLayout f4808P;

    /* renamed from: R */
    public String f4810R;

    /* renamed from: U */
    public int f4813U;

    /* renamed from: V */
    public int f4814V;

    /* renamed from: X */
    public OnItemViewSelectedListener f4816X;

    /* renamed from: Y */
    public OnItemViewClickedListener f4817Y;

    /* renamed from: a0 */
    public float f4819a0;

    /* renamed from: b0 */
    public boolean f4820b0;

    /* renamed from: c0 */
    public Object f4821c0;

    /* renamed from: e0 */
    public PresenterSelector f4823e0;

    /* renamed from: g0 */
    public Object f4825g0;

    /* renamed from: h0 */
    public Object f4826h0;

    /* renamed from: i0 */
    public Object f4827i0;

    /* renamed from: j0 */
    public Object f4828j0;

    /* renamed from: k0 */
    public C2057zh f4829k0;

    /* renamed from: l0 */
    public BrowseTransitionListener f4830l0;

    /* renamed from: z */
    public final C1872uh f4836z = new C1872uh(this);

    /* renamed from: A */
    public final StateMachine.Event f4793A = new StateMachine.Event("headerFragmentViewCreated");

    /* renamed from: B */
    public final StateMachine.Event f4794B = new StateMachine.Event("mainFragmentViewCreated");

    /* renamed from: C */
    public final StateMachine.Event f4795C = new StateMachine.Event("screenDataReady");

    /* renamed from: D */
    public final MainFragmentAdapterRegistry f4796D = new MainFragmentAdapterRegistry();

    /* renamed from: L */
    public int f4804L = 1;

    /* renamed from: M */
    public int f4805M = 0;

    /* renamed from: Q */
    public boolean f4809Q = true;

    /* renamed from: S */
    public boolean f4811S = true;

    /* renamed from: T */
    public boolean f4812T = true;

    /* renamed from: W */
    public boolean f4815W = true;

    /* renamed from: Z */
    public int f4818Z = -1;

    /* renamed from: d0 */
    public boolean f4822d0 = true;

    /* renamed from: f0 */
    public final RunnableC0019ai f4824f0 = new RunnableC0019ai(0, this);

    /* renamed from: m0 */
    public final C1946wh f4831m0 = new C1946wh(this);

    /* renamed from: n0 */
    public final C1983xh f4832n0 = new C1983xh(this);

    /* renamed from: o0 */
    public final C0267a f4833o0 = new C0267a(this);

    /* renamed from: p0 */
    public final C0268b f4834p0 = new C0268b(this);

    /* renamed from: q0 */
    public final C1835th f4835q0 = new C1835th(this);

    @Deprecated
    /* loaded from: classes.dex */
    public static class BrowseTransitionListener {
        public void onHeadersTransitionStart(boolean z) {
        }

        public void onHeadersTransitionStop(boolean z) {
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class FragmentFactory<T extends Fragment> {
        public abstract T createFragment(Object obj);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface FragmentHost {
        void notifyDataReady(MainFragmentAdapter mainFragmentAdapter);

        void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter);

        void showTitleView(boolean z);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class ListRowFragmentFactory extends FragmentFactory<RowsFragment> {
        @Override // androidx.leanback.app.BrowseFragment.FragmentFactory
        public RowsFragment createFragment(Object obj) {
            return new RowsFragment();
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class MainFragmentAdapter<T extends Fragment> {

        /* renamed from: a */
        public boolean f4837a;

        /* renamed from: b */
        public final Fragment f4838b;

        /* renamed from: c */
        public C0272f f4839c;

        public MainFragmentAdapter(T t) {
            this.f4838b = t;
        }

        public final T getFragment() {
            return (T) this.f4838b;
        }

        public final FragmentHost getFragmentHost() {
            return this.f4839c;
        }

        public boolean isScalingEnabled() {
            return this.f4837a;
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
            this.f4837a = z;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface MainFragmentAdapterProvider {
        MainFragmentAdapter getMainFragmentAdapter();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class MainFragmentAdapterRegistry {

        /* renamed from: b */
        public static final ListRowFragmentFactory f4840b = new ListRowFragmentFactory();

        /* renamed from: a */
        public final HashMap f4841a = new HashMap();

        public MainFragmentAdapterRegistry() {
            registerFragment(ListRow.class, f4840b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.leanback.app.BrowseFragment$FragmentFactory] */
        public Fragment createFragment(Object obj) {
            ListRowFragmentFactory listRowFragmentFactory;
            ListRowFragmentFactory listRowFragmentFactory2 = f4840b;
            if (obj == null) {
                listRowFragmentFactory = listRowFragmentFactory2;
            } else {
                listRowFragmentFactory = (FragmentFactory) this.f4841a.get(obj.getClass());
            }
            if (listRowFragmentFactory != null || (obj instanceof PageRow)) {
                listRowFragmentFactory2 = listRowFragmentFactory;
            }
            return listRowFragmentFactory2.createFragment(obj);
        }

        public void registerFragment(Class<?> cls, FragmentFactory fragmentFactory) {
            this.f4841a.put(cls, fragmentFactory);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class MainFragmentRowsAdapter<T extends Fragment> {

        /* renamed from: a */
        public final Fragment f4842a;

        public MainFragmentRowsAdapter(T t) {
            if (t != null) {
                this.f4842a = t;
                return;
            }
            throw new IllegalArgumentException("Fragment can't be null");
        }

        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
            return null;
        }

        public final T getFragment() {
            return (T) this.f4842a;
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

    @Deprecated
    /* loaded from: classes.dex */
    public interface MainFragmentRowsAdapterProvider {
        MainFragmentRowsAdapter getMainFragmentRowsAdapter();
    }

    public static Bundle createArgs(Bundle bundle, String str, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(f4791r0, str);
        bundle.putInt(f4792s0, i);
        return bundle;
    }

    @Override // androidx.leanback.app.BaseFragment
    /* renamed from: a */
    public final void mo1259a() {
        super.mo1259a();
        this.f4754w.addState(this.f4836z);
    }

    @Override // androidx.leanback.app.BaseFragment
    /* renamed from: b */
    public final void mo1260b() {
        super.mo1260b();
        StateMachine stateMachine = this.f4754w;
        C0016af c0016af = this.f4743l;
        stateMachine.addTransition(c0016af, this.f4836z, this.f4793A);
        stateMachine.addTransition(c0016af, this.f4744m, this.f4794B);
        stateMachine.addTransition(c0016af, this.f4745n, this.f4795C);
    }

    /* renamed from: c */
    public final void m1263c() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i) != this.f4798F) {
            childFragmentManager.beginTransaction().replace(i, this.f4798F).commit();
        }
    }

    @Override // androidx.leanback.app.BaseFragment
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(ou0.m6729a(this), R.transition.lb_browse_entrance_transition);
    }

    /* renamed from: d */
    public final boolean m1264d(ObjectAdapter objectAdapter, int i) {
        Object obj;
        boolean z;
        boolean z2 = true;
        Object obj2 = null;
        if (!this.f4812T) {
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
        boolean z3 = this.f4820b0;
        Object obj3 = this.f4821c0;
        if (this.f4812T && (obj instanceof PageRow)) {
            z = true;
        } else {
            z = false;
        }
        this.f4820b0 = z;
        if (z) {
            obj2 = obj;
        }
        this.f4821c0 = obj2;
        if (this.f4798F != null) {
            if (z3) {
                if (z && (obj3 == null || obj3 == obj2)) {
                    z2 = false;
                }
            } else {
                z2 = z;
            }
        }
        if (z2) {
            Fragment createFragment = this.f4796D.createFragment(obj);
            this.f4798F = createFragment;
            if (createFragment instanceof MainFragmentAdapterProvider) {
                m1268h();
            } else {
                throw new IllegalArgumentException("Fragment must implement MainFragmentAdapterProvider");
            }
        }
        return z2;
    }

    /* renamed from: e */
    public final void m1265e(boolean z) {
        int i;
        float f;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4808P.getLayoutParams();
        if (!z) {
            i = this.f4813U;
        } else {
            i = 0;
        }
        marginLayoutParams.setMarginStart(i);
        this.f4808P.setLayoutParams(marginLayoutParams);
        this.f4797E.setExpand(z);
        m1269i();
        if (!z && this.f4815W && this.f4797E.isScalingEnabled()) {
            f = this.f4819a0;
        } else {
            f = 1.0f;
        }
        this.f4808P.setLayoutScaleY(f);
        this.f4808P.setChildScale(f);
    }

    public void enableMainFragmentScaling(boolean z) {
        this.f4815W = z;
    }

    @Deprecated
    public void enableRowScaling(boolean z) {
        enableMainFragmentScaling(z);
    }

    /* renamed from: f */
    public final boolean m1266f(int i) {
        ObjectAdapter objectAdapter = this.f4802J;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            for (int i2 = 0; i2 < this.f4802J.size(); i2++) {
                if (((Row) this.f4802J.get(i2)).isRenderedAsRowView()) {
                    if (i == i2) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: g */
    public final void m1267g(boolean z) {
        int i;
        View view = this.f4799G.getView();
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (z) {
            i = 0;
        } else {
            i = -this.f4813U;
        }
        marginLayoutParams.setMarginStart(i);
        view.setLayoutParams(marginLayoutParams);
    }

    public ObjectAdapter getAdapter() {
        return this.f4802J;
    }

    @ColorInt
    public int getBrandColor() {
        return this.f4805M;
    }

    public HeadersFragment getHeadersFragment() {
        return this.f4799G;
    }

    public int getHeadersState() {
        return this.f4804L;
    }

    public Fragment getMainFragment() {
        return this.f4798F;
    }

    public final MainFragmentAdapterRegistry getMainFragmentRegistry() {
        return this.f4796D;
    }

    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.f4817Y;
    }

    public OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.f4816X;
    }

    public RowsFragment getRowsFragment() {
        Fragment fragment = this.f4798F;
        if (fragment instanceof RowsFragment) {
            return (RowsFragment) fragment;
        }
        return null;
    }

    public int getSelectedPosition() {
        return this.f4818Z;
    }

    public RowPresenter.ViewHolder getSelectedRowViewHolder() {
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.f4800H;
        if (mainFragmentRowsAdapter != null) {
            return this.f4800H.findRowViewHolderByPosition(mainFragmentRowsAdapter.getSelectedPosition());
        }
        return null;
    }

    /* renamed from: h */
    public final void m1268h() {
        boolean z;
        MainFragmentAdapter mainFragmentAdapter = ((MainFragmentAdapterProvider) this.f4798F).getMainFragmentAdapter();
        this.f4797E = mainFragmentAdapter;
        mainFragmentAdapter.f4839c = new C0272f(this);
        if (!this.f4820b0) {
            ComponentCallbacks2 componentCallbacks2 = this.f4798F;
            if (componentCallbacks2 instanceof MainFragmentRowsAdapterProvider) {
                m1270j(((MainFragmentRowsAdapterProvider) componentCallbacks2).getMainFragmentRowsAdapter());
            } else {
                m1270j(null);
            }
            if (this.f4800H == null) {
                z = true;
            } else {
                z = false;
            }
            this.f4820b0 = z;
            return;
        }
        m1270j(null);
    }

    /* renamed from: i */
    public final void m1269i() {
        int i = this.f4814V;
        if (this.f4815W && this.f4797E.isScalingEnabled() && this.f4811S) {
            i = (int) ((i / this.f4819a0) + 0.5f);
        }
        this.f4797E.setAlignment(i);
    }

    public final boolean isHeadersTransitionOnBackEnabled() {
        return this.f4809Q;
    }

    public boolean isInHeadersTransition() {
        if (this.f4828j0 != null) {
            return true;
        }
        return false;
    }

    public boolean isShowingHeaders() {
        return this.f4811S;
    }

    /* renamed from: j */
    public final void m1270j(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        MainFragmentRowsAdapter mainFragmentRowsAdapter2 = this.f4800H;
        if (mainFragmentRowsAdapter == mainFragmentRowsAdapter2) {
            return;
        }
        if (mainFragmentRowsAdapter2 != null) {
            mainFragmentRowsAdapter2.setAdapter(null);
        }
        this.f4800H = mainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewSelectedListener(new C0273g(this, mainFragmentRowsAdapter));
            this.f4800H.setOnItemViewClickedListener(this.f4817Y);
        }
        m1273m();
    }

    /* renamed from: k */
    public final void m1271k(boolean z) {
        HeadersFragment headersFragment = this.f4799G;
        headersFragment.f5023k = z;
        headersFragment.m1306f();
        m1267g(z);
        m1265e(!z);
    }

    /* renamed from: l */
    public final void m1272l(boolean z) {
        ObjectAdapter objectAdapter;
        if (!getFragmentManager().isDestroyed() && (objectAdapter = this.f4802J) != null && objectAdapter.size() != 0) {
            this.f4811S = z;
            this.f4797E.onTransitionPrepare();
            this.f4797E.onTransitionStart();
            RunnableC0269c runnableC0269c = new RunnableC0269c(this, z);
            if (!z) {
                runnableC0269c.run();
                return;
            }
            MainFragmentAdapter mainFragmentAdapter = this.f4797E;
            View view = getView();
            ViewTreeObserverOnPreDrawListenerC0271e viewTreeObserverOnPreDrawListenerC0271e = new ViewTreeObserverOnPreDrawListenerC0271e(this, runnableC0269c, mainFragmentAdapter, view);
            view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0271e);
            mainFragmentAdapter.setExpand(false);
            view.invalidate();
            viewTreeObserverOnPreDrawListenerC0271e.f5322c = 0;
        }
    }

    /* renamed from: m */
    public final void m1273m() {
        u91 u91Var = this.f4801I;
        u91 u91Var2 = null;
        if (u91Var != null) {
            u91Var.f27154d.unregisterObserver(u91Var.f27156f);
            this.f4801I = null;
        }
        if (this.f4800H != null) {
            ObjectAdapter objectAdapter = this.f4802J;
            if (objectAdapter != null) {
                u91Var2 = new u91(objectAdapter);
            }
            this.f4801I = u91Var2;
            this.f4800H.setAdapter(u91Var2);
        }
    }

    /* renamed from: n */
    public final void m1274n() {
        boolean m1266f;
        int i;
        MainFragmentAdapter mainFragmentAdapter;
        boolean m1266f2;
        MainFragmentAdapter mainFragmentAdapter2;
        if (!this.f4811S) {
            if (this.f4820b0 && (mainFragmentAdapter2 = this.f4797E) != null) {
                m1266f2 = mainFragmentAdapter2.f4839c.f5325a;
            } else {
                m1266f2 = m1266f(this.f4818Z);
            }
            if (m1266f2) {
                showTitle(6);
                return;
            } else {
                showTitle(false);
                return;
            }
        }
        if (this.f4820b0 && (mainFragmentAdapter = this.f4797E) != null) {
            m1266f = mainFragmentAdapter.f4839c.f5325a;
        } else {
            m1266f = m1266f(this.f4818Z);
        }
        int i2 = this.f4818Z;
        ObjectAdapter objectAdapter = this.f4802J;
        boolean z = true;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            for (int i3 = 0; i3 < this.f4802J.size(); i3++) {
                Row row = (Row) this.f4802J.get(i3);
                if (row.isRenderedAsRowView() || (row instanceof PageRow)) {
                    if (i2 != i3) {
                        z = false;
                    }
                }
            }
        }
        if (m1266f) {
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

    @Override // androidx.leanback.app.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        TypedArray obtainStyledAttributes = ou0.m6729a(this).obtainStyledAttributes(R.styleable.LeanbackTheme);
        this.f4813U = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginStart, r0.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_start));
        this.f4814V = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginTop, r0.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_top));
        obtainStyledAttributes.recycle();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String str = f4791r0;
            if (arguments.containsKey(str)) {
                setTitle(arguments.getString(str));
            }
            String str2 = f4792s0;
            if (arguments.containsKey(str2)) {
                setHeadersState(arguments.getInt(str2));
            }
        }
        if (this.f4812T) {
            if (this.f4809Q) {
                this.f4810R = "lbHeadersBackStack_" + this;
                this.f4829k0 = new C2057zh(this);
                getFragmentManager().addOnBackStackChangedListener(this.f4829k0);
                C2057zh c2057zh = this.f4829k0;
                BrowseFragment browseFragment = c2057zh.f29375c;
                if (bundle != null) {
                    int i = bundle.getInt("headerStackIndex", -1);
                    c2057zh.f29374b = i;
                    if (i == -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    browseFragment.f4811S = z;
                } else if (!browseFragment.f4811S) {
                    browseFragment.getFragmentManager().beginTransaction().addToBackStack(browseFragment.f4810R).commit();
                }
            } else if (bundle != null) {
                this.f4811S = bundle.getBoolean("headerShow");
            }
        }
        this.f4819a0 = getResources().getFraction(R.fraction.lb_browse_rows_scale, 1, 1);
    }

    public HeadersFragment onCreateHeadersFragment() {
        return new HeadersFragment();
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        int i;
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i2 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i2) == null) {
            this.f4799G = onCreateHeadersFragment();
            m1264d(this.f4802J, this.f4818Z);
            FragmentTransaction replace = getChildFragmentManager().beginTransaction().replace(R.id.browse_headers_dock, this.f4799G);
            Fragment fragment = this.f4798F;
            if (fragment != null) {
                replace.replace(i2, fragment);
            } else {
                MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(null);
                this.f4797E = mainFragmentAdapter;
                mainFragmentAdapter.f4839c = new C0272f(this);
            }
            replace.commit();
        } else {
            this.f4799G = (HeadersFragment) getChildFragmentManager().findFragmentById(R.id.browse_headers_dock);
            this.f4798F = getChildFragmentManager().findFragmentById(i2);
            if (bundle != null && bundle.getBoolean("isPageRow", false)) {
                z = true;
            } else {
                z = false;
            }
            this.f4820b0 = z;
            if (bundle != null) {
                i = bundle.getInt("currentSelectedPosition", 0);
            } else {
                i = 0;
            }
            this.f4818Z = i;
            m1268h();
        }
        HeadersFragment headersFragment = this.f4799G;
        headersFragment.f5024l = !this.f4812T;
        headersFragment.m1306f();
        PresenterSelector presenterSelector = this.f4823e0;
        if (presenterSelector != null) {
            this.f4799G.setPresenterSelector(presenterSelector);
        }
        this.f4799G.setAdapter(this.f4802J);
        this.f4799G.setOnHeaderViewSelectedListener(this.f4834p0);
        this.f4799G.setOnHeaderClickedListener(this.f4833o0);
        View inflate = layoutInflater.inflate(R.layout.lb_browse_fragment, viewGroup, false);
        getProgressBarManager().setRootView((ViewGroup) inflate);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) inflate.findViewById(R.id.browse_frame);
        this.f4807O = browseFrameLayout;
        browseFrameLayout.setOnChildFocusListener(this.f4832n0);
        this.f4807O.setOnFocusSearchListener(this.f4831m0);
        installTitleView(layoutInflater, this.f4807O, bundle);
        ScaleFrameLayout scaleFrameLayout = (ScaleFrameLayout) inflate.findViewById(i2);
        this.f4808P = scaleFrameLayout;
        scaleFrameLayout.setPivotX(RecyclerView.f7068F0);
        this.f4808P.setPivotY(this.f4814V);
        if (this.f4806N) {
            HeadersFragment headersFragment2 = this.f4799G;
            headersFragment2.f5025m = this.f4805M;
            headersFragment2.f5026n = true;
            if (headersFragment2.getVerticalGridView() != null) {
                headersFragment2.getVerticalGridView().setBackgroundColor(headersFragment2.f5025m);
                headersFragment2.m1305e(headersFragment2.f5025m);
            }
        }
        this.f4825g0 = TransitionHelper.createScene(this.f4807O, new RunnableC2020yh(this, 0));
        this.f4826h0 = TransitionHelper.createScene(this.f4807O, new RunnableC2020yh(this, 1));
        this.f4827i0 = TransitionHelper.createScene(this.f4807O, new RunnableC2020yh(this, 2));
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        if (this.f4829k0 != null) {
            getFragmentManager().removeOnBackStackChangedListener(this.f4829k0);
        }
        super.onDestroy();
    }

    @Override // androidx.leanback.app.BaseFragment, androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onDestroyView() {
        m1270j(null);
        this.f4821c0 = null;
        this.f4797E = null;
        this.f4798F = null;
        this.f4799G = null;
        this.f4807O = null;
        this.f4808P = null;
        this.f4827i0 = null;
        this.f4825g0 = null;
        this.f4826h0 = null;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void onEntranceTransitionEnd() {
        MainFragmentAdapter mainFragmentAdapter = this.f4797E;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
        }
        HeadersFragment headersFragment = this.f4799G;
        if (headersFragment != null) {
            headersFragment.onTransitionEnd();
        }
    }

    @Override // androidx.leanback.app.BaseFragment
    public void onEntranceTransitionPrepare() {
        this.f4799G.onTransitionPrepare();
        this.f4797E.setEntranceTransitionState(false);
        this.f4797E.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void onEntranceTransitionStart() {
        this.f4799G.onTransitionStart();
        this.f4797E.onTransitionStart();
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentSelectedPosition", this.f4818Z);
        bundle.putBoolean("isPageRow", this.f4820b0);
        C2057zh c2057zh = this.f4829k0;
        if (c2057zh != null) {
            bundle.putInt("headerStackIndex", c2057zh.f29374b);
        } else {
            bundle.putBoolean("headerShow", this.f4811S);
        }
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onStart() {
        Fragment fragment;
        HeadersFragment headersFragment;
        super.onStart();
        this.f4799G.setAlignment(this.f4814V);
        m1269i();
        if (this.f4812T && this.f4811S && (headersFragment = this.f4799G) != null && headersFragment.getView() != null) {
            this.f4799G.getView().requestFocus();
        } else if ((!this.f4812T || !this.f4811S) && (fragment = this.f4798F) != null && fragment.getView() != null) {
            this.f4798F.getView().requestFocus();
        }
        if (this.f4812T) {
            m1271k(this.f4811S);
        }
        this.f4754w.fireEvent(this.f4793A);
        this.f4822d0 = false;
        m1263c();
        RunnableC0019ai runnableC0019ai = this.f4824f0;
        if (runnableC0019ai.f204c != -1) {
            ((BrowseFragment) runnableC0019ai.f206e).f4807O.post(runnableC0019ai);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.f4822d0 = true;
        RunnableC0019ai runnableC0019ai = this.f4824f0;
        ((BrowseFragment) runnableC0019ai.f206e).f4807O.removeCallbacks(runnableC0019ai);
        super.onStop();
    }

    @Override // androidx.leanback.app.BaseFragment
    public void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.f4827i0, obj);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.f4802J = objectAdapter;
        if (objectAdapter == null) {
            this.f4803K = null;
        } else {
            PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
            if (presenterSelector != null) {
                if (presenterSelector != this.f4803K) {
                    this.f4803K = presenterSelector;
                    Presenter[] presenters = presenterSelector.getPresenters();
                    InvisibleRowPresenter invisibleRowPresenter = new InvisibleRowPresenter();
                    int length = presenters.length;
                    Presenter[] presenterArr = new Presenter[length + 1];
                    System.arraycopy(presenterArr, 0, presenters, 0, presenters.length);
                    presenterArr[length] = invisibleRowPresenter;
                    this.f4802J.setPresenterSelector(new C1909vh(presenterSelector, invisibleRowPresenter, presenterArr, 0));
                }
            } else {
                throw new IllegalArgumentException("Adapter.getPresenterSelector() is null");
            }
        }
        if (getView() == null) {
            return;
        }
        m1273m();
        this.f4799G.setAdapter(this.f4802J);
    }

    public void setBrandColor(@ColorInt int i) {
        this.f4805M = i;
        this.f4806N = true;
        HeadersFragment headersFragment = this.f4799G;
        if (headersFragment != null) {
            headersFragment.f5025m = i;
            headersFragment.f5026n = true;
            if (headersFragment.getVerticalGridView() != null) {
                headersFragment.getVerticalGridView().setBackgroundColor(headersFragment.f5025m);
                headersFragment.m1305e(headersFragment.f5025m);
            }
        }
    }

    public void setBrowseTransitionListener(BrowseTransitionListener browseTransitionListener) {
        this.f4830l0 = browseTransitionListener;
    }

    public void setHeaderPresenterSelector(PresenterSelector presenterSelector) {
        this.f4823e0 = presenterSelector;
        HeadersFragment headersFragment = this.f4799G;
        if (headersFragment != null) {
            headersFragment.setPresenterSelector(presenterSelector);
        }
    }

    public void setHeadersState(int i) {
        if (i >= 1 && i <= 3) {
            if (i != this.f4804L) {
                this.f4804L = i;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            Log.w("BrowseFragment", "Unknown headers state: " + i);
                        } else {
                            this.f4812T = false;
                            this.f4811S = false;
                        }
                    } else {
                        this.f4812T = true;
                        this.f4811S = false;
                    }
                } else {
                    this.f4812T = true;
                    this.f4811S = true;
                }
                HeadersFragment headersFragment = this.f4799G;
                if (headersFragment != null) {
                    headersFragment.f5024l = true ^ this.f4812T;
                    headersFragment.m1306f();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Invalid headers state: "));
    }

    public final void setHeadersTransitionOnBackEnabled(boolean z) {
        this.f4809Q = z;
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.f4817Y = onItemViewClickedListener;
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.f4800H;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f4816X = onItemViewSelectedListener;
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public void startHeadersTransition(boolean z) {
        if (this.f4812T) {
            if (!isInHeadersTransition() && this.f4811S != z) {
                m1272l(z);
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot start headers transition");
    }

    public void setSelectedPosition(int i, boolean z) {
        this.f4824f0.m90a(i, 1, z);
    }

    public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
        if (this.f4796D == null) {
            return;
        }
        if (viewHolderTask != null) {
            startHeadersTransition(false);
        }
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.f4800H;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setSelectedPosition(i, z, viewHolderTask);
        }
    }
}
