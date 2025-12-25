package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import p000.ph1;

@Metadata(m5568d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, m5569d2 = {"kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,398:1\n1789#2,3:399\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:399,3\n*E\n"})
/* loaded from: classes2.dex */
public final class RegexKt {
    public static final MatchResult access$findNext(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new ph1(matcher, charSequence);
    }

    public static final MatchResult access$matchEntire(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new ph1(matcher, charSequence);
    }

    public static final int access$toInt(Iterable iterable) {
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= ((RegexOption) it.next()).getValue();
        }
        return i;
    }
}
