package p000;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final /* synthetic */ class x32 extends FunctionReferenceImpl implements Function2 {

    /* renamed from: h */
    public final /* synthetic */ Function3 f28434h;

    /* renamed from: i */
    public final /* synthetic */ Path f28435i;

    /* renamed from: j */
    public final /* synthetic */ Path f28436j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x32(Function3 function3, Path path, Path path2) {
        super(2, Intrinsics.Kotlin.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
        this.f28434h = function3;
        this.f28435i = path;
        this.f28436j = path2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        FileVisitResult m15a;
        Path p0 = r32.m7202n(obj);
        Exception p1 = (Exception) obj2;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        m15a = a42.m15a(this.f28434h, this.f28435i, this.f28436j, p0, p1);
        return m15a;
    }
}
