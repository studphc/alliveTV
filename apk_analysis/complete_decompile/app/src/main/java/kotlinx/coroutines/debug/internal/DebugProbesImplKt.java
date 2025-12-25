package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.text.Typography;
import p000.AbstractC1726qj;

@Metadata(m5568d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, m5569d2 = {"kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DebugProbesImplKt {
    public static final String access$repr(String str) {
        StringBuilder sb = new StringBuilder("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\b') {
                sb.append("\\b");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else {
                sb.append(charAt);
            }
        }
        return AbstractC1726qj.m7060p(sb, Typography.quote, "StringBuilder().apply(builderAction).toString()");
    }
}
