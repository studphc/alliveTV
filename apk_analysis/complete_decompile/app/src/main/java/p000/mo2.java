package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class mo2 extends ko2 {
    @NotNull
    public static final String prependIndent(@NotNull String str, @NotNull String indent) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.map(StringsKt__StringsKt.lineSequence(str), new lo2(indent, 1)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    @NotNull
    public static final String replaceIndent(@NotNull String str, @NotNull String newIndent) {
        int i;
        int i2;
        Function1 lo2Var;
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> lines = StringsKt__StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : lines) {
            if (!ro2.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            int length = str3.length();
            while (true) {
                if (i < length) {
                    if (!AbstractC1326ip.isWhitespace(str3.charAt(i))) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                i = str3.length();
            }
            arrayList2.add(Integer.valueOf(i));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) arrayList2);
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        int size = (lines.size() * newIndent.length()) + str.length();
        if (newIndent.length() == 0) {
            lo2Var = C1223g8.f17587p;
        } else {
            lo2Var = new lo2(newIndent, 0);
        }
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : lines) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == lastIndex) && ro2.isBlank(str4)) {
                str4 = null;
            } else {
                String drop = StringsKt___StringsKt.drop(str4, i2);
                if (drop != null && (str2 = (String) lo2Var.invoke(drop)) != null) {
                    str4 = str2;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i3;
        }
        String sb = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList3, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    @NotNull
    public static final String replaceIndentByMargin(@NotNull String str, @NotNull String newIndent, @NotNull String marginPrefix) {
        Function1 lo2Var;
        int i;
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (!ro2.isBlank(marginPrefix)) {
            List<String> lines = StringsKt__StringsKt.lines(str);
            int size = (lines.size() * newIndent.length()) + str.length();
            if (newIndent.length() == 0) {
                lo2Var = C1223g8.f17587p;
            } else {
                lo2Var = new lo2(newIndent, 0);
            }
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : lines) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj;
                String str4 = null;
                if ((i2 == 0 || i2 == lastIndex) && ro2.isBlank(str3)) {
                    str3 = null;
                } else {
                    int length = str3.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            if (!AbstractC1326ip.isWhitespace(str3.charAt(i4))) {
                                i = i4;
                                break;
                            }
                            i4++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        int i5 = i;
                        if (ro2.startsWith$default(str3, marginPrefix, i, false, 4, null)) {
                            int length2 = marginPrefix.length() + i5;
                            Intrinsics.checkNotNull(str3, "null cannot be cast to non-null type java.lang.String");
                            str4 = str3.substring(length2);
                            Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str4 != null && (str2 = (String) lo2Var.invoke(str4)) != null) {
                        str3 = str2;
                    }
                }
                if (str3 != null) {
                    arrayList.add(str3);
                }
                i2 = i3;
            }
            String sb = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
            Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static String trimIndent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, "");
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimMargin(@NotNull String str, @NotNull String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, "", marginPrefix);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
