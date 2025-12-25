package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._HostnamesJvmKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.ro2;
import p000.ye0;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 72\u00020\u0001:\u000287J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010 \u001a\u00020\rH\u0007¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010\"\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b#\u0010\u0015J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0004H\u0000¢\u0006\u0004\b&\u0010'J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0011\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b-\u0010,\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u001a\u001a\u00020\u00178\u0007¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010 \u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b \u0010\u000fR\u0017\u0010$\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b$\u0010\u0015R\u0017\u0010\"\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b4\u00103\u001a\u0004\b\"\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b5\u00103\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b6\u00103\u001a\u0004\b\u001c\u0010\u0015¨\u00069"}, m5569d2 = {"Lokhttp3/Cookie;", "", "Lokhttp3/HttpUrl;", ImagesContract.URL, "", "matches", "(Lokhttp3/HttpUrl;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "-deprecated_name", AppMeasurementSdk.ConditionalUserProperty.NAME, "-deprecated_value", "value", "-deprecated_persistent", "()Z", "persistent", "", "-deprecated_expiresAt", "()J", "expiresAt", "-deprecated_hostOnly", "hostOnly", "-deprecated_domain", "domain", "-deprecated_path", "path", "-deprecated_httpOnly", "httpOnly", "-deprecated_secure", "secure", "forObsoleteRfc2965", "toString$okhttp", "(Z)Ljava/lang/String;", "Lokhttp3/Cookie$Builder;", "newBuilder", "()Lokhttp3/Cookie$Builder;", "a", "Ljava/lang/String;", "b", "c", "J", "d", "e", "f", "Z", "g", "h", "i", "Companion", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Cookie {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j */
    public static final Pattern f23916j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    public static final Pattern f23917k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    public static final Pattern f23918l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    public static final Pattern f23919m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: from kotlin metadata */
    public final String value;

    /* renamed from: c, reason: from kotlin metadata */
    public final long expiresAt;

    /* renamed from: d, reason: from kotlin metadata */
    public final String domain;

    /* renamed from: e, reason: from kotlin metadata */
    public final String path;

    /* renamed from: f, reason: from kotlin metadata */
    public final boolean secure;

    /* renamed from: g, reason: from kotlin metadata */
    public final boolean httpOnly;

    /* renamed from: h, reason: from kotlin metadata */
    public final boolean persistent;

    /* renamed from: i, reason: from kotlin metadata */
    public final boolean hostOnly;

    @Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, m5569d2 = {"Lokhttp3/Cookie$Companion;", "", "Lokhttp3/HttpUrl;", ImagesContract.URL, "", "setCookie", "Lokhttp3/Cookie;", "parse", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "", "currentTimeMillis", "parse$okhttp", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "Lokhttp3/Headers;", "headers", "", "parseAll", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;)Ljava/util/List;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static int m6582a(String str, int i, int i2, boolean z) {
            boolean z2;
            while (i < i2) {
                char charAt = str.charAt(i);
                if ((charAt >= ' ' || charAt == '\t') && charAt < 127 && ((charAt > '9' || '0' > charAt) && ((charAt > 'z' || 'a' > charAt) && ((charAt > 'Z' || 'A' > charAt) && charAt != ':')))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        public static final /* synthetic */ boolean access$domainMatch(Companion companion, String str, String str2) {
            companion.getClass();
            return m6583b(str, str2);
        }

        public static final boolean access$pathMatch(Companion companion, HttpUrl httpUrl, String str) {
            companion.getClass();
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.areEqual(encodedPath, str)) {
                return true;
            }
            if (ro2.startsWith$default(encodedPath, str, false, 2, null) && (ro2.endsWith$default(str, "/", false, 2, null) || encodedPath.charAt(str.length()) == '/')) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public static boolean m6583b(String str, String str2) {
            if (Intrinsics.areEqual(str, str2)) {
                return true;
            }
            if (ro2.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(str)) {
                return true;
            }
            return false;
        }

        /* renamed from: c */
        public static long m6584c(int i, String str) {
            int m6582a = m6582a(str, 0, i, false);
            Matcher matcher = Cookie.f23919m.matcher(str);
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            while (m6582a < i) {
                int m6582a2 = m6582a(str, m6582a + 1, i, true);
                matcher.region(m6582a, m6582a2);
                if (i3 == -1 && matcher.usePattern(Cookie.f23919m).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    i3 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    i6 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    i7 = Integer.parseInt(group3);
                } else if (i4 == -1 && matcher.usePattern(Cookie.f23918l).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    i4 = Integer.parseInt(group4);
                } else if (i5 == -1 && matcher.usePattern(Cookie.f23917k).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowercase = _UtilJvmKt.lowercase(group5, US);
                    String pattern = Cookie.f23917k.pattern();
                    Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                    i5 = StringsKt__StringsKt.indexOf$default((CharSequence) pattern, lowercase, 0, false, 6, (Object) null) / 4;
                } else if (i2 == -1 && matcher.usePattern(Cookie.f23916j).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    i2 = Integer.parseInt(group6);
                }
                m6582a = m6582a(str, m6582a2 + 1, i, false);
            }
            if (70 <= i2 && i2 < 100) {
                i2 += 1900;
            }
            if (i2 >= 0 && i2 < 70) {
                i2 += 2000;
            }
            if (i2 >= 1601) {
                if (i5 != -1) {
                    if (1 <= i4 && i4 < 32) {
                        if (i3 >= 0 && i3 < 24) {
                            if (i6 >= 0 && i6 < 60) {
                                if (i7 >= 0 && i7 < 60) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i2);
                                    gregorianCalendar.set(2, i5 - 1);
                                    gregorianCalendar.set(5, i4);
                                    gregorianCalendar.set(11, i3);
                                    gregorianCalendar.set(12, i6);
                                    gregorianCalendar.set(13, i7);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.");
                            }
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        @Nullable
        public final Cookie parse$okhttp(long currentTimeMillis, @NotNull HttpUrl url, @NotNull String setCookie) {
            String str;
            String str2;
            String str3;
            boolean z;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            int delimiterOffset$default = _UtilCommonKt.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(setCookie, '=', 0, delimiterOffset$default, 2, (Object) null);
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            boolean z2 = true;
            String trimSubstring$default = _UtilCommonKt.trimSubstring$default(setCookie, 0, delimiterOffset$default2, 1, null);
            if (trimSubstring$default.length() == 0 || _UtilCommonKt.indexOfControlOrNonAscii(trimSubstring$default) != -1) {
                return null;
            }
            String trimSubstring = _UtilCommonKt.trimSubstring(setCookie, delimiterOffset$default2 + 1, delimiterOffset$default);
            if (_UtilCommonKt.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            int i = delimiterOffset$default + 1;
            int length = setCookie.length();
            String str4 = null;
            String str5 = null;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = true;
            long j = -1;
            long j2 = DatesKt.MAX_DATE;
            while (true) {
                long j3 = Long.MAX_VALUE;
                long j4 = Long.MIN_VALUE;
                if (i < length) {
                    int delimiterOffset = _UtilCommonKt.delimiterOffset(setCookie, ';', i, length);
                    int delimiterOffset2 = _UtilCommonKt.delimiterOffset(setCookie, '=', i, delimiterOffset);
                    String trimSubstring2 = _UtilCommonKt.trimSubstring(setCookie, i, delimiterOffset2);
                    if (delimiterOffset2 < delimiterOffset) {
                        str3 = _UtilCommonKt.trimSubstring(setCookie, delimiterOffset2 + 1, delimiterOffset);
                    } else {
                        str3 = "";
                    }
                    if (ro2.equals(trimSubstring2, "expires", z2)) {
                        try {
                            j2 = m6584c(str3.length(), str3);
                            z = z2;
                            z5 = z;
                        } catch (IllegalArgumentException unused) {
                            z = z2;
                        }
                    } else if (ro2.equals(trimSubstring2, "max-age", z2)) {
                        try {
                            long parseLong = Long.parseLong(str3);
                            if (parseLong > 0) {
                                j4 = parseLong;
                            }
                            j = j4;
                        } catch (NumberFormatException e) {
                            try {
                                if (new Regex("-?\\d+").matches(str3)) {
                                    if (ro2.startsWith$default(str3, "-", false, 2, null)) {
                                        j3 = Long.MIN_VALUE;
                                    }
                                    j = j3;
                                } else {
                                    throw e;
                                    break;
                                }
                            } catch (NumberFormatException | IllegalArgumentException unused2) {
                            }
                        }
                        z = true;
                        z5 = true;
                    } else if (ro2.equals(trimSubstring2, "domain", true)) {
                        if (!ro2.endsWith$default(str3, ".", false, 2, null)) {
                            String canonicalHost = _HostnamesJvmKt.toCanonicalHost(StringsKt__StringsKt.removePrefix(str3, (CharSequence) "."));
                            if (canonicalHost != null) {
                                str4 = canonicalHost;
                                z6 = false;
                                z = true;
                            } else {
                                throw new IllegalArgumentException();
                            }
                        } else {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    } else {
                        z = true;
                        if (ro2.equals(trimSubstring2, "path", true)) {
                            str5 = str3;
                        } else if (ro2.equals(trimSubstring2, "secure", true)) {
                            z3 = true;
                        } else if (ro2.equals(trimSubstring2, "httponly", true)) {
                            z4 = true;
                        }
                    }
                    i = delimiterOffset + 1;
                    z2 = z;
                } else {
                    if (j != Long.MIN_VALUE) {
                        if (j != -1) {
                            if (j <= 9223372036854775L) {
                                j3 = j * 1000;
                            }
                            long j5 = currentTimeMillis + j3;
                            if (j5 >= currentTimeMillis && j5 <= DatesKt.MAX_DATE) {
                                j4 = j5;
                            } else {
                                j4 = 253402300799999L;
                            }
                        } else {
                            j4 = j2;
                        }
                    }
                    String host = url.host();
                    String str6 = str4;
                    if (str6 == null) {
                        str = host;
                    } else {
                        if (!m6583b(host, str6)) {
                            return null;
                        }
                        str = str6;
                    }
                    if (host.length() != str.length() && PublicSuffixDatabase.INSTANCE.get().getEffectiveTldPlusOne(str) == null) {
                        return null;
                    }
                    String str7 = "/";
                    String str8 = str5;
                    if (str8 != null && ro2.startsWith$default(str8, "/", false, 2, null)) {
                        str2 = str8;
                    } else {
                        String encodedPath = url.encodedPath();
                        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) encodedPath, '/', 0, false, 6, (Object) null);
                        if (lastIndexOf$default != 0) {
                            str7 = encodedPath.substring(0, lastIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(str7, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                        str2 = str7;
                    }
                    return new Cookie(trimSubstring$default, trimSubstring, j4, str, str2, z3, z4, z5, z6, null);
                }
            }
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            int size = values.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(url, values.get(i));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
                Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
                return unmodifiableList;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String str) {
        return INSTANCE.parse(httpUrl, str);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
        return INSTANCE.parseAll(httpUrl, headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    @JvmName(name = "-deprecated_domain")
    @NotNull
    /* renamed from: -deprecated_domain, reason: not valid java name and from getter */
    public final String getDomain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    @JvmName(name = "-deprecated_expiresAt")
    /* renamed from: -deprecated_expiresAt, reason: not valid java name and from getter */
    public final long getExpiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    @JvmName(name = "-deprecated_hostOnly")
    /* renamed from: -deprecated_hostOnly, reason: not valid java name and from getter */
    public final boolean getHostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    @JvmName(name = "-deprecated_httpOnly")
    /* renamed from: -deprecated_httpOnly, reason: not valid java name and from getter */
    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = AppMeasurementSdk.ConditionalUserProperty.NAME, imports = {}))
    @JvmName(name = "-deprecated_name")
    @NotNull
    /* renamed from: -deprecated_name, reason: not valid java name and from getter */
    public final String getName() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    @JvmName(name = "-deprecated_path")
    @NotNull
    /* renamed from: -deprecated_path, reason: not valid java name and from getter */
    public final String getPath() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    @JvmName(name = "-deprecated_persistent")
    /* renamed from: -deprecated_persistent, reason: not valid java name and from getter */
    public final boolean getPersistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    @JvmName(name = "-deprecated_secure")
    /* renamed from: -deprecated_secure, reason: not valid java name and from getter */
    public final boolean getSecure() {
        return this.secure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    @JvmName(name = "-deprecated_value")
    @NotNull
    /* renamed from: -deprecated_value, reason: not valid java name and from getter */
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "domain")
    @NotNull
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Cookie) {
            Cookie cookie = (Cookie) other;
            if (Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int m8286f = ye0.m8286f(ye0.m8286f(527, 31, this.name), 31, this.value);
        long j = this.expiresAt;
        int m8286f2 = ye0.m8286f(ye0.m8286f((m8286f + ((int) (j ^ (j >>> 32)))) * 31, 31, this.domain), 31, this.path);
        int i4 = 1237;
        if (this.secure) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i5 = (m8286f2 + i) * 31;
        if (this.httpOnly) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int i6 = (i5 + i2) * 31;
        if (this.persistent) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        int i7 = (i6 + i3) * 31;
        if (this.hostOnly) {
            i4 = 1231;
        }
        return i7 + i4;
    }

    @JvmName(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @JvmName(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@NotNull HttpUrl url) {
        boolean access$domainMatch;
        Intrinsics.checkNotNullParameter(url, "url");
        boolean z = this.hostOnly;
        String str = this.domain;
        if (z) {
            access$domainMatch = Intrinsics.areEqual(url.host(), str);
        } else {
            access$domainMatch = Companion.access$domainMatch(INSTANCE, url.host(), str);
        }
        if (!access$domainMatch || !Companion.access$pathMatch(INSTANCE, url, this.path)) {
            return false;
        }
        if (this.secure && !url.getIsHttps()) {
            return false;
        }
        return true;
    }

    @JvmName(name = AppMeasurementSdk.ConditionalUserProperty.NAME)
    @NotNull
    public final String name() {
        return this.name;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @JvmName(name = "path")
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name = "secure")
    public final boolean secure() {
        return this.secure;
    }

    @NotNull
    public String toString() {
        return toString$okhttp(false);
    }

    @NotNull
    public final String toString$okhttp(boolean forObsoleteRfc2965) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            long j = this.expiresAt;
            if (j == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(j)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (forObsoleteRfc2965) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString()");
        return sb2;
    }

    @JvmName(name = "value")
    @NotNull
    public final String value() {
        return this.value;
    }

    @Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\tJ\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m5569d2 = {"Lokhttp3/Cookie$Builder;", "", "<init>", "()V", "Lokhttp3/Cookie;", "cookie", "(Lokhttp3/Cookie;)V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "(Ljava/lang/String;)Lokhttp3/Cookie$Builder;", "value", "", "expiresAt", "(J)Lokhttp3/Cookie$Builder;", "domain", "hostOnlyDomain", "path", "secure", "()Lokhttp3/Cookie$Builder;", "httpOnly", "build", "()Lokhttp3/Cookie;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public String f23929a;

        /* renamed from: b */
        public String f23930b;

        /* renamed from: c */
        public long f23931c;

        /* renamed from: d */
        public String f23932d;

        /* renamed from: e */
        public String f23933e;

        /* renamed from: f */
        public boolean f23934f;

        /* renamed from: g */
        public boolean f23935g;

        /* renamed from: h */
        public boolean f23936h;

        /* renamed from: i */
        public boolean f23937i;

        public Builder() {
            this.f23931c = DatesKt.MAX_DATE;
            this.f23933e = "/";
        }

        @NotNull
        public final Cookie build() {
            String str = this.f23929a;
            if (str != null) {
                String str2 = this.f23930b;
                if (str2 != null) {
                    long j = this.f23931c;
                    String str3 = this.f23932d;
                    if (str3 != null) {
                        return new Cookie(str, str2, j, str3, this.f23933e, this.f23934f, this.f23935g, this.f23936h, this.f23937i, null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        @NotNull
        public final Builder domain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            String canonicalHost = _HostnamesJvmKt.toCanonicalHost(domain);
            if (canonicalHost != null) {
                this.f23932d = canonicalHost;
                this.f23937i = false;
                return this;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected domain: ", domain));
        }

        @NotNull
        public final Builder expiresAt(long expiresAt) {
            if (expiresAt <= 0) {
                expiresAt = Long.MIN_VALUE;
            }
            if (expiresAt > DatesKt.MAX_DATE) {
                expiresAt = 253402300799999L;
            }
            this.f23931c = expiresAt;
            this.f23936h = true;
            return this;
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            String canonicalHost = _HostnamesJvmKt.toCanonicalHost(domain);
            if (canonicalHost != null) {
                this.f23932d = canonicalHost;
                this.f23937i = true;
                return this;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected domain: ", domain));
        }

        @NotNull
        public final Builder httpOnly() {
            this.f23935g = true;
            return this;
        }

        @NotNull
        public final Builder name(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (Intrinsics.areEqual(StringsKt__StringsKt.trim(name).toString(), name)) {
                this.f23929a = name;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed");
        }

        @NotNull
        public final Builder path(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            if (ro2.startsWith$default(path, "/", false, 2, null)) {
                this.f23933e = path;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        @NotNull
        public final Builder secure() {
            this.f23934f = true;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(StringsKt__StringsKt.trim(value).toString(), value)) {
                this.f23930b = value;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull Cookie cookie) {
            this();
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.f23929a = cookie.name();
            this.f23930b = cookie.value();
            this.f23931c = cookie.expiresAt();
            this.f23932d = cookie.domain();
            this.f23933e = cookie.path();
            this.f23934f = cookie.secure();
            this.f23935g = cookie.httpOnly();
            this.f23936h = cookie.persistent();
            this.f23937i = cookie.hostOnly();
        }
    }
}
