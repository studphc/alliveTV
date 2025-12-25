package p000;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class t02 {

    /* renamed from: a */
    public static final Logger f26653a = Logger.getLogger("okio.Okio");

    /* renamed from: a */
    public static final Sink m7428a(Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    /* renamed from: b */
    public static final Source m7429b(Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }
}
