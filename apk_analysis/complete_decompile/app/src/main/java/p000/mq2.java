package p000;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class mq2 extends ResourceCursorAdapter implements View.OnClickListener {

    /* renamed from: q */
    public static final /* synthetic */ int f23061q = 0;

    /* renamed from: d */
    public final SearchView f23062d;

    /* renamed from: e */
    public final SearchableInfo f23063e;

    /* renamed from: f */
    public final Context f23064f;

    /* renamed from: g */
    public final WeakHashMap f23065g;

    /* renamed from: h */
    public final int f23066h;

    /* renamed from: i */
    public int f23067i;

    /* renamed from: j */
    public ColorStateList f23068j;

    /* renamed from: k */
    public int f23069k;

    /* renamed from: l */
    public int f23070l;

    /* renamed from: m */
    public int f23071m;

    /* renamed from: n */
    public int f23072n;

    /* renamed from: o */
    public int f23073o;

    /* renamed from: p */
    public int f23074p;

    public mq2(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f23067i = 1;
        this.f23069k = -1;
        this.f23070l = -1;
        this.f23071m = -1;
        this.f23072n = -1;
        this.f23073o = -1;
        this.f23074p = -1;
        this.f23062d = searchView;
        this.f23063e = searchableInfo;
        this.f23066h = searchView.getSuggestionCommitIconResId();
        this.f23064f = context;
        this.f23065g = weakHashMap;
    }

    /* renamed from: e */
    public static String m6238e(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* renamed from: b */
    public final Drawable m6239b(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f23064f.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindView(View view, Context context, Cursor cursor) {
        int i;
        int i2;
        int i3;
        ImageView imageView;
        Drawable m6240c;
        Drawable m6240c2;
        Drawable.ConstantState constantState;
        ActivityInfo activityInfo;
        int iconResource;
        String str;
        lq2 lq2Var = (lq2) view.getTag();
        int i4 = this.f23074p;
        if (i4 != -1) {
            i = cursor.getInt(i4);
        } else {
            i = 0;
        }
        TextView textView = lq2Var.f22640a;
        if (textView != null) {
            String m6238e = m6238e(cursor, this.f23069k);
            textView.setText(m6238e);
            if (TextUtils.isEmpty(m6238e)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        Context context2 = this.f23064f;
        TextView textView2 = lq2Var.f22641b;
        if (textView2 != null) {
            String m6238e2 = m6238e(cursor, this.f23071m);
            if (m6238e2 != null) {
                if (this.f23068j == null) {
                    TypedValue typedValue = new TypedValue();
                    context2.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
                    this.f23068j = context2.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(m6238e2);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f23068j, null), 0, m6238e2.length(), 33);
                str = spannableString;
            } else {
                str = m6238e(cursor, this.f23070l);
            }
            if (TextUtils.isEmpty(str)) {
                if (textView != null) {
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                }
            } else if (textView != null) {
                textView.setSingleLine(true);
                textView.setMaxLines(1);
            }
            textView2.setText(str);
            if (TextUtils.isEmpty(str)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
        }
        ImageView imageView2 = lq2Var.f22642c;
        if (imageView2 != null) {
            int i5 = this.f23072n;
            if (i5 == -1) {
                m6240c2 = null;
            } else {
                m6240c2 = m6240c(cursor.getString(i5));
                if (m6240c2 == null) {
                    ComponentName searchActivity = this.f23063e.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    WeakHashMap weakHashMap = this.f23065g;
                    if (weakHashMap.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState2 = (Drawable.ConstantState) weakHashMap.get(flattenToShortString);
                        if (constantState2 == null) {
                            m6240c2 = null;
                        } else {
                            m6240c2 = constantState2.newDrawable(context2.getResources());
                        }
                    } else {
                        PackageManager packageManager = context2.getPackageManager();
                        try {
                            activityInfo = packageManager.getActivityInfo(searchActivity, 128);
                            iconResource = activityInfo.getIconResource();
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.w("SuggestionsAdapter", e.toString());
                        }
                        if (iconResource != 0) {
                            Drawable drawable = packageManager.getDrawable(searchActivity.getPackageName(), iconResource, activityInfo.applicationInfo);
                            if (drawable == null) {
                                StringBuilder m8299s = ye0.m8299s(iconResource, "Invalid icon resource ", " for ");
                                m8299s.append(searchActivity.flattenToShortString());
                                Log.w("SuggestionsAdapter", m8299s.toString());
                            } else {
                                m6240c2 = drawable;
                                if (m6240c2 != null) {
                                    constantState = null;
                                } else {
                                    constantState = m6240c2.getConstantState();
                                }
                                weakHashMap.put(flattenToShortString, constantState);
                            }
                        }
                        m6240c2 = null;
                        if (m6240c2 != null) {
                        }
                        weakHashMap.put(flattenToShortString, constantState);
                    }
                    if (m6240c2 == null) {
                        m6240c2 = context2.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView2.setImageDrawable(m6240c2);
            if (m6240c2 == null) {
                imageView2.setVisibility(4);
            } else {
                imageView2.setVisibility(0);
                m6240c2.setVisible(false, false);
                m6240c2.setVisible(true, false);
            }
        }
        ImageView imageView3 = lq2Var.f22643d;
        if (imageView3 != null) {
            int i6 = this.f23073o;
            if (i6 == -1) {
                m6240c = null;
            } else {
                m6240c = m6240c(cursor.getString(i6));
            }
            imageView3.setImageDrawable(m6240c);
            if (m6240c == null) {
                imageView3.setVisibility(8);
            } else {
                imageView3.setVisibility(0);
                m6240c.setVisible(false, false);
                i2 = 1;
                m6240c.setVisible(true, false);
                i3 = this.f23067i;
                imageView = lq2Var.f22644e;
                if (i3 == 2 && (i3 != i2 || (i & 1) == 0)) {
                    imageView.setVisibility(8);
                    return;
                }
                imageView.setVisibility(0);
                imageView.setTag(textView.getText());
                imageView.setOnClickListener(this);
            }
        }
        i2 = 1;
        i3 = this.f23067i;
        imageView = lq2Var.f22644e;
        if (i3 == 2) {
        }
        imageView.setVisibility(0);
        imageView.setTag(textView.getText());
        imageView.setOnClickListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable m6240c(String str) {
        Drawable newDrawable;
        Drawable newDrawable2;
        WeakHashMap weakHashMap = this.f23065g;
        Context context = this.f23064f;
        Drawable drawable = null;
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + context.getPackageName() + "/" + parseInt;
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakHashMap.get(str2);
                if (constantState == null) {
                    newDrawable2 = null;
                } else {
                    newDrawable2 = constantState.newDrawable();
                }
                if (newDrawable2 != null) {
                    return newDrawable2;
                }
                Drawable drawable2 = ContextCompat.getDrawable(context, parseInt);
                if (drawable2 != null) {
                    weakHashMap.put(str2, drawable2.getConstantState());
                }
                return drawable2;
            } catch (Resources.NotFoundException unused) {
                Log.w("SuggestionsAdapter", "Icon resource not found: ".concat(str));
                return null;
            } catch (NumberFormatException unused2) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) weakHashMap.get(str);
                if (constantState2 == null) {
                    newDrawable = null;
                } else {
                    newDrawable = constantState2.newDrawable();
                }
                if (newDrawable != null) {
                    return newDrawable;
                }
                Uri parse = Uri.parse(str);
                try {
                } catch (FileNotFoundException e) {
                    Log.w("SuggestionsAdapter", "Icon not found: " + parse + ", " + e.getMessage());
                    if (drawable != null) {
                        weakHashMap.put(str, drawable.getConstantState());
                    }
                    return drawable;
                }
                if ("android.resource".equals(parse.getScheme())) {
                    try {
                        drawable = m6239b(parse);
                        if (drawable != null) {
                        }
                    } catch (Resources.NotFoundException unused3) {
                        throw new FileNotFoundException("Resource does not exist: " + parse);
                    }
                } else {
                    InputStream openInputStream = context.getContentResolver().openInputStream(parse);
                    if (openInputStream != null) {
                        try {
                            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                            try {
                                openInputStream.close();
                            } catch (IOException e2) {
                                Log.e("SuggestionsAdapter", "Error closing icon stream for " + parse, e2);
                            }
                            drawable = createFromStream;
                            if (drawable != null) {
                            }
                        } finally {
                        }
                    } else {
                        throw new FileNotFoundException("Failed to open " + parse);
                    }
                }
            }
        }
        return drawable;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, p000.InterfaceC2035yw
    public final void changeCursor(Cursor cursor) {
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f23069k = cursor.getColumnIndex("suggest_text_1");
                this.f23070l = cursor.getColumnIndex("suggest_text_2");
                this.f23071m = cursor.getColumnIndex("suggest_text_2_url");
                this.f23072n = cursor.getColumnIndex("suggest_icon_1");
                this.f23073o = cursor.getColumnIndex("suggest_icon_2");
                this.f23074p = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, p000.InterfaceC2035yw
    public final CharSequence convertToString(Cursor cursor) {
        String m6238e;
        String m6238e2;
        if (cursor == null) {
            return null;
        }
        String m6238e3 = m6238e(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (m6238e3 != null) {
            return m6238e3;
        }
        SearchableInfo searchableInfo = this.f23063e;
        if (searchableInfo.shouldRewriteQueryFromData() && (m6238e2 = m6238e(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return m6238e2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (m6238e = m6238e(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return m6238e;
    }

    /* renamed from: d */
    public final Cursor m6241d(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f23064f.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newDropDownView = newDropDownView(this.f23064f, getCursor(), viewGroup);
            if (newDropDownView != null) {
                ((lq2) newDropDownView.getTag()).f22640a.setText(e.toString());
            }
            return newDropDownView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.f23064f, getCursor(), viewGroup);
            ((lq2) newView.getTag()).f22640a.setText(e.toString());
            return newView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new lq2(newView));
        ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.f23066h);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = getCursor();
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = getCursor();
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f23062d.onQueryRefine((CharSequence) tag);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, p000.InterfaceC2035yw
    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        SearchView searchView = this.f23062d;
        if (searchView.getVisibility() == 0 && searchView.getWindowVisibility() == 0) {
            try {
                Cursor m6241d = m6241d(this.f23063e, charSequence2);
                if (m6241d != null) {
                    m6241d.getCount();
                    return m6241d;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }
}
