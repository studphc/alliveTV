package androidx.appcompat.widget;

import android.R;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p000.AbstractC1497l3;
import p000.C1827t9;
import p000.h92;
import p000.l91;
import p000.mq2;
import p000.pf2;
import p000.q72;
import p000.qf2;
import p000.rf2;
import p000.sf2;
import p000.so1;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: k0 */
    public static final so1 f1359k0;

    /* renamed from: A */
    public final Rect f1360A;

    /* renamed from: B */
    public final int[] f1361B;

    /* renamed from: C */
    public final int[] f1362C;

    /* renamed from: D */
    public final ImageView f1363D;

    /* renamed from: E */
    public final Drawable f1364E;

    /* renamed from: F */
    public final int f1365F;

    /* renamed from: G */
    public final int f1366G;

    /* renamed from: H */
    public final Intent f1367H;

    /* renamed from: I */
    public final Intent f1368I;

    /* renamed from: J */
    public final CharSequence f1369J;

    /* renamed from: K */
    public OnQueryTextListener f1370K;

    /* renamed from: L */
    public OnCloseListener f1371L;

    /* renamed from: M */
    public View.OnFocusChangeListener f1372M;

    /* renamed from: N */
    public OnSuggestionListener f1373N;

    /* renamed from: O */
    public View.OnClickListener f1374O;

    /* renamed from: P */
    public boolean f1375P;

    /* renamed from: Q */
    public boolean f1376Q;

    /* renamed from: R */
    public CursorAdapter f1377R;

    /* renamed from: S */
    public boolean f1378S;

    /* renamed from: T */
    public CharSequence f1379T;

    /* renamed from: U */
    public boolean f1380U;

    /* renamed from: V */
    public boolean f1381V;

    /* renamed from: W */
    public int f1382W;

    /* renamed from: a0 */
    public boolean f1383a0;

    /* renamed from: b0 */
    public String f1384b0;

    /* renamed from: c0 */
    public CharSequence f1385c0;

    /* renamed from: d0 */
    public boolean f1386d0;

    /* renamed from: e0 */
    public int f1387e0;

    /* renamed from: f0 */
    public SearchableInfo f1388f0;

    /* renamed from: g0 */
    public Bundle f1389g0;

    /* renamed from: h0 */
    public final qf2 f1390h0;

    /* renamed from: i0 */
    public final qf2 f1391i0;

    /* renamed from: j0 */
    public final WeakHashMap f1392j0;

    /* renamed from: p */
    public final SearchAutoComplete f1393p;

    /* renamed from: q */
    public final View f1394q;

    /* renamed from: r */
    public final View f1395r;

    /* renamed from: s */
    public final View f1396s;

    /* renamed from: t */
    public final ImageView f1397t;

    /* renamed from: u */
    public final ImageView f1398u;

    /* renamed from: v */
    public final ImageView f1399v;

    /* renamed from: w */
    public final ImageView f1400w;

    /* renamed from: x */
    public final View f1401x;

    /* renamed from: y */
    public sf2 f1402y;

    /* renamed from: z */
    public final Rect f1403z;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1404a = false;

        /* renamed from: b */
        public int f1405b;

        /* renamed from: c */
        public int f1406c;

        /* renamed from: d */
        public int f1407d;

        /* renamed from: e */
        public int f1408e;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapInt;
            int mapInt2;
            int mapBoolean;
            int mapObject;
            mapInt = propertyMapper.mapInt("imeOptions", R.attr.imeOptions);
            this.f1405b = mapInt;
            mapInt2 = propertyMapper.mapInt("maxWidth", R.attr.maxWidth);
            this.f1406c = mapInt2;
            mapBoolean = propertyMapper.mapBoolean("iconifiedByDefault", androidx.appcompat.R.attr.iconifiedByDefault);
            this.f1407d = mapBoolean;
            mapObject = propertyMapper.mapObject("queryHint", androidx.appcompat.R.attr.queryHint);
            this.f1408e = mapObject;
            this.f1404a = true;
        }

        public void readProperties(@NonNull SearchView searchView, @NonNull PropertyReader propertyReader) {
            if (this.f1404a) {
                propertyReader.readInt(this.f1405b, searchView.getImeOptions());
                propertyReader.readInt(this.f1406c, searchView.getMaxWidth());
                propertyReader.readBoolean(this.f1407d, searchView.isIconfiedByDefault());
                propertyReader.readObject(this.f1408e, searchView.getQueryHint());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    /* loaded from: classes.dex */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* loaded from: classes.dex */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes.dex */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: b */
        public boolean f1409b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1409b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1409b + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1409b));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: e */
        public int f1410e;

        /* renamed from: f */
        public SearchView f1411f;

        /* renamed from: g */
        public boolean f1412g;

        /* renamed from: h */
        public final RunnableC0105n f1413h;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                if (i < 640 || i2 < 480) {
                    return 160;
                }
                return PsExtractor.AUDIO_STREAM;
            }
            return PsExtractor.AUDIO_STREAM;
        }

        /* renamed from: a */
        public final void m276a() {
            if (Build.VERSION.SDK_INT >= 29) {
                AbstractC0103l.m322b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            so1 so1Var = SearchView.f1359k0;
            so1Var.getClass();
            so1.m7394a();
            Method method = so1Var.f26508c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.f1410e > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1412g) {
                RunnableC0105n runnableC0105n = this.f1413h;
                removeCallbacks(runnableC0105n);
                post(runnableC0105n);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.f1411f;
            searchView.m274o(searchView.isIconified());
            searchView.post(searchView.f1390h0);
            if (searchView.f1393p.hasFocus()) {
                searchView.m264e();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1411f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1411f.hasFocus() && getVisibility() == 0) {
                this.f1412g = true;
                Context context = getContext();
                so1 so1Var = SearchView.f1359k0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    m276a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            RunnableC0105n runnableC0105n = this.f1413h;
            if (!z) {
                this.f1412g = false;
                removeCallbacks(runnableC0105n);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f1412g = false;
                    removeCallbacks(runnableC0105n);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f1412g = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1411f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1410e = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1413h = new RunnableC0105n(this);
            this.f1410e = getThreshold();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [so1, java.lang.Object] */
    static {
        so1 so1Var = null;
        if (Build.VERSION.SDK_INT < 29) {
            ?? obj = new Object();
            obj.f26506a = null;
            obj.f26507b = null;
            obj.f26508c = null;
            so1.m7394a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                obj.f26506a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                obj.f26507b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                obj.f26508c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            so1Var = obj;
        }
        f1359k0 = so1Var;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_width);
    }

    /* renamed from: c */
    public final Intent m262c(Uri uri, String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1385c0);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1389g0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f1388f0.getSearchActivity());
        return intent;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1381V = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f1393p;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f1381V = false;
    }

    /* renamed from: d */
    public final Intent m263d(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1389g0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        } else {
            i = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: e */
    public final void m264e() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f1393p;
        if (i >= 29) {
            AbstractC0103l.m321a(searchAutoComplete);
            return;
        }
        so1 so1Var = f1359k0;
        so1Var.getClass();
        so1.m7394a();
        Method method = so1Var.f26506a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        so1Var.getClass();
        so1.m7394a();
        Method method2 = so1Var.f26507b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: f */
    public final void m265f() {
        SearchAutoComplete searchAutoComplete = this.f1393p;
        if (TextUtils.isEmpty(searchAutoComplete.getText())) {
            if (this.f1375P) {
                OnCloseListener onCloseListener = this.f1371L;
                if (onCloseListener == null || !onCloseListener.onClose()) {
                    clearFocus();
                    m274o(true);
                    return;
                }
                return;
            }
            return;
        }
        searchAutoComplete.setText("");
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
    }

    /* renamed from: g */
    public final boolean m266g(int i) {
        int i2;
        Uri parse;
        String m6238e;
        OnSuggestionListener onSuggestionListener = this.f1373N;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i)) {
            return false;
        }
        Cursor cursor = this.f1377R.getCursor();
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intent = null;
            try {
                int i3 = mq2.f23061q;
                String m6238e2 = mq2.m6238e(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (m6238e2 == null) {
                    m6238e2 = this.f1388f0.getSuggestIntentAction();
                }
                if (m6238e2 == null) {
                    m6238e2 = "android.intent.action.SEARCH";
                }
                String m6238e3 = mq2.m6238e(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (m6238e3 == null) {
                    m6238e3 = this.f1388f0.getSuggestIntentData();
                }
                if (m6238e3 != null && (m6238e = mq2.m6238e(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    m6238e3 = m6238e3 + "/" + Uri.encode(m6238e);
                }
                if (m6238e3 == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(m6238e3);
                }
                intent = m262c(parse, m6238e2, mq2.m6238e(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), mq2.m6238e(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e) {
                try {
                    i2 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i2 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e2) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e2);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f1393p;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
        return true;
    }

    public int getImeOptions() {
        return this.f1393p.getImeOptions();
    }

    public int getInputType() {
        return this.f1393p.getInputType();
    }

    public int getMaxWidth() {
        return this.f1382W;
    }

    public CharSequence getQuery() {
        return this.f1393p.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1379T;
        if (charSequence == null) {
            SearchableInfo searchableInfo = this.f1388f0;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.f1388f0.getHintId());
            }
            return this.f1369J;
        }
        return charSequence;
    }

    public int getSuggestionCommitIconResId() {
        return this.f1366G;
    }

    public int getSuggestionRowLayout() {
        return this.f1365F;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f1377R;
    }

    /* renamed from: h */
    public final void m267h(int i) {
        OnSuggestionListener onSuggestionListener = this.f1373N;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i)) {
            return;
        }
        Editable text = this.f1393p.getText();
        Cursor cursor = this.f1377R.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.f1377R.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    /* renamed from: i */
    public final void m268i() {
        SearchAutoComplete searchAutoComplete = this.f1393p;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.f1370K;
            if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
                if (this.f1388f0 != null) {
                    getContext().startActivity(m262c(null, "android.intent.action.SEARCH", null, text.toString()));
                }
                searchAutoComplete.setImeVisibility(false);
                searchAutoComplete.dismissDropDown();
            }
        }
    }

    public boolean isIconfiedByDefault() {
        return this.f1375P;
    }

    public boolean isIconified() {
        return this.f1376Q;
    }

    public boolean isQueryRefinementEnabled() {
        return this.f1380U;
    }

    public boolean isSubmitButtonEnabled() {
        return this.f1378S;
    }

    /* renamed from: j */
    public final void m269j() {
        int i;
        int[] iArr;
        boolean isEmpty = TextUtils.isEmpty(this.f1393p.getText());
        if (isEmpty && (!this.f1375P || this.f1386d0)) {
            i = 8;
        } else {
            i = 0;
        }
        ImageView imageView = this.f1399v;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (!isEmpty) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    /* renamed from: k */
    public final void m270k() {
        int[] iArr;
        if (this.f1393p.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1395r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1396s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* renamed from: l */
    public final void m271l() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z = this.f1375P;
        SearchAutoComplete searchAutoComplete = this.f1393p;
        if (z && (drawable = this.f1364E) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    /* renamed from: m */
    public final void m272m() {
        int i;
        if ((this.f1378S || this.f1383a0) && !isIconified() && (this.f1398u.getVisibility() == 0 || this.f1400w.getVisibility() == 0)) {
            i = 0;
        } else {
            i = 8;
        }
        this.f1396s.setVisibility(i);
    }

    /* renamed from: n */
    public final void m273n(boolean z) {
        int i;
        boolean z2 = this.f1378S;
        if (z2 && ((z2 || this.f1383a0) && !isIconified() && hasFocus() && (z || !this.f1383a0))) {
            i = 0;
        } else {
            i = 8;
        }
        this.f1398u.setVisibility(i);
    }

    /* renamed from: o */
    public final void m274o(boolean z) {
        int i;
        int i2;
        this.f1376Q = z;
        int i3 = 8;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f1393p.getText());
        this.f1397t.setVisibility(i);
        m273n(!isEmpty);
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        this.f1394q.setVisibility(i2);
        ImageView imageView = this.f1363D;
        if (imageView.getDrawable() != null && !this.f1375P) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        m269j();
        m275p(isEmpty);
        m272m();
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        m274o(true);
        this.f1393p.setImeOptions(this.f1387e0);
        this.f1386d0 = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.f1386d0) {
            return;
        }
        this.f1386d0 = true;
        SearchAutoComplete searchAutoComplete = this.f1393p;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f1387e0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1390h0);
        post(this.f1391i0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int[] iArr = this.f1361B;
            SearchAutoComplete searchAutoComplete = this.f1393p;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f1362C;
            getLocationInWindow(iArr2);
            int i5 = iArr[1] - iArr2[1];
            int i6 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i6;
            int height = searchAutoComplete.getHeight() + i5;
            Rect rect = this.f1403z;
            rect.set(i6, i5, width, height);
            int i7 = rect.left;
            int i8 = rect.right;
            int i9 = i4 - i2;
            Rect rect2 = this.f1360A;
            rect2.set(i7, 0, i8, i9);
            sf2 sf2Var = this.f1402y;
            if (sf2Var == null) {
                sf2 sf2Var2 = new sf2(searchAutoComplete, rect2, rect);
                this.f1402y = sf2Var2;
                setTouchDelegate(sf2Var2);
            } else {
                sf2Var.f26409b.set(rect2);
                Rect rect3 = sf2Var.f26411d;
                rect3.set(rect2);
                int i10 = -sf2Var.f26412e;
                rect3.inset(i10, i10);
                sf2Var.f26410c.set(rect);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i3 = this.f1382W) > 0) {
                    size = Math.min(i3, size);
                }
            } else {
                size = this.f1382W;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i4 = this.f1382W;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onQueryRefine(@Nullable CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m274o(savedState.f1409b);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, androidx.appcompat.widget.SearchView$SavedState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f1409b = isIconified();
        return absSavedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.f1390h0);
    }

    /* renamed from: p */
    public final void m275p(boolean z) {
        int i = 8;
        if (this.f1383a0 && !isIconified() && z) {
            this.f1398u.setVisibility(8);
            i = 0;
        }
        this.f1400w.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f1381V || !isFocusable()) {
            return false;
        }
        if (!isIconified()) {
            boolean requestFocus = this.f1393p.requestFocus(i, rect);
            if (requestFocus) {
                m274o(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i, rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.f1389g0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m265f();
            return;
        }
        m274o(false);
        SearchAutoComplete searchAutoComplete = this.f1393p;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1374O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1375P == z) {
            return;
        }
        this.f1375P = z;
        m274o(z);
        m271l();
    }

    public void setImeOptions(int i) {
        this.f1393p.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1393p.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1382W = i;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f1371L = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1372M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.f1370K = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1374O = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.f1373N = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        SearchAutoComplete searchAutoComplete = this.f1393p;
        searchAutoComplete.setText(charSequence);
        if (charSequence != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1385c0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m268i();
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.f1379T = charSequence;
        m271l();
    }

    public void setQueryRefinementEnabled(boolean z) {
        int i;
        this.f1380U = z;
        CursorAdapter cursorAdapter = this.f1377R;
        if (cursorAdapter instanceof mq2) {
            mq2 mq2Var = (mq2) cursorAdapter;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            mq2Var.f23067i = i;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        int i;
        this.f1388f0 = searchableInfo;
        Intent intent = null;
        boolean z = true;
        SearchAutoComplete searchAutoComplete = this.f1393p;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.f1388f0.getImeOptions());
            int inputType = this.f1388f0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.f1388f0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            CursorAdapter cursorAdapter = this.f1377R;
            if (cursorAdapter != null) {
                cursorAdapter.changeCursor(null);
            }
            if (this.f1388f0.getSuggestAuthority() != null) {
                mq2 mq2Var = new mq2(getContext(), this, this.f1388f0, this.f1392j0);
                this.f1377R = mq2Var;
                searchAutoComplete.setAdapter(mq2Var);
                mq2 mq2Var2 = (mq2) this.f1377R;
                if (this.f1380U) {
                    i = 2;
                } else {
                    i = 1;
                }
                mq2Var2.f23067i = i;
            }
            m271l();
        }
        SearchableInfo searchableInfo2 = this.f1388f0;
        boolean z2 = false;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.f1388f0.getVoiceSearchLaunchWebSearch()) {
                intent = this.f1367H;
            } else if (this.f1388f0.getVoiceSearchLaunchRecognizer()) {
                intent = this.f1368I;
            }
            if (intent != null) {
                if (getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
                    z = false;
                }
                z2 = z;
            }
        }
        this.f1383a0 = z2;
        if (z2) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        m274o(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1378S = z;
        m274o(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f1377R = cursorAdapter;
        this.f1393p.setAdapter(cursorAdapter);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.searchViewStyle);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1403z = new Rect();
        this.f1360A = new Rect();
        this.f1361B = new int[2];
        this.f1362C = new int[2];
        this.f1390h0 = new qf2(this, 0);
        this.f1391i0 = new qf2(this, 1);
        this.f1392j0 = new WeakHashMap();
        ViewOnClickListenerC0101j viewOnClickListenerC0101j = new ViewOnClickListenerC0101j(this);
        ViewOnKeyListenerC0102k viewOnKeyListenerC0102k = new ViewOnKeyListenerC0102k(this);
        rf2 rf2Var = new rf2(this);
        C1827t9 c1827t9 = new C1827t9(2, this);
        l91 l91Var = new l91(1, this);
        pf2 pf2Var = new pf2(this);
        int[] iArr = androidx.appcompat.R.styleable.SearchView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SearchView_layout, androidx.appcompat.R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(androidx.appcompat.R.id.search_src_text);
        this.f1393p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1394q = findViewById(androidx.appcompat.R.id.search_edit_frame);
        View findViewById = findViewById(androidx.appcompat.R.id.search_plate);
        this.f1395r = findViewById;
        View findViewById2 = findViewById(androidx.appcompat.R.id.submit_area);
        this.f1396s = findViewById2;
        ImageView imageView = (ImageView) findViewById(androidx.appcompat.R.id.search_button);
        this.f1397t = imageView;
        ImageView imageView2 = (ImageView) findViewById(androidx.appcompat.R.id.search_go_btn);
        this.f1398u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(androidx.appcompat.R.id.search_close_btn);
        this.f1399v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(androidx.appcompat.R.id.search_voice_btn);
        this.f1400w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(androidx.appcompat.R.id.search_mag_icon);
        this.f1363D = imageView5;
        ViewCompat.setBackground(findViewById, obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(findViewById2, obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_submitBackground));
        int i2 = androidx.appcompat.R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(obtainStyledAttributes.getDrawable(i2));
        imageView2.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(obtainStyledAttributes.getDrawable(i2));
        this.f1364E = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(imageView, getResources().getString(androidx.appcompat.R.string.abc_searchview_description_search));
        this.f1365F = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SearchView_suggestionRowLayout, androidx.appcompat.R.layout.abc_search_dropdown_item_icons_2line);
        this.f1366G = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(viewOnClickListenerC0101j);
        imageView3.setOnClickListener(viewOnClickListenerC0101j);
        imageView2.setOnClickListener(viewOnClickListenerC0101j);
        imageView4.setOnClickListener(viewOnClickListenerC0101j);
        searchAutoComplete.setOnClickListener(viewOnClickListenerC0101j);
        searchAutoComplete.addTextChangedListener(pf2Var);
        searchAutoComplete.setOnEditorActionListener(rf2Var);
        searchAutoComplete.setOnItemClickListener(c1827t9);
        searchAutoComplete.setOnItemSelectedListener(l91Var);
        searchAutoComplete.setOnKeyListener(viewOnKeyListenerC0102k);
        searchAutoComplete.setOnFocusChangeListener(new q72(1, this));
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f1369J = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SearchView_defaultQueryHint);
        this.f1379T = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SearchView_queryHint);
        int i3 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SearchView_android_imeOptions, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SearchView_android_inputType, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1367H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1368I = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1401x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new h92(1, this));
        }
        m274o(this.f1375P);
        m271l();
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f1393p;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
