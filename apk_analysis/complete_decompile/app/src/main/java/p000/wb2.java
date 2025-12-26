package p000;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Path;
import okio.internal.ResourceFileSystem;

/* loaded from: classes2.dex */
public final class wb2 {
    /* renamed from: a */
    public static final boolean m8019a(wb2 wb2Var, Path path) {
        wb2Var.getClass();
        return !ro2.endsWith(path.name(), ".class", true);
    }

    /* renamed from: b */
    public static Path m8020b(Path path, Path base) {
        Path path2;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String path3 = base.toString();
        path2 = ResourceFileSystem.f24780c;
        return path2.resolve(ro2.replace$default(StringsKt__StringsKt.removePrefix(path.toString(), (CharSequence) path3), '\\', '/', false, 4, (Object) null));
    }
}
