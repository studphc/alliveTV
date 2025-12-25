package p000;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: ky */
/* loaded from: classes.dex */
public final class C1491ky implements ParsingLoadable.Parser {
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public final Object parse(Uri uri, InputStream inputStream) {
        return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
    }
}
