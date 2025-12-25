package p000;

import java.io.File;

/* loaded from: classes2.dex */
public enum ad0 extends cd0 {
    public ad0() {
        super("IS_DIRECTORY", 0);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return ((File) obj).isDirectory();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Files.isDirectory()";
    }
}
