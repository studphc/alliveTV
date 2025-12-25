package p000;

import java.io.File;

/* loaded from: classes2.dex */
public enum bd0 extends cd0 {
    public bd0() {
        super("IS_FILE", 1);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return ((File) obj).isFile();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Files.isFile()";
    }
}
