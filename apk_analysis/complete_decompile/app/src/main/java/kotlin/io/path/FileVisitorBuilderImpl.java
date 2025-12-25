package kotlin.io.path;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.xc0;

@Metadata(m5568d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u000e\u001a\u00020\r26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0011\u001a\u00020\r26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJG\u0010\u0014\u001a\u00020\r26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJI\u0010\u0015\u001a\u00020\r28\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m5569d2 = {"Lkotlin/io/path/FileVisitorBuilderImpl;", "Lkotlin/io/path/FileVisitorBuilder;", "<init>", "()V", "Lkotlin/Function2;", "Ljava/nio/file/Path;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "directory", "Ljava/nio/file/attribute/BasicFileAttributes;", "attributes", "Ljava/nio/file/FileVisitResult;", "function", "", "onPreVisitDirectory", "(Lkotlin/jvm/functions/Function2;)V", "file", "onVisitFile", "Ljava/io/IOException;", "exception", "onVisitFileFailed", "onPostVisitDirectory", "Ljava/nio/file/FileVisitor;", "build", "()Ljava/nio/file/FileVisitor;", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalPathApi
/* loaded from: classes2.dex */
public final class FileVisitorBuilderImpl implements FileVisitorBuilder {

    /* renamed from: a */
    public Function2 f21140a;

    /* renamed from: b */
    public Function2 f21141b;

    /* renamed from: c */
    public Function2 f21142c;

    /* renamed from: d */
    public Function2 f21143d;

    /* renamed from: e */
    public boolean f21144e;

    /* renamed from: b */
    public static void m5619b(Object obj, String str) {
        if (obj == null) {
        } else {
            throw new IllegalStateException(str.concat(" was already defined"));
        }
    }

    /* renamed from: a */
    public final void m5620a() {
        if (!this.f21144e) {
        } else {
            throw new IllegalStateException("This builder was already built");
        }
    }

    @NotNull
    public final FileVisitor<Path> build() {
        m5620a();
        this.f21144e = true;
        return new xc0(this.f21140a, this.f21141b, this.f21142c, this.f21143d);
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onPostVisitDirectory(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        m5620a();
        m5619b(this.f21143d, "onPostVisitDirectory");
        this.f21143d = function;
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onPreVisitDirectory(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        m5620a();
        m5619b(this.f21140a, "onPreVisitDirectory");
        this.f21140a = function;
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onVisitFile(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        m5620a();
        m5619b(this.f21141b, "onVisitFile");
        this.f21141b = function;
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onVisitFileFailed(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        m5620a();
        m5619b(this.f21142c, "onVisitFileFailed");
        this.f21142c = function;
    }
}
