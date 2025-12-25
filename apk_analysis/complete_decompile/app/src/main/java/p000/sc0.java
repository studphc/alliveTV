package p000;

import java.io.File;
import kotlin.io.AccessDeniedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class sc0 extends rc0 {

    /* renamed from: b */
    public boolean f26366b;

    /* renamed from: c */
    public File[] f26367c;

    /* renamed from: d */
    public int f26368d;

    /* renamed from: e */
    public boolean f26369e;

    /* renamed from: f */
    public final /* synthetic */ vc0 f26370f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sc0(vc0 vc0Var, File rootDir) {
        super(rootDir);
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        this.f26370f = vc0Var;
    }

    @Override // p000.wc0
    /* renamed from: a */
    public final File mo7356a() {
        Function1 function1;
        Function1 function12;
        Function2 function2;
        boolean z = this.f26369e;
        vc0 vc0Var = this.f26370f;
        File file = this.f28136a;
        if (!z && this.f26367c == null) {
            function12 = vc0Var.f27738d.f21114c;
            if (function12 != null && !((Boolean) function12.invoke(file)).booleanValue()) {
                return null;
            }
            File[] listFiles = file.listFiles();
            this.f26367c = listFiles;
            if (listFiles == null) {
                function2 = vc0Var.f27738d.f21116e;
                if (function2 != null) {
                    function2.invoke(file, new AccessDeniedException(this.f28136a, null, "Cannot list files in a directory", 2, null));
                }
                this.f26369e = true;
            }
        }
        File[] fileArr = this.f26367c;
        if (fileArr != null) {
            int i = this.f26368d;
            Intrinsics.checkNotNull(fileArr);
            if (i < fileArr.length) {
                File[] fileArr2 = this.f26367c;
                Intrinsics.checkNotNull(fileArr2);
                int i2 = this.f26368d;
                this.f26368d = i2 + 1;
                return fileArr2[i2];
            }
        }
        if (this.f26366b) {
            function1 = vc0Var.f27738d.f21115d;
            if (function1 != null) {
                function1.invoke(file);
            }
            return null;
        }
        this.f26366b = true;
        return file;
    }
}
