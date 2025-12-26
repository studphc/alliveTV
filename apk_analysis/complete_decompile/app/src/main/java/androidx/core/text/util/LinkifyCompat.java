package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.AbstractC1726qj;
import p000.C0556bg;
import p000.f91;
import p000.g91;
import p000.yd0;
import p000.zd0;

/* loaded from: classes.dex */
public final class LinkifyCompat {

    /* renamed from: a */
    public static final String[] f3802a = new String[0];

    /* renamed from: b */
    public static final C0556bg f3803b = new C0556bg(14);

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface LinkifyMask {
    }

    /* renamed from: a */
    public static void m888a(TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, g91] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, g91] */
    public static boolean addLinks(@NonNull Spannable spannable, int i) {
        int i2;
        int i3;
        int i4;
        int indexOf;
        if (m892e()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        Object[] objArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = objArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(objArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            m890c(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter);
        }
        if ((i & 2) != 0) {
            m890c(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null);
        }
        if ((i & 8) != 0) {
            String obj = spannable.toString();
            int i5 = 0;
            while (true) {
                try {
                    String m889b = m889b(obj);
                    if (m889b == null || (indexOf = obj.indexOf(m889b)) < 0) {
                        break;
                    }
                    ?? obj2 = new Object();
                    int length2 = m889b.length() + indexOf;
                    obj2.f17618c = indexOf + i5;
                    i5 += length2;
                    obj2.f17619d = i5;
                    obj = obj.substring(length2);
                    try {
                        obj2.f17617b = "geo:0,0?q=" + URLEncoder.encode(m889b, "UTF-8");
                        arrayList.add(obj2);
                    } catch (UnsupportedEncodingException unused) {
                    }
                } catch (UnsupportedOperationException unused2) {
                }
            }
        }
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            ?? obj3 = new Object();
            obj3.f17616a = uRLSpan;
            obj3.f17618c = spannable.getSpanStart(uRLSpan);
            obj3.f17619d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(obj3);
        }
        Collections.sort(arrayList, f3803b);
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size - 1) {
            g91 g91Var = (g91) arrayList.get(i6);
            int i7 = i6 + 1;
            g91 g91Var2 = (g91) arrayList.get(i7);
            int i8 = g91Var.f17618c;
            int i9 = g91Var2.f17618c;
            if (i8 <= i9 && (i2 = g91Var.f17619d) > i9) {
                int i10 = g91Var2.f17619d;
                int i11 = (i10 > i2 && (i3 = i2 - i8) <= (i4 = i10 - i9)) ? i3 < i4 ? i6 : -1 : i7;
                if (i11 != -1) {
                    Object obj4 = ((g91) arrayList.get(i11)).f17616a;
                    if (obj4 != null) {
                        spannable.removeSpan(obj4);
                    }
                    arrayList.remove(i11);
                    size--;
                }
            }
            i6 = i7;
        }
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g91 g91Var3 = (g91) it.next();
            if (g91Var3.f17616a == null) {
                spannable.setSpan(new URLSpan(g91Var3.f17617b), g91Var3.f17618c, g91Var3.f17619d, 33);
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x00bb, code lost:
    
        if (p000.zd0.m8411a(r3.group(0)) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x004d, code lost:
    
        r3 = -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x004e, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x004f, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011e  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m889b(String str) {
        int i;
        int length;
        MatchResult matchResult;
        MatchResult matchResult2;
        int i2;
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress(str);
        }
        Pattern pattern = zd0.f29318c;
        Matcher matcher = pattern.matcher(str);
        int i3 = 0;
        int i4 = 0;
        while (matcher.find(i4)) {
            if (zd0.m8411a(matcher.group(i3))) {
                int start = matcher.start();
                int end = matcher.end();
                Pattern pattern2 = zd0.f29317b;
                Matcher matcher2 = pattern2.matcher(str);
                String str2 = "";
                int i5 = i3;
                int i6 = -1;
                int i7 = -1;
                int i8 = 1;
                int i9 = 1;
                boolean z = true;
                while (true) {
                    if (end < str.length()) {
                        if (!matcher2.find(end)) {
                            length = str.length();
                            break;
                        }
                        if (matcher2.end() - matcher2.start() > 25) {
                            length = matcher2.end();
                            break;
                        }
                        while (end < matcher2.start()) {
                            int i10 = end + 1;
                            if ("\n\u000b\f\r\u0085\u2028\u2029".indexOf(str.charAt(end)) != -1) {
                                i8++;
                            }
                            end = i10;
                        }
                        if (i8 > 5 || (i9 = i9 + 1) > 14) {
                            break;
                        }
                        if (end <= 0 || ":,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029".indexOf(str.charAt(end - 1)) != -1) {
                            Matcher region = pattern.matcher(str).region(end, str.length());
                            if (region.lookingAt()) {
                                matchResult = region.toMatchResult();
                            }
                        }
                        matchResult = null;
                        if (matchResult != null) {
                            if (z && i8 > 1) {
                                int i11 = -end;
                                break;
                            }
                            if (i6 == -1) {
                                i6 = end;
                            }
                            i2 = 0;
                        } else {
                            if (zd0.f29320e.matcher(matcher2.group(0)).matches()) {
                                i5 = 1;
                            } else {
                                if (i9 == 5 && i5 == 0) {
                                    end = matcher2.end();
                                    break;
                                }
                                if (i5 != 0 && i9 > 4) {
                                    if (end <= 0 || ",*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029".indexOf(str.charAt(end - 1)) != -1) {
                                        Matcher region2 = zd0.f29319d.matcher(str).region(end, str.length());
                                        if (region2.lookingAt()) {
                                            matchResult2 = region2.toMatchResult();
                                            if (matchResult2 != null) {
                                                if (str2.equals("et") && matchResult2.group(0).equals("al")) {
                                                    end = matchResult2.end();
                                                    break;
                                                }
                                                Matcher matcher3 = pattern2.matcher(str);
                                                if (matcher3.find(matchResult2.end())) {
                                                    String group = matcher3.group(0);
                                                    int groupCount = matchResult2.groupCount();
                                                    while (true) {
                                                        if (groupCount <= 0) {
                                                            break;
                                                        }
                                                        int i12 = groupCount - 1;
                                                        if (matchResult2.group(groupCount) != null) {
                                                            groupCount = i12;
                                                            break;
                                                        }
                                                        groupCount = i12;
                                                    }
                                                    if (zd0.f29322g.matcher(group).matches()) {
                                                        yd0 yd0Var = zd0.f29316a[groupCount];
                                                        yd0Var.getClass();
                                                        int parseInt = Integer.parseInt(group.substring(0, 2));
                                                        if ((yd0Var.f28906a <= parseInt && parseInt <= yd0Var.f28907b) || parseInt == yd0Var.f28908c || parseInt == yd0Var.f28909d) {
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    i7 = matchResult2.end();
                                                }
                                            }
                                        }
                                    }
                                    matchResult2 = null;
                                    if (matchResult2 != null) {
                                    }
                                }
                            }
                            i2 = 0;
                            z = false;
                        }
                        str2 = matcher2.group(i2);
                        end = matcher2.end();
                    } else {
                        break;
                    }
                }
                i3 = 0;
                if (i7 > 0) {
                    i = i7;
                } else {
                    if (i6 <= 0) {
                        i6 = end;
                    }
                    i = -i6;
                }
                if (i > 0) {
                    return str.substring(start, i);
                }
                i4 = -i;
            } else {
                i4 = matcher.end();
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, g91] */
    /* renamed from: c */
    public static void m890c(ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                if (group != null) {
                    ?? obj = new Object();
                    obj.f17617b = m891d(group, strArr, matcher, null);
                    obj.f17618c = start;
                    obj.f17619d = end;
                    arrayList.add(obj);
                }
            }
        }
    }

    /* renamed from: d */
    public static String m891d(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                String str2 = strArr[i];
                if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                    z = true;
                    if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                        StringBuilder m7064t = AbstractC1726qj.m7064t(str2);
                        m7064t.append(str.substring(str2.length()));
                        str = m7064t.toString();
                    }
                } else {
                    i++;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z && strArr.length > 0) {
            return AbstractC1726qj.m7061q(new StringBuilder(), strArr[0], str);
        }
        return str;
    }

    /* renamed from: e */
    public static boolean m892e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public static boolean addLinks(@NonNull TextView textView, int i) {
        if (m892e()) {
            return Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (addLinks((Spannable) text, i)) {
                m888a(textView);
                return true;
            }
        } else {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (addLinks(valueOf, i)) {
                m888a(textView);
                textView.setText(valueOf);
                return true;
            }
        }
        return false;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (m892e()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (m892e()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (m892e()) {
            f91.m4781a(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            m888a(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (m892e()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (m892e()) {
            return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        String lowerCase;
        if (m892e()) {
            return f91.m4782b(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f3802a;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            String str2 = strArr[i];
            i++;
            if (str2 == null) {
                lowerCase = "";
            } else {
                lowerCase = str2.toLowerCase(Locale.ROOT);
            }
            strArr2[i] = lowerCase;
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) && group != null) {
                spannable.setSpan(new URLSpan(m891d(group, strArr2, matcher, transformFilter)), start, end, 33);
                z = true;
            }
        }
        return z;
    }
}
