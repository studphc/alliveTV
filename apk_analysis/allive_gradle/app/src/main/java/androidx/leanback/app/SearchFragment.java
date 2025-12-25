package androidx.leanback.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import androidx.annotation.Nullable;
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
import p000.df2;
import p000.ef2;
import p000.ff2;
import p000.gf2;
import p000.hf2;
import p000.if2;
import p000.ou0;

@Deprecated
/* loaded from: classes.dex */
public class SearchFragment extends Fragment {

    /* renamed from: x */
    public static final String f5237x;

    /* renamed from: y */
    public static final String f5238y;

    /* renamed from: f */
    public RowsFragment f5244f;

    /* renamed from: g */
    public SearchBar f5245g;

    /* renamed from: h */
    public SearchResultProvider f5246h;

    /* renamed from: j */
    public OnItemViewSelectedListener f5248j;

    /* renamed from: k */
    public OnItemViewClickedListener f5249k;

    /* renamed from: l */
    public ObjectAdapter f5250l;

    /* renamed from: m */
    public SpeechRecognitionCallback f5251m;

    /* renamed from: n */
    public String f5252n;

    /* renamed from: o */
    public Drawable f5253o;

    /* renamed from: p */
    public if2 f5254p;

    /* renamed from: q */
    public SpeechRecognizer f5255q;

    /* renamed from: r */
    public int f5256r;

    /* renamed from: t */
    public boolean f5258t;

    /* renamed from: u */
    public boolean f5259u;

    /* renamed from: w */
    public boolean f5261w;

    /* renamed from: a */
    public final df2 f5239a = new df2(this);

    /* renamed from: b */
    public final Handler f5240b = new Handler();

    /* renamed from: c */
    public final ef2 f5241c = new ef2(this, 0);

    /* renamed from: d */
    public final RunnableC0285s f5242d = new RunnableC0285s(this);

    /* renamed from: e */
    public final ef2 f5243e = new ef2(this, 1);

    /* renamed from: i */
    public String f5247i = null;

    /* renamed from: s */
    public boolean f5257s = true;

    /* renamed from: v */
    public final ff2 f5260v = new ff2(this);

    /* loaded from: classes.dex */
    public interface SearchResultProvider {
        ObjectAdapter getResultsAdapter();

        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    static {
        String canonicalName = SearchFragment.class.getCanonicalName();
        f5237x = AbstractC1726qj.m7057m(canonicalName, ".query");
        f5238y = AbstractC1726qj.m7057m(canonicalName, ".title");
    }

    public static Bundle createArgs(Bundle bundle, String str) {
        return createArgs(bundle, str, null);
    }

    public static SearchFragment newInstance(String str) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(createArgs(null, str));
        return searchFragment;
    }

    /* renamed from: a */
    public final void m1345a() {
        SearchBar searchBar;
        if2 if2Var = this.f5254p;
        if (if2Var != null && (searchBar = this.f5245g) != null) {
            searchBar.setSearchQuery((String) if2Var.f18397a);
            if2 if2Var2 = this.f5254p;
            if (if2Var2.f18398b) {
                String str = (String) if2Var2.f18397a;
                this.f5256r |= 2;
                m1346b();
                SearchResultProvider searchResultProvider = this.f5246h;
                if (searchResultProvider != null) {
                    searchResultProvider.onQueryTextSubmit(str);
                }
            }
            this.f5254p = null;
        }
    }

    /* renamed from: b */
    public final void m1346b() {
        RowsFragment rowsFragment = this.f5244f;
        if (rowsFragment != null && rowsFragment.getVerticalGridView() != null && this.f5250l.size() != 0 && this.f5244f.getVerticalGridView().requestFocus()) {
            this.f5256r &= -2;
        }
    }

    /* renamed from: c */
    public final void m1347c() {
        RowsFragment rowsFragment;
        ObjectAdapter objectAdapter = this.f5250l;
        if (objectAdapter != null && objectAdapter.size() > 0 && (rowsFragment = this.f5244f) != null && rowsFragment.getAdapter() == this.f5250l) {
            m1346b();
        } else {
            this.f5245g.requestFocus();
        }
    }

    /* renamed from: d */
    public final void m1348d() {
        int i;
        int i2;
        ObjectAdapter objectAdapter;
        RowsFragment rowsFragment = this.f5244f;
        if (rowsFragment != null) {
            i = rowsFragment.getSelectedPosition();
        } else {
            i = -1;
        }
        SearchBar searchBar = this.f5245g;
        if (i > 0 && (objectAdapter = this.f5250l) != null && objectAdapter.size() != 0) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        searchBar.setVisibility(i2);
    }

    public void displayCompletions(List<String> list) {
        this.f5245g.displayCompletions(list);
    }

    public Drawable getBadgeDrawable() {
        SearchBar searchBar = this.f5245g;
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
        SearchBar searchBar = this.f5245g;
        if (searchBar != null && searchBar.getHint() != null) {
            intent.putExtra("android.speech.extra.PROMPT", this.f5245g.getHint());
        }
        if (this.f5253o == null) {
            z = false;
        }
        intent.putExtra("LEANBACK_BADGE_PRESENT", z);
        return intent;
    }

    public RowsFragment getRowsFragment() {
        return this.f5244f;
    }

