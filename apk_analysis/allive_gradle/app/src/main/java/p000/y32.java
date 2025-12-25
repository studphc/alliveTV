package p000;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class y32 extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ Function3 f28821b;

    /* renamed from: c */
    public final /* synthetic */ Path f28822c;

    /* renamed from: d */
    public final /* synthetic */ Path f28823d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y32(Function3 function3, Path path, Path path2) {
        super(2);
        this.f28821b = function3;
        this.f28822c = path;
        this.f28823d = path2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        FileVisitResult m15a;
        FileVisitResult fileVisitResult;
        Path directory = r32.m7202n(obj);
        IOException iOException = (IOException) obj2;
        Intrinsics.checkNotNullParameter(directory, "directory");
        if (iOException == null) {
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }
        m15a = a42.m15a(this.f28821b, this.f28822c, this.f28823d, directory, iOException);
        return m15a;
    }
}
