package p000;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import kotlin.io.path.CopyActionContext;
import kotlin.io.path.CopyActionResult;
import kotlin.io.path.LinkFollowing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: classes2.dex */
public final class t32 extends Lambda implements Function3 {

    /* renamed from: b */
    public final /* synthetic */ boolean f26683b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t32(boolean z) {
        super(3);
        this.f26683b = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        CopyActionContext copyToRecursively = (CopyActionContext) obj;
        Path src = (Path) obj2;
        Path dst = (Path) obj3;
        Intrinsics.checkNotNullParameter(copyToRecursively, "$this$copyToRecursively");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(this.f26683b);
        boolean isDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !isDirectory) {
            if (isDirectory) {
                a42.deleteRecursively(dst);
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(linkOptions);
            spreadBuilder.add(StandardCopyOption.REPLACE_EXISTING);
            CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.toArray(new CopyOption[spreadBuilder.size()]);
            Intrinsics.checkNotNullExpressionValue(Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(this, target, *options)");
        }
        return CopyActionResult.CONTINUE;
    }
}
