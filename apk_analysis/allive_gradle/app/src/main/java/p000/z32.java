package p000;

import java.nio.file.Path;
import kotlin.Unit;
import kotlin.io.path.FileVisitorBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class z32 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ Function3 f29236b;

    /* renamed from: c */
    public final /* synthetic */ Path f29237c;

    /* renamed from: d */
    public final /* synthetic */ Path f29238d;

    /* renamed from: e */
    public final /* synthetic */ Function3 f29239e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z32(Function3 function3, Path path, Path path2, Function3 function32) {
        super(1);
        this.f29236b = function3;
        this.f29237c = path;
        this.f29238d = path2;
        this.f29239e = function32;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        FileVisitorBuilder visitFileTree = (FileVisitorBuilder) obj;
        Intrinsics.checkNotNullParameter(visitFileTree, "$this$visitFileTree");
        Path path = this.f29237c;
        Path path2 = this.f29238d;
        Function3 function3 = this.f29236b;
        Function3 function32 = this.f29239e;
        visitFileTree.onPreVisitDirectory(new v32(function3, path, path2, function32));
        visitFileTree.onVisitFile(new w32(function3, this.f29237c, this.f29238d, function32));
        visitFileTree.onVisitFileFailed(new x32(function32, this.f29237c, this.f29238d));
        visitFileTree.onPostVisitDirectory(new y32(function32, this.f29237c, this.f29238d));
        return Unit.INSTANCE;
    }
}