    public String getTitle() {
        SearchBar searchBar = this.f5245g;
        if (searchBar != null) {
            return searchBar.getTitle();
        }
        return null;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        if (this.f5257s) {
            if (bundle == null) {
                z = true;
            } else {
                z = false;
            }
            this.f5257s = z;
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lb_search_fragment, viewGroup, false);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) inflate.findViewById(R.id.lb_search_frame);
        SearchBar searchBar = (SearchBar) browseFrameLayout.findViewById(R.id.lb_search_bar);
        this.f5245g = searchBar;
        searchBar.setSearchBarListener(new C0286t(this));
        this.f5245g.setSpeechRecognitionCallback(this.f5251m);
        this.f5245g.setPermissionListener(this.f5260v);
        m1345a();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String str = f5237x;
            if (arguments.containsKey(str)) {
                this.f5245g.setSearchQuery(arguments.getString(str));
            }
            String str2 = f5238y;
            if (arguments.containsKey(str2)) {
                setTitle(arguments.getString(str2));
            }
        }
        Drawable drawable = this.f5253o;
        if (drawable != null) {
            setBadgeDrawable(drawable);
        }
        String str3 = this.f5252n;
        if (str3 != null) {
            setTitle(str3);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i = R.id.lb_results_frame;
        if (childFragmentManager.findFragmentById(i) == null) {
            this.f5244f = new RowsFragment();
            getChildFragmentManager().beginTransaction().replace(i, this.f5244f).commit();
        } else {
            this.f5244f = (RowsFragment) getChildFragmentManager().findFragmentById(i);
        }
        this.f5244f.setOnItemViewSelectedListener(new gf2(this));
        this.f5244f.setOnItemViewClickedListener(this.f5249k);
        this.f5244f.setExpand(true);
        if (this.f5246h != null) {
            Handler handler = this.f5240b;
            RunnableC0285s runnableC0285s = this.f5242d;
            handler.removeCallbacks(runnableC0285s);
            handler.post(runnableC0285s);
        }
        browseFrameLayout.setOnFocusSearchListener(new hf2(this));
        if (!SpeechRecognizer.isRecognitionAvailable(ou0.m6729a(this))) {
            if (this.f5245g.hasFocus()) {
                this.f5245g.findViewById(R.id.lb_search_text_editor).requestFocus();
            }
            this.f5245g.findViewById(R.id.lb_search_bar_speech_orb).setFocusable(false);
        } else {
            this.f5261w = true;
        }
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        ObjectAdapter objectAdapter = this.f5250l;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(this.f5239a);
            this.f5250l = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f5245g = null;
        this.f5244f = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.f5255q != null) {
            this.f5245g.setSpeechRecognizer(null);
            this.f5255q.destroy();
            this.f5255q = null;
        }
        this.f5258t = true;
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0 && strArr.length > 0 && strArr[0].equals("android.permission.RECORD_AUDIO") && iArr[0] == 0) {
            startRecognition();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5258t = false;
        if (this.f5251m == null && this.f5255q == null && this.f5261w) {
            SpeechRecognizer createSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(ou0.m6729a(this));
            this.f5255q = createSpeechRecognizer;
            this.f5245g.setSpeechRecognizer(createSpeechRecognizer);
        }
        if (this.f5259u) {
            this.f5259u = false;
            this.f5245g.startRecognition();
        } else {
            this.f5245g.stopRecognition();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.f5244f.getVerticalGridView();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.lb_search_browse_rows_align_top);
        verticalGridView.setItemAlignmentOffset(0);
        verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignmentOffset(dimensionPixelSize);
        verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignment(0);
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f5253o = drawable;
        SearchBar searchBar = this.f5245g;
        if (searchBar != null) {
            searchBar.setBadgeDrawable(drawable);
        }
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        if (onItemViewClickedListener != this.f5249k) {
            this.f5249k = onItemViewClickedListener;
            RowsFragment rowsFragment = this.f5244f;
            if (rowsFragment != null) {
                rowsFragment.setOnItemViewClickedListener(onItemViewClickedListener);
            }
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.f5248j = onItemViewSelectedListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.f5245g;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.f5245g;
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
        this.f5254p = obj;
        m1345a();
        if (this.f5257s) {
            this.f5257s = false;
            this.f5240b.removeCallbacks(this.f5243e);
        }
    }

    public void setSearchResultProvider(SearchResultProvider searchResultProvider) {
        if (this.f5246h != searchResultProvider) {
            this.f5246h = searchResultProvider;
            Handler handler = this.f5240b;
            RunnableC0285s runnableC0285s = this.f5242d;
            handler.removeCallbacks(runnableC0285s);
            handler.post(runnableC0285s);
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.f5251m = speechRecognitionCallback;
        SearchBar searchBar = this.f5245g;
        if (searchBar != null) {
            searchBar.setSpeechRecognitionCallback(speechRecognitionCallback);
        }
        if (speechRecognitionCallback != null && this.f5255q != null) {
            this.f5245g.setSpeechRecognizer(null);
            this.f5255q.destroy();
            this.f5255q = null;
        }
    }

    public void setTitle(String str) {
        this.f5252n = str;
        SearchBar searchBar = this.f5245g;
        if (searchBar != null) {
            searchBar.setTitle(str);
        }
    }

    public void startRecognition() {
        if (this.f5258t) {
            this.f5259u = true;
        } else {
            this.f5245g.startRecognition();
        }
    }

    public static Bundle createArgs(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(f5237x, str);
        bundle.putString(f5238y, str2);
        return bundle;
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.f5245g.displayCompletions(completionInfoArr);
    }

    public void setSearchQuery(Intent intent, boolean z) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            return;
        }
        setSearchQuery(stringArrayListExtra.get(0), z);
    }
}
