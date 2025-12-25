package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.util.Locale;
import p000.fx0;
import p000.ic1;
import p000.jc1;
import p000.lc1;
import p000.mc1;
import p000.nc1;
import p000.ye0;

/* loaded from: classes.dex */
public final class LocaleListCompat {

    /* renamed from: b */
    public static final LocaleListCompat f3710b = create(new Locale[0]);

    /* renamed from: a */
    public final mc1 f3711a;

    public LocaleListCompat(mc1 mc1Var) {
        this.f3711a = mc1Var;
    }

    /* renamed from: a */
    public static Locale m876a(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        throw new IllegalArgumentException(ye0.m8296p("Can not parse language tag: [", str, "]"));
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(jc1.m5431a(localeArr));
        }
        return new LocaleListCompat(new lc1(localeArr));
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i = 0; i < length; i++) {
                localeArr[i] = ic1.m5208a(split[i]);
            }
            return create(localeArr);
        }
        return getEmptyLocaleList();
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(jc1.m5432b());
        }
        return create(Locale.getDefault());
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(jc1.m5433c());
        }
        return create(Locale.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return f3710b;
    }

    @RequiresApi(21)
    public static boolean matchesLanguageAndScript(@NonNull Locale locale, @NonNull Locale locale2) {
        boolean matchesLanguageAndScript;
        if (Build.VERSION.SDK_INT >= 33) {
            matchesLanguageAndScript = LocaleList.matchesLanguageAndScript(locale, locale2);
            return matchesLanguageAndScript;
        }
        return ic1.m5209b(locale, locale2);
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        return wrap(fx0.m4856i(obj));
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocaleListCompat) {
            if (this.f3711a.equals(((LocaleListCompat) obj).f3711a)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Locale get(int i) {
        return this.f3711a.get(i);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return this.f3711a.mo5919d(strArr);
    }

    public int hashCode() {
        return this.f3711a.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale locale) {
        return this.f3711a.mo5916a(locale);
    }

    public boolean isEmpty() {
        return this.f3711a.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.f3711a.size();
    }

    @NonNull
    public String toLanguageTags() {
        return this.f3711a.mo5917b();
    }

    @NonNull
    public String toString() {
        return this.f3711a.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.f3711a.mo5918c();
    }

    @NonNull
    @RequiresApi(24)
    public static LocaleListCompat wrap(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new nc1(localeList));
    }
}
