package p000;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class rc0 extends wc0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rc0(File rootDir) {
        super(rootDir);
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
    }
}
