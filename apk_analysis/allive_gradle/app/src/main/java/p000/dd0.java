package p000;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.FilePathComponents;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class dd0 {
    /* renamed from: a */
    public static final int m4571a(String str) {
        int indexOf$default;
        char c = File.separatorChar;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, c, 0, false, 4, (Object) null);
        if (indexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, c, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str, c, indexOf$default + 1, false, 4, (Object) null);
            if (indexOf$default3 >= 0) {
                return indexOf$default3 + 1;
            }
            return str.length();
        }
        if (indexOf$default2 > 0 && str.charAt(indexOf$default2 - 1) == ':') {
            return indexOf$default2 + 1;
        }
        if (indexOf$default2 != -1 || !StringsKt__StringsKt.endsWith$default((CharSequence) str, ':', false, 2, (Object) null)) {
            return 0;
        }
        return str.length();
    }

    @NotNull
    public static final File getRoot(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new File(getRootName(file));
    }

    @NotNull
    public static final String getRootName(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        String substring = path.substring(0, m4571a(path2));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean isRooted(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        if (m4571a(path) > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final File subPath(@NotNull File file, int i, int i2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return toComponents(file).subPath(i, i2);
    }

    @NotNull
    public static final FilePathComponents toComponents(@NotNull File file) {
        List list;
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        int m4571a = m4571a(path);
        String substring = path.substring(0, m4571a);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = path.substring(m4571a);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List split$default = StringsKt__StringsKt.split$default((CharSequence) substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
