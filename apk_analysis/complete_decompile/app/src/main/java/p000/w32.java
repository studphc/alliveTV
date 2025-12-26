package p000;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final /* synthetic */ class w32 extends FunctionReferenceImpl implements Function2 {

    /* renamed from: h */
    public final /* synthetic */ Function3 f28059h;

    /* renamed from: i */
    public final /* synthetic */ Path f28060i;

    /* renamed from: j */
    public final /* synthetic */ Path f28061j;

    /* renamed from: k */
    public final /* synthetic */ Function3 f28062k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w32(Function3 function3, Path path, Path path2, Function3 function32) {
        super(2, Intrinsics.Kotlin.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
        this.f28059h = function3;
        this.f28060i = path;
        this.f28061j = path2;
        this.f28062k = function32;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Path p0 = r32.m7202n(obj);
        BasicFileAttributes p1 = r32.m7206r(obj2);
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return a42.access$copyToRecursively$copy(this.f28059h, this.f28060i, this.f28061j, this.f28062k, p0, p1);
    }
}
