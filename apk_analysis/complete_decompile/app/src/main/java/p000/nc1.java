package p000;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class nc1 implements mc1 {

    /* renamed from: a */
    public final LocaleList f23324a;

    public nc1(Object obj) {
        this.f23324a = fx0.m4856i(obj);
    }

    @Override // p000.mc1
    /* renamed from: a */
    public final int mo5916a(Locale locale) {
        int indexOf;
        indexOf = this.f23324a.indexOf(locale);
        return indexOf;
    }

    @Override // p000.mc1
    /* renamed from: b */
    public final String mo5917b() {
        String languageTags;
        languageTags = this.f23324a.toLanguageTags();
        return languageTags;
    }

    @Override // p000.mc1
    /* renamed from: c */
    public final Object mo5918c() {
        return this.f23324a;
    }

    @Override // p000.mc1
    /* renamed from: d */
    public final Locale mo5919d(String[] strArr) {
        Locale firstMatch;
        firstMatch = this.f23324a.getFirstMatch(strArr);
        return firstMatch;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        equals = this.f23324a.equals(((mc1) obj).mo5918c());
        return equals;
    }

    @Override // p000.mc1
    public final Locale get(int i) {
        Locale locale;
        locale = this.f23324a.get(i);
        return locale;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f23324a.hashCode();
        return hashCode;
    }

    @Override // p000.mc1
    public final boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.f23324a.isEmpty();
        return isEmpty;
    }

    @Override // p000.mc1
    public final int size() {
        int size;
        size = this.f23324a.size();
        return size;
    }

    public final String toString() {
        String localeList;
        localeList = this.f23324a.toString();
        return localeList;
    }
}
