package androidx.leanback.app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.R;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.SearchBar;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.SpeechRecognitionCallback;
import androidx.leanback.widget.VerticalGridView;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1726qj;
import p000.if2;
import p000.kf2;
import p000.lf2;
import p000.mf2;
import p000.nf2;
import p000.of2;

/* loaded from: classes.dex */
public class SearchSupportFragment extends Fragment {

    /* renamed from: B0 */
    public static final String f5262B0;

    /* renamed from: C0 */
    public static final String f5263C0;

    /* renamed from: A0 */
    public boolean f5264A0;

    /* renamed from: j0 */
    public RowsSupportFragment f5270j0;

    /* renamed from: k0 */
    public SearchBar f5271k0;

    /* renamed from: l0 */
    public SearchResultProvider f5272l0;

    /* renamed from: n0 */
    public OnItemViewSelectedListener f5274n0;

    /* renamed from: o0 */
    public OnItemViewClickedListener f5275o0;

    /* renamed from: p0 */
    public ObjectAdapter f5276p0;

    /* renamed from: q0 */
    public SpeechRecognitionCallback f5277q0;

    /* renamed from: r0 */
    public String f5278r0;

    /* renamed from: s0 */
    public Drawable f5279s0;

    /* renamed from: t0 */
    public if2 f5280t0;

    /* renamed from: u0 */
    public SpeechRecognizer f5281u0;

    /* renamed from: v0 */
    public int f5282v0;

    /* renamed from: x0 */
    public boolean f5284x0;

    /* renamed from: y0 */
    public boolean f5285y0;

    /* renamed from: e0 */
    public final kf2 f5265e0 = new kf2(this);

    /* renamed from: f0 */
    public final Handler f5266f0 = new Handler();

    /* renamed from: g0 */
    public final lf2 f5267g0 = new lf2(this, 0);

    /* renamed from: h0 */
    public final RunnableC0287u f5268h0 = new RunnableC0287u(this);

    /* renamed from: i0 */
    public final lf2 f5269i0 = new lf2(this, 1);

    /* renamed from: m0 */
    public String f5273m0 = null;

    /* renamed from: w0 */
    public boolean f5283w0 = true;

    /* renamed from: z0 */
    public final mf2 f5286z0 = new mf2(this);

    /* loaded from: classes.dex */
    public interface SearchResultProvider {
        ObjectAdapter getResultsAdapter();

        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    static {
        String canonicalName = SearchSupportFragment.class.getCanonicalName();
        f5262B0 = AbstractC1726qj.m7057m(canonicalName, ".query");
        f5263C0 = AbstractC1726qj.m7057m(canonicalName, ".title");
    }

    public static Bundle createArgs(Bundle bundle, String str) {
        return createArgs(bundle, str, null);
    }

    public static SearchSupportFragment newInstance(String str) {
        SearchSupportFragment searchSupportFragment = new SearchSupportFragment();
        searchSupportFragment.setArguments(createArgs(null, str));
        return searchSupportFragment;
    }

    public void displayCompletions(List<String> list) {
        this.f5271k0.displayCompletions(list);
    }

    public Drawable getBadgeDrawable() {
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            return searchBar.getBadgeDrawable();
        }
        return null;
    }

