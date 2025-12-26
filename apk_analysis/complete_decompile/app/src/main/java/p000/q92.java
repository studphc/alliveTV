package p000;

import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes2.dex */
public final class q92 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final String f25492a;

    /* renamed from: b */
    public final int f25493b;

    static {
        final DefaultConstructorMarker defaultConstructorMarker = null;
        new Object(defaultConstructorMarker) { // from class: kotlin.text.Regex$Serialized$Companion
        };
    }

    public q92(String pattern, int i) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.f25492a = pattern;
        this.f25493b = i;
    }

    private final Object readResolve() {
        Pattern compile = Pattern.compile(this.f25492a, this.f25493b);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(pattern, flags)");
        return new Regex(compile);
    }
}
