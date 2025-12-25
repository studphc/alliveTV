package p000;

import java.io.File;
import kotlin.io.AccessDeniedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class uc0 extends rc0 {

    /* renamed from: b */
    public boolean f27220b;

    /* renamed from: c */
    public File[] f27221c;

    /* renamed from: d */
    public int f27222d;

    /* renamed from: e */
    public final /* synthetic */ vc0 f27223e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc0(vc0 vc0Var, File rootDir) {
        super(rootDir);
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        this.f27223e = vc0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r0 = r2.f27738d.f21116e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        if (r0.length == 0) goto L31;
     */
    @Override // p000.wc0
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File mo7356a() {
        Function1 function1;
        Function2 function2;
        Function1 function12;
        Function1 function13;
        boolean z = this.f27220b;
        vc0 vc0Var = this.f27223e;
        File file = this.f28136a;
        if (!z) {
            function13 = vc0Var.f27738d.f21114c;
            if (function13 != null && !((Boolean) function13.invoke(file)).booleanValue()) {
                return null;
            }
            this.f27220b = true;
            return file;
        }
        File[] fileArr = this.f27221c;
        if (fileArr != null) {
            int i = this.f27222d;
            Intrinsics.checkNotNull(fileArr);
            if (i >= fileArr.length) {
                function12 = vc0Var.f27738d.f21115d;
                if (function12 != null) {
                    function12.invoke(file);
                }
                return null;
            }
        }
        if (this.f27221c == null) {
            File[] listFiles = file.listFiles();
            this.f27221c = listFiles;
            if (listFiles == null && function2 != null) {
                function2.invoke(file, new AccessDeniedException(this.f28136a, null, "Cannot list files in a directory", 2, null));
            }
            File[] fileArr2 = this.f27221c;
            if (fileArr2 != null) {
                Intrinsics.checkNotNull(fileArr2);
            }
            function1 = vc0Var.f27738d.f21115d;
            if (function1 != null) {
                function1.invoke(file);
            }
            return null;
        }
        File[] fileArr3 = this.f27221c;
        Intrinsics.checkNotNull(fileArr3);
        int i2 = this.f27222d;
        this.f27222d = i2 + 1;
        return fileArr3[i2];
    }
}
