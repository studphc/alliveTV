package p000;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult$groupValues$1;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.RegexKt;
import org.jetbrains.annotations.NotNull;
import p000.ph1;

/* loaded from: classes2.dex */
public final class ph1 implements MatchResult {

    /* renamed from: a */
    public final Matcher f25177a;

    /* renamed from: b */
    public final CharSequence f25178b;

    /* renamed from: c */
    public final MatcherMatchResult$groups$1 f25179c;

    /* renamed from: d */
    public MatcherMatchResult$groupValues$1 f25180d;

    public ph1(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.f25177a = matcher;
        this.f25178b = input;
        this.f25179c = new MatcherMatchResult$groups$1(this);
    }

    @Override // kotlin.text.MatchResult
    public final MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.text.MatcherMatchResult$groupValues$1] */
    @Override // kotlin.text.MatchResult
    public final List getGroupValues() {
        if (this.f25180d == null) {
            this.f25180d = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return contains((String) obj);
                    }
                    return false;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                @NotNull
                public String get(int index) {
                    String group = ph1.this.f25177a.group(index);
                    return group == null ? "" : group;
                }

                @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
                /* renamed from: getSize */
                public int getF21007c() {
                    return ph1.this.f25177a.groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return indexOf((String) obj);
                    }
                    return -1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return lastIndexOf((String) obj);
                    }
                    return -1;
                }

                public /* bridge */ boolean contains(String str) {
                    return super.contains((MatcherMatchResult$groupValues$1) str);
                }

                public /* bridge */ int indexOf(String str) {
                    return super.indexOf((MatcherMatchResult$groupValues$1) str);
                }

                public /* bridge */ int lastIndexOf(String str) {
                    return super.lastIndexOf((MatcherMatchResult$groupValues$1) str);
                }
            };
        }
        MatcherMatchResult$groupValues$1 matcherMatchResult$groupValues$1 = this.f25180d;
        Intrinsics.checkNotNull(matcherMatchResult$groupValues$1);
        return matcherMatchResult$groupValues$1;
    }

    @Override // kotlin.text.MatchResult
    public final MatchGroupCollection getGroups() {
        return this.f25179c;
    }

    @Override // kotlin.text.MatchResult
    public final IntRange getRange() {
        IntRange until;
        until = r82.until(r0.start(), this.f25177a.end());
        return until;
    }

    @Override // kotlin.text.MatchResult
    public final String getValue() {
        String group = this.f25177a.group();
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    public final MatchResult next() {
        int i;
        Matcher matcher = this.f25177a;
        int end = matcher.end();
        if (matcher.end() == matcher.start()) {
            i = 1;
        } else {
            i = 0;
        }
        int i2 = end + i;
        CharSequence charSequence = this.f25178b;
        if (i2 <= charSequence.length()) {
            Matcher matcher2 = matcher.pattern().matcher(charSequence);
            Intrinsics.checkNotNullExpressionValue(matcher2, "matcher.pattern().matcher(input)");
            return RegexKt.access$findNext(matcher2, i2, charSequence);
        }
        return null;
    }
}
