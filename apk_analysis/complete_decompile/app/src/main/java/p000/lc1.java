package p000;

import androidx.core.os.LocaleListCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class lc1 implements mc1 {

    /* renamed from: c */
    public static final Locale[] f22460c = new Locale[0];

    /* renamed from: d */
    public static final Locale f22461d = new Locale("en", "XA");

    /* renamed from: e */
    public static final Locale f22462e = new Locale("ar", "XB");

    /* renamed from: a */
    public final Locale[] f22463a;

    /* renamed from: b */
    public final String f22464b;

    static {
        LocaleListCompat.m876a("en-Latn");
    }

    public lc1(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f22463a = f22460c;
            this.f22464b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    sb.append(locale2.getLanguage());
                    String country = locale2.getCountry();
                    if (country != null && !country.isEmpty()) {
                        sb.append('-');
                        sb.append(locale2.getCountry());
                    }
                    if (i < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException(ye0.m8292l(i, "list[", "] is null"));
            }
        }
        this.f22463a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f22464b = sb.toString();
    }

    @Override // p000.mc1
    /* renamed from: a */
    public final int mo5916a(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f22463a;
            if (i < localeArr.length) {
                if (localeArr[i].equals(locale)) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    @Override // p000.mc1
    /* renamed from: b */
    public final String mo5917b() {
        return this.f22464b;
    }

    @Override // p000.mc1
    /* renamed from: c */
    public final Object mo5918c() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
    
        if (r9.equals(r8.getCountry()) == false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4 A[LOOP:1: B:10:0x002d->B:16:0x00a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a8 A[EDGE_INSN: B:17:0x00a8->B:18:0x00a8 BREAK  A[LOOP:1: B:10:0x002d->B:16:0x00a4], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // p000.mc1
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Locale mo5919d(String[] strArr) {
        ?? r8;
        List asList = Arrays.asList(strArr);
        Locale[] localeArr = this.f22463a;
        int i = 0;
        if (localeArr.length != 1) {
            if (localeArr.length == 0) {
                i = -1;
            } else {
                Iterator it = asList.iterator();
                int i2 = Integer.MAX_VALUE;
                while (true) {
                    if (it.hasNext()) {
                        Locale m876a = LocaleListCompat.m876a((String) it.next());
                        int i3 = 0;
                        while (true) {
                            if (i3 < localeArr.length) {
                                Locale locale = localeArr[i3];
                                if (!m876a.equals(locale)) {
                                    if (m876a.getLanguage().equals(locale.getLanguage())) {
                                        Locale locale2 = f22461d;
                                        if (!locale2.equals(m876a)) {
                                            Locale locale3 = f22462e;
                                            if (!locale3.equals(m876a) && !locale2.equals(locale) && !locale3.equals(locale)) {
                                                String m5519a = kc1.m5519a(m876a);
                                                String str = "";
                                                if (m5519a.isEmpty()) {
                                                    m5519a = "";
                                                }
                                                if (m5519a.isEmpty()) {
                                                    String country = m876a.getCountry();
                                                    if (!country.isEmpty()) {
                                                    }
                                                } else {
                                                    String m5519a2 = kc1.m5519a(locale);
                                                    if (!m5519a2.isEmpty()) {
                                                        str = m5519a2;
                                                    }
                                                    r8 = m5519a.equals(str);
                                                    if (r8 > 0) {
                                                        break;
                                                    }
                                                    i3++;
                                                }
                                            }
                                        }
                                    }
                                    r8 = 0;
                                    if (r8 > 0) {
                                    }
                                }
                                r8 = 1;
                                if (r8 > 0) {
                                }
                            } else {
                                i3 = Integer.MAX_VALUE;
                                break;
                            }
                        }
                        if (i3 == 0) {
                            break;
                        }
                        if (i3 < i2) {
                            i2 = i3;
                        }
                    } else if (i2 != Integer.MAX_VALUE) {
                        i = i2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return localeArr[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lc1)) {
            return false;
        }
        Locale[] localeArr = ((lc1) obj).f22463a;
        Locale[] localeArr2 = this.f22463a;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i = 0; i < localeArr2.length; i++) {
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // p000.mc1
    public final Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f22463a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public final int hashCode() {
        int i = 1;
        for (Locale locale : this.f22463a) {
            i = (i * 31) + locale.hashCode();
        }
        return i;
    }

    @Override // p000.mc1
    public final boolean isEmpty() {
        if (this.f22463a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // p000.mc1
    public final int size() {
        return this.f22463a.length;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f22463a;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