    public Intent getRecognizerIntent() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        boolean z = true;
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null && searchBar.getHint() != null) {
            intent.putExtra("android.speech.extra.PROMPT", this.f5271k0.getHint());
        }
        if (this.f5279s0 == null) {
            z = false;
        }
        intent.putExtra("LEANBACK_BADGE_PRESENT", z);
        return intent;
    }

    public RowsSupportFragment getRowsSupportFragment() {
        return this.f5270j0;
    }

    public String getTitle() {
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            return searchBar.getTitle();
        }
        return null;
    }

    /* renamed from: l */
    public final void m1349l() {
        SearchBar searchBar;
        if2 if2Var = this.f5280t0;
        if (if2Var != null && (searchBar = this.f5271k0) != null) {
            searchBar.setSearchQuery((String) if2Var.f18397a);
            if2 if2Var2 = this.f5280t0;
            if (if2Var2.f18398b) {
                String str = (String) if2Var2.f18397a;
                this.f5282v0 |= 2;
                m1350m();
                SearchResultProvider searchResultProvider = this.f5272l0;
                if (searchResultProvider != null) {
                    searchResultProvider.onQueryTextSubmit(str);
                }
            }
            this.f5280t0 = null;
        }
    }

    /* renamed from: m */
    public final void m1350m() {
        RowsSupportFragment rowsSupportFragment = this.f5270j0;
        if (rowsSupportFragment != null && rowsSupportFragment.getVerticalGridView() != null && this.f5276p0.size() != 0 && this.f5270j0.getVerticalGridView().requestFocus()) {
            this.f5282v0 &= -2;
        }
    }

    /* renamed from: n */
    public final void m1351n() {
        RowsSupportFragment rowsSupportFragment;
        ObjectAdapter objectAdapter = this.f5276p0;
        if (objectAdapter != null && objectAdapter.size() > 0 && (rowsSupportFragment = this.f5270j0) != null && rowsSupportFragment.getAdapter() == this.f5276p0) {
            m1350m();
        } else {
            this.f5271k0.requestFocus();
        }
    }

    /* renamed from: o */
    public final void m1352o() {
        int i;
        int i2;
        ObjectAdapter objectAdapter;
        RowsSupportFragment rowsSupportFragment = this.f5270j0;
        if (rowsSupportFragment != null) {
            i = rowsSupportFragment.getSelectedPosition();
        } else {
            i = -1;
        }
        SearchBar searchBar = this.f5271k0;
        if (i > 0 && (objectAdapter = this.f5276p0) != null && objectAdapter.size() != 0) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        searchBar.setVisibility(i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        if (this.f5283w0) {
            if (bundle == null) {
                z = true;
            } else {
                z = false;
            }
            this.f5283w0 = z;
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lb_search_fragment, viewGroup, false);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) inflate.findViewById(R.id.lb_search_frame);
        SearchBar searchBar = (SearchBar) browseFrameLayout.findViewById(R.id.lb_search_bar);
        this.f5271k0 = searchBar;
        searchBar.setSearchBarListener(new C0288v(this));
        this.f5271k0.setSpeechRecognitionCallback(this.f5277q0);
        this.f5271k0.setPermissionListener(this.f5286z0);
        m1349l();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String str = f5262B0;
            if (arguments.containsKey(str)) {
                this.f5271k0.setSearchQuery(arguments.getString(str));
            }
            String str2 = f5263C0;
            if (arguments.containsKey(str2)) {
                setTitle(arguments.getString(str2));
            }
        }
        Drawable drawable = this.f5279s0;
        if (drawable != null) {
            setBadgeDrawable(drawable);
        }
        String str3 = this.f5278r0;
        if (str3 != null) {
            setTitle(str3);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.lb_results_frame;
        if (childFragmentManager.findFragmentById(i) == null) {
            this.f5270j0 = new RowsSupportFragment();
            getChildFragmentManager().beginTransaction().replace(i, this.f5270j0).commit();
        } else {
            this.f5270j0 = (RowsSupportFragment) getChildFragmentManager().findFragmentById(i);
        }
        this.f5270j0.setOnItemViewSelectedListener(new nf2(this));
        this.f5270j0.setOnItemViewClickedListener(this.f5275o0);
        this.f5270j0.setExpand(true);
        if (this.f5272l0 != null) {
            Handler handler = this.f5266f0;
            RunnableC0287u runnableC0287u = this.f5268h0;
            handler.removeCallbacks(runnableC0287u);
            handler.post(runnableC0287u);
        }
        browseFrameLayout.setOnFocusSearchListener(new of2(this));
        if (!SpeechRecognizer.isRecognitionAvailable(getContext())) {
            if (this.f5271k0.hasFocus()) {
                this.f5271k0.findViewById(R.id.lb_search_text_editor).requestFocus();
            }
            this.f5271k0.findViewById(R.id.lb_search_bar_speech_orb).setFocusable(false);
        } else {
            this.f5264A0 = true;
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ObjectAdapter objectAdapter = this.f5276p0;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(this.f5265e0);
            this.f5276p0 = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f5271k0 = null;
        this.f5270j0 = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        if (this.f5281u0 != null) {
            this.f5271k0.setSpeechRecognizer(null);
            this.f5281u0.destroy();
            this.f5281u0 = null;
        }
        this.f5284x0 = true;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0 && strArr.length > 0 && strArr[0].equals("android.permission.RECORD_AUDIO") && iArr[0] == 0) {
            startRecognition();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5284x0 = false;
        if (this.f5277q0 == null && this.f5281u0 == null && this.f5264A0) {
            SpeechRecognizer createSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
            this.f5281u0 = createSpeechRecognizer;
            this.f5271k0.setSpeechRecognizer(createSpeechRecognizer);
        }
        if (this.f5285y0) {
            this.f5285y0 = false;
            this.f5271k0.startRecognition();
        } else {
            this.f5271k0.stopRecognition();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.f5270j0.getVerticalGridView();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.lb_search_browse_rows_align_top);
        verticalGridView.setItemAlignmentOffset(0);
        verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignmentOffset(dimensionPixelSize);
        verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignment(0);
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f5279s0 = drawable;
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            searchBar.setBadgeDrawable(drawable);
        }
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        if (onItemViewClickedListener != this.f5275o0) {
            this.f5275o0 = onItemViewClickedListener;
            RowsSupportFragment rowsSupportFragment = this.f5270j0;
            if (rowsSupportFragment != null) {
                rowsSupportFragment.setOnItemViewClickedListener(onItemViewClickedListener);
            }
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f5274n0 = onItemViewSelectedListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColorsInListening(colors);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [if2, java.lang.Object] */
    public void setSearchQuery(String str, boolean z) {
        if (str == null) {
            return;
        }
        ?? obj = new Object();
        obj.f18397a = str;
        obj.f18398b = z;
        this.f5280t0 = obj;
        m1349l();
        if (this.f5283w0) {
            this.f5283w0 = false;
            this.f5266f0.removeCallbacks(this.f5269i0);
        }
    }

    public void setSearchResultProvider(SearchResultProvider searchResultProvider) {
        if (this.f5272l0 != searchResultProvider) {
            this.f5272l0 = searchResultProvider;
            Handler handler = this.f5266f0;
            RunnableC0287u runnableC0287u = this.f5268h0;
            handler.removeCallbacks(runnableC0287u);
            handler.post(runnableC0287u);
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.f5277q0 = speechRecognitionCallback;
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            searchBar.setSpeechRecognitionCallback(speechRecognitionCallback);
        }
        if (speechRecognitionCallback != null && this.f5281u0 != null) {
            this.f5271k0.setSpeechRecognizer(null);
            this.f5281u0.destroy();
            this.f5281u0 = null;
        }
    }

    public void setTitle(String str) {
        this.f5278r0 = str;
        SearchBar searchBar = this.f5271k0;
        if (searchBar != null) {
            searchBar.setTitle(str);
        }
    }

    public void startRecognition() {
        if (this.f5284x0) {
            this.f5285y0 = true;
        } else {
            this.f5271k0.startRecognition();
        }
    }

    public static Bundle createArgs(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(f5262B0, str);
        bundle.putString(f5263C0, str2);
        return bundle;
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.f5271k0.displayCompletions(completionInfoArr);
    }

    public void setSearchQuery(Intent intent, boolean z) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            return;
        }
        setSearchQuery(stringArrayListExtra.get(0), z);
    }
}
